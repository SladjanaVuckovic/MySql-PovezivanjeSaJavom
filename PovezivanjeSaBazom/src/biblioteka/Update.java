package biblioteka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/praksa";
		String username = "root";
		String password = "";
		
		System.out.println("Konekcija..");
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			System.out.println("Uspesna konekcija ka bazi");
			String sqlupdate = "UPDATE bibliotekari SET ime = ?, prezime = ?, sifra = ? , ulica= ?, broj=?, mesto =?, bibliotekaID=? WHERE bibliotekarID =?";
			
			PreparedStatement ps = conn.prepareStatement(sqlupdate);
			
			ps.setString(1, "Masa");
			ps.setString(2, "Masic");
			ps.setString(3, "z781");
			ps.setString(4, "Ustanicka");
			ps.setString(5, "280");
			ps.setString(6, "Beograd");
			ps.setInt(7, 2);
			
			ps.setInt(8, 1); //uslov
			
			int promenjenPodatak = ps.executeUpdate();
			if(promenjenPodatak>0)
				System.out.println("Uspesno je izvrsena izmena.");
			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}

