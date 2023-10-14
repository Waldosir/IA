package FL;

import net.sourceforge.jFuzzyLogic.FIS;

public class TestTipper {
		  public static void main(String[] args) throws Exception {
		    FIS fis = FIS.load("fcl/tipper.fcl", true); // Load from 'FCL' file
		    fis.setVariable("service", 3); // Set inputs
		    fis.setVariable("food", 7);
		    fis.evaluate(); // Evaluate

		    // Show output variable
		    System.out.println("Output value:" + fis.getVariable("tip").getValue()); 
		  }
		}