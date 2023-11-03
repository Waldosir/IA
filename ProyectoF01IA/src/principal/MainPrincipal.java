package principal;

import Interfaz.VentanaIngreso;

public class MainPrincipal {

	public static void main(String[] args) {
		
		ventana();
		/*
		pruebas();
		//*/
		String url = System.getProperty("user.dir");
		System.out.println(url);
	}

	
	private static void ventana() {
		VentanaIngreso v = new VentanaIngreso();
		v.setVisible(true);
	}
	
	/*
	private static void pruebas() {
		DificultadFuzzy d = new DificultadFuzzy();
		d.checarGraficas();
	}
	//*/
}
