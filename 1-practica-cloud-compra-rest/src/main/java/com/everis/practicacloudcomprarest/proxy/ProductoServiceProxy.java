package com.everis.practicacloudcomprarest.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.everis.practicacloudcomprarest.model.Compra;
import com.everis.practicacloudcomprarest.model.Producto;
import com.everis.practicacloudcomprarest.response.ProductoResponse;

@FeignClient(name="producto-service")
@RibbonClient(name="producto-service")
public interface ProductoServiceProxy {
	@GetMapping("/consultarInventario/id/{id}")
	public ProductoResponse retrieveProducto(@PathVariable Integer id);
	@PostMapping("/insertarCompra/idProducto/{idProducto}/cantidad/{cantidad}")
	public Compra insertarCompra(@PathVariable int idProducto, @PathVariable int cantidad);
	@PutMapping("/modificarInventario/id/{id}/cantidad/{cantidad}")
	public Producto actualizarStock(@PathVariable Integer id, @PathVariable int cantidad); 
}
