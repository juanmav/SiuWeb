package com.diphot.siuweb.server.pesistense;

import com.diphot.siuweb.shared.dtos.InterfaceDTO;

public class DAOFactory {

	private DAOFactory(){
		
	}
	
	public static DAOInterface<?,InterfaceDTO> getDAOImpl(Object dto){
		String clazzName = dto.getClass().getSimpleName();
		System.out.println("El dto que me llega es el siguiente: " + clazzName);
		DAOInterface<?,InterfaceDTO> dao = null;
		try {
			// TODO mejorar esto tiene que ser un archivo de configurarcion o algo similar.
			clazzName = clazzName.replace("DTO", "DAO");
			Class<DAOInterface<?, InterfaceDTO>> c = (Class<DAOInterface<?, InterfaceDTO>>) Class.forName("com.diphot.siuweb.server.pesistense.daos."+clazzName);
			dao = (DAOInterface<?, InterfaceDTO>) c.newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dao;
	}
	
}
