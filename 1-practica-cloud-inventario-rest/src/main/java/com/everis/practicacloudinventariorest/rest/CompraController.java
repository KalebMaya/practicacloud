package com.everis.practicacloudinventariorest.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.practicacloudinventariorest.model.Compra;
import com.everis.practicacloudinventariorest.service.CompraService;

@RestController
public class CompraController {

		@Autowired
		private CompraService compraService;
		
		@PostMapping("/insertarCompra/idProducto/{idProducto}/cantidad/{cantidad}")
		public Compra insertarCompra(@PathVariable int idProducto, @PathVariable int cantidad) {
			return compraService.insertar(idProducto, cantidad);
		}
}
