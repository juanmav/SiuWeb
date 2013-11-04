package com.diphot.siuweb.server.mailer;

import java.util.HashSet;
import com.diphot.siuweb.server.business.model.Inspeccion;
import com.diphot.siuweb.server.business.model.Role;
import com.diphot.siuweb.server.business.model.User;
import com.diphot.siuweb.server.pesistense.daos.RoleDAO;
import com.diphot.siuweb.shared.SiuConstants;
import com.google.appengine.api.mail.MailService;

public class ResueltoStrategy extends InspeccionMailStrategy{
	@Override
	public void exec(Inspeccion inspeccion, MailService.Message msg) {
		// Enviar mail a Secretario y Supervisor.
		RoleDAO rdao = new RoleDAO();
		rdao.begin();
		Role secr = rdao.getRoleByName(SiuConstants.ROLES.SECRETARIA);
		Role supr = rdao.getRoleByName(SiuConstants.ROLES.SUPERVISOR);
		// agrego a los Inspectores
		HashSet<User> users = secr.getMembers();
		// agregos a los supervisores.
		users.addAll(supr.getMembers());
		for (User u : users){
			System.out.println(u.getUsername());
			msg.setTo(u.getEmail());
		}

		rdao.end();
	}
}