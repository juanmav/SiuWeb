package com.diphot.siuweb.server.business.facade.proxy;

import java.util.ArrayList;

import com.diphot.siuweb.server.business.facade.InspeccionFacadeInterface;
import com.diphot.siuweb.server.business.facade.impl.InspeccionFacade;
import com.diphot.siuweb.server.business.model.Inspeccion;
import com.diphot.siuweb.shared.SiuConstants;
import com.diphot.siuweb.shared.dtos.InspeccionDTO;
import com.diphot.siuweb.shared.dtos.UserDTO;
import com.diphot.siuweb.shared.dtos.filters.InspeccionFilterDTO;

public class InspeccionFacadeProxy implements InspeccionFacadeInterface{

	private static InspeccionFacade impl = InspeccionFacade.getInstance();
	private static InspeccionFacadeProxy instance;
	private static UserFacadeProxy userproxy = UserFacadeProxy.getInstance();

	public static InspeccionFacadeProxy getInstance() {
		if (instance == null){
			instance = new InspeccionFacadeProxy();
		}
		return instance;
	}

	@Override
	public Inspeccion create(InspeccionDTO iDTO) {
		Inspeccion result = null;
		if (userproxy.checkLoginAndRole(iDTO.token, SiuConstants.ROLES.INSPECTOR)){
			result = impl.create(iDTO, userproxy.getUserDTOByToken(iDTO.token));
		}
		return result;
	}

	@Override
	public Inspeccion confirmar(InspeccionDTO iDTO) {
		Inspeccion result = null;
		if (userproxy.checkLoginAndRole(iDTO.token, SiuConstants.ROLES.INSPECTOR)){
			result = impl.confirmar(iDTO.getId(), userproxy.getUserDTOByToken(iDTO.token));
		}
		return result;
	}

	@Override
	public Inspeccion ejecutadaAuditable(InspeccionDTO iDTO) {
		Inspeccion result = null;
		if (userproxy.checkLoginAndRole(iDTO.token, SiuConstants.ROLES.SECRETARIA)){
			result = impl.ejecutadaAuditable(iDTO.getId(), userproxy.getUserDTOByToken(iDTO.token));
		}
		return result;
	}

	@Override
	public void verificarPlazos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<InspeccionDTO> getDTOList(UserDTO userDTO) {
		ArrayList<InspeccionDTO> lista = null;
		if (userproxy.checkLogin(userDTO.getToken())){
			lista = impl.getDTOList();
		}
		return lista;
	}

	@Override
	public ArrayList<InspeccionDTO> getDTOList(InspeccionFilterDTO filter) {
		ArrayList<InspeccionDTO> lista = null;
		if (userproxy.checkLogin(filter.token)){
			lista = impl.getDTOList();
		}
		return lista;
	}

	@Override
	public InspeccionDTO getDTOById(Long id, UserDTO userDTO) {
		InspeccionDTO result = null;
		if (userproxy.checkLogin(userDTO.getToken())){
			result = impl.getDTOById(id);
		}
		return result;
	}
}
