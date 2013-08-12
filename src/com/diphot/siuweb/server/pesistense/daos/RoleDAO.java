package com.diphot.siuweb.server.pesistense.daos;

import java.util.ArrayList;
import java.util.List;

import com.diphot.siuweb.server.business.model.Role;
import com.diphot.siuweb.server.pesistense.AbstractDAO;
import com.diphot.siuweb.shared.dtos.RoleDTO;
import com.diphot.siuweb.shared.dtos.filters.FilterInterfaceDTO;

public class RoleDAO extends AbstractDAO<Role, RoleDTO>{

	public RoleDAO() {
		super(Role.class);
	}

	@Override
	public List<Role> getList(FilterInterfaceDTO filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role creatFromDTO(RoleDTO dto) {
		Role r = new Role(dto.getId(), dto.getName());
		return null;
	}

	@Override
	public Role updateFromDTO(RoleDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleDTO getDTO(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleDTO getDTO(Role entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<RoleDTO> getDTOList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<RoleDTO> getDTOList(FilterInterfaceDTO filter) {
		// TODO Auto-generated method stub
		return null;
	}


}
