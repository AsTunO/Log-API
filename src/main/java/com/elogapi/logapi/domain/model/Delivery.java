package com.elogapi.logapi.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;

import com.elogapi.logapi.domain.ValidationGroups;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

@Entity
public class Delivery 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Valid
	@ConvertGroup(from = Default.class, to = ValidationGroups.ClientId.class)
	@NotNull
	@ManyToOne
	@JoinColumn(name = "delivery_client_id")
	private Client client;
	
	@Embedded
	private Remittee remitte;
	
	@NotNull
	private BigDecimal tax;
	
	@JsonProperty(access = Access.READ_ONLY)
	@Enumerated(EnumType.STRING)
	private DeliveryStatus status;
	
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime dateSolicitation;
	
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime dateCompletion;
	
	
	
// Boilerplate code

	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Client getClient() 
	{
		return client;
	}

	public void setClient(Client client) 
	{
		this.client = client;
	}

	public Remittee getRemitte() 
	{
		return remitte;
	}

	public void setRemitte(Remittee remitte) 
	{
		this.remitte = remitte;
	}

	public BigDecimal getTax() 
	{
		return tax;
	}

	public void setTax(BigDecimal tax) 
	{
		this.tax = tax;
	}

	public DeliveryStatus getStatus() 
	{
		return status;
	}

	public void setStatus(DeliveryStatus status) 
	{
		this.status = status;
	}

	public LocalDateTime getDateSolicitation() 
	{
		return dateSolicitation;
	}

	public void setDateSolicitation(LocalDateTime dateSolicitation) 
	{
		this.dateSolicitation = dateSolicitation;
	}

	public LocalDateTime getDateCompletion() 
	{
		return dateCompletion;
	}

	public void setDateCompletion(LocalDateTime dateCompletion) 
	{
		this.dateCompletion = dateCompletion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Delivery other = (Delivery) obj;
		return Objects.equals(id, other.id);
	}

	
	
}