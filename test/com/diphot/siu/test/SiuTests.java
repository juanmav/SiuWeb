package com.diphot.siu.test;

import java.util.ArrayList;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

import com.diphot.siuweb.server.business.facade.AuditoriaFacade;
import com.diphot.siuweb.server.business.facade.InspeccionFacade;
import com.diphot.siuweb.server.business.model.Auditoria;
import com.diphot.siuweb.server.business.model.Inspeccion;
import com.diphot.siuweb.server.business.model.inspeccion.status.Confirmado;
import com.diphot.siuweb.server.business.model.inspeccion.status.Ejecutado;
import com.diphot.siuweb.server.business.model.inspeccion.status.InspeccionState;
import com.diphot.siuweb.server.business.model.inspeccion.status.Observado;
import com.diphot.siuweb.server.business.model.inspeccion.status.Resuelto;
import com.diphot.siuweb.shared.SiuConstants;
import com.diphot.siuweb.shared.dtos.AuditoriaDTO;
import com.diphot.siuweb.shared.dtos.InspeccionDTO;
import com.diphot.siuweb.shared.dtos.TemaDTO;
import com.diphot.siuweb.shared.dtos.filters.AuditoriaFilterDTO;
import com.diphot.siuweb.shared.dtos.filters.InspeccionFilterDTO;

public class SiuTests extends AbstractSiuTest {

	final private Long inspeccionID = 10L; 

	private void preCreacionInspecciones(){
		InspeccionFacade.create(new InspeccionDTO(inspeccionID,"Quintino",100,"Observacion", new TemaDTO(10L), 0.0, 0.0, new Date().toString(), "", "", "", SiuConstants.ALTO));
		InspeccionFacade.create(new InspeccionDTO(inspeccionID+1L,"Quintino",100,"Observacion", new TemaDTO(10L), 0.0, 0.0, new Date().toString(), "", "", "", SiuConstants.MEDIO));
		InspeccionFacade.create(new InspeccionDTO(inspeccionID+2L,"Quintino",100,"Observacion", new TemaDTO(10L), 0.0, 0.0, new Date().toString(), "", "", "", SiuConstants.MEDIO));
		InspeccionFacade.create(new InspeccionDTO(inspeccionID+3L,"Quintino",100,"Observacion", new TemaDTO(10L), 0.0, 0.0, new Date().toString(), "", "", "", SiuConstants.BAJO));
	}

	@Test
	public void TestCreateInspeccion() {
		Inspeccion i = InspeccionFacade.create(new InspeccionDTO(inspeccionID,"Quintino",100,"Observacion", new TemaDTO(10L), 0.0, 0.0, new Date().toString(), "", "", "", SiuConstants.ALTO));
		Assert.assertNotNull(i);
	}

	@Test
	public void TestCreateInspeccion2() {
		Inspeccion i = InspeccionFacade.create(new InspeccionDTO(inspeccionID,"Quintino",100,"Observacion", new TemaDTO(10L), 0.0, 0.0, new Date().toString(), "", "", "", SiuConstants.ALTO));
		Assert.assertNotNull(i);
	}

	@Test
	public void confirma(){
		preCreacionInspecciones();
		Inspeccion i = InspeccionFacade.confirmar(inspeccionID);
		Assert.assertNotNull(i);
		Assert.assertTrue(i.getState() instanceof Confirmado);
	}
	@Test
	public void ejecutada(){
		preCreacionInspecciones();
		Inspeccion i = InspeccionFacade.confirmar(inspeccionID);
		Assert.assertNotNull(i);
		i = InspeccionFacade.ejecutadaAuditable(inspeccionID);
		Assert.assertNotNull(i);
		Assert.assertTrue(i.getState() instanceof Ejecutado);
	}
	@Test
	public void createAuditoriaResuelta(){
		preCreacionInspecciones();
		Auditoria a = AuditoriaFacade.create(new AuditoriaDTO(1L, inspeccionID,null,null,null,true,""));
		Assert.assertNotNull(a);
		Inspeccion i = a.getInspeccion();
		Resuelto r = (Resuelto)i.getState();
		Assert.assertNotNull(r);
		Assert.assertEquals(i.getLastStateIdentifier(), new Integer(InspeccionState.RESUELTO));
	}

	@Test
	public void getAuditorias(){
		preCreacionInspecciones();
		Auditoria a = AuditoriaFacade.create(new AuditoriaDTO(1L, inspeccionID,null,null,null,true,""));
		Assert.assertNotNull(a);
		AuditoriaFilterDTO filter = new AuditoriaFilterDTO();
		filter.inspeccionID = inspeccionID;
		ArrayList<AuditoriaDTO> aus = AuditoriaFacade.getDTOList(filter);
		Assert.assertNotNull(aus);
		if ( aus != null)
			Assert.assertTrue(aus.size() > 0);
	}

	@Test
	public void createAuditoriaNOResuelta(){
		preCreacionInspecciones();
		Auditoria a = AuditoriaFacade.create(new AuditoriaDTO(1L, inspeccionID,null,null,null,false,""));
		Assert.assertNotNull(a);
		Inspeccion i = a.getInspeccion();
		Observado r = (Observado)i.getState();
		Assert.assertNotNull(r);
		Assert.assertEquals(i.getLastStateIdentifier(), new Integer(InspeccionState.OBSERVADO));
	}

	@Test
	public void getByQueryDTO(){
		preCreacionInspecciones();
		InspeccionFilterDTO filter = new InspeccionFilterDTO();
		filter.estadoID = InspeccionState.OBSERVADO;
		filter.riesgo = SiuConstants.ALTO; 
		ArrayList<InspeccionDTO> list = InspeccionFacade.getDTOList(filter);
		Assert.assertNotNull(list);
		// Este resultado depende del preCreate()
		Assert.assertEquals(list.size(), 1);
	}

	@Test
	public void getByQueryDTOTwo(){
		preCreacionInspecciones();
		InspeccionFilterDTO filter = new InspeccionFilterDTO();
		filter.estadoID = InspeccionState.CONFIRMADO;
		filter.riesgo = SiuConstants.MEDIO;
		InspeccionFacade.confirmar(11L);
		ArrayList<InspeccionDTO> list = InspeccionFacade.getDTOList(filter);
		Assert.assertNotNull(list);
		// Este resultado depende del preCreate()
		Assert.assertEquals(list.size(), 1);
	}

}
