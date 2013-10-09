package com.diphot.siuweb.server.pdfservice;

import java.io.IOException;
import java.io.StringReader;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.diphot.siuweb.server.business.model.Inspeccion;
import com.diphot.siuweb.server.pesistense.daos.InspeccionDAO;
import com.diphot.siuweb.server.services.utils.InspeccionHMTL;
import com.itextpdf.text.DocumentException;

@SuppressWarnings("serial")
public class CreatePdfServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/pdf");
		CustomWorker cworker= new CustomWorker();
		InspeccionDAO idao = new InspeccionDAO();
		idao.begin();
		Inspeccion inspeccion = idao.getById(1072L);
		// http://maps.googleapis.com/maps/api/staticmap?scale=1&center=40.702147,-74.015794&zoom=14&size=300x150&maptype=roadmap&markers=color:blue%7Clabel:S%7C40.702147,-74.015794&sensor=false
		try {
			cworker.exec(response.getOutputStream(), new StringReader(InspeccionHMTL.getInspeccionHTML(inspeccion)));
			idao.end();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
