package com.diphot.siuweb.server.pesistense.daos;

import java.util.List;

import javax.jdo.PersistenceManager;

import com.diphot.siuweb.server.business.EncodedImage;
import com.diphot.siuweb.server.business.Inspeccion;
import com.diphot.siuweb.server.pesistense.DAOInterface;
import com.diphot.siuweb.server.pesistense.PMF.PMF;
import com.diphot.siuweb.shared.dtos.EncodedImageDTO;
import com.diphot.siuweb.shared.dtos.InterfaceDTO;

public class EncodedImageDAO implements DAOInterface<EncodedImage, EncodedImageDTO>{

	@Override
	public EncodedImage findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EncodedImage> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EncodedImage create(EncodedImage entity) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		pm.makePersistent(entity);
		pm.close();
		return entity;
	}

	@Override
	public List<EncodedImage> massiveCreate(List<EncodedImage> list) {
		return null;
	}

	@Override
	public EncodedImage creatFromDTO(EncodedImageDTO dto) {
		EncodedImage encodedImage = new EncodedImage(dto.getEncodedImageString());
		InspeccionDAO inspeccionDAO = new InspeccionDAO();
		Inspeccion inspeccion = inspeccionDAO.findById(dto.getInspeccionDTO().getId());
		// Creo la imagen
		//this.create(encodedImage);
		// Agrego la nueva Imagen a la Inspeccion
		inspeccion.addImage(encodedImage);
		inspeccionDAO.update(inspeccion);
		return encodedImage;
	}

	@Override
	public EncodedImage update(EncodedImage entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EncodedImage updateFromDTO(EncodedImageDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EncodedImageDTO getDTO(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EncodedImageDTO> getDTOList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InterfaceDTO getDTO(EncodedImage entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
