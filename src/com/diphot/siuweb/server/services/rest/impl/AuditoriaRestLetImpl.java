package com.diphot.siuweb.server.services.rest.impl;

import java.util.ArrayList;

import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import com.diphot.siuweb.server.business.facade.proxy.AuditoriaFacadeProxy;
import com.diphot.siuweb.server.services.rest.interfaces.AuditoriaRestLetInterface;
import com.diphot.siuweb.shared.dtos.AuditoriaDTO;
import com.diphot.siuweb.shared.dtos.filters.AuditoriaFilterDTO;

public class AuditoriaRestLetImpl extends ServerResource implements AuditoriaRestLetInterface{
	@Override
	public void create(AuditoriaDTO auditoriaDTO) {
		AuditoriaFacadeProxy.getInstance().create(auditoriaDTO);
	}

	@Override
	@Post
	public ArrayList<AuditoriaDTO> getByID(AuditoriaFilterDTO filter) {
		ArrayList<AuditoriaDTO> result =AuditoriaFacadeProxy.getInstance().getDTOList(filter); 
		
		System.out.println("Devolviendo " + result.size() + " auditorias de resultados.");
		System.out.println("Devolviendo " + result);
		return result;
	}
}
