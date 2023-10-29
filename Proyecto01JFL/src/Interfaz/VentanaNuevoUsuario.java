package Interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DatosUsuario.LecturaDatos;
import DatosUsuario.Usuario;

public class VentanaNuevoUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textContrasena;
	private JTextField textUsuario;
	private JTextField textConfirmarContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaNuevoUsuario frame = new VentanaNuevoUsuario();
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
	public  VentanaNuevoUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 100,100, 100));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton botonCrearNuevoUsuario = new JButton("Crear");
		botonCrearNuevoUsuario.setBackground(new Color(51, 255, 0));
		
		botonCrearNuevoUsuario.setBounds(193, 193, 92, 36);
		contentPane.add(botonCrearNuevoUsuario);
		
		JLabel labelUsuario = new JLabel("Usuario:");
		labelUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelUsuario.setBounds(40, 54, 86, 25);
		contentPane.add(labelUsuario);
		
		textContrasena = new JTextField();
		contentPane.add(textContrasena);
		textContrasena.setBounds(137, 102, 148, 25);
		textContrasena.setColumns(10);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(137, 54, 148, 25);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel labelContrasena = new JLabel("Contraseña:");
		labelContrasena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelContrasena.setBounds(40, 102, 86, 25);
		contentPane.add(labelContrasena);
		
		JLabel labelTitulo = new JLabel("Crear nuevo usuario");
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		labelTitulo.setBounds(69, 10, 288, 34);
		contentPane.add(labelTitulo);
		
		JButton btnBorrar = new JButton("Regresar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaIngreso vI = new VentanaIngreso();
				vI.main(null);
			}
		});
		btnBorrar.setBackground(new Color(255, 0, 51));
		btnBorrar.setBounds(82, 193, 92, 36);
		contentPane.add(btnBorrar);
		
		JLabel lblConfirmarContrasena = new JLabel("<html>Confirmar<br />Contraseña:</html>");
		lblConfirmarContrasena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirmarContrasena.setBounds(40, 137, 86, 40);
		contentPane.add(lblConfirmarContrasena);
		
		textConfirmarContrasena = new JTextField();
		textConfirmarContrasena.setColumns(10);
		textConfirmarContrasena.setBounds(137, 152, 148, 25);
		contentPane.add(textConfirmarContrasena);
		
		
		botonCrearNuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LecturaDatos l = new LecturaDatos();
				if(textContrasena.getText().equals(textConfirmarContrasena.getText())) {
					System.out.println("Si accede");
					if(l.validarCantidad(textUsuario.getText(), textContrasena.getText())) {
						if(l.nombreDistinto(textUsuario.getText())) {
							Usuario u = new Usuario(textUsuario.getText(), textContrasena.getText());
							l.actualizarLista(u);
							JOptionPane.showMessageDialog(contentPane, "Usuario registrado");
							dispose();
							VentanaIngreso vI = new VentanaIngreso();
							vI.main(null);
						}else {
							JOptionPane.showMessageDialog(contentPane, "Error. Usuario ya existente");
						}
						
					}else {
						JOptionPane.showMessageDialog(contentPane, "Error. Usuario y/o contrasena \ncortos y/o largos");
					}
				}else {
					JOptionPane.showMessageDialog(contentPane, "Error. Contrasena no iguales");
				}
			}
		});
		/*
		botonCrearNuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre, contrasena;
				LecturaDatos ld = new LecturaDatos();
				nombre = textUsuario.getText();
				contrasena = textContrasena.getText();
				if(!(nombre.equals("") || contrasena.equals(""))){
				try {
					Usuario uActual = ld.buscarUsuario(nombre);
					if(uActual.getContrasena().equals(contrasena)) {
						JOptionPane.showMessageDialog(contentPane, "Le diste al bueno");
						dispose();
						VentanaMenuClases vMC = new VentanaMenuClases(uActual);
						vMC.main(null, uActual);
					}else {
						JOptionPane.showMessageDialog(contentPane, "Usuario y/o contraseña no validos");
						System.out.println("Buuuh");
					}
				} catch(NullPointerException ex) {
					JOptionPane.showMessageDialog(contentPane, "Usuario y/o contraseña no validos");
				}
				
				}
				
			}
		});
		*/
	}
}
