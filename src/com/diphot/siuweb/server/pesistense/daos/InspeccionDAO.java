package com.diphot.siuweb.server.pesistense.daos;
        
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import com.diphot.siuweb.server.business.EncodedImage;
import com.diphot.siuweb.server.business.Inspeccion;
import com.diphot.siuweb.server.business.Tema;
import com.diphot.siuweb.server.pesistense.AbstractDAO;
import com.diphot.siuweb.server.pesistense.PMF.PMF;
import com.diphot.siuweb.shared.dtos.InspeccionDTO;
import com.diphot.siuweb.shared.dtos.InterfaceDTO;
import com.diphot.siuweb.shared.dtos.TemaDTO;
import com.diphot.siuweb.shared.dtos.filters.FilterInterfaceDTO;

public class InspeccionDAO extends AbstractDAO<Inspeccion, InspeccionDTO> {

	public InspeccionDAO() {
		super(Inspeccion.class);
	}

	@Override
	public Inspeccion creatFromDTO(InspeccionDTO dto) {
		TemaDTO temadto = dto.getTema();
		TemaDAO temaDAO = new TemaDAO();
		temaDAO.begin();
		Tema tema = temaDAO.findById(temadto.getId());
		// TODO ver bien esto.
		//pm = JDOHelper.getPersistenceManager(tema);
		// TODO resolver el tema de las fechas
		Inspeccion inspeccion = new Inspeccion(null, dto.getCalle(), dto.getAltura(), new Date(), tema, dto.getLatitude(), dto.getLongitude());
		if (dto.getImg1() != null)
			inspeccion.addImage(new EncodedImage(dto.getImg1()));
		if (dto.getImg2() != null)
			inspeccion.addImage(new EncodedImage(dto.getImg2()));
		if (dto.getImg3() != null)
			inspeccion.addImage(new EncodedImage(dto.getImg3()));
		Inspeccion result = this.create(inspeccion);
		temaDAO.end();
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
		TemaDAO temadao = new TemaDAO();
		for (Inspeccion i : inspecciones){
			TemaDTO temadto = (TemaDTO) temadao.getDTO(i.getTema());
			dtos.add(new InspeccionDTO(i.getId(), i.getCalle(), i.getAltura(), 
					temadto,i.getLatitude(), i.getLongitude(),i.getFecha().toString(),
					getValueImage(i.getEncodedIMG1()),
					getValueImage(i.getEncodedIMG2()),
					getValueImage(i.getEncodedIMG3())));
		}
		pm.close();
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
	public InterfaceDTO getDTO(Inspeccion entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InspeccionDTO> getDTOList(FilterInterfaceDTO filter) {
		// TODO Auto-generated method stub
		return null;
	}
}
