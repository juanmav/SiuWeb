package com.diphot.siuweb.server.services.rest.interfaces;

import java.util.ArrayList;

import org.restlet.resource.Get;
import org.restlet.resource.Post;

import com.diphot.siuweb.shared.dtos.AuditoriaDTO;

public interface AuditoriaRestLetInterface {
	@Get
    public void create(AuditoriaDTO auditoriaDTO);
	@Post
	public ArrayList<AuditoriaDTO> getByID(Long InspeccionID);
}
