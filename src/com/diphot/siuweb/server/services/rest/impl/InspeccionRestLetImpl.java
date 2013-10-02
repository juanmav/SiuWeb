package com.diphot.siuweb.server.services.rest.impl;

import java.util.ArrayList;
import org.restlet.resource.ServerResource;
import com.diphot.siuweb.server.business.facade.proxy.InspeccionFacadeProxy;
import com.diphot.siuweb.server.services.rest.interfaces.InspeccionRestLetInterface;
import com.diphot.siuweb.shared.dtos.InspeccionDTO;
import com.diphot.siuweb.shared.dtos.filters.InspeccionFilterDTO;

public class InspeccionRestLetImpl extends ServerResource implements InspeccionRestLetInterface{
	@Override
	public void create(InspeccionDTO inspeccionDTO) {
		InspeccionFacadeProxy.getInstance().create(inspeccionDTO);
	}
	@Override
	public ArrayList<InspeccionDTO> getList(InspeccionFilterDTO filter) {
		ArrayList<InspeccionDTO> result = InspeccionFacadeProxy.getInstance().getDTOList(filter);
		System.out.println("Devolviendo " + result.size() + " inspecciones de resultados.");
		System.out.println("Devolviendo " + result);
		return result;
	}
	

	
}
