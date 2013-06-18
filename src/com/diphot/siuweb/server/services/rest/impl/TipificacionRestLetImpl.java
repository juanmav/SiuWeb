package com.diphot.siuweb.server.services.rest.impl;

import java.util.ArrayList;
import org.restlet.resource.ServerResource;

import com.diphot.siuweb.server.business.facade.TipificacionFacade;
import com.diphot.siuweb.server.services.rest.interfaces.TipificacionRestLetInterface;
import com.diphot.siuweb.shared.dtos.AreaDTO;
import com.diphot.siuweb.shared.dtos.TemaDTO;
import com.diphot.siuweb.shared.dtos.TipoRelevamientoDTO;

public class TipificacionRestLetImpl extends ServerResource implements TipificacionRestLetInterface{

	@Override
	public ArrayList<AreaDTO> getAreas() {
		return TipificacionFacade.getAreasDTO();
	}

	@Override
	public ArrayList<TipoRelevamientoDTO> getTiposRelevamiento() {
		return TipificacionFacade.getTipoRelevamientoDTO();
	}

	@Override
	public ArrayList<TemaDTO> getTemas() {
		return TipificacionFacade.getTemasDTO();
	}
}
