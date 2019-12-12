package com.rccs.springboot.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rccs.springboot.model.entity.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long>{
	@Query("select p from Producto p where p.nombre like %?1%")
	List<Producto> findByNombre(String term); 
	
	List<Producto> findByNombreLikeIgnoreCase(String term);
}
