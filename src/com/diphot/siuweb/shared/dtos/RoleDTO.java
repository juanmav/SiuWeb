package com.diphot.siuweb.shared.dtos;


public class RoleDTO implements InterfaceDTO{

	private Long id;
	private String name;
	
	public RoleDTO(Long id, String name){
		this.setId(id);
		this.setName(name);
	}
	@Override
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
