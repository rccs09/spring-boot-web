package com.rccs.springboot.model.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rccs.springboot.model.entity.Cliente;

public interface IclienteDao extends PagingAndSortingRepository<Cliente, Long> {

}
