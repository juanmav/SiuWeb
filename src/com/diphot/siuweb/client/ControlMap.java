package com.diphot.siuweb.client;

import java.util.ArrayList;

import com.diphot.siuweb.client.services.InspeccionService;
import com.diphot.siuweb.client.services.InspeccionServiceAsync;
import com.diphot.siuweb.shared.SiuConstants;
//import com.diphot.siuweb.server.services.utils.ConversionUtil;
import com.diphot.siuweb.shared.dtos.InspeccionDTO;
import com.diphot.siuweb.shared.dtos.filters.InspeccionFilterDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.maps.client.MapOptions;
import com.google.gwt.maps.client.MapTypeId;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.base.LatLng;
import com.google.gwt.maps.client.events.click.ClickMapEvent;
import com.google.gwt.maps.client.events.click.ClickMapHandler;
import com.google.gwt.maps.client.overlays.InfoWindow;
import com.google.gwt.maps.client.overlays.InfoWindowOptions;
import com.google.gwt.maps.client.overlays.Marker;
import com.google.gwt.maps.client.overlays.MarkerOptions;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class ControlMap extends Composite {

	private static ControlMapUiBinder uiBinder = GWT.create(ControlMapUiBinder.class);
	interface ControlMapUiBinder extends UiBinder<Widget, ControlMap> {}

	final InspeccionServiceAsync inspeccionServiceAsync = GWT.create(InspeccionService.class);

	/* Mapa */
	private MapWidget mapWidget;

	@UiField
	protected HTMLPanel mapContainer;

	public ControlMap() {
		initWidget(uiBinder.createAndBindUi(this));

		drawMap();

		reloadData();
	}

	
	ArrayList<Marker> marcadores = new ArrayList<Marker>();
	
	private void reloadData(){
		Timer timer = new Timer(){

			@Override
			public void run() {
				InspeccionFilterDTO filter = new InspeccionFilterDTO();
				filter.estadoID = 1;
				filter.desde = "15/09/2013";
				filter.hasta = "30/11/2013";

				
				// Arreglar este metodo
				// No le da bola al filtro!
				inspeccionServiceAsync.getInspeccionesDTO(filter, new AsyncCallback<ArrayList<InspeccionDTO>>() {
					@Override
					public void onSuccess(ArrayList<InspeccionDTO> result) {
						for (Marker m : marcadores){
							m.setMap((MapWidget)null);
						}
						marcadores.clear();
						for (InspeccionDTO idto : result) {
							marcadores.add(drawBasicMarker(idto));	
						}
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub	
					}
				});
				this.schedule(30000);
			}};
		timer.schedule(1);
	}
	
	private void drawMap() {
		LatLng center = LatLng.newInstance(-34.4347865, -58.5785161);
		MapOptions opts = MapOptions.newInstance();
		opts.setZoom(13);
		opts.setCenter(center);
		opts.setMapTypeId(MapTypeId.ROADMAP);

		mapWidget = new MapWidget(opts);
		mapContainer.add(mapWidget);
		mapWidget.setSize("1200px", "800px");

		mapWidget.addClickHandler(new ClickMapHandler() {
			@Override
			public void onEvent(ClickMapEvent event) {
				// TODO fix the event getting, getting ....
				GWT.log("clicked on latlng=" + event.getMouseEvent().getLatLng());
			}
		});
	}


	private Marker drawBasicMarker(final InspeccionDTO idto) {
		final Marker markerBasic;
		LatLng center = LatLng.newInstance(idto.getLatitude(), idto.getLongitude());
		MarkerOptions options = MarkerOptions.newInstance();
		options.setPosition(center);
		options.setTitle("Inspeccion id: " + idto.getId());

		if (idto.getRiesgo() == 1)
			options.setIcon("http://google.com/mapfiles/ms/micons/green-dot.png");
		if (idto.getRiesgo() == 2)
			options.setIcon("http://google.com/mapfiles/ms/micons/yellow-dot.png");
		if (idto.getRiesgo() == 3)
			options.setIcon("http://google.com/mapfiles/ms/micons/red-dot.png");

		markerBasic = Marker.newInstance(options);
		markerBasic.setMap(mapWidget);

		markerBasic.addClickHandler(new ClickMapHandler() {
			@Override
			public void onEvent(ClickMapEvent event) {
				// Solo llama este metodo cuando se clikea el pin.
				InspeccionFilterDTO filter = new InspeccionFilterDTO();
				filter.inspeccionID = idto.getId();
				inspeccionServiceAsync.getInspeccionWithImage(filter, new AsyncCallback<InspeccionDTO>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSuccess(InspeccionDTO result) {
						String stringResult = 
								"<p style=\"margin-left: 6px; margin-right: 6px; font: 15px sans-serif;\"><b>ID: </b>"+ idto.getId() +"</p>\r\n" +
										"<p style=\"margin-left: 6px; margin-right: 6px; font: 15px sans-serif;\"><b>Fecha: </b>"+ /*ConversionUtil.getSimpleDate(*/idto.getFecha().toString()/*)*/ +"</p>\r\n" + 
										"<p style=\"margin-left: 6px; margin-right: 6px; font: 15px sans-serif;\"><b>Riesgo: </b>"+ /*ConversionUtil.getRiesgoString(*/getRiesgoString(idto.getRiesgo())/*)*/ +"</p>\r\n" +
										"<p style=\"margin-left: 6px; margin-right: 6px; font: 15px sans-serif;\"><b>Localidad: </b>"+ idto.getLocalidad().getNombre() +"</p>\r\n" +
										"<p style=\"margin-left: 6px; margin-right: 6px; font: 15px sans-serif;\"><b>Calle: </b>"+ idto.getCalle() +"</p>\r\n" +
										"<p style=\"margin-left: 6px; margin-right: 6px; font: 15px sans-serif;\"><b>Altura: </b>"+ idto.getAltura() +"</p>\r\n" +
										"<p style=\"margin-left: 6px; margin-right: 6px; font: 15px sans-serif;\"><b>Entre Calles: </b>"+ idto.getEntreCalleUno()+ " y " + idto.getEntreCalleDos() +"</p>\r\n" +
										"<p style=\"margin-left: 6px; margin-right: 6px; font: 15px sans-serif;\"><b>Tema: </b>"+ idto.getTema().getNombre() +"</p>\r\n" + 
										"<p style=\"margin-left: 6px; margin-right: 6px; font: 15px sans-serif;\"><b>Observaci&oacute;n: </b>" + idto.getObservacion()	+"</p>\r\n"+ 
										"<img src=\""+ "data:image/jpeg;base64," + result.getImg1() +"\"></img>"+
										"<img src=\""+ "data:image/jpeg;base64," + result.getImg2() +"\"></img>"+
										"<img src=\""+ "data:image/jpeg;base64," + result.getImg3() +"\"></img>";

						HTML html = new HTML(stringResult);
						InfoWindowOptions options = InfoWindowOptions.newInstance();
						options.setContent(html);
						InfoWindow iw = InfoWindow.newInstance(options);
						iw.open(mapWidget, markerBasic);
					}
				});
			}
		});	
		return markerBasic;
	}

	private String getRiesgoString(Integer i){
		switch (i) {
		case SiuConstants.BAJO:
			return "BAJO";
		case SiuConstants.MEDIO:
			return "MEDIO";
		case SiuConstants.ALTO:
			return "ALTO";
		default:
			return "ALTO";
		}
	}

	/*
	http://google.com/mapfiles/ms/micons/red-dot.png
	http://google.com/mapfiles/ms/micons/green-dot.png
	http://google.com/mapfiles/ms/micons/yellow-dot.png
	 */

}
