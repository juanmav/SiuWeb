package com.diphot.siu.test;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.diphot.siuweb.server.business.facade.proxy.AuditoriaFacadeProxy;
import com.diphot.siuweb.server.business.facade.proxy.InspeccionFacadeProxy;
import com.diphot.siuweb.server.business.facade.proxy.UserFacadeProxy;
import com.diphot.siuweb.server.business.facade.proxy.exception.NotLoginException;
import com.diphot.siuweb.server.business.model.Auditoria;
import com.diphot.siuweb.server.business.model.Inspeccion;
import com.diphot.siuweb.server.business.model.inspeccion.status.InspeccionState;
import com.diphot.siuweb.shared.SiuConstants;
import com.diphot.siuweb.shared.dtos.AuditoriaDTO;
import com.diphot.siuweb.shared.dtos.InspeccionDTO;
import com.diphot.siuweb.shared.dtos.TemaDTO;
import com.diphot.siuweb.shared.dtos.UserDTO;

public class ProxysTest extends AbstractSiuTest{

	@Test
	public void createInspeccion(){
		UserDTO udto = UserFacadeProxy.getInstance().login("juanma", "asdf69");
		InspeccionDTO idto = new InspeccionDTO(10L,"Quintino",100,"Observacion", new TemaDTO(10L), 0.0, 0.0, new Date().toString(), "", "", "", SiuConstants.ALTO);
		idto.token = udto.getToken();
		Inspeccion i = InspeccionFacadeProxy.getInstance().create(idto);
		Assert.assertNotNull(i);
	}
	
	@Test
	// Trata de crear sin loguearse tiene que fallar.
	public void createInspeccionFAIL(){
		InspeccionDTO idto = new InspeccionDTO(10L,"Quintino",100,"Observacion", new TemaDTO(10L), 0.0, 0.0, new Date().toString(), "", "", "", SiuConstants.ALTO);
		try {
			InspeccionFacadeProxy.getInstance().create(idto);
			// Si llega a este punto fallo la prueba.
			Assert.assertTrue(false);
		} catch (NotLoginException e){
			// Si arroja la excepcion es correto!.
			Assert.assertNotNull(e);
		}
	}
	
	@Test
	public void InspeccionLifeCicle(){
		UserDTO udto = UserFacadeProxy.getInstance().login("juanma", "asdf69");
		InspeccionDTO idto = new InspeccionDTO(10L,"Quintino",100,"Observacion", new TemaDTO(10L), 0.0, 0.0, new Date().toString(), "", "", "", SiuConstants.ALTO);
		idto.token = udto.getToken();
		
		// Creo Inspeccion.
		Inspeccion i = InspeccionFacadeProxy.getInstance().create(idto);
		
		// Confirmo Inspeccion solo paso ID y Token.
		InspeccionDTO simpleIDTO = new InspeccionDTO();
		simpleIDTO.setId(i.getId());
		simpleIDTO.token = udto.getToken();
		
		i = InspeccionFacadeProxy.getInstance().confirmar(simpleIDTO);
		Assert.assertNotNull(i);
		Assert.assertTrue(i.getLastStateIdentifier() == InspeccionState.CONFIRMADO);
		
		// Ejecuto.
		i = InspeccionFacadeProxy.getInstance().ejecutadaAuditable(simpleIDTO);
		Assert.assertNotNull(i);
		Assert.assertTrue(i.getLastStateIdentifier() == InspeccionState.EJECUTADO);
		
		// Audito
		AuditoriaDTO adto = new AuditoriaDTO(null, i.getId(),null,null,null,true,"");
		adto.token = udto.getToken();
		Auditoria a = AuditoriaFacadeProxy.getInstance().create(adto);
		Assert.assertNotNull(a);
	}
	
}
