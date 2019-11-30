package com.rccs.springboot.model.dao;

import java.util.List;

import com.rccs.springboot.model.entity.Cliente;

public interface IclienteDao {
	List<Cliente> findAll();
	
	void save(Cliente cliente);
	
	Cliente findById(Long id);
	
	public void delete(Long id);
}
