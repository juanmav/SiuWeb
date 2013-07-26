package com.diphot.siuweb.server.business.facade;

import java.util.ArrayList;

import com.diphot.siuweb.server.business.model.Auditoria;
import com.diphot.siuweb.server.business.model.EncodedImage;
import com.diphot.siuweb.server.business.model.Inspeccion;
import com.diphot.siuweb.server.pesistense.daos.AuditoriaDAO;
import com.diphot.siuweb.server.pesistense.daos.InspeccionDAO;
import com.diphot.siuweb.shared.dtos.AuditoriaDTO;
import com.diphot.siuweb.shared.dtos.filters.AuditoriaFilterDTO;

public class AuditoriaFacade {

	public static Auditoria create(AuditoriaDTO dto){
		InspeccionDAO idao = new InspeccionDAO();
		idao.begin();
		Inspeccion inspeccion = idao.getById(dto.getInspeccionID());
		Auditoria result = new Auditoria(dto.getId(),inspeccion,dto.getResuelto(),dto.getObservaciones());
		if (dto.getImg1() != null && !dto.getImg1().equals(""))
			result.addImage(new EncodedImage(dto.getImg1()));
		if (dto.getImg2() != null && !dto.getImg2().equals(""))
			result.addImage(new EncodedImage(dto.getImg2()));
		if (dto.getImg3() != null && !dto.getImg3().equals(""))
			result.addImage(new EncodedImage(dto.getImg3()));
		idao.end();
		return result;
	}
	
	public static ArrayList<AuditoriaDTO> getDTOList(AuditoriaFilterDTO filter){
		AuditoriaDAO adao = new AuditoriaDAO();
		ArrayList<AuditoriaDTO> result;
		adao.begin();
		result = adao.getDTOList(filter);
		adao.end();
		return result;
	}
}
