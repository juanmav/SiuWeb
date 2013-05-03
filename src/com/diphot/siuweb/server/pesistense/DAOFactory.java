package com.diphot.siuweb.server.pesistense;

import java.util.logging.Logger;

import com.diphot.siuweb.shared.InterfaceDTO;

public class DAOFactory {

	private static final Logger log = Logger.getLogger(DAOFactory.class.getName());
	
	private DAOFactory(){
		
	}
	
	@SuppressWarnings("unchecked")
	public static DAOInterface<?,InterfaceDTO> getDAOImpl(Object dto){
		String clazzName = dto.getClass().getSimpleName();
		System.out.println("El dto que me llega es el siguiente: " + clazzName);
		DAOInterface<?,InterfaceDTO> dao = null;
		try {
			// TODO mejorar esto tiene que ser un archivo de configurarcion o algo similar.
			clazzName = clazzName.replace("DTO", "DAO");
			Class<DAOInterface<?, InterfaceDTO>> c = (Class<DAOInterface<?, InterfaceDTO>>) Class.forName("com.diphot.siuweb.server.pesistense.daos."+clazzName);
			log.info("Nombre del Dao: ");
			log.info("com.diphot.siuweb.server.pesistense.daos."+clazzName);
			dao = (DAOInterface<?, InterfaceDTO>) c.newInstance();
		} catch (ClassNotFoundException e) {
			log.severe(e.getMessage());
			e.printStackTrace();
		} catch (InstantiationException e) {
			log.severe(e.getMessage());
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			log.severe(e.getMessage());
			e.printStackTrace();
		}
		return dao;
	}
	
}
