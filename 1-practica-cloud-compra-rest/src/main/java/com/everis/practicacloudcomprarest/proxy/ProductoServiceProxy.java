package com.everis.practicacloudcomprarest.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.everis.practicacloudcomprarest.response.ProductoResponse;

@FeignClient(name="producto-service")
@RibbonClient(name="producto-service")
public interface ProductoServiceProxy {
	@GetMapping("/consultarInventario/id/{id}")
	public ProductoResponse retrieveProducto(@PathVariable Long id);
}
