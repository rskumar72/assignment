package week3;

import org.junit.Test;

public class Opentaps_CreateLead extends Wrapper {

	@Test
	public void createLead() {

		launchApp("chrome", "http://demo1.opentaps.org/opentaps/control/main");
		execution();
		System.out.println("Process completed successfully with Chrome Browser");
		
		
//		Now Proceed the same with the Firefox driver
		launchApp("firefox",  "http://demo1.opentaps.org/opentaps/control/main");
		execution();
		System.out.println("Process completed successfully with Firefox Browser");
	}
}
