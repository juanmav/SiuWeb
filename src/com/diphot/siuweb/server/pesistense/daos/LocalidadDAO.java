package com.diphot.siuweb.server.pesistense.daos;

import java.util.ArrayList;
import java.util.List;
import com.diphot.siuweb.server.business.model.Localidad;
import com.diphot.siuweb.server.pesistense.AbstractDAO;
import com.diphot.siuweb.shared.dtos.LocalidadDTO;
import com.diphot.siuweb.shared.dtos.filters.FilterInterfaceDTO;

public class LocalidadDAO extends AbstractDAO<Localidad, LocalidadDTO>{

	public LocalidadDAO() {
		super(Localidad.class);
	}

	@Override
	public List<Localidad> getList(FilterInterfaceDTO filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Localidad creatFromDTO(LocalidadDTO dto) {
		Localidad l = new Localidad(dto.getId(), dto.getNombre());
		return this.create(l);
	}

	@Override
	public Localidad updateFromDTO(LocalidadDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocalidadDTO getDTO(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocalidadDTO getDTO(Localidad entity) {
		LocalidadDTO dto = new LocalidadDTO(entity.getId(), entity.getNombre());
		return dto;
	}

	@Override
	public ArrayList<LocalidadDTO> getDTOList() {
		ArrayList<LocalidadDTO> dtos = new ArrayList<LocalidadDTO>();
		List<Localidad> localidades = getList();
		for (Localidad a : localidades){
			dtos.add((LocalidadDTO) getDTO(a));
		}
		return dtos;
	}

	@Override
	public ArrayList<LocalidadDTO> getDTOList(FilterInterfaceDTO filter) {
		// TODO Auto-generated method stub
		return null;
	}
}
