package com.diphot.siuweb.server.business.model;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

public class Role {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String encodedKey;

	@Persistent
	@Extension(vendorName="datanucleus", key="gae.pk-id", value="true")
	private Long id;
	
	@Persistent
	private String name;
	
	public Role(){
		
	}
	
	public Role(Long id, String name){
		this.id = id;
		this.name = name;
	}
}
