package br.com.viavarejo.entity;

import java.util.Objects;

import org.springframework.data.annotation.Immutable;

@Immutable
public class Product {

	private String code;
	private String name;
	private Double value;
	
	public Product() {}
	
	public Product(String code, String name, Double value) {
		super();
		this.code = code;
		this.name = name;
		this.value = value;
	}

	@Override
	public final boolean equals(final Object other) {
		if (!(other instanceof Product)) {
			return false;
		}
		Product castOther = (Product) other;
		return Objects.equals(code, castOther.code) && Objects.equals(name, castOther.name)
				&& Objects.equals(value, castOther.value);
	}

	@Override
	public final int hashCode() {
		return Objects.hash(code, name, value);
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public Double getValue() {
		return value;
	}	
}
