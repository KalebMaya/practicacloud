package com.everis.practicacloudcomprarest.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.everis.practicacloudcomprarest.model.Persona;
import com.everis.practicacloudcomprarest.proxy.ProductoServiceProxy;
import com.everis.practicacloudcomprarest.response.ProductoResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ProductoController {
	
	@Autowired
	private ProductoServiceProxy productoServiceProxy;
	
	@Autowired
	private Environment environment;
	
	@Value("${config.reorden}")
	private int reorden;
	
	@GetMapping("/comprar/id/{id}/cantidad/{cantidad}")
	public ProductoResponse convert(@PathVariable Integer id,
			                        @PathVariable int cantidad) {
		ProductoResponse response = new ProductoResponse();
		try {
			response = productoServiceProxy.retrieveProducto(id);
		if((response.getValue().getStock()*(100-reorden)/100) < cantidad ) {
		    HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.APPLICATION_JSON);
			String url = "https://whatzmeapi.com:10501/rest/api/enviar-mensaje?token=877be9b47ac39dcbdac80d4fff18e554352abc13";
			Persona persona = new Persona();
			persona.setMensaje("Comprar mas producto "+id);
			persona.setNumero("525582032362");
			ObjectMapper objectMapper = new ObjectMapper();
			String personaJson = objectMapper.writeValueAsString(persona);
			HttpEntity<String> request = new HttpEntity<String>(personaJson, headers);
			ResponseEntity<String> respuesta = new RestTemplate().postForEntity(url, request, String.class);
			response.setSuccesful(false);
			response.setMessage("Compra rechazada, no hay suficiente inventario");
		} else {
			productoServiceProxy.actualizarStock(id, cantidad);
			response.setCompra(productoServiceProxy.insertarCompra(id, cantidad));
			response.setSuccesful(true);
			response.setMessage("Compra exitosa");
		}
		return response;
		} catch (Exception e) {
			response.setSuccesful(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}
	

}
