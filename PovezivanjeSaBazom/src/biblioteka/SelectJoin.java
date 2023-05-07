package biblioteka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectJoin {

	public static void main(String[] args) {
		
		
		String url = "jdbc:mysql://localhost:3306 /praksa";
		String username = "root";
		
		String password = "";
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			System.out.println("Uspesna konekcija ka bazi. ");
			
		String sqlSelect = "SELECT p.ime, p.prezime AS Pisac, k.naziv AS Knjiga "
				+ "FROM pisciknjige pk	JOIN pisci p "
				+ "ON pk.pisacID = p.pisacID JOIN knjige k ON pk.knjigaID = k.knjigaID;";
						
		Statement stmt = conn.createStatement(); 
		ResultSet result = stmt.executeQuery(sqlSelect);
		
		while(result.next()) {
			String ime = result.getString(1);
			String prezime = result.getString(2);
			String naziv = result.getString(3);
			
			
			StringBuilder builder = new StringBuilder();
			builder.append("\nPisac: ");
			builder.append(ime);
			builder.append(" "+ prezime);
			builder.append("\nKnjiga: ");
			builder.append(naziv);
			
			
			System.out.println(builder.toString());
		}
		
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
