package br.com.viavarejo.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import nl.jqno.equalsverifier.EqualsVerifier;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentRulesTest {

	@Test
	public void equalsContract() {
		EqualsVerifier.forClass(PaymentRules.class).verify();
	}
}
