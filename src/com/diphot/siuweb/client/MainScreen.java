package com.diphot.siuweb.client;

import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class MainScreen extends Composite {

	private static MainScreenUiBinder uiBinder = GWT
			.create(MainScreenUiBinder.class);

	interface MainScreenUiBinder extends UiBinder<Widget, MainScreen> {
	}

	public MainScreen() {
		initWidget(uiBinder.createAndBindUi(this));
		this.menuPanel.add(new Menu());
	}
	
	@UiField
	FlowPanel menuPanel;
	@UiField
	FlowPanel desktop;
}
