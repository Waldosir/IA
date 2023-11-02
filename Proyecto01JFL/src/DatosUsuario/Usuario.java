package DatosUsuario;

import java.util.ArrayList;

public class Usuario  {
	private int id;
	private String nombre;
	private String contrasena;
	private int numeroLineas;
	//Nombre del curso - Suma despues de racha de 3 - Condicion de si acabo el curso
	private ArrayList<String[]> datosCursos = new ArrayList<String[]>();
	private int opcion;
	
	//Usuario para rescatar Usuarios
	public Usuario(int id, String nombre, String contrasena, int numeroLineas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.numeroLineas = numeroLineas;
		opcion = -1;
	}

	
	//Usuario para la creacion de usuarios
	public Usuario(String nombre, String contrasena) {
		this.id = 0;
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.numeroLineas = 0;
		opcion = 0;
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
	
	public void setDatos(ArrayList<String[]> datos) {
		this.datosCursos.clear();
		for(String[] todo:datos) {
			anadirDatos(todo);
		}
	}
	
	public ArrayList<String[]> getDatos(){
		return this.datosCursos;
	}
	
	

	
}
