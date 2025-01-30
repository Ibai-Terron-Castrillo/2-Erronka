package erronka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class logina {
	private JFrame frame;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Login window = new Login();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public logina() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 597, 365);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(50, 50, 80, 25);
		frame.getContentPane().add(lblUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(140, 50, 150, 25);
		frame.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblContrasena = new JLabel("Contraseña:");
		lblContrasena.setBounds(50, 90, 80, 25);
		frame.getContentPane().add(lblContrasena);

		txtContrasena = new JPasswordField();
		txtContrasena.setBounds(140, 90, 150, 25);
		frame.getContentPane().add(txtContrasena);

		JButton btnLogin = new JButton("Iniciar sesión");
		btnLogin.setBounds(100, 140, 150, 30);
		frame.getContentPane().add(btnLogin);

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verificarCredenciales(txtUsuario.getText(), new String(txtContrasena.getPassword()));
			}
		});
	}

	private void verificarCredenciales(String usuario, String contrasena) {
		Connection conn = sql.getConnection();
		if (conn == null) {
			JOptionPane.showMessageDialog(frame, "Error de conexión a la base de datos", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		String query = "SELECT tipo FROM langilea WHERE erabiltzailea = ? AND pasahitza = ?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, usuario);
			stmt.setString(2, contrasena);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				String tipo = rs.getString("tipo");
				JOptionPane.showMessageDialog(frame, "Inicio de sesión exitoso como " + tipo);
				abrirInterfazSegunTipo(tipo);
			} else {
				JOptionPane.showMessageDialog(frame, "Usuario o contraseña incorrectos", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(frame, "Error en la consulta SQL", "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			sql.closeConnection(conn);
		}
	}

	private void abrirInterfazSegunTipo(String tipo) {
		if (tipo.equals("admin")) {
			JOptionPane.showMessageDialog(frame, "Acceso al panel de administrador");
			// Aquí puedes abrir una nueva ventana para admins
		} else {
			JOptionPane.showMessageDialog(frame, "Acceso a la vista de empleados");
			// Aquí puedes abrir una ventana para empleados normales
		}
	}
}
