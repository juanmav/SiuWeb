package com.diphot.siuweb.client;


import com.diphot.siuweb.client.abms.ABMArea;
import com.diphot.siuweb.client.abms.TableroView;
import com.diphot.siuweb.client.abms.TreeView;
import com.diphot.siuweb.client.services.AreaService;
import com.diphot.siuweb.client.services.AreaServiceAsync;
import com.diphot.siuweb.client.services.InspeccionService;
import com.diphot.siuweb.client.services.InspeccionServiceAsync;
import com.diphot.siuweb.client.services.TemaService;
import com.diphot.siuweb.client.services.TemaServiceAsync;
import com.diphot.siuweb.client.services.TipoRelevamientoService;
import com.diphot.siuweb.client.services.TipoRelevamientoServiceAsync;
import com.extjs.gxt.ui.client.Style.Orientation;
 
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.ContentPanel;  
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;  
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.AccordionLayout;  
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;  
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
 
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Element;  
import com.google.gwt.user.client.rpc.AsyncCallback;
 

public class Menu extends LayoutContainer {
	@Override  
	protected void onRender(Element parent, int index) {  
		super.onRender(parent, index);  
		setLayout(new FlowLayout(10));  

		ContentPanel accordionPanel = new ContentPanel();  
		accordionPanel.setHeading("Menu Siu");  
		accordionPanel.setBodyBorder(false);  
		accordionPanel.setLayout(new AccordionLayout());
		accordionPanel.setHeight(500);
		tablero(accordionPanel);
		reportesMenu(accordionPanel);
	    adminMenu(accordionPanel);
	    populateMenu(accordionPanel);
	    add(accordionPanel);
	}
		
	private void tablero(ContentPanel accordionPanel){
		/* Reportes */
	    ContentPanel tablero = new ContentPanel();
		tablero.setAnimCollapse(false);  
		tablero.setHeading("Tablero Partido");  
		tablero.setLayout(new RowLayout(Orientation.VERTICAL));
		Button tableroControl = new Button("Tablero Control");
		
		tableroControl.addListener(Events.OnClick, new Listener<BaseEvent>(){
			@Override
			public void handleEvent(BaseEvent be) {
				TableroView tableroView = new TableroView();
				tableroView.show();
			}
		});
		
		tableroControl.setWidth(135);
		tablero.add(tableroControl);
		
		accordionPanel.add(tablero);
	}
	
	private void adminMenu(ContentPanel accordionPanel){
		/* Administracion */
		ContentPanel adminCP = new ContentPanel();
		adminCP.setAnimCollapse(false);  
		adminCP.setHeading("Administracion");  
		adminCP.setLayout(new RowLayout(Orientation.VERTICAL));  
	    
		Button area = new Button("ABM- Area");
		area.setWidth("100%");
		area.addListener(Events.OnClick, new Listener<BaseEvent>(){
			@Override
			public void handleEvent(BaseEvent be) {
				ABMArea a = new ABMArea();
				a.show();
			}
		});
		adminCP.add(area);
		Button tiporev = new Button("ABM- TipoRelevamiento");
		tiporev.setWidth("100%");
		adminCP.add(tiporev);
		
		Button tema = new Button("ABM- Tema");
		
		tema.setWidth("100%");
		adminCP.add(tema);
				
		accordionPanel.add(adminCP);
	}
	
	private void reportesMenu(ContentPanel accordionPanel){
		/* Reportes */
	    
	    ContentPanel reportesCP = new ContentPanel();
		reportesCP.setAnimCollapse(false);  
		reportesCP.setHeading("Reportes");  
		reportesCP.setLayout(new RowLayout(Orientation.VERTICAL));
		
		Button insp = new Button("Inspecciones");
		insp.setWidth("100%");
		reportesCP.add(insp);
		
		accordionPanel.add(reportesCP);
	}

	private void populateMenu(ContentPanel accordionPanel){
		/* Reportes */
	    ContentPanel populatorsContainer = new ContentPanel();
		populatorsContainer.setAnimCollapse(false);  
		populatorsContainer.setHeading("Creacion de Datos Aut.");  
		populatorsContainer.setLayout(new RowLayout(Orientation.VERTICAL));
		Button areaBTN = new Button("Crear Areas");
		areaBTN.setWidth("100%");
		areaBTN.addListener(Events.OnClick, new Listener<BaseEvent>(){
			@Override
			public void handleEvent(BaseEvent be) {
				final AreaServiceAsync areaServiceAsync = GWT.create(AreaService.class);
				areaServiceAsync.populateINIT(new AsyncCallback<Void>() {
					
					@Override
					public void onSuccess(Void result) {
						Info.display("Areas Creadas", "eso");
						
					}
					
					@Override
					public void onFailure(Throwable caught) {
						Info.display("FALLO Creacion areas!", "eso");
						
					}
				});
			}
		});
		
		Button tipoRelevBTN = new Button("Crear Tipos");
		tipoRelevBTN.setWidth("100%");
		tipoRelevBTN.addListener(Events.OnClick, new Listener<BaseEvent>(){
			@Override
			public void handleEvent(BaseEvent be) {
				final TipoRelevamientoServiceAsync tipoRelevamientoServiceAsync = GWT.create(TipoRelevamientoService.class);
				tipoRelevamientoServiceAsync.populateINIT(new AsyncCallback<Void>() {
					
					@Override
					public void onSuccess(Void result) {
						Info.display("Tipos Relevamiendos Creadas", "eso");
						
					}
					
					@Override
					public void onFailure(Throwable caught) {
						Info.display("FALLO Creacion Tipos Relevamientos!", "eso");
					}
				});
			}
		});
		
		Button temasvBTN = new Button("Crear Temas");
		temasvBTN.setWidth("100%");
		temasvBTN.addListener(Events.OnClick, new Listener<BaseEvent>(){
			@Override
			public void handleEvent(BaseEvent be) {
				final TemaServiceAsync tipoRelevamientoServiceAsync = GWT.create(TemaService.class);
				tipoRelevamientoServiceAsync.populateINIT(new AsyncCallback<Void>() {
					
					@Override
					public void onSuccess(Void result) {
						Info.display("Temas Creadas", "eso");
						
					}
					
					@Override
					public void onFailure(Throwable caught) {
						Info.display("FALLO Creacion Temas!", "eso");
					}
				});
			}
		});
		
		Button inspeccionesBTN = new Button("Crear Inspecciones de Ejemplo");
		inspeccionesBTN.setWidth("100%");
		inspeccionesBTN.addListener(Events.OnClick, new Listener<BaseEvent>(){
			@Override
			public void handleEvent(BaseEvent be) {
				final InspeccionServiceAsync tipoRelevamientoServiceAsync = GWT.create(InspeccionService.class);
				tipoRelevamientoServiceAsync.examplesCreate(new AsyncCallback<Void>() {
					
					@Override
					public void onSuccess(Void result) {
						Info.display("Ejemplos Creados", "eso");
					}
					
					@Override
					public void onFailure(Throwable caught) {
						Info.display("FALLO Ejemplos Creados", "eso");
					}
				});
			}
		});
		
		populatorsContainer.add(areaBTN);
		populatorsContainer.add(tipoRelevBTN);
		populatorsContainer.add(temasvBTN);
		populatorsContainer.add(inspeccionesBTN);
		
		accordionPanel.add(populatorsContainer);
	}
	
}
