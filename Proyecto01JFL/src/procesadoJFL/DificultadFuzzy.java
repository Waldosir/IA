package procesadoJFL;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

public class Dificultad {
	private final String fileName = "C:/Users/Waldosir/Desktop/PrograMCC/IA/flc/project01.fcl";
	private double time;
	private double help;
	private double mistakes;
	
	private double easy;
	private double normal;
	private double hard;
	
	public Dificultad() {
		//Aqui introducire valos de dificultad almacenados en un .txt
		/*
		 * this.easy = algo
		 * this.normal = algo
		 * this.hard = algo
		 */
		
		this.easy = 0;
		this.normal = 0;
		this.hard = 0;
	}
	public double getTime() {
		return this.time;
	}
	public double getHelp() {
		return this.help;
	}
	public double getMistakes() {
		return this.mistakes;
	}
	
	public void setValoresDificultad(double time,int help,int  mistakes) {
		this.time = time;
		this.help = (double) help;
		this.mistakes = (double) mistakes;
	}
	
	public void sumarAyuda() {
		this.help+=1;
	}
	
	public void sumarErrores() {
		this.mistakes+=1;
	}
	
	
	public void proceso() {
		double timeL = this.time, helpL = this.help, mistakesL = this.mistakes;
		//double timeL = 1, helpL = 1, mistakesL = 0;
		if(this.time>360) {
			timeL = 360;
		}
		if(this.help>3) {
			timeL = 3;
		}
		if(this.mistakes>4) {
			timeL = 4;
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
       JFuzzyChart.get().chart(functionBlock);

       // Set inputs
       fis.setVariable("time", timeL);
       fis.setVariable("help", helpL);
       fis.setVariable("mistakes", mistakesL);
       

       // Evaluate
       fis.evaluate();
       
       //Da la tabla de la dificultad
       //Variable difficult = functionBlock.getVariable("difficult");
       //JFuzzyChart.get().chart(difficult, difficult.getDefuzzifier(),true);
       //Gpr.debug("easy[difficult]: "+ functionBlock.getVariable("difficult").getMembership("easy"));
       
       this.easy += functionBlock.getVariable("difficult").getMembership("easy");
       this.normal+= functionBlock.getVariable("difficult").getMembership("normal");
       this.hard += functionBlock.getVariable("difficult").getMembership("hard");
       
       
	}
	
	public String getDificultad() {
		proceso();
		String dificultad ="";
		if(hard>normal && hard > easy) {
			dificultad = dificultades.dificil.toString();
		}else if(normal>=easy) {
			dificultad = dificultades.normal.toString();
		}else {
			dificultad = dificultades.facil.toString();
		}
	       return dificultad;
	}
	
	
	
	
}
