package com.diphot.siuweb.server.mailer;

import com.diphot.siuweb.server.business.model.Inspeccion;
import com.diphot.siuweb.server.pdfservice.CustomWorker;
import com.diphot.siuweb.server.services.utils.InspeccionHMTL;
import com.google.appengine.api.mail.MailService;
import com.google.appengine.api.mail.MailService.Attachment;
import com.google.appengine.api.mail.MailServiceFactory;
import com.itextpdf.text.DocumentException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

public class InspeccionMailer {
	public static void notifyChange(Inspeccion inspeccion, Integer action){
		try {
			MailService service = MailServiceFactory.getMailService(); 
			MailService.Message msg = new MailService.Message(); 

			msg.setSender("juanma.v82@gmail.com");
			// Segun el tipo de accion que se ejecuto cambian los destinatarios.
			InspeccionMailStrategy strategy = new ObservadoStrategy().getStrategy(action);
			strategy.exec(inspeccion, msg);
			msg.setSubject("Detalle de inspeccion n°: " + inspeccion.getId() + " estado:" + inspeccion.getState().toString());
			//msg.setContent(InspeccionHMTL.getInspeccionHTML(inspeccion),"text/html");
			//http://127.0.0.1:8888/createpdfservlet

			CustomWorker cworker= new CustomWorker();
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			try {
				cworker.exec(bos, new StringReader(InspeccionHMTL.getInspeccionHTML(inspeccion)));
			} catch (DocumentException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			msg.setTextBody("Detalle de inspeccion Adjunto en formato PDF");
			Attachment a = new Attachment("reporte.pdf", bos.toByteArray());
			msg.setAttachments(a);
			service.send(msg);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
