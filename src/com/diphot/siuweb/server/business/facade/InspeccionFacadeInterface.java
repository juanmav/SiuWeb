package com.diphot.siuweb.server.business.facade;

import java.util.ArrayList;

import com.diphot.siuweb.server.business.model.Inspeccion;
import com.diphot.siuweb.shared.dtos.InspeccionDTO;
import com.diphot.siuweb.shared.dtos.UserDTO;
import com.diphot.siuweb.shared.dtos.filters.InspeccionFilterDTO;

public interface InspeccionFacadeInterface {

	public  Inspeccion create(InspeccionDTO iDTO);
	public  Inspeccion confirmar(InspeccionDTO iDTO);
	public  Inspeccion ejecutadaAuditable(InspeccionDTO iDTO);
	public  void verificarPlazos();
	public  ArrayList<InspeccionDTO> getDTOList(UserDTO userDTO);
	public  ArrayList<InspeccionDTO> getDTOList(InspeccionFilterDTO filter);
	public  InspeccionDTO getDTOById(InspeccionFilterDTO filter);

}
