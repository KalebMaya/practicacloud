package com.everis.practicacloudinventariorest.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.everis.practicacloudinventariorest.model.Producto;
import com.everis.practicacloudinventariorest.response.ProductoValueResponse;
import com.everis.practicacloudinventariorest.service.ProductoService;

@RestController
public class ProductoController {
	
	@Autowired
	private ProductoService productoServicio;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/consultarInventario/nombre/{nombre}")
	public ProductoValueResponse retrieveProducto(@PathVariable String nombre) {
		ProductoValueResponse response = new ProductoValueResponse();
		try {
			Producto valor = productoServicio.findByNombre(nombre);
			if(valor == null) {
				response.setMessage("Producto no encontrado");
				response.setSuccesful(false);
				return response;
			}
			valor.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
			response.setSuccesful(true);
			response.setMessage("Producto recuperado exitosamente");
			response.setValue(valor);
			return response;
		} catch (Exception e) {
			response.setSuccesful(false);
			response.setMessage(e.getMessage());
			return response;
		}
	}

}
