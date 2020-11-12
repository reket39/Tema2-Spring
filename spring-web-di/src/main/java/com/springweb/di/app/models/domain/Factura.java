package com.springweb.di.app.models.domain;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import org.springframework.web.context.annotation.SessionScope;

@Component     //se arregla con @RequestScope 
@SessionScope //Component es singleton y factura tiene que ser lo contrario para cada usuario una factura diferente
public class Factura implements Serializable {
	
	
	@Value("${factura.descripcion}")
	private String descripcion;
	
	@Autowired
	private Cliente cliente;
	
	@Autowired//qualified si fuera mas de uno
	private List<ItemFactura> items;
	
	@PostConstruct//justo despues de cargar
	public void inicializar() {
		cliente.setNombre(cliente.getNombre().concat(" ").concat("José"));
		descripcion = descripcion.concat(" de el cliente ").concat(cliente.getNombre());
	}
	@PreDestroy
	public void destruir() {
		System.out.println("Factura destruida ".concat(descripcion));
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<ItemFactura> getItems() {
		return items;
	}
	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -3025153161069860418L;

	
	
}
