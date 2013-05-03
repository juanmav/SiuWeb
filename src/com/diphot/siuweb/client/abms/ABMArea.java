package com.diphot.siuweb.client.abms;

import java.util.ArrayList;

import com.diphot.siuweb.shared.dtos.AreaDTO;
import com.diphot.siuweb.shared.dtos.filters.AreaFilterDTO;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;

public class ABMArea extends AbstractABM<AreaDTO> {

	// Estos campos son para el formulario de edicion.
	private TextField<Long> idField = new TextField<Long>();
	private TextField<String> nombreField = new TextField<String>();
	
	public ABMArea(){
		// Fuerzo la llamada del super() con el DTO que corresponda.
		super(new AreaDTO());
	}

	// Los campos necesarios para este metodo quedan dentro del scope
	// del mismo por eso no se hacen atributos de clase.
	@Override
	protected void crearFormularioAlta(TabItem tbitem, Button salvarBTN){
		// Creo el formulario
		final TextField<Long> idCreateField = new TextField<Long>();
		idCreateField.setFieldLabel("id: ");
		idCreateField.setEnabled(false);
		final TextField<String> nombreCreateField = new TextField<String>();
		nombreCreateField.setFieldLabel("Nombre: ");
		tbitem.add(idCreateField);
		tbitem.add(nombreCreateField);

		// Solo agrego el listener al boton salvar
		// le indico como leer el formulario y llamar a salvar(dto)
		salvarBTN.addListener(Events.OnClick, new Listener<BaseEvent>(){
			@Override
			public void handleEvent(BaseEvent be) {
				AreaDTO dto = new AreaDTO();
				dto.setId(idCreateField.getValue());
				dto.setNombre(nombreCreateField.getValue());
				// Salvar es funcion de la superclase
				salvar(dto);
				
				// Limpio el formulario
				idCreateField.clear();
				nombreCreateField.clear();
			}
		});
	}

	// Generar la configuracion de columnas.
	@Override
	protected ColumnModel gridColumnConfig() {
		ArrayList<ColumnConfig> configs = new ArrayList<ColumnConfig>();

		ColumnConfig c = new ColumnConfig();
		c.setId("id");
		c.setHeader("id");
		c.setWidth(35);
		configs.add(c);

		c =  new ColumnConfig();
		c.setId("nombre");
		c.setHeader("Nombre");
		c.setWidth(200);
		configs.add(c);

		ColumnModel columnmodel = new ColumnModel(configs);	
		return columnmodel;
	}

	// Los campos necesarios para este metodo quedan dentro del scope
	// del mismo por eso no se hacen atributos de clase.
	@Override
	protected void crearFiltrosForm(ContentPanel filtrosContentPanel, Button filtrarBTN){
		TextField<String> nombre = new TextField<String>();
		nombre.setFieldLabel("Nombre");
		filtrosContentPanel.add(nombre);
		
		// Solo agrego el listener al boton salvar
		// le indico como leer el formulario y llamar a filter(FilterDTO) y limpiar el formulario
		filtrarBTN.addListener(Events.OnClick, new Listener<BaseEvent>(){
			@Override
			public void handleEvent(BaseEvent be) {
				AreaFilterDTO filter = new AreaFilterDTO();
				filter(filter);
			}
		});
		
	}
	
	// Este metodo viene del doble click de la grilla o el boton edicion.
	@Override
	protected void escribirFormEdicion(AreaDTO value) {
		System.out.println("Para editar" + value.getNombre());
		this.idField.setValue(value.getId());
		this.nombreField.setValue(value.getNombre());
	}
	
	@Override
	protected void crearFormularioEdicion(TabItem tbitem, Button updateBTN){
		// Creo el formulario
		this.idField = new TextField<Long>();
		this.idField.setFieldLabel("id ");
		idField.setEnabled(false);
		
		this.nombreField = new TextField<String>();
		this.nombreField.setFieldLabel("Nombre ");
		tbitem.add(idField);
		tbitem.add(nombreField);

		// Solo agrego el listener al boton salvar
		// le indico como leer el formulario y llamar a salvar(dto) y limpiar el formulario
		updateBTN.addListener(Events.OnClick, new Listener<BaseEvent>(){
			@Override
			public void handleEvent(BaseEvent be) {
				AreaDTO dto = new AreaDTO();
				dto.setId(idField.getValue());
				dto.setNombre(nombreField.getValue());
				// Salvar es funcion de la superclase
				update(dto);
				
				// Limpio el formulario
				idField.clear();
				nombreField.clear();
			}
		});
	}
}
