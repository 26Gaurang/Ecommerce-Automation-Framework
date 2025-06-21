package AbstractComp;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

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
	public static String testFolderName;
	
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
			
			 // Generate timestamp
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            // Base screenshot directory in Jenkins-safe path
            String baseDir = System.getProperty("user.dir") + "/screenshots";

            // Create a folder once per test (testFolderName should be set in @BeforeMethod)
            String folderPath = baseDir + "/" + testFolderName;
            new File(folderPath).mkdirs();  // create if not exists

            // Final screenshot path
            File dest = new File(folderPath + "/" + msg + "_" + timestamp + ".jpg");

            // Save file
            FileUtils.copyFile(src, dest);
            
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	


}
