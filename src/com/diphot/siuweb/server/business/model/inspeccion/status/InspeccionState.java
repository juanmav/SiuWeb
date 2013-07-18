package com.diphot.siuweb.server.business.model.inspeccion.status;

import java.util.Date;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.diphot.siuweb.server.business.model.Inspeccion;
import com.google.appengine.datanucleus.annotations.Unowned;

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.SUBCLASS_TABLE)
public abstract class InspeccionState {
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String encodedKey;
	@Persistent
    @Extension(vendorName="datanucleus", key="gae.pk-id", value="true")
    private Long id;
	
	//Listado de Estados para identificarlos en la base.
	final public static int OBSERVADO = 1;
	final public static int CONFIRMADO = 2;
	final public static int EJECUTADO = 3;
	final public static int RESUELTO = 4;

	@Persistent
	protected Integer code;
	
	@Persistent
	protected Date creacion;
			
	@Persistent
	@Unowned
	protected Inspeccion inspeccion;
	
	public InspeccionState(Date date, Inspeccion inspeccion){
		this.creacion = date;
		this.inspeccion = inspeccion;
	}
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer identifier) {
		this.code = identifier;
	}
}
