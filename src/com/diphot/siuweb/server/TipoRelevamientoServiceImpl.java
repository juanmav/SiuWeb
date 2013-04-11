package com.diphot.siuweb.server;

import java.util.ArrayList;

import com.diphot.siuweb.client.services.TipoRelevamientoService;
import com.diphot.siuweb.server.business.Area;
import com.diphot.siuweb.server.business.TipoRelevamiento;
import com.diphot.siuweb.server.pesistense.daos.AreaDAO;
import com.diphot.siuweb.server.pesistense.daos.TipoRelevamientoDAO;
import com.diphot.siuweb.shared.dtos.TipoRelevamientoDTO;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class TipoRelevamientoServiceImpl extends RemoteServiceServlet implements TipoRelevamientoService{

	@Override
	public ArrayList<TipoRelevamientoDTO> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(TipoRelevamientoDTO dto) {
		// TODO Auto-generated method stub
	}

	@Override
	public void populateINIT() {
		AreaDAO adao = new AreaDAO();
		TipoRelevamientoDAO tdao = new TipoRelevamientoDAO();
		ArrayList<TipoRelevamiento> tipos = new ArrayList<TipoRelevamiento>();
		
		
		// Servicios Publicos
		Area area = adao.findById(1L);
		tipos.add(new TipoRelevamiento(1L, "Vía Pública en General", area));
		tipos.add(new TipoRelevamiento(2L, "Arbolado", area));
		tipos.add(new TipoRelevamiento(3L, "Alumbrado", area));
		tipos.add(new TipoRelevamiento(4L, "Servicio Eléctrico", area));
		tipos.add(new TipoRelevamiento(5L, "Semáforos", area));
		tipos.add(new TipoRelevamiento(6L, "URGENCIA", area));
		
		// Control urbano
		area = adao.findById(2L);
		tipos.add(new TipoRelevamiento(7L, "Vía Pública en General", area));
		
		// Proteccion
		area = adao.findById(3L);
		tipos.add(new TipoRelevamiento(8L, "Vía Pública en General", area));
		tipos.add(new TipoRelevamiento(9L, "Urgencia", area));
		
		// Insercion
		area = adao.findById(4L);
		tipos.add(new TipoRelevamiento(10L, "Obras", area));
		
		tdao.massiveCreate(tipos);
		
	}
}
