package com.diphot.siuweb.client.services;

import java.util.ArrayList;

import com.diphot.siuweb.shared.dtos.TemaDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface TemaServiceAsync {
	void getList(AsyncCallback<ArrayList<TemaDTO>> callback);
	void create(TemaDTO dto, AsyncCallback<Void> callback);
	void populateINIT(AsyncCallback<Void> callback);
}
