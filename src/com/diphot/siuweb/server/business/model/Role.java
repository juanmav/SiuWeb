package com.diphot.siuweb.server.business.model;

import java.util.HashSet;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;

import com.google.appengine.datanucleus.annotations.Unowned;

@PersistenceCapable
public class Role {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String encodedKey;

	@Persistent
	@Extension(vendorName="datanucleus", key="gae.pk-id", value="true")
	private Long id;

	@Persistent
	private String name;

	@Persistent
	@Unowned
	@ManyToMany(mappedBy = "roles", cascade = CascadeType.ALL)
	// Para que esto funcione se sobreescribieron los metodos equals y hashcode de java.lang.Object
	private HashSet<User> members = new HashSet<User>();

	public Role(){

	}

	public Role(Long id, String name){
		this.id = id;
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj == this){
			result = true;
		} else if (obj == null || obj.getClass() != this.getClass()) {
			result = false;
		} else if (((Role)obj).id == this.id){
			result = true;
		} 
		return result;
	}
	@Override
	public int hashCode() {
		return this.id.intValue();
	}
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
	public HashSet<User> getMembers() {
		return members;
	}
	public void setMembers(HashSet<User> members) {
		this.members = members;
	}
	public void addMember(User user){
		this.members.add(user);
	}
}
