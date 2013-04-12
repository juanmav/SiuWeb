package com.diphot.siuweb.shared.dtos;

import com.extjs.gxt.ui.client.data.BeanModelTag;
import com.google.gwt.user.client.rpc.IsSerializable;

public class EncodedImageDTO implements IsSerializable, BeanModelTag, InterfaceDTO{

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
