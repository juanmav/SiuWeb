package com.diphot.siuweb.server.pesistense;

import java.util.ArrayList;
import com.diphot.siuweb.shared.dtos.InterfaceDTO;

public interface DAOInterface <Bussines, DTO extends InterfaceDTO> {
	public Bussines findById(Long id);
	public ArrayList<Bussines> findAll();
	public Bussines create(Bussines entity);
	public ArrayList<Bussines> massiveCreate (ArrayList<Bussines> list);
	public Bussines creatFromDTO(DTO dto);
	public Bussines update(Bussines entity);
	public Bussines updateFromDTO(DTO dto);
	public void delete(Long id);
	public InterfaceDTO getDTO(Long id);
	public InterfaceDTO getDTO(Bussines entity);
	public ArrayList<DTO> getDTOList();
}
