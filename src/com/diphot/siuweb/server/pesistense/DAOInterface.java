package com.diphot.siuweb.server.pesistense;

import java.util.ArrayList;
import java.util.List;

import com.diphot.siuweb.shared.dtos.InterfaceDTO;
import com.diphot.siuweb.shared.dtos.filters.FilterInterfaceDTO;

public interface DAOInterface <Bussines, DTO extends InterfaceDTO> {
	public void begin();
	public void end();
	public Bussines getById(Long id);
	public List<Bussines> getList();
	public List<Bussines> getList(FilterInterfaceDTO filter);
	public Bussines create(Bussines entity);
	public ArrayList<Bussines> massiveCreate (ArrayList<Bussines> list);
	public Bussines creatFromDTO(DTO dto);
	public Bussines update(Bussines entity);
	public Bussines updateFromDTO(DTO dto);
	public void delete(Long id);
	public InterfaceDTO getDTO(Long id);
	public InterfaceDTO getDTO(Bussines entity);
	public ArrayList<DTO> getDTOList();
	public ArrayList<DTO> getDTOList(FilterInterfaceDTO filter);
}
