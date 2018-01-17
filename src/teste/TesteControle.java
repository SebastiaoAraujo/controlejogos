package teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import conexao.ConectaBanco;
import dao.UsuarioDao;
import modelo.Usuario;

public class TesteControle {

	public static void main(String[] args) throws SQLException {

		Connection conexao = new ConectaBanco().getConnect();
		UsuarioDao dao = new UsuarioDao();
		Usuario funcionario = new Usuario();
		List<Usuario> listausuario = dao.getLista();

		// funcionario.setNomeCompleto("Ediaine dos Santos Rocha");
		// funcionario.setEmail("ediaine.araujo@gmail.com");
		// funcionario.setTelefone("(62)99222-7340");
		// funcionario.setLogin("ediaine");
		// funcionario.setSenha("123");
		// funcionario.setObservacao("Administrador");
		// dao.AdicionarUsuario(funcionario);
		// System.out.println("Dados Gravados com Sucesso!!!!");

		// if (conexao!= null) {
		// System.out.println("Sucesso!!!");
		// } else
		// System.out.println("FAILL!!!!");
		// conexao.close();
		
		for(Usuario usuario:listausuario) {
			System.out.println("ID: "+ usuario.getIdUsuario());
			System.out.println("Nome Completo: "+ usuario.getNomeCompleto());
			System.out.println("Email: "+ usuario.getEmail());
			System.out.println("Telefone: "+ usuario.getTelefone());
			System.out.println("Login: "+ usuario.getLogin());
			System.out.println("Observação: "+ usuario.getObservacao());
			System.out.println("**********************");
		}

	}

}
