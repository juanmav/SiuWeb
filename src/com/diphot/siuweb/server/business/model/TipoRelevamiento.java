package com.diphot.siuweb.server.business.model;

import java.util.ArrayList;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.google.appengine.datanucleus.annotations.Unowned;

@PersistenceCapable
public class TipoRelevamiento {

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
	private Area area;
	
	@Persistent
	@OneToMany(mappedBy = "tiporelevamiento", cascade = CascadeType.ALL)
	@Unowned
	private ArrayList<Tema> temas = new ArrayList<Tema>();
	
	public TipoRelevamiento(){
		
	}
	public void addTema(Tema tema){
		this.temas.add(tema);
	}
	public TipoRelevamiento(Long id, String nombre, Area area){
		this.id = id; 
		this.nombre = nombre;
		this.area = area;
		this.area.addTipo(this);
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
	
	public String toString(){
		return this.nombre;
	}
	
}
