package com.platform.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.platform.entity.Categoria;
import com.platform.service.CategoriaService;
import com.platform.util.Message;

@Named
@ViewScoped
public class CategoriaController implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private CategoriaService categoriaService;

	private Categoria categoria;
	private Categoria categoriaSelec;
	private List<Categoria> categorias;

	@PostConstruct
	public void init() {
		categoria = new Categoria();
		categoriaSelec = new Categoria();
		loadCategorias();
	}

	public void loadCategorias() {
		try {
			this.categorias = categoriaService.findAll();
		} catch (Exception e) {
			Message.messageError("Error Categoria :" + e.getMessage());
		}
	}

	public void saveCategoria() {
		try {
			if (categoria.getId() != null) {

				Message.messageInfo("Registro actualizado exitosamente");
				categoriaService.update(categoria);
			} else {
				categoriaService.insert(categoria);
				Message.messageInfo("Registro guardado exitosamente");

			}
			loadCategorias();
			clearForm();
		} catch (Exception e) {
			Message.messageError("Error Categoria :" + e.getStackTrace());
		}
	}

	public void editCategoria() {
		try {
			if (this.categoriaSelec != null) {
				this.categoria = categoriaSelec;
			} else {
				Message.messageInfo("Debe seleccionar una categoria");
			}
		} catch (Exception e) {
			Message.messageError("Error Categoria :" + e.getMessage());
		}

	}

	public void selectCategoria(SelectEvent e) {
		this.categoriaSelec = (Categoria) e.getObject();
	}

	public void clearForm() {
		this.categoria = new Categoria();
		this.categoriaSelec = null;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Categoria getCategoriaSelec() {
		return categoriaSelec;
	}

	public void setCategoriaSelec(Categoria categoriaSelec) {
		this.categoriaSelec = categoriaSelec;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

}