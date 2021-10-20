package com.elogapi.logapi.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.elogapi.logapi.domain.model.Client;
import com.elogapi.logapi.domain.repository.ClientRepository;

@RestController
public class ClientController 
{

	private ClientRepository clientRepository;
	
	
	public ClientController(ClientRepository clientRepository) {
		super();
		this.clientRepository = clientRepository;
	}



	@GetMapping("/clients")
	public List<Client> list()
	{
		return clientRepository.findAll();
	}
	
	@GetMapping("/clients/{clientId}")
	public ResponseEntity<Client> search(@PathVariable Long clientId)
	{
		Optional<Client> client =  clientRepository.findById(clientId);
		
		if(client.isPresent()) {
			return ResponseEntity.ok(client.get());
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	
	
	
	
	
	
}