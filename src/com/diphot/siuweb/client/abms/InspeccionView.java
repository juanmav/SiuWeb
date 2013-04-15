package com.diphot.siuweb.client.abms;

import com.diphot.siuweb.shared.dtos.InspeccionDTO;
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.user.client.ui.Image;

public class InspeccionView extends Window{

	public InspeccionView(InspeccionDTO iDTO) {
		
		setWidth(350);
		setLayout(new FormLayout());
		
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
				
		this.add(id);
		this.add(calle);
		this.add(altura);
		
		HorizontalPanel hp = new HorizontalPanel();
		hp.setSize(300, 100);
		hp.setBorders(true);
		Image img1 = new Image();
		img1.setSize("100px", "100px");
		Image img2 = new Image();
		img2.setSize("100px", "100px");
		Image img3 = new Image();
		img3.setSize("100px", "100px");
		hp.add(img1);
		img1.setUrl("data:image/jpeg;base64," + iDTO.getImg1());
		hp.add(img2);
		img2.setUrl("data:image/jpeg;base64," + iDTO.getImg2());
		hp.add(img3);
		img3.setUrl("data:image/jpeg;base64," + iDTO.getImg3());
		this.add(hp);
		
		Button close = new Button("Listo");
		this.addButton(close);
	}
}
