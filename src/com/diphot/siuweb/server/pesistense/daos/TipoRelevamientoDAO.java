package com.diphot.siuweb.server.pesistense.daos;

import java.util.List;
import javax.jdo.PersistenceManager;
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
		TipoRelevamiento a = pm.getObjectById(TipoRelevamiento.class,id);
		pm.close();
		return a;
	}

	@Override
	public List<TipoRelevamiento> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoRelevamiento create(TipoRelevamiento entity) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		return pm.makePersistent(entity);
	}

	@Override
	public List<TipoRelevamiento> massiveCreate(List<TipoRelevamiento> list) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoRelevamientoDTO> getDTOList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InterfaceDTO getDTO(TipoRelevamiento entity) {
		// TODO Auto-generated method stub
		return null;
	}
}
