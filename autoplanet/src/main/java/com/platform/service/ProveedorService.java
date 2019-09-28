package com.platform.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.platform.entity.Proveedor;
import com.platform.repository.ProveedorRepository;

@Named
public class ProveedorService implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private ProveedorRepository proveedorRepository;

	@Transactional
	public Integer insert(Proveedor proveedor) throws Exception {
		return proveedorRepository.insert(proveedor);
	}

	@Transactional
	public Integer update(Proveedor proveedor) throws Exception {
		return proveedorRepository.update(proveedor);
	}

	public List<Proveedor> findAll() throws Exception {
		return proveedorRepository.findAll();
	}

}