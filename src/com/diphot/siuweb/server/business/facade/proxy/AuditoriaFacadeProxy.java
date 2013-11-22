package com.diphot.siuweb.server.business.facade.proxy;

import java.util.ArrayList;

import com.diphot.siuweb.server.business.facade.AuditoriaFacadeInterface;
import com.diphot.siuweb.server.business.facade.impl.AuditoriaFacade;
import com.diphot.siuweb.server.business.model.Auditoria;
import com.diphot.siuweb.shared.SiuConstants;
import com.diphot.siuweb.shared.dtos.AuditoriaDTO;
import com.diphot.siuweb.shared.dtos.InspeccionDTO;
import com.diphot.siuweb.shared.dtos.filters.AuditoriaFilterDTO;

public class AuditoriaFacadeProxy implements AuditoriaFacadeInterface{
	
	
	private static AuditoriaFacade impl = AuditoriaFacade.getInstance();
	private static AuditoriaFacadeProxy instance;
	private static UserFacadeProxy userproxy = UserFacadeProxy.getInstance();

	public static AuditoriaFacadeProxy getInstance() {
		if (instance == null){
			instance = new AuditoriaFacadeProxy();
		}
		return instance;
	}
	
	@Override
	public Auditoria create(AuditoriaDTO adto) {
		Auditoria result = null;
		if (userproxy.checkLoginAndRole(adto.token, SiuConstants.ROLES.INSPECTOR)){
			result = impl.create(adto, userproxy.getUserDTOByToken(adto.token));
		}
		return result;
	}

	@Override
	public ArrayList<AuditoriaDTO> getDTOList(AuditoriaFilterDTO filter) {
		ArrayList<AuditoriaDTO> lista = null;
		if (userproxy.checkLogin(filter.token)){
			lista = impl.getDTOList(filter);
		}
		return lista;
	}

	public void createAuditTask(InspeccionDTO inspeccionDTO) {
		if (userproxy.checkLoginAndRole(inspeccionDTO.token, SiuConstants.ROLES.SUPERVISOR)){
			impl.createAuditTask(inspeccionDTO.getId());
		}	
	}
	
	public ArrayList<InspeccionDTO> getInspeccionesToAuditar(InspeccionDTO inspeccionDTO){
		ArrayList<InspeccionDTO> result = null;
		if (userproxy.checkLoginAndRole(inspeccionDTO.token, SiuConstants.ROLES.SUPERVISOR) || 
			userproxy.checkLoginAndRole(inspeccionDTO.token, SiuConstants.ROLES.INSPECTOR) ){
			result = impl.getInspeccionesParaAuditar();
		}
		return result;
	}
}
