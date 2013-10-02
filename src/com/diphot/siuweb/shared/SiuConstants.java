package com.diphot.siuweb.shared;


public interface SiuConstants {
	
	// Riesgos
	public static final int ALTO = 3;
	public static final int MEDIO = 2;
	public static final int BAJO = 1;
	
	public interface ROLES {
		// Roles
		public static final String ADMIN = "ADMIN";
		public static final String SUPERVISOR = "SUPERVISOR";
		public static final String SECRETARIA = "SECRETARIA";
		public static final String INSPECTOR = "INSPECTOR";
	}
	
	public interface ACTION {
		// Acciones
		public static final int OBSERVADO = 1;
		public static final int CONFIRMADO = 2;
		public static final int EJECUTADO = 3;
		public static final int RESUELTO = 4;
	}
}
