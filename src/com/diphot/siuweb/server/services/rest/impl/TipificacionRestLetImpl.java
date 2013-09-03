package com.diphot.siuweb.server.services.rest.impl;

import java.util.ArrayList;
import org.restlet.resource.ServerResource;
import com.diphot.siuweb.server.business.facade.proxy.TipificacionFacadeProxy;
import com.diphot.siuweb.server.services.rest.interfaces.TipificacionRestLetInterface;
import com.diphot.siuweb.shared.dtos.AreaDTO;
import com.diphot.siuweb.shared.dtos.TemaDTO;
import com.diphot.siuweb.shared.dtos.TipoRelevamientoDTO;
import com.diphot.siuweb.shared.dtos.UserDTO;

public class TipificacionRestLetImpl extends ServerResource implements TipificacionRestLetInterface{

	@Override
	public ArrayList<AreaDTO> getAreas(UserDTO userdto) {
		return TipificacionFacadeProxy.getInstance().getAreasDTO(userdto);
	}

	@Override
	public ArrayList<TipoRelevamientoDTO> getTiposRelevamiento(UserDTO userdto) {
		return TipificacionFacadeProxy.getInstance().getTipoRelevamientoDTO(userdto);
	}

	@Override
	public ArrayList<TemaDTO> getTemas(UserDTO userdto) {
		return TipificacionFacadeProxy.getInstance().getTemasDTO(userdto);
	}
}
