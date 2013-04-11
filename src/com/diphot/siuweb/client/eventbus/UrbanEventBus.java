package com.diphot.siuweb.client.eventbus;

import com.google.gwt.event.shared.SimpleEventBus;

public class UrbanEventBus {

	private static SimpleEventBus eventBus = new SimpleEventBus();

	private UrbanEventBus(){

	}

	public static SimpleEventBus getEventBus(){
		return eventBus;
	}
	
}
