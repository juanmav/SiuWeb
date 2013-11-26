package com.diphot.siuweb.server.pesistense.daos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import com.diphot.siuweb.server.business.model.EncodedImage;
import com.diphot.siuweb.server.business.model.Inspeccion;
import com.diphot.siuweb.server.business.model.Localidad;
import com.diphot.siuweb.server.business.model.Tema;
import com.diphot.siuweb.server.business.model.inspeccion.status.InspeccionState;
import com.diphot.siuweb.server.pesistense.AbstractDAO;
import com.diphot.siuweb.server.pesistense.PMF.PMF;
import com.diphot.siuweb.server.services.utils.ConversionUtil;
import com.diphot.siuweb.shared.SiuConstants;
import com.diphot.siuweb.shared.dtos.InspeccionDTO;
import com.diphot.siuweb.shared.dtos.LocalidadDTO;
import com.diphot.siuweb.shared.dtos.TemaDTO;
import com.diphot.siuweb.shared.dtos.filters.FilterInterfaceDTO;
import com.diphot.siuweb.shared.dtos.filters.InspeccionFilterDTO;
import com.google.appengine.api.datastore.KeyFactory;
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
		LocalidadDAO localidadDAO = new LocalidadDAO();
		Inspeccion result = null;
		temaDAO.begin(); localidadDAO.begin();
		Tema tema = temaDAO.getById(temadto.getId());
		// TODO resolver el tema de las fechas
		// Poner el id en null asi la DB lo crea!
		Inspeccion inspeccion = new Inspeccion(null, dto.getCalle(), dto.getAltura(), ConversionUtil.getDateFromString(dto.getFecha()), dto.getObservacion(), tema, dto.getLatitude(), dto.getLongitude(), dto.getRiesgo());
		if (dto.getImg1() != null && !dto.getImg1().equals(""))
			inspeccion.addImage(new EncodedImage(dto.getImg1()));
		if (dto.getImg2() != null && !dto.getImg2().equals(""))
			inspeccion.addImage(new EncodedImage(dto.getImg2()));
		if (dto.getImg3() != null && !dto.getImg3().equals(""))
			inspeccion.addImage(new EncodedImage(dto.getImg3()));
		// El agrego el Mapa estatico.
		inspeccion.setEncodedMap(new EncodedImage(getStringMapImage(dto.getLatitude(), dto.getLongitude())));
		inspeccion.setUuid(dto.UUID);

		Localidad localidad = localidadDAO.getById(dto.getLocalidad().getId());
		inspeccion.setLocalidad(localidad);

		inspeccion.setEntreCalleUno(dto.getEntreCalleUno());
		inspeccion.setEntreCalleDos(dto.getEntreCalleDos());

		result = this.create(inspeccion);
		temaDAO.end(); localidadDAO.end();
		return result;
	}

	private String getStringMapImage(Double latitude, Double longitude){
		URL url;
		String result = "";
		try {
			url = new URL("http://maps.googleapis.com/maps/api/staticmap?" +
					"center="+ latitude +"," +
					longitude +
					"&zoom=17&size=300x300&maptype=roadmap&" +
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
		Inspeccion i = pm.getObjectById(Inspeccion.class, KeyFactory.createKey(Inspeccion.class.getSimpleName(), id));
		return getDTOWithImage(i);
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

	/*
	 * 
	 * */
	@Override
	public InspeccionDTO getDTO(Inspeccion i) {
		TemaDAO temadao = new TemaDAO();
		TemaDTO temadto = (TemaDTO) temadao.getDTO(i.getTema());
		InspeccionDTO idto = new InspeccionDTO(i.getId(), i.getCalle(), i.getAltura(), i.getObservacion(), 
				temadto,i.getLatitude(), i.getLongitude(),ConversionUtil.getSimpleDate(i.getFecha().toString()).toString(),
				"",
				"",
				"",
				i.getRiesgo());
		idto.setLastStateIdentifier(i.getLastStateIdentifier());
		idto.setImgMap("");
		Localidad localidad = i.getLocalidad();
		idto.setLocalidad(new LocalidadDTO(localidad.getId(), localidad.getNombre()));
		idto.setEntreCalleUno(i.getEntreCalleUno());
		idto.setEntreCalleDos(i.getEntreCalleDos());
		idto.setAuditoriaCant(i.getAuditorias().size());
		return idto;
	}

	public InspeccionDTO getDTOWithImage(Inspeccion i){
		TemaDAO temadao = new TemaDAO();
		TemaDTO temadto = (TemaDTO) temadao.getDTO(i.getTema());
		InspeccionDTO idto = new InspeccionDTO(i.getId(), i.getCalle(), i.getAltura(), i.getObservacion(), 
				temadto,i.getLatitude(), i.getLongitude(),ConversionUtil.getSimpleDate(i.getFecha().toString()).toString(),
				getValueImage(i.getEncodedIMG1()),
				getValueImage(i.getEncodedIMG2()),
				getValueImage(i.getEncodedIMG3()),
				i.getRiesgo());
		idto.setLastStateIdentifier(i.getLastStateIdentifier());
		idto.setImgMap(getValueImage(i.getEncodedMap()));
		Localidad localidad = i.getLocalidad();
		idto.setLocalidad(new LocalidadDTO(localidad.getId(), localidad.getNombre()));
		idto.setEntreCalleUno(i.getEntreCalleUno());
		idto.setEntreCalleDos(i.getEntreCalleDos());
		idto.setAuditoriaCant(i.getAuditorias().size());
		return idto;
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
		// TODO agregar fecha desde hasta, y localidad.
		InspeccionFilterDTO filter = (InspeccionFilterDTO) f;
		List<Inspeccion> result;
		Query query = pm.newQuery(Inspeccion.class);

		if (filter != null){
			ArrayList<Object> parameters = new ArrayList<Object>();
			String stringFilter = "lastStateIdentifier == lastParam ";
			String stringDeclared = "Integer lastParam";
			parameters.add(filter.estadoID);
			
			// lastStateIndentifier siempre va.
			if (filter.riesgo != SiuConstants.TODOS){
				stringFilter = stringFilter +  " && riesgo == riesgoParam";
				stringDeclared = stringDeclared + ", Integer riesgoParam";
				parameters.add(filter.riesgo);
			}
			if (filter.desde != null && filter.hasta !=null){
				Date dateDesde = ConversionUtil.getDateFromString(filter.desde);
				Date dateHasta = ConversionUtil.getDateFromString(filter.hasta);
				stringFilter = stringFilter + " && fecha >= desdeParam && fecha <= hastaParam";
				stringDeclared =  stringDeclared + ", java.util.Date desdeParam, java.util.Date hastaParam";
				parameters.add(dateDesde);
				parameters.add(new Date(dateHasta.getTime() + 1000 * 60 * 60 * 24 - 1 ));
			}
			if (filter.localidadID != null && filter.localidadID != -1){
				stringFilter = stringFilter + " && localidad == localidadParam";
				LocalidadDAO ldao = new LocalidadDAO();
				Localidad l;
				ldao.begin();
				l = ldao.getById(filter.localidadID);
				//ldao.end();
				// Se cierra la transacion sola al finalizar el DAO de Inspeccion.
				stringDeclared = stringDeclared + ", com.diphot.siuweb.server.business.model.Localidad localidadParam";
				parameters.add(l);
			}
			System.out.println("Filtros: " + stringFilter);
			System.out.println("Parametros: " + stringDeclared);
			for (Object o : parameters){
				System.out.print("Valor: " + o.toString() + " ");
			}
			System.out.println("");
			query.setFilter(stringFilter);
			query.declareParameters(stringDeclared);
			result = (List<Inspeccion>)query.executeWithArray(parameters.toArray());
		} else {
			result = (List<Inspeccion>)query.execute();
		}
		return result;
	}
	
	/*
	 * if (filter.riesgo != SiuConstants.TODOS){
				query.setFilter("riesgo == riesgoParam && lastStateIdentifier == lastParam");
				query.declareParameters("int riesgoParam, Integer lastParam");
			} else { // TODOS 
				query.setFilter("lastStateIdentifier == lastParam");
				query.declareParameters("int riesgoParam, Integer lastParam");
			}
	 * */

	public Inspeccion getByUUID(String uuid){
		Inspeccion result = null;
		Query query = pm.newQuery(Inspeccion.class);
		query.setFilter("uuid == uuidParam");
		query.declareParameters("String uuidParam");
		List<Inspeccion> lista =(List<Inspeccion>)query.execute(uuid); 
		if (lista.size() > 0){
			result = lista.get(0);
		}
		return result;
	}

}
