package com.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.platform.model.entity.Auto;

@Named
public class AutoRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "visorPU")
	private EntityManager em;

	public Integer insert(Auto auto) throws Exception {
		em.persist(auto);
		return auto.getId();
	}

	public Integer update(Auto auto) throws Exception {
		em.merge(auto);
		return auto.getId();
	}

	public List<Auto> findAll() throws Exception {
		
		List<Auto> autos = new ArrayList<>();

		TypedQuery<Auto> query = em.createQuery("SELECT p FROM Auto p", Auto.class);
		autos = query.getResultList();
		return autos;
	}
	
	
	public Optional<Auto> findByPlaca(String placa) throws Exception {
		Auto auto;
		TypedQuery<Auto> autoFound = em.createQuery("Select c from Auto c WHERE c.placa =?1",
				Auto.class);
		autoFound.setParameter(1, placa);
		auto = autoFound.getSingleResult();

		return Optional.of(auto);
	}

}
