package com.diphot.siuweb.server.services.rest.interfaces;

import org.restlet.resource.Put;

import com.diphot.siuweb.shared.dtos.UserDTO;

public interface UserRestLetInterface {
	@Put
	public UserDTO login(UserDTO userDTO);
}