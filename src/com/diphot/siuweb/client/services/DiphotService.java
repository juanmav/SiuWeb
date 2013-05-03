package com.diphot.siuweb.client.services;

import java.util.ArrayList;

import com.diphot.siuweb.shared.InterfaceDTO;
import com.diphot.siuweb.shared.dtos.filters.FilterInterfaceDTO;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("diphotservice")
public interface DiphotService extends RemoteService{
	ArrayList<InterfaceDTO> getList(InterfaceDTO dto);
	Long create(InterfaceDTO dto);
	void update(InterfaceDTO dto);
	void delete(InterfaceDTO dto);
	ArrayList<InterfaceDTO> getList(InterfaceDTO dto,FilterInterfaceDTO filter);
}
