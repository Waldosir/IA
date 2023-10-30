package DatosUsuario;

import java.util.ArrayList;
import java.util.Collections;

import bancoDatos.LecturaPreguntastxt;
import bancoDatos.LecturaUsuarios;
import procesadoJFL.Dificultad;

public class LecturaPregunta {
	private Dificultad dif;
	private ArrayList<String[]> datos = new ArrayList<String[]>();
	private Usuario uActual;
	private String nombreCurso;
	private int numeroPregunta;
	
	public LecturaPregunta(Dificultad dif, Usuario uActual, String nombreCurso) {
	this.numeroPregunta = 0;
	this.uActual = uActual;
	this.dif = dif;
	this.nombreCurso = nombreCurso;
	usuarioNuevo();
	calcularPreguntas();
	}
	
	public Usuario getUsuario() {
		return this.uActual;
	}
	
	public Dificultad getDificultad() {
		return this.dif;
	}
	
	public void modificarDificultad(Dificultad dif) {
		if(!(this.dif.toString().equals(dif.toString()))) {
			this.dif = dif;
			calcularPreguntas();
		}
		
	}
	

	
	public String getPregunta() {
		try {
			return this.datos.get(this.numeroPregunta)[0];
		} catch(IndexOutOfBoundsException e) {
			this.numeroPregunta = 0;
			Collections.shuffle(this.datos);
			return this.datos.get(this.numeroPregunta)[0];
		}
		
	}
	
	public String getRespuesta() {
		try {
			return this.datos.get(this.numeroPregunta)[5];
		}catch(IndexOutOfBoundsException e) {
			this.numeroPregunta = 0;
			Collections.shuffle(this.datos);
			return this.datos.get(this.numeroPregunta)[5];
		}
		
	}
	
	public void siguientePregunta() {
		this.numeroPregunta++;
		/*
		if(this.numeroPregunta>=this.datos.size()) {
			this.numeroPregunta = 0;
			Collections.shuffle(datos);
			
		}
		*/
	}
	
	public String respuestaParaUsuario(int opcion) { //LALALALALA
		try {
			return this.datos.get(numeroPregunta)[opcion+1];
		}catch(IndexOutOfBoundsException e) {
			this.numeroPregunta = 0;
			Collections.shuffle(this.datos);
			return this.datos.get(numeroPregunta)[opcion+1];
		}
		
	}
	
	public String[] tomarDatosPreguntas(int posicion) {
		try {
			return this.datos.get(posicion);
		}
		catch(IndexOutOfBoundsException e) {
			this.numeroPregunta = 0;
			Collections.shuffle(this.datos);
			return this.datos.get(posicion);
		}
	}
	
	
	private void calcularPreguntas(){
		this.datos.clear();
		ArrayList<String[]> pF = datosPreguntaFacil();
		ArrayList<String[]> pN = datosPreguntaNormal();
		ArrayList<String[]> pD = datosPreguntaDificil();
		
		if(this.dif.toString().equals(Dificultad.facil.toString())) {
			for(String[] preguntas:pF) {
				this.datos.add(preguntas);
			}
		}else if(this.dif.toString().equals(Dificultad.normal.toString())){

			for(String[] preguntas:pF) {
				this.datos.add(preguntas);
			}
			//*/
		
			for(String[] preguntas:pN) {
				this.datos.add(preguntas);
			}
			
		}else if(this.dif.toString().equals(Dificultad.dificil.toString())) {

			for(String[] preguntas:pF) {
				this.datos.add(preguntas);
			}
			
			for(String[] preguntas:pN) {
				this.datos.add(preguntas);
			}
			//*/
			for(String[] preguntas:pD) {
				this.datos.add(preguntas);
			}
			
		}

		Collections.shuffle(datos);
	}
	
	private ArrayList<String[]> datosPreguntaFacil(){
		ArrayList<String[]> datos = new ArrayList<String[]>();
		datos = datosPFaciltxtGrafica(); //De donde saca la información
		return datos;
	}
	
	private ArrayList<String[]> datosPreguntaNormal(){
		ArrayList<String[]> datos = new ArrayList<String[]>();
		datos = datosPNormaltxtGrafica(); //De donde saca la información
		return datos;
	}
	
	private ArrayList<String[]> datosPreguntaDificil(){
		ArrayList<String[]> datos = new ArrayList<String[]>();
		datos = datosPDificiltxtGrafica(); //De donde saca la información
		return datos;
	}
	
	private void usuarioNuevo() {
		LecturaUsuarios l = new LecturaUsuarios();
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
	
	
	private ArrayList<String[]> datosPFaciltxtGrafica(){
		ArrayList<String[]> datos = new ArrayList<String[]>();
		LecturaPreguntastxt preguntaDatos = new LecturaPreguntastxt(this.nombreCurso);
		datos = preguntaDatos.preguntasFacil();
		return datos;
	}
	
	private ArrayList<String[]> datosPNormaltxtGrafica(){
		ArrayList<String[]> datos = new ArrayList<String[]>();
		LecturaPreguntastxt preguntaDatos = new LecturaPreguntastxt(this.nombreCurso);
		datos = preguntaDatos.preguntasNormal();
		return datos;
	}
	
	private ArrayList<String[]> datosPDificiltxtGrafica(){
		ArrayList<String[]> datos = new ArrayList<String[]>();
		LecturaPreguntastxt preguntaDatos = new LecturaPreguntastxt(this.nombreCurso);
		datos = preguntaDatos.preguntasDificil();
		return datos;
	}
	
	private int PosicionDatoCurso() {
		ArrayList<String[]> datos = this.uActual.getDatos();
		int x = 0;
		for(String[] curso:datos) {
			if(curso[0].equals(nombreCurso)) {
				return x;
				}
			x++;
			}
		return 0;
		}

	
	public boolean CursoTerminado() {
		ArrayList<String[]> datos = this.uActual.getDatos();
		for(String[] curso:datos) {
			if(curso[0].equals(nombreCurso)) {
				if(curso[2].equals("1")) {
					return true;
				}
			}
		}
		return false;
	}
	
	private void modificarDatosCursoUsuario(String[] datosUsuario) {
		ArrayList<String[]> datosCurso = this.uActual.getDatos();
		ArrayList<String[]> datosFinales = new ArrayList<String[]>();
		int x = 0;
		for(String[] sumaDatos: datosCurso) {
			if(x!=PosicionDatoCurso()) {
				datosFinales.add(sumaDatos);
			}else {
				datosFinales.add(datosUsuario);
			}
			x++;
		}
		
		uActual.setDatos(datosFinales);
		
		LecturaUsuarios lu = new LecturaUsuarios();
		lu.actualizarLista(uActual);
	}
	
	public void terminarCurso() {
		ArrayList<String[]> datosCursos = this.uActual.getDatos();
		String[] datosUsuario = datosCursos.get(PosicionDatoCurso());
		String datoS = "1";
		datosUsuario[2] = datoS;
		modificarDatosCursoUsuario(datosUsuario);
	}
	
	public void sumarRachaMayorTres() {
		ArrayList<String[]> datosCursos = this.uActual.getDatos();
		String[] datosUsuario = datosCursos.get(PosicionDatoCurso());
		if(datosUsuario[2].equals("0")) {
			int datoInt = Integer.parseInt(datosUsuario[1])+1;
			String datoS = datoInt + "";
			datosUsuario[1] = datoS;
			modificarDatosCursoUsuario(datosUsuario);
		}
		
		
	}
	
	public int getNumeroRacha() {
		String racha = this.uActual.getDatos().get(PosicionDatoCurso())[1];
		return Integer.parseInt(racha);
	}
	
	

}
