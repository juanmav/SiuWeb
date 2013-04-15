package com.diphot.siuweb.server.business;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.datanucleus.annotations.Unowned;

@PersistenceCapable
public class Tema {

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private String nombre;
	@Persistent(defaultFetchGroup = "true")
	@Unowned
	private TipoRelevamiento tiporelevamiento;
	
	public Tema() {
		
	}
	
	public Tema(Long id, String nombre, TipoRelevamiento tiporelevamiento){
		this.id = id;
		this.nombre = nombre;
		this.tiporelevamiento = tiporelevamiento;
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

	public TipoRelevamiento getTiporelevamiento() {
		return tiporelevamiento;
	}

	public void setTiporelevamiento(TipoRelevamiento tiporelevamiento) {
		this.tiporelevamiento = tiporelevamiento;
	}
}
