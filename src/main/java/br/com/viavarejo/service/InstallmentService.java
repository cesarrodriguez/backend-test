package br.com.viavarejo.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viavarejo.client.JSONPlaceHolderClient;
import br.com.viavarejo.entity.Installment;
import br.com.viavarejo.entity.Installments;
import br.com.viavarejo.util.CalcUtils;

@Service
public class InstallmentService {

	@Autowired
	private JSONPlaceHolderClient client;

	public List<Installment> getInstallments(Installments installments) {
		if(installments.getProduct().getValue() < installments.getPaymentRules().getInitValue()) {
			throw new IllegalArgumentException("Valor de entrada é maior que o valor do produto");
		}
		Double diff = installments.getProduct().getValue() - installments.getPaymentRules().getInitValue();

		List<Installment> list = new ArrayList<>();
		if (installments.getPaymentRules().getQttInstallments() < 7) {
			for (int i = 0; i < installments.getPaymentRules().getQttInstallments(); i++) {
				list.add(Installment.builder().invoice(i+1)
						.value(BigDecimal.valueOf(diff).divide(BigDecimal.valueOf(installments.getPaymentRules().getQttInstallments()), 2, RoundingMode.HALF_DOWN))
						.interest(BigDecimal.ZERO).build());
			}
		} else {
			Double total = CalcUtils.calculateInterest(getSelicRateLast30Days().doubleValue(), installments.getPaymentRules().getQttInstallments(), diff);
			for (int i = 0; i < installments.getPaymentRules().getQttInstallments(); i++) {
				list.add(Installment.builder().invoice(i+1)
						.value(BigDecimal.valueOf(total).divide(BigDecimal.valueOf(installments.getPaymentRules().getQttInstallments()), 2, RoundingMode.HALF_DOWN))
						.interest(getSelicRateLast30Days()).build());
			}
		}
		return list;
	}

	public BigDecimal getSelicRateLast30Days() {
		return client.getSelictRateLast30Days().stream().map(s -> BigDecimal.valueOf(s.getValor()))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}
}
