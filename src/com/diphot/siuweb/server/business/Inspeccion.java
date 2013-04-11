package com.diphot.siuweb.server.business;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.util.Date;

@PersistenceCapable
public class Inspeccion {

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private String calle;
	@Persistent
	private String altura;
	@Persistent
	private Tema tema;
	@Persistent
	private double latitude;
	@Persistent
	private double longitude;
	@Persistent
	private Date fecha;
	
	@Persistent
	private EncodedImage encodedIMG1;
	@Persistent
	private EncodedImage encodedIMG2;
	@Persistent
	private EncodedImage encodedIMG3;
	
	public Inspeccion (Long id, String calle, String altura, Tema tema, double latitude, double longitude){
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
	public String getAltura() {
		return altura;
	}
	public void setAltura(String altura) {
		this.altura = altura;
	}
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
}
