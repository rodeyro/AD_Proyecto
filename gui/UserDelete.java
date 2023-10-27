package Proyecto_AD_UD1.gui;

import Proyecto_AD_UD1.model.App;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserDelete extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel etiquetaBorrarUsuario;
	private JButton btnBorrar;
	private JButton btnCancelar;
	private App app;
	private String nombreUsuario;

	public UserDelete(App app, String nombreUsuario) {
		this.app = app;
		this.nombreUsuario = nombreUsuario;
		setTitle("Aplicación usuarios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 316, 147);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);

		etiquetaBorrarUsuario = new JLabel("¿Está seguro de que quiere borrar su usuario?");
		etiquetaBorrarUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		etiquetaBorrarUsuario.setBounds(10, 11, 296, 34);
		contentPane.add(etiquetaBorrarUsuario);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(170, 56, 89, 23);
		btnBorrar.addActionListener(this);
		btnBorrar.setBackground(Color.decode("#e74c3c"));
		btnBorrar.setForeground(Color.decode("#ecf0f1"));
		contentPane.add(btnBorrar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(35, 56, 89, 23);
		btnCancelar.addActionListener(this);
		contentPane.add(btnCancelar);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*if (e.getSource() == btnBorrar) {
			app.deleteUser(app.getUsers().getUser(nombreUsuario).getName(), app.getUsers().getUser(nombreUsuario).getPasswordHash(), app.getUsers().getUser(nombreUsuario).getAge(), app.getUsers().getUser(nombreUsuario).getEmail());
		}*/

		if (e.getSource() == btnCancelar) {
			new User(app, app.getUsers().getUser(nombreUsuario).getName());
			dispose();
		}

	}

}
