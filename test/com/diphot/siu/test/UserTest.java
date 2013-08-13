package com.diphot.siu.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.diphot.siuweb.server.business.facade.UserFacade;
import com.diphot.siuweb.server.business.model.User;
import com.diphot.siuweb.shared.dtos.UserDTO;

public class UserTest  extends AbstractSiuTest {


	@Before
	public void setUp() {
		super.setUp();
		UserFacade.createUser(new UserDTO(1L,"admin", "admin"));
	}
	
	@Test
	public void testPasswordDigest(){
		User u = new User("admin", "password");
		// Chequeo el password y me da OK
		Assert.assertTrue(u.checkPassword("password"));
		// Si comparo el password directo con el hash da false
		Assert.assertFalse(u.getPassword().equalsIgnoreCase("password"));
	}
	
	@Test
	public void testToken(){
		UserDTO udto = UserFacade.login("admin", "admin");
		udto.getToken();
		Assert.assertTrue(UserFacade.checkToken(udto));
	}
	
	@Test
	public void testRole(){
		
		
	}

}
