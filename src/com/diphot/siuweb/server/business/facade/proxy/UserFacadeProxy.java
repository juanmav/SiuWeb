package com.diphot.siuweb.server.business.facade.proxy;

import java.util.Collections;
import java.util.Date;

import net.sf.jsr107cache.Cache;
import net.sf.jsr107cache.CacheException;
import net.sf.jsr107cache.CacheFactory;
import net.sf.jsr107cache.CacheManager;
import com.diphot.siuweb.server.business.facade.UserFacadeInterface;
import com.diphot.siuweb.server.business.facade.impl.UserFacade;
import com.diphot.siuweb.server.business.facade.proxy.exception.NotLoginException;
import com.diphot.siuweb.server.business.facade.proxy.exception.NotUserNotPasswordException;
import com.diphot.siuweb.server.services.utils.PasswordUtils;
import com.diphot.siuweb.shared.SiuConstants;
import com.diphot.siuweb.shared.dtos.RoleDTO;
import com.diphot.siuweb.shared.dtos.UserDTO;

public class UserFacadeProxy implements UserFacadeInterface {

	UserFacade impl = UserFacade.getInstance();

	private static UserFacadeProxy instance;

	public static UserFacadeProxy getInstance() {
		if (instance == null){
			instance = new UserFacadeProxy();
		}
		return instance;
	}

	private UserFacadeProxy(){

	}

	@Override
	public UserDTO login() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO login(String username, String password) {
		UserDTO userDTO = impl.login(username, password); 
		if (userDTO != null){
			userDTO.setToken(createToken(userDTO));
		} else {
			throw new NotUserNotPasswordException();
		}
		return userDTO;
	}

	@Override
	public void createUser(UserDTO userdto, UserDTO admin) {
		if (checkLoginAndRole(userdto.getToken(), SiuConstants.ROLES.ADMIN)){
			impl.createUser(userdto);
		} else {
			throw new NotLoginException();
		};

	}

	@Override
	public void createRole(RoleDTO rdto, UserDTO admin) {
		if (checkLoginAndRole(admin.getToken(), SiuConstants.ROLES.ADMIN)){
			impl.createRole(rdto);
		} else {
			throw new NotLoginException();
		};

	}

	@Override
	public void assingRole(Long userID, Long RoleID, UserDTO admin) {
		if (checkLoginAndRole(admin.getToken(), SiuConstants.ROLES.ADMIN)){
			impl.assingRole(userID, RoleID);
		} else {
			
		};	
	}

	/*
	 * Login support
	 * 
	 * Implementacion acoplada.
	 * 
	 * */

	private String createToken(UserDTO udto){
		String token = PasswordUtils.saltHashMD5(udto.getUsername() + new Date().toString());
		Cache cache = getCache();
		if (cache != null){
			udto.setToken(token);
			cache.put(token, udto);
		}
		return token;
	}
	private Cache getCache(){
		Cache cache = null;
		try {
			CacheFactory cacheFactory = CacheManager.getInstance().getCacheFactory();
			cache = cacheFactory.createCache(Collections.emptyMap());
		} catch (CacheException e) {

		}
		return cache;
	}

	public Boolean checkLogin(String token){
		Cache cache = getCache();
		UserDTO userToken = (UserDTO) cache.get(token);
		if (userToken != null){
			return true;
		} else { 
			return false;
		}
	}

	private Boolean hasRole(String token, String rolename){
		RoleDTO other = new RoleDTO(0L, rolename);
		Boolean result = false;
		if (token != null){
			UserDTO userdto = getUserDTOByToken(token);
			for (RoleDTO role : userdto.getRolesDTO()) {
				if (role.equals(new RoleDTO(SiuConstants.ROLES.ADMIN))){
					result = true;
				}else if (role.equals(other)) {
					result = true;
				}
			}
		}
		return result;
	}

	public Boolean checkLoginAndRole(String token, String rolename){
		if (hasRole(token, rolename) && checkLogin(token)){
			return true;
		} else {
			throw new NotLoginException();
		}
		 
	}
	
	public UserDTO getUserDTOByToken(String token){
		Cache cache = getCache();
		UserDTO userToken = (UserDTO) cache.get(token);
		return userToken;
	}

}
