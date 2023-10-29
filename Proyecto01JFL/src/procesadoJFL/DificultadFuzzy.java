package procesadoJFL;

import DatosUsuario.Usuario;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.Gpr;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class DificultadFuzzy {
	//private final String fileName = "C:/Users/Waldosir/Desktop/PrograMCC/IA/flc/project01.fcl";
	private final String fileName = "D:/Documentos/RepositoriosGITHub/IA/Proyecto01JFL/flc/project01.fcl";
	private int time;
	private int help;
	private int mistakes;
	
	private int down=0;
	private int stay=0;
	private int up=1;
	
	public DificultadFuzzy() {
		this.time = 0;
		this.help = 0;
		this.mistakes = 0;
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
	
	public int proceso() {
		//double timeL = this.time, helpL = this.help, mistakesL = this.mistakes;
		double timeL = this.time, helpL = this.help, mistakesL = this.mistakes;
		int dif = 0;
		if(this.time>60) {
			timeL = 60;
		}
		if(this.help>3) {
			helpL = 3;
		}
		if(this.mistakes>3) {
			mistakesL = 3;
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
       
       //Da la tabla de la dificultad
       Variable checkLevel = functionBlock.getVariable(variablesFL.values()[3].toString());
      
       Gpr.debug(variablesFL.values()[3].toString()+"[Valor]: "+ functionBlock.getVariable(variablesFL.values()[3].toString()).getMembership("down"));
       System.out.println("Ver nivel "+functionBlock.getVariable(variablesFL.values()[3].toString()).defuzzify());
       double difDouble = functionBlock.getVariable(variablesFL.values()[3].toString()).defuzzify();
       
       dif = (int)(Math.round(difDouble));

       
       //Tabla de datos
       JFuzzyChart.get().chart(functionBlock);
       JFuzzyChart.get().chart(checkLevel, checkLevel.getDefuzzifier(),true);
       
       return dif;
	}
	
	public void verificarEstadoNivel(Usuario uActual) {
		int nivel = proceso();
		
		if(nivel<6) {
			this.down++;
		}else if(nivel<8) {
			this.stay++;
		}else {
			this.up++;
		}
		
		if(estadoDificultad()) {

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
			}
		}else if(down<=3) {
			if(Dificultad.dificil.toString().equals(d.toString())) {
				dificultadCambiar = Dificultad.normal;
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
	
	
	/*
	
	public String getDificultad() {
		proceso();
		String dificultad ="";
		if(hard>normal && hard > easy) {
			dificultad = Dificultad.dificil.toString();
		}else if(normal>=easy) {
			dificultad = Dificultad.normal.toString();
		}else {
			dificultad = Dificultad.facil.toString();
		}
	       return dificultad;
	}
	
	
	*/
	
}
