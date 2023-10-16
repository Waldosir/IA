package DatosUsuario;

import procesadoJFL.Dificultad;

public class Usuario extends Dificultad {
	private int id;
	private String nombre;
	private String contrasena;
	private int opcion;
	private int nivel;
	
	
	public Usuario(String nombre, String contrasena) {
		this.id = 0;
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.opcion = 0;
		this.nivel = 1;
	}
	
	public Usuario(int id, String nombre, String contrasena, int nivel) {
		this.id = id;
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.opcion = 0;
		this.nivel = nivel;
	}
	
	public String getNombre() {
		return this.nombre; 
	}
	
	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}
	
	public int getOpcion() {
		return this.opcion; 
	}
	
	public int getNivel() {
		return this.nivel;
	}
	
	public void sumarNivel() {
		this.nivel+=1;
	}
	
	public void limpiar() {
		this.setValoresDificultad(0, 0, 0);
	}
	
	
	
}
