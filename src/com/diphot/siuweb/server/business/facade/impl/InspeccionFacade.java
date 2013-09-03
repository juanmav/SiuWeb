package com.diphot.siuweb.server.business.facade.impl;

import java.util.ArrayList;
import com.diphot.siuweb.server.business.model.Inspeccion;
import com.diphot.siuweb.server.pesistense.daos.InspeccionDAO;
import com.diphot.siuweb.shared.dtos.InspeccionDTO;
import com.diphot.siuweb.shared.dtos.UserDTO;
import com.diphot.siuweb.shared.dtos.filters.InspeccionFilterDTO;

public class InspeccionFacade {

	private static InspeccionFacade instance;
	
	public static InspeccionFacade getInstance() {
		if (instance == null){
			instance = new InspeccionFacade();
		}
		return instance;
	}
	
	private InspeccionFacade(){
		
	}
	
	public Inspeccion create(InspeccionDTO iDTO, UserDTO userdto){
		Inspeccion result;
		InspeccionDAO idao = new InspeccionDAO();
		idao.begin();
		result = idao.creatFromDTO(iDTO);
		idao.end();
		return result;
	}

	public Inspeccion confirmar(Long id, UserDTO userdto){
		InspeccionDAO idao = new InspeccionDAO();
		idao.begin();
		Inspeccion result = idao.getById(id);
		result.confirmar();
		idao.end();
		return result;
	}

	
	/*
	 * Este metodo es llamado cuando la secretaria pone como ejecutada la Inspeccion
	 * o Cuando se dispara la revision de plazos.
	 * 
	 * */
	
	public Inspeccion ejecutadaAuditable(Long id,UserDTO userdto){
		InspeccionDAO idao = new InspeccionDAO();
		idao.begin();
		Inspeccion result = idao.getById(id);
		result.ejecutadaAuditable();
		idao.end();
		return result;
	}

	public void verificarPlazos(){
		InspeccionDAO idao = new InspeccionDAO();
		idao.begin();


		idao.end();
	}

	public ArrayList<InspeccionDTO> getDTOList(){
		ArrayList<InspeccionDTO> result;
		InspeccionDAO idao = new InspeccionDAO();
		idao.begin();
		result = idao.getDTOList();
		idao.end();
		return result;
	}
	
	/**
	 * Solo acepta Estado y Riesgo por el momento
	 * */
	public ArrayList<InspeccionDTO> getDTOList(InspeccionFilterDTO filter){
		ArrayList<InspeccionDTO> result = new ArrayList<InspeccionDTO>();
		InspeccionDAO idao = new InspeccionDAO();
		idao.begin();
		result = idao.getDTOList(filter);
		idao.end();
		return result;
	}
	
	public Inspeccion getById(Long id){
		InspeccionDAO idao = new InspeccionDAO();
		Inspeccion result;
		idao.begin();
		result = idao.getById(id);
		idao.end();
		return result;
	}
	
	public InspeccionDTO getDTOById(Long id){
		InspeccionDAO idao = new InspeccionDAO();
		InspeccionDTO result;
		idao.begin();
		result = idao.getDTO(id);
		idao.end();
		return result;
	}
}
