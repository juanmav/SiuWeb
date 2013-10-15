package com.diphot.siuweb.server.mailer;

import java.util.ArrayList;
import com.diphot.siuweb.server.business.model.Inspeccion;
import com.diphot.siuweb.server.business.model.User;
import com.google.appengine.api.mail.MailService;

public class ConfirmadoStrategy extends InspeccionMailStrategy{
	@Override
	public void exec(Inspeccion inspeccion, MailService.Message msg) {
		// Enviar el mail a la gente de la secretaria

		ArrayList<User> us = inspeccion.getTema().getTiporelevamiento().getArea().getOwners();
		for (User u : us) {
			msg.setTo(u.getEmail());
		}

	}
}
