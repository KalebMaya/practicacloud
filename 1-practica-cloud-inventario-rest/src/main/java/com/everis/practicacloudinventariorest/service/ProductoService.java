package com.everis.practicacloudinventariorest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.practicacloudinventariorest.model.Producto;
import com.everis.practicacloudinventariorest.repository.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired
	ProductoRepository productoRepositorio;
	
	public Producto findById(int id) {
		return productoRepositorio.findById(id).get();
	}
	
	public Producto actualizaStock(int id, int cantidad) {
		Producto producto = productoRepositorio.findById(id).get();
		if (producto == null) {
			return null;
		}
		if(producto.getStock()-cantidad < 0 ) {
			return null;
		} else {
			producto.setStock(producto.getStock()-cantidad);
			return productoRepositorio.save(producto);
		}
		
	}
}
