package com.diphot.siuweb.client.abms;

import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.ui.TabPanel;

public abstract class AbstractABM <T>  {

	
	
	public AbstractABM(){
		
	}
	
	protected abstract void grillaBusqueda(TabItem tabitem);
	protected abstract void crearFormularioAlta(TabItem tabitem);
	protected abstract void crearFormularioEdicion(TabItem tabitem);
	protected abstract ColumnModel gridColumnConfig();
}
