package com.josesmar.workshopmongodb.dto;

import java.io.Serializable;
import java.util.Date;

public class ComentDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String text;
	private Date date;
	private AuthorDto authorDto;

	
	public ComentDto() {
		
	}


	public ComentDto(String text, Date date, AuthorDto authorDto) {
		super();
		this.text = text;
		this.date = date;
		this.authorDto = authorDto;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public AuthorDto getAuthorDto() {
		return authorDto;
	}


	public void setAuthorDto(AuthorDto authorDto) {
		this.authorDto = authorDto;
	}
	
	
}
