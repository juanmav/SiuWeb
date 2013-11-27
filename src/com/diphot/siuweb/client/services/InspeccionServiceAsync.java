package com.diphot.siuweb.client.services;

import java.util.ArrayList;

import com.diphot.siuweb.shared.dtos.EncodedImageDTO;
import com.diphot.siuweb.shared.dtos.InspeccionDTO;
import com.diphot.siuweb.shared.dtos.filters.InspeccionFilterDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface InspeccionServiceAsync {
	void create(InspeccionDTO dto, AsyncCallback<Long> callback);
	void getList(AsyncCallback<ArrayList<InspeccionDTO>> callback);
	void createImage(EncodedImageDTO dto, int numero, AsyncCallback<Void> callback);
	void examplesCreate(AsyncCallback<Void> callback);
	void getInspeccionesDTO(InspeccionFilterDTO filter, AsyncCallback<ArrayList<InspeccionDTO>> callback);
	void getInspeccionWithImage(InspeccionFilterDTO filter, AsyncCallback<InspeccionDTO> callback);
}