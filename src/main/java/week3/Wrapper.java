package week3;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.sun.java.swing.plaf.windows.resources.windows;

public class Wrapper {
	RemoteWebDriver driver;

	public void launchApp(String browser, String url) {

		try {
			if (browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}

			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (WebDriverException e) {
			System.out.println("Application could not be launched !!");
		}
	}

	// 1. wrapper class for By ID

	public void enterTextById(String id, String value) {
		try {
			driver.findElement(By.id(id)).clear();
			driver.findElement(By.id(id)).sendKeys(value);
		} catch (NoSuchElementException e) {
			System.out.println("The element with id : " + id + " could not be found !!");
		}
	}

	// 2. wrapper class for By class Name

	public void clickByClassName(String className) {
		try {

			driver.findElement(By.className(className)).click();
		} catch (NoSuchElementException e) {
			System.out.println("The element with className : " + className + " could not be found !!");
		}
	}
	// 3. wrapper class for By Name

	public void enterbyName(String namestring, String textname) {
		try {
			{
				driver.findElementByName(namestring).sendKeys(textname);

			}
		} catch (NoSuchElementException e) {
			System.out.println("The element with Name :" + namestring + "Could not be found");
		}

	}

	// 4. wrapper class for XPath

	public void clickbyxpath(String pathstring) {
		try {

			{
				driver.findElement(By.xpath(pathstring)).click();

			}
		} catch (NoSuchElementException e) {
			System.out.println("The element with Xpath :" + pathstring + " Could not be found");
		}

	}

	// 5. wrapper class for Index (String Id,int indexnum)

	public void selectbIndex(String Id, int indexnum) {
		try {

			{
				Select drop = new Select(driver.findElementById(Id));
				drop.selectByIndex(indexnum);

			}
		} catch (NoSuchElementException e) {
			System.out.println("The dropdown list does not contain the Index no: " + indexnum);
		}

	}

	// 6. wrapper class to verify browser title
	public void verifybrowsertitle(String title) {
		boolean status = false;
		try {
			if (driver.getTitle().equals(title)) {
				status = true;
				System.out.println("Both the titles matched");

			} else {
				System.out.println("The Titles  does not match :");
				System.out.println("The expected title is : " + title);
				System.out.println("The actual browser title is :" + driver.getTitle());
			}
		} catch (Exception e) {
			System.out.println("Browser could not be verified");
		}

	}

	// 7. wrapper class to verify URL
	public void verifyURL(String url) {
		boolean status = false;
		try {
			if (driver.getCurrentUrl().equals(url)) {
				status = true;
				System.out.println("Both the URLs matched");

			} else {
				System.out.println("The URLs  does not match :");
				System.out.println("The expected URL  is : " + url);
				System.out.println("The actual URL is :" + driver.getCurrentUrl());
			}
		} catch (Exception e) {
			System.out.println("URL could not be verified");
		}
	}

	// 8,9. Frames Wrapper class - tage name and number of the frame to be
	// switched are passed as
	// argument
	public void handleframe(String tagname, int framenumber) {
		try {
			{
				List<WebElement> ele = driver.findElementsByTagName(tagname);

				int count = ele.size();

				for (int i = 0; i < count; i++) {
					driver.switchTo().frame(i);
					if (i == framenumber) {
						System.out.println("Successfully switched to the " + framenumber + "frame");
						break;
					}

				}

				driver.switchTo().defaultContent();
				System.out.println("Successfully swithced back to Parent Frame");

			}
		} catch (NoSuchElementException e) {
			System.out.println("No frames available");
		}

	}

	// 10. Wrapper class to accept the alert

	public void acceptalert() {
		try {
			Alert a = driver.switchTo().alert();

			System.out.print("Alert is :" + a.getText());

			a.accept();
		} catch (UnhandledAlertException e) {
			System.out.println("No such alert found ");
		}

	}

	// 11. Wrapper class to Dismiss the alert
	public void dismissalert() {
		try {
			Alert a = driver.switchTo().alert();

			System.out.print("Alert to Dismiss is :" + a.getText());

			a.dismiss();
		} catch (UnhandledAlertException e) {
			System.out.println("No such alert found ");
		}
	}

	// 12,13. Window Handling
	public void windowhandling(String xpath) {
		String parentHandle = driver.getWindowHandle();

		driver.findElementByXPath(xpath);

		Set<String> allwindows = driver.getWindowHandles();
		for (String eachwindow : allwindows) {
			driver.switchTo().window(eachwindow);
			driver.close();
		}
		System.out.println("Switched to Last window");
		driver.switchTo().window(parentHandle);
		System.out.println("Switched back to Parent window");
	}

	

	// 14. Verify Text
public void verifytext(String Texttoverify) {
	try {
		Alert a = driver.switchTo().alert();
if (a.getText().equals(Texttoverify))

{ System.out.println("The Title of the alerts matches");
}	else
	{
		System.out.println("The Text does not match");
		System.out.println("The expectd Text is : "+Texttoverify);
		System.out.println("The actual Text is : " + a.getText());
	}
		
	} catch (UnhandledAlertException e) {
		System.out.println("No such alert found ");
	}
}
//15. wrapper class for LinkText

	public void enterbyLinkText(String Textlink) {
		try {

			{
				driver.findElement(By.linkText(Textlink)).click();

			}
		} catch (NoSuchElementException e) {
			System.out.println("The element with Xpath :" + Textlink + " Could not be found");
		}

	}
//	Execution of tasks class
	
public void execution()
{
	enterTextById("username", "DemoSalesManager");
	enterTextById("password", "crmsfa");
	clickByClassName("decorativeSubmit");
	clickbyxpath("//*[@id='button']/a/img");
	enterbyLinkText("Create Lead");
	enterTextById("createLeadForm_companyName", "ABCD");
	enterTextById("createLeadForm_firstName", "Senthil");
	enterTextById("createLeadForm_lastName", "Kumar");
	clickByClassName("smallSubmit");
	driver.close();
}
}
