package com.diphot.siuweb.server.services.rest.interfaces;

import java.util.ArrayList;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;

import com.diphot.siuweb.shared.dtos.AreaDTO;
import com.diphot.siuweb.shared.dtos.TemaDTO;
import com.diphot.siuweb.shared.dtos.TipoRelevamientoDTO;

public interface TipificacionRestLetInterface {
	@Get
	public ArrayList<AreaDTO> getAreas();
	@Put
	public ArrayList<TipoRelevamientoDTO> getTiposRelevamiento();
	@Post
	public ArrayList<TemaDTO> getTemas();

}