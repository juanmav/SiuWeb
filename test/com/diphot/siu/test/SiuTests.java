package com.diphot.siu.test;

import java.util.ArrayList;
import junit.framework.Assert;

import org.junit.Test;

import com.diphot.siuweb.server.business.facade.impl.AuditoriaFacade;
import com.diphot.siuweb.server.business.facade.impl.InspeccionFacade;
import com.diphot.siuweb.server.business.model.Auditoria;
import com.diphot.siuweb.server.business.model.Inspeccion;
import com.diphot.siuweb.server.business.model.inspeccion.status.Confirmado;
import com.diphot.siuweb.server.business.model.inspeccion.status.Ejecutado;
import com.diphot.siuweb.server.business.model.inspeccion.status.InspeccionState;
import com.diphot.siuweb.server.business.model.inspeccion.status.Observado;
import com.diphot.siuweb.server.business.model.inspeccion.status.Resuelto;
import com.diphot.siuweb.server.pesistense.daos.InspeccionDAO;
import com.diphot.siuweb.shared.SiuConstants;
import com.diphot.siuweb.shared.dtos.AuditoriaDTO;
import com.diphot.siuweb.shared.dtos.InspeccionDTO;
import com.diphot.siuweb.shared.dtos.LocalidadDTO;
import com.diphot.siuweb.shared.dtos.TemaDTO;
import com.diphot.siuweb.shared.dtos.filters.AuditoriaFilterDTO;
import com.diphot.siuweb.shared.dtos.filters.InspeccionFilterDTO;

public class SiuTests extends AbstractSiuTest {

	@Test
	public void testComplexFilter(){
		preCreacionInspecciones();
		InspeccionFilterDTO filter = new InspeccionFilterDTO();
		filter.estadoID = InspeccionState.CONFIRMADO;
		filter.riesgo = SiuConstants.ALTO;
		filter.localidadID = 2L;
		filter.desde = "10/10/2013";
		filter.hasta = "12/10/2013";
		Inspeccion i = InspeccionFacade.getInstance().confirmar(inspeccionID,null);
		ArrayList<InspeccionDTO> list = InspeccionFacade.getInstance().getDTOList(filter);
		Assert.assertNotNull(list);
		// Este resultado depende del preCreate()
		Assert.assertEquals(list.size(), 1);
		Assert.assertEquals(list.get(0).getLocalidad().getId(), filter.localidadID);
	}
	
	@Test
	public void TestCreateInspeccion() {
		InspeccionDTO idto = new InspeccionDTO(inspeccionID,"Quintino",100,"Observacion", new TemaDTO(10L), 0.0, 0.0, "11/10/2013", "", "", "", SiuConstants.ALTO);
		idto.setLocalidad(new LocalidadDTO(2L,""));
		idto.setEntreCalleUno("Calle1");
		idto.setEntreCalleUno("Calle2");
		Inspeccion i = InspeccionFacade.getInstance().create(idto,null);
		Assert.assertNotNull(i);
	}

	@Test
	public void TestCreateInspeccion2() {
		InspeccionDTO idto = new InspeccionDTO(null,"Quintino",100,"Observacion", new TemaDTO(10L), 0.0, 0.0, "11/10/2013", "", "", "", SiuConstants.BAJO);
		idto.setLocalidad(new LocalidadDTO(2L,""));
		idto.setEntreCalleUno("Calle1");
		idto.setEntreCalleUno("Calle2");
		Inspeccion i = InspeccionFacade.getInstance().create(idto,null);
		Assert.assertNotNull(i);
	}

	@Test
	public void confirma(){
		preCreacionInspecciones();
		Inspeccion i = InspeccionFacade.getInstance().confirmar(inspeccionID,null);
		Assert.assertNotNull(i);
		Assert.assertTrue(i.getState() instanceof Confirmado);
	}
	@Test
	public void ejecutada(){
		preCreacionInspecciones();
		Inspeccion i = InspeccionFacade.getInstance().confirmar(inspeccionID,null);
		Assert.assertNotNull(i);
		i = InspeccionFacade.getInstance().ejecutadaAuditable(inspeccionID,null);
		Assert.assertNotNull(i);
		Assert.assertTrue(i.getState() instanceof Ejecutado);
	}
	@Test
	public void createAuditoriaResuelta(){
		preCreacionInspecciones();
		Auditoria a = AuditoriaFacade.getInstance().create(new AuditoriaDTO(1L, inspeccionID,null,null,null,true,""),null);
		Assert.assertNotNull(a);
		Inspeccion i = a.getInspeccion();
		Resuelto r = (Resuelto)i.getState();
		Assert.assertNotNull(r);
		Assert.assertEquals(i.getLastStateIdentifier(), new Integer(InspeccionState.RESUELTO));
	}

	@Test
	public void getAuditorias(){
		preCreacionInspecciones();
		Auditoria a = AuditoriaFacade.getInstance().create(new AuditoriaDTO(1L, inspeccionID,null,null,null,true,""),null);
		Assert.assertNotNull(a);
		AuditoriaFilterDTO filter = new AuditoriaFilterDTO();
		filter.inspeccionID = inspeccionID;
		ArrayList<AuditoriaDTO> aus = AuditoriaFacade.getInstance().getDTOList(filter);
		Assert.assertNotNull(aus);
		if ( aus != null)
			Assert.assertTrue(aus.size() > 0);
	}

	@Test
	public void createAuditoriaNOResuelta(){
		preCreacionInspecciones();
		Auditoria a = AuditoriaFacade.getInstance().create(new AuditoriaDTO(1L, inspeccionID,null,null,null,false,""),null);
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
		ArrayList<InspeccionDTO> list = InspeccionFacade.getInstance().getDTOList(filter);
		Assert.assertNotNull(list);
		// Este resultado depende del preCreate()
		Assert.assertEquals(list.size(), 1);
	}

	@Test
	public void getByQueryDTOTwo(){
		preCreacionInspecciones();
		InspeccionFilterDTO filter = new InspeccionFilterDTO();
		filter.estadoID = InspeccionState.CONFIRMADO;
		filter.riesgo = SiuConstants.ALTO;
		InspeccionFacade.getInstance().confirmar(inspeccionID,null);
		ArrayList<InspeccionDTO> list = InspeccionFacade.getInstance().getDTOList(filter);
		Assert.assertNotNull(list);
		// Este resultado depende del preCreate()
		Assert.assertEquals(list.size(), 1);
	}

	@Test
	public void testEntreCalle(){
		preCreacionInspecciones();
		InspeccionDAO idao = new InspeccionDAO();
		idao.begin();
		ArrayList<InspeccionDTO> ilist = idao.getDTOList();
		for (InspeccionDTO idto : ilist){
			Assert.assertNotNull(idto.getEntreCalleUno());
			Assert.assertNotNull(idto.getEntreCalleDos());
		}
		idao.end();
	}
	
	
}
