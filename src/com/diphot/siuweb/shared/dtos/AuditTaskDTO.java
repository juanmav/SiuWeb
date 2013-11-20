package com.diphot.siuweb.shared.dtos;

import java.io.Serializable;

public class AuditTaskDTO  implements Serializable, InterfaceDTO {

	private static final long serialVersionUID = -4871765418846796576L;
	private Long id;
	private Long inspeccionID;
	public String token;
	
	@Override
	public Long getId() {
		return this.id;
	}
	public void setID(Long id){
		this.id = id;
	}
	public Long getInspeccionID() {
		return inspeccionID;
	}
	public void setInspeccionID(Long inspeccionID) {
		this.inspeccionID = inspeccionID;
	}

}
