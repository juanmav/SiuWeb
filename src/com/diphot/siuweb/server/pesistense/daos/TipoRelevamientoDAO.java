package com.diphot.siuweb.server.pesistense.daos;

import java.util.ArrayList;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.diphot.siuweb.server.business.Area;
import com.diphot.siuweb.server.business.TipoRelevamiento;
import com.diphot.siuweb.server.pesistense.DAOInterface;
import com.diphot.siuweb.server.pesistense.PMF.PMF;
import com.diphot.siuweb.shared.dtos.AreaDTO;
import com.diphot.siuweb.shared.dtos.InterfaceDTO;
import com.diphot.siuweb.shared.dtos.TipoRelevamientoDTO;

public class TipoRelevamientoDAO implements DAOInterface<TipoRelevamiento, TipoRelevamientoDTO>{

	@Override
	public TipoRelevamiento findById(Long id) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		TipoRelevamiento tipo = pm.getObjectById(TipoRelevamiento.class,id);
		// TODO ver esto es para forzar la carga del area.
		//Area a = tipo.getArea();
		pm.close();
		return tipo;
	}

	@Override
	public ArrayList<TipoRelevamiento> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoRelevamiento create(TipoRelevamiento entity) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		return pm.makePersistent(entity);
	}

	@Override
	public ArrayList<TipoRelevamiento> massiveCreate(ArrayList<TipoRelevamiento> list) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		pm.makePersistentAll(list);
		return list;
	}

	@Override
	public TipoRelevamiento creatFromDTO(TipoRelevamientoDTO dto) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		TipoRelevamiento tiporev = new TipoRelevamiento();
		tiporev.setNombre(dto.getNombre());
		AreaDAO areaDao = new AreaDAO();
		AreaDTO areadto = dto.getAreadto();
		Area area = areaDao.findById(areadto.getId());
		tiporev.setArea(area);
		pm.makePersistent(tiporev);
		return tiporev;
	}

	
	@Override
	public TipoRelevamiento update(TipoRelevamiento entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoRelevamiento updateFromDTO(TipoRelevamientoDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TipoRelevamientoDTO getDTO(Long id) {
		return null;
	}

	@Override
	public ArrayList<TipoRelevamientoDTO> getDTOList() {
		ArrayList<TipoRelevamientoDTO> dtos = new ArrayList<TipoRelevamientoDTO>();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(TipoRelevamiento.class);
		List<TipoRelevamiento> areas = (List<TipoRelevamiento>) q.execute();
		for (TipoRelevamiento a : areas){
			dtos.add((TipoRelevamientoDTO) getDTO(a));
		}
		pm.close();
		return dtos;
	}

	@Override
	public InterfaceDTO getDTO(TipoRelevamiento entity) {
		TipoRelevamientoDTO dto = new TipoRelevamientoDTO();
		if (entity != null){
			dto.setId(entity.getId());
			dto.setNombre(entity.getNombre());
			AreaDTO adto = (AreaDTO) new AreaDAO().getDTO(entity.getArea());
			dto.setAreadto(adto);
		} else {
			dto.setId(-1L);
			dto.setNombre("Algo paso en la DB");
		}
		return dto;
	}
}
