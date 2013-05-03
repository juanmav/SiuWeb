package com.diphot.siuweb.shared.dtos;

import com.diphot.siuweb.shared.InterfaceDTO;
import com.extjs.gxt.ui.client.data.BeanModelTag;
import com.google.gwt.user.client.rpc.IsSerializable;

public class AreaDTO implements IsSerializable, BeanModelTag, InterfaceDTO {
	private Long id;
	private String nombre;

	public AreaDTO(){

	}

	public String toString(){
		return nombre;
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
