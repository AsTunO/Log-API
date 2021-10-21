package com.elogapi.logapi.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elogapi.logapi.domain.exception.BusinessException;
import com.elogapi.logapi.domain.model.Client;
import com.elogapi.logapi.domain.repository.ClientRepository;

@Service
public class CRUDClientService 
{
	private ClientRepository clientRepository;

	@Transactional
	public Client save(Client client)
	{
		
		boolean usingEmail = clientRepository.findByEmail(client.getEmail())
				.stream()
				.anyMatch(clientExisting -> !clientExisting.equals(client));
		
		if(usingEmail) {
			throw new BusinessException("There is a client using this e-mail.");
		}
		
		return clientRepository.save(client);
	}
	
	@Transactional
	public void delete(Long clientId)
	{
		clientRepository.deleteById(clientId);
	}
	
// Boilerplate code	
	
	public CRUDClientService(ClientRepository clientRepository) 
	{
		super();
		this.clientRepository = clientRepository;
	}
	
	
}