package com.diphot.siu.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.diphot.siuweb.server.business.facade.impl.UserFacade;
import com.diphot.siuweb.server.business.facade.proxy.UserFacadeProxy;
import com.diphot.siuweb.server.business.model.Role;
import com.diphot.siuweb.server.business.model.User;
import com.diphot.siuweb.server.pesistense.daos.RoleDAO;
import com.diphot.siuweb.server.pesistense.daos.UserDAO;
import com.diphot.siuweb.shared.SiuConstants;
import com.diphot.siuweb.shared.dtos.RoleDTO;
import com.diphot.siuweb.shared.dtos.UserDTO;

public class UserTest  extends AbstractSiuTest {

	@Before
	public void setUp() {
		super.setUp();
		UserFacade.getInstance().createUser(new UserDTO(1L,"admin", "admin", "jmvicente@diphot.com"));
		UserFacade.getInstance().createRole(new RoleDTO(1L, SiuConstants.ROLES.ADMIN));
		UserFacade.getInstance().createRole(new RoleDTO(2L, SiuConstants.ROLES.SUPERVISOR));
		UserFacade.getInstance().createRole(new RoleDTO(3L, SiuConstants.ROLES.INSPECTOR));
		UserFacade.getInstance().createRole(new RoleDTO(4L, SiuConstants.ROLES.SECRETARIA));
	}
	
	@Test
	public void testPasswordDigest(){
		User u = new User(1L,"admin", "password","a@a.com");
		// Chequeo el password y me da OK
		Assert.assertTrue(u.checkPassword("password"));
		// Si comparo el password directo con el hash da false
		Assert.assertFalse(u.getPassword().equalsIgnoreCase("password"));
	}
	
	@Test
	public void testTokenLogin(){
		UserDTO udto = UserFacadeProxy.getInstance().login("admin", "admin");
		Assert.assertNotNull(udto.getToken());
		Assert.assertTrue(UserFacadeProxy.getInstance().checkLogin(udto.getToken()));
	}
	
	@Test
	public void testRole(){
		UserFacade.getInstance().assingRole(1L, 1L);
		UserDAO udao = new UserDAO();
		udao.begin();
		User u = udao.getById(1L);
		System.out.println(u.getRoles().size());
		Assert.assertTrue(u.getRoles().size() > 0);
		udao.end();
		
		RoleDAO rdao = new RoleDAO();
		rdao.begin();
		Role r = rdao.getRoleByName(SiuConstants.ROLES.ADMIN);
		Assert.assertTrue(r.getMembers().size() > 0);
		for (User member : r.getMembers()){
			System.out.println(member.getUsername());
		}
		rdao.end();
	}

	@Test
	public void testRoleDTO(){
		UserFacade.getInstance().assingRole(1L, 1L);
		UserDTO u = UserFacade.getInstance().login("admin", "admin");
		Assert.assertNotNull(u.getRolesDTO().get(0));
	}
	
	@Test
	public void failLogin(){
		UserDTO u = UserFacade.getInstance().login("admin", "asdasddas");
		Assert.assertNull(u);
	}
}
