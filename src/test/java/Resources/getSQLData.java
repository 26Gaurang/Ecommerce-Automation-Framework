package Resources;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

public class getSQLData {
	
	@DataProvider(name = "sqlData")
    public Iterator<Object[]> getSQLDatabase() throws SQLException {
      
        List<Object[]> data = DBsetup.getLoginData();

        return data.iterator();
    }
	
	
	

}
