package com.everis.practicacloudcomprarest.response;

import com.everis.practicacloudcomprarest.model.Producto;

public class ProductoResponse {

private boolean successful;
private String message;
private Producto value;
private String ip;

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
public String getIp() {
	return ip;
}
public void setIp(String ip) {
	this.ip = ip;
}

}
