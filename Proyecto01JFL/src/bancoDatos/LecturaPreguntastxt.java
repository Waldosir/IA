package DatosUsuario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LecturaPreguntastxt {
	String rutaFacil = "DatosPreguntas/preguntasFacil.txt";
	String rutaNormal = "DatosPreguntas/PreguntasNormal.txt";;
	String rutaDificil = "DatosPreguntas/PreguntasDificil.txt";; 
	
	public LecturaPreguntastxt() {
		
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
	
	public ArrayList<String[]> preguntasFacil(){
		return recuperarPreguntas(rutaFacil);
	}
	
	public ArrayList<String[]> preguntasNormal(){
		return recuperarPreguntas(rutaNormal);
	}
	
	public ArrayList<String[]> preguntasDificil(){
		return recuperarPreguntas(rutaDificil);
	}
	
	
	
	
	}


