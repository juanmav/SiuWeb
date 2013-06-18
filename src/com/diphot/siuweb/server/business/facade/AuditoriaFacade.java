package com.diphot.siuweb.server.business.facade;

import com.diphot.siuweb.server.business.model.Auditoria;
import com.diphot.siuweb.server.business.model.Inspeccion;
import com.diphot.siuweb.server.pesistense.daos.InspeccionDAO;
import com.diphot.siuweb.shared.dtos.AuditoriaDTO;

public class AuditoriaFacade {

	void crearAuditoria(AuditoriaDTO auditoriaDTO){
		InspeccionDAO idao = new InspeccionDAO();
		idao.begin();
		Inspeccion inspeccion = idao.findById(auditoriaDTO.getInspeccionID());
		new Auditoria(inspeccion,auditoriaDTO.getEncodedIMG1(),
				auditoriaDTO.getEncodedIMG1(),
				auditoriaDTO.getEncodedIMG1(),
				auditoriaDTO.getResuelto(), 
				auditoriaDTO.getObservaciones());
		idao.end();
	}

}
