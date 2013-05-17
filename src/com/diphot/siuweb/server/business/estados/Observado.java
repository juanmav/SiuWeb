package com.diphot.siuweb.server.business.estados;

import java.util.Date;

import com.diphot.siuweb.server.business.Inspeccion;

public class Observado extends InspeccionState {

	public Observado(Date date, Inspeccion inspeccion) {
		super(date, inspeccion);
	}

	@Override
	void checkState() {
		// Enviar Mail con aviso.
		this.nextState();
	}

	@Override
	void nextState() {
				
	}

	@Override
	void setState(InspeccionState state) {
		// TODO Auto-generated method stub
		
	}

}
