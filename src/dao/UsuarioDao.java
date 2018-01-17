package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexao.ConectaBanco;
import modelo.Usuario;

public class UsuarioDao {
	Connection conexao = new ConectaBanco().getConnect();
	public boolean acesso;

	
	public void AdicionarUsuario(Usuario usuario) throws SQLException {
		String sql = "insert into usuario" + "(nomecompleto, telefone, email, login, senha, observacao)"
				+ "values (?,?,?,?,?,?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, usuario.getNomeCompleto());
		stmt.setString(2, usuario.getTelefone());
		stmt.setString(3, usuario.getEmail());
		stmt.setString(4, usuario.getLogin());
		stmt.setString(5, usuario.getSenha());
		stmt.setString(6, usuario.getObservacao());
		stmt.execute();
		stmt.close();
	}
	
	
	public List<Usuario> getLista() throws SQLException{
		String sql = ("select * from usuario");
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		while(rs.next()) {
			Usuario usuario = new Usuario();
			usuario.setIdUsuario(rs.getInt("id_usuario"));
			usuario.setNomeCompleto(rs.getString("nomecompleto"));
			usuario.setEmail(rs.getString("email"));
			usuario.setTelefone(rs.getString("telefone"));
			usuario.setLogin(rs.getString("login"));
			usuario.setObservacao(rs.getString("observacao"));
			usuarios.add(usuario);
		}
		rs.close();
		stmt.close();
		return usuarios;
	}
	
	
	public void ValidaLogin(String login, String senha) throws SQLException {
		
		String sql = ("select login, senha from usuario where login='"+login+"'and senha='"+senha+"'");
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			JOptionPane.showMessageDialog(null, "Usuario e Senha Corretos!!!");
			acesso = true;
		}else {
			JOptionPane.showMessageDialog(null, "Usuario e Senha Incorretos!!!");
			acesso = false;
		}
		
	}

}
