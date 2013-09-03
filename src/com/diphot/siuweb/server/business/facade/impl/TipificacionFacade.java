package com.diphot.siuweb.server.business.facade.impl;

import java.util.ArrayList;
import com.diphot.siuweb.server.business.facade.TipificacionFacadeInterface;
import com.diphot.siuweb.server.pesistense.daos.AreaDAO;
import com.diphot.siuweb.server.pesistense.daos.TemaDAO;
import com.diphot.siuweb.server.pesistense.daos.TipoRelevamientoDAO;
import com.diphot.siuweb.shared.dtos.AreaDTO;
import com.diphot.siuweb.shared.dtos.TemaDTO;
import com.diphot.siuweb.shared.dtos.TipoRelevamientoDTO;
import com.diphot.siuweb.shared.dtos.UserDTO;

public class TipificacionFacade {

	private static TipificacionFacade instance;

	public static TipificacionFacade getInstance() {
		if (instance == null){
			instance = new TipificacionFacade();
		}
		return instance;
	}

	private TipificacionFacade(){
		
	}
	
	
	public void createArea(AreaDTO dto){
		AreaDAO dao = new AreaDAO();
		dao.begin();
		dao.creatFromDTO(dto);
		dao.end();
	}

	
	public void createTipoRelevamiento(TipoRelevamientoDTO dto){
		TipoRelevamientoDAO dao = new TipoRelevamientoDAO();
		dao.begin();
		dao.creatFromDTO(dto);
		dao.end();
	}

	
	public void createTema(TemaDTO dto){
		TemaDAO dao = new TemaDAO();
		dao.begin();
		dao.creatFromDTO(dto);
		dao.end();
	}

	
	public ArrayList<AreaDTO> getAreasDTO(){
		AreaDAO dao = new AreaDAO(); 
		ArrayList<AreaDTO> result;
		dao.begin();
		result = dao.getDTOList();
		dao.end();
		return result;
	}

	
	public ArrayList<TipoRelevamientoDTO> getTipoRelevamientoDTO(){
		TipoRelevamientoDAO dao = new TipoRelevamientoDAO();
		ArrayList<TipoRelevamientoDTO> result;
		dao.begin();
		result = dao.getDTOList();
		dao.end();
		return result;
	}

	public ArrayList<TemaDTO> getTemasDTO(){
		TemaDAO dao = new TemaDAO();
		ArrayList<TemaDTO> result;
		dao.begin();
		result = dao.getDTOList();
		dao.end();
		return result;
	}
}
