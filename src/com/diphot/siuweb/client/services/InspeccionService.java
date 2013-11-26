package com.diphot.siuweb.client.services;

import java.util.ArrayList;

import com.diphot.siuweb.shared.dtos.EncodedImageDTO;
import com.diphot.siuweb.shared.dtos.InspeccionDTO;
import com.diphot.siuweb.shared.dtos.filters.InspeccionFilterDTO;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("inspeccionservice")
public interface InspeccionService extends RemoteService {
	ArrayList<InspeccionDTO> getList();
	Long create(InspeccionDTO dto);
	void createImage(EncodedImageDTO dto, int numero);
	void examplesCreate();
	ArrayList<InspeccionDTO> getInspeccionesDTO(InspeccionFilterDTO filter);
}
