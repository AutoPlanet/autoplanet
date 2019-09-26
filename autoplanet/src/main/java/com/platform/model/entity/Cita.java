package com.platform.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.platform.model.entity.Cliente;
import com.platform.model.entity.Servicio;

@Entity
@Table(name = "citas")
public class Cita implements Serializable{
		
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;

		@Temporal(TemporalType.DATE)
		@Column(name = "create_at")
		private Date createAt;

		@OneToMany(mappedBy = "citaId", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
				CascadeType.REMOVE }, fetch = FetchType.LAZY, orphanRemoval = true)
		private List<Servicio> items;

		@ManyToOne
		@JoinColumn(name = "cliente_id")
		private Cliente cliente;

		public Cita() {
			this.items = new ArrayList<Servicio>();
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Date getCreateAt() {
			return createAt;
		}

		public void setCreateAt(Date createAt) {
			this.createAt = createAt;
		}

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}
		
		public List<Servicio> getItems() {
			return items;
		}

		public void setItems(List<Servicio> items) {
			this.items = items;
		}

}
