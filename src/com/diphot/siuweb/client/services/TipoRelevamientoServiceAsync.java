package com.diphot.siuweb.client.services;

import java.util.ArrayList;
import com.diphot.siuweb.shared.dtos.TipoRelevamientoDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface TipoRelevamientoServiceAsync {
	void getList(AsyncCallback<ArrayList<TipoRelevamientoDTO>> callback);
	void create(TipoRelevamientoDTO dto, AsyncCallback<Void> callback);
	void populateINIT(AsyncCallback<Void> callback);
}
