package biblioteka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {

	public static void main(String[] args) {
		
		
		String url = "jdbc:mysql://localhost:3306 /praksa";
		String username = "root";
		
		String password = "";
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			System.out.println("Uspesna konekcija ka bazi. ");
			
		String sqlSelect = "SELECT * FROM clanovi";
		Statement stmt = conn.createStatement(); 
		ResultSet result = stmt.executeQuery(sqlSelect);
		
		while(result.next()) {
			String ime = result.getNString(2);
			String prezime = result.getString(3);
			String datumr = result.getString(4);
			String tel = result.getString(5);
			String brojck = result.getString(6);
			String ul = result.getString(7);
			String br = result.getString(8);
			String mesto = result.getString(9);
			
			StringBuilder builder = new StringBuilder();
			builder.append("\nIme: ");
			builder.append(ime);
			builder.append("\nPozinka: ");
			builder.append(prezime);
			builder.append("\nDatum rodjenja: ");
			builder.append(datumr);
			builder.append("\nTelefon: ");
			builder.append(tel);
			builder.append("\nBroj clanske karte: ");
			builder.append(brojck);
			builder.append("\nUlica: ");
			builder.append(ul);
			builder.append("\nBroj: ");
			builder.append(br);
			builder.append("\nMesto: ");
			builder.append(mesto);
			
			System.out.println(builder.toString());
		}
		
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
