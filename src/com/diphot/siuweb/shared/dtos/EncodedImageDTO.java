package com.diphot.siuweb.shared.dtos;

import java.io.Serializable;
import com.diphot.siuweb.shared.InterfaceDTO;
import com.extjs.gxt.ui.client.data.BeanModelTag;

public class EncodedImageDTO implements Serializable, BeanModelTag, InterfaceDTO{

	private static final long serialVersionUID = -3576037209286046260L;
	private Long id;
	private InspeccionDTO inspeccionDTO;
	private String encodedImageString;
	
	public EncodedImageDTO(){
		
	}
	
	public EncodedImageDTO(String encodedImageString, InspeccionDTO inspeccionDTO){
		this.encodedImageString = encodedImageString;
		this.inspeccionDTO = inspeccionDTO;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEncodedImageString() {
		return encodedImageString;
	}
	public void setEncodedImageString(String encodedImage) {
		this.encodedImageString = encodedImage;
	}
	public InspeccionDTO getInspeccionDTO() {
		return inspeccionDTO;
	}
	public void setInspeccionDTO(InspeccionDTO inspeccionDTO) {
		this.inspeccionDTO = inspeccionDTO;
	}
}
