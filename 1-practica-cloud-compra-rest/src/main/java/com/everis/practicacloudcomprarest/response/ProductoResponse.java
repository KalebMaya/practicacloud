package com.everis.practicacloudcomprarest.response;

import com.everis.practicacloudcomprarest.model.Compra;
import com.everis.practicacloudcomprarest.model.Producto;

public class ProductoResponse {

	private boolean succesful;
	private String message;
	private Producto value;
	private Compra compra;
	
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
	public Compra getCompra() {
		return compra;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}

}
