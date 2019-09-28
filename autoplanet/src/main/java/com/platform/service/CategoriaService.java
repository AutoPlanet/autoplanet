package com.platform.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.platform.entity.Categoria;
import com.platform.repository.CategoriaRepository;

@Named
public class CategoriaService implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private CategoriaRepository categoriaRepository;

	@Transactional
	public Integer insert(Categoria categoria) throws Exception {

		return categoriaRepository.insert(categoria);
		
	}

	@Transactional
	public Integer update(Categoria categoria) throws Exception {
		return categoriaRepository.update(categoria);
	}

	public List<Categoria> findAll() throws Exception {
		return categoriaRepository.findAll();
	}

}