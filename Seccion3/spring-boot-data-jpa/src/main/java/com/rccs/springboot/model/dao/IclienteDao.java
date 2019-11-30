package com.rccs.springboot.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.rccs.springboot.model.entity.Cliente;

public interface IclienteDao extends CrudRepository<Cliente, Long> {

}
