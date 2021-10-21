package com.elogapi.logapi.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.elogapi.logapi.domain.model.Client;
import com.elogapi.logapi.domain.repository.ClientRepository;
import com.elogapi.logapi.domain.service.CRUDClientService;

@RestController
@RequestMapping("/clients")
public class ClientController 
{

	private ClientRepository clientRepository;
	private CRUDClientService crudClientService; 
	

	public ClientController(ClientRepository clientRepository, CRUDClientService crudClientService) {
		super();
		this.clientRepository = clientRepository;
		this.crudClientService = crudClientService;
	}

	@GetMapping
	public List<Client> list()
	{
		return clientRepository.findAll();
	}
	
	@GetMapping("/{clientId}")
	public ResponseEntity<Client> search(@PathVariable Long clientId)
	{
		return clientRepository.findById(clientId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Client add(@Valid @RequestBody Client client) 
	{
		return crudClientService.save(client);
	}
	
	@PutMapping("/{clientId}")
	public ResponseEntity<Client> Update(@PathVariable Long clientId, @Valid @RequestBody Client client)
	{
		if(!clientRepository.existsById(clientId)) {
			return ResponseEntity.notFound().build();
		}
		
		client.setId(clientId);
		client = crudClientService.save(client);
		
		return ResponseEntity.ok(client);
	}
	
	@DeleteMapping("/{clientId}")
	public ResponseEntity<Void> Delete(@PathVariable Long clientId)
	{
		if(!clientRepository.existsById(clientId)) {
			return ResponseEntity.notFound().build();
		}
		
		crudClientService.delete(clientId);
		
		return ResponseEntity.noContent().build();
		
	}
	
	
}