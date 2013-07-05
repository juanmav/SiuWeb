package com.diphot.siuweb.server.business.facade;

import java.util.Date;

import com.diphot.siuweb.server.business.model.Inspeccion;
import com.diphot.siuweb.server.business.model.inspeccion.status.Confirmado;
import com.diphot.siuweb.server.business.model.inspeccion.status.Ejecutado;
import com.diphot.siuweb.server.business.model.inspeccion.status.Observado;
import com.diphot.siuweb.server.pesistense.daos.InspeccionDAO;
import com.diphot.siuweb.shared.dtos.InspeccionDTO;

public class InspeccionFacade {

	public static void InspeccionCreate(InspeccionDTO iDTO){
		InspeccionDAO idao = new InspeccionDAO();
		idao.begin();
		idao.creatFromDTO(iDTO);
		idao.end();
	}
	
	public static void confirmar(Long id){
		InspeccionDAO idao = new InspeccionDAO();
		idao.begin();
		Inspeccion inspeccion = idao.findById(id);
		// Paso al siguiente Estado
		if (inspeccion.getState() instanceof Observado){
			inspeccion.setState(new Confirmado(new Date(), inspeccion));
		}
		idao.end();
	}
	
	public static void ejecutada(Long id){
		InspeccionDAO idao = new InspeccionDAO();
		idao.begin();
		Inspeccion inspeccion = idao.findById(id);
		// Paso al siguiente Estado
		if (inspeccion.getState() instanceof Confirmado){
			inspeccion.setState(new Ejecutado(new Date(), inspeccion));
		}
		idao.end();
	}
	
	public static void verificarPlazos(){
		InspeccionDAO idao = new InspeccionDAO();
		idao.begin();
		
		
		
		idao.end();
	}
	
}
