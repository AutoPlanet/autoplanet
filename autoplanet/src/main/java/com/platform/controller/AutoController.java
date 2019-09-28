package com.platform.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.platform.entity.Auto;
import com.platform.entity.Cliente;
import com.platform.service.AutoService;
import com.platform.service.ClienteService;
import com.platform.util.Message;

@Named
@ViewScoped
public class AutoController implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private ClienteService clienteService;
	
	@Inject
	private AutoService autoService;

	private Auto auto;
	private Auto autoSel;
	private List<Auto> autos;

	private Cliente cliente;
	private List<Cliente> clientes;

	@PostConstruct
	public void init() {
		auto = new Auto();
		autoSel = new Auto();

		this.loadAutos();
		this.loadClientes();
	}
	
	public void loadClientes() {
		try {
			this.clientes = clienteService.findAll();
		} catch (Exception e) {

		}
	}
	 
	public void loadAutos() {
		try {
			this.autos = autoService.findAll();
		} catch (Exception e) {
			Message.messageError("Error Auto :" + e.getMessage());

		}
	}

	public void saveAuto() {
		try {
			if (auto.getId() != 0) {
				auto.setCliente(cliente);
				autoService.update(auto);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				auto.setCliente(cliente);
				autoService.insert(auto);
				Message.messageInfo("Registro guardado exitosamente");

			}
			loadAutos();
			loadClientes();
			cleanForm();
		} catch (Exception e) {
			Message.messageError("Error AutoType :" + e.getMessage());
		}
	}

	public void editAuto() {
		try {
			if (this.autoSel.getId() > 0) {
				this.auto = this.autoSel;
			} else {
				Message.messageInfo("Debe seleccionar un auto");
			}
		} catch (Exception e) {
			Message.messageError("Error Auto :" + e.getMessage());
		}

	}

	public void selecAuto(SelectEvent e) {
		this.autoSel = (Auto) e.getObject();
	}

	public void cleanForm() {
		this.auto = new Auto();
		this.autoSel = null;
	}

	public Auto getAuto() {
		return auto;
	}

	public void setProducto(Auto auto) {
		this.auto = auto;
	}

	public Auto getAutoSel() {
		return autoSel;
	}

	public void setAutoSel(Auto autoSel) {
		this.autoSel = autoSel;
	}

	public List<Auto> getAutos() {
		return autos;
	}

	public void setAutos(List<Auto> autos) {
		this.autos = autos;
	}

	public List<Cliente> getClientes() { 
		return clientes; 
	}
	  
	public void setClientes(List<Cliente> clientes) { 
		this.clientes = clientes; 
	}
	  
	public Cliente getCliente() { 
		return cliente; 
	}
	  
	public void setCliente(Cliente cliente) { 
		this.cliente = cliente; 
	}
	  
}
