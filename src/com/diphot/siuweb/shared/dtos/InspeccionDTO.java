package com.diphot.siuweb.shared.dtos;

import java.util.Date;

import com.extjs.gxt.ui.client.data.BeanModelTag;
import com.google.gwt.user.client.rpc.IsSerializable;

public class InspeccionDTO implements IsSerializable, BeanModelTag, InterfaceDTO {

	private Long id;
	private String calle;
	private String altura;
	private TemaDTO tema;
	private Double longitude;
	private Double latitude;
	private Date fecha;
	
	public InspeccionDTO(){
		
	}
	
	public InspeccionDTO(Long id, String calle, String altura, TemaDTO tema,
							double longitude, double latitude, Date fecha) {
		super();
		this.id = id;
		this.calle = calle;
		this.altura = altura;
		this.tema = tema;
		this.longitude = longitude;
		this.latitude = latitude;
		this.fecha = fecha;
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
	
	public TemaDTO getTema() {
		return tema;
	}
	
	public void setTema(TemaDTO tema) {
		this.tema = tema;
	}
	
	public Double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	public Double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
