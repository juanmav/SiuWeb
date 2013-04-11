package com.diphot.siuweb.server;

import java.util.ArrayList;
import com.diphot.siuweb.client.services.InspeccionService;
import com.diphot.siuweb.server.pesistense.daos.EncodedImageDAO;
import com.diphot.siuweb.server.pesistense.daos.InspeccionDAO;
import com.diphot.siuweb.shared.dtos.EncodedImageDTO;
import com.diphot.siuweb.shared.dtos.InspeccionDTO;

public class InspeccionServiceImpl implements InspeccionService{
	
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
}
