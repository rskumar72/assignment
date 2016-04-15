package assignment;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class frames {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:/Testleaf/selenium/drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
//		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://layout.jquery-dev.com/demos/iframes_many.html ");
		driver.manage().window().maximize();

		List<WebElement> ele = driver.findElementsByTagName("iframe");

		/* find out the total frames in main page */
		int count = ele.size();
		/* System.out.println("Number of frames in a page :" + ele.size()); */
		int total = count;

		/* to check in each frame */
		for (int i = 0; i < count; i++) {
			driver.switchTo().frame(i);
			List<WebElement> ele1 = driver.findElementsByTagName("iframe");
			int count1 = ele1.size();
			driver.switchTo().defaultContent();

			total = total + count1;

		}
		System.out.println("Total number of frames present :" + total);
		driver.quit();

	}

}
