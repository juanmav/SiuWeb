package com.diphot.siuweb.client.abms;

import java.util.ArrayList;

import com.diphot.siuweb.client.services.DiphotService;
import com.diphot.siuweb.client.services.DiphotServiceAsync;
import com.diphot.siuweb.client.util.ConoBaseListLoader;
import com.diphot.siuweb.shared.dtos.InterfaceDTO;
import com.diphot.siuweb.shared.dtos.filters.FilterInterfaceDTO;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BeanModel;
import com.extjs.gxt.ui.client.data.BeanModelReader;
import com.extjs.gxt.ui.client.data.ListLoadResult;
import com.extjs.gxt.ui.client.data.ListLoader;
import com.extjs.gxt.ui.client.data.RpcProxy;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.TableData;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.TabPanel;

public abstract class  AbstractABM <T extends InterfaceDTO>  extends Window{

	private InterfaceDTO abstractDTO;
	private TabPanel tabPanel;
	private TabItem busquedaTab;
	private TabItem crearTab;
	private TabItem editarTab;

	private final int alto = 500;
	private final int ancho = 400;

	private Grid<BaseModel> grid;

	private final DiphotServiceAsync diphotServiceAsync = GWT.create(DiphotService.class);

	public AbstractABM(T dto){
		this.abstractDTO = dto;
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
		this.crearTab.setLayout(new FormLayout());
		Button alta = new Button("Crear");
		crearFormularioAlta(crearTab, alta);
		agregarBotonfinalForm(crearTab,alta);
		tabPanel.add(crearTab, "Crear");  

		this.editarTab = new TabItem("Editar");
		this.editarTab.setLayout(new FormLayout());
		Button edicionBTN = new Button("Actualizar");
		crearFormularioEdicion(editarTab, edicionBTN);
		agregarBotonfinalForm(editarTab,edicionBTN);
		tabPanel.add(editarTab,"Editar");

		this.add(tabPanel);
		tabPanel.selectTab(1);
		busquedaTab.layout();
	}

	private void agregarBotonfinalForm(TabItem tab, Button salvarBTN){
		HorizontalPanel hp = new HorizontalPanel();
		hp.setTableWidth("100%");
		TableData td = new TableData();
		td.setHorizontalAlign(HorizontalAlignment.RIGHT);
		hp.add(salvarBTN, td);
		tab.add(hp);
	}
	
	private void agregarBotonfinalFormFiltros(ContentPanel cp, Button salvarBTN){
		HorizontalPanel hp = new HorizontalPanel();
		hp.setTableWidth("100%");
		TableData td = new TableData();
		td.setHorizontalAlign(HorizontalAlignment.RIGHT);
		hp.add(salvarBTN, td);
		cp.add(hp);
	}

	protected void grillaBusqueda(TabItem tab){
		RpcProxy<ArrayList<InterfaceDTO>> proxy = new  RpcProxy<ArrayList<InterfaceDTO>>(){
			@Override
			protected void load(Object loadConfig, final AsyncCallback<ArrayList<InterfaceDTO>> callback) {
				diphotServiceAsync.getList(abstractDTO, new AsyncCallback<ArrayList<InterfaceDTO>>() {
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

		// El ConoBaseListLoader te permite acceder al proxy del store y modificalo
		// de esta manera no hay que re generar todos los objetos y se puede traer
		// una grilla filtrada.
		
		ListLoader<ListLoadResult<BaseModel>> loader = new ConoBaseListLoader<ListLoadResult<BaseModel>>(proxy, new BeanModelReader());
		loader.load();
		ListStore<BaseModel> store =  new ListStore<BaseModel>(loader);

		this.grid = new Grid<BaseModel> (store, gridColumnConfig());
		
		// En doble click nos lleva al formulario de edicion y lo escribe.
		this.grid.addListener(Events.RowDoubleClick, new Listener<GridEvent<BeanModel>>(){
			@SuppressWarnings("unchecked")
			@Override
			public void handleEvent(GridEvent<BeanModel> be) {
				escribirFormEdicion(  (T)be.getModel().getBean());
				editarTab.layout();
			}
		});


		ContentPanel filtros = new ContentPanel();
		filtros.setFooter(true);
		filtros.setHeading("Filtros");
		filtros.setTitle("Filtros");
		filtros.setLayout(new FormLayout());
		
		Button filtroBTN = new Button("Filtrar");
		crearFiltrosForm(filtros,filtroBTN);
		agregarBotonfinalFormFiltros(filtros, filtroBTN);
		tab.add(grid);
		tab.add(filtros);
	}

	protected void salvar(InterfaceDTO dto){
		diphotServiceAsync.create(dto, new AsyncCallback<Long>() {
			@Override
			public void onSuccess(Long result) {
				Info.display("Informacion: ", "El registro ha sido guardado");
			}

			@Override
			public void onFailure(Throwable caught) {
				Info.display("ERROR: ", "ERROR pruebe en unos instantes y/o comuniquese con el Admin");
			}
		});
	}

	protected void update(InterfaceDTO dto){
		diphotServiceAsync.update(dto, new AsyncCallback<Void>() {
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

	
	// Este metodo toma el filtro y cambia los resultados de la grilla
	protected void filter(final FilterInterfaceDTO filter){
		ListLoader<ListLoadResult<BaseModel>> loader = (ListLoader<ListLoadResult<BaseModel>>)(grid.getStore().getLoader());
		RpcProxy<ArrayList<InterfaceDTO>> proxy = new RpcProxy<ArrayList<InterfaceDTO>>() {
			@Override
			protected void load(Object loadConfig, final AsyncCallback<ArrayList<InterfaceDTO>> callback) {
				diphotServiceAsync.getList(abstractDTO,filter, new AsyncCallback<ArrayList<InterfaceDTO>>() {
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
		((ConoBaseListLoader<ListLoadResult<BaseModel>>)loader).setProxy(proxy);
		loader.load();
	}
	
	abstract protected ColumnModel gridColumnConfig();
	abstract protected void crearFiltrosForm(ContentPanel filtrosContentPanel, Button filtroBTN);
	abstract protected void crearFormularioAlta(TabItem tbitem, Button altaBTN);
	abstract protected void crearFormularioEdicion(TabItem tab, Button updateBTN);
	abstract protected void escribirFormEdicion(T value);
}
