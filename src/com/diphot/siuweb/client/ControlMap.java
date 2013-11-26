package com.diphot.siuweb.client;

import java.util.ArrayList;

import com.diphot.siuweb.client.services.InspeccionService;
import com.diphot.siuweb.client.services.InspeccionServiceAsync;
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
		
		InspeccionFilterDTO filter = new InspeccionFilterDTO();
		filter.estadoID = 2;
		filter.desde = "15/09/2013";
		filter.hasta = "30/11/2013";

		inspeccionServiceAsync.getInspeccionesDTO(filter, new AsyncCallback<ArrayList<InspeccionDTO>>() {
			@Override
			public void onSuccess(ArrayList<InspeccionDTO> result) {
				for (InspeccionDTO idto : result) {
					drawBasicMarker(idto);
				}
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub	
			}
		});
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


	private void drawBasicMarker(final InspeccionDTO idto) {
		final Marker markerBasic;
		LatLng center = LatLng.newInstance(idto.getLatitude(), idto.getLongitude());
		MarkerOptions options = MarkerOptions.newInstance();
		options.setPosition(center);
		options.setTitle("Inspeccion id: " + idto.getId());

		markerBasic = Marker.newInstance(options);
		markerBasic.setMap(mapWidget);

		markerBasic.addClickHandler(new ClickMapHandler() {
			@Override
			public void onEvent(ClickMapEvent event) {
				HTML html = new HTML(getInspeccionHMTL(idto));
				InfoWindowOptions options = InfoWindowOptions.newInstance();
				options.setContent(html);
				InfoWindow iw = InfoWindow.newInstance(options);
				iw.open(mapWidget, markerBasic);
			}
		});
	}
	
	private String getInspeccionHMTL(InspeccionDTO idto){
		String result = 
				"<p style=\"margin-left: 6px; margin-right: 6px; font: 15px sans-serif;\"><strong>ID: </strong>"+ idto.getId() +"</p>\r\n" +
				"<p style=\"margin-left: 6px; margin-right: 6px; font: 15px sans-serif;\"><strong>Fecha: </strong>"+ /*ConversionUtil.getSimpleDate(*/idto.getFecha().toString()/*)*/ +"</p>\r\n" + 
				"<p style=\"margin-left: 6px; margin-right: 6px; font: 15px sans-serif;\"><strong>Riesgo: </strong>"+ /*ConversionUtil.getRiesgoString(*/idto.getRiesgo()/*)*/ +"</p>\r\n" +
				"<p style=\"margin-left: 6px; margin-right: 6px; font: 15px sans-serif;\"><strong>Localidad: </strong>"+ idto.getLocalidad().getNombre() +"</p>\r\n" +
				"<p style=\"margin-left: 6px; margin-right: 6px; font: 15px sans-serif;\"><strong>Calle: </strong>"+ idto.getCalle() +"</p>\r\n" +
				"<p style=\"margin-left: 6px; margin-right: 6px; font: 15px sans-serif;\"><strong>Altura: </strong>"+ idto.getAltura() +"</p>\r\n" +
				"<p style=\"margin-left: 6px; margin-right: 6px; font: 15px sans-serif;\"><strong>Entre Calles: </strong>"+ idto.getEntreCalleUno()+ " y " + idto.getEntreCalleDos() +"</p>\r\n" +
				"<p style=\"margin-left: 6px; margin-right: 6px; font: 15px sans-serif;\"><strong>Tema: </strong>"+ idto.getTema().getNombre() +"</p>\r\n" + 
				"<p style=\"margin-left: 6px; margin-right: 6px; font: 15px sans-serif;\"><strong>Observaci&oacute;n: </strong>" + idto.getObservacion()	+"</p>\r\n";
		return result;
	}
	
}
