package com.diphot.siuweb.server.reporter;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.diphot.siuweb.server.business.model.Inspeccion;
import com.diphot.siuweb.server.pesistense.daos.InspeccionDAO;
import com.diphot.siuweb.server.services.utils.ConversionUtil;


public class CustomReporterCSV extends HttpServlet {

	private static final long serialVersionUID = 2429116769407326384L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InspeccionDAO idao = new InspeccionDAO();
		idao.begin();
		List<Inspeccion> lista = idao.getList();
		for (Inspeccion i : lista){
			response.getWriter().println(i.getId()+","+ i.getTema().getTiporelevamiento().toString() + "," + ConversionUtil.getSimpleDate(i.getFecha().toString()) + "," + i.getLastStateIdentifier());
		}
		idao.end();
	}

}
