package com.diphot.siuweb.client.services;

import java.util.ArrayList;

import com.diphot.siuweb.shared.dtos.InterfaceDTO;
import com.diphot.siuweb.shared.dtos.filters.FilterInterfaceDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DiphotServiceAsync {
	void create(InterfaceDTO dto, AsyncCallback<Long> callback);
	void update(InterfaceDTO dto, AsyncCallback<Void> callback);
	void delete(InterfaceDTO dto, AsyncCallback<Void> callback);
	void getList(InterfaceDTO dto, FilterInterfaceDTO filter,
			AsyncCallback<ArrayList<InterfaceDTO>> callback);
	void getList(InterfaceDTO dto,
			AsyncCallback<ArrayList<InterfaceDTO>> callback);
	
}
