package com.everis.practicacloudinventariorest.model;
// Generated 25/09/2019 12:57:56 PM by Hibernate Tools 5.2.12.Final

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Compra generated by hbm2java
 */
@Entity
@Table(name = "compra", catalog = "inventario")
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

	@Id
	@GeneratedValue(strategy = IDENTITY)
	
	@Column(name = "idcompra", unique = true, nullable = false)
	public Integer getIdcompra() {
		return this.idcompra;
	}

	public void setIdcompra(Integer idcompra) {
		this.idcompra = idcompra;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "producto_idproducto", nullable = false)
	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechahora", nullable = false, length = 19)
	public Date getFechahora() {
		return this.fechahora;
	}

	public void setFechahora(Date fechahora) {
		this.fechahora = fechahora;
	}

	@Column(name = "cantidad", nullable = false)
	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
