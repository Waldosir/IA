package principal;

import DatosUsuario.LecturaDatos;
import DatosUsuario.Usuario;
import procesadoJFL.Dificultad;


public class mainPrincipal {

	public static void main(String[] args) {
		int tiempo, help,mistakes;/*
		Usuario uNuevo = new Usuario("James","1234");
		ventanaPreguntas v = new ventanaPreguntas(uNuevo);
		v.main(args, uNuevo);
	*/
		
		Dificultad d = new Dificultad();
		d.proceso();
		
		
		LecturaDatos l = new LecturaDatos();
		Usuario u; 
		//u = l.buscarUsuario("Aldair");
		//u = l.buscarIDUsuario(1);
		//System.out.println(u.getNombre());
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
