package com.diphot.siuweb.shared.dtos.filters;

import com.diphot.siuweb.shared.dtos.AreaDTO;
import com.diphot.siuweb.shared.dtos.TemaDTO;
import com.diphot.siuweb.shared.dtos.TipoRelevamientoDTO;
import com.google.gwt.user.client.rpc.IsSerializable;

public class InspeccionFilterDTO implements FilterInterfaceDTO, IsSerializable {
	public Long id;
	public String calle;
	public Integer altura;
	public AreaDTO areadto;
	public TipoRelevamientoDTO tipodto;
	public TemaDTO temadto;
}
