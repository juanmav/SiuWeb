package com.diphot.siuweb.shared.dtos;

import java.io.Serializable;

import com.diphot.siuweb.shared.InterfaceDTO;
import com.extjs.gxt.ui.client.data.BeanModelTag;


public class AreaDTO implements Serializable, BeanModelTag, InterfaceDTO {

	private static final long serialVersionUID = 1096797938747356616L;
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
