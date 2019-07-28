package br.com.viavarejo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.viavarejo.entity.Installment;
import br.com.viavarejo.entity.Installments;
import br.com.viavarejo.service.InstallmentService;

@RestController
@RequestMapping("/installment")
public class InstallmentController {
	
	@Autowired
	private InstallmentService service;

	@PostMapping("/installments")
    public ResponseEntity<List<Installment>> getInstallments(@RequestBody Installments installments) {
    	 List<Installment> list = service.getInstallments(installments);
        return ResponseEntity.ok().body(list);
    }
    
}