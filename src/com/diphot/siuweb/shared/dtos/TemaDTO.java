package com.diphot.siuweb.shared.dtos;

import com.diphot.siuweb.shared.Jsonizable.Jsonizable;
import com.extjs.gxt.ui.client.data.BeanModelTag;
import com.google.gwt.user.client.rpc.IsSerializable;

public class TemaDTO implements IsSerializable, BeanModelTag, Jsonizable {
	private String nombre;
	private Long id;
	private TipoRelevamientoDTO tiporelevamientodto;
	
	public TemaDTO() {
		
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
