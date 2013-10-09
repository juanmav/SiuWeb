package com.diphot.siuweb.server.mailer;

import com.diphot.siuweb.server.business.model.Inspeccion;
import com.diphot.siuweb.shared.SiuConstants;
import com.google.appengine.api.mail.MailService;

public abstract class  InspeccionMailStrategy {
	public abstract void exec(Inspeccion inspeccion, MailService.Message msg);
	public InspeccionMailStrategy getStrategy(Integer action){
		switch (action) {
		case SiuConstants.ACTION.OBSERVADO:
			return new ObservadoStrategy();
		case SiuConstants.ACTION.CONFIRMADO:
			return new ConfirmadoStrategy();
		case SiuConstants.ACTION.EJECUTADO:
			return new EjecutadoStrategy();
		case SiuConstants.ACTION.RESUELTO:
			return new ResueltoStrategy();
		default:
			return null;
		}
	}
}
