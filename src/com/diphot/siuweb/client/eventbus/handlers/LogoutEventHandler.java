package com.diphot.siuweb.client.eventbus.handlers;

import com.diphot.siuweb.client.eventbus.events.LogoutEvent;
import com.google.gwt.event.shared.EventHandler;

public interface LogoutEventHandler extends EventHandler {
	void logout(LogoutEvent e);
}
