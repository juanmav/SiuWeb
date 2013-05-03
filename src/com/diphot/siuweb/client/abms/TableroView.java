package com.diphot.siuweb.client.abms;

import java.util.ArrayList;

import com.diphot.siuweb.client.services.DiphotService;
import com.diphot.siuweb.client.services.DiphotServiceAsync;
import com.diphot.siuweb.shared.InterfaceDTO;
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
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.extjs.gxt.ui.client.data.BeanModel;

public class TableroView extends Window {

	private final DiphotServiceAsync diphotServiceAsync = GWT.create(DiphotService.class);
	
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
		
		this.addButton(new Button("Filtrar"));
		
	}
	
	private ComboBox<BaseModel> areaCombobox(){
		RpcProxy<ArrayList<InterfaceDTO>> proxy = new  RpcProxy<ArrayList<InterfaceDTO>>(){
			@Override
			protected void load(Object loadConfig, final AsyncCallback<ArrayList<InterfaceDTO>> callback) {
				diphotServiceAsync.getList(new AreaDTO(), new AsyncCallback<ArrayList<InterfaceDTO>>() {
					@Override
					public void onFailure(Throwable caught) {
						callback.onFailure(caught);
					}

					@Override
					public void onSuccess(ArrayList<InterfaceDTO> result) {
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
		combobox.setFieldLabel("Area");
		combobox.setWidth(150);
		combobox.setAllowBlank(false);
		combobox.setEditable(false);
		combobox.setStore(store);
		combobox.setTriggerAction(TriggerAction.ALL);
		return combobox;
	}
	
	private ComboBox<BaseModel> tiposCombobox(){
		RpcProxy<ArrayList<InterfaceDTO>> proxy = new  RpcProxy<ArrayList<InterfaceDTO>>(){
			@Override
			protected void load(Object loadConfig, final AsyncCallback<ArrayList<InterfaceDTO>> callback) {
				diphotServiceAsync.getList(new TipoRelevamientoDTO(), new AsyncCallback<ArrayList<InterfaceDTO>>() {
					@Override
					public void onFailure(Throwable caught) {
						callback.onFailure(caught);
					}

					@Override
					public void onSuccess(ArrayList<InterfaceDTO> result) {
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
		combobox.setFieldLabel("Tipo Relevamiento");
		combobox.setWidth(150);
		combobox.setAllowBlank(false);
		combobox.setEditable(false);
		combobox.setStore(store);
		combobox.setTriggerAction(TriggerAction.ALL);
		return combobox;
	}
	
	private ComboBox<BaseModel> temasCombobox(){
		RpcProxy<ArrayList<InterfaceDTO>> proxy = new  RpcProxy<ArrayList<InterfaceDTO>>(){
			@Override
			protected void load(Object loadConfig, final AsyncCallback<ArrayList<InterfaceDTO>> callback) {
				diphotServiceAsync.getList(new TemaDTO(), new AsyncCallback<ArrayList<InterfaceDTO>>() {
					@Override
					public void onFailure(Throwable caught) {
						callback.onFailure(caught);
					}

					@Override
					public void onSuccess(ArrayList<InterfaceDTO> result) {
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
		combobox.setFieldLabel("Tema");
		combobox.setWidth(150);
		combobox.setAllowBlank(false);
		combobox.setEditable(false);
		combobox.setStore(store);
		combobox.setTriggerAction(TriggerAction.ALL);
		return combobox;
	}
	
	
	private void initGrid(){
		RpcProxy<ArrayList<InterfaceDTO>> proxy = new  RpcProxy<ArrayList<InterfaceDTO>>(){
			@Override
			protected void load(Object loadConfig, final AsyncCallback<ArrayList<InterfaceDTO>> callback) {
				diphotServiceAsync.getList(new InspeccionDTO(), new AsyncCallback<ArrayList<InterfaceDTO>>() {
					@Override
					public void onFailure(Throwable caught) {
						callback.onFailure(caught);
					}
					@Override
					public void onSuccess(ArrayList<InterfaceDTO> result) {
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
		
		c = new ColumnConfig();
		c.setId("tema");
		c.setHeader("Tema");
		c.setWidth(100);
		configs.add(c);
		ColumnModel columnmodel = new ColumnModel(configs);	
		return columnmodel;
	}
	
	/*
	 * GridCellRenderer<BaseModel> change = new GridCellRenderer<BaseModel>() {
			@Override
			public Object render(BaseModel model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<BaseModel> store, Grid<BaseModel> grid) {
					return (model.get(property));
			}
		};
		c.setRenderer(change);
	 * 
	 * */
}
