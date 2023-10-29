package DatosUsuario;

import java.util.ArrayList;

import procesadoJFL.Dificultad;
import procesadoJFL.DificultadFuzzy;

public class Usuario extends DificultadFuzzy {
	private int id;
	private String nombre;
	private String contrasena;
	private int numeroLineas;
	private ArrayList<String[]> datosCursos = new ArrayList<String[]>();
	private int opcion;
	private int[] datosFL;
	
	public Usuario(int id, String nombre, String contrasena, int numeroLineas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.numeroLineas = numeroLineas;
		opcion = -1;
	}

	public Usuario(String nombre, String contrasena, int numeroLineas) {
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.numeroLineas = numeroLineas;
	}
	
	public Usuario(String nombre, String contrasena) {
		this.id = 0;
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.numeroLineas = 0;
		opcion = 0;
	}
	
	public double getDificultadCurso(String nombreCurso) {
		for(String[] datosT:datosCursos) {
			if(datosT[0].equals(nombreCurso)) {
				return Double.parseDouble(datosT[1]);
			}
		}
		return 0.0;
	}

	public int getOpcion() {
		return opcion;
	}

	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public int getNumeroLineas() {
		return numeroLineas;
	}

	public void setNumeroLineas(int numeroLineas) {
		this.numeroLineas = numeroLineas;
	}
	
	public void anadirDatos(String[] datos) {
		datosCursos.add(datos);
	}
	
	public ArrayList<String[]> getDatos(){
		return this.datosCursos;
	}
	
	public void setDificultadMateria(int dificultad, String curso) {
		for(String[] cursos:datosCursos) {
			if(cursos[0].equals(curso)) {
				cursos[1] = dificultad+"";
			}
		}
	}
	
	public String getDificultadMateria(String curso) {
		for(String[] cursos:datosCursos) {
			if(cursos[0].equals(curso)) {
				return cursos[1]; 
			}
		}
		return "0";
	}
	
	
}
