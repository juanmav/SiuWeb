package com.diphot.siuweb.server.business;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.datanucleus.annotations.Unowned;


@PersistenceCapable
public class TipoRelevamiento {

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private String nombre;
	@Persistent(defaultFetchGroup = "true")
	@Unowned
	private Area area;
	
	public TipoRelevamiento(){
		
	}

	public TipoRelevamiento(Long id, String nombre, Area area){
		this.id = id;
		this.nombre = nombre;
		this.area = area;
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

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
}
