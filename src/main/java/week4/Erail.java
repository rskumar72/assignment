
package week4;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import project1.MyWrapper;

public class Erail extends MyWrapper 
{
	String from = "MAS";
	String to = "ONG";
	List <WebElement> header,train;
	int col = 0;
	int trainCount = 0;
	int i= 1;
	int j= 1;
	int size;
	@Test
	public void start() throws IOException, InterruptedException
	{
		
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://erail.in/");
		driver.findElementById("txtStationFrom").clear();
		driver.findElementById("txtStationFrom").sendKeys(from);
		Thread.sleep(3000);
		driver.findElementById("txtStationFrom").sendKeys(Keys.ENTER);
		 
		
		driver.findElementById("txtStationTo").clear();
		driver.findElementById("txtStationTo").sendKeys(to);
		Thread.sleep(3000);
		driver.findElementById("txtStationTo").sendKeys(Keys.ENTER);
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		createSheet("D:\\NewMavenPro\\SelMarch\\data\\erail.xlsx", "Status");
		
		header = driver.findElementsByXPath("//div[@id='divTrainsListHeader']/table/tbody/tr/td");
		addRow(0);
		
		for (WebElement elem : header) 
		{
			addCellData(0, col, elem.getText());
			col++;
		}
		
		header = driver.findElementsByXPath("//div[@id='divTrainsList']/table/tbody/tr");
		trainCount = header.size();
		//System.out.println("Train Count "+trainCount);
		
		for(i=1;i<trainCount;i++)
		{		
			addRow(i);
			//System.out.println("Row "+i+" Created");
			train = driver.findElementsByXPath("//div[@id='divTrainsList']/table[1]/tbody/tr["+i+"]/td");
			size = train.size();
			//System.out.println(size);
			
			for(j=1;j<=size;j++)
			{
				addCellData(i, j-1, driver.findElementByXPath("//div[@id='divTrainsList']/table/tbody/tr["+i+"]/td["+j+"]").getText());
			}
		}
		
		writeAndClose();
		
	}
}

