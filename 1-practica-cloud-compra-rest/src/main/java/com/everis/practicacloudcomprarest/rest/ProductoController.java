package com.everis.practicacloudcomprarest.rest;

import java.math.BigDecimal;
import java.net.InetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.everis.practicacloudcomprarest.proxy.ProductoServiceProxy;
import com.everis.practicacloudcomprarest.response.ProductoResponse;

@RestController
public class ProductoController {
	
	@Autowired
	private ProductoServiceProxy productoServiceProxy;
	
	@Autowired
	private Environment environment;
	
	@Value("${config.reorden}")
	private int reorden;
	
	@GetMapping("/comprar/id/{id}/cantidad/{cantidad}")
	public ProductoResponse convert(@PathVariable Long id,
			                        @PathVariable BigDecimal cantidad) {
		ProductoResponse response = new ProductoResponse();
		try {
			response = productoServiceProxy.retrieveProducto(id);
		if((response.getValue().getStock().intValue()*(100-reorden)/100) < cantidad.intValue() ) {
			response.setSuccessful(false);
			response.setMessage("inventario insuficiente, su compra no puede ser procesada");
			response.setIp(InetAddress.getLocalHost().getHostName());
		} else {
		response.setSuccessful(true);
		response.setMessage("Compra exitosa");
		}
		return response;
		} catch (Exception e) {
			response.setSuccessful(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}
	

}
