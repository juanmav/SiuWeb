package com.diphot.siuweb.server.business.estados;

import java.util.Date;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import com.diphot.siuweb.server.business.Inspeccion;
import com.google.appengine.datanucleus.annotations.Unowned;

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.SUBCLASS_TABLE)
public abstract class InspeccionState {

	// Listado de Estados para identificarlos en la base.
	public static Integer OBSERVADO = 1;
	public static Integer INFORMADO = 2;
	public static Integer ACEPTADO = 3;
	public static Integer REALIZADO = 4;
	public static Integer REOBSERVADO = 5;
	public static Integer RESUELTO = 6;
	
	protected Date creacion;
	protected Date modificado;
	protected Date alarma;
		
	@Persistent
	@Unowned
	protected Inspeccion inspeccion;
	
	public InspeccionState(Date date, Inspeccion inspeccion){
		this.creacion = date;
		this.inspeccion = inspeccion;
	}
	
	abstract void checkState();
	abstract void nextState();
	abstract void setState(InspeccionState state);
	
	
}
