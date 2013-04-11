package com.diphot.siuweb.client.eventbus.events;

import com.diphot.siuweb.client.eventbus.handlers.LoginEventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class LoginEvent extends GwtEvent<LoginEventHandler> {

	public static Type<LoginEventHandler> TYPE = new Type<LoginEventHandler>();
	
	@Override
	public Type<LoginEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(LoginEventHandler handler) {
		handler.login(this);
	}

}
