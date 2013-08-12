package com.diphot.siuweb.shared.dtos;

import java.io.Serializable;

import com.extjs.gxt.ui.client.data.BeanModelTag;

public class UserDTO implements Serializable, BeanModelTag, InterfaceDTO {

	private static final long serialVersionUID = 7669063489261772143L;
	private Long id;
	private String username;
	private String password;
	private String token;
	private RoleDTO roleDTO;
	
	
	public UserDTO(){
		
	}
	
	public UserDTO(Long id, String username) {
		super();
		this.id = id;
		this.username = username;
	}
	
	public UserDTO(Long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	@Override
	public Long getId() {
		return this.id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RoleDTO getRoleDTO() {
		return roleDTO;
	}

	public void setRoleDTO(RoleDTO roleDTO) {
		this.roleDTO = roleDTO;
	}
}
