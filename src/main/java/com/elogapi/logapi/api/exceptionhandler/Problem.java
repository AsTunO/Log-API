package com.elogapi.logapi.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Problem 
{
	private Integer status;
	private LocalDateTime dateHour;
	private String title;
	private List<Field> fields;
	
	public static class Field
	{
			
		private String nome;
		private String mensagem;
		
		
	// Boilerplate code	
		
		public String getNome() 
		{
			return nome;
		}
		public void setNome(String nome) 
		{
			this.nome = nome;
		}
		public String getMensagem() 
		{
			return mensagem;
		}
		public void setMensagem(String mensagem) 
		{
			this.mensagem = mensagem;
		}
		public Field(String nome, String mensagem) 
		{
			super();
			this.nome = nome;
			this.mensagem = mensagem;
		}
			
	}

// Boilerplate code	

	public Integer getStatus() 
	{
		return status;
	}

	public void setStatus(Integer status) 
	{
		this.status = status;
	}

	public LocalDateTime getDateHour() 
	{
		return dateHour;
	}

	public void setDateHour(LocalDateTime dateHour) 
	{
		this.dateHour = dateHour;
	}

	public String getTitle() 
	{
		return title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}

	public List<Field> getFields() 
	{
		return fields;
	}

	public void setFields(List<Field> fields) 
	{
		this.fields = fields;
	}
}