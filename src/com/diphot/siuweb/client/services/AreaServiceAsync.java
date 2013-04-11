package com.diphot.siuweb.client.services;

import java.util.ArrayList;

import com.diphot.siuweb.shared.dtos.AreaDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AreaServiceAsync {
	void getList(AsyncCallback<ArrayList<AreaDTO>> callback);

	void create(AreaDTO dto, AsyncCallback<Void> callback);

	void populateINIT(AsyncCallback<Void> callback);
}
