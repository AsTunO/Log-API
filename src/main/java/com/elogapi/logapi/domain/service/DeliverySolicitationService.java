package com.elogapi.logapi.domain.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elogapi.logapi.domain.exception.BusinessException;
import com.elogapi.logapi.domain.model.Client;
import com.elogapi.logapi.domain.model.Delivery;
import com.elogapi.logapi.domain.model.DeliveryStatus;
import com.elogapi.logapi.domain.repository.ClientRepository;
import com.elogapi.logapi.domain.repository.DeliveryRepository;

@Service
public class DeliverySolicitationService 
{
	private CRUDClientService crudClientService;
	private DeliveryRepository deliveryRepository;

	
	@Transactional
	public Delivery request(Delivery delivery)
	{
		
		Client client = crudClientService.search(delivery.getClient().getId());
		
		
		delivery.setClient(client);
		delivery.setStatus(DeliveryStatus.PENDING);
		delivery.setDateSolicitation(LocalDateTime.now());
		
		
		return deliveryRepository.save(delivery);
	}


// Boilerplate Code
	
	public DeliverySolicitationService(CRUDClientService crudClientService, DeliveryRepository deliveryRepository) 
	{
		super();
		this.crudClientService = crudClientService;
		this.deliveryRepository = deliveryRepository;
	}
	
	
	
	
	
	

	
	
	
}
