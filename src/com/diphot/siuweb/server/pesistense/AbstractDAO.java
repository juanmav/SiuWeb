package com.diphot.siuweb.server.pesistense;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import com.diphot.siuweb.server.pesistense.PMF.PMF;
import com.diphot.siuweb.shared.dtos.InterfaceDTO;
import com.diphot.siuweb.shared.dtos.filters.FilterInterfaceDTO;

public abstract class AbstractDAO <Bussines, I extends InterfaceDTO> implements DAOInterface<Bussines, I>{

	protected PersistenceManager pm;
	
	private Class<Bussines> typeParameterClass;
	
	public AbstractDAO(Class<Bussines> typeParameterClass){
		this.typeParameterClass = typeParameterClass;
	}
	
	public void begin(){
		/* Este proxy me permite trabajar siempre con el mismo manager de persistencia*/
		this.pm = PMF.get().getPersistenceManagerProxy();
	}
	
	public void end(){
		this.pm.close();
	}
	
	@Override
	public Bussines getById(Long id) {
		Bussines a = pm.getObjectById(this.typeParameterClass,id);
		return a;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bussines> getList() {
		List<Bussines> areas = (List<Bussines>) pm.newQuery(this.typeParameterClass).execute();
		return areas;
	}

	@Override
	public Bussines create(Bussines entity) {
		pm.makePersistent(entity);
		return entity;
	}

	@Override
	public ArrayList<Bussines> massiveCreate(ArrayList<Bussines> list) {
		pm.makePersistentAll(list);
		return list;
	}

	@Override
	public Bussines update(Bussines entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
	}

	@Override
	public abstract Bussines creatFromDTO(I dto);
	@Override
	public abstract Bussines updateFromDTO(I dto);
	@Override
	public abstract I getDTO(Long id);
	@Override
	public abstract I getDTO(Bussines entity);
	@Override
	public abstract ArrayList<I> getDTOList();
	@Override
	public abstract ArrayList<I> getDTOList(FilterInterfaceDTO filter);
}
