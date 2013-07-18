package com.diphot.siuweb.server.pesistense.daos;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Query;

import com.diphot.siuweb.server.business.model.Auditoria;
import com.diphot.siuweb.server.business.model.Inspeccion;
import com.diphot.siuweb.server.pesistense.AbstractDAO;
import com.diphot.siuweb.shared.InterfaceDTO;
import com.diphot.siuweb.shared.dtos.AuditoriaDTO;
import com.diphot.siuweb.shared.dtos.filters.AuditoriaFilterDTO;
import com.diphot.siuweb.shared.dtos.filters.FilterInterfaceDTO;

public class AuditoriaDAO extends AbstractDAO<Auditoria, AuditoriaDTO>{

	public AuditoriaDAO() {
		super(Auditoria.class);
	}

	@Override
	// TODO mejorar
	public List<Auditoria> getList(FilterInterfaceDTO f) {
		AuditoriaFilterDTO filter = (AuditoriaFilterDTO)f;
		ArrayList<Auditoria> result;
		InspeccionDAO idao = new InspeccionDAO();
		idao.begin();
		Inspeccion i = idao.getById(filter.inspeccionID);
		result = i.getAuditorias();
		idao.end();
		return result;
	}

	@Override
	public Auditoria creatFromDTO(AuditoriaDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Auditoria updateFromDTO(AuditoriaDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InterfaceDTO getDTO(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuditoriaDTO getDTO(Auditoria a) {
		AuditoriaDTO dto = new AuditoriaDTO(a.getId(), a.getInspeccion().getId(), 
				a.getEncodedIMG1().getEncodedImageString(), 
				a.getEncodedIMG1().getEncodedImageString(), 
				a.getEncodedIMG1().getEncodedImageString(), 
				a.getResuelto(), 
				a.getObservaciones());
		return dto;
	}

	@Override
	public ArrayList<AuditoriaDTO> getDTOList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AuditoriaDTO> getDTOList(FilterInterfaceDTO filter) {
		ArrayList<AuditoriaDTO> result = new ArrayList<AuditoriaDTO>();
		for (Auditoria a : this.getList(filter)){
			result.add(getDTO(a));
		}
		return result;
	}
}
