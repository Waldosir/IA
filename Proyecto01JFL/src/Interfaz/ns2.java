package Interfaz;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bancoPreguntas.Algebra;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeListener;

import DatosUsuario.Usuario;

import javax.swing.event.ChangeEvent;

public class ns2 extends JFrame {
/*
	private static final long serialVersionUID = 1L;
	private JPanel panelPreguntas;
	private JTextField textoPreguntas;


	public static void main(String[] args, Usuario uActual) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaPreguntas frame = new ventanaPreguntas(uActual);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public void datos() {
	}
	
	public ventanaPreguntas(Usuario uActual) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 450, 300);
		panelPreguntas = new JPanel();
		panelPreguntas.setBorder(new EmptyBorder(0, 100,100, 100));
		panelPreguntas.setLayout(null);
		setContentPane(panelPreguntas);
		
		//Usuario prueba = new Usuario("Cindy","1234");
		
		textoPreguntas = new JTextField();
		textoPreguntas.setBounds(96, 43, 199, 48);
		textoPreguntas.setText("Hola que tal");
		textoPreguntas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textoPreguntas.setEditable(false);
		panelPreguntas.add(textoPreguntas);
		textoPreguntas.setColumns(10);
		
		
		Algebra algebra = new Algebra(uActual);
		int respuestaFinal;
		textoPreguntas.setEditable(false);
		textoPreguntas.setText(algebra.preguntaFacil());
		ArrayList<Integer> respuestas = algebra.obtenerRespuestas();
		respuestaFinal = algebra.getResultado();
		
		
		
		JLabel nivelLabel = new JLabel("Nivel 1");
		nivelLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		nivelLabel.setBounds(10, 240, 118, 23);
		panelPreguntas.add(nivelLabel);
		
		JLabel materiaLabel = new JLabel("Algebra lineal");
		materiaLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		materiaLabel.setBounds(10, 10, 118, 23);
		panelPreguntas.add(materiaLabel);
		
		JRadioButton respuesta1 = new JRadioButton("Respuesta1");
		JRadioButton respuesta2 = new JRadioButton("Respuesta2");
		JRadioButton respuesta3 = new JRadioButton("Respuesta3");
		JRadioButton respuesta4 = new JRadioButton("Respuesta4");
		
		respuesta1.setText(respuestas.get(0)+"");
		respuesta2.setText(respuestas.get(1)+"");
		respuesta3.setText(respuestas.get(2)+"");
		respuesta4.setText(respuestas.get(3)+"");
		
		respuesta1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				respuesta2.setSelected(false);
				respuesta3.setSelected(false);
				respuesta4.setSelected(false);
				boolean opcionEscogida = true;
				uActual.setOpcion(0);
			}
		});
		
		respuesta2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				respuesta1.setSelected(false);
				respuesta3.setSelected(false);
				respuesta4.setSelected(false);
				uActual.setOpcion(1);
			}
		});
		
		respuesta3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				respuesta2.setSelected(false);
				respuesta1.setSelected(false);
				respuesta4.setSelected(false);
				uActual.setOpcion(2);
			}
		});
		
		respuesta4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				respuesta2.setSelected(false);
				respuesta3.setSelected(false);
				respuesta1.setSelected(false);
				uActual.setOpcion(3);
			}
		});
		
		
		
		
		respuesta1.setBounds(59, 107, 103, 21);
		panelPreguntas.add(respuesta1);
		
		
		respuesta2.setBounds(192, 107, 103, 21);
		panelPreguntas.add(respuesta2);
		
		
		respuesta3.setBounds(59, 144, 103, 21);
		panelPreguntas.add(respuesta3);
		
		
		respuesta4.setBounds(192, 144, 103, 21);
		panelPreguntas.add(respuesta4);
		
		
		
	
		
		JButton facilBoton = new JButton("Facil");
		facilBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				textoPreguntas.setEditable(false);
				textoPreguntas.setText(algebra.preguntaFacil());
				ArrayList<Integer> respuestas = algebra.obtenerRespuestas();
				respuesta1.setText(respuestas.get(0)+"");
				respuesta2.setText(respuestas.get(1)+"");
				respuesta3.setText(respuestas.get(2)+"");
				respuesta4.setText(respuestas.get(3)+"");
	
			}
		});
		facilBoton.setBounds(113, 220, 82, 33);
		panelPreguntas.add(facilBoton);
		
		JButton normalBoton = new JButton("Normal");
		normalBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Integer> respuestas = algebra.obtenerRespuestas();
				textoPreguntas.setEditable(false);
				textoPreguntas.setText(algebra.preguntaNormal());
				respuesta1.setText(respuestas.get(0)+"");
				respuesta2.setText(respuestas.get(1)+"");
				respuesta3.setText(respuestas.get(2)+"");
				respuesta4.setText(respuestas.get(3)+"");
		
			}
		});
		normalBoton.setBounds(213, 220, 82, 33);
		panelPreguntas.add(normalBoton);
		
		
		JButton dificilBoton = new JButton("Dificil");
		dificilBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textoPreguntas.setEditable(false);
				textoPreguntas.setText(algebra.preguntaDificil());
				ArrayList<Integer> respuestas = algebra.obtenerRespuestas();
				respuesta1.setText(respuestas.get(0)+"");
				respuesta2.setText(respuestas.get(1)+"");
				respuesta3.setText(respuestas.get(2)+"");
				respuesta4.setText(respuestas.get(3)+"");
				
			}
		});
		dificilBoton.setBounds(330, 220, 82, 33);
		panelPreguntas.add(dificilBoton);
		
		JLabel respuestaLabel= new JLabel("Respuesta:");
		respuestaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		respuestaLabel.setBounds(138, 10, 241, 29);
		panelPreguntas.add(respuestaLabel);
		
		
		JButton botonRespuesta = new JButton("Aceptar");
		botonRespuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(respuestas.get(uActual.getOpcion()) == algebra.getResultado() ) {
					respuestaLabel.setText("Respuesta: \nCorrecta");
					uActual.sumarNivel();
					nivelLabel.setText("Nivel:"+uActual.getNivel());
				}else {
					
					respuestaLabel.setText("Respuesta: \nIncorrecta");
				}
			}
		});
		botonRespuesta.setBounds(327, 171, 85, 21);
		panelPreguntas.add(botonRespuesta);
		
		
		
		
	
		
		
		
		

		
	}
	*/
}
