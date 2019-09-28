package com.platform.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.platform.entity.Cliente;
import com.platform.service.ClienteService;
import com.platform.util.Message;

@Named
@ViewScoped
public class ClienteController implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private ClienteService clienteService;

	private Cliente cliente;
	private Cliente clienteSelec;
	private List<Cliente> clientes;

	@PostConstruct
	public void init() {
		cliente = new Cliente();
		clienteSelec = new Cliente();
		loadClientes();
	}

	public void loadClientes() {
		try {
			this.clientes = clienteService.findAll();
		} catch (Exception e) {
			Message.messageError("Error Cliente :" + e.getMessage());
		}
	}

	public void saveCliente() {
		try {
			if (cliente.getId() != null) {

				Message.messageInfo("Registro actualizado exitosamente");
				clienteService.update(cliente);
			} else {
				clienteService.insert(cliente);
				Message.messageInfo("Registro guardado exitosamente");

			}
			loadClientes();
			clearForm();
		} catch (Exception e) {
			Message.messageError("Error Cliente :" + e.getStackTrace());
		}
	}

	public void editCliente() {
		try {
			if (this.clienteSelec != null) {
				this.cliente = clienteSelec;
			} else {
				Message.messageInfo("Debe seleccionar una cliente");
			}
		} catch (Exception e) {
			Message.messageError("Error Cliente :" + e.getMessage());
		}

	}

	public void selectCliente(SelectEvent e) {
		this.clienteSelec = (Cliente) e.getObject();
	}

	public void clearForm() {
		this.cliente = new Cliente();
		this.clienteSelec = null;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getClienteSelec() {
		return clienteSelec;
	}

	public void setClienteSelec(Cliente clienteSelec) {
		this.clienteSelec = clienteSelec;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
