package com.rccs.springboot.model.service;

import java.util.List;

import com.rccs.springboot.model.entity.Cliente;

public interface IClienteService {
	List<Cliente> findAll();
	
	void save(Cliente cliente);
	
	Cliente findById(Long id);
	
	public void delete(Long id);
}
