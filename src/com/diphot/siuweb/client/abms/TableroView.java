package com.diphot.siuweb.client.abms;

import java.util.ArrayList;

import com.diphot.siuweb.client.services.AreaService;
import com.diphot.siuweb.client.services.AreaServiceAsync;
import com.diphot.siuweb.client.services.InspeccionService;
import com.diphot.siuweb.client.services.InspeccionServiceAsync;
import com.diphot.siuweb.client.services.TemaService;
import com.diphot.siuweb.client.services.TemaServiceAsync;
import com.diphot.siuweb.client.services.TipoRelevamientoService;
import com.diphot.siuweb.client.services.TipoRelevamientoServiceAsync;
import com.diphot.siuweb.server.business.Area;
import com.diphot.siuweb.shared.dtos.AreaDTO;
import com.diphot.siuweb.shared.dtos.TemaDTO;
import com.diphot.siuweb.shared.dtos.TipoRelevamientoDTO;
import com.diphot.siuweb.shared.dtos.InspeccionDTO;
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
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.extjs.gxt.ui.client.data.BeanModel;

public class TableroView extends Window {

	private final InspeccionServiceAsync inspeccionServiceAsync = GWT.create(InspeccionService.class);
	private final AreaServiceAsync areaServiceAsync = GWT.create(AreaService.class);
	private final TipoRelevamientoServiceAsync tipoRelevamientoServiceAsync = GWT.create(TipoRelevamientoService.class);
	private final TemaServiceAsync temaServiceAsync = GWT.create(TemaService.class);
	
	private final int alto = 500;
	private final int ancho = 600;
	
	private Grid<BaseModel> grid;
	
	public TableroView(){
		super();
		setSize(ancho, alto);
		setLayout(new FitLayout());
		initGrid();
		initFiltros();
	}
	
	private void initFiltros(){
		ContentPanel filtros = new ContentPanel(new FormLayout());
		filtros.setHeading("Filtros");
		
		TextField<Long> id = new TextField<Long>();
		id.setFieldLabel("id");
		TextField<String> calle = new TextField<String>();
		calle.setFieldLabel("Calle");
		TextField<Integer> altura = new TextField<Integer>();
		altura.setFieldLabel("Altura");
		
		filtros.add(id);
		filtros.add(calle);
		filtros.add(altura);
		
		ComboBox<BaseModel> areasCombo = areaCombobox();
		ComboBox<BaseModel> tiposCombo = tiposCombobox();
		ComboBox<BaseModel> temasCombo = temasCombobox();
		
		filtros.add(areasCombo);
		filtros.add(tiposCombo);
		filtros.add(temasCombo);
		
		this.setBottomComponent(filtros);
		
	}
	
	private ComboBox<BaseModel> areaCombobox(){
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
		ListLoader<ListLoadResult<BaseModel>> loader = new BaseListLoader<ListLoadResult<BaseModel>>(proxy,new BeanModelReader());
		loader.load();
		ListStore<BaseModel> store = new ListStore<BaseModel>(loader);
		ComboBox<BaseModel> combobox = new ComboBox<BaseModel>();
		combobox.setDisplayField("nombre");
		combobox.setWidth(150);
		combobox.setAllowBlank(false);
		combobox.setEditable(false);
		combobox.setStore(store);
		combobox.setTriggerAction(TriggerAction.ALL);
		return combobox;
	}
	
	private ComboBox<BaseModel> tiposCombobox(){
		RpcProxy<ArrayList<TipoRelevamientoDTO>> proxy = new  RpcProxy<ArrayList<TipoRelevamientoDTO>>(){
			@Override
			protected void load(Object loadConfig, final AsyncCallback<ArrayList<TipoRelevamientoDTO>> callback) {
				tipoRelevamientoServiceAsync.getList( new AsyncCallback<ArrayList<TipoRelevamientoDTO>>() {
					@Override
					public void onFailure(Throwable caught) {
						callback.onFailure(caught);
					}

					@Override
					public void onSuccess(ArrayList<TipoRelevamientoDTO> result) {
						callback.onSuccess(result);
					}

				});
			}
		};
		ListLoader<ListLoadResult<BaseModel>> loader = new BaseListLoader<ListLoadResult<BaseModel>>(proxy,new BeanModelReader());
		loader.load();
		ListStore<BaseModel> store = new ListStore<BaseModel>(loader);
		ComboBox<BaseModel> combobox = new ComboBox<BaseModel>();
		combobox.setDisplayField("nombre");
		combobox.setWidth(150);
		combobox.setAllowBlank(false);
		combobox.setEditable(false);
		combobox.setStore(store);
		combobox.setTriggerAction(TriggerAction.ALL);
		return combobox;
	}
	
	private ComboBox<BaseModel> temasCombobox(){
		RpcProxy<ArrayList<TemaDTO>> proxy = new  RpcProxy<ArrayList<TemaDTO>>(){
			@Override
			protected void load(Object loadConfig, final AsyncCallback<ArrayList<TemaDTO>> callback) {
				temaServiceAsync.getList( new AsyncCallback<ArrayList<TemaDTO>>() {
					@Override
					public void onFailure(Throwable caught) {
						callback.onFailure(caught);
					}

					@Override
					public void onSuccess(ArrayList<TemaDTO> result) {
						callback.onSuccess(result);
					}

				});
			}
		};
		ListLoader<ListLoadResult<BaseModel>> loader = new BaseListLoader<ListLoadResult<BaseModel>>(proxy,new BeanModelReader());
		loader.load();
		ListStore<BaseModel> store = new ListStore<BaseModel>(loader);
		ComboBox<BaseModel> combobox = new ComboBox<BaseModel>();
		combobox.setDisplayField("nombre");
		combobox.setWidth(150);
		combobox.setAllowBlank(false);
		combobox.setEditable(false);
		combobox.setStore(store);
		combobox.setTriggerAction(TriggerAction.ALL);
		return combobox;
	}
	
	
	private void initGrid(){
		RpcProxy<ArrayList<InspeccionDTO>> proxy = new  RpcProxy<ArrayList<InspeccionDTO>>(){
			@Override
			protected void load(Object loadConfig, final AsyncCallback<ArrayList<InspeccionDTO>> callback) {
				inspeccionServiceAsync.getList( new AsyncCallback<ArrayList<InspeccionDTO>>() {
					@Override
					public void onFailure(Throwable caught) {
						callback.onFailure(caught);
					}
					@Override
					public void onSuccess(ArrayList<InspeccionDTO> result) {
						callback.onSuccess(result);
					}
				});
			}
		};

		ListLoader<ListLoadResult<BaseModel>> loader = new BaseListLoader<ListLoadResult<BaseModel>>(proxy, new BeanModelReader());
		loader.load();
		ListStore<BaseModel> store =  new ListStore<BaseModel>(loader);
		this.grid = new Grid<BaseModel> (store, gridColumnConfig());
		
		/* Doble click sobre Fila*/
		grid.addListener(Events.OnDoubleClick, new Listener<BaseEvent>(){
			@Override
			public void handleEvent(BaseEvent be) {
				Info.display("Ver datos Fila!", "Mensaje!");
				InspeccionDTO b = (InspeccionDTO)((BeanModel)((grid).getSelectionModel().getSelectedItem())).getBean();
				InspeccionView iView = new InspeccionView(b);
				iView.show();
			}

		});
		
		/*Agrego la grilla a la ventana*/
		this.add(grid);
	}
	
	private ColumnModel gridColumnConfig() {
		ArrayList<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		
		ColumnConfig c = new ColumnConfig();
		c.setId("id");
		c.setHeader("id");
		c.setWidth(40);
		configs.add(c);
		
		c =  new ColumnConfig();
		c.setId("calle");
		c.setHeader("Calle");
		c.setWidth(100);
		configs.add(c);
		
		c =  new ColumnConfig();
		c.setId("altura");
		c.setHeader("Altura");
		c.setWidth(100);
		configs.add(c);
		
		c =  new ColumnConfig();
		c.setId("fecha");
		c.setHeader("Fecha");
		c.setWidth(100);
		configs.add(c);

		
		
		
		ColumnModel columnmodel = new ColumnModel(configs);	
		return columnmodel;
	}
	
}
