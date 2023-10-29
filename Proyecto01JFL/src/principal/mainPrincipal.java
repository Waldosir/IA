package principal;

import Interfaz.VentanaIngreso;
import procesadoJFL.DificultadFuzzy;


public class mainPrincipal {

	public static void main(String[] args) {
		
		//checarVentanaCurso();
		
		//checarTablasDificultad(); 
		 //ventana(args);
	}
	/*
	static void checarVentanaCurso() {
		ArrayList<String[]> p = new ArrayList<String[]>();
		VentanaCurso v = new VentanaCurso(null, p);
		v.main(null, "Graficas", p);
	}
	*/
	
	static void checarTablasDificultad() {
		//Tiempo medio: 30
		//Tiempo - ayuda - errores
		//colocarDificultad(0,0,0); //Dificultad UP -> 9
		//colocarDificultad(100,3,3); //Dificultad down -> 2
		//colocarDificultad(100,0,0);//Dificultad stay -> 6.67
		//colocarDificultad(0,0,3);//Dificultad down -> 4
		//colocarDificultad(30,0,3);//Dificultad down -> 4
		//colocarDificultad(30,3,0);//Dificultad stay - 6
		//colocarDificultad(0,3,0);//Dificultad stay -> 6
		
		//colocarDificultad(30,3,1);//Dificultad stay -> 6.666
		


		/*
		colocarDificultad(100,3,3); // Dificultad stay ->
		/*
		asdasd
		/*
		//*/
	}
	static void colocarDificultad(int tiempo, int ayuda, int errores) {
		
		
		DificultadFuzzy d = new DificultadFuzzy();
		
		//tiempo - ayuda - errores
		
		d.setValoresDificultad(tiempo, ayuda, errores);
		
		d.proceso();
	}
	
	static void ventana(String[] args) {
		VentanaIngreso v = new VentanaIngreso();
		v.main(args);
	}
	
	
	static void pruebas() {
int tiempo, help,mistakes;
		
		//Tiempo en minutos - Maximo 360
		tiempo = 360;
		//Ayudas - maximo 3
		help = 3;
		//Intentos - Maximo 4
		mistakes = 4;
		/*
		Dificultad d = new Dificultad();
		d.setValoresDificultad(tiempo, help, mistakes);
		System.out.println("La dificultad primera es "+d.dificultad());
		
		tiempo = 0;help = 0;mistakes = 0;
		d.setValoresDificultad(tiempo, help, mistakes);
		System.out.println("La dificultad despues es "+d.dificultad());
		
		tiempo = 0;help = 0;mistakes = 0;
		d.setValoresDificultad(tiempo, help, mistakes);
		System.out.println("La dificultad despues es "+d.dificultad());
		
		tiempo = 120;help = 2;mistakes = 0;
		d.setValoresDificultad(tiempo, help, mistakes);
		System.out.println("La dificultad despues es "+d.dificultad());
		
		tiempo = 120;help = 2;mistakes = 0;
		d.setValoresDificultad(tiempo, help, mistakes);
		System.out.println("La dificultad despues es "+d.dificultad());
        */
	}

}
