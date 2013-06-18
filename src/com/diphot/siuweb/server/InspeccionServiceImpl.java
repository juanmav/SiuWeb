package com.diphot.siuweb.server;

import java.util.ArrayList;
import java.util.Date;

import com.diphot.siuweb.client.services.InspeccionService;
import com.diphot.siuweb.server.business.model.EncodedImage;
import com.diphot.siuweb.server.business.model.Inspeccion;
import com.diphot.siuweb.server.pesistense.daos.EncodedImageDAO;
import com.diphot.siuweb.server.pesistense.daos.InspeccionDAO;
import com.diphot.siuweb.server.pesistense.daos.TemaDAO;
import com.diphot.siuweb.shared.dtos.EncodedImageDTO;
import com.diphot.siuweb.shared.dtos.InspeccionDTO;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class InspeccionServiceImpl extends RemoteServiceServlet implements InspeccionService{
	
	@Override
	public ArrayList<InspeccionDTO> getList() {
		return  new InspeccionDAO().getDTOList();
	}
	
	@Override
	public Long create(InspeccionDTO dto) {
		return new InspeccionDAO().creatFromDTO(dto).getId();
	}

	@Override
	public void createImage(EncodedImageDTO dto, int numero) {
		 new EncodedImageDAO().creatFromDTO(dto);
	}

	@Override
	public void examplesCreate() {
		TemaDAO temaDAO = new TemaDAO();
		InspeccionDAO iDAO = new InspeccionDAO();
		Inspeccion i = new Inspeccion();
		i.setCalle("Martin Colorado");
		i.setAltura(1500);
		i.setTema(temaDAO.findById(10L));
		i.setFecha(new Date());
		i.setLatLong(-34.42801,-58.580475);
		i.addImage(new EncodedImage(EncodedImageExamples.img1));
		i.addImage(new EncodedImage(EncodedImageExamples.img2));
		i.addImage(new EncodedImage(EncodedImageExamples.img3));
		iDAO.create(i);
	}
	
	
}
