package Resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBsetup {

	public static List<Object[]> getLoginData() throws SQLException{
		
		String url = "jdbc:mysql://localhost:3306/Ecom";
		String user = "root";
		String pass = "Gaurang@2610";
		
		Connection conn = DriverManager.getConnection(url, user, pass);
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM TestData");
		
		List<Object[]> Login = new ArrayList<>();
		
		while(rs.next()) {
		
				String email = rs.getString("Email");
				String password = rs.getString("Pass");
				String Prod = rs.getString("Product");
				String usern = rs.getString("UserName");
				String card = rs.getString("CardNo");
				String cv = rs.getString("Cvv");
				String emon = rs.getString("Month");
				String eyear = rs.getString("Year");	
			
		Login.add(new Object[]{email, password,Prod, usern, card, cv, emon, eyear});
		}
		
		conn.close();
		return Login;	
		
	}	
}
