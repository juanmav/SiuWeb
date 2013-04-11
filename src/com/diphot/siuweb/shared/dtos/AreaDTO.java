package com.diphot.siuweb.shared.dtos;

import com.diphot.siuweb.shared.Jsonizable.Jsonizable;
import com.extjs.gxt.ui.client.data.BeanModelTag;
import com.google.gwt.user.client.rpc.IsSerializable;

public class AreaDTO implements IsSerializable, BeanModelTag, Jsonizable {
	private Long id;
	private String nombre;

	public AreaDTO(){

	}

	public AreaDTO(Long id, String nombre){
		this.id = id;
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
