package com.diphot.siuweb.server.business.facade.proxy;

import java.util.ArrayList;

import com.diphot.siuweb.server.business.facade.TipificacionFacadeInterface;
import com.diphot.siuweb.server.business.facade.impl.TipificacionFacade;
import com.diphot.siuweb.shared.SiuConstants;
import com.diphot.siuweb.shared.dtos.AreaDTO;
import com.diphot.siuweb.shared.dtos.TemaDTO;
import com.diphot.siuweb.shared.dtos.TipoRelevamientoDTO;
import com.diphot.siuweb.shared.dtos.UserDTO;

public class TipificacionFacadeProxy implements TipificacionFacadeInterface{

	private static TipificacionFacade impl = TipificacionFacade.getInstance();
	private static TipificacionFacadeProxy instance;
	private static UserFacadeProxy userproxy = UserFacadeProxy.getInstance();

	public static TipificacionFacadeProxy getInstance() {
		if (instance == null){
			instance = new TipificacionFacadeProxy();
		}
		return instance;
	}
	
	@Override
	public void createArea(AreaDTO dto, UserDTO admin) {
		if (userproxy.checkLoginAndRole(admin.getToken(), SiuConstants.ROLES.ADMIN)){
			impl.createArea(dto);
		}
	}

	@Override
	public void createTipoRelevamiento(TipoRelevamientoDTO dto, UserDTO admin) {
		if (userproxy.checkLoginAndRole(admin.getToken(), SiuConstants.ROLES.ADMIN)){
			impl.createTipoRelevamiento(dto);
		}
	}

	@Override
	public void createTema(TemaDTO dto, UserDTO admin) {
		if (userproxy.checkLoginAndRole(admin.getToken(), SiuConstants.ROLES.ADMIN)){
			impl.createTema(dto);
		}
	}

	@Override
	public ArrayList<AreaDTO> getAreasDTO(UserDTO admin) {
		ArrayList<AreaDTO> result = null;
		if (userproxy.checkLogin(admin.getToken())){
			result = impl.getAreasDTO();
		}
		return result;
	}

	@Override
	public ArrayList<TipoRelevamientoDTO> getTipoRelevamientoDTO(UserDTO admin) {
		ArrayList<TipoRelevamientoDTO> result = null;
		if (userproxy.checkLogin(admin.getToken())){
			result = impl.getTipoRelevamientoDTO();
		}
		return result;
	}

	@Override
	public ArrayList<TemaDTO> getTemasDTO(UserDTO admin) {
		ArrayList<TemaDTO> result = null;
		if (userproxy.checkLogin(admin.getToken())){
			result = impl.getTemasDTO();
		}
		return result;
	}
}
