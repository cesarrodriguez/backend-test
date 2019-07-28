package br.com.viavarejo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.viavarejo.client.JSONPlaceHolderClient;
import br.com.viavarejo.entity.Installments;
import br.com.viavarejo.entity.PaymentRules;
import br.com.viavarejo.entity.Product;
import br.com.viavarejo.entity.SelicRate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InstallmentServiceTest {

	@MockBean
	private JSONPlaceHolderClient client;

	@Autowired
	private InstallmentService installmentService;

	@Test
	public void getSelicRateLast30Days_thenReturnSelicAmountLast30Days() throws Exception {

		SelicRate selicRate1 = new SelicRate(new Date(), 0.5);
		SelicRate selicRate2 = new SelicRate(new Date(), 0.23);
		List<SelicRate> selicRates = new ArrayList<>();
		selicRates.add(selicRate1);
		selicRates.add(selicRate2);

		given(this.client.getSelictRateLast30Days()).willReturn(selicRates);

		assertThat(installmentService.getSelicRateLast30Days()).isEqualTo(BigDecimal.valueOf(0.73));
	}
	
	

	@Test
	public void getInstallment_thenReturnInstallmentWithoutInterest() throws Exception {

		SelicRate selicRate1 = new SelicRate(new Date(), 0.5);
		SelicRate selicRate2 = new SelicRate(new Date(), 0.23);
		List<SelicRate> selicRates = new ArrayList<>();
		selicRates.add(selicRate1);
		selicRates.add(selicRate2);

		given(this.client.getSelictRateLast30Days()).willReturn(selicRates);

		Installments installments = new Installments();
		installments.setPaymentRules(new PaymentRules(0.0, 6));
		installments.setProduct(new Product("0", "Product", 600.0));
		
		assertThat(installmentService.getInstallments(installments)).isNotNull();

		installmentService.getInstallments(installments).stream()
				.forEach(i -> assertThat(i.getInterest()).isEqualTo(BigDecimal.ZERO));
	}
	
	@Test
	public void getInstallment_thenReturnInstallmentWithInterest() throws Exception {

		SelicRate selicRate1 = new SelicRate(new Date(), 0.5);
		SelicRate selicRate2 = new SelicRate(new Date(), 0.23);
		List<SelicRate> selicRates = new ArrayList<>();
		selicRates.add(selicRate1);
		selicRates.add(selicRate2);

		given(this.client.getSelictRateLast30Days()).willReturn(selicRates);
		
		Installments installments = new Installments();
		installments.setPaymentRules(new PaymentRules(0.0, 7));
		installments.setProduct(new Product("0", "Product", 600.0));

		assertThat(installmentService.getInstallments(installments)).isNotNull();

		installmentService.getInstallments(installments).stream()
				.forEach(i -> assertThat(i.getInterest()).isEqualTo(BigDecimal.valueOf(0.73)));
	}

}
