package com.platform.service;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.platform.entity.Cita;
import com.platform.repository.CitaRepository;

@Named
public class CitaService implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private CitaRepository citaRepository;

	@Transactional
	public Integer insert(Cita cita) throws Exception {

		cita.getItems().forEach(item -> item.setCitaId(cita));

		return citaRepository.insert(cita);
	}

}
