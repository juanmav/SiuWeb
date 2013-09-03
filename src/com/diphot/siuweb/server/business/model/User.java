package com.diphot.siuweb.server.business.model;

import java.util.HashSet;
import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.diphot.siuweb.server.services.utils.PasswordUtils;
import com.google.appengine.datanucleus.annotations.Unowned;
/**
 * Tener cuidado con la creación de las password, siempre utilizar el metodo setPassword, por mas que 
 * se este dentro de la clase. Recordar concepto de doble encapsulamiento.
 * */
@PersistenceCapable
public class User {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String encodedKey;

	@Persistent
	@Extension(vendorName="datanucleus", key="gae.pk-id", value="true")
	private Long id;
	
	@Persistent
	private String username;
	@Persistent
	private String password;

	@Persistent
	@Unowned
	// Para que esto funcione se sobreescribieron los metodos equals y hashcode de java.lang.Object
	private HashSet<Role> roles = new HashSet<Role>();
		
	public User(){
		
	}
	public User(Long id, String username, String password){
		this.id = id;
		this.username = username;
		setPassword(password);
	}
	
	public User(String username, String password){
		this.username = username;
		setPassword(password);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = PasswordUtils.saltHashMD5(password);
	}
	public String getPassword() {
		return password;
	}
	public boolean checkPassword(String password){
		return this.password.equalsIgnoreCase(PasswordUtils.saltHashMD5(password));
	}
	
	public HashSet<Role> getRoles() {
		return roles;
	}
	public void setRole(HashSet<Role> roles) {
		this.roles = roles;
	}
	
	public void addRole(Role role){
		this.roles.add(role);
	}
	
}
