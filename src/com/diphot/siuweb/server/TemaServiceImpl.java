package com.diphot.siuweb.server;

import java.util.ArrayList;

import com.diphot.siuweb.client.services.TemaService;
import com.diphot.siuweb.server.business.Tema;
import com.diphot.siuweb.server.business.TipoRelevamiento;
import com.diphot.siuweb.server.pesistense.daos.TemaDAO;
import com.diphot.siuweb.server.pesistense.daos.TipoRelevamientoDAO;
import com.diphot.siuweb.shared.dtos.TemaDTO;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class TemaServiceImpl extends RemoteServiceServlet implements TemaService{

	@Override
	public ArrayList<TemaDTO> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(TemaDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void populateINIT() {
		TipoRelevamientoDAO tipoDAO = new TipoRelevamientoDAO();
		TemaDAO temaDAO = new TemaDAO();
		ArrayList<Tema> temas = new ArrayList<Tema>();
		TipoRelevamiento tipoRelevamiento = tipoDAO.findById(1L);
		/*********************
		 * SERVICIOS PÚBLICOS*
		 ********************/
		// Via Publica General
		temas.add(new Tema(1L,"Residuos domiciliarios",tipoRelevamiento));
		temas.add(new Tema(2L,"Montículos de Tierra y/o escombros",tipoRelevamiento));
		temas.add(new Tema(3L,"Montículos de Ramas y/o Basura",tipoRelevamiento));
		temas.add(new Tema(4L,"Residuos Acumulados en Esquina y/o baldíos",tipoRelevamiento));
		temas.add(new Tema(5L,"Cestos de Residuos / cumplimiento horario sacar residuos",tipoRelevamiento));
		temas.add(new Tema(6L,"Transitabilidad de calles de tierra",tipoRelevamiento));
		temas.add(new Tema(7L,"Baches en Asfalto Vecinal",tipoRelevamiento));
		temas.add(new Tema(8L,"Baches o Losas en Asfaltos de Hormigón",tipoRelevamiento));
		temas.add(new Tema(9L,"Cordones rotos",tipoRelevamiento));
		temas.add(new Tema(10L,"Tomado de Juntas",tipoRelevamiento));
		temas.add(new Tema(11L,"Estado de rampas para discapacitados",tipoRelevamiento));
		temas.add(new Tema(12L,"Estado de Sendas peatonales",tipoRelevamiento));
		temas.add(new Tema(13L,"Pintura amarilla vial en esquinas céntricas",tipoRelevamiento));
		temas.add(new Tema(14L,"Pintura de Líneas de división y pare en avenidas",tipoRelevamiento));
		temas.add(new Tema(15L,"Veredas rotas o inexistentes",tipoRelevamiento));
		temas.add(new Tema(16L,"Limpiezas de zanjas y/o Aguas estancadas",tipoRelevamiento));
		temas.add(new Tema(17L,"Limpieza de sumideros y/o desagües pluviales",tipoRelevamiento));
		temas.add(new Tema(18L,"Limpieza de Arroyos",tipoRelevamiento));
		temas.add(new Tema(19L,"Falta de tapas de cámara y/o sumideros",tipoRelevamiento));
		temas.add(new Tema(20L,"Refugios de parada de colectivos rotos o faltantes",tipoRelevamiento));
		temas.add(new Tema(21L,"OTROS",tipoRelevamiento));

		// Arbolado
		tipoRelevamiento = tipoDAO.findById(2L);
		temas.add(new Tema(22L,"Mantenimiento de Parquización y arboleda",tipoRelevamiento));
		temas.add(new Tema(23L,"Estado de seguridad y pintura de juegos",tipoRelevamiento));
		temas.add(new Tema(24L,"Estado de higiene de residuos peligrosos en areneros",tipoRelevamiento));
		temas.add(new Tema(25L,"Estado de higiene en general",tipoRelevamiento));
		temas.add(new Tema(26L,"Estado de Limpieza y pintura de bancos y monumentos",tipoRelevamiento));
		temas.add(new Tema(27L,"Funcionamiento de Fuentes",tipoRelevamiento));
		temas.add(new Tema(28L,"Árbol Caído / o en riesgo",tipoRelevamiento));
		temas.add(new Tema(29L,"Raíces levantan vereda",tipoRelevamiento));
		temas.add(new Tema(30L,"Poda de Árboles/Ligustros",tipoRelevamiento));
		temas.add(new Tema(31L,"OTROS",tipoRelevamiento));

		// Alumbrado
		tipoRelevamiento = tipoDAO.findById(3L);
		temas.add(new Tema(32L,"Fallas en Lámparas",tipoRelevamiento));
		temas.add(new Tema(33L,"Columnas de Alumbrado Oxidadas en la base",tipoRelevamiento));
		temas.add(new Tema(34L,"Ausencia de Jabalina",tipoRelevamiento));
		temas.add(new Tema(35L,"Columnas de alumbrado Despintadas",tipoRelevamiento));
		temas.add(new Tema(36L,"Tulipas Rotas",tipoRelevamiento));
		temas.add(new Tema(37L,"Tulipas Sucias",tipoRelevamiento));
		temas.add(new Tema(38L,"Columnas de Alumbrado dobladas/Torcidas",tipoRelevamiento));
		temas.add(new Tema(39L,"Columnas de Alumbrado con Riesgos Eléctricos a terceros",tipoRelevamiento));
		temas.add(new Tema(40L,"OTROS",tipoRelevamiento));
		
		//Servicio Eléctrico
		tipoRelevamiento = tipoDAO.findById(4L);
		temas.add(new Tema(41L,"Presunto robo de energía eléctrica con cableados precarios",tipoRelevamiento));
		temas.add(new Tema(42L,"Funcionamiento Bombas Depresoras de napas",tipoRelevamiento));
		temas.add(new Tema(43L,"Conexiones no reglamentarias",tipoRelevamiento));
		temas.add(new Tema(44L,"Tendidos eléctricos deteriorados",tipoRelevamiento));
		temas.add(new Tema(45L,"OTROS",tipoRelevamiento));
		
		// Semáforos
		tipoRelevamiento = tipoDAO.findById(5L);
		temas.add(new Tema(46L,"No funciona",tipoRelevamiento));
		temas.add(new Tema(47L,"Luz apagada",tipoRelevamiento));
		temas.add(new Tema(48L,"Todo encendido",tipoRelevamiento));
		temas.add(new Tema(49L,"Aparato dañado",tipoRelevamiento));
		temas.add(new Tema(50L,"OTROS",tipoRelevamiento));
		
		// Urgencias 
		tipoRelevamiento = tipoDAO.findById(6L);
		temas.add(new Tema(51L,"Columna de Alumbrado caída",tipoRelevamiento));
		temas.add(new Tema(52L,"Columna de alumbrado electrificada",tipoRelevamiento));
		temas.add(new Tema(53L,"Cables de ALUMBRADO cortado ( no EDENOR)",tipoRelevamiento));
		temas.add(new Tema(54L,"Árbol caído o por caer",tipoRelevamiento));
		temas.add(new Tema(55L,"Aparato dañado",tipoRelevamiento));
		temas.add(new Tema(56L,"Semáforo no funciona en cruce peligroso",tipoRelevamiento));
		temas.add(new Tema(57L,"Poste de Edenor / Teléfono chocado",tipoRelevamiento));
		
		/*********************
		 * CONTROL URBANO Y AMBIENTAL*
		 ********************/
		//Vía Pública en General
		tipoRelevamiento = tipoDAO.findById(7L);
		temas.add(new Tema(58L,"Ocupación Indebida del espacio público",tipoRelevamiento));
		temas.add(new Tema(59L,"Inspección General",tipoRelevamiento));
		temas.add(new Tema(60L,"Malos olores o gases tóxicos en la vía pública",tipoRelevamiento));
		temas.add(new Tema(61L,"OTROS",tipoRelevamiento));
		
		/*********************
		 * PROTECCION CIUDADANA*
		 ********************/
		//Vía Pública en General
		tipoRelevamiento = tipoDAO.findById(8L);
		temas.add(new Tema(62L,"Desarmaderos de autos / Lugares de actividades Ilegales",tipoRelevamiento));
		temas.add(new Tema(63L,"Estado de Carteles de Señalización Vial",tipoRelevamiento));
		temas.add(new Tema(64L,"Autos abandonados / Quemados",tipoRelevamiento));
		temas.add(new Tema(65L,"Dársena de parada de colectivos",tipoRelevamiento));
		temas.add(new Tema(66L,"Carga y Descarga / Estacionamiento doble fila",tipoRelevamiento));
		temas.add(new Tema(67L,"OTROS",tipoRelevamiento));
		
		// URGENCIA
		tipoRelevamiento = tipoDAO.findById(9L);
		temas.add(new Tema(68L,"Escape de Gas",tipoRelevamiento));
		temas.add(new Tema(69L,"Cables de Edenor cortados",tipoRelevamiento));
		temas.add(new Tema(70L,"Accidente de tránsito",tipoRelevamiento));
		temas.add(new Tema(71L,"Emergencia médica",tipoRelevamiento));
		
		/*********************
		 * INERSIÓN PÚBLICA*
		 ********************/
		// Obras
		tipoRelevamiento = tipoDAO.findById(10L);
		temas.add(new Tema(71L,"Señalamiento y/o balizamiento de obras en vía pública",tipoRelevamiento));
		temas.add(new Tema(71L,"Calles nuevas de Asfalto Vecinal",tipoRelevamiento));
		temas.add(new Tema(71L,"Calles nuevas de asfalto de hormigón",tipoRelevamiento));
		temas.add(new Tema(71L,"Limpieza de costas y /o residuos flotando en arroyos",tipoRelevamiento));
		temas.add(new Tema(71L,"Entubamientos",tipoRelevamiento));
		temas.add(new Tema(71L,"Desagües",tipoRelevamiento));
		temas.add(new Tema(71L,"Obras de Edenor",tipoRelevamiento));
		temas.add(new Tema(71L,"Obras de Gas Natural",tipoRelevamiento));
		temas.add(new Tema(71L,"Obras de video cable",tipoRelevamiento));
		temas.add(new Tema(71L,"Obras de telefonía",tipoRelevamiento));
		temas.add(new Tema(71L,"Antenas de telefonía",tipoRelevamiento));
		temas.add(new Tema(71L,"Obras de Agua Corriente y/o cloacas",tipoRelevamiento));
		temas.add(new Tema(71L,"OTROS",tipoRelevamiento));
		
		temaDAO.massiveCreate(temas);
	}

}
