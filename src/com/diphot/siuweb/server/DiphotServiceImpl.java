package com.diphot.siuweb.server;

import java.util.ArrayList;

import com.diphot.siuweb.client.services.DiphotService;
import com.diphot.siuweb.server.pesistense.DAOFactory;
import com.diphot.siuweb.server.pesistense.DAOInterface;
import com.diphot.siuweb.shared.InterfaceDTO;
import com.diphot.siuweb.shared.dtos.filters.FilterInterfaceDTO;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class DiphotServiceImpl extends RemoteServiceServlet implements DiphotService{
	
	@Override
	public ArrayList<InterfaceDTO> getList(InterfaceDTO dto) {
		DAOInterface<?, InterfaceDTO> dao = DAOFactory.getDAOImpl(dto);
		dao.begin();
		ArrayList<InterfaceDTO> list = dao.getDTOList();
		dao.end();
		return list;
	}
	@Override
	public Long create(InterfaceDTO dto) {
		DAOInterface<?, InterfaceDTO> dao = DAOFactory.getDAOImpl(dto);
		dao.begin();
		dao.creatFromDTO(dto);
		dao.end();
		return dto.getId();
	}
	@Override
	public void update(InterfaceDTO dto) {
		DAOInterface<?, InterfaceDTO> dao = DAOFactory.getDAOImpl(dto);
		dao.begin();
		dao.updateFromDTO(dto);
		dao.end();
	}
	@Override
	public void delete(InterfaceDTO dto) {
		DAOInterface<?, InterfaceDTO> dao = DAOFactory.getDAOImpl(dto);
		dao.begin();
		dao.delete(dto.getId());
		dao.end();
	}
	@Override
	public ArrayList<InterfaceDTO> getList(InterfaceDTO dto, FilterInterfaceDTO filter) {
		DAOInterface<?, InterfaceDTO> dao = DAOFactory.getDAOImpl(dto);
		dao.begin();
		ArrayList<InterfaceDTO> list = dao.getDTOList(filter);
		dao.end();
		return list;
	}
}
