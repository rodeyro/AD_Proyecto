package Proyecto_AD_UD1.gui;

import Proyecto_AD_UD1.model.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;



public class User extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel etiquetaMenuUsuario;
	private JButton btnVerDatos;
	private JButton btnCambiarContraseña;
	private JButton btnBorrarUsuario;
	private JButton btnExportarUsuarios;
	private JButton btnCrearNuevoUsuario;
	private JButton btnCerrarSesion;
	private App app;
	private String nombreUsuario;

	public User(App app, String nombreUsuario) {
		this.app = app;
		this.nombreUsuario = nombreUsuario;
		int paddingLeft = 75;

		setTitle("Aplicación usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		etiquetaMenuUsuario = new JLabel(nombreUsuario, SwingConstants.CENTER);
		etiquetaMenuUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		etiquetaMenuUsuario.setBounds(0, 20, 300, 30);
		contentPane.add(etiquetaMenuUsuario);

		btnVerDatos = new JButton("Ver datos");
		btnVerDatos.setBounds(paddingLeft, 64, 150, 23);
		btnVerDatos.addActionListener(this);
		contentPane.add(btnVerDatos);

		btnCambiarContraseña = new JButton("Cambiar contraseña");
		btnCambiarContraseña.setBounds(paddingLeft, 98, 150, 23);
		btnCambiarContraseña.addActionListener(this);
		contentPane.add(btnCambiarContraseña);

		if(!nombreUsuario.equals("admin")) {
			btnBorrarUsuario = new JButton("Borrar usuario");
			btnBorrarUsuario.setBounds(paddingLeft, 132, 150, 23);
			btnBorrarUsuario.addActionListener(this);
			btnBorrarUsuario.setBackground(Color.decode("#e74c3c"));
			btnBorrarUsuario.setForeground(Color.decode("#ecf0f1"));
			contentPane.add(btnBorrarUsuario);
		}

		btnCerrarSesion = new JButton("Cerrar sesión");
		btnCerrarSesion.setBounds(paddingLeft, 200, 150, 23);
		btnCerrarSesion.addActionListener(this);
		contentPane.add(btnCerrarSesion);

		System.out.println(nombreUsuario);
		if(nombreUsuario.equals("admin")) {
			setBounds(0, 0, 300, 360);

			btnCrearNuevoUsuario = new JButton("Crear nuevo usuario");
			btnCrearNuevoUsuario.setBounds(paddingLeft, 180, 150, 23);
			btnCrearNuevoUsuario.addActionListener(this);
			contentPane.add(btnCrearNuevoUsuario);

			btnExportarUsuarios = new JButton("Exportar usuarios");
			btnExportarUsuarios.setBounds(paddingLeft, 210, 150, 23);
			btnExportarUsuarios.addActionListener(this);
			contentPane.add(btnExportarUsuarios);

			btnCerrarSesion.setBounds(paddingLeft, 270, 150, 23);
			btnCerrarSesion.addActionListener(this);
		}

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnExportarUsuarios) {
			System.out.println("Exportar usuario (Proyecto_AD_UD1.model.ZIP)");
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setSelectedFile(new File("usuarios.zip"));
			int returnValue = fileChooser.showOpenDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				System.out.println("Archivo seleccionado: " + selectedFile.getAbsolutePath());
			} else {
				System.out.println("Selección de archivo cancelada.");
			}
		}

		if(e.getSource()== btnCrearNuevoUsuario){
			new UserCreate(app);
			dispose();
		}

		if(e.getSource()== btnCerrarSesion){
			new Login(app);
			dispose();
		}

		if(e.getSource()== btnVerDatos){;
			new UserDetails(app , nombreUsuario , String.valueOf(app.getUsers().getUser(nombreUsuario).getAge()), app.getUsers().getUser(nombreUsuario).getEmail());
		}

		if(e.getSource()== btnCambiarContraseña){
			new UserChangePassword(app , nombreUsuario);
			dispose();
		}

		if(e.getSource()== btnBorrarUsuario){
			new UserDelete(app , nombreUsuario);
			dispose();
		}

		if(e.getSource()== btnExportarUsuarios){
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setSelectedFile(new File("usuarios.zip"));
			int returnValue = fileChooser.showOpenDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {

			} else {
				System.out.println("Selección de archivo cancelada.");
			}
			dispose();
		}


	}

}
