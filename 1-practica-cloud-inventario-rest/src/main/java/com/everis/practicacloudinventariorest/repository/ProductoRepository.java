package com.everis.practicacloudinventariorest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.practicacloudinventariorest.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

	Producto findByNombre(String nombre);
}