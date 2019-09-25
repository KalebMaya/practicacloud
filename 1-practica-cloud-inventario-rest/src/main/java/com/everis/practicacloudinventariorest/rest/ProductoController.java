package com.everis.practicacloudinventariorest.rest;

import java.net.InetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/consultarInventario/id/{id}")
	public ProductoValueResponse retrieveProducto(@PathVariable Integer id) {
		ProductoValueResponse response = new ProductoValueResponse();
		try {
			Producto valor = productoServicio.findById(id);
			if(valor == null) {
				response.setMessage("Producto no encontrado");
				response.setSuccesful(false);
				return response;
			}
			valor.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
			valor.setIp(InetAddress.getLocalHost().getHostAddress());
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
	
	@PutMapping("/modificarInventario/id/{id}/cantidad/{cantidad}")
	public ProductoValueResponse actualizarStock(@PathVariable Integer id, @PathVariable int cantidad) {
		ProductoValueResponse response = new ProductoValueResponse();
		try {
			Producto valor = productoServicio.actualizaStock(id, cantidad);
			if(valor == null) {
				response.setMessage("No se pudo actualizar el producto");
				response.setSuccesful(false);
				return response;
			}
			valor.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
			valor.setIp(InetAddress.getLocalHost().getHostAddress());
			response.setSuccesful(true);
			response.setMessage("Producto actualizado exitosamente");
			response.setValue(valor);
			return response;
		} catch (Exception e) {
			response.setSuccesful(false);
			response.setMessage(e.getMessage());
			return response;
		}
	}
	

}
