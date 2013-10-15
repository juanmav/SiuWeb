package com.diphot.siuweb.server.mailer;

import java.util.HashSet;
import com.diphot.siuweb.server.business.model.Inspeccion;
import com.diphot.siuweb.server.business.model.Role;
import com.diphot.siuweb.server.business.model.User;
import com.diphot.siuweb.server.pesistense.daos.RoleDAO;
import com.diphot.siuweb.shared.SiuConstants;
import com.google.appengine.api.mail.MailService;

public class EjecutadoStrategy extends InspeccionMailStrategy{
	@Override
	public void exec(Inspeccion inspeccion, MailService.Message msg) {
		// Enviar el mail a los inspectores y supervisores
		RoleDAO rdao = new RoleDAO();
		rdao.begin();
		Role inspr = rdao.getRoleByName(SiuConstants.ROLES.INSPECTOR);
		Role supr = rdao.getRoleByName(SiuConstants.ROLES.SUPERVISOR);
		// agrego a los Inspectores
		HashSet<User> users = inspr.getMembers();
		// agregos a los supervisores.
		users.addAll(supr.getMembers());
			for (User u : users){
				System.out.println(u.getUsername());
				msg.setTo(u.getEmail());
			}
		rdao.end();
	}
}

