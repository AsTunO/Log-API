package com.elogapi.logapi.api.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.elogapi.logapi.domain.model.Delivery;
import com.elogapi.logapi.domain.service.DeliverySolicitationService;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController 
{
	private DeliverySolicitationService deliverySolicitationService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Delivery request(@Valid @RequestBody Delivery delivery)
	{
		return deliverySolicitationService.request(delivery);
	}


// Boilerplate Code
	
	public DeliveryController(DeliverySolicitationService deliverySolicitationService) 
	{
		super();
		this.deliverySolicitationService = deliverySolicitationService;
	}
	
	
}
