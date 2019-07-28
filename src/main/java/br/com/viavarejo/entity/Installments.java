package br.com.viavarejo.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Objects;

import org.springframework.data.annotation.Immutable;

@Immutable
public class Installments {

	private PaymentRules paymentRules;
	private Product product;
	private BigDecimal total;

	@Override
	public final boolean equals(final Object other) {
		if (!(other instanceof Installments)) {
			return false;
		}
		Installments castOther = (Installments) other;
		return Objects.equals(paymentRules, castOther.paymentRules) && Objects.equals(product, castOther.product)
				&& Objects.equals(total, castOther.total);
	}

	@Override
	public final int hashCode() {
		return Objects.hash(paymentRules, product, total);
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

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
