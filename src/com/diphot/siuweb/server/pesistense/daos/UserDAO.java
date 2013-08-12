package com.diphot.siuweb.server.pesistense.daos;

import java.util.ArrayList;
import java.util.List;
import javax.jdo.Query;
import com.diphot.siuweb.server.business.model.User;
import com.diphot.siuweb.server.pesistense.AbstractDAO;
import com.diphot.siuweb.shared.dtos.UserDTO;
import com.diphot.siuweb.shared.dtos.filters.FilterInterfaceDTO;

public class UserDAO extends AbstractDAO<User, UserDTO>{

	public UserDAO() {
		super(User.class);
	}

	@Override
	public List<User> getList(FilterInterfaceDTO filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User creatFromDTO(UserDTO dto) {
		User u = new User(dto.getUsername(),dto.getPassword());
		this.create(u);
		return u;
	}

	@Override
	public User updateFromDTO(UserDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO getDTO(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO getDTO(User entity) {
		UserDTO udto = new UserDTO(entity.getId(), entity.getUsername());
		return udto;
	}

	@Override
	public ArrayList<UserDTO> getDTOList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserDTO> getDTOList(FilterInterfaceDTO filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public User getByUsername(String username){
		Query query = pm.newQuery(User.class);
		query.setFilter("username == usernameParam");
		query.declareParameters("String usernameParam");
		User result = ((List<User>)query.execute(username)).get(0);
		return result;
	}
}
