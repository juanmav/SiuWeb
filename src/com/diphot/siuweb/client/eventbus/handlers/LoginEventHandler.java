package com.diphot.siuweb.client.eventbus.handlers;

import com.diphot.siuweb.client.eventbus.events.LoginEvent;
import com.google.gwt.event.shared.EventHandler;

public interface  LoginEventHandler extends EventHandler{
	void login(LoginEvent e);
}
