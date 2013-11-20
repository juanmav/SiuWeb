package com.diphot.siuweb.server.business.model;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.diphot.siuweb.server.pesistense.PrimaryKeyCalculator;
import com.google.appengine.datanucleus.annotations.Unowned;

@PersistenceCapable
public class AuditTask {
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String encodedKey;
	
	@Persistent
    @Extension(vendorName="datanucleus", key="gae.pk-id", value="true")
    private Long id;

	@Persistent
	private Boolean realizada;
	
	@Persistent(defaultFetchGroup = "true")
	@Unowned
	private Inspeccion inspeccion;
	
	public AuditTask(){
		this.realizada = false;
	}
	
	public Long getId() {
		return PrimaryKeyCalculator.getIDFromEKSIfIDIsNull(id,encodedKey);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getRealizada() {
		return realizada;
	}

	public void setRealizada(Boolean realizada) {
		this.realizada = realizada;
	}

	public Inspeccion getInspeccion() {
		return inspeccion;
	}

	public void setInspeccion(Inspeccion inspeccion) {
		this.inspeccion = inspeccion;
	}
}
