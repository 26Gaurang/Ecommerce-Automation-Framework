package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	
public static Properties globalProp() throws IOException  {	
	
Properties prop = new Properties();

 	FileInputStream fis = new FileInputStream("C:\\Users\\customer\\eclipse-workspace\\Ecommerce\\src\\test\\java\\Resources\\globalConfig.properties");
	
 	prop.load(fis);
	
	prop.getProperty("browser");
	
	prop.getProperty("url");
	
	return prop;

}
		
	
}
	

	
	
	
