package com.diphot.siuweb.server.services.rest.impl;

import java.util.ArrayList;

import org.restlet.resource.ServerResource;
import com.diphot.siuweb.server.business.facade.InspeccionFacade;
import com.diphot.siuweb.server.services.rest.interfaces.InspeccionRestLetInterface;
import com.diphot.siuweb.shared.dtos.InspeccionDTO;
import com.diphot.siuweb.shared.dtos.filters.InspeccionFilterDTO;

public class InspeccionRestLetImpl extends ServerResource implements InspeccionRestLetInterface{
	@Override
	public void create(InspeccionDTO inspeccionDTO) {
		InspeccionFacade.create(inspeccionDTO);
	}

	@Override
	public void confirmar(Long id) {
		InspeccionFacade.confirmar(id);
	}

	@Override
	public void ejecutadaAuditable(Long id) {
		InspeccionFacade.ejecutadaAuditable(id);
	}

	@Override
	public ArrayList<InspeccionDTO> getDTOByQuery(InspeccionFilterDTO filter) {
		return InspeccionFacade.getDTOList(filter);
	}
}
