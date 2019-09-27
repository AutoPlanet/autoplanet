package com.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.platform.model.entity.Categoria;

@Named
public class CategoriaRepository implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "visorPU")
	private EntityManager em;

	public Integer insert(Categoria categoria) throws Exception {
		em.persist(categoria);
		return categoria.getId();
	}

	public Integer update(Categoria categoria) throws Exception {
		em.merge(categoria);
		return categoria.getId();
	}

	public List<Categoria> findAll() throws Exception {
		List<Categoria> categorias = new ArrayList<>();

		TypedQuery<Categoria> query = em.createQuery("SELECT c FROM Categoria c", Categoria.class);
		categorias = query.getResultList();
		return categorias;
	}

}