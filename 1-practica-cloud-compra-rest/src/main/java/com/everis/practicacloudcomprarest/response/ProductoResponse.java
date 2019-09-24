package com.everis.practicacloudcomprarest.response;

import java.math.BigDecimal;

import com.everis.practicacloudcomprarest.model.Producto;

public class ProductoResponse {

private boolean successful;
private String message;
private Producto value;


public boolean isSuccessful() {
	return successful;
}
public void setSuccessful(boolean successful) {
	this.successful = successful;
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
