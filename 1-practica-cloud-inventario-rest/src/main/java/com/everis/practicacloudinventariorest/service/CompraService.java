package com.everis.practicacloudinventariorest.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.practicacloudinventariorest.model.Compra;
import com.everis.practicacloudinventariorest.model.Producto;
import com.everis.practicacloudinventariorest.repository.CompraRepository;
import com.everis.practicacloudinventariorest.repository.ProductoRepository;

@Service
public class CompraService {

		@Autowired
		private CompraRepository compraRepository;
		
		@Autowired
		ProductoRepository productoRepositorio;
		
		public Compra insertar(int idProducto, int cantidad){
			Producto producto = productoRepositorio.findById(idProducto).get();
			Compra compra = new Compra();
			compra.setCantidad(cantidad);
			compra.setProducto(producto);
			compra.setFechahora(new Date());
			return compraRepository.save(compra);
		}
		
		
}
