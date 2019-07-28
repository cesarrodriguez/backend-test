package br.com.viavarejo.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.viavarejo.entity.Installment;
import br.com.viavarejo.entity.Installments;
import br.com.viavarejo.parambody.PaymentRules;
import br.com.viavarejo.parambody.Product;
import br.com.viavarejo.service.InstallmentService;

@RunWith(SpringRunner.class)
@WebMvcTest(InstallmentController.class)
public class InstallmentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private InstallmentService service;

	@Test
	public void getInstallments_thenReturnStatusOk() throws Exception {
		Installments installments = new Installments();
		Product product = new Product("1", "Via Varejo's new product", 0.0);
		PaymentRules paymentRules = new PaymentRules(100.0, 10);
		 installments.setPaymentRules(paymentRules);
		 installments.setProduct(product);
		
		this.mockMvc
				.perform(get("/installment/installments").contentType(MediaType.APPLICATION_JSON)
						.content(installments.toJson()))
				.andDo(print()).andExpect(status().isOk());

	}

	@Test
	public void getInstallments_thenReturnStatusOkAndTotalId() throws Exception {
		Installments installments = new Installments();
		Product product = new Product("1", "Via Varejo's new product", 0.0);
		
		PaymentRules paymentRules = new PaymentRules(100.0, 10);
		
		 installments.setPaymentRules(paymentRules);
		 installments.setProduct(product);
		 installments.setTotal(BigDecimal.ONE);

		given(service.getInstallments(product.getCode(), product.getName(), product.getValue())).willReturn(installments);

		// when + then
		this.mockMvc
				.perform(get("/installment/installments").contentType(MediaType.APPLICATION_JSON)
						.content(installments.toJson()))
				.andExpect(status().isOk()).andDo(print())
				.andExpect(jsonPath("$.total", is(1)));

	}
}