package com.diphot.siuweb.server;

import java.util.ArrayList;

import com.diphot.siuweb.client.services.TipoRelevamientoService;
import com.diphot.siuweb.server.business.model.Area;
import com.diphot.siuweb.server.business.model.TipoRelevamiento;
import com.diphot.siuweb.server.pesistense.daos.AreaDAO;
import com.diphot.siuweb.server.pesistense.daos.TipoRelevamientoDAO;
import com.diphot.siuweb.shared.dtos.TipoRelevamientoDTO;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class TipoRelevamientoServiceImpl extends RemoteServiceServlet implements TipoRelevamientoService{

	@Override
	public ArrayList<TipoRelevamientoDTO> getList() {
		return new TipoRelevamientoDAO().getDTOList();
	}

	@Override
	public void create(TipoRelevamientoDTO dto) {
		// TODO Auto-generated method stub
	}

	@Override
	public void populateINIT() {
		AreaDAO adao = new AreaDAO();
		adao.begin();
			
		// Servicios Publicos
		Area area = adao.getById(1L);
		new TipoRelevamiento(1L, "V�a P�blica en General", area);
		new TipoRelevamiento(2L, "Arbolado", area);
		new TipoRelevamiento(3L, "Alumbrado", area);
		new TipoRelevamiento(4L, "Servicio El�ctrico", area);
		new TipoRelevamiento(5L, "Sem�foros", area);
		new TipoRelevamiento(6L, "URGENCIA", area);
		
		// Control urbano
		area = adao.getById(2L);
		new TipoRelevamiento(7L, "V�a P�blica en General", area);
		
		// Proteccion
		area = adao.getById(3L);
		new TipoRelevamiento(8L, "V�a P�blica en General", area);
		new TipoRelevamiento(9L, "Urgencia", area);
		
		// Insercion
		area = adao.getById(4L);
		new TipoRelevamiento(10L, "Obras", area);
		
		adao.end();
	}
}
