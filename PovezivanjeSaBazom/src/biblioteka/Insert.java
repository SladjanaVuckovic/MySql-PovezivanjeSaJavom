package biblioteka;

import java.sql.*;

public class Insert {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/praksa";
		String username = "root";
		String password = "";
		
		System.out.println("Konekcija..");
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			System.out.println("Uspesna konekcija ka bazi");
			
			String sqlinsert = "INSERT INTO clanovi(ime, prezime, datunRodj, telefon, clanskaKartaBr, ulica, broj, mesto)VALUES(? ,?, ?, ?, ?, ?,? ,?)";
			PreparedStatement ps = conn.prepareStatement(sqlinsert);
			ps.setString(1, "Nikola");
			ps.setString(2, "Pantic");
			ps.setString(3, "1999-11-11");
			ps.setString(4, "0698123355");
			ps.setInt(5, 555);
			ps.setString(6, "Sarajevska");
			ps.setString(7, "105");
			ps.setString(8, "Beograd");
			
			int unetPodatak = ps.executeUpdate();
			
			if(unetPodatak>0)
				System.out.println("Podatak je upisan! ");

	}catch (SQLException e) {
		e.printStackTrace();}

}
}
