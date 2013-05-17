package com.diphot.siuweb.server.pesistense.daos;

import java.util.ArrayList;
import com.diphot.siuweb.server.business.estados.TemaTiempos;
import com.diphot.siuweb.server.pesistense.AbstractDAO;
import com.diphot.siuweb.shared.InterfaceDTO;
import com.diphot.siuweb.shared.dtos.filters.FilterInterfaceDTO;

public class TemaTiemposDAO extends AbstractDAO<TemaTiempos, InterfaceDTO>{

	public TemaTiemposDAO() {
		super(TemaTiempos.class);
	}

	@Override
	public TemaTiempos creatFromDTO(InterfaceDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TemaTiempos updateFromDTO(InterfaceDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InterfaceDTO getDTO(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InterfaceDTO getDTO(TemaTiempos entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InterfaceDTO> getDTOList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InterfaceDTO> getDTOList(
			FilterInterfaceDTO filter) {
		// TODO Auto-generated method stub
		return null;
	}

}
