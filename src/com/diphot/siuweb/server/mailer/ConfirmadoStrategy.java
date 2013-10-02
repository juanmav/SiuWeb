package com.diphot.siuweb.server.mailer;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;

import com.diphot.siuweb.server.business.model.Inspeccion;
import com.diphot.siuweb.server.business.model.User;

public class ConfirmadoStrategy extends InspeccionMailStrategy{
	@Override
	public void exec(Inspeccion inspeccion, Message msg) {
		// Enviar el mail a la gente de la secretaria
		try {
			ArrayList<User> us = inspeccion.getTema().getTiporelevamiento().getArea().getOwners();
			for (User u : us) {
				msg.addRecipient(Message.RecipientType.TO,new InternetAddress(u.getEmail(), u.getUsername()));
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
