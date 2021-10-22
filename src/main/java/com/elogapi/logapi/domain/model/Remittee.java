package com.elogapi.logapi.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Remittee 
{
	@Column(name = "remittee_name")
	private String name;
	
	@Column(name = "remittee_public_palce")
	private String publicPlace;
	
	@Column(name = "remittee_number")
	private String number;
	
	@Column(name = "remittee_complement")
	private String complement;
	
	@Column(name = "remittee_district")
	private String district;
	
	
	
	
	
// Boilerplate code	
	
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getPublicPlace() 
	{
		return publicPlace;
	}
	public void setPublicPlace(String publicPlace) 
	{
		this.publicPlace = publicPlace;
	}
	public String getNumber() 
	{
		return number;
	}
	public void setNumber(String number) 
	{
		this.number = number;
	}
	public String getComplement() 
	{
		return complement;
	}
	public void setComplement(String complement) 
	{
		this.complement = complement;
	}
	public String getDistrict() 
	{
		return district;
	}
	public void setDistrict(String district) 
	{
		this.district = district;
	}
	
	
}
