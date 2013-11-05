package com.diphot.siuweb.server.services.utils;

import com.diphot.siuweb.server.business.model.Inspeccion;

public class InspeccionHMTL {
	public static String getInspeccionHTML(Inspeccion inspeccion){
		String html = "<html>\r\n" + 
				"<head></head>\r\n" + 
				"<body style=\"width: 697; height: 1026px; background-color: #acacac; padding: 0px; margin: 0px;\">\r\n" + 
				"	<table style=\"width: 697px; margin-right: auto; margin-left: auto;\">\r\n" + 
				"		<tr style=\"background-color: #c42126; height: 87px;\">\r\n" + 
				"			<td>\r\n" + 
				"				<img style=\"float: right; margin-right: 18px; margin-top: 7px;\" width=\"130px\" height=\"74px\" alt=\"\" src=\"data:image/jpeg;base64,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\" />\r\n" +
				"				<strong style=\"float: left; margin-bottom: 20px; font-size: 35px;\">MONITOREO URBANO TIGRE</strong>\r\n" +
				"			</td><!-- fin img_logo -->  \r\n" + 
				"		</tr><!-- fin header -->\r\n" + 
				"		<tr style=\"padding: 0px; margin: 0px;\">\r\n" + 
				"			<td>\r\n" + 
				"				<table style=\"width: 697px; padding: 0px; margin: 0px; background-color: #FFF; float: left;\">\r\n" + 
				"					<tr>  \r\n" + 
				"						<td>\r\n" + 
				"							<p style=\"height: 37px; width: 660px; padding-top: 9px; margin-left: 18px; border-top-width: 1px; border-bottom-width: 1px; border-top-style: solid; border-bottom-style: solid; border-top-color: #bababc; border-bottom-color: #bababc; float: left;\">\r\n" + 
				"							<strong style=\"margin-left: 18px;\"> Informe de Inspecci&oacute;n: " + inspeccion.getId() + "</strong></p>\r\n" + 
				"						</td><!-- fin titulo -->\r\n" + 
				"					</tr>\r\n" + 
				"					<tr>\r\n" + 
				"						<td>\r\n" + 
				"							<table style=\"margin-left: 18px;\">\r\n" + 
				"								<tr>\r\n"+				
				"								<td style=\"float: left; width: 218px; margin-top: 15px; margin-left: 18px;\">\r\n" + 
				getEncondedImage(1,inspeccion)+ 
				"								</td>\r\n" + 
				"								<td style=\"float: left; width: 218px; margin-top: 15px; margin-left: 18px;\">\r\n" + 
				getEncondedImage(2,inspeccion)+ 
				"								</td>\r\n" + 
				"								<td style=\"float: left; width: 218px; margin-top: 15px; margin-left: 18px;\">\r\n" + 
				getEncondedImage(3,inspeccion)+ 
				"								</td>\r\n" +
				"								</tr>\r\n"+					
				"							</table>\r\n" + 
				"						</td>\r\n" + 
				"					</tr>\r\n" + 
				"					<tr>\r\n" + 
				" <!--height: 265px;-->						<td> \r\n" + 
				" <!-- height: 88px;-->							<table style=\"margin-top: 7px; margin-left: 18px; margin-bottom: 15px;\">\r\n" + 
				"								<tr>\r\n" + 
				"									<td style=\"width: 327px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px; 	border-right-style: solid; 	border-bottom-style: solid; 	border-left-style: solid; 	border-right-color: #CCC; 	border-bottom-color: #CCC; 	border-left-color: #CCC; 	-webkit-border-bottom-right-radius: 2px; 	-webkit-border-bottom-left-radius: 2px; 	-moz-border-radius-bottomright: 2px; 	-moz-border-radius-bottomleft: 2px; 	border-bottom-right-radius: 2px; 	border-bottom-left-radius: 2px;\">\r\n" +  
				"										<p style=\"margin-left: 6px; margin-right: 6px; font: 15px sans-serif;\"><strong>Fecha: </strong>"+ ConversionUtil.getSimpleDate(inspeccion.getFecha().toString()) +"</p>\r\n" + 
				"										<p style=\"margin-left: 6px; margin-right: 6px; font: 15px sans-serif;\"><strong>Riesgo: </strong>"+ ConversionUtil.getRiesgoString(inspeccion.getRiesgo()) +"</p>\r\n" +
				"										<p style=\"margin-left: 6px; margin-right: 6px; font: 15px sans-serif;\"><strong>Localidad: </strong>"+ inspeccion.getLocalidad().getNombre() +"</p>\r\n" +
				"										<p style=\"margin-left: 6px; margin-right: 6px; font: 15px sans-serif;\"><strong>Calle: </strong>"+ inspeccion.getCalle() +"</p>\r\n" +
				"										<p style=\"margin-left: 6px; margin-right: 6px; font: 15px sans-serif;\"><strong>Altura: </strong>"+ inspeccion.getAltura() +"</p>\r\n" +
				"										<p style=\"margin-left: 6px; margin-right: 6px; font: 15px sans-serif;\"><strong>Entre Calles: </strong>"+ inspeccion.getEntreCalleUno()+ " y " + inspeccion.getEntreCalleDos() +"</p>\r\n" +
				"										<p style=\"margin-left: 6px; margin-right: 6px; font: 15px sans-serif;\"><strong>Tema: </strong>"+ inspeccion.getTema().getNombre() +"</p>\r\n" + 
				"										<p style=\"margin-left: 6px; margin-right: 6px; font: 15px sans-serif;\"><strong>Observaci&oacute;n: </strong>" + inspeccion.getObservacion()	+"</p>\r\n" + 
				"									</td><!-- fin col_izq -->\r\n" + 
				"									<td style=\"float: right; \">\r\n" + 
				getEncondedImage(4,inspeccion)+ 
				"									</td><!-- fin col_der --> \r\n" + 
				"								</tr>\r\n" + 
				"							</table>\r\n" + 
				"						</td>\r\n" + 
				"					</tr><!-- fin contenido -->\r\n" + 
				"				</table>\r\n" + 
				"			</td>\r\n" + 
				"		</tr>\r\n" + 
				"		<tr style=\"height: 97px; width: 697px; background-color: #ebebeb; float: left;\">\r\n" + 
				"			<td></td>\r\n" + 
				"		</tr><!-- fin footer -->\r\n" + 
				"	</table><!-- fin content -->\r\n" + 
				"</body>\r\n" + 
				"</html>\r\n" + 
				"";
		return html;
	}

	public static String getEncondedImage(Integer number, Inspeccion inspeccion){
		switch (number) {
		case 1:
			if (inspeccion.getEncodedIMG1() != null) {  
				return "<img src=\""+ "data:image/jpeg;base64," + inspeccion.getEncodedIMG1().getEncodedImageString() +"\"></img>"; 
			} else { 
				return "";
			}
		case 2:
			if (inspeccion.getEncodedIMG2() != null) {  
				return "<img src=\""+ "data:image/jpeg;base64," + inspeccion.getEncodedIMG2().getEncodedImageString() +"\"></img>"; 
			} else { 
				return "";
			}
		case 3:
			if (inspeccion.getEncodedIMG3() != null) {  
				return "<img src=\""+ "data:image/jpeg;base64," + inspeccion.getEncodedIMG3().getEncodedImageString() +"\"></img>"; 
			} else { 
				return "";
			}
		case 4:
			if (inspeccion.getEncodedMap() != null) {  
				return "<img src=\""+ "data:image/jpeg;base64," + inspeccion.getEncodedMap().getEncodedImageString() +"\"></img>"; 
			} else { 
				return "";
			}
		default:
			return "";
		}
	}
}
