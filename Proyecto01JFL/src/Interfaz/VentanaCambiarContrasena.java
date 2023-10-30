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
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DatosUsuario.Usuario;
import bancoDatos.LecturaUsuarios;


public class VentanaCambiarContrasena extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField contrasenaVieja;
	private JPasswordField contrasenaNueva;
	private JPasswordField contrasenaConfirmar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Usuario uActual) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCambiarContrasena frame = new VentanaCambiarContrasena(uActual);
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
	public VentanaCambiarContrasena(Usuario uActual) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel contraViejalbl = new JLabel("<html>Vieja<br />Contraseña:</html>");
		contraViejalbl.setHorizontalAlignment(SwingConstants.CENTER);
		contraViejalbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contraViejalbl.setBounds(21, 51, 108, 43);
		contentPane.add(contraViejalbl);
		
		JLabel lblNewLabel = new JLabel("<html>Nueva<br />Contraseña:</html>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(21, 121, 108, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<html>Confirmar<br />Contraseña:</html>");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(21, 188, 108, 33);
		contentPane.add(lblNewLabel_1);
		
		contrasenaVieja = new JPasswordField();
		contrasenaVieja.setBounds(153, 75, 108, 19);
		contentPane.add(contrasenaVieja);
		
		contrasenaNueva = new JPasswordField();
		contrasenaNueva.setBounds(153, 142, 108, 19);
		contentPane.add(contrasenaNueva);
		
		contrasenaConfirmar = new JPasswordField();
		contrasenaConfirmar.setBounds(153, 202, 108, 19);
		contentPane.add(contrasenaConfirmar);
		
		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(contrasenaVieja.getText().equals(uActual.getContrasena())) {
					if(contrasenaNueva.getText().equals(contrasenaConfirmar.getText())) {
						uActual.setContrasena(contrasenaNueva.getText());
						LecturaUsuarios l = new LecturaUsuarios();
						l.actualizarLista(uActual);
						JOptionPane.showMessageDialog(contentPane, "Cambio de contraseñas actualizado");
						dispose();
						VentanaMenuClases vMC = new VentanaMenuClases(uActual);
						vMC.main(null, uActual);
						
					}else {
						JOptionPane.showMessageDialog(contentPane, "Error. Contrasena nueva no son iguales");
					}
				}else {
					JOptionPane.showMessageDialog(contentPane, "Error. Contrasena vieja no valida");
				}
			}
		});
		botonAceptar.setBounds(292, 200, 85, 21);
		contentPane.add(botonAceptar);
		
		JButton botonSalir = new JButton("Salir");
		botonSalir.setForeground(Color.WHITE);
		botonSalir.setBackground(Color.RED);
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaMenuClases vMC = new VentanaMenuClases(uActual);
				vMC.main(null, uActual);
			}
		});
		botonSalir.setBounds(292, 121, 85, 21);
		contentPane.add(botonSalir);
		
		JLabel lblNewLabel_2 = new JLabel("Menu Cambiar Contraseña");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(84, 10, 252, 31);
		contentPane.add(lblNewLabel_2);
		
	}
	
}
