package com.diphot.siuweb.client.eventbus.events;

import com.diphot.siuweb.client.eventbus.handlers.JobDoneEventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class JobDoneEvent extends GwtEvent<JobDoneEventHandler>{

	public static Type<JobDoneEventHandler> TYPE = new Type<JobDoneEventHandler>();
	
	@Override
	public Type<JobDoneEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(JobDoneEventHandler handler) {
		handler.jobDone(this);
	}
}
