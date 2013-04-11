package com.diphot.siuweb.shared.dtos;

import com.diphot.siuweb.shared.Jsonizable.Jsonizable;
import com.extjs.gxt.ui.client.data.BeanModelTag;
import com.google.gwt.user.client.rpc.IsSerializable;

public class TipoRelevamientoDTO implements IsSerializable, BeanModelTag, Jsonizable{
	private String id;
	private String nombre;
	private AreaDTO areadto;
		
	public TipoRelevamientoDTO(){
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public AreaDTO getAreadto() {
		return areadto;
	}

	public void setAreadto(AreaDTO areadto) {
		this.areadto = areadto;
	}

}
