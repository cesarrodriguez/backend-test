package br.com.viavarejo.entity;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.viavarejo.parambody.PaymentRules;
import br.com.viavarejo.parambody.Product;

public class Installments {

	private PaymentRules paymentRules;
	private Product product;
	private BigDecimal total;

//	private List<Installment> installments;

	public Installments(PaymentRules paymentRules, Product product, BigDecimal total) {
		super();
		this.paymentRules = paymentRules;
		this.product = product;
		this.total = total;
	}

	public Installments() {

	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

//	public List<Installment> getInstallments() {
//		return installments;
//	}
//
//	public void setInstallments(List<Installment> installments) {
//		this.installments = installments;
//	}

	public PaymentRules getPaymentRules() {
		return paymentRules;
	}

	public void setPaymentRules(PaymentRules paymentRules) {
		this.paymentRules = paymentRules;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String toJson() throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(this);
	}
}
