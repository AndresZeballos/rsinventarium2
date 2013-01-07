package coneccionConMySQL;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

public class Login {

	JButton boton;
	JFrame frame;

	String usuario;
	String password;

	public String getUsuario() {
		return this.usuario;
	}

	public String getPassword() {
		return this.password;
	}

	public Login() {

		boton = new JButton("Aceptar");
		boton.setBounds(230, 40, 100, 25);
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				a(arg0);
			}
		});

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(null);
		frame.add(boton);

		JLabel usu = new JLabel();
		usu.setBackground(new Color(255, 255, 255));
		usu.setBounds(20, 10, 70, 25);
		usu.setText("Usuario: ");

		JLabel pas = new JLabel();
		pas.setBackground(new Color(255, 255, 255));
		pas.setBounds(20, 40, 70, 25);
		pas.setText("Password:");

		JTextField u = new JTextField();
		u.setBounds(100, 10, 110, 25);

		JTextField p = new JTextField();
		p.setBounds(100, 40, 110, 25);

		frame.add(usu);
		frame.add(pas);

		frame.add(u);
		frame.add(p);

		frame.setSize(400, 120);
		frame.setVisible(true);

		frame.setTitle("Login");

		while (frame.isVisible()) {
		}

		if (u.getText() != "" && p.getText() != "") {
			this.usuario = u.getText();
			this.password = p.getText();
		}
		frame.dispose();
	}

	private void a(ActionEvent arg0) {
		this.frame.setVisible(false);
	}

}
