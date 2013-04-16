package com.diphot.siuweb.server.business;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.datanucleus.annotations.Unowned;

import java.util.Date;

@PersistenceCapable
public class Inspeccion {
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
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
	
	public Inspeccion (Long id, String calle, Integer altura, Tema tema, double latitude, double longitude){
		this.id = id;
		this.calle = calle;
		this.altura = altura;
		this.tema = tema;
		this.latitude = latitude;
		this.longitude = longitude;
	}
		
	public Inspeccion(){
		
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
}
