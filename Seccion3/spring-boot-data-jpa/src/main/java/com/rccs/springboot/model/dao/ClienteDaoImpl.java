package com.rccs.springboot.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.rccs.springboot.model.entity.Cliente;

@Repository("clienteDaoJpaImpl")
public class ClienteDaoImpl implements IclienteDao{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Cliente> findAll() {
		return em.createQuery("from Cliente").getResultList();
	}

	@Override
	public Cliente findById(Long id) {
		return em.find(Cliente.class, id);
	}
	
	@Override
	public void save(Cliente cliente) {
		if(cliente.getId()!=null && cliente.getId()>0) {
			em.merge(cliente);
		}else {
			em.persist(cliente);
		}
	}

	@Override
	public void delete(Long id) {
		em.remove(findById(id));		
	}

}
