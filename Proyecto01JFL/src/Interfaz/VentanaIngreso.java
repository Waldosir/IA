package Interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DatosUsuario.Usuario;
import bancoDatos.LecturaUsuarios;

public class VentanaIngreso extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField contrasenaPsw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaIngreso frame = new VentanaIngreso();
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
	public VentanaIngreso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 100,100, 100));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton botonIngresar = new JButton("Ingresar");
		
		botonIngresar.setBounds(163, 151, 92, 36);
		contentPane.add(botonIngresar);
		
		JLabel labelUsuario = new JLabel("Usuario:");
		labelUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelUsuario.setBounds(40, 54, 86, 25);
		contentPane.add(labelUsuario);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(137, 54, 148, 25);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel labelContrasena = new JLabel("Contraseña:");
		labelContrasena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelContrasena.setBounds(40, 102, 86, 25);
		contentPane.add(labelContrasena);
		
		JLabel labelTitulo = new JLabel("Bienvenido al programa.");
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		labelTitulo.setBounds(40, 10, 288, 34);
		contentPane.add(labelTitulo);
		
		JButton botonNuevoUsuario = new JButton("<html>¿Nuevo<br />Usuario?</html>");
		botonNuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaNuevoUsuario vNU = new VentanaNuevoUsuario();
				vNU.main(null);
			}
		});
		botonNuevoUsuario.setBounds(322, 75, 92, 52);
		contentPane.add(botonNuevoUsuario);
		
		JButton botonSalir = new JButton("Salir");
		botonSalir.setForeground(new Color(255, 255, 255));
		botonSalir.setBackground(new Color(255, 0, 0));
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		botonSalir.setBounds(318, 23, 85, 21);
		contentPane.add(botonSalir);
		
		contrasenaPsw = new JPasswordField();
		contrasenaPsw.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					validarUsuarioNuevo(textUsuario, contrasenaPsw);
				}
			}
		});
		contrasenaPsw.setBounds(137, 105, 148, 22);
		contentPane.add(contrasenaPsw);
		
		botonIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarUsuarioNuevo(textUsuario, contrasenaPsw);
			}
		});
		
	}
	
	private void validarUsuarioNuevo(JTextField textUsuario, JPasswordField contrasenaPsw ) {
		String nombre, contrasena;
		nombre = textUsuario.getText();
		contrasena = contrasenaPsw.getText();
		LecturaUsuarios l = new LecturaUsuarios();
		if(l.conectar(nombre, contrasena)){
		try {
			dispose();
			Usuario uActual = l.busquedaUsuario(nombre);
			VentanaMenuClases vMC= new VentanaMenuClases(uActual);
			vMC.main(null, uActual);
		
		} catch(NullPointerException ex) {
			JOptionPane.showMessageDialog(contentPane, "Usuario y/o contraseña no validos");
		}
		
		}else {
			JOptionPane.showMessageDialog(contentPane, "Usuario y/o contraseña no validos");
		}
		
	}
}
