package com.platform.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.platform.entity.Proveedor;
import com.platform.service.ProveedorService;
import com.platform.util.Message;

@Named
@ViewScoped
public class ProveedorController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProveedorService proveedorService;

	private Proveedor proveedor;
	private Proveedor proveedorSel;
	private List<Proveedor> proveedores;

	@PostConstruct
	public void init() {
		proveedor = new Proveedor();
		proveedorSel = new Proveedor();

		this.loadProveedores();
	}

	public void loadProveedores() {
		try {
			this.proveedores = proveedorService.findAll();
		} catch (Exception e) {
			Message.messageError("Error Proveedor :" + e.getMessage());
		}
	}

	public void saveProveedor() {
		try {
			if (proveedor.getId() != 0) {
				proveedorService.update(proveedor);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				proveedorService.insert(proveedor);
				Message.messageInfo("Registro guardado exitosamente");

			}
			loadProveedores();
			cleanForm();
		} catch (Exception e) {
			Message.messageError("Error ProductoType :" + e.getMessage());
		}
	}

	public void editProveedor() {
		try {
			if (this.proveedorSel.getId() > 0) {
				this.proveedor = this.proveedorSel;
				// this.product.setProductType(this.productSel.getProductType());
			} else {
				Message.messageInfo("Debe seleccionar un proveedor");
			}
		} catch (Exception e) {
			Message.messageError("Error Proveedor :" + e.getMessage());
		}

	}

	public void selecProveedor(SelectEvent e) {
		this.proveedorSel = (Proveedor) e.getObject();
	}

	public void cleanForm() {
		this.proveedor = new Proveedor();
		this.proveedorSel = null;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Proveedor getProveedorSel() {
		return proveedorSel;
	}

	public void setProveedorSel(Proveedor proveedorSel) {
		this.proveedorSel = proveedorSel;
	}

	public List<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProducts(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

}