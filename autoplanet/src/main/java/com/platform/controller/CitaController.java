package com.platform.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;

import org.primefaces.event.SelectEvent;

import com.platform.entity.Cita;
import com.platform.entity.Cliente;
import com.platform.entity.Producto;
import com.platform.entity.Servicio;
import com.platform.service.CitaService;
import com.platform.service.ClienteService;
import com.platform.service.ProductoService;
import com.platform.util.Message;

@Named
@ViewScoped
public class CitaController implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private CitaService citaService;

	@Inject
	private ClienteService clienteService;

	@Inject
	private ProductoService productoService;

	private Cita cita;
	private Cita citaSel;
	private List<Cita> citas;

	private Servicio servicio;
	private Servicio servicioSel;
	private List<Servicio> servicios;

	private Cliente cliente;

	private Producto producto;
	private List<Producto> productos;

	@PostConstruct
	public void init() {
		cita = new Cita();
		citaSel = new Cita();
		citas = new ArrayList<>();

		servicio = new Servicio();
		servicioSel = new Servicio();
		servicios = new ArrayList<>();

		cliente = new Cliente();

		producto = new Producto();
		productos = new ArrayList<>();

		this.loadProducto();

	}

	public void findClienteByDni() {
		try {

			Optional<Cliente> customerExist = clienteService.findCustomerByDni(cliente.getDni());

			if (customerExist.isPresent()) {
				cliente = customerExist.get();
			}
		} catch (NoResultException e) {
			Message.messageInfo("Cliente no existe");
			resetForm();
		} catch (Exception e) {
			Message.messageError("Error Servicio :" + e.getMessage());
		}
	}

	public void addProductoToDetail() {
		servicio.setProducto(producto);
		
		servicios.add(servicio);
		
		cleanServicio();
	}

	public void loadProducto() {
		try {
			this.productos = productoService.findAll();
		} catch (Exception e) {

		}
	}

	public List<Producto> autoCompleteProducto(String query) {

		List<Producto> productosFilter = new ArrayList<Producto>();

		try {
			List<Producto> productos = productoService.findAll();
			for (int i = 0; i < productos.size(); i++) {
				Producto producto = productos.get(i);

				if (producto.getNombre().startsWith(query)) {
					productosFilter.add(producto);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return productosFilter;
	}

	public void updatePrecioProducto() {
		this.servicio.setPrecio(producto.getPrecio());
	}

	public void calculateImporteDetail() {
		double importe;
		importe = this.servicio.getPrecio() * this.servicio.getCantidad();
		this.servicio.setImporte(importe);
	}

	public void saveCita() {
		try {
			if (cliente != null) {
				if (!servicios.isEmpty()) {

					cita.setCliente(cliente);
					cita.setItems(servicios);

					citaService.insert(cita);

					resetForm();
					cleanServicio();

					Message.messageInfo("Registro de Cita");
				} else {
					Message.messageInfo("La cita no tiene servicio");
				}
			} else {
				Message.messageInfo("Debe buscar un cliente");
			}

		} catch (Exception e) {
			Message.messageError("Error Order :" + e.getMessage());
		}
	}

	public void cleanServicio() {
		this.servicio = new Servicio();
		this.producto = new Producto();
	}

	public void resetForm() {
		this.cita = new Cita();
		this.citaSel = null;
		this.servicios.clear();
		this.cliente = new Cliente();
	}

	public void selectCita(SelectEvent ev) {
		this.citaSel = (Cita) ev.getObject();
	}

	public void selectServicio(SelectEvent ev) {
		this.servicio = (Servicio) ev.getObject();
	}

	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

	public Cita getCitaSel() {
		return citaSel;
	}

	public void setCitaSel(Cita citaSel) {
		this.citaSel = citaSel;
	}

	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Servicio getServicioSel() {
		return servicioSel;
	}

	public void setServicioSel(Servicio servicioSel) {
		this.servicioSel = servicioSel;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

}
