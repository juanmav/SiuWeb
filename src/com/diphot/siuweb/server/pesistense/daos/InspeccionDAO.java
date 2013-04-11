package com.diphot.siuweb.server.pesistense.daos;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;

import com.diphot.siuweb.server.business.Inspeccion;
import com.diphot.siuweb.server.business.Tema;
import com.diphot.siuweb.server.pesistense.DAOInterface;
import com.diphot.siuweb.server.pesistense.PMF.PMF;
import com.diphot.siuweb.shared.dtos.InspeccionDTO;
import com.diphot.siuweb.shared.dtos.TemaDTO;

public class InspeccionDAO implements DAOInterface<Inspeccion, InspeccionDTO> {

	@Override
	public Inspeccion findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Inspeccion> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inspeccion create(Inspeccion entity) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		pm.makePersistent(entity);
		pm.close();
		return entity;
	}

	@Override
	public List<Inspeccion> massiveCreate(List<Inspeccion> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inspeccion creatFromDTO(InspeccionDTO dto) {
		TemaDTO temadto = dto.getTema();
		Tema tema = new TemaDAO().findById(temadto.getId());
		Inspeccion inspeccion = new Inspeccion(null, dto.getCalle(), dto.getAltura(), tema, dto.getLatitude(), dto.getLongitude());
		return this.create(inspeccion);
	}

	@Override
	public Inspeccion update(Inspeccion entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inspeccion updateFromDTO(InspeccionDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public InspeccionDTO getDTO(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InspeccionDTO> getDTOList() {
		// TODO Auto-generated method stub
		return null;
	}

}
