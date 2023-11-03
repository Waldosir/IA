package bancoDatos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import DatosUsuario.Usuario;

public class LecturaUsuarios {
	private String Ruta = "DatosUsuarios/datos.txt";
	private ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	
	public LecturaUsuarios() { //Toma todos los usuarios
		ArrayList<Usuario> l =recuperarArrayListUsuarios();
		for(Usuario lista:l) {
			this.listaUsuarios.add(lista);
		}
		l= null;
	}
	
	public Usuario buscarUsuario(String nombre) {
		Usuario u = null;
		for(Usuario uLista:this.listaUsuarios){
			if(uLista.getNombre().equals(nombre)) {
				u = uLista;
				break;
			}
		}
		return u;
	}
	
	public boolean nombreDistinto(String nombre) { //Impide que haya nombre repetido
		for(Usuario lista:listaUsuarios) {
			if(lista.getNombre().equals(nombre)) {
				return false;
			}
		}
		return true;
	}
	
	//Valida usuarios y contraseñas que no esten largos o cortos
	public boolean validarTamano(String nombre, String contrasena) {
		if(nombre.length()<12 && nombre.length()>=4) {
			if(contrasena.length()<10 && contrasena.length()>4) {
				return true;
			}
		}
		
		return false;
	}
	
	//Verifica conexion para pasar Usuario-Contraseña
	public boolean conectar(String nombre, String contrasena) {
		for(Usuario lista:this.listaUsuarios) {
			if(lista.getNombre().equals(nombre)) {
				if(lista.getContrasena().equals(contrasena)) {
					return true;
			}
				
			}
		}
		return false;
	}
	
	//Checa si tiene curso.
	public boolean tieneCurso(Usuario u, String nombreCurso) {
			for(int i=0;i<u.getDatos().size();i++) {
				if(u.getDatos().get(i)[0].equals(nombreCurso)) {
					return true;
				}
			}
		anadirCursoUsuario(u,  nombreCurso);
		return false;
	}
	
	//Añade el curso a la linea de texto.
	private void anadirCursoUsuario(Usuario u, String nombreCurso) {
		String datos[] = {nombreCurso,"0","0"};
		u.anadirDatos(datos);
		u.setNumeroLineas(u.getNumeroLineas()+1);
		this.actualizarLista(u);
	}
	
	private void metodoAgregar(Usuario usuario) {
			Usuario u = usuario;//Crea un usuario
			/*
			 * FileOutPutStream permite la salida de datos. Como FileWriter, solo que permite 
			 * flujo de Bytes sin formato
			 * 
			 * El constructor escribe en un String, con valor booleano true
			 */
			try(FileOutputStream fos = new FileOutputStream(Ruta,true); 
					PrintStream salida = new PrintStream(fos)){
			//Imprime ID, nombre, contraseña y numero de cursos con su información respectiva
				salida.println(u.getId()+"|"+u.getNombre()+"|"+u.getContrasena()+"|"+u.getNumeroLineas());
				for(int i=0;i<u.getNumeroLineas();i++) {
					String[] datosCurso = u.getDatos().get(i);
					salida.println(datosCurso[0]+"|"+datosCurso[1]+"|"+datosCurso[2]);
				}
				
			}catch(IOException ex) {
				ex.printStackTrace();
			}
			
	}

	private void crearArchivo() {
		try {
		      File myObj = new File(Ruta); //Archivo en objeto
		      Files.createDirectories(Paths.get("DatosUsuarios"));
		      if (myObj.createNewFile()) { //Si se crea el archivo
		        //System.out.println("Archivo creado: " + myObj.getName());
		      } else {//Si ya existe el archivo
		        //System.out.println("Ya existe el archivo.");
		      }
		    }
		catch (IOException e) {//En dado caso no se pueda crear el archivo
		      System.out.println("Un error ha ocurrido.");
		      e.printStackTrace();
		    }
		  }
	
	private Usuario[] recuperarUsuarios() {//Lista de todos los usuarios y sus datos
		ArrayList<Usuario> existentes = new ArrayList<>();
		Usuario u = null;
		try(BufferedReader bf = new BufferedReader(new FileReader(Ruta))){//Lee los datos
			String s;
			while((s = bf.readLine())!=null) {//Hasta que no haya linea para leer
				String[] datos = s.split("[|]");//Reagrupa los datos con su respectivo separador
				//Crea un usuario con esos datos
				u = new Usuario(Integer.parseInt(datos[0]),datos[1],datos[2],Integer.parseInt(datos[3]));
				for(int i=0; i<u.getNumeroLineas();i++) {
					s = bf.readLine();
					datos = s.split("[|]");
					u.anadirDatos(datos);
				}
				existentes.add(u);//Se anade el usuario a la lista
				}
			}catch(FileNotFoundException ex) { //Excepction no encuentra el archivo
				crearArchivo(); //Crea el archivo
			}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		//Se regresa el ArrayList en Array
		return existentes.toArray(new Usuario[0]);}
	
	private ArrayList<Usuario> recuperarArrayListUsuarios() { //Conversion de Arreglo a ArrayList
		ArrayList<Usuario> listaU = new ArrayList<Usuario>();
		Usuario[] lista = recuperarUsuarios();
		for(int i=0;i<lista.length;i++) {
			listaU.add(lista[i]);
		}
		
		return listaU;
	}
	
	private void borraTodo(){
		try(PrintStream out = new PrintStream(Ruta);){//Crea un nuevo archivo con esos datos
			FileOutputStream writer = new FileOutputStream(Ruta);
			writer.write(("").getBytes()); //Escribe un archivo sin caracteres
			writer.close();
			
		}catch(FileNotFoundException ex) { //Excepction no encuentra el archivo
			crearArchivo(); //Crea el archivo
		} 
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void borrarUsuario(String nombre) {
		Usuario uBorrar = null;
		for(Usuario listaT: this.listaUsuarios) {
			if(listaT.getNombre().equals(nombre)) {
				uBorrar = listaT;
				break;
			}
		}
		if(uBorrar!=null) {
			this.listaUsuarios.remove(uBorrar);
			ordenarMiembros();
			borraTodo(); //Archivo limpio
			for(Usuario listaT:this.listaUsuarios) {
				metodoAgregar(listaT);
			}
		}
		
	}
	
	public void actualizarLista(Usuario u) {
		boolean eliminar = false; Usuario uEliminar = null;
		ordenarMiembros();
		for(Usuario listaT: this.listaUsuarios) {
			if(listaT.getId() == u.getId()) {
				uEliminar = listaT;
				eliminar = true;
				break;
			}
		}
		
		if(eliminar) {
			this.listaUsuarios.remove(uEliminar);
		}else {
			if(u.getId()==0) { //Nuevo usuario
				u.setId(asignarID());
			}
		}
		this.listaUsuarios.add(u);
		ordenarMiembros();
		
		borraTodo(); //Archivo limpio
		for(Usuario listaT:this.listaUsuarios) {
			metodoAgregar(listaT);
		}
	}
	
	private void ordenarMiembros() {
		Collections.sort(this.listaUsuarios, new Comparator<Usuario>() {
			public int compare(Usuario u1, Usuario u2) {
				if(u1.getId()>u2.getId()) {
					return 1;
				}if(u1.getId()<u2.getId()) {
					return -1;
				}
				return 0;
			}
		});
	}
		
	private int asignarID() {
		int x=1;
		for(Usuario p:this.listaUsuarios) {
			if(x==p.getId()) {
				x +=1;
			}else {
				break;
			}
		}
		return x;
	}
	
	
	/*
	public Usuario busquedaUsuario(String nombreUsuario) { 
		Usuario u = null;
		try(BufferedReader bf = new BufferedReader(new FileReader(Ruta))){//Encuentra el archivo
			String s;
			while((s = bf.readLine())!=null) {//Lee una linea entera y hasta que la línea ya no tenga nada
				String[] datos = s.split("[|]");//Array de todos los datos seccionados
				if(datos[1].equals(nombreUsuario)) {//Si encuentra el nombre se crea el objeto con sus datos
					u = new Usuario(Integer.parseInt(datos[0]),datos[1], datos[2],Integer.parseInt(datos[3]));
					int lineas = u.getNumeroLineas();
					for(int i=0;i<lineas;i++) {
						s = bf.readLine();
						datos = s.split("[|]");
						u.anadirDatos(datos);
					}
					
					break;
				}
			}
		}catch(FileNotFoundException ex) { //Excepction no encuentra el archivo
			crearArchivo(); //Crea el archivo
		}
		catch(IOException ex) { //Otra clase de error
			System.out.println("Error");
			ex.printStackTrace();
		}
		
		return u;
	}
	
	//*/
	
	
	
	
}