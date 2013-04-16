package com.diphot.siuweb.server.pesistense.daos;

import java.util.ArrayList;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import com.diphot.siuweb.server.business.Area;
import com.diphot.siuweb.server.pesistense.DAOInterface;
import com.diphot.siuweb.server.pesistense.PMF.PMF;
import com.diphot.siuweb.shared.dtos.AreaDTO;
import com.diphot.siuweb.shared.dtos.InterfaceDTO;

public class AreaDAO implements DAOInterface<Area, AreaDTO>{

	@Override
	public Area findById(Long id) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Area a = pm.getObjectById(Area.class,id);
		pm.close();
		return a;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Area> findAll() {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		ArrayList<Area> areas = (ArrayList<Area>) pm.getObjectById(Area.class);
		return areas;
	}

	@Override
	public Area create(Area entity) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		pm.makePersistent(entity);
		pm.close();
		return entity;
	}

	@Override
	public Area creatFromDTO(AreaDTO dto) {
		Area a = new Area();
		a.setNombre(dto.getNombre());
		return this.create(a);
	}

	@Override
	public Area update(Area entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Area updateFromDTO(AreaDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
	}

	@Override
	public AreaDTO getDTO(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<AreaDTO> getDTOList() {
		ArrayList<AreaDTO> dtos = new ArrayList<AreaDTO>();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Area.class);
		List<Area> areas = (List<Area>) q.execute();
		for (Area a : areas){
			dtos.add((AreaDTO) getDTO(a));
		}
		pm.close();
		return dtos;
	}

	@Override
	public ArrayList<Area> massiveCreate(ArrayList<Area> list) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		pm.makePersistentAll(list);
		return list;
	}

	@Override
	public InterfaceDTO getDTO(Area entity) {
		AreaDTO dto = new AreaDTO(entity.getId(), entity.getNombre());
		return dto;
	}
}
