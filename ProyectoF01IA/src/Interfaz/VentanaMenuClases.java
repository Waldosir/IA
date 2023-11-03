package Interfaz;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DatosUsuario.Usuario;
import bancoDatos.LecturaPregunta;
import bancoDatos.LecturaUsuarios;
import procesadoJFL.Dificultad;

public class VentanaMenuClases extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Usuario uActual) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenuClases frame = new VentanaMenuClases(uActual);
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
	public VentanaMenuClases(Usuario uActual) {
		setTitle("Menu principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);	
		
		setContentPane(contentPane);
		uActual.setOpcion(-1);
		
		JLabel lblNewLabel = new JLabel("Bienvenido Usuario "+uActual.getNombre());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(51, 45, 293, 35);
		contentPane.add(lblNewLabel);
		
		JButton btnGraficas = new JButton("Graficas");
		
		btnGraficas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGraficas.setBounds(163, 134, 115, 56);
		contentPane.add(btnGraficas);
		
		JButton botonVolver = new JButton("Volver(<---");
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaIngreso vI = new VentanaIngreso();
				vI.setVisible(true);
			}
		});
		botonVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botonVolver.setBounds(2, 10, 123, 25);
		contentPane.add(botonVolver);
		
		JButton btnCambiarContrasena = new JButton("Cambiar Contraseña");
		btnCambiarContrasena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaCambiarContrasena vCC = new VentanaCambiarContrasena(uActual);
				vCC.setVisible(true);
				
			}
		});
		btnCambiarContrasena.setBounds(212, 14, 166, 21);
		
		contentPane.add(btnCambiarContrasena);
		
		JButton btnAlgebra = new JButton("Algebra");
		btnAlgebra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreCurso = btnAlgebra.getText();
				LecturaPregunta pregunta = new LecturaPregunta(Dificultad.facil,nombreCurso);
				IngresarCurso(nombreCurso, pregunta, uActual);
			}
		});
		btnAlgebra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAlgebra.setBounds(38, 134, 115, 56);
		contentPane.add(btnAlgebra);
		
		JLabel lblNewLabel_1 = new JLabel("Cursos:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(101, 85, 166, 39);
		contentPane.add(lblNewLabel_1);
		
		btnGraficas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreCurso = btnGraficas.getText();
				LecturaPregunta pregunta = new LecturaPregunta(Dificultad.facil,nombreCurso);
				IngresarCurso(nombreCurso, pregunta, uActual);
			}
		});
	}
	
	private void IngresarCurso(String nombreCurso, LecturaPregunta pregunta, Usuario uActual) {
		LecturaUsuarios l = new LecturaUsuarios();
		if(!(l.tieneCurso(uActual, nombreCurso))) {
			JOptionPane.showMessageDialog(contentPane, "Bienvenido al curso "+nombreCurso);
		}
		
		if(pregunta.CursoTerminado(uActual)) {
			JOptionPane.showMessageDialog(contentPane, "El curso ya ha sido completado. Se activara el modo infinito de preguntas");
			dispose();
			VentanaCurso vC = new VentanaCurso(nombreCurso,pregunta,uActual, true);
			vC.setVisible(true);
		}else {
			dispose();
			VentanaCurso vC = new VentanaCurso(nombreCurso,pregunta,uActual, false);
			vC.setVisible(true);
		}
	}
	

}
