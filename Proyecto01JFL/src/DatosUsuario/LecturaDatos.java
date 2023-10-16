package DatosUsuario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;





public class LecturaDatos {
	String ruta = "DatosUsuarios//usuarios.txt";
	public LecturaDatos() {
	
		
	}
	
	
	public Usuario buscarUsuario(String nombreUsuario) {
		Usuario u = null;
		try(BufferedReader bf = new BufferedReader(new FileReader(ruta))){//Encuentra el archivo
			String s;
			while((s = bf.readLine())!=null) {//Lee una linea entera y hasta que la línea ya no tenga nada
				String[] datos = s.split("[|]");//Array de todos los datos seccionados
				if(datos[1].equals(nombreUsuario)) {//Si encuentra el nombre se crea el objeto con sus datos
					u = new Usuario(Integer.parseInt(datos[0]),datos[1],datos[2],Integer.parseInt(datos[3]));
					break;
				}
			}
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		return u;//Si no encuentra nada, regresa null
	}
	
	public Usuario buscarIDUsuario(int ID) {//Buscar como el anterior, pero ahora con el ID
		Usuario u = null;
		try(BufferedReader bf = new BufferedReader(new FileReader(ruta))){
			String s;
			while((s = bf.readLine())!=null) {
				String[] datos = s.split("[|]");
				if(datos[0].equals(ID+"")) {//Dado que ID es un entero, ID se transforma en String y compara
					u = new Usuario(Integer.parseInt(datos[0]),datos[1],datos[2],Integer.parseInt(datos[3]));
					break;
				}
			}
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		return u;
	}
	
	
}
