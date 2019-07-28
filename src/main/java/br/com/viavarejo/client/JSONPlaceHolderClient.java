package br.com.viavarejo.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.viavarejo.entity.SelicRate;
import feign.Headers;

@FeignClient(value = "jplaceholder", url = "https://api.bcb.gov.br")
public interface JSONPlaceHolderClient {
	@GetMapping("/dados/serie/bcdata.sgs.11/dados/ultimos/30?formato=json")
	@Headers("Content-Type: application/json")
	List<SelicRate> getSelictRateLast30Days();

}
