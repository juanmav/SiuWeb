package com.diphot.siuweb.server.pesistense.daos;

import java.util.List;
import javax.jdo.PersistenceManager;
import com.diphot.siuweb.server.business.Tema;
import com.diphot.siuweb.server.pesistense.DAOInterface;
import com.diphot.siuweb.server.pesistense.PMF.PMF;
import com.diphot.siuweb.shared.dtos.InterfaceDTO;
import com.diphot.siuweb.shared.dtos.TemaDTO;

public class TemaDAO implements DAOInterface<Tema, TemaDTO>{

	@Override
	public Tema findById(Long id) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Tema a = pm.getObjectById(Tema.class,id);
		pm.close();
		return a;
	}

	@Override
	public List<Tema> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tema create(Tema entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tema> massiveCreate(List<Tema> list) {
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
	public List<TemaDTO> getDTOList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InterfaceDTO getDTO(Tema entity) {
		TemaDTO dto = new TemaDTO();
		dto.setId(entity.getId());
		dto.setNombre(entity.getNombre());
		return dto;
	}
}
