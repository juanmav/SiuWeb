package com.diphot.siuweb.server.services.rest.impl;

import org.restlet.resource.ServerResource;
import com.diphot.siuweb.server.business.facade.InspeccionFacade;
import com.diphot.siuweb.server.services.rest.interfaces.InspeccionRestLetInterface;
import com.diphot.siuweb.shared.dtos.InspeccionDTO;

public class InspeccionRestLetImpl extends ServerResource implements InspeccionRestLetInterface{
	@Override
	public void create(InspeccionDTO inspeccionDTO) {
		InspeccionFacade.InspeccionCreate(inspeccionDTO);
	}
}
