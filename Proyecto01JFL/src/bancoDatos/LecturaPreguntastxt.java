package bancoDatos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LecturaPreguntastxt {
	private String rutaFacil = "preguntasFacil.txt";
	private String rutaNormal = "PreguntasNormal.txt";
	private String rutaDificil = "PreguntasDificil.txt";
	private String carpeta = "DatosPreguntas/";
	
	public LecturaPreguntastxt(String nombre) {
		rutaFacil = carpeta+nombre+"/"+rutaFacil;
		rutaNormal = carpeta+nombre+"/"+rutaNormal;
		rutaDificil = carpeta+nombre+"/"+rutaDificil;
	}

	private ArrayList<String[]> recuperarPreguntas(String Ruta){
		ArrayList<String[]> preguntas = new ArrayList<String[]>();
		
		try(BufferedReader bf = new BufferedReader(new FileReader(Ruta))){//Lee los datos
			String s;
			while((s = bf.readLine())!=null) {//Hasta que no haya linea para leer
				String[] datos = s.split("[|]");//Reagrupa los datos con su respectivo separador
				preguntas.add(datos);				
				}
			}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		//Se regresa el ArrayList en Array
		return preguntas;
		}
	
	public ArrayList<String[]> preguntasFacil(){ //Regresa preguntas faciles
		return recuperarPreguntas(rutaFacil);
	}
	
	public ArrayList<String[]> preguntasNormal(){ //Regresa preguntas normales
		return recuperarPreguntas(rutaNormal);
	}
	
	public ArrayList<String[]> preguntasDificil(){//Regresa preguntas dificiles
		return recuperarPreguntas(rutaDificil);
	}
	
	
	
	
	}


