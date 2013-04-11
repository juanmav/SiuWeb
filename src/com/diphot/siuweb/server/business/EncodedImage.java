package com.diphot.siuweb.server.business;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

public class EncodedImage {

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private String encodedImageString;
	
	public EncodedImage(){
		
	}
	
	public EncodedImage(String encodedImage){
		this.encodedImageString = encodedImage;
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
}
