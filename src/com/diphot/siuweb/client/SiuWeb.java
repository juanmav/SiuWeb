package com.diphot.siuweb.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.maps.client.LoadApi;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SiuWeb implements EntryPoint {

	@Override
	public void onModuleLoad() {
		
		/* Cargo la Api de google maps*/
		Runnable onLoad = new Runnable() {
			@Override
			public void run() {

			}
		};
		/* Cargo las Api de Maps ya que las necesito en casi todos los contextos de uso.*/
		LoadApi.go(onLoad, false);
		RootPanel.get().add(new MainScreen());
	}
	
	
}
