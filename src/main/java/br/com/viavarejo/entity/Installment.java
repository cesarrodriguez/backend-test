package br.com.viavarejo.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
@Builder(access = AccessLevel.PUBLIC)
@Getter
@EqualsAndHashCode
@JsonDeserialize
public class Installment {

	private Integer installment;
	private BigDecimal value;
	private BigDecimal interest;
	
	public String toJson() throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(this);
	}
}
