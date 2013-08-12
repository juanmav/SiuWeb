package com.diphot.siuweb.server.business.model;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.diphot.siuweb.server.services.utils.PasswordUtils;
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

	public User(){
		
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
}
