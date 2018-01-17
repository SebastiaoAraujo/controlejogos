package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class ConectaBanco {
	

	public Connection getConnect() {
		String url = "jdbc:postgresql://localhost:5432/controlejogos";
		String usuario = "postgres";
		String senha = "123456";
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, usuario, senha);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e, "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		return con;
	}
}
