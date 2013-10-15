package com.diphot.siuweb.server.business.model;

import java.util.ArrayList;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import com.google.appengine.datanucleus.annotations.Unowned;

@PersistenceCapable
public class Area {

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String encodedKey;
	
	@Persistent
    @Extension(vendorName="datanucleus", key="gae.pk-id", value="true")
    private Long id;

	@Persistent
	private String nombre;

	@Persistent
	@OneToMany(mappedBy = "area", cascade = CascadeType.ALL)
	@Unowned
	private ArrayList<TipoRelevamiento> tipos = new ArrayList<TipoRelevamiento>();
	
	@Persistent
	@Unowned
	private ArrayList<User> owners = new ArrayList<User>();

	public ArrayList<TipoRelevamiento> getTipos() {
		return tipos;
	}

	public void addTipo(TipoRelevamiento t) {
		tipos.add(t);
	}
	
	public Area(){

	}

	public Area(Long id, String nombre){
		this.nombre = nombre;
		this.id = id;
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
	public void addOwner(User user){
		this.owners.add(user);
	}
	public ArrayList<User> getOwners() {
		return owners;
	}
	public void setOwners(ArrayList<User> owners) {
		this.owners = owners;
	}
}
