package br.com.viavarejo.parambody;

import java.util.Objects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Product {

	private String code;
	private String name;
	private Double value;

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Product)) {
			return false;
		}
		Product castOther = (Product) other;
		return Objects.equals(code, castOther.code) && Objects.equals(name, castOther.name)
				&& Objects.equals(value, castOther.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, name, value);
	}

	public Product() {
		super();
	}

	public Product(String code, String name, Double value) {
		super();
		this.code = code;
		this.name = name;
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String toJson() throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(this);
	}
}
