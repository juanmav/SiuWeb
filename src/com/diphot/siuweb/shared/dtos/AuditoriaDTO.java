package com.diphot.siuweb.shared.dtos;


import java.io.Serializable;

import com.diphot.siuweb.server.business.model.EncodedImage;
import com.diphot.siuweb.shared.InterfaceDTO;
import com.extjs.gxt.ui.client.data.BeanModelTag;

public class AuditoriaDTO implements Serializable, BeanModelTag, InterfaceDTO {

	private static final long serialVersionUID = 3146877714180406714L;
	
	private Long id;
    private Long inspeccionID;
	private EncodedImage encodedIMG1;
	private EncodedImage encodedIMG2;
	private EncodedImage encodedIMG3;
	private Boolean resuelto;
	private String observaciones;
	
	public Long getInspeccionID() {
		return inspeccionID;
	}

	public void setInspeccionID(Long inspeccionID) {
		this.inspeccionID = inspeccionID;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Boolean getResuelto() {
		return resuelto;
	}

	public void setResuelto(Boolean resuelto) {
		this.resuelto = resuelto;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
}
