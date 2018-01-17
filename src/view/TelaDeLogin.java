package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.UsuarioDao;

public class TelaDeLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldLogin;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeLogin frame = new TelaDeLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaDeLogin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(122, 162, 46, 14);
		contentPane.add(lblLogin);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(178, 155, 208, 29);
		contentPane.add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(122, 219, 46, 14);
		contentPane.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(178, 212, 208, 29);
		contentPane.add(passwordField);
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UsuarioDao dao = new UsuarioDao();
				try {
					dao.ValidaLogin(textFieldLogin.getText(), passwordField.getText());
					if(dao.acesso == true) {
						TelaInicial telainicial = new TelaInicial();
						telainicial.show();
						telainicial.setExtendedState(new TelaInicial().MAXIMIZED_BOTH);
						dispose();
					}
					if(dao.acesso == false) {
						textFieldLogin.setText("");
						passwordField.setText("");
						textFieldLogin.requestFocus();
					}
					dao.acesso = false;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnLogar.setBounds(122, 284, 89, 23);
		contentPane.add(btnLogar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSair.setBounds(297, 284, 89, 23);
		contentPane.add(btnSair);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaDeLogin.class.getResource("/imagens/xbox-1.jpg")));
		lblNewLabel.setBounds(234, 49, 80, 69);
		contentPane.add(lblNewLabel);
	}

}
