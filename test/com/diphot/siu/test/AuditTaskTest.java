package com.diphot.siu.test;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import com.diphot.siuweb.server.business.facade.impl.AuditoriaFacade;
import com.diphot.siuweb.server.business.model.AuditTask;
import com.diphot.siuweb.server.pesistense.daos.AuditTaskDAO;
import com.diphot.siuweb.shared.dtos.InspeccionDTO;

public class AuditTaskTest extends AbstractSiuTest {

	
	@Test
	public void createTaskTest(){
		preCreacionInspecciones();
		AuditTask at = AuditoriaFacade.getInstance().createAuditTask(inspeccionID);
		Long id = at.getId();

		AuditTaskDAO atdao = new AuditTaskDAO();
		atdao.begin();
		AuditTask at2 = atdao.getById(id);
		Assert.assertNotNull(at2);

		List<AuditTask> lista = atdao.getList();

		Assert.assertNotNull(lista);

		Assert.assertTrue(lista.size() > 0);

		atdao.end();
	}

	@Test
	public void getInspeccionToAudit(){
		preCreacionInspecciones();
		AuditTask at = AuditoriaFacade.getInstance().createAuditTask(inspeccionID);
		ArrayList<InspeccionDTO> lista = AuditoriaFacade.getInstance().getInspeccionesParaAuditar();
		
		Assert.assertNotNull(lista);
		Assert.assertTrue(lista.size() > 0);

	}
	
	@Test
	public void testFind(){
		preCreacionInspecciones();
		
		AuditTask at = AuditoriaFacade.getInstance().createAuditTask(inspeccionID);
		Long id = at.getId();
		AuditTaskDAO atdao = new AuditTaskDAO();
		atdao.begin();
		List<AuditTask> list= atdao.getNotDoneList();
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size() > 0);
		atdao.end();
	}


}
