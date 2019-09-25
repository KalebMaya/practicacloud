package com.everis.practicacloudcomprarest.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Producto implements java.io.Serializable {

	private Integer idproducto;
	private String nombre;
	private int stock;
	private int port;
	private String ip;
	@JsonIgnore
	private Set<Compra> compras = new HashSet<Compra>(0);

	public Producto() {
	}

	public Producto(Integer idproducto, String nombre, int stock, int port, String ip) {
		this.idproducto = idproducto;
		this.nombre = nombre;
		this.stock = stock;
		this.port = port;
		this.ip = ip;
	}

	public Producto(Integer idproducto, String nombre, int stock, int port, String ip, Set<Compra> compras) {
		this.idproducto = idproducto;
		this.nombre = nombre;
		this.stock = stock;
		this.port = port;
		this.ip = ip;
		this.compras = compras;
	}
	public Integer getIdproducto() {
		return this.idproducto;
	}

	public void setIdproducto(Integer idproducto) {
		this.idproducto = idproducto;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getPort() {
		return this.port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Set<Compra> getCompras() {
		return this.compras;
	}

	public void setCompras(Set<Compra> compras) {
		this.compras = compras;
	}

}
