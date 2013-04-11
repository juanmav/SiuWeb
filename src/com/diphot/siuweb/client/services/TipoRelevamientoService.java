package com.diphot.siuweb.client.services;

import java.util.ArrayList;

import com.diphot.siuweb.shared.dtos.TipoRelevamientoDTO;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("tiporelevamientoservice")
public interface TipoRelevamientoService  extends RemoteService{
	ArrayList<TipoRelevamientoDTO> getList();
	void create(TipoRelevamientoDTO dto);
	void populateINIT();
}

