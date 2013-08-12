package com.diphot.siuweb.server.business.facade;

import java.util.Date;
import java.util.Collections;

import net.sf.jsr107cache.Cache;
import net.sf.jsr107cache.CacheException;
import net.sf.jsr107cache.CacheFactory;
import net.sf.jsr107cache.CacheManager;


import com.diphot.siuweb.server.business.model.User;
import com.diphot.siuweb.server.pesistense.daos.RoleDAO;
import com.diphot.siuweb.server.pesistense.daos.UserDAO;
import com.diphot.siuweb.server.services.utils.PasswordUtils;
import com.diphot.siuweb.shared.dtos.RoleDTO;
import com.diphot.siuweb.shared.dtos.UserDTO;

public class UserFacade {

	/**
	 * Login paras Web
	 * */
	
	public static UserDTO login(){
		return null;
	}
	
	/**
	 * Login para WebService
	 * */
	
	public static UserDTO login(String username, String password){
		UserDAO udao = new UserDAO();
		udao.begin();

		User user = udao.getByUsername(username);
		UserDTO userDTO = null;
		if (user.checkPassword(password)){
			userDTO = udao.getDTO(user);
			userDTO.setToken(createToken(userDTO));
		};

		udao.end();
		return userDTO;
	}

	public static Boolean checkToken(UserDTO udto){
		Cache cache = getCache();
		String token = (String) cache.get(udto.getUsername());

		if (token.equalsIgnoreCase(udto.getToken())){
			return true;
		} else {
			return false;
		}
	}

	private static String createToken(UserDTO udto){
		String token = PasswordUtils.saltHashMD5(udto.getUsername() + new Date().toString());
		Cache cache = getCache();
		if (cache != null){
			cache.put(udto.getUsername(), token);
		}
		return token;
	}

	private static Cache getCache(){
		Cache cache = null;
		try {
			CacheFactory cacheFactory = CacheManager.getInstance().getCacheFactory();
			cache = cacheFactory.createCache(Collections.emptyMap());
		} catch (CacheException e) {

		}
		return cache;
	}
	
	public static void createUser(UserDTO userdto){
		UserDAO udao = new UserDAO();
		udao.begin();
		udao.creatFromDTO(userdto);
		udao.end();
	}
	
	public static void createRole(RoleDTO rdto){
		RoleDAO rdao = new RoleDAO();
		rdao.begin();
		rdao.creatFromDTO(rdto);
		rdao.end();
	}

}
