package Interfaz;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DatosUsuario.LecturaDatos;
import DatosUsuario.LecturaPregunta;
import DatosUsuario.Usuario;
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
		
		JButton botonAlgebra = new JButton("Algebra");
		botonAlgebra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LecturaDatos l = new LecturaDatos();
				if(!(l.tieneCurso(uActual, botonAlgebra.getText()))) {
					l.anadirCursoUsuario(uActual, botonAlgebra.getText());
				}
				dispose();
				VentanaPreguntasAlgebra vPA = new VentanaPreguntasAlgebra(uActual);
				vPA.main(null, uActual);
			}
		});
		botonAlgebra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botonAlgebra.setBounds(52, 85, 104, 35);
		contentPane.add(botonAlgebra);
		
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
		
		btnGraficas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreCurso = btnGraficas.getText();
				LecturaPregunta pregunta = new LecturaPregunta(Dificultad.facil, uActual, nombreCurso);
				dispose();
				VentanaCurso vC = new VentanaCurso(btnGraficas.getText(),pregunta,uActual);
				vC.main(null,  nombreCurso,pregunta,uActual);
				//Null, nombrecurso, clasepreguntas, usuario Actual
				
				
				
			}
		});
	}

}
