package com.rccs.springboot.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rccs.springboot.model.entity.Cliente;

public interface IClienteService {
	List<Cliente> findAll();
	
	void save(Cliente cliente);
	
	Cliente findById(Long id);
	
	public void delete(Long id);
	
	Page<Cliente> findAll(Pageable pageable);
}
