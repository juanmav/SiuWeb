package com.diphot.siuweb.server.business.model.inspeccion.status;

import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;

import com.diphot.siuweb.server.business.model.Inspeccion;

@PersistenceCapable
public class Resuelto extends InspeccionState{

	public Resuelto(Date date, Inspeccion inspeccion) {
		// TODO Auto-generated constructor stub
		super(date, inspeccion);
		this.code = InspeccionState.RESUELTO;
	}
	public String toString(){
		return "RESUELTO";
	}
}
