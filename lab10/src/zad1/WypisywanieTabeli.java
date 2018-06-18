package zad1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class WypisywanieTabeli {
	
	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:h2:./data/nazwabazy", "sa", "");


			Statement statement = conn.createStatement();
			
			//Wyswietlanie calej tabeli:
			//statement.execute("SELECT * FROM waluty");
			
			//Ograniczenie do 10 pierwszych rekordow
			//statement.execute("SELECT * FROM waluty limit 10" );
			
			// Przykladowe kwerendy z dodatkwoym warunkiem:
			//statement.execute("SELECT * FROM waluty where data < '2001-03-27'");
			statement.execute("SELECT Id, data, USD, EUR FROM waluty where usd > eur");
			//statement.execute("SELECT * FROM waluty where usd > 4.50 and eur < 3.83");
			
			ResultSet rs = statement.getResultSet();
			
			ResultSetMetaData md  = rs.getMetaData();
					

			for (int i = 1; i <= md.getColumnCount(); i++){
				System.out.print(md.getColumnName(i)+ " | ");						
				
			}
			System.out.println();
			
			while (rs.next()) {
				for (int i = 1; i <= md.getColumnCount(); i++){
					System.out.print(rs.getObject(i) + " | ");							
				}
				System.out.println();
			}
		} 
		
		finally {
			if (conn!= null){
				conn.close();
			}
		}
	}

}
