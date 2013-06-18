package com.diphot.siuweb.server;

import java.util.ArrayList;

import com.diphot.siuweb.client.services.TemaService;
import com.diphot.siuweb.server.business.model.Tema;
import com.diphot.siuweb.server.business.model.TipoRelevamiento;
import com.diphot.siuweb.server.pesistense.daos.TemaDAO;
import com.diphot.siuweb.server.pesistense.daos.TipoRelevamientoDAO;
import com.diphot.siuweb.shared.dtos.TemaDTO;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class TemaServiceImpl extends RemoteServiceServlet implements TemaService{

	@Override
	public ArrayList<TemaDTO> getList() {
		return new TemaDAO().getDTOList();
	}

	@Override
	public void create(TemaDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void populateINIT() {
		TipoRelevamientoDAO tipoDAO = new TipoRelevamientoDAO();
		tipoDAO.begin();
		
		TipoRelevamiento tipoRelevamiento = tipoDAO.findById(1L);
		/*********************
		 * SERVICIOS P�BLICOS*
		 ********************/
		// Via Publica General
		new Tema(1L,"Residuos domiciliarios",tipoRelevamiento);
		new Tema(2L,"Mont�culos de Tierra y/o escombros",tipoRelevamiento);
		new Tema(3L,"Mont�culos de Ramas y/o Basura",tipoRelevamiento);
		new Tema(4L,"Residuos Acumulados en Esquina y/o bald�os",tipoRelevamiento);
		new Tema(5L,"Cestos de Residuos / cumplimiento horario sacar residuos",tipoRelevamiento);
		new Tema(6L,"Transitabilidad de calles de tierra",tipoRelevamiento);
		new Tema(7L,"Baches en Asfalto Vecinal",tipoRelevamiento);
		new Tema(8L,"Baches o Losas en Asfaltos de Hormig�n",tipoRelevamiento);
		new Tema(9L,"Cordones rotos",tipoRelevamiento);
		new Tema(10L,"Tomado de Juntas",tipoRelevamiento);
		new Tema(11L,"Estado de rampas para discapacitados",tipoRelevamiento);
		new Tema(12L,"Estado de Sendas peatonales",tipoRelevamiento);
		new Tema(13L,"Pintura amarilla vial en esquinas c�ntricas",tipoRelevamiento);
		new Tema(14L,"Pintura de L�neas de divisi�n y pare en avenidas",tipoRelevamiento);
		new Tema(15L,"Veredas rotas o inexistentes",tipoRelevamiento);
		new Tema(16L,"Limpiezas de zanjas y/o Aguas estancadas",tipoRelevamiento);
		new Tema(17L,"Limpieza de sumideros y/o desag�es pluviales",tipoRelevamiento);
		new Tema(18L,"Limpieza de Arroyos",tipoRelevamiento);
		new Tema(19L,"Falta de tapas de c�mara y/o sumideros",tipoRelevamiento);
		new Tema(20L,"Refugios de parada de colectivos rotos o faltantes",tipoRelevamiento);
		new Tema(21L,"OTROS",tipoRelevamiento);

		// Arbolado
		tipoRelevamiento = tipoDAO.findById(2L);
		new Tema(22L,"Mantenimiento de Parquizaci�n y arboleda",tipoRelevamiento);
		new Tema(23L,"Estado de seguridad y pintura de juegos",tipoRelevamiento);
		new Tema(24L,"Estado de higiene de residuos peligrosos en areneros",tipoRelevamiento);
		new Tema(25L,"Estado de higiene en general",tipoRelevamiento);
		new Tema(26L,"Estado de Limpieza y pintura de bancos y monumentos",tipoRelevamiento);
		new Tema(27L,"Funcionamiento de Fuentes",tipoRelevamiento);
		new Tema(28L,"�rbol Ca�do / o en riesgo",tipoRelevamiento);
		new Tema(29L,"Ra�ces levantan vereda",tipoRelevamiento);
		new Tema(30L,"Poda de �rboles/Ligustros",tipoRelevamiento);
		new Tema(31L,"OTROS",tipoRelevamiento);

		// Alumbrado
		tipoRelevamiento = tipoDAO.findById(3L);
		new Tema(32L,"Fallas en L�mparas",tipoRelevamiento);
		new Tema(33L,"Columnas de Alumbrado Oxidadas en la base",tipoRelevamiento);
		new Tema(34L,"Ausencia de Jabalina",tipoRelevamiento);
		new Tema(35L,"Columnas de alumbrado Despintadas",tipoRelevamiento);
		new Tema(36L,"Tulipas Rotas",tipoRelevamiento);
		new Tema(37L,"Tulipas Sucias",tipoRelevamiento);
		new Tema(38L,"Columnas de Alumbrado dobladas/Torcidas",tipoRelevamiento);
		new Tema(39L,"Columnas de Alumbrado con Riesgos El�ctricos a terceros",tipoRelevamiento);
		new Tema(40L,"OTROS",tipoRelevamiento);
		
		//Servicio El�ctrico
		tipoRelevamiento = tipoDAO.findById(4L);
		new Tema(41L,"Presunto robo de energ�a el�ctrica con cableados precarios",tipoRelevamiento);
		new Tema(42L,"Funcionamiento Bombas Depresoras de napas",tipoRelevamiento);
		new Tema(43L,"Conexiones no reglamentarias",tipoRelevamiento);
		new Tema(44L,"Tendidos el�ctricos deteriorados",tipoRelevamiento);
		new Tema(45L,"OTROS",tipoRelevamiento);
		
		// Sem�foros
		tipoRelevamiento = tipoDAO.findById(5L);
		new Tema(46L,"No funciona",tipoRelevamiento);
		new Tema(47L,"Luz apagada",tipoRelevamiento);
		new Tema(48L,"Todo encendido",tipoRelevamiento);
		new Tema(49L,"Aparato da�ado",tipoRelevamiento);
		new Tema(50L,"OTROS",tipoRelevamiento);
		
		// Urgencias 
		tipoRelevamiento = tipoDAO.findById(6L);
		new Tema(51L,"Columna de Alumbrado ca�da",tipoRelevamiento);
		new Tema(52L,"Columna de alumbrado electrificada",tipoRelevamiento);
		new Tema(53L,"Cables de ALUMBRADO cortado ( no EDENOR)",tipoRelevamiento);
		new Tema(54L,"�rbol ca�do o por caer",tipoRelevamiento);
		new Tema(55L,"Aparato da�ado",tipoRelevamiento);
		new Tema(56L,"Sem�foro no funciona en cruce peligroso",tipoRelevamiento);
		new Tema(57L,"Poste de Edenor / Tel�fono chocado",tipoRelevamiento);
		
		/*********************
		 * CONTROL URBANO Y AMBIENTAL*
		 ********************/
		//V�a P�blica en General
		tipoRelevamiento = tipoDAO.findById(7L);
		new Tema(58L,"Ocupaci�n Indebida del espacio p�blico",tipoRelevamiento);
		new Tema(59L,"Inspecci�n General",tipoRelevamiento);
		new Tema(60L,"Malos olores o gases t�xicos en la v�a p�blica",tipoRelevamiento);
		new Tema(61L,"OTROS",tipoRelevamiento);
		
		/*********************
		 * PROTECCION CIUDADANA*
		 ********************/
		//V�a P�blica en General
		tipoRelevamiento = tipoDAO.findById(8L);
		new Tema(62L,"Desarmaderos de autos / Lugares de actividades Ilegales",tipoRelevamiento);
		new Tema(63L,"Estado de Carteles de Se�alizaci�n Vial",tipoRelevamiento);
		new Tema(64L,"Autos abandonados / Quemados",tipoRelevamiento);
		new Tema(65L,"D�rsena de parada de colectivos",tipoRelevamiento);
		new Tema(66L,"Carga y Descarga / Estacionamiento doble fila",tipoRelevamiento);
		new Tema(67L,"OTROS",tipoRelevamiento);
		
		// URGENCIA
		tipoRelevamiento = tipoDAO.findById(9L);
		new Tema(68L,"Escape de Gas",tipoRelevamiento);
		new Tema(69L,"Cables de Edenor cortados",tipoRelevamiento);
		new Tema(70L,"Accidente de tr�nsito",tipoRelevamiento);
		new Tema(71L,"Emergencia m�dica",tipoRelevamiento);
		
		/*********************
		 * INERSI�N P�BLICA*
		 ********************/
		// Obras
		tipoRelevamiento = tipoDAO.findById(10L);
		new Tema(72L,"Se�alamiento y/o balizamiento de obras en v�a p�blica",tipoRelevamiento);
		new Tema(73L,"Calles nuevas de Asfalto Vecinal",tipoRelevamiento);
		new Tema(74L,"Calles nuevas de asfalto de hormig�n",tipoRelevamiento);
		new Tema(75L,"Limpieza de costas y /o residuos flotando en arroyos",tipoRelevamiento);
		new Tema(76L,"Entubamientos",tipoRelevamiento);
		new Tema(77L,"Desag�es",tipoRelevamiento);
		new Tema(78L,"Obras de Edenor",tipoRelevamiento);
		new Tema(79L,"Obras de Gas Natural",tipoRelevamiento);
		new Tema(80L,"Obras de video cable",tipoRelevamiento);
		new Tema(91L,"Obras de telefon�a",tipoRelevamiento);
		new Tema(92L,"Antenas de telefon�a",tipoRelevamiento);
		new Tema(93L,"Obras de Agua Corriente y/o cloacas",tipoRelevamiento);
		new Tema(94L,"OTROS",tipoRelevamiento);
		
		//temaDAO.massiveCreate(temas);
		tipoDAO.end();
	}

}
