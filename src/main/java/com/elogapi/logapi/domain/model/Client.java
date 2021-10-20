package com.elogapi.logapi.domain.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "logclient")
public class Client 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "clientid")
	private Long id;
	
	@Column(name = "clientname")
	private String name;
	
	@Column(name = "clientemail")
	private String email;
	
	@Column(name = "clienttelephone")
	private String telephone;
	
	
	
	
	
	
	
	
	
	
	

// Boilerplate code	
	@Override
	public int hashCode() 
	{
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(id, other.id);
	}
	public Long getId() 
	{
		return id;
	}
	public void setId(Long id) 
	{
		this.id = id;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public String getTelephone() 
	{
		return telephone;
	}
	public void setTelephone(String telephone) 
	{
		this.telephone = telephone;
	}
	
	
}