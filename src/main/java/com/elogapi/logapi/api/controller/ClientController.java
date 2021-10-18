package com.elogapi.logapi.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import com.elogapi.logapi.domain.model.Client;

@RestController
public class ClientController 
{
	@GetMapping("/client")
	public List<Client> list()
	{
		Client cli1 = new Client();
		cli1.setId(1L);
		cli1.setName("Júlio Cesar");
		cli1.setEmail("juliocesar27072004@outlook.com");
		cli1.setTelephone("(81) 99239-0357");
		
		var cli2 = new Client();
		cli2.setId(2L);
		cli2.setName("Bianca Alves");
		cli2.setEmail("biacaalves@outlook.com");
		cli2.setTelephone("(81) 99532-1337");
		
		
		
		return Arrays.asList(cli1,cli2);
	}
}