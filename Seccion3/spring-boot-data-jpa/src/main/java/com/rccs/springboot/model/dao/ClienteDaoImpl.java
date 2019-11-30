package com.rccs.springboot.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rccs.springboot.model.entity.Cliente;

@Repository("clienteDaoJpaImpl")
public class ClienteDaoImpl implements IclienteDao{
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional(readOnly = true)
	@Override
	public List<Cliente> findAll() {
		return em.createQuery("from Cliente").getResultList();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		if(cliente.getId()!=null && cliente.getId()>0) {
			em.merge(cliente);
		}else {
			em.persist(cliente);
		}
		
		
	}

	@Override
	public Cliente findById(Long id) {
		return em.find(Cliente.class, id);
	}

}
