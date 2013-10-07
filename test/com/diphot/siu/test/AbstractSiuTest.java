package com.diphot.siu.test;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;

import com.diphot.siuweb.server.business.facade.impl.TipificacionFacade;
import com.diphot.siuweb.server.business.facade.impl.UserFacade;
import com.diphot.siuweb.server.business.model.Area;
import com.diphot.siuweb.server.business.model.Tema;
import com.diphot.siuweb.server.business.model.TipoRelevamiento;
import com.diphot.siuweb.server.pesistense.daos.AreaDAO;
import com.diphot.siuweb.server.pesistense.daos.LocalidadDAO;
import com.diphot.siuweb.server.pesistense.daos.TipoRelevamientoDAO;
import com.diphot.siuweb.server.pesistense.daos.UserDAO;
import com.diphot.siuweb.shared.SiuConstants;
import com.diphot.siuweb.shared.dtos.LocalidadDTO;
import com.diphot.siuweb.shared.dtos.RoleDTO;
import com.diphot.siuweb.shared.dtos.TipoRelevamientoDTO;
import com.diphot.siuweb.shared.dtos.UserDTO;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public class AbstractSiuTest {

	private final LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

	@Before
	public void setUp() {
		helper.setUp();
		dbCreate();
		dbUserCreate();
	}

	@After
	public void tearDown() {
		helper.tearDown();
	}

	protected void dbUserCreate(){
		UserFacade.getInstance().createUser(new UserDTO(1L, "juanma", "asdf69", "jmvicente@diphot.com"));
		UserFacade.getInstance().createUser(new UserDTO(2L,"vsaldana", "v1ct0r", "jmvicente@diphot.com"));
		UserFacade.getInstance().createUser(new UserDTO(3L,"crubiera", "c4rl0s", "jmvicente@diphot.com"));
		UserFacade.getInstance().createUser(new UserDTO(4L,"tsecretaria", "s3cre3t4r14", "jmvicente@diphot.com"));
		UserFacade.getInstance().createRole(new RoleDTO(1L, SiuConstants.ROLES.ADMIN));
		UserFacade.getInstance().createRole(new RoleDTO(2L, SiuConstants.ROLES.SUPERVISOR));
		UserFacade.getInstance().createRole(new RoleDTO(3L, SiuConstants.ROLES.INSPECTOR));
		UserFacade.getInstance().createRole(new RoleDTO(4L, SiuConstants.ROLES.SECRETARIA));
		UserFacade.getInstance().assingRole(1L, 1L);
		UserFacade.getInstance().assingRole(2L, 2L);
		UserFacade.getInstance().assingRole(3L, 3L);
		UserFacade.getInstance().assingRole(4L, 4L);
	}

	protected void dbCreate(){
		//Creadon AREAS


		AreaDAO areaDAO = new AreaDAO();
		TipoRelevamientoDAO tipoRelevamientoDAO = new TipoRelevamientoDAO();

		areaDAO.begin(); tipoRelevamientoDAO.begin();

		/*
		 * Creacion de Areas
		 * 
		 * */

		areaDAO.create(new Area(1L,"SERVICIOS PÚBLICOS")); //  Y CONSERVACIÓN DE INFRAESTRUCTURA
		areaDAO.create(new Area(2L,"PROTECCION CIUDADANA"));
		areaDAO.create(new Area(3L,"Ed. Educativos y Centros de Salud"));

		/*
		 * Creacion de Tipos
		 * 
		 * */

		ArrayList<TipoRelevamientoDTO> tipos = new ArrayList<TipoRelevamientoDTO>();
		// Servicios Publicos
		Area area =  areaDAO.getById(1L);
		new TipoRelevamiento(1L, "Alumbrado Publico",area);
		new TipoRelevamiento(2L, "Arbolado y Forestación",area);
		new TipoRelevamiento(3L, "Plazas y Paseos",area);
		new TipoRelevamiento(4L, "Calles",area);
		new TipoRelevamiento(5L, "Veredas y Aceras",area);
		new TipoRelevamiento(6L, "Limpieza e Higiene",area);
		new TipoRelevamiento(7L, "Redes Privadas",area);

		//Protección Ciudadana
		area =  areaDAO.getById(2L);
		new TipoRelevamiento(8L, "Cartelería y Señalización",area);
		new TipoRelevamiento(9L, "Refugios de colectivos",area);
		new TipoRelevamiento(10L, "Calles",area);
		new TipoRelevamiento(11L, "Veredas y Aceras",area);
		new TipoRelevamiento(12L, "Cartelería y Señalización",area);
		new TipoRelevamiento(13L, "Semáforos",area);
		new TipoRelevamiento(14L, "Tránsito",area);

		// Desarrollo Humano
		area =  areaDAO.getById(3L);
		new TipoRelevamiento(15L, "Ed. Educativos y Centros de Salud",area);

		/*
		 * Creacion de Temas
		 * 
		 * */
		TipoRelevamiento tipoRelevamiento = tipoRelevamientoDAO.getById(1L);

		// Alumbrado Publico
		new Tema(1L,"Residuos domiciliarios",tipoRelevamiento);
		new Tema(2L,"Encendido diurno",tipoRelevamiento);
		new Tema(3L,"Artefacto roto o faltante",tipoRelevamiento);
		new Tema(4L,"Tulipa abierta, rota o faltante",tipoRelevamiento);
		new Tema(5L,"Columna inclinada o con riesgo de caerse",tipoRelevamiento);
		new Tema(6L,"Columna girada",tipoRelevamiento);
		new Tema(7L,"Falta de pintura",tipoRelevamiento);
		new Tema(8L,"Bandeja abierta o faltante",tipoRelevamiento);
		new Tema(9L,"OTRO",tipoRelevamiento);

		//Arbolado y Forestación
		tipoRelevamiento = tipoRelevamientoDAO.getById(2L);

		new Tema(10L,"Poda",tipoRelevamiento);
		new Tema(11L,"Radeo - darle forma al árbol",tipoRelevamiento);
		new Tema(12L,"Bajar copa de árbol",tipoRelevamiento);
		new Tema(13L,"Árbol caído",tipoRelevamiento);
		new Tema(14L,"Árbol y/o ramas en riesgo de caerse",tipoRelevamiento);
		new Tema(15L,"Despeje de cableado",tipoRelevamiento);
		new Tema(16L,"Despeje de alumbrado público",tipoRelevamiento);
		new Tema(17L,"OTRO",tipoRelevamiento);

		// Plazas y Paseos
		tipoRelevamiento = tipoRelevamientoDAO.getById(3L);

		new Tema(18L,"Arenero: falta de arena",tipoRelevamiento);
		new Tema(19L,"Arenero: higiene y seguridad",tipoRelevamiento);
		new Tema(20L,"Bancos y/o mesas: falta de pintura e higiene",tipoRelevamiento);
		new Tema(21L,"Bancos y/o mesas: rotas",tipoRelevamiento);
		new Tema(22L,"Bandera: mástil inclinado, con riesgo de caerse o falta de pintura",tipoRelevamiento);
		new Tema(23L,"Bandera: faltante o rota",tipoRelevamiento);
		new Tema(24L,"Requiere corte de césped",tipoRelevamiento);
		new Tema(25L,"Farolas: encendido diurno",tipoRelevamiento);
		new Tema(26L,"Farolas: inclinada o con riesgo de caerse",tipoRelevamiento);
		new Tema(27L,"Fuente de agua: falta de pintura o rota",tipoRelevamiento);
		new Tema(28L,"Fuente de agua: no funciona",tipoRelevamiento);
		new Tema(29L,"Glorietas: falta de pintura",tipoRelevamiento);
		new Tema(30L,"Glorietas: rotas",tipoRelevamiento);
		new Tema(31L,"Graffitis",tipoRelevamiento);
		new Tema(32L,"Juegos: rotos",tipoRelevamiento);
		new Tema(33L,"Juegos: falta de pintura e higiene",tipoRelevamiento);
		new Tema(34L,"Limpieza, higiene y seguridad en general",tipoRelevamiento);
		new Tema(35L,"Monumentos y/o placas: faltantes o rotos",tipoRelevamiento);
		new Tema(36L,"Plantas y plantines rotas o faltantes",tipoRelevamiento);
		new Tema(37L,"Tejido o cerco perimetral: reposición o reparación",tipoRelevamiento);
		new Tema(38L,"Veredas rotas o inexistentes",tipoRelevamiento);
		new Tema(39L,"OTRO",tipoRelevamiento);

		// Calles
		tipoRelevamiento = tipoRelevamientoDAO.getById(4L);
		new Tema(40L,"Calle de tierra (escoria) en mal estado",tipoRelevamiento);
		new Tema(41L,"Baches",tipoRelevamiento);
		new Tema(42L,"Hormigón roto",tipoRelevamiento);
		new Tema(43L,"Junta en calle de hormigón faltante",tipoRelevamiento);
		new Tema(44L,"OTRO",tipoRelevamiento);


		// Veredas y Aceras
		tipoRelevamiento = tipoRelevamientoDAO.getById(5L);

		new Tema(45L,"Boca de tormenta roto",tipoRelevamiento);
		new Tema(46L,"Cámaras o sumideros rotos",tipoRelevamiento);
		new Tema(47L,"Cordón roto",tipoRelevamiento);
		new Tema(48L,"Desagüe/alcantarilla: roto",tipoRelevamiento);
		new Tema(49L,"Desagüe/alcantarilla: faltante de tapa",tipoRelevamiento);
		new Tema(50L,"Falta de tapa de cámara de agua / gas / luz / teléfono",tipoRelevamiento);
		new Tema(51L,"Rampa para discapacitados rota",tipoRelevamiento);
		new Tema(52L,"Veredas rotas o inexistentes",tipoRelevamiento);
		new Tema(53L,"Vereda rota por empresas de servicios",tipoRelevamiento);
		new Tema(54L,"OTRO",tipoRelevamiento);

		//Limpieza e Higiene
		tipoRelevamiento = tipoRelevamientoDAO.getById(6L);

		new Tema(55L,"Pasto/arbusto/césped alto",tipoRelevamiento);
		new Tema(56L,"Arroyos y canales con residuos",tipoRelevamiento);
		new Tema(57L,"Boca de tormenta tapada",tipoRelevamiento);
		new Tema(58L,"Cámaras y caños tapados",tipoRelevamiento);
		new Tema(59L,"Zanja tapada con residuos",tipoRelevamiento);
		new Tema(60L,"Terrenos baldíos con residuos o pasto/arbusto/césped alto",tipoRelevamiento);
		new Tema(61L,"Residuos dispersos",tipoRelevamiento);
		new Tema(62L,"Montículos de escombros",tipoRelevamiento);
		new Tema(63L,"Montículos de chatarra",tipoRelevamiento);
		new Tema(64L,"Montículos de ramas y troncos",tipoRelevamiento);
		new Tema(65L,"Montículos de residuos domiciliarios",tipoRelevamiento);
		new Tema(66L,"Montículos de tierra",tipoRelevamiento);
		new Tema(67L,"OTRO",tipoRelevamiento);

		// Redes Privadas
		tipoRelevamiento = tipoRelevamientoDAO.getById(7L);

		new Tema(68L,"Cables sueltos (Electricidadr/Teléfono/Videocable)",tipoRelevamiento);
		new Tema(69L,"Pérdida de agua",tipoRelevamiento);
		new Tema(70L,"Pérdida de Gas",tipoRelevamiento);
		new Tema(71L,"Poste roto (Electricidad/Teléfono/Videocable)",tipoRelevamiento);
		new Tema(72L,"Poste con riesgo de caerse (Electricidad/Teléfono/Videocable)",tipoRelevamiento);
		new Tema(73L,"OTRO",tipoRelevamiento);

		//Cartelería y Señalización	
		tipoRelevamiento = tipoRelevamientoDAO.getById(8L);

		new Tema(74L,"Graffitis",tipoRelevamiento);

		// Refugios de colectivos
		tipoRelevamiento = tipoRelevamientoDAO.getById(9L);

		new Tema(75L,"Falta de pintura",tipoRelevamiento);
		new Tema(76L,"Roto",tipoRelevamiento);
		new Tema(77L,"Con riesgo de caerse",tipoRelevamiento);
		new Tema(78L,"Graffitis",tipoRelevamiento);
		new Tema(79L,"OTRO",tipoRelevamiento);


		/*
		 * Proteccion Ciudadana
		 * 
		 * */ 
		// Calles
		tipoRelevamiento = tipoRelevamientoDAO.getById(10L);

		new Tema(80L,"Pintura de reductores de velocidad",tipoRelevamiento);
		new Tema(81L,"Pintura de senda peatonal",tipoRelevamiento);

		//Veredas y Aceras
		tipoRelevamiento = tipoRelevamientoDAO.getById(11L);
		new Tema(82L,"Cordón: falta de pintura amarilla vial en esquinas",tipoRelevamiento);

		//Cartelería y Señalización
		tipoRelevamiento = tipoRelevamientoDAO.getById(12L);
		new Tema(83L,"Cartel indicador de calle (nomenclador) faltante o roto",tipoRelevamiento);
		new Tema(84L,"Falta nombre y/o altura de calle en el cartel indicador",tipoRelevamiento);
		new Tema(85L,"Cartel de señalización vial faltante o roto",tipoRelevamiento);
		new Tema(86L,"OTRO",tipoRelevamiento);

		//Semáforos
		tipoRelevamiento = tipoRelevamientoDAO.getById(13L);
		new Tema(87L,"Apagado",tipoRelevamiento);
		new Tema(88L,"Intermitente",tipoRelevamiento);
		new Tema(89L,"Encendido permanentemente",tipoRelevamiento);
		new Tema(90L,"Columna inclinada",tipoRelevamiento);
		new Tema(91L,"Columna con riesgo de caerse",tipoRelevamiento);
		new Tema(92L,"Artefacto roto",tipoRelevamiento);
		new Tema(93L,"OTRO",tipoRelevamiento);

		//Tránsito
		tipoRelevamiento = tipoRelevamientoDAO.getById(14L);
		new Tema(94L,"Volquete abandonado",tipoRelevamiento);
		new Tema(95L,"Vehículo abandonado y/o quemado",tipoRelevamiento);
		new Tema(96L,"OTRO",tipoRelevamiento);

		/*
		 * Desarrollo Humano
		 * */
		tipoRelevamiento = tipoRelevamientoDAO.getById(15L);

		new Tema(97L,"Fachada con graffitis",tipoRelevamiento);
		new Tema(98L,"Falta de pintura en la fachada",tipoRelevamiento);
		new Tema(99L,"Ventanas rotas",tipoRelevamiento);
		new Tema(100L,"Puerta de acceso al edificio rota",tipoRelevamiento);
		new Tema(101L,"OTRO",tipoRelevamiento);

		areaDAO.end(); tipoRelevamientoDAO.end();

		// TODO Modificar emails!
		UserFacade.getInstance().createUser(new UserDTO(1L, "juanma", "asdf69", "jmvicente@diphot.com"));
		UserFacade.getInstance().createUser(new UserDTO(2L,"vsaldana", "v1ct0r", "jmvicente@diphot.com"));
		UserFacade.getInstance().createUser(new UserDTO(3L,"crubiera", "c4rl0s", "jmvicente@diphot.com"));
		UserFacade.getInstance().createUser(new UserDTO(4L,"tsecretaria", "s3cr3tar1a", "jmvicente@diphot.com"));
		UserFacade.getInstance().createUser(new UserDTO(5L,"aamoruso", "4l3j4ndr0", "jmvicente@diphot.com"));
		UserFacade.getInstance().createUser(new UserDTO(6L,"etaboada", "3du4rd0", "jmvicente@diphot.com"));

		UserFacade.getInstance().createRole(new RoleDTO(1L, SiuConstants.ROLES.ADMIN));
		UserFacade.getInstance().createRole(new RoleDTO(2L, SiuConstants.ROLES.SUPERVISOR));
		UserFacade.getInstance().createRole(new RoleDTO(3L, SiuConstants.ROLES.INSPECTOR));
		UserFacade.getInstance().createRole(new RoleDTO(4L, SiuConstants.ROLES.SECRETARIA));

		UserFacade.getInstance().assingRole(1L, 1L);
		UserFacade.getInstance().assingRole(2L, 2L);
		UserFacade.getInstance().assingRole(3L, 3L);
		UserFacade.getInstance().assingRole(4L, 4L);
		UserFacade.getInstance().assingRole(5L, 4L);
		UserFacade.getInstance().assingRole(6L, 4L);

		TipificacionFacade.getInstance().addAreaOwner(5L, 1L);
		TipificacionFacade.getInstance().addAreaOwner(6L, 1L);

		// Creacion de Localidades.
		LocalidadDAO ldao = new LocalidadDAO();
		ldao.begin();
		ldao.creatFromDTO(new LocalidadDTO(1L, "Benavídez"));
		ldao.creatFromDTO(new LocalidadDTO(2L, "Delta de Tigre"));
		ldao.creatFromDTO(new LocalidadDTO(3L, "Dique Luján"));
		ldao.creatFromDTO(new LocalidadDTO(4L, "Don Torcuato"));
		ldao.creatFromDTO(new LocalidadDTO(5L, "El Talar"));
		ldao.creatFromDTO(new LocalidadDTO(6L, "General Pacheco"));
		ldao.creatFromDTO(new LocalidadDTO(7L, "Nordelta"));
		ldao.creatFromDTO(new LocalidadDTO(8L, "Ricardo Rojas"));
		ldao.creatFromDTO(new LocalidadDTO(9L, "Rincón de Milberg"));
		ldao.creatFromDTO(new LocalidadDTO(10L, "Tigre"));
		ldao.creatFromDTO(new LocalidadDTO(11L, "Troncos del Talar"));
		ldao.end();

	}
}
