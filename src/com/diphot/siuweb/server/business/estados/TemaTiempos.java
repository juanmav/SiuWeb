package com.diphot.siuweb.server.business.estados;

import java.util.HashMap;

import com.diphot.siuweb.server.business.Tema;

public class TemaTiempos {

	private Tema tema;
	// id, horas.
	private HashMap<Integer, Integer> tiempos;
	
	// Por defecto.
	public TemaTiempos(Tema tema){
		this.tiempos = new HashMap<Integer, Integer>();
		this.tiempos.put(InspeccionState.INFORMADO, 2);
		this.tiempos.put(InspeccionState.ACEPTADO, 2);
		this.tiempos.put(InspeccionState.REALIZADO, 76);
		this.setTema(tema);
	}
	
	public void putTiempo(Integer indice, Integer horas){
		this.tiempos.put(indice, horas);
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
}
