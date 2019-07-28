package br.com.viavarejo.parambody;

import java.util.Objects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PaymentRules {

	private Double initValue;
	private Integer qttInstallments;

	public PaymentRules() {
		super();
	}

	public PaymentRules(Double initValue, Integer qttInstallments) {
		super();
		this.initValue = initValue;
		this.qttInstallments = qttInstallments;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof PaymentRules)) {
			return false;
		}
		PaymentRules castOther = (PaymentRules) other;
		return Objects.equals(initValue, castOther.initValue)
				&& Objects.equals(qttInstallments, castOther.qttInstallments);
	}

	@Override
	public int hashCode() {
		return Objects.hash(initValue, qttInstallments);
	}

	public Double getInitValue() {
		return initValue;
	}

	public void setInitValue(Double initValue) {
		this.initValue = initValue;
	}

	public Integer getQttInstallments() {
		return qttInstallments;
	}

	public void setQttInstallments(Integer qttInstallments) {
		this.qttInstallments = qttInstallments;
	}

	public String toJson() throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(this);
	}

}
