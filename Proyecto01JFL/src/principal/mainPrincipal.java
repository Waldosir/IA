package principal;

import Interfaz.VentanaIngreso;
import procesadoJFL.DificultadFuzzy;


public class mainPrincipal {

	public static void main(String[] args) {
		//pruebas()
		
		ventana(args);
	}
	

	private static void ventana(String[] args) {
		VentanaIngreso v = new VentanaIngreso();
		v.setVisible(true);
	}
	
	
	private static void pruebas() {
		DificultadFuzzy d = new DificultadFuzzy();
		d.checarGraficas();
	}

}
