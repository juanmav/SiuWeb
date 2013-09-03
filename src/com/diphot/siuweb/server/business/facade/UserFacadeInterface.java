package com.diphot.siuweb.server.business.facade;

import com.diphot.siuweb.shared.dtos.RoleDTO;
import com.diphot.siuweb.shared.dtos.UserDTO;

public interface UserFacadeInterface {

	/**
	 * Login paras Web
	 * */
	public UserDTO login();
	
	/**
	 * Login para WebService
	 * */
	public UserDTO login(String username, String password);
	public void createUser(UserDTO userdto, UserDTO admin);
	public void createRole(RoleDTO rdto,UserDTO admin);
	public void assingRole(Long userID, Long RoleID, UserDTO admin);
}
