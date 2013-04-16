package com.diphot.siuweb.server;

import java.util.ArrayList;
import com.diphot.siuweb.client.services.AreaService;
import com.diphot.siuweb.server.business.Area;
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
		areas.add(new Area(1L,"SERVICIOS PÚBLICOS Y CONSERVACIÓN DE INFRAESTRUCTURA"));
		areas.add(new Area(2L,"CONTROL URBANO Y AMBIENTAL"));
		areas.add(new Area(3L,"PROTECCION CIUDADANA"));
		areas.add(new Area(4L,"INERSIÓN PÚBLICA Y PLANEAMIENTO URBANO"));
		new AreaDAO().massiveCreate(areas);
	}
}
