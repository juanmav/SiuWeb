package com.diphot.siuweb.server.pesistense.daos;

import java.util.ArrayList;
import java.util.List;
import com.diphot.siuweb.server.business.model.Auditoria;
import com.diphot.siuweb.server.business.model.Inspeccion;
import com.diphot.siuweb.server.pesistense.AbstractDAO;
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
	public AuditoriaDTO getDTO(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuditoriaDTO getDTO(Auditoria a) {
		AuditoriaDTO dto = new AuditoriaDTO(a.getId(), a.getInspeccion().getId(), 
				(( a.getEncodedIMG1() != null ) ? a.getEncodedIMG1().getEncodedImageString() : null), 
				(( a.getEncodedIMG2() != null ) ? a.getEncodedIMG2().getEncodedImageString() : null), 
				(( a.getEncodedIMG3() != null ) ? a.getEncodedIMG3().getEncodedImageString() : null), 
				a.getResuelto(), 
				a.getObservaciones());
		dto.setFecha(a.getFecha().toString());
		return dto;
	}

	@Override
	public ArrayList<AuditoriaDTO> getDTOList() {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*
	 * Se Utiliza directamente el InspeccionDAO aca sin usar el this.getlist para evitar el cierre
	 * de la transaccion y poder armar los DTO's correctamente.
	 * */
	@Override
	public ArrayList<AuditoriaDTO> getDTOList(FilterInterfaceDTO filter) {
		ArrayList<AuditoriaDTO> result = new ArrayList<AuditoriaDTO>();
		ArrayList<Auditoria> list;
		AuditoriaFilterDTO f = (AuditoriaFilterDTO) filter;
		InspeccionDAO idao = new InspeccionDAO();
		idao.begin();
		Inspeccion i = idao.getById(f.inspeccionID);
		list = i.getAuditorias();
		for (Auditoria a : list){
			result.add(getDTO(a));
		}
		idao.end();
		return result;
	}
}
