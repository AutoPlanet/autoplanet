package com.platform.repository;

import java.io.Serializable;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.platform.entity.Cita;

@Named
public class CitaRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "visorPU")
	private EntityManager em;

	public Integer insert(Cita cita) throws Exception {

		em.persist(cita);
		return cita.getId();
	}

}
