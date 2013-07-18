package com.diphot.siu.test;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;

import com.diphot.siuweb.server.business.model.Area;
import com.diphot.siuweb.server.business.model.Tema;
import com.diphot.siuweb.server.business.model.TipoRelevamiento;
import com.diphot.siuweb.server.pesistense.daos.AreaDAO;
import com.diphot.siuweb.server.pesistense.daos.TipoRelevamientoDAO;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public class AbstractSiuTest {

	private final LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

	@Before
	public void setUp() {
		helper.setUp();
		dbCreate();
	}

	@After
	public void tearDown() {
		helper.tearDown();
	}
	
	protected void dbCreate(){
		ArrayList<Area> areas = new ArrayList<Area>();
		areas.add(new Area(1L,"SERVICIOS PÚBLICOS Y CONSERVACIÓN DE INFRAESTRUCTURA"));
		areas.add(new Area(2L,"CONTROL URBANO Y AMBIENTAL"));
		areas.add(new Area(3L,"PROTECCION CIUDADANA"));
		areas.add(new Area(4L,"INSERCIÓN PÚBLICA Y PLANEAMIENTO URBANO"));
		AreaDAO areaDAO = new AreaDAO();
		areaDAO.begin();
		areaDAO.massiveCreate(areas);
					
		// Servicios Publicos
		Area area = areaDAO.getById(1L);
		new TipoRelevamiento(1L, "Vía Pública en General", area);
		new TipoRelevamiento(2L, "Arbolado", area);
		new TipoRelevamiento(3L, "Alumbrado", area);
		new TipoRelevamiento(4L, "Servicio Eléctrico", area);
		new TipoRelevamiento(5L, "Semáforos", area);
		new TipoRelevamiento(6L, "URGENCIA", area);
		
		// Control urbano
		area = areaDAO.getById(2L);
		new TipoRelevamiento(7L, "Vía Pública en General", area);
		
		// Proteccion
		area = areaDAO.getById(3L);
		new TipoRelevamiento(8L, "Vía Pública en General", area);
		new TipoRelevamiento(9L, "Urgencia", area);
		
		// Insercion
		area = areaDAO.getById(4L);
		new TipoRelevamiento(10L, "Obras", area);
		
		areaDAO.end();
		
		TipoRelevamientoDAO tipoDAO = new TipoRelevamientoDAO();
		tipoDAO.begin();
		
		TipoRelevamiento tipoRelevamiento = tipoDAO.getById(1L);
		/*********************
		 * SERVICIOS PÚBLICOS*
		 ********************/
		// Via Publica General
		new Tema(1L,"Residuos domiciliarios",tipoRelevamiento);
		new Tema(2L,"Montículos de Tierra y/o escombros",tipoRelevamiento);
		new Tema(3L,"Montículos de Ramas y/o Basura",tipoRelevamiento);
		new Tema(4L,"Residuos Acumulados en Esquina y/o baldíos",tipoRelevamiento);
		new Tema(5L,"Cestos de Residuos / cumplimiento horario sacar residuos",tipoRelevamiento);
		new Tema(6L,"Transitabilidad de calles de tierra",tipoRelevamiento);
		new Tema(7L,"Baches en Asfalto Vecinal",tipoRelevamiento);
		new Tema(8L,"Baches o Losas en Asfaltos de Hormigón",tipoRelevamiento);
		new Tema(9L,"Cordones rotos",tipoRelevamiento);
		new Tema(10L,"Tomado de Juntas",tipoRelevamiento);
		new Tema(11L,"Estado de rampas para discapacitados",tipoRelevamiento);
		new Tema(12L,"Estado de Sendas peatonales",tipoRelevamiento);
		new Tema(13L,"Pintura amarilla vial en esquinas céntricas",tipoRelevamiento);
		new Tema(14L,"Pintura de Líneas de división y pare en avenidas",tipoRelevamiento);
		new Tema(15L,"Veredas rotas o inexistentes",tipoRelevamiento);
		new Tema(16L,"Limpiezas de zanjas y/o Aguas estancadas",tipoRelevamiento);
		new Tema(17L,"Limpieza de sumideros y/o desagües pluviales",tipoRelevamiento);
		new Tema(18L,"Limpieza de Arroyos",tipoRelevamiento);
		new Tema(19L,"Falta de tapas de cámara y/o sumideros",tipoRelevamiento);
		new Tema(20L,"Refugios de parada de colectivos rotos o faltantes",tipoRelevamiento);
		new Tema(21L,"OTROS",tipoRelevamiento);

		// Arbolado
		tipoRelevamiento = tipoDAO.getById(2L);
		new Tema(22L,"Mantenimiento de Parquización y arboleda",tipoRelevamiento);
		new Tema(23L,"Estado de seguridad y pintura de juegos",tipoRelevamiento);
		new Tema(24L,"Estado de higiene de residuos peligrosos en areneros",tipoRelevamiento);
		new Tema(25L,"Estado de higiene en general",tipoRelevamiento);
		new Tema(26L,"Estado de Limpieza y pintura de bancos y monumentos",tipoRelevamiento);
		new Tema(27L,"Funcionamiento de Fuentes",tipoRelevamiento);
		new Tema(28L,"Árbol Caído / o en riesgo",tipoRelevamiento);
		new Tema(29L,"Raíces levantan vereda",tipoRelevamiento);
		new Tema(30L,"Poda de Árboles/Ligustros",tipoRelevamiento);
		new Tema(31L,"OTROS",tipoRelevamiento);

		// Alumbrado
		tipoRelevamiento = tipoDAO.getById(3L);
		new Tema(32L,"Fallas en Lámparas",tipoRelevamiento);
		new Tema(33L,"Columnas de Alumbrado Oxidadas en la base",tipoRelevamiento);
		new Tema(34L,"Ausencia de Jabalina",tipoRelevamiento);
		new Tema(35L,"Columnas de alumbrado Despintadas",tipoRelevamiento);
		new Tema(36L,"Tulipas Rotas",tipoRelevamiento);
		new Tema(37L,"Tulipas Sucias",tipoRelevamiento);
		new Tema(38L,"Columnas de Alumbrado dobladas/Torcidas",tipoRelevamiento);
		new Tema(39L,"Columnas de Alumbrado con Riesgos Eléctricos a terceros",tipoRelevamiento);
		new Tema(40L,"OTROS",tipoRelevamiento);
		
		//Servicio Eléctrico
		tipoRelevamiento = tipoDAO.getById(4L);
		new Tema(41L,"Presunto robo de energía eléctrica con cableados precarios",tipoRelevamiento);
		new Tema(42L,"Funcionamiento Bombas Depresoras de napas",tipoRelevamiento);
		new Tema(43L,"Conexiones no reglamentarias",tipoRelevamiento);
		new Tema(44L,"Tendidos eléctricos deteriorados",tipoRelevamiento);
		new Tema(45L,"OTROS",tipoRelevamiento);
		
		// Semáforos
		tipoRelevamiento = tipoDAO.getById(5L);
		new Tema(46L,"No funciona",tipoRelevamiento);
		new Tema(47L,"Luz apagada",tipoRelevamiento);
		new Tema(48L,"Todo encendido",tipoRelevamiento);
		new Tema(49L,"Aparato dañado",tipoRelevamiento);
		new Tema(50L,"OTROS",tipoRelevamiento);
		
		// Urgencias 
		tipoRelevamiento = tipoDAO.getById(6L);
		new Tema(51L,"Columna de Alumbrado caída",tipoRelevamiento);
		new Tema(52L,"Columna de alumbrado electrificada",tipoRelevamiento);
		new Tema(53L,"Cables de ALUMBRADO cortado ( no EDENOR)",tipoRelevamiento);
		new Tema(54L,"Árbol caído o por caer",tipoRelevamiento);
		new Tema(55L,"Aparato dañado",tipoRelevamiento);
		new Tema(56L,"Semáforo no funciona en cruce peligroso",tipoRelevamiento);
		new Tema(57L,"Poste de Edenor / Teléfono chocado",tipoRelevamiento);
		
		/*********************
		 * CONTROL URBANO Y AMBIENTAL*
		 ********************/
		//Vía Pública en General
		tipoRelevamiento = tipoDAO.getById(7L);
		new Tema(58L,"Ocupación Indebida del espacio público",tipoRelevamiento);
		new Tema(59L,"Inspección General",tipoRelevamiento);
		new Tema(60L,"Malos olores o gases tóxicos en la vía pública",tipoRelevamiento);
		new Tema(61L,"OTROS",tipoRelevamiento);
		
		/*********************
		 * PROTECCION CIUDADANA*
		 ********************/
		//Vía Pública en General
		tipoRelevamiento = tipoDAO.getById(8L);
		new Tema(62L,"Desarmaderos de autos / Lugares de actividades Ilegales",tipoRelevamiento);
		new Tema(63L,"Estado de Carteles de Señalización Vial",tipoRelevamiento);
		new Tema(64L,"Autos abandonados / Quemados",tipoRelevamiento);
		new Tema(65L,"Dársena de parada de colectivos",tipoRelevamiento);
		new Tema(66L,"Carga y Descarga / Estacionamiento doble fila",tipoRelevamiento);
		new Tema(67L,"OTROS",tipoRelevamiento);
		
		// URGENCIA
		tipoRelevamiento = tipoDAO.getById(9L);
		new Tema(68L,"Escape de Gas",tipoRelevamiento);
		new Tema(69L,"Cables de Edenor cortados",tipoRelevamiento);
		new Tema(70L,"Accidente de tránsito",tipoRelevamiento);
		new Tema(71L,"Emergencia médica",tipoRelevamiento);
		
		/*********************
		 * INERSIÓN PÚBLICA*
		 ********************/
		// Obras
		tipoRelevamiento = tipoDAO.getById(10L);
		new Tema(72L,"Señalamiento y/o balizamiento de obras en vía pública",tipoRelevamiento);
		new Tema(73L,"Calles nuevas de Asfalto Vecinal",tipoRelevamiento);
		new Tema(74L,"Calles nuevas de asfalto de hormigón",tipoRelevamiento);
		new Tema(75L,"Limpieza de costas y /o residuos flotando en arroyos",tipoRelevamiento);
		new Tema(76L,"Entubamientos",tipoRelevamiento);
		new Tema(77L,"Desagües",tipoRelevamiento);
		new Tema(78L,"Obras de Edenor",tipoRelevamiento);
		new Tema(79L,"Obras de Gas Natural",tipoRelevamiento);
		new Tema(80L,"Obras de video cable",tipoRelevamiento);
		new Tema(91L,"Obras de telefonía",tipoRelevamiento);
		new Tema(92L,"Antenas de telefonía",tipoRelevamiento);
		new Tema(93L,"Obras de Agua Corriente y/o cloacas",tipoRelevamiento);
		new Tema(94L,"OTROS",tipoRelevamiento);
		
		//temaDAO.massiveCreate(temas);
		tipoDAO.end();
		
	}
}
