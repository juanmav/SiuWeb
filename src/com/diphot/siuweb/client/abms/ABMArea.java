package com.diphot.siuweb.client.abms;

import java.util.ArrayList;

import com.diphot.siuweb.client.services.AreaService;
import com.diphot.siuweb.client.services.AreaServiceAsync;
import com.diphot.siuweb.shared.dtos.AreaDTO;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.BaseListLoader;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BeanModelReader;
import com.extjs.gxt.ui.client.data.ListLoadResult;
import com.extjs.gxt.ui.client.data.ListLoader;
import com.extjs.gxt.ui.client.data.RpcProxy;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.TableData;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.TabPanel;


public class ABMArea extends Window{

	private TabPanel tabPanel;
	private TabItem busquedaTab;
	private TabItem crearTab;
	private TabItem editarTab;
	
	private final int alto = 500;
	private final int ancho = 400;
	
	private final AreaServiceAsync areaServiceAsync = GWT.create(AreaService.class);
	//private final GreetingServiceAsync greetservicet = GWT.create(GreetingService.class);
	
	private Grid<BaseModel> grid;
	
	public ABMArea(){
		setSize(ancho, alto);
		this.setHeading("ABM - Area");
		ToolBar toolbar = new ToolBar();
		Button crear = new Button("Crear");
		Button eliminar = new Button("Eliminar");
		Button editar = new Button("Editar");
		toolbar.add(crear);
		toolbar.add(eliminar);
		toolbar.add(editar);
		this.setTopComponent(toolbar);

		this.tabPanel = new TabPanel();
		tabPanel.setWidth("100%");

		this.busquedaTab = new TabItem("Busqueda");
		this.busquedaTab.setLayout(new FormLayout());
		grillaBusqueda(busquedaTab);
		tabPanel.add(busquedaTab,"Busqueda"); 

		this.crearTab = new TabItem("Crear");
		crearFormularioAlta(crearTab);
		tabPanel.add(crearTab, "Crear");  

		this.editarTab = new TabItem("Editar");
		crearFormularioEdicion(editarTab);
		tabPanel.add(editarTab,"Editar");

		this.add(tabPanel);
	}
	
	
	protected void crearFormularioAlta(TabItem tbitem){
		final TextField<Long> id = new TextField<Long>();
		id.setFieldLabel("id: ");
		id.setEnabled(false);
		final TextField<String> nombre = new TextField<String>();
		nombre.setFieldLabel("Nombre: ");

		tbitem.add(id);
		tbitem.add(nombre);

		HorizontalPanel hp = new HorizontalPanel();
		//hp.setWidth(300);
		hp.setTableWidth("100%");
		TableData td = new TableData();
		td.setHorizontalAlign(HorizontalAlignment.RIGHT);

		Button salvar = new Button("Salvar");

		salvar.addListener(Events.OnClick, new Listener<BaseEvent>(){
			@Override
			public void handleEvent(BaseEvent be) {
				AreaDTO dto = new AreaDTO();
				dto.setId(id.getValue());
				dto.setNombre(nombre.getValue());
				areaServiceAsync.create(dto, new AsyncCallback<Void>() {
					@Override
					public void onSuccess(Void result) {
						Info.display("Informacion: ", "El registro ha sido guardado");
					}

					@Override
					public void onFailure(Throwable caught) {
						Info.display("ERROR: ", "ERROR pruebe en unos instantes y/o comuniquese con el Admin");
					}
				});
			}
		});
		hp.add(salvar, td);
		tbitem.add(hp);
	}
	
	
	protected void crearFormularioEdicion(TabItem tab){
		
	}
	
	
	protected void grillaBusqueda(TabItem tab){
		RpcProxy<ArrayList<AreaDTO>> proxy = new  RpcProxy<ArrayList<AreaDTO>>(){
			@Override
			protected void load(Object loadConfig, final AsyncCallback<ArrayList<AreaDTO>> callback) {
				areaServiceAsync.getList( new AsyncCallback<ArrayList<AreaDTO>>() {
					@Override
					public void onFailure(Throwable caught) {
						callback.onFailure(caught);
					}
					@Override
					public void onSuccess(ArrayList<AreaDTO> result) {
						callback.onSuccess(result);
					}
				});
			}
		};

		ListLoader<ListLoadResult<BaseModel>> loader = new BaseListLoader<ListLoadResult<BaseModel>>(proxy, new BeanModelReader());
		loader.load();
		ListStore<BaseModel> store =  new ListStore<BaseModel>(loader);
			
		this.grid = new Grid<BaseModel> (store, gridColumnConfig());
		
		
		ContentPanel filtros = new ContentPanel();
		filtros.setFooter(true);
		filtros.setHeading("Filtros");
		filtros.setTitle("Filtros");
		filtros.setLayout(new FormLayout());
		
		filtrosForm(filtros);
		
		
		tab.add(grid);
		tab.add(filtros);
	}
	
	protected ColumnModel gridColumnConfig() {
		ArrayList<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		
		ColumnConfig c = new ColumnConfig();
		c.setId("id");
		c.setHeader("id");
		c.setWidth(40);
		configs.add(c);
		
		c =  new ColumnConfig();
		c.setId("nombre");
		c.setHeader("Nombre");
		c.setWidth(100);
		configs.add(c);
		
		ColumnModel columnmodel = new ColumnModel(configs);	
		return columnmodel;
	}
	
	protected void filtrosForm(ContentPanel filtrosContentPanel){
		TextField<String> nombre = new TextField<String>();
		nombre.setFieldLabel("Nombre");
		
		Button filtrar = new Button("Filtrar");
		
		HorizontalPanel hp = new HorizontalPanel();
		//hp.setWidth(300);
		hp.setTableWidth("100%");
		TableData td = new TableData();
		td.setHorizontalAlign(HorizontalAlignment.RIGHT);
		hp.add(filtrar);
		filtrosContentPanel.add(nombre);
		filtrosContentPanel.add(hp);
	}
	
	
	
	
}
