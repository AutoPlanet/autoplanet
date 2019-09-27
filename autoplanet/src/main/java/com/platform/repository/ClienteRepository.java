package com.platform.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.platform.entity.Cliente;

@Named
public class ClienteRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "visorPU")
	private EntityManager em;

	public Integer insert(Cliente cliente) throws Exception {
		em.persist(cliente);
		return cliente.getId();
	}
	
	public Integer update(Cliente cliente) throws Exception {
		em.merge(cliente);
		return cliente.getId();
	}

	public Optional<Cliente> findByDni(String dni) throws Exception {
		Cliente cliente;
		TypedQuery<Cliente> customerFound = em.createQuery("Select c from Cliente c WHERE c.dni =?1",
				Cliente.class);
		customerFound.setParameter(1, dni);
		cliente = customerFound.getSingleResult();

		return Optional.of(cliente);
	}
	
	public List<Cliente> findAll() throws Exception {
		List<Cliente> clientes = new ArrayList<>();

		TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c", Cliente.class);
		clientes = query.getResultList();
		return clientes;
	}

}