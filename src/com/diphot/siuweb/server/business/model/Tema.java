package com.diphot.siuweb.server.business.model;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.ManyToOne;
import com.google.appengine.datanucleus.annotations.Unowned;

@PersistenceCapable
public class Tema {

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String encodedKey;
	
	@Persistent
    @Extension(vendorName="datanucleus", key="gae.pk-id", value="true")
    private Long id;
	
	@Persistent
	private String nombre;
	
	@Persistent(defaultFetchGroup = "true")
	@Unowned
	@ManyToOne
	private TipoRelevamiento tiporelevamiento;
	
	public Tema() {
		
	}
	
	public Tema(Long id, String nombre, TipoRelevamiento tiporelevamiento){
		this.id = id;
		this.nombre = nombre;
		this.tiporelevamiento = tiporelevamiento;
		this.tiporelevamiento.addTema(this);
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
