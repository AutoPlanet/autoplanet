package com.upc.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.upc.model.entity.Producto;
import com.upc.model.repository.ProductoRepository;

@Named
public class ProductoService implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private ProductoRepository productoRepository;

	@Transactional
	public Integer insert(Producto producto) throws Exception {
		return productoRepository.insert(producto);
	}

	@Transactional
	public Integer update(Producto producto) throws Exception {
		return productoRepository.update(producto);
	}

	public List<Producto> findAll() throws Exception {
		return productoRepository.findAll();
	}

}
