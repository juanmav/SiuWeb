package com.diphot.siuweb.server;

import java.util.ArrayList;

import com.diphot.siuweb.client.services.DiphotService;
import com.diphot.siuweb.server.pesistense.DAOFactory;
import com.diphot.siuweb.server.pesistense.DAOInterface;
import com.diphot.siuweb.shared.dtos.InterfaceDTO;
import com.diphot.siuweb.shared.dtos.filters.FilterInterfaceDTO;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class DiphotServiceImpl extends RemoteServiceServlet implements DiphotService{
	@Override
	public ArrayList<InterfaceDTO> getList(InterfaceDTO dto) {
		DAOInterface<?, InterfaceDTO> dao = DAOFactory.getDAOImpl(dto);
		return dao.getDTOList();
	}
	@Override
	public Long create(InterfaceDTO dto) {
		DAOInterface<?, InterfaceDTO> dao = DAOFactory.getDAOImpl(dto);
		dao.creatFromDTO(dto);
		return dto.getId();
	}
	@Override
	public void update(InterfaceDTO dto) {
		DAOInterface<?, InterfaceDTO> dao = DAOFactory.getDAOImpl(dto);
		dao.updateFromDTO(dto);
	}
	@Override
	public void delete(InterfaceDTO dto) {
		DAOInterface<?, InterfaceDTO> dao = DAOFactory.getDAOImpl(dto);
		dao.delete(dto.getId());
	}
	@Override
	public ArrayList<InterfaceDTO> getList(InterfaceDTO dto, FilterInterfaceDTO filter) {
		DAOInterface<?, InterfaceDTO> dao = DAOFactory.getDAOImpl(dto);
		dao.getDTOList(filter);
		return null;
	}
}
