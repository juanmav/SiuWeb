package com.diphot.siuweb.shared.dtos;

import java.io.Serializable;
import com.extjs.gxt.ui.client.data.BeanModelTag;

public class TemaDTO implements Serializable, BeanModelTag,  InterfaceDTO {

	private static final long serialVersionUID = -1154524751777580522L;
	private String nombre;
	private Long id;
	private TipoRelevamientoDTO tiporelevamientodto;
	
	public TemaDTO() {
		
	}
	
	public TemaDTO(Long id){
		this.id = id;
	}
	
	public String toString(){
		return this.nombre;
	}
	
	public TemaDTO (Long id, String nombre, TipoRelevamientoDTO tiporelevamientodto){
		this.id = id;
		this.nombre = nombre;
		this.tiporelevamientodto = tiporelevamientodto;
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

	public TipoRelevamientoDTO getTiporelevamientodto() {
		return tiporelevamientodto;
	}

	public void setTiporelevamientodto(TipoRelevamientoDTO tiporelevamientodto) {
		this.tiporelevamientodto = tiporelevamientodto;
	}
}
