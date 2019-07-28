package br.com.viavarejo.entity;

import java.util.Objects;

import org.springframework.data.annotation.Immutable;

@Immutable
public class PaymentRules {

	private Double initValue;
	private Integer qttInstallments;

	@Override
	public final boolean equals(final Object other) {
		if (!(other instanceof PaymentRules)) {
			return false;
		}
		PaymentRules castOther = (PaymentRules) other;
		return Objects.equals(initValue, castOther.initValue)
				&& Objects.equals(qttInstallments, castOther.qttInstallments);
	}

	@Override
	public final int hashCode() {
		return Objects.hash(initValue, qttInstallments);
	}

	public PaymentRules() {
		super();
	}

	public PaymentRules(Double initValue, Integer qttInstallments) {
		super();
		this.initValue = initValue;
		this.qttInstallments = qttInstallments;
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
}
