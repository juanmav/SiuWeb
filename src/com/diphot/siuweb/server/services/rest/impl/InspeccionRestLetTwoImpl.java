package com.diphot.siuweb.server.services.rest.impl;

import org.restlet.resource.ServerResource;

import com.diphot.siuweb.server.business.facade.proxy.InspeccionFacadeProxy;
import com.diphot.siuweb.server.services.rest.interfaces.InspeccionRestLetInterfaceTwo;
import com.diphot.siuweb.shared.dtos.InspeccionDTO;

public class InspeccionRestLetTwoImpl extends ServerResource implements InspeccionRestLetInterfaceTwo{

	@Override
	public void confirmar(InspeccionDTO inspeccionDTO) {
		InspeccionFacadeProxy.getInstance().confirmar(inspeccionDTO);
	}
	@Override
	public void ejecutadaAuditable(InspeccionDTO inspeccionDTO) {
		InspeccionFacadeProxy.getInstance().ejecutadaAuditable(inspeccionDTO);
	}

}
