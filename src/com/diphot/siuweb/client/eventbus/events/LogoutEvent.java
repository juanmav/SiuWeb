package com.diphot.siuweb.client.eventbus.events;

import com.diphot.siuweb.client.eventbus.handlers.LogoutEventHandler;
import com.google.gwt.event.shared.GwtEvent;


public class LogoutEvent extends GwtEvent<LogoutEventHandler> {

public static Type<LogoutEventHandler> TYPE = new Type<LogoutEventHandler>();
	
	@Override
	public Type<LogoutEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(LogoutEventHandler handler) {
		handler.logout(this);
	}
	
}
