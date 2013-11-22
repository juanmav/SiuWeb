package com.diphot.siuweb.server.services.rest.impl;

import java.util.ArrayList;

import org.restlet.resource.ServerResource;
import com.diphot.siuweb.server.business.facade.proxy.AuditoriaFacadeProxy;
import com.diphot.siuweb.server.services.rest.interfaces.AuditoriaRestLetInterfaceTwo;
import com.diphot.siuweb.shared.dtos.InspeccionDTO;

public class AuditoriaRestLetTwoImpl extends ServerResource implements AuditoriaRestLetInterfaceTwo{
	@Override
	public ArrayList<InspeccionDTO> getInspeccionesToAuditar(InspeccionDTO inspeccionDTO) {
		return AuditoriaFacadeProxy.getInstance().getInspeccionesToAuditar(inspeccionDTO);
	}
}
