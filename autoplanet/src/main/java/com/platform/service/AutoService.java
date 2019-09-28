package com.platform.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.platform.entity.Auto;
import com.platform.repository.AutoRepository;

@Named
public class AutoService implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private AutoRepository autoRepository;

	@Transactional
	public Integer insert(Auto auto) throws Exception {
		return autoRepository.insert(auto);
		
	}

	@Transactional
	public Integer update(Auto auto) throws Exception {
		return autoRepository.update(auto);
	}

	public List<Auto> findAll() throws Exception {
		return autoRepository.findAll();
	}
	
	public Optional<Auto> findAutoByPlaca(String placa) throws Exception {
		return autoRepository.findByPlaca(placa);
	}

}
