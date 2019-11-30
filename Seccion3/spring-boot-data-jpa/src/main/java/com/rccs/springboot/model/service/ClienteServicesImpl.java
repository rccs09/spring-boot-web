package com.rccs.springboot.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rccs.springboot.model.dao.IclienteDao;
import com.rccs.springboot.model.entity.Cliente;

@Service
public class ClienteServicesImpl implements IClienteService{
	@Autowired
	IclienteDao clienteDao;

	@Transactional(readOnly = true)
	@Override
	public List<Cliente> findAll() {
		return clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		return clienteDao.findById(id);
	}
	
	@Override
	@Transactional
	public void save(Cliente cliente) {
		clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.delete(id);
	}
	
}
