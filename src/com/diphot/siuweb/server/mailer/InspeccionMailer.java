package com.diphot.siuweb.server.mailer;

import com.diphot.siuweb.server.business.model.Inspeccion;
import com.diphot.siuweb.server.services.utils.InspeccionHMTL;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class InspeccionMailer {

	public static void notifyChange(Inspeccion inspeccion, Integer action){
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("jmvicente@diphot.com", "Juan Manuel Vicente"));
			// Segun el tipo de accion que se ejecuto cambian los destinatarios.
			InspeccionMailStrategy strategy = new ObservadoStrategy().getStrategy(action);
			strategy.exec(inspeccion, msg);
			msg.setSubject("Your Example.com account has been activated");
			msg.setText(InspeccionHMTL.getInspeccionHTML(inspeccion));
			Transport.send(msg);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
