package com.diphot.siuweb.server.services.rest.impl;

import com.diphot.siuweb.server.business.facade.AuditoriaFacade;
import com.diphot.siuweb.server.services.rest.interfaces.AuditoriaRestLetInterface;
import com.diphot.siuweb.shared.dtos.AuditoriaDTO;

public class AuditoriaRestLetImpl implements AuditoriaRestLetInterface{
	@Override
	public void create(AuditoriaDTO auditoriaDTO) {
		AuditoriaFacade.create(auditoriaDTO);
	}
}
