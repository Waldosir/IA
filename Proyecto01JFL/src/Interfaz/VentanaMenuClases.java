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
import javax.swing.border.EmptyBorder;

import DatosUsuario.LecturaPregunta;
import DatosUsuario.Usuario;
import NoLoOcupo.VentanaPreguntasAlgebra;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);
		uActual.setOpcion(-1);
		
		JButton botonAlgebraV1 = new JButton("Algebra1.0");
		botonAlgebraV1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LecturaUsuarios l = new LecturaUsuarios();
				if(!(l.tieneCurso(uActual, botonAlgebraV1.getText()))) {
					l.anadirCursoUsuario(uActual, botonAlgebraV1.getText());
				}
				dispose();
				VentanaPreguntasAlgebra vPA = new VentanaPreguntasAlgebra(uActual);
				vPA.main(null, uActual);
			}
		});
		botonAlgebraV1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botonAlgebraV1.setBounds(222, 202, 104, 35);
		contentPane.add(botonAlgebraV1);
		
		JLabel lblNewLabel = new JLabel("Bienvenido "+uActual.getNombre());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(91, 40, 248, 35);
		contentPane.add(lblNewLabel);
		
		JButton btnGraficas = new JButton("Graficas");
		
		btnGraficas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGraficas.setBounds(192, 85, 104, 35);
		contentPane.add(btnGraficas);
		
		JButton botonVolver = new JButton("Volver(<---");
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaIngreso vI = new VentanaIngreso();
				vI.main(null);
			}
		});
		botonVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botonVolver.setBounds(2, 10, 123, 25);
		contentPane.add(botonVolver);
		
		JButton btnNewButton = new JButton("Cambiar Contraseña");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaCambiarContrasena vCC = new VentanaCambiarContrasena(uActual);
				vCC.main(null, uActual);
				
			}
		});
		btnNewButton.setBounds(212, 14, 127, 21);
		
		contentPane.add(btnNewButton);
		
		JButton botonAlgebra = new JButton("Algebra");
		botonAlgebra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreCurso = botonAlgebra.getText();
				LecturaPregunta pregunta = new LecturaPregunta(Dificultad.facil, uActual, nombreCurso);
				IngresarCurso(nombreCurso, pregunta);

				
				//Null, nombrecurso, clasepreguntas, usuario Actual
			}
		});
		botonAlgebra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botonAlgebra.setBounds(41, 85, 104, 35);
		contentPane.add(botonAlgebra);
		
		btnGraficas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreCurso = btnGraficas.getText();
				LecturaPregunta pregunta = new LecturaPregunta(Dificultad.facil, uActual, nombreCurso);
				IngresarCurso(nombreCurso, pregunta);
				
				
				
			}
		});
	}
	
	private void IngresarCurso(String nombreCurso, LecturaPregunta pregunta) {
		if(pregunta.CursoTerminado()) {
			JOptionPane.showMessageDialog(contentPane, "El curso ya ha sido completado. Se activara el modo infinito de preguntas");
			dispose();
			VentanaCurso vC = new VentanaCurso(nombreCurso,pregunta,pregunta.getUsuario(), true);
			vC.main(null,  nombreCurso,pregunta,pregunta.getUsuario(), true);	
		}else {
			dispose();
			VentanaCurso vC = new VentanaCurso(nombreCurso,pregunta,pregunta.getUsuario(), false);
			vC.main(null,  nombreCurso,pregunta,pregunta.getUsuario(), false);
		}
	}
}
