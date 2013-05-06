package com.diphot.siuweb.client.abms;

import com.diphot.siuweb.shared.dtos.InspeccionDTO;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.maps.client.MapOptions;
import com.google.gwt.maps.client.MapTypeId;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.base.LatLng;
import com.google.gwt.maps.client.overlays.Marker;
import com.google.gwt.maps.client.overlays.MarkerOptions;
import com.google.gwt.user.client.ui.Image;

public class InspeccionView extends Window{

	private MapWidget mapWidget;
	private Marker marker;

	public InspeccionView(InspeccionDTO iDTO) {

		setWidth(700);
		setHeight(550);
		setLayout(new FormLayout());
		
		HorizontalPanel hz = new HorizontalPanel();
		ContentPanel cp = new ContentPanel(new FormLayout());
		cp.setHeading("Detalle Inspeccion");
		TextField<Long> id = new TextField<Long>();
		id.setFieldLabel("id");
		id.setValue(iDTO.getId());
		id.disable();
		TextField<String> calle = new TextField<String>();
		calle.setFieldLabel("Calle");
		calle.setValue(iDTO.getCalle());
		calle.disable();
		TextField<Integer> altura = new TextField<Integer>();
		altura.setFieldLabel("Altura");
		altura.setValue(iDTO.getAltura());
		altura.disable();

		TextArea observacion = new TextArea();
		observacion.setFieldLabel("Observacion");
		observacion.setValue(iDTO.getObservacion());
		observacion.disable();

		cp.add(id);
		cp.add(calle);
		cp.add(altura);
		cp.add(observacion);
		cp.setSize("350px", "250px");
		hz.add(cp);
		this.add(hz);
		hz.add(drawMap(iDTO.getLatitude(), iDTO.getLongitude()));
		
		HorizontalPanel hp = new HorizontalPanel();
		hp.setSize(300, 100);
		hp.setBorders(true);
		Image img1 = new Image();
		img1.setSize("233px", "233px");
		Image img2 = new Image();
		img2.setSize("233px", "233px");
		Image img3 = new Image();
		img3.setSize("233px", "233px");
		hp.add(img1);
		img1.setUrl("data:image/jpeg;base64," + iDTO.getImg1());
		hp.add(img2);
		img2.setUrl("data:image/jpeg;base64," + iDTO.getImg2());
		hp.add(img3);
		img3.setUrl("data:image/jpeg;base64," + iDTO.getImg3());
		this.add(hp);

		Button close = new Button("Listo");
		close.addListener(Events.OnClick, new Listener<BaseEvent>(){
			@Override
			public void handleEvent(BaseEvent be) {
				hide();
			}
		});
		this.addButton(close);
		
		drawBasicMarker(iDTO.getLatitude(), iDTO.getLongitude());
	}

	private MapWidget drawMap(Double lat, Double lng) {
		LatLng center = LatLng.newInstance(lat, lng);
		MapOptions opts = MapOptions.newInstance();
		opts.setZoom(17);
		opts.setCenter(center);
		opts.setMapTypeId(MapTypeId.HYBRID);

		mapWidget = new MapWidget(opts);
		mapWidget.setSize("350px", "250px");
		return mapWidget;
	}

	private void drawBasicMarker(Double lat, Double lng) {
		LatLng center = LatLng.newInstance(lat, lng);
		MarkerOptions options = MarkerOptions.newInstance();
		options.setPosition(center);
		options.setTitle("Hello World");

		marker = Marker.newInstance(options);
		marker.setMap(mapWidget);

		/*markerBasic.addClickHandler(new ClickMapHandler() {
			@Override
			public void onEvent(ClickMapEvent event) {
				drawInfoWindow(markerBasic, event.getMouseEvent());
			}
		});*/
	}
}
