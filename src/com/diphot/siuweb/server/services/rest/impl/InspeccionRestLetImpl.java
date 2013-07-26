package com.diphot.siuweb.server.services.rest.impl;

import java.util.ArrayList;
import org.restlet.resource.Get;
import org.restlet.resource.Options;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;
import com.diphot.siuweb.server.business.facade.InspeccionFacade;
import com.diphot.siuweb.server.services.rest.interfaces.InspeccionRestLetInterface;
import com.diphot.siuweb.shared.dtos.InspeccionDTO;
import com.diphot.siuweb.shared.dtos.filters.InspeccionFilterDTO;

public class InspeccionRestLetImpl extends ServerResource implements InspeccionRestLetInterface{
	@Override
	@Post
	public void create(InspeccionDTO inspeccionDTO) {
		InspeccionFacade.create(inspeccionDTO);
	}
	@Override
	@Get
	public ArrayList<InspeccionDTO> getList(InspeccionFilterDTO filter) {
		ArrayList<InspeccionDTO> result = InspeccionFacade.getDTOList(filter);
		System.out.println("Devolviendo " + result.size() + " resultados.");
		System.out.println("Devolviendo " + result);
		return result;
	}
	@Override
	@Put
	public void confirmar(Long id) {
		InspeccionFacade.confirmar(id);
	}
	@Override
	@Options
	public void ejecutadaAuditable(Long id) {
		InspeccionFacade.ejecutadaAuditable(id);
	}

	
}
