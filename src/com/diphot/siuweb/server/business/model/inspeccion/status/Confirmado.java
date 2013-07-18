package com.diphot.siuweb.server.business.model.inspeccion.status;

import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;

import com.diphot.siuweb.server.business.model.Inspeccion;

@PersistenceCapable
public class Confirmado extends InspeccionState {
	
	
	
	public Confirmado(Date date, Inspeccion inspeccion) {
		super(date, inspeccion);
		this.code = InspeccionState.CONFIRMADO;
	}
}
