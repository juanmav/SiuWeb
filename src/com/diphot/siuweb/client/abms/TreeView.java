package com.diphot.siuweb.client.abms;

import java.util.ArrayList;

import com.diphot.siuweb.client.services.DiphotService;
import com.diphot.siuweb.client.services.DiphotServiceAsync;
import com.diphot.siuweb.shared.dtos.AreaDTO;
import com.diphot.siuweb.shared.dtos.InterfaceDTO;
import com.diphot.siuweb.shared.dtos.TipoRelevamientoDTO;
import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGrid;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGridCellRenderer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class TreeView extends Window{
	
	private final DiphotServiceAsync diphotServiceAsync = GWT.create(DiphotService.class);

	private AreaTree raiz = new AreaTree(0L, "Raiz");
	
	
	public TreeView(){
			//setLayout(new FitLayout());
		diphotServiceAsync.getList(new AreaDTO(), new AsyncCallback<ArrayList<InterfaceDTO>>() {
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onSuccess(ArrayList<InterfaceDTO> result) {
				for (InterfaceDTO idto : result){
					AreaDTO adto = (AreaDTO)idto;
					AreaTree atree = new AreaTree(adto.getId(), adto.getNombre());
					raiz.add(atree);
				}
				//getTipoRelevamientoTree();
			}
		});
		
		/*Button b = new Button("Paciencia");
		b.addListener(Events.OnClick, new Listener<BaseEvent>(){

			@Override
			public void handleEvent(BaseEvent be) {
				createTreeGrid();
			}
			
		});
		this.add(b);*/
	}

	private void getTipoRelevamientoTree(){
		raiz.getChildren();
		diphotServiceAsync.getList(new TipoRelevamientoDTO(), new AsyncCallback<ArrayList<InterfaceDTO>>() {
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onSuccess(ArrayList<InterfaceDTO> result) {
				for (InterfaceDTO idto : result){
					TipoRelevamientoDTO tdto = (TipoRelevamientoDTO)idto;
				}
			}
		});

	}
	
	private void createTreeGrid(){
		TreeStore<ModelData> store = new TreeStore<ModelData>();
		store.add(raiz.getChildren(), true);
		
		ArrayList<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		ColumnConfig name = new ColumnConfig("name", "Name", 100);
		name.setRenderer(new TreeGridCellRenderer<ModelData>());
		configs.add(name);
		ColumnModel cm = new ColumnModel(configs);
		
		
		TreeGrid<ModelData> treeGrid = new TreeGrid<ModelData>(store,cm);
	    treeGrid.setBorders(true);
	    //tree.getStyle().setLeafIcon(Resources.ICONS.music());
	    treeGrid.setAutoExpandColumn("name");
	    treeGrid.setTrackMouseOver(false);
	    treeGrid.setSize(300, 300);
	    this.add(treeGrid);
	}
	

	@SuppressWarnings("serial")
	class AreaTree extends BaseTreeModel {
		
		public AreaTree(Long id, String name) {
			set("id", id);
			set("name", name);
		}

		public void addChildres(BaseTreeModel[] children) {
			for (int i = 0; i < children.length; i++) {
				add(children[i]);
			}
		}
		
		public Integer getId() {
			return (Integer) get("id");
		}

		public String getName() {
			return (String) get("name");
		}

		public String toString() {
			return getName();
		}

	}
	
	class TipoRelevamientoTree extends BaseTreeModel{
		public TipoRelevamientoTree(Long id, String name) {
			set("id", id);
			set("name", name);
		}
		public void addChildres(BaseTreeModel[] children) {
			for (int i = 0; i < children.length; i++) {
				add(children[i]);
			}
		}
		public Integer getId() {
			return (Integer) get("id");
		}
		public String getName() {
			return (String) get("name");
		}
		public String toString() {
			return getName();
		}
	}
}
