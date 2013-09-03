package com.diphot.siuweb.server.business.facade.impl;

import com.diphot.siuweb.server.business.facade.UserFacadeInterface;
import com.diphot.siuweb.server.business.model.Role;
import com.diphot.siuweb.server.business.model.User;
import com.diphot.siuweb.server.pesistense.daos.RoleDAO;
import com.diphot.siuweb.server.pesistense.daos.UserDAO;
import com.diphot.siuweb.shared.dtos.RoleDTO;
import com.diphot.siuweb.shared.dtos.UserDTO;

public class UserFacade {

	private static UserFacade instance;

	public static UserFacade getInstance() {
		if (instance == null){
			instance = new UserFacade();
		}
		return instance;
	}

	private UserFacade(){

	}

	/**
	 * Login paras Web
	 * */
	
	public UserDTO login(){
		return null;
	}

	/**
	 * Login para WebService
	 * */
	
	public UserDTO login(String username, String password){
		UserDAO udao = new UserDAO();
		udao.begin(); 

		User user = udao.getByUsername(username);
		UserDTO userDTO = null;
		if (user.checkPassword(password)){
			userDTO = udao.getDTO(user);
		};
		udao.end();
		return userDTO;
	}
	
	public void createUser(UserDTO userdto){
		UserDAO udao = new UserDAO();
		udao.begin();
		udao.creatFromDTO(userdto);
		udao.end();
	}
	
	public void createRole(RoleDTO rdto){
		RoleDAO rdao = new RoleDAO();
		rdao.begin();
		rdao.creatFromDTO(rdto);
		rdao.end();
	}
	
	public void assingRole(Long userID, Long RoleID){
		RoleDAO rdao = new RoleDAO();
		UserDAO udao = new UserDAO();
		rdao.begin(); udao.begin();
		User u = udao.getById(userID);
		Role r = rdao.getById(RoleID);
		u.addRole(r);
		rdao.end(); udao.end();
	}

}
