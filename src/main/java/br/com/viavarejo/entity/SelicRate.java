package br.com.viavarejo.entity;

import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Immutable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.com.viavarejo.config.CustomerDateAndTimeDeserialize;

@Immutable
public class SelicRate {

	@JsonDeserialize(using = CustomerDateAndTimeDeserialize.class)
	private Date data;
	private Double valor;

	@Override
	public final boolean equals(final Object other) {
		if (!(other instanceof SelicRate)) {
			return false;
		}
		SelicRate castOther = (SelicRate) other;
		return Objects.equals(data, castOther.data) && Objects.equals(valor, castOther.valor);
	}

	@Override
	public final int hashCode() {
		return Objects.hash(data, valor);
	}
	
	public SelicRate() {
		super();
	}

	public SelicRate(Date data, Double valor) {
		super();
		this.data = data;
		this.valor = valor;
	}
	
	public Double getValor() {
		return valor;
	}

}