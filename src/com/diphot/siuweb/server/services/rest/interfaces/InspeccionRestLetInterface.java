package com.diphot.siuweb.server.services.rest.interfaces;

import org.restlet.resource.Get;
import com.diphot.siuweb.shared.dtos.InspeccionDTO;

public interface InspeccionRestLetInterface {
	@Get
    public void create(InspeccionDTO inspeccionDTO);
}
