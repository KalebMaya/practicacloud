package com.everis.practicacloudinventariorest.response;

import com.everis.practicacloudinventariorest.model.Producto;

public class ProductoValueResponse {
	
	private boolean succesful;
	private String message;
	private Producto value;
	
	public boolean isSuccesful() {
		return succesful;
	}
	public void setSuccesful(boolean succesful) {
		this.succesful = succesful;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Producto getValue() {
		return value;
	}
	public void setValue(Producto value) {
		this.value = value;
	}

}
