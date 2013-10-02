package com.diphot.siuweb.server.mailer;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;

import com.diphot.siuweb.server.business.model.Inspeccion;
import com.diphot.siuweb.server.business.model.Role;
import com.diphot.siuweb.server.business.model.User;
import com.diphot.siuweb.server.pesistense.daos.RoleDAO;
import com.diphot.siuweb.shared.SiuConstants;

public class EjecutadoStrategy extends InspeccionMailStrategy{
	@Override
	public void exec(Inspeccion inspeccion, Message msg) {
		// Enviar el mail a los inspectores y supervisores
		RoleDAO rdao = new RoleDAO();
		rdao.begin();
		Role inspr = rdao.getRoleByName(SiuConstants.ROLES.INSPECTOR);
		Role supr = rdao.getRoleByName(SiuConstants.ROLES.SUPERVISOR);
		// agrego a los Inspectores
		HashSet<User> users = inspr.getMembers();
		// agregos a los supervisores.
		users.addAll(supr.getMembers());
		
		try {
			for (User u : users){
				System.out.println(u.getUsername());
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(u.getEmail(), u.getUsername()));
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rdao.end();
	}
}

