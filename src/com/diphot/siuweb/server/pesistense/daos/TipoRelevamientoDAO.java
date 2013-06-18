package com.diphot.siuweb.server.pesistense.daos;

import java.util.ArrayList;
import java.util.List;

import com.diphot.siuweb.server.business.model.Area;
import com.diphot.siuweb.server.business.model.TipoRelevamiento;
import com.diphot.siuweb.server.pesistense.AbstractDAO;
import com.diphot.siuweb.shared.InterfaceDTO;
import com.diphot.siuweb.shared.dtos.AreaDTO;
import com.diphot.siuweb.shared.dtos.TipoRelevamientoDTO;
import com.diphot.siuweb.shared.dtos.filters.FilterInterfaceDTO;

public class TipoRelevamientoDAO extends AbstractDAO<TipoRelevamiento, TipoRelevamientoDTO>{

	public TipoRelevamientoDAO() {
		super(TipoRelevamiento.class);
	}

	@Override
	public TipoRelevamiento creatFromDTO(TipoRelevamientoDTO dto) {
		AreaDAO areaDAO = new AreaDAO();
		areaDAO.begin();
		Area area = areaDAO.findById(dto.getAreadto().getId());
		TipoRelevamiento tiporev = new TipoRelevamiento(null, dto.getNombre(), area);
		areaDAO.end();
		return tiporev;
	}

	@Override
	public TipoRelevamiento updateFromDTO(TipoRelevamientoDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoRelevamientoDTO getDTO(Long id) {
		return null;
	}

	@Override
	public ArrayList<TipoRelevamientoDTO> getDTOList() {
		ArrayList<TipoRelevamientoDTO> dtos = new ArrayList<TipoRelevamientoDTO>();
		List<TipoRelevamiento> areas = findAll();
		for (TipoRelevamiento a : areas){
			dtos.add((TipoRelevamientoDTO) getDTO(a));
		}
		pm.close();
		return dtos;
	}

	@Override
	public InterfaceDTO getDTO(TipoRelevamiento entity) {
		TipoRelevamientoDTO dto = new TipoRelevamientoDTO();
		dto.setId(entity.getId());
		dto.setNombre(entity.getNombre());
		AreaDTO adto = (AreaDTO) new AreaDAO().getDTO(entity.getArea());
		dto.setAreadto(adto);
		return dto;
	}

	@Override
	public ArrayList<TipoRelevamientoDTO> getDTOList(FilterInterfaceDTO filter) {
		// TODO Auto-generated method stub
		return null;
	}
}
