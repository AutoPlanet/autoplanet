package com.platform.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.platform.model.entity.Cita;
import com.platform.model.entity.Producto;

@Entity
@Table(name = "servicios")
public class Servicio implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nombre", nullable = false)
	private String nombre;
		
	@Column(name = "cantidad")
	private int cantidad;

	@Column(name = "precio")
	private double precio;

	@Column(name = "importe")
	private double importe;

	@ManyToOne
	@JoinColumn(name = "cita_id", nullable = false)
	private Cita citaId;

	@ManyToOne
	@JoinColumn(name = "producto_id", nullable = false)
	private Producto producto;
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "auto_id", nullable = false) private Auto auto;
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "proveedor_id", nullable = false) private Proveedor
	 * proveedorId;
	 */
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public Cita getCitaId() {
		return citaId;
	}

	public void setCitaId(Cita citaId) {
		this.citaId = citaId;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	/*
	 * public Proveedor getProveedorId() { return proveedorId; }
	 * 
	 * public void setProveedorId(Proveedor proveedorId) { this.proveedorId =
	 * proveedorId; }
	 * 
	 * public Auto getAuto() { return auto; }
	 * 
	 * public void setAuto(Auto auto) { this.auto = auto; }
	 * 
	 */
	/* Faltaria proveedor, auto */
	@Override
	public String toString() {
		return producto.getNombre();
		//this.proveedor.getNombre();
	}
	
	
	
	/*
	 * @Override public String toString() { return producto.getNombre(); return
	 * proveedor.getNombre(); }
	 * 
	 */
}
