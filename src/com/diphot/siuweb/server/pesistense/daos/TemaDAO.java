package com.diphot.siuweb.server.pesistense.daos;

import java.util.ArrayList;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import com.diphot.siuweb.server.business.Tema;
import com.diphot.siuweb.server.pesistense.DAOInterface;
import com.diphot.siuweb.server.pesistense.PMF.PMF;
import com.diphot.siuweb.shared.dtos.InterfaceDTO;
import com.diphot.siuweb.shared.dtos.TemaDTO;
import com.diphot.siuweb.shared.dtos.TipoRelevamientoDTO;

public class TemaDAO implements DAOInterface<Tema, TemaDTO>{

	@Override
	public Tema findById(Long id) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Tema a = pm.getObjectById(Tema.class,id);
		// TODO ver esto, es para forzar la carga del relevamiento y la Area.
		//a.getTiporelevamiento().getArea();
		pm.close();
		return a;
	}

	@Override
	public ArrayList<Tema> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tema create(Tema entity) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Tema> massiveCreate(ArrayList<Tema> list) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		pm.makePersistentAll(list);
		return list;
	}
	@Override
	public Tema creatFromDTO(TemaDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Tema update(Tema entity) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Tema updateFromDTO(TemaDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
	}
	@Override
	public TemaDTO getDTO(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<TemaDTO> getDTOList() {
		ArrayList<TemaDTO> dtos = new ArrayList<TemaDTO>();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Tema.class);
		List<Tema> areas = (List<Tema>) q.execute();
		for (Tema a : areas){
			dtos.add((TemaDTO) getDTO(a));
		}
		pm.close();
		return dtos;
	}
	
	@Override
	public InterfaceDTO getDTO(Tema entity) {
		TemaDTO dto = new TemaDTO();
		dto.setId(entity.getId());
		dto.setNombre(entity.getNombre());
		TipoRelevamientoDTO tdto = (TipoRelevamientoDTO) new TipoRelevamientoDAO().getDTO(entity.getTiporelevamiento());
		dto.setTiporelevamientodto(tdto);
		return dto;
	}
}
