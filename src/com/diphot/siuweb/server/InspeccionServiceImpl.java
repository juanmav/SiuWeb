package com.diphot.siuweb.server;

import java.util.ArrayList;
import java.util.Date;

import com.diphot.siuweb.client.services.InspeccionService;
import com.diphot.siuweb.server.business.facade.AuditoriaFacade;
import com.diphot.siuweb.server.business.facade.InspeccionFacade;
import com.diphot.siuweb.server.business.model.EncodedImage;
import com.diphot.siuweb.server.business.model.Inspeccion;
import com.diphot.siuweb.server.pesistense.daos.EncodedImageDAO;
import com.diphot.siuweb.server.pesistense.daos.InspeccionDAO;
import com.diphot.siuweb.server.pesistense.daos.TemaDAO;
import com.diphot.siuweb.shared.SiuConstants;
import com.diphot.siuweb.shared.dtos.AuditoriaDTO;
import com.diphot.siuweb.shared.dtos.EncodedImageDTO;
import com.diphot.siuweb.shared.dtos.InspeccionDTO;
import com.diphot.siuweb.shared.dtos.TemaDTO;
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
		Long inspeccionID = 10L;
		InspeccionFacade.create(new InspeccionDTO(inspeccionID,"Quintino",100,"Observacion", new TemaDTO(10L), 0.0, 0.0, new Date().toString(), null, null, null, SiuConstants.ALTO));
		//InspeccionFacade.create(new InspeccionDTO(inspeccionID+1L,"Quintino",100,"Observacion", new TemaDTO(10L), 0.0, 0.0, "", "", "", "", SiuConstants.MEDIO));
		//InspeccionFacade.create(new InspeccionDTO(inspeccionID+2L,"Quintino",100,"Observacion", new TemaDTO(10L), 0.0, 0.0, "", "", "", "", SiuConstants.MEDIO));
		//InspeccionFacade.create(new InspeccionDTO(inspeccionID+3L,"Quintino",100,"Observacion", new TemaDTO(10L), 0.0, 0.0, "", "", "", "", SiuConstants.BAJO));
		InspeccionFacade.confirmar(10L);
		InspeccionFacade.ejecutadaAuditable(10L);//*/
		AuditoriaFacade.create(new AuditoriaDTO(1L, 10L,null,null,null,true,""));
	}
	
	
}
