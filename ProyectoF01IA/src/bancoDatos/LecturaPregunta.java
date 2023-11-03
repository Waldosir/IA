package bancoDatos;

import java.util.ArrayList;
import java.util.Collections;

import DatosUsuario.Usuario;
import procesadoJFL.Dificultad;

public class LecturaPregunta {
	private Dificultad dif;
	private ArrayList<String[]> datosPregunta = new ArrayList<String[]>();
	private String nombreCurso;
	private int numeroPregunta;
	
	public LecturaPregunta(Dificultad dif, String nombreCurso) {
	this.numeroPregunta = 0;
	this.dif = dif;
	this.nombreCurso = nombreCurso;
	calcularPreguntas(false);
	}

	public Dificultad getDificultad() {
		return this.dif;
	}
	
	public void modificarDificultad(Dificultad dif, boolean racha) {
		if(!(this.dif.toString().equals(dif.toString()))) {
			this.dif = dif;
			calcularPreguntas(racha);
		}
		
	}

	public String getPregunta() {
		try {
			return this.datosPregunta.get(this.numeroPregunta)[0];
		} catch(IndexOutOfBoundsException e) {
			this.numeroPregunta = 0;
			Collections.shuffle(this.datosPregunta);
			return this.datosPregunta.get(this.numeroPregunta)[0];
		}
		
	}
	
	public String getRespuesta() {
		try {
			return this.datosPregunta.get(this.numeroPregunta)[5];
		}catch(IndexOutOfBoundsException e) {
			this.numeroPregunta = 0;
			Collections.shuffle(this.datosPregunta);
			return this.datosPregunta.get(this.numeroPregunta)[5];
		}
		
	}
	
	public void siguientePregunta() {
		this.numeroPregunta++;
	}
	
	public String respuestaParaUsuario(int opcion) { 
		try {
			return this.datosPregunta.get(numeroPregunta)[opcion+1];
		}catch(IndexOutOfBoundsException e) {
			this.numeroPregunta = 0;
			Collections.shuffle(this.datosPregunta);
			return this.datosPregunta.get(numeroPregunta)[opcion+1];
		}
		
	}
	
	public String[] tomarDatosPreguntas(int posicion) {
		try {
			return this.datosPregunta.get(posicion);
		}
		catch(IndexOutOfBoundsException e) {
			this.numeroPregunta = 0;
			Collections.shuffle(this.datosPregunta);
			return this.datosPregunta.get(posicion);
		}
	}
	
	
	private void calcularPreguntas(boolean racha){
		this.datosPregunta.clear();
		ArrayList<String[]> pF = datosPreguntaFacil();
		ArrayList<String[]> pN = datosPreguntaNormal();
		ArrayList<String[]> pD = datosPreguntaDificil();
		
		if(this.dif.toString().equals(Dificultad.facil.toString())) {
			for(String[] preguntas:pF) {
				this.datosPregunta.add(preguntas);
			}
		}else if(this.dif.toString().equals(Dificultad.normal.toString())){
		
			for(String[] preguntas:pN) {
				this.datosPregunta.add(preguntas);
			}
			
		}else if(this.dif.toString().equals(Dificultad.dificil.toString())) {
			if(racha) {
				for(String[] preguntas:pF) {
					this.datosPregunta.add(preguntas);
				}
				
				for(String[] preguntas:pN) {
					this.datosPregunta.add(preguntas);
				}
			}
			
			//*/
			for(String[] preguntas:pD) {
				this.datosPregunta.add(preguntas);
			}
			
		}

		Collections.shuffle(datosPregunta);
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
	
	private int PosicionDatoCurso(Usuario uActual) {
		ArrayList<String[]> datos = uActual.getDatos();
		int x = 0;
		for(String[] curso:datos) {
			if(curso[0].equals(nombreCurso)) {
				return x;
				}
			x++;
			}
		return 0;
		}

	
	public boolean CursoTerminado(Usuario uActual) {
		ArrayList<String[]> datos = uActual.getDatos();
		for(String[] curso:datos) {
			if(curso[0].equals(nombreCurso)) {
				if(curso[2].equals("1")) {
					return true;
				}
			}
		}
		return false;
	}
	
	private void modificarDatosCursoUsuario(String[] datosUsuario, Usuario uActual) {
		ArrayList<String[]> datosCurso = uActual.getDatos();
		ArrayList<String[]> datosFinales = new ArrayList<String[]>();
		int x = 0;
		for(String[] sumaDatos: datosCurso) {
			if(x!=PosicionDatoCurso(uActual)) {
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
	
	public void terminarCurso(Usuario uActual) {
		ArrayList<String[]> datosCursos = uActual.getDatos();
		String[] datosUsuario = datosCursos.get(PosicionDatoCurso(uActual));
		String datoS = "1";
		datosUsuario[2] = datoS;
		modificarDatosCursoUsuario(datosUsuario, uActual);
	}
	
	public void sumarRachaMayorTres(Usuario uActual) {
		ArrayList<String[]> datosCursos = uActual.getDatos();
		String[] datosUsuario = datosCursos.get(PosicionDatoCurso(uActual));
		if(datosUsuario[2].equals("0")) {
			int datoInt = Integer.parseInt(datosUsuario[1])+1;
			String datoS = datoInt + "";
			datosUsuario[1] = datoS;
			modificarDatosCursoUsuario(datosUsuario, uActual);
		}
		
		
	}
	
	public int getNumeroRacha(Usuario uActual) {
		String racha = uActual.getDatos().get(PosicionDatoCurso(uActual))[1];
		return Integer.parseInt(racha);
	}
	
	

}
