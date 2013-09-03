package com.diphot.siuweb.server.services.rest;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import com.diphot.siuweb.server.services.rest.impl.AuditoriaRestLetImpl;
import com.diphot.siuweb.server.services.rest.impl.InspeccionRestLetImpl;
import com.diphot.siuweb.server.services.rest.impl.TipificacionRestLetImpl;
import com.diphot.siuweb.server.services.rest.impl.UserRestLetInterfaceImpl;

public class RestApi extends Application {

	/**
	 * Creates a root Restlet that will receive all incoming calls.
	 */
	@Override
	public Restlet createInboundRoot() {
		Router router = new Router(getContext());
		router.attach("/inspecciones", InspeccionRestLetImpl.class);
		router.attach("/tipificacion", TipificacionRestLetImpl.class);
		router.attach("/auditorias", AuditoriaRestLetImpl.class);
		router.attach("/user",UserRestLetInterfaceImpl.class);
		return router;
	}
}
