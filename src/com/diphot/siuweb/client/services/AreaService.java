package com.diphot.siuweb.client.services;

import java.util.ArrayList;
import com.diphot.siuweb.shared.dtos.AreaDTO;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("areaservice")
public interface AreaService extends RemoteService {
	ArrayList<AreaDTO> getList();
	void create(AreaDTO dto);
	void populateINIT();
}