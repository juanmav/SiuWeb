package com.diphot.siuweb.shared.dtos;

import com.diphot.siuweb.shared.Jsonizable.Jsonizable;
import com.extjs.gxt.ui.client.data.BeanModelTag;
import com.google.gwt.user.client.rpc.IsSerializable;

public class EncodedImageDTO implements IsSerializable, BeanModelTag, Jsonizable{

	private Long id;
	private InspeccionDTO inspeccionDTO;
	private String encodedImageString;
	
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
