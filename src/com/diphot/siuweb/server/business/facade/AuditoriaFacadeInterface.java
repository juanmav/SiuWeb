package com.diphot.siuweb.server.business.facade;

import java.util.ArrayList;

import com.diphot.siuweb.server.business.model.Auditoria;
import com.diphot.siuweb.shared.dtos.AuditoriaDTO;
import com.diphot.siuweb.shared.dtos.UserDTO;
import com.diphot.siuweb.shared.dtos.filters.AuditoriaFilterDTO;

public interface AuditoriaFacadeInterface {
	public Auditoria create(AuditoriaDTO dto);
	public ArrayList<AuditoriaDTO> getDTOList(AuditoriaFilterDTO filter);
}
