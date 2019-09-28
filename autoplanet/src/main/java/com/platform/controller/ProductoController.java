package com.platform.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.platform.entity.Categoria;
import com.platform.entity.Producto;
import com.platform.entity.Proveedor;
import com.platform.service.CategoriaService;
import com.platform.service.ProductoService;
import com.platform.service.ProveedorService;
import com.platform.util.Message;

@Named
@ViewScoped
public class ProductoController implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private CategoriaService categoriaService;
	
	@Inject
	private ProveedorService proveedorService;

	@Inject
	private ProductoService productoService;

	private Producto producto;
	private Producto productoSel;
	private List<Producto> productos;

	private Categoria categoria;
	private List<Categoria> categorias;
	
	private Proveedor proveedor;
	private List<Proveedor> proveedores;

	@PostConstruct
	public void init() {
		producto = new Producto();
		productoSel = new Producto();

		this.loadProductos();
		this.loadCategorias();
		this.loadProveedores();
	}

	public void loadCategorias() {
		try {
			this.categorias = categoriaService.findAll();
		} catch (Exception e) {

		}
	}
	
	public void loadProveedores() {
		try {
			this.proveedores = proveedorService.findAll();
		} catch (Exception e) {

		}
	}

	public void loadProductos() {
		try {
			this.productos = productoService.findAll();
		} catch (Exception e) {

		}
	}

	public void saveProducto() {
		try {
			if (producto.getId() != 0) {
				producto.setCategoria(categoria);
				producto.setProveedor(proveedor);
				productoService.update(producto);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				producto.setCategoria(categoria);
				producto.setProveedor(proveedor);
				productoService.insert(producto);
				Message.messageInfo("Registro guardado exitosamente");

			}
			loadProductos();
			//loadCategorias();
			//loadProveedores();
			cleanForm();
		} catch (Exception e) {
			Message.messageError("Error ProductoType :" + e.getMessage());
		}
	}

	public void editProducto() {
		try {
			if (this.productoSel.getId() > 0) {
				this.producto = this.productoSel;
				// this.product.setProductType(this.productSel.getProductType());
			} else {
				Message.messageInfo("Debe seleccionar un producto");
			}
		} catch (Exception e) {
			Message.messageError("Error Producto :" + e.getMessage());
		}

	}

	public void selecProducto(SelectEvent e) {
		this.productoSel = (Producto) e.getObject();
	}

	public void cleanForm() {
		this.producto = new Producto();
		this.productoSel = null;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Producto getProductoSel() {
		return productoSel;
	}

	public void setProductoSel(Producto productoSel) {
		this.productoSel = productoSel;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public List<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

}
