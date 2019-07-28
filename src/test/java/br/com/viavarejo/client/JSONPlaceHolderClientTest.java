package br.com.viavarejo.client;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JSONPlaceHolderClientTest {

	@Autowired
	private JSONPlaceHolderClient client;

	@Test
	public void getJSONPlaceHolderClient_thenReturnStatusOk() throws Exception {
		assertThat(client.getSelictRateLast30Days()).isNotNull();
		assertThat(client.getSelictRateLast30Days()).isNotEmpty();
		client.getSelictRateLast30Days().stream().forEach(s -> assertThat(s.getValor()).isNotNull());
		client.getSelictRateLast30Days().stream().forEach(s -> assertThat(s.getValor()).isEqualTo(0.024620));
		assertThat(client.getSelictRateLast30Days().stream().map(s -> BigDecimal.valueOf(s.getValor()))
				.reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue()).isEqualTo(0.7386);
	}

}
