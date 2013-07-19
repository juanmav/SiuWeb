package com.diphot.siuweb.server.business.facade;

import java.util.ArrayList;
import com.diphot.siuweb.server.business.model.Inspeccion;
import com.diphot.siuweb.server.pesistense.daos.InspeccionDAO;
import com.diphot.siuweb.shared.dtos.InspeccionDTO;
import com.diphot.siuweb.shared.dtos.filters.InspeccionFilterDTO;

public class InspeccionFacade {

	public static Inspeccion create(InspeccionDTO iDTO){
		Inspeccion result;
		InspeccionDAO idao = new InspeccionDAO();
		idao.begin();
		result = idao.creatFromDTO(iDTO);
		idao.end();
		return result;
	}

	public static Inspeccion confirmar(Long id){
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
	
	public static Inspeccion ejecutadaAuditable(Long id){
		InspeccionDAO idao = new InspeccionDAO();
		idao.begin();
		Inspeccion result = idao.getById(id);
		result.ejecutadaAuditable();
		idao.end();
		return result;
	}

	public static void verificarPlazos(){
		InspeccionDAO idao = new InspeccionDAO();
		idao.begin();


		idao.end();
	}

	public static ArrayList<InspeccionDTO> getDTOList(){
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
	public static ArrayList<InspeccionDTO> getDTOList(InspeccionFilterDTO filter){
		ArrayList<InspeccionDTO> result = new ArrayList<InspeccionDTO>();
		InspeccionDAO idao = new InspeccionDAO();
		idao.begin();
		result = idao.getDTOList(filter);
		idao.end();
		return result;
	}
	
	public static Inspeccion getById(Long id){
		InspeccionDAO idao = new InspeccionDAO();
		Inspeccion result;
		idao.begin();
		result = idao.getById(id);
		idao.end();
		return result;
	}
	
	public static InspeccionDTO getDTOById(Long id){
		InspeccionDAO idao = new InspeccionDAO();
		InspeccionDTO result;
		idao.begin();
		result = idao.getDTO(id);
		idao.end();
		return result;
	}
}
