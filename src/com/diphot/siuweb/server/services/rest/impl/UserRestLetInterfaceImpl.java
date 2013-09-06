package com.diphot.siuweb.server.services.rest.impl;

import org.restlet.resource.ServerResource;
import com.diphot.siuweb.server.business.facade.proxy.UserFacadeProxy;
import com.diphot.siuweb.server.services.rest.interfaces.UserRestLetInterface;
import com.diphot.siuweb.shared.dtos.UserDTO;

public class UserRestLetInterfaceImpl extends ServerResource implements UserRestLetInterface {
	@Override
	public UserDTO login(UserDTO userDTO) {
		UserFacadeProxy proxy = UserFacadeProxy.getInstance();
		UserDTO result = proxy.login(userDTO.getUsername(), userDTO.getPassword());
		return result;
	}
}
