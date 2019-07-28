package br.com.viavarejo.entity;

import java.math.BigDecimal;
import java.util.Objects;

import org.springframework.data.annotation.Immutable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Immutable
@Builder(access = AccessLevel.PUBLIC)
@Getter
@JsonDeserialize
public class Installment {

	private Integer invoice;
	private BigDecimal value;
	private BigDecimal interest;

	@Override
	public final boolean equals(final Object other) {
		if (!(other instanceof Installment)) {
			return false;
		}
		Installment castOther = (Installment) other;
		return Objects.equals(invoice, castOther.invoice) && Objects.equals(value, castOther.value)
				&& Objects.equals(interest, castOther.interest);
	}

	@Override
	public final int hashCode() {
		return Objects.hash(invoice, value, interest);
	}
}
