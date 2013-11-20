package com.diphot.siuweb.server.pesistense.daos;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Query;

import com.diphot.siuweb.server.business.model.AuditTask;
import com.diphot.siuweb.server.pesistense.AbstractDAO;
import com.diphot.siuweb.shared.dtos.AuditTaskDTO;
import com.diphot.siuweb.shared.dtos.filters.FilterInterfaceDTO;

public class AuditTaskDAO extends AbstractDAO<AuditTask, AuditTaskDTO>{

	public AuditTaskDAO() {
		super(AuditTask.class);
	}

	@Override
	public List<AuditTask> getList(FilterInterfaceDTO filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuditTask creatFromDTO(AuditTaskDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuditTask updateFromDTO(AuditTaskDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuditTaskDTO getDTO(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuditTaskDTO getDTO(AuditTask entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AuditTaskDTO> getDTOList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AuditTaskDTO> getDTOList(FilterInterfaceDTO filter) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AuditTask> getNotDoneList(){
		Query query = pm.newQuery(AuditTask.class);
		query.setFilter("realizada == realizadaParam");
		query.declareParameters("Boolean realizadaParam");
		List<AuditTask> lista =(List<AuditTask>)query.execute(false); 
		return lista;
	}
	
}
