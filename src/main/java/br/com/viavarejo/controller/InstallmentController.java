package br.com.viavarejo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.viavarejo.entity.Installments;
import br.com.viavarejo.service.InstallmentService;

@RestController
@RequestMapping("/installment")
public class InstallmentController {
	
	@Autowired
	private InstallmentService service;

	@GetMapping("/installments")
    public ResponseEntity<Installments> getInstallments(@RequestBody Installments installments) {
    	 installments = service.getInstallments(installments.getProduct().getCode(), installments.getProduct().getName(), installments.getProduct().getValue());
        return ResponseEntity.ok().body(installments);
    }
    
}