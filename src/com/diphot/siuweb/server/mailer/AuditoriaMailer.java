package com.diphot.siuweb.server.mailer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

import com.diphot.siuweb.server.business.model.Auditoria;
import com.diphot.siuweb.server.pdfservice.CustomWorker;
import com.diphot.siuweb.server.services.utils.AuditoriaHTML;
import com.google.appengine.api.mail.MailService;
import com.google.appengine.api.mail.MailServiceFactory;
import com.google.appengine.api.mail.MailService.Attachment;
import com.itextpdf.text.DocumentException;

public class AuditoriaMailer {

	public static void notifyChange(Auditoria auditoria, Integer action){
		try {
			MailService service = MailServiceFactory.getMailService(); 
			MailService.Message msg = new MailService.Message(); 

			msg.setSender("juanma.v82@gmail.com");
			// Segun el tipo de accion que se ejecuto cambian los destinatarios.
			InspeccionMailStrategy strategy = new ObservadoStrategy().getStrategy(action);
			strategy.exec(auditoria.getInspeccion(), msg);
			msg.setSubject("Detalle de Revision n°: " + auditoria.getId() + " de Inspeccion n°: " + auditoria.getInspeccion().getId() + " estado:" + auditoria.getInspeccion().getState().toString());
			CustomWorker cworker= new CustomWorker();
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			try {
				cworker.exec(bos, new StringReader(AuditoriaHTML.getAuditoriaHTML(auditoria)));
			} catch (DocumentException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			msg.setTextBody("Detalle de Revisión Adjunto en formato PDF");
			Attachment a = new Attachment("revision.pdf", bos.toByteArray());
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
