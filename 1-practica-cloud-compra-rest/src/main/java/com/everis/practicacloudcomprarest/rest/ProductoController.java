package com.everis.practicacloudcomprarest.rest;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.everis.practicacloudcomprarest.response.ProductoResponse;

@RestController
public class ProductoController {
	
	@Value("${config.reorden}")
	private int reorden;
	
	@GetMapping("/comprar/id/{id}/cantidad/{cantidad}")
	public ProductoResponse convert(@PathVariable Long id,
			                        @PathVariable BigDecimal cantidad) {
		String url = "http://192.168.1.71:8000/consultarInventario/id/{id}";
	
		Map<String, Long> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		ProductoResponse response = new ProductoResponse();
		try {
		ResponseEntity<ProductoResponse> respuesta =
		             new RestTemplate().getForEntity(url,
		            		 ProductoResponse.class, uriVariables);
		
			response = respuesta.getBody();
		if((response.getValue().getStock().intValue()*(100-reorden)/100) < cantidad.intValue() ) {
			response.setSuccessful(false);
			response.setMessage("inventario insuficiente, su compra no puede ser procesada");
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
