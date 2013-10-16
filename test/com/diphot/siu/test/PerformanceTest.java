package com.diphot.siu.test;

import org.junit.Test;

import junit.framework.Assert;

import com.diphot.siuweb.server.business.facade.impl.InspeccionFacade;
import com.diphot.siuweb.shared.dtos.InspeccionDTO;

public class PerformanceTest extends AbstractSiuTest {

	@Test
	public void DTOwithImage(){
		preCreacionInspecciones();
		InspeccionDTO idto = InspeccionFacade.getInstance().getDTOById(inspeccionID);
		Assert.assertNotNull(idto.getImg1());
	}
}
