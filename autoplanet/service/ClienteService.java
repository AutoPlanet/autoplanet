package com.upc.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.upc.model.entity.Cliente;
import com.upc.model.repository.ClienteRepository;

@Named
public class ClienteService implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private ClienteRepository clienteRepository;

	@Transactional
	public Integer insert(Cliente customer) throws Exception {
		return clienteRepository.insert(customer);
	}
	
	@Transactional
	public Integer update(Cliente cliente) throws Exception {
		return clienteRepository.update(cliente);
	}

	public Optional<Cliente> findCustomerByDni(String dni) throws Exception {
		return clienteRepository.findByDni(dni);
	}
	
	public List<Cliente> findAll() throws Exception {
		return clienteRepository.findAll();
	}

}