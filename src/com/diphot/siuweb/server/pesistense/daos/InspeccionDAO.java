package com.diphot.siuweb.server.pesistense.daos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import com.diphot.siuweb.server.business.model.EncodedImage;
import com.diphot.siuweb.server.business.model.Inspeccion;
import com.diphot.siuweb.server.business.model.Tema;
import com.diphot.siuweb.server.business.model.inspeccion.status.InspeccionState;
import com.diphot.siuweb.server.pesistense.AbstractDAO;
import com.diphot.siuweb.server.pesistense.PMF.PMF;
import com.diphot.siuweb.shared.dtos.InspeccionDTO;
import com.diphot.siuweb.shared.dtos.TemaDTO;
import com.diphot.siuweb.shared.dtos.filters.FilterInterfaceDTO;
import com.diphot.siuweb.shared.dtos.filters.InspeccionFilterDTO;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;
import com.itextpdf.text.pdf.codec.Base64;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class InspeccionDAO extends AbstractDAO<Inspeccion, InspeccionDTO> {

	public InspeccionDAO() {
		super(Inspeccion.class);
	}

	@Override
	public Inspeccion creatFromDTO(InspeccionDTO dto) {
		TemaDTO temadto = dto.getTema();
		TemaDAO temaDAO = new TemaDAO();
		Inspeccion result = null;
		temaDAO.begin();
		Tema tema = temaDAO.getById(temadto.getId());
		// TODO resolver el tema de las fechas
		Inspeccion inspeccion = new Inspeccion((dto.getId() != null ? dto.getId() : null), dto.getCalle(), dto.getAltura(), new Date(), dto.getObservacion(), tema, dto.getLatitude(), dto.getLongitude(), dto.getRiesgo());
		if (dto.getImg1() != null)
			inspeccion.addImage(new EncodedImage(dto.getImg1()));
		if (dto.getImg2() != null)
			inspeccion.addImage(new EncodedImage(dto.getImg2()));
		if (dto.getImg3() != null)
			inspeccion.addImage(new EncodedImage(dto.getImg3()));
		// El agrego el Mapa estatico.
		//inspeccion.setEncodedMap(new EncodedImage(getStringMapImage(dto.getLatitude(), dto.getLongitude())));
		result = this.create(inspeccion);
		temaDAO.end();
		return result;
	}

	private String getStringMapImage(Double latitude, Double longitude){
		URL url;
		String result = "";
		try {
			url = new URL("http://maps.googleapis.com/maps/api/staticmap?" +
					"center="+ latitude +"," +
					longitude +
					"&zoom=15&size=300x300&maptype=roadmap&" +
					"markers="+latitude+"," +
					longitude +
					"&sensor=false");
			byte[] b = URLFetchServiceFactory.getURLFetchService().fetch( url ).getContent();
			result = Base64.encodeBytes(b);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public Inspeccion updateFromDTO(InspeccionDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public InspeccionDTO getDTO(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<InspeccionDTO> getDTOList() {
		ArrayList<InspeccionDTO> dtos = new ArrayList<InspeccionDTO>();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Inspeccion.class);
		List<Inspeccion> inspecciones = (List<Inspeccion>) q.execute();
		for (Inspeccion i : inspecciones){
			dtos.add(getDTO(i));
		}
		return dtos;
	}

	private String getValueImage(EncodedImage i){
		if (i == null){
			return "";
		} else {
			return i.getEncodedImageString();
		}
	}

	@Override
	public InspeccionDTO getDTO(Inspeccion i) {
		TemaDAO temadao = new TemaDAO();
		TemaDTO temadto = (TemaDTO) temadao.getDTO(i.getTema());
		return new InspeccionDTO(i.getId(), i.getCalle(), i.getAltura(), i.getObservacion(), 
				temadto,i.getLatitude(), i.getLongitude(),i.getFecha().toString(),
				getValueImage(i.getEncodedIMG1()),
				getValueImage(i.getEncodedIMG2()),
				getValueImage(i.getEncodedIMG3()),
				i.getRiesgo());
	}

	@Override
	public ArrayList<InspeccionDTO> getDTOList(FilterInterfaceDTO filter) {
		ArrayList<InspeccionDTO> result = new ArrayList<InspeccionDTO>();
		List<Inspeccion> iList = getList(filter);
		for (Inspeccion i : iList){
			result.add(getDTO(i));
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	// TODO Verificar esto
	public ArrayList<Inspeccion> getByState(InspeccionState state){
		ArrayList<Inspeccion> result;
		Query query = pm.newQuery(Inspeccion.class);
		query.setFilter("lastName == lastNameParam");
		result = (ArrayList<Inspeccion>) query.execute(state.getClass());
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Inspeccion> getList(FilterInterfaceDTO f) {
		InspeccionFilterDTO filter = (InspeccionFilterDTO) f;
		List<Inspeccion> result;
		Query query = pm.newQuery(Inspeccion.class);
		query.setFilter("riesgo == riesgoParam && lastStateIdentifier == lastParam");
		query.declareParameters("int riesgoParam, Integer lastParam");
		result = (List<Inspeccion>)query.execute(filter.riesgo, filter.estadoID);
		return result;
	}
}
