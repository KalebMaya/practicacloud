package com.everis.practicacloudinventariorest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.practicacloudinventariorest.model.Producto;
import com.everis.practicacloudinventariorest.repository.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired
	ProductoRepository productoRepositorio;
	
	public Producto findById(Long id) {
		return productoRepositorio.findById(id).get();
	}
	

}
