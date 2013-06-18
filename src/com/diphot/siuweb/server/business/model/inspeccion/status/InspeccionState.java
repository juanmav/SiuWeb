package com.diphot.siuweb.server.business.model.inspeccion.status;

import java.util.Date;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import com.diphot.siuweb.server.business.model.Inspeccion;
import com.google.appengine.datanucleus.annotations.Unowned;

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.SUBCLASS_TABLE)
public abstract class InspeccionState {

	// Listado de Estados para identificarlos en la base.
	/*public static Integer OBSERVADO = 1;
	public static Integer CONFIRMADO = 2;
	public static Integer EJECUTADO = 3;
	public static Integer RESUELTO = 4;*/
	
	@Persistent
	protected Date creacion;
			
	@Persistent
	@Unowned
	protected Inspeccion inspeccion;
	
	public InspeccionState(Date date, Inspeccion inspeccion){
		this.creacion = date;
		this.inspeccion = inspeccion;
	}
}
