package com.diphot.siuweb.client.util;

import com.extjs.gxt.ui.client.data.BaseListLoader;
import com.extjs.gxt.ui.client.data.DataProxy;
import com.extjs.gxt.ui.client.data.DataReader;
import com.extjs.gxt.ui.client.data.ListLoadResult;

// Esta clase permite acceder al proxy de loader y cambiarlo.

public class ConoBaseListLoader <D extends ListLoadResult<?>> extends BaseListLoader<D>{

		public ConoBaseListLoader(DataProxy<?> proxy, DataReader<?> reader) {
		super(proxy, reader);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setProxy (DataProxy proxy){
		this.proxy = proxy;
	}
}