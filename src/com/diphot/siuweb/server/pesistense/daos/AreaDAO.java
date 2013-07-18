package com.diphot.siuweb.server.pesistense.daos;

import java.util.ArrayList;
import java.util.List;

import com.diphot.siuweb.server.business.model.Area;
import com.diphot.siuweb.server.pesistense.AbstractDAO;
import com.diphot.siuweb.shared.InterfaceDTO;
import com.diphot.siuweb.shared.dtos.AreaDTO;
import com.diphot.siuweb.shared.dtos.filters.FilterInterfaceDTO;

public class AreaDAO extends AbstractDAO<Area, AreaDTO>{

	public AreaDAO() {
		super(Area.class);
	}

	@Override
	public Area creatFromDTO(AreaDTO dto) {
		Area a = new Area();
		a.setNombre(dto.getNombre());
		return this.create(a);
	}

	@Override
	public Area updateFromDTO(AreaDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AreaDTO getDTO(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AreaDTO> getDTOList() {
		ArrayList<AreaDTO> dtos = new ArrayList<AreaDTO>();
		List<Area> areas = getList();
		for (Area a : areas){
			dtos.add((AreaDTO) getDTO(a));
		}
		return dtos;
	}
	
	@Override
	public InterfaceDTO getDTO(Area entity) {
		AreaDTO dto = new AreaDTO(entity.getId(), entity.getNombre());
		return dto;
	}

	@Override
	public ArrayList<AreaDTO> getDTOList(FilterInterfaceDTO filter) {
		// TODO implementar FILTROS.
		return getDTOList();
	}

	@Override
	public List<Area> getList(FilterInterfaceDTO filter) {
		// TODO Auto-generated method stub
		return null;
	}
}
