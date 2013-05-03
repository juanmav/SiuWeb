package com.diphot.siuweb.server.pesistense.daos;

import java.util.ArrayList;
import java.util.List;
import com.diphot.siuweb.server.business.Tema;
import com.diphot.siuweb.server.pesistense.AbstractDAO;
import com.diphot.siuweb.shared.dtos.InterfaceDTO;
import com.diphot.siuweb.shared.dtos.TemaDTO;
import com.diphot.siuweb.shared.dtos.TipoRelevamientoDTO;
import com.diphot.siuweb.shared.dtos.filters.FilterInterfaceDTO;

public class TemaDAO extends AbstractDAO<Tema, TemaDTO>{

	public TemaDAO() {
		super(Tema.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Tema creatFromDTO(TemaDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Tema updateFromDTO(TemaDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public TemaDTO getDTO(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<TemaDTO> getDTOList() {
		ArrayList<TemaDTO> dtos = new ArrayList<TemaDTO>();
		List<Tema> areas = findAll();
		for (Tema a : areas){
			dtos.add((TemaDTO) getDTO(a));
		}
		return dtos;
	}
	
	@Override
	public InterfaceDTO getDTO(Tema entity) {
		TemaDTO dto = new TemaDTO();
		dto.setId(entity.getId());
		dto.setNombre(entity.getNombre());
		TipoRelevamientoDTO tdto = (TipoRelevamientoDTO) new TipoRelevamientoDAO().getDTO(entity.getTiporelevamiento());
		dto.setTiporelevamientodto(tdto);
		return dto;
	}

	@Override
	public ArrayList<TemaDTO> getDTOList(FilterInterfaceDTO filter) {
		// TODO Auto-generated method stub
		return null;
	}
}
