package com.platform.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.platform.entity.Producto;

@Named
public class ProductoRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "visorPU")
	private EntityManager em;

	public Integer insert(Producto producto) throws Exception {
		em.persist(producto);
		return producto.getId();
	}

	public Integer update(Producto producto) throws Exception {
		em.merge(producto);
		return producto.getId();
	}

	public List<Producto> findAll() throws Exception {
		List<Producto> productos = new ArrayList<>();

		TypedQuery<Producto> query = em.createQuery("SELECT p FROM Producto p", Producto.class);
		productos = query.getResultList();
		return productos;
	}

}
