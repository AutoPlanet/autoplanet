package com.platform.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.platform.entity.Proveedor;

@Named
public class ProveedorRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "visorPU")
	private EntityManager em;

	public Integer insert(Proveedor proveedor) throws Exception {
		em.persist(proveedor);
		return proveedor.getId();
	}

	public Integer update(Proveedor proveedor) throws Exception {
		em.merge(proveedor);
		return proveedor.getId();
	}

	public List<Proveedor> findAll() throws Exception {
		List<Proveedor> proveedores = new ArrayList<>();

		TypedQuery<Proveedor> query = em.createQuery("SELECT p FROM Proveedor p", Proveedor.class);
		proveedores = query.getResultList();
		return proveedores;
	}

}