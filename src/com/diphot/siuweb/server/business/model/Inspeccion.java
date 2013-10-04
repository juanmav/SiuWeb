package com.diphot.siuweb.server.business.model;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import com.diphot.siuweb.server.business.model.inspeccion.status.Confirmado;
import com.diphot.siuweb.server.business.model.inspeccion.status.Ejecutado;
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
	@Persistent
	@Unowned
	private EncodedImage encodedIMG1;
	@Persistent
	@Unowned
	private EncodedImage encodedIMG2;
	@Persistent
	@Unowned
	private EncodedImage encodedIMG3;
	@Persistent
	@Unowned
	private EncodedImage encodedMap;
	@Persistent
	private String observacion;

	@Persistent
	@OneToMany(mappedBy = "inspeccion", cascade = CascadeType.ALL)
	@Unowned
	private ArrayList<Auditoria> auditorias = new ArrayList<Auditoria>();

	// TODO ver como soportar relaciones polimorficas sin utilizar keys.
	//@Persistent
	//private ArrayList<InspeccionState> states = new ArrayList<InspeccionState>();
	@Persistent	
	private ArrayList<Observado> observados = new ArrayList<Observado>();
	@Persistent
	private ArrayList<Confirmado> confirmados = new ArrayList<Confirmado>();
	@Persistent
	private ArrayList<Ejecutado> ejecutados = new ArrayList<Ejecutado>();
	@Persistent
	private ArrayList<Resuelto> resuelto = new ArrayList<Resuelto>();

	@Persistent
	private Integer lastStateIdentifier;

	@Persistent 
	private Integer riesgo;
	
	@Persistent
	@Unowned
	private User owner;
	
	@Persistent
	private String uuid;
	
	@Persistent
	@Unowned
	private Localidad localidad;
	
	public Inspeccion (Long id, String calle, Integer altura, Date fecha, String observacion, Tema tema, double latitude, double longitude, int riesgo){
		this.id = id;
		this.calle = calle;
		this.altura = altura;
		this.tema = tema;
		this.latitude = latitude;
		this.longitude = longitude;
		this.fecha = fecha;
		this.observacion = observacion;
		this.riesgo = riesgo;
		this.observados.add(new Observado(fecha, this));
		// Para buscar la inspeccion por el codigo de estado.
		this.lastStateIdentifier = InspeccionState.OBSERVADO;
	}

	public InspeccionState getState(){
		switch (this.lastStateIdentifier) {
		case InspeccionState.OBSERVADO:
			return this.observados.get(observados.size() - 1);
		case InspeccionState.CONFIRMADO:
			return this.confirmados.get(confirmados.size() - 1);
		case InspeccionState.EJECUTADO:
			return this.ejecutados.get(ejecutados.size() - 1);
		case InspeccionState.RESUELTO:
			return this.resuelto.get(0);
		default:
			return null;
		}
	}

	public void setState(InspeccionState state){
		if (state instanceof Observado){
			this.observados.add((Observado)state);
		} else if (state instanceof Confirmado){
			this.confirmados.add((Confirmado)state);
		} else if (state instanceof Ejecutado){
			this.ejecutados.add((Ejecutado)state);
		} else if (state instanceof Resuelto){
			this.resuelto.add((Resuelto) state);
		}
		// Para buscar la inspeccion por el codigo de estado.
		this.lastStateIdentifier = state.getCode();
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
	/** TODO aca habria que poner una lista encadenada o similar, 
	 * arrojar excepciones si se pasa de tres o pisar fotos viejas.
	 *
	 * @param img
	 */
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
	public Integer getRiesgo() {
		return riesgo;
	}
	public void setRiesgo(Integer riesgo) {
		this.riesgo = riesgo;
	}
	public Integer getLastStateIdentifier() {
		return lastStateIdentifier;
	}
	public void setLastStateIdentifier(Integer lastStateIdentifier) {
		this.lastStateIdentifier = lastStateIdentifier;
	}
	public ArrayList<Auditoria> getAuditorias() {
		return auditorias;
	}

	public void confirmar(){
		this.setState(new Confirmado(new Date(), this));
	}

	public void ejecutadaAuditable(){
		this.setState(new Ejecutado(new Date(), this));
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
}
