package com.diphot.siuweb.server;

import java.util.ArrayList;
import com.diphot.siuweb.client.services.AreaService;
import com.diphot.siuweb.server.business.model.Area;
import com.diphot.siuweb.server.pesistense.daos.AreaDAO;
import com.diphot.siuweb.shared.dtos.AreaDTO;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class AreaServiceImpl extends RemoteServiceServlet implements AreaService {

	@Override
	public ArrayList<AreaDTO> getList() {
		return new AreaDAO().getDTOList();
	}

	@Override
	public void create(AreaDTO dto) {
		new AreaDAO().creatFromDTO(dto);
		
	}

	@Override
	public void populateINIT() {
		ArrayList<Area> areas = new ArrayList<Area>();
		areas.add(new Area(1L,"SERVICIOS PÚBLICOS"));
		areas.add(new Area(2L,"CONTROL URBANO"));
		areas.add(new Area(3L,"PROTECCION CIUDADANA"));
		areas.add(new Area(4L,"INSERCIÓN PÚBLICA"));
		AreaDAO areaDAO = new AreaDAO();
		areaDAO.begin();
		areaDAO.massiveCreate(areas);
		areaDAO.end();
	}
}
