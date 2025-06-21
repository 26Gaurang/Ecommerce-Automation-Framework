package AbstractComp;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AbstractComponents {

	
	protected WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {	
		this.driver = driver;
	}
	
	
	public void WaitForVisibility(WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));	
	}
	
	
	public void ElementToBeClickable(WebElement element2) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element2));	
	}
	
	
	public void JSscroll(WebElement element3) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element3);
	}
	
	public void JSclick(WebElement element4) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element4);
	}
	
	
	public void CaptureScreen(String msg) {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			
			//String folderPath = "screenshots/" + folderName;
		   // new File(folderPath).mkdirs(); // creates folder if not exists
			
			FileUtils.copyFile(src,new File("G:\\google photos\\Screens\\"+msg+".jpg"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	


}
