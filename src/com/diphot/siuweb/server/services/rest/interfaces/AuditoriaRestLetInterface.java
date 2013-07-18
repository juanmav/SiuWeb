package com.diphot.siuweb.server.services.rest.interfaces;

import org.restlet.resource.Get;

import com.diphot.siuweb.shared.dtos.AuditoriaDTO;

public interface AuditoriaRestLetInterface {
	@Get
    public void create(AuditoriaDTO auditoriaDTO);
}
