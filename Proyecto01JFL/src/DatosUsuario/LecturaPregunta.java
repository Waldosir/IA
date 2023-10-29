package DatosUsuario;

import java.util.ArrayList;
import java.util.Collections;

import procesadoJFL.Dificultad;

public class LecturaPregunta {
	private Dificultad dif;
	private ArrayList<String[]> datos = new ArrayList<String[]>();
	private Usuario uActual;
	private String nombreCurso;
	private int numeroPregunta;
	
	public LecturaPregunta(Dificultad dif, Usuario uActual, String nombreCurso) {
	this.numeroPregunta = 0;
	this.dif = dif;
	this.uActual = uActual;
	this.nombreCurso = nombreCurso;
	usuarioNuevo();
	calcularPreguntas();
	}
	
	public Dificultad getDificultad() {
		return this.dif;
	}
	
	
	public String getPregunta() {
		return this.datos.get(numeroPregunta)[0];
	}
	
	public String getRespuesta() {
		return this.datos.get(numeroPregunta)[5];
	}
	
	public void siguientePregunta() {
		this.numeroPregunta++;
		if(this.numeroPregunta>=this.datos.size()) {
			Collections.shuffle(datos);
			this.numeroPregunta = 0;
		}
	}
	
	public String respuestaParaUsuario(int opcion) {
		return this.datos.get(numeroPregunta)[opcion+1];
	}
	
	public String[] tomarDatosPreguntas(int posicion) {
		return this.datos.get(posicion);
	}
	
	public void modificarDificultad(Dificultad dif) {
		this.dif = dif;
		calcularPreguntas();
	}
	
	private void calcularPreguntas(){
		this.datos.clear();
		ArrayList<String[]> d = null;
		if(this.dif.toString().equals(Dificultad.facil.toString())) {
			d =datosPreguntaFacil();
		}else if(this.dif.toString().equals(Dificultad.normal.toString())){
			d = datosPreguntaNormal();
		}else if(this.dif.toString().equals(Dificultad.dificil.toString())) {
			d = datosPreguntaDificil();
		}
		
		for(int i=0; i<d.size();i++) {
			datos.add(d.get(i));
		}
		
		Collections.shuffle(datos);
	}
	
	private ArrayList<String[]> datosPreguntaFacil(){
		ArrayList<String[]> datos = new ArrayList<String[]>();
		datos = datosPFaciltxt(); //De donde saca la información
		return datos;
	}
	
	private ArrayList<String[]> datosPreguntaNormal(){
		ArrayList<String[]> datos = new ArrayList<String[]>();
		datos = datosPNormaltxt(); //De donde saca la información
		return datos;
	}
	
	private ArrayList<String[]> datosPreguntaDificil(){
		ArrayList<String[]> datos = new ArrayList<String[]>();
		datos =  datosPDificiltxt();
		return datos;
	}
	
	private void usuarioNuevo() {
		LecturaDatos l = new LecturaDatos();
		if(!l.tieneCurso(this.uActual, this.nombreCurso)) {
			l.anadirCursoUsuario(uActual, nombreCurso);
		}
		
	}
	
	/*
	 * De aqui a arriba no son modificables
	 */
	
	/*
	 * Los modificables
	 */
	
	
	private ArrayList<String[]> datosPFaciltxt(){
		ArrayList<String[]> datos = new ArrayList<String[]>();
		LecturaPreguntastxt preguntaDatos = new LecturaPreguntastxt();
		datos = preguntaDatos.preguntasFacil();
		return datos;
	}
	
	private ArrayList<String[]> datosPNormaltxt(){
		ArrayList<String[]> datos = new ArrayList<String[]>();
		LecturaPreguntastxt preguntaDatos = new LecturaPreguntastxt();
		datos = preguntaDatos.preguntasNormal();
		return datos;
	}
	
	private ArrayList<String[]> datosPDificiltxt(){
		ArrayList<String[]> datos = new ArrayList<String[]>();
		LecturaPreguntastxt preguntaDatos = new LecturaPreguntastxt();
		datos = preguntaDatos.preguntasNormal();
		return datos;
	}
	
	

}
