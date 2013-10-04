package com.diphot.siu.test;

import org.junit.Assert;
import org.junit.Test;

import com.diphot.siuweb.server.pesistense.daos.LocalidadDAO;
import com.diphot.siuweb.shared.dtos.LocalidadDTO;

public class LocalidadTest extends AbstractSiuTest{

	@Test
	public void TestCreate(){
		LocalidadDAO ldao = new LocalidadDAO();
		ldao.begin();
		ldao.creatFromDTO(new LocalidadDTO(1L, "Benavídez"));
		ldao.creatFromDTO(new LocalidadDTO(2L, "Delta de Tigre"));
		ldao.creatFromDTO(new LocalidadDTO(3L, "Dique Luján"));
		ldao.creatFromDTO(new LocalidadDTO(4L, "Don Torcuato"));
		ldao.creatFromDTO(new LocalidadDTO(5L, "El Talar"));
		ldao.creatFromDTO(new LocalidadDTO(6L, "General Pacheco"));
		ldao.creatFromDTO(new LocalidadDTO(7L, "Nordelta"));
		ldao.creatFromDTO(new LocalidadDTO(8L, "Ricardo Rojas"));
		ldao.creatFromDTO(new LocalidadDTO(9L, "Rincón de Milberg"));
		ldao.creatFromDTO(new LocalidadDTO(10L, "Tigre"));
		ldao.creatFromDTO(new LocalidadDTO(11L, "Troncos del Talar"));
		Assert.assertTrue(ldao.getList().size() > 3);
		Assert.assertTrue(ldao.getDTOList().size() > 3);
		ldao.end();
	}

}
