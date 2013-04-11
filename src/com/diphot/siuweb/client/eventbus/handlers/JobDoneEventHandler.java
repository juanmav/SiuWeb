package com.diphot.siuweb.client.eventbus.handlers;

import com.diphot.siuweb.client.eventbus.events.JobDoneEvent;
import com.google.gwt.event.shared.EventHandler;

public interface JobDoneEventHandler extends EventHandler{
	void jobDone(JobDoneEvent e);
}
