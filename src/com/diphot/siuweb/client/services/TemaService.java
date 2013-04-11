package com.diphot.siuweb.client.services;

import java.util.ArrayList;

import com.diphot.siuweb.shared.dtos.TemaDTO;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("temaservice")
public interface TemaService extends RemoteService{
	ArrayList<TemaDTO> getList();
	void create(TemaDTO dto);
	void populateINIT();
}
