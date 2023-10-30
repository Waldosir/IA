package principal;

import Interfaz.VentanaIngreso;
import procesadoJFL.DificultadFuzzy;


public class mainPrincipal {

	public static void main(String[] args) {
		//pruebas()
		
		ventana(args);
	}
	

	static void ventana(String[] args) {
		VentanaIngreso v = new VentanaIngreso();
		v.main(args);
	}
	
	
	static void pruebas() {
		DificultadFuzzy d = new DificultadFuzzy();
		d.checarGraficas();
	}

}
