package procesadoJFL;

import java.util.Scanner;

import DatosUsuario.Usuario;
import bancoDatos.LecturaPregunta;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class DificultadFuzzy {
	private final String fileName = System.getProperty("user.dir")+"/flc/project01.fcl";
	private int time;
	private int help;
	private int mistakes;
	private boolean racha;
	
	private int down=0;
	private int stay=0;
	private int up=1;
	
	public DificultadFuzzy() {
		this.time = 0;
		this.help = 0;
		this.mistakes = 0;
		this.racha = false;
	}
	
	public int getTime() {
		return this.time;
	}
	
	public int getHelp() {
		return this.help;
	}
	
	public int getMistakes() {
		return this.mistakes;
	}
	
	public boolean getRacha() {
		return this.racha;
	}
	
	public void setRacha(boolean racha) {
		this.racha = racha;
	}
	
	public void setValoresDificultad(int time,int help,int  mistakes) {
		this.time = time;
		this.help = help;
		this.mistakes = mistakes;
	}
	
	public void sumarAyuda() {
		this.help+=1;
	}
	
	public void sumarErrores() {
		this.mistakes+=1;
	}
	
	public void resetFL() {
		this.help = 0;
		this.mistakes = 0;
		this.time = 0;
	}
	
	private double proceso() {
		//double timeL = this.time, helpL = this.help, mistakesL = this.mistakes;
		double timeL = this.time, helpL = this.help, mistakesL = this.mistakes;
		
		if(timeL>variablesFL.time.getValorMaximo()) {
			timeL = variablesFL.time.getValorMaximo();
		}
		if(helpL>variablesFL.help.getValorMaximo()) {
			helpL =variablesFL.help.getValorMaximo();
		}
		if(mistakesL>variablesFL.mistakes.getValorMaximo()) {
			mistakesL = variablesFL.mistakes.getValorMaximo();
		}
		
		 // Load from 'FCL' file
       
       FIS fis = FIS.load(fileName,true);
       // Error while loading?
       if( fis == null ) { 
           System.err.println("Can't load file: '" 
                                  + fileName + "'");
           return 0;
       }
       
       //Show Ruleset
       FunctionBlock functionBlock = fis.getFunctionBlock(null);
       //Da la tabla de todos los datos
       
       // Set inputs
       fis.setVariable(variablesFL.values()[0].toString(), timeL);
       fis.setVariable(variablesFL.values()[1].toString(), helpL);
       fis.setVariable(variablesFL.values()[2].toString(), mistakesL);
       

       // Evaluate
       fis.evaluate();
       
       double difDouble = functionBlock.getVariable(variablesFL.values()[3].toString()).defuzzify();
       
       //System.out.println(difDouble);
       //dif = (int)(Math.round(difDouble));
       //Variable checkLevel = functionBlock.getVariable(variablesFL.values()[3].toString());
       //Tabla de datos
       
      // JFuzzyChart.get().chart(functionBlock);
      // JFuzzyChart.get().chart(checkLevel, checkLevel.getDefuzzifier(),true);
       return difDouble;
	}
	
	public void verificarEstadoNivel(LecturaPregunta pregunta, Usuario uActual) {
		double nivel = proceso();
		if(nivel<4) {
			this.down++;
		}
		if(nivel<6) {
			this.down++;
			racha = false;
		}else if(nivel<7.8) {
			this.stay++;
			racha = false;
		}else {
			this.up++;
		}
		if(estadoDificultad()) {
			pregunta.modificarDificultad(cambioDificultad(pregunta.getDificultad()), this.racha);
		}
		
		if(this.racha) {
			pregunta.sumarRachaMayorTres(uActual);
		}
	}
	
	public boolean estadoDificultad() {
		if(down>=3 || up>=3) {
			return true;
		}else if(stay>=3) {
			down = 0;
			stay = 0;
			up = 0;
		}
		return false;
	}
	
	public Dificultad cambioDificultad(Dificultad d) {
		Dificultad dificultadCambiar = Dificultad.facil;
		if(up>=3) {
			if(Dificultad.facil.toString().equals(d.toString())) {
				dificultadCambiar = Dificultad.normal;
			}else if(Dificultad.normal.toString().equals(d.toString())) {
				dificultadCambiar = Dificultad.dificil;
			}else {
				dificultadCambiar = Dificultad.dificil;
				this.racha = true;
			}
		}else if(down>=3) {
			if(Dificultad.dificil.toString().equals(d.toString())) {
				dificultadCambiar = Dificultad.normal;
				this.racha = false;
			}else if(Dificultad.normal.toString().equals(d.toString())) {
				dificultadCambiar = Dificultad.facil;
			}else {
				dificultadCambiar = Dificultad.facil;
			}
		}
		this.up = 0;
		this.down = 0;
		this.stay = 0;
		
		return dificultadCambiar;
		
	}
	
	/*//Activar solo para pruebas
	public void checarGraficas() {
			int tiempoMedio = 21;
			int ayudaMedia =1;
			int errorMedio = 1;
				System.out.println("Primera prueba:");
				pruebas(tiempoMedio,2,1);
				espera();
				System.out.println("R1Sube:");
				pruebas(0,0,0); 
				espera();
				System.out.println("R2Queda:");
				pruebas(100,0,0); 
				espera();
				System.out.println("R3Queda ->Ver:");
				pruebas(100,ayudaMedia,0);
				espera();
				System.out.println("R4Baja:");
				pruebas(100,ayudaMedia,errorMedio);
				espera();
				System.out.println("R5Baja:");
				pruebas(-1,3,-1);
				espera();
				System.out.println("R6Baja:");
				pruebas(-1,-1,3);
				espera();
				System.out.println("R7Queda:");
				pruebas(-1,-1,errorMedio);
				espera();
				System.out.println("R8Sube:");
				pruebas(tiempoMedio,0,-1);
				espera();
				System.out.println("R9Queda:");
				pruebas(tiempoMedio,ayudaMedia,-1);
				espera();
	}
	
	private void espera() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Presione enter para continuar");
		sc.next();
		
	}
	
	private void pruebas(double timeL, double helpL, double mistakesL) {

		
				if(timeL>variablesFL.time.getValorMaximo()) {
					timeL = variablesFL.time.getValorMaximo();
				}
				if(helpL>variablesFL.help.getValorMaximo()) {
					helpL =variablesFL.help.getValorMaximo();
				}
				if(mistakesL>variablesFL.mistakes.getValorMaximo()) {
					mistakesL = variablesFL.mistakes.getValorMaximo();
				}
				
				 // Load from 'FCL' file
		       
		       FIS fis = FIS.load(fileName,true);
		       // Error while loading?
		       if( fis == null ) { 
		           System.err.println("Can't load file: '" 
		                                  + fileName + "'");
		           return ;
		       }
		       
		       //Show Ruleset
		       FunctionBlock functionBlock = fis.getFunctionBlock(null);
		       //Da la tabla de todos los datos
		       
		       // Set inputs
		       fis.setVariable(variablesFL.values()[0].toString(), timeL);
		       fis.setVariable(variablesFL.values()[1].toString(), helpL);
		       fis.setVariable(variablesFL.values()[2].toString(), mistakesL);
		       

		       // Evaluate
		       fis.evaluate();
		       
		       //Da la tabla de la dificultad
		       Variable checkLevel = functionBlock.getVariable(variablesFL.values()[3].toString());
		       System.out.println("Ver nivel "+functionBlock.getVariable(variablesFL.values()[3].toString()).defuzzify());
		       
		       //Tabla de datos
		       JFuzzyChart.get().chart(functionBlock);
		       JFuzzyChart.get().chart(checkLevel, checkLevel.getDefuzzifier(),true);
	}
	
	//*/
}
