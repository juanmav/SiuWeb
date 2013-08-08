package com.diphot.siuweb.server.services.rest.impl;

import java.util.ArrayList;

import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import com.diphot.siuweb.server.business.facade.AuditoriaFacade;
import com.diphot.siuweb.server.services.rest.interfaces.AuditoriaRestLetInterface;
import com.diphot.siuweb.shared.dtos.AuditoriaDTO;
import com.diphot.siuweb.shared.dtos.filters.AuditoriaFilterDTO;

public class AuditoriaRestLetImpl extends ServerResource implements AuditoriaRestLetInterface{
	@Override
	public void create(AuditoriaDTO auditoriaDTO) {
		AuditoriaFacade.create(auditoriaDTO);
	}

	@Override
	@Post
	public ArrayList<AuditoriaDTO> getByID(Long InspeccionID) {
		AuditoriaFilterDTO filter = new AuditoriaFilterDTO();
		filter.inspeccionID = InspeccionID;
		return AuditoriaFacade.getDTOList(filter);
	}
}
