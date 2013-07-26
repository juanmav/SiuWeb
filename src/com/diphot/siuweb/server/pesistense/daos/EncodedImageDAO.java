package com.diphot.siuweb.server.pesistense.daos;

import java.util.ArrayList;
import java.util.List;

import com.diphot.siuweb.server.business.model.EncodedImage;
import com.diphot.siuweb.server.business.model.Inspeccion;
import com.diphot.siuweb.server.pesistense.AbstractDAO;
import com.diphot.siuweb.shared.dtos.EncodedImageDTO;
import com.diphot.siuweb.shared.dtos.InterfaceDTO;
import com.diphot.siuweb.shared.dtos.filters.FilterInterfaceDTO;

public class EncodedImageDAO extends AbstractDAO<EncodedImage, EncodedImageDTO>{

	public EncodedImageDAO() {
		super(EncodedImage.class);
	}

	@Override
	public EncodedImage creatFromDTO(EncodedImageDTO dto) {
		EncodedImage encodedImage = new EncodedImage(dto.getEncodedImageString());
		InspeccionDAO inspeccionDAO = new InspeccionDAO();
		inspeccionDAO.begin();
		Inspeccion inspeccion = inspeccionDAO.getById(dto.getInspeccionDTO().getId());
		inspeccion.addImage(encodedImage);
		inspeccionDAO.update(inspeccion);
		inspeccionDAO.end();
		return encodedImage;
	}

	@Override
	public EncodedImage updateFromDTO(EncodedImageDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EncodedImageDTO getDTO(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<EncodedImageDTO> getDTOList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InterfaceDTO getDTO(EncodedImage entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<EncodedImageDTO> getDTOList(FilterInterfaceDTO filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EncodedImage> getList(FilterInterfaceDTO filter) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
