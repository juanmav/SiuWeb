package com.diphot.siuweb.server.business.facade;

import java.util.ArrayList;
import com.diphot.siuweb.shared.dtos.AreaDTO;
import com.diphot.siuweb.shared.dtos.TemaDTO;
import com.diphot.siuweb.shared.dtos.TipoRelevamientoDTO;
import com.diphot.siuweb.shared.dtos.UserDTO;

public interface TipificacionFacadeInterface {
	public void createArea(AreaDTO dto, UserDTO admin);
	public void createTipoRelevamiento(TipoRelevamientoDTO dto, UserDTO admin);
	public void createTema(TemaDTO dto, UserDTO admin);
	public ArrayList<AreaDTO> getAreasDTO(UserDTO admin);
	public ArrayList<TipoRelevamientoDTO> getTipoRelevamientoDTO(UserDTO admin);
	public ArrayList<TemaDTO> getTemasDTO(UserDTO admin);
}
