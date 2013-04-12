package com.diphot.siuweb.server.business;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.google.appengine.api.datastore.Text;

@PersistenceCapable
public class EncodedImage {

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private Text encodedImageString;
	
	public EncodedImage(){
		
	}
	
	public EncodedImage(String encodedImage){
		this.encodedImageString = new Text(encodedImage);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEncodedImageString() {
		return encodedImageString.getValue();
	}
	public void setEncodedImageString(String encodedImage) {
		this.encodedImageString = new Text(encodedImage);
	}
}
