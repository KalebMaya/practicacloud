package com.everis.practicacloudcomprarest.model;
// Generated 25/09/2019 12:57:56 PM by Hibernate Tools 5.2.12.Final

import java.util.Date;

public class Compra implements java.io.Serializable {

	private Integer idcompra;
	private Producto producto;
	private Date fechahora;
	private int cantidad;

	public Compra() {
	}

	public Compra(Integer idcompra, Producto producto, Date fechahora, int cantidad) {
		this.idcompra = idcompra;
		this.producto = producto;
		this.fechahora = fechahora;
		this.cantidad = cantidad;
	}

	public Integer getIdcompra() {
		return this.idcompra;
	}

	public void setIdcompra(Integer idcompra) {
		this.idcompra = idcompra;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Date getFechahora() {
		return this.fechahora;
	}

	public void setFechahora(Date fechahora) {
		this.fechahora = fechahora;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
