package com.diphot.siuweb.server.business.model;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import com.diphot.siuweb.server.business.model.inspeccion.status.InspeccionState;
import com.diphot.siuweb.server.business.model.inspeccion.status.Observado;
import com.diphot.siuweb.server.business.model.inspeccion.status.Resuelto;
import com.google.appengine.datanucleus.annotations.Unowned;

import java.util.ArrayList;
import java.util.Date;

@PersistenceCapable
public class Inspeccion {
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String encodedKey;
	
	@Persistent
    @Extension(vendorName="datanucleus", key="gae.pk-id", value="true")
    private Long id;
	
	@Persistent
	private String calle;
	@Persistent
	private Integer altura;
	@Persistent
	@Unowned
	private Tema tema;
	@Persistent
	private Double latitude;
	@Persistent
	private Double longitude;
	@Persistent
	private Date fecha;
	@Persistent(defaultFetchGroup = "true")
	@Unowned
	private EncodedImage encodedIMG1;
	@Persistent(defaultFetchGroup = "true")
	@Unowned
	private EncodedImage encodedIMG2;
	@Persistent(defaultFetchGroup = "true")
	@Unowned
	private EncodedImage encodedIMG3;
	@Persistent(defaultFetchGroup = "true")
	@Unowned
	private EncodedImage encodedMap;
	@Persistent
	private String observacion;
	
	@Persistent
	@OneToMany(mappedBy = "inspeccion", cascade = CascadeType.ALL)
	@Unowned
	private ArrayList<Auditoria> auditorias = new ArrayList<Auditoria>();

	@Persistent
	private ArrayList<InspeccionState> states = new ArrayList<InspeccionState>();
	
	public Inspeccion (Long id, String calle, Integer altura, Date fecha, String observacion, Tema tema, double latitude, double longitude){
		this.id = id;
		this.calle = calle;
		this.altura = altura;
		this.tema = tema;
		this.latitude = latitude;
		this.longitude = longitude;
		this.fecha = fecha;
		this.observacion = observacion;
		this.states.add(new Observado(fecha, this));
	}
		
	public InspeccionState getState(){
		// Solo devuelvo el ultimo estado que es el valido.
		return states.get(states.size() - 1);
	}
	
	public void setState(InspeccionState state){
		states.add(state);
	}
	
	public Inspeccion(){
		
	}
	// TODO disparar una excepcion y/o alarma para cuando la cuenta de Auditorias supere las dos auditorias.
	public void addAuditoria(Auditoria auditoria){
		this.auditorias.add(auditoria);
		
		if (auditoria.getResuelto()){ // El Problema esta resuelto
			setState(new Resuelto(auditoria.getFecha(), this));
		} else {
			setState(new Observado(auditoria.getFecha(), this));
		}
		
	}
	// TODO aca habria que poner una lista encadenada o algo por el estilo y arrojar excepciones si se pasa de tres o pisar
	// fotos viejas.
	public void addImage(EncodedImage img){
		if (this.encodedIMG1 == null) {
			this.encodedIMG1 = img;
		} else if (this.encodedIMG2 == null){
			this.encodedIMG2 = img;
		} else if (this.encodedIMG3 == null){
			this.encodedIMG3 = img;
		}
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public Integer getAltura() {
		return altura;
	}
	public void setAltura(Integer altura) {
		this.altura = altura;
	}
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public EncodedImage getEncodedIMG1() {
		return encodedIMG1;
	}

	public void setEncodedIMG1(EncodedImage encodedIMG1) {
		this.encodedIMG1 = encodedIMG1;
	}

	public EncodedImage getEncodedIMG2() {
		return encodedIMG2;
	}

	public void setEncodedIMG2(EncodedImage encodedIMG2) {
		this.encodedIMG2 = encodedIMG2;
	}

	public EncodedImage getEncodedIMG3() {
		return encodedIMG3;
	}

	public void setEncodedIMG3(EncodedImage encodedIMG3) {
		this.encodedIMG3 = encodedIMG3;
	}
	
	public void setLatLong(Double latitude, Double longitude){
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	public EncodedImage getEncodedMap() {
		return encodedMap;
	}

	public void setEncodedMap(EncodedImage encodedMap) {
		this.encodedMap = encodedMap;
	}
}
