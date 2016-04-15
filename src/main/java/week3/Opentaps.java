package week3;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Opentaps extends Wrapper {

	@Test
	public void login() {

		/*
		 * FirefoxDriver driver=new FirefoxDriver();
		 * driver.get("http://demo1.opentaps.org/opentaps/control/main");
		 * driver.manage().window().maximize();
		 */

		launchApp("chrome", "http://demo1.opentaps.org/opentaps/control/main");

		enterTextById("username", "DemoSalesManager");
		enterTextById("password", "crmsfa");
		clickByClassName("decorativeSubmit");
//		launchApp("firefox", "http://demo1.opentaps.org/opentaps/control/main");
	}
}
