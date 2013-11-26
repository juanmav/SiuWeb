package com.diphot.siuweb.server.business.facade.impl;

import java.util.ArrayList;
import java.util.List;

import com.diphot.siuweb.server.business.model.AuditTask;
import com.diphot.siuweb.server.business.model.Auditoria;
import com.diphot.siuweb.server.business.model.EncodedImage;
import com.diphot.siuweb.server.business.model.Inspeccion;
import com.diphot.siuweb.server.mailer.AuditoriaMailer;
import com.diphot.siuweb.server.pesistense.daos.AuditTaskDAO;
import com.diphot.siuweb.server.pesistense.daos.AuditoriaDAO;
import com.diphot.siuweb.server.pesistense.daos.InspeccionDAO;
import com.diphot.siuweb.shared.SiuConstants;
import com.diphot.siuweb.shared.dtos.AuditoriaDTO;
import com.diphot.siuweb.shared.dtos.InspeccionDTO;
import com.diphot.siuweb.shared.dtos.UserDTO;
import com.diphot.siuweb.shared.dtos.filters.AuditTaskFilterDTO;
import com.diphot.siuweb.shared.dtos.filters.AuditoriaFilterDTO;

public class AuditoriaFacade {

	private static AuditoriaFacade instance;

	public static AuditoriaFacade getInstance() {
		if (instance == null){
			instance = new AuditoriaFacade();
		}
		return instance;
	}

	private AuditoriaFacade(){

	}


	public Auditoria create(AuditoriaDTO dto, UserDTO userdto){
		InspeccionDAO idao = new InspeccionDAO();
		idao.begin();
		Inspeccion inspeccion = idao.getById(dto.getInspeccionID());
		Auditoria result = new Auditoria(dto.getId(),inspeccion,dto.getResuelto(),dto.getObservaciones());
		if (dto.getImg1() != null && !dto.getImg1().equals("")){
			result.addImage(new EncodedImage(dto.getImg1()));
		}	
		if (dto.getImg2() != null && !dto.getImg2().equals("")){
			result.addImage(new EncodedImage(dto.getImg2()));
		}
		if (dto.getImg3() != null && !dto.getImg3().equals("")){
			result.addImage(new EncodedImage(dto.getImg3()));
		}
		// Damn lazy load
		// TODO ver como corregir esto. Queda Acomplado.
		result.getInspeccion().getLocalidad();
		result.getInspeccion().getTema();
		result.getInspeccion().getEncodedIMG1();
		result.getInspeccion().getEncodedIMG2();
		result.getInspeccion().getEncodedIMG3();
		result.getInspeccion().getEncodedMap();
		AuditoriaMailer.notifyChange(result, SiuConstants.ACTION.RESUELTO);	
		idao.end();
		
		AuditTaskDAO autdao = new AuditTaskDAO();
		autdao.begin();
		
		AuditTaskFilterDTO autFilterDTO = new AuditTaskFilterDTO();
		autFilterDTO.inspeccionID = dto.getInspeccionID();
		
		List<AuditTask> l = autdao.getList(autFilterDTO);
		AuditTask auTask = l.get(0);
		auTask.setRealizada(true);
		autdao.end();
		
		return result;
	}

	public ArrayList<AuditoriaDTO> getDTOList(AuditoriaFilterDTO filter){
		AuditoriaDAO adao = new AuditoriaDAO();
		ArrayList<AuditoriaDTO> result;
		adao.begin();
		result = adao.getDTOList(filter);
		adao.end();
		return result;
	}
	
	public AuditTask createAuditTask(Long  inspeccionID){
		AuditTask atask = new AuditTask();
		InspeccionDAO idao = new InspeccionDAO();
		AuditTaskDAO atDAO = new AuditTaskDAO();
		idao.begin();atDAO.begin();
		Inspeccion i = idao.getById(inspeccionID);
		atask.setInspeccion(i);
		atDAO.create(atask);
		idao.end();atDAO.end();
		return atask;
	}
	
	public ArrayList<InspeccionDTO> getInspeccionesParaAuditar(){
		AuditTaskDAO autdao = new AuditTaskDAO();
		ArrayList<InspeccionDTO> result = new ArrayList<InspeccionDTO>();
		InspeccionDAO idao = new InspeccionDAO();
		autdao.begin();idao.begin();
		List<AuditTask> lista = autdao.getNotDoneList();
		for (AuditTask at : lista){
			result.add(idao.getDTO(at.getInspeccion()));
		}
		autdao.end();idao.end();
		return result;
	}


}
