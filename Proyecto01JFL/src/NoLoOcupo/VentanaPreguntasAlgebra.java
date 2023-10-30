package Interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import DatosUsuario.LecturaDatos;
import DatosUsuario.Usuario;
import bancoPreguntas.Algebra;

public class VentanaPreguntasAlgebra extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelPreguntas;
	private JTextField textoPreguntas;

	/**
	 * Launch the application.
	 */
	Timer timer;
	
	int second,minutes,hours;
	
	public static void main(String[] args, Usuario uActual) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPreguntasAlgebra frame = new VentanaPreguntasAlgebra(uActual);
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
	
	
	public void datos() {
	}
	
	public boolean casoCero(JRadioButton[] respuestas) {
		int invisibles = 0; int hayCero=0;
		for(JRadioButton todo:respuestas) {
			if(!(todo.isVisible())){
				invisibles++;
			}
			if((todo.getText().equals(0+""))&& todo.isVisible()) {
				hayCero++;
			}
		}
		
		if((hayCero == 2 && invisibles ==2) || invisibles>2) {
			return true;
		}
		return false;
	}
	

	public VentanaPreguntasAlgebra(Usuario uActual) {
		String nombreCurso = "Algebra";
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 450, 300);
		panelPreguntas = new JPanel();
		panelPreguntas.setBorder(new EmptyBorder(0, 100,100, 100));
		panelPreguntas.setLayout(null);
		setContentPane(panelPreguntas);
		
		//Usuario prueba = new Usuario("Cindy","1234");
		
		textoPreguntas = new JTextField();
		textoPreguntas.setBounds(95, 53, 199, 48);
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
		JRadioButton[] respuestasArrayButton = new JRadioButton[4];
		respuestasArrayButton[0] = new JRadioButton("R1");
		respuestasArrayButton[1] = new JRadioButton("R2");
		respuestasArrayButton[2] = new JRadioButton("R3");
		respuestasArrayButton[3] = new JRadioButton("R4");
		
		for(int i=0;i<respuestasArrayButton.length;i++) {
			respuestasArrayButton[i].setText(respuestas.get(i)+"");
		}
		
		respuestasArrayButton[0].setBounds(59, 107, 103, 21);
		respuestasArrayButton[1].setBounds(192, 107, 103, 21);
		respuestasArrayButton[2].setBounds(59, 144, 103, 21);
		respuestasArrayButton[3].setBounds(192, 144, 103, 21);

		for(int i=0;i<respuestasArrayButton.length;i++) {
			panelPreguntas.add(respuestasArrayButton[i]);
		}
		
		respuestasArrayButton[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = 0;
				for(int i=0;i<respuestasArrayButton.length;i++) {
					if(n!=i) {
						respuestasArrayButton[i].setSelected(false);
					}
				}
				uActual.setOpcion(n);
			}
		});
		
		respuestasArrayButton[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = 1;
				for(int i=0;i<respuestasArrayButton.length;i++) {
					if(n!=i) {
						respuestasArrayButton[i].setSelected(false);
					}
				}
				uActual.setOpcion(n);
			}
		});
		
		respuestasArrayButton[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = 2;
				for(int i=0;i<respuestasArrayButton.length;i++) {
					if(n!=i) {
						respuestasArrayButton[i].setSelected(false);
					}
				}
				uActual.setOpcion(n);
			}
		});
		
		respuestasArrayButton[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = 3;
				for(int i=0;i<respuestasArrayButton.length;i++) {
					if(n!=i) {
						respuestasArrayButton[i].setSelected(false);
					}
				}
				uActual.setOpcion(n);
			}
		});
		
		
		
		JLabel nivelLabel = new JLabel("Nivel dificultad:"+ uActual.getDificultadCurso(nombreCurso));
		nivelLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		nivelLabel.setBounds(10, 181, 206, 23);
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
				for(int i=0;i<respuestasArrayButton.length;i++) {
					respuestasArrayButton[i].setText(respuestas.get(i)+"");
					respuestasArrayButton[i].setVisible(true);
				}
				uActual.resetFL();
	
			}
		});
		facilBoton.setBounds(20, 214, 82, 33);
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
				for(int i=0;i<respuestasArrayButton.length;i++) {
					respuestasArrayButton[i].setText(respuestas.get(i)+"");
					respuestasArrayButton[i].setVisible(true);
				}
				uActual.resetFL();
		
			}
		});
		normalBoton.setBounds(124, 214, 82, 33);
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
				
				for(int i=0;i<respuestasArrayButton.length;i++) {
					respuestasArrayButton[i].setText(respuestas.get(i)+"");
					respuestasArrayButton[i].setVisible(true);
				}
				uActual.resetFL();
				
			}
		});
		dificilBoton.setBounds(236, 214, 82, 33);
		panelPreguntas.add(dificilBoton);
		
		JLabel respuestaLabel= new JLabel("Respuesta:");
		respuestaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		respuestaLabel.setBounds(138, 10, 241, 29);
		panelPreguntas.add(respuestaLabel);
		
		
		JButton botonRespuesta = new JButton("Aceptar");
		
		botonRespuesta.setBounds(301, 107, 85, 21);
		panelPreguntas.add(botonRespuesta);
		
		JLabel rangoNivelesLabel = new JLabel("(0-10)");
		rangoNivelesLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rangoNivelesLabel.setBounds(226, 181, 65, 23);
		panelPreguntas.add(rangoNivelesLabel);
		
		JButton botonAyuda = new JButton("Ayuda");
		botonAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uActual.sumarAyuda();
				if(uActual.getHelp()<4) {
					do {
						try {
							if(casoCero(respuestasArrayButton)) {
								break;
							}else {
								int numero = (int) (Math.random()*(4-0)+0);
								if(!(respuestasArrayButton[numero].getText().equals(algebra.getResultado()+""))&&respuestasArrayButton[numero].isVisible() ) {
									respuestasArrayButton[numero].setVisible(false);
									break;
								}
							}
							
						}catch(ArrayIndexOutOfBoundsException ex) {
							
						}catch(StackOverflowError ex) {
							break;
						}
						
					}while(true);
					
				}else {
					
					//JOptionPane.showMessageDialog(panelPreguntas, "No se pueden pedir mas ayudas");
				}
				
				if(uActual.getHelp()>=3) {
					botonAyuda.setVisible(false);
				}
			}
		});
		botonAyuda.setBounds(301, 144, 85, 21);
		panelPreguntas.add(botonAyuda);
		
		JLabel tiempoLabel = new JLabel("0:0");
		tiempoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tiempoLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		tiempoLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tiempoLabel.setBounds(304, 69, 75, 23);
		panelPreguntas.add(tiempoLabel);
		
		respuesta1.setVisible(false);
		respuesta2.setVisible(false);
		respuesta3.setVisible(false);
		respuesta4.setVisible(false);
		
		Timer(tiempoLabel);
		
		JButton botonSiguiente = new JButton("Siguiente -->");
		botonSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LecturaDatos l = new LecturaDatos();
				
				l.actualizarLista(uActual); 
				nivelLabel.setText("Nivel:"+uActual.getDificultadCurso(nombreCurso));
				actualizar(respuestasArrayButton, textoPreguntas, uActual, algebra);
				respuestaLabel.setText("Respuesta:");
				botonRespuesta.setVisible(true);
				botonAyuda.setVisible(true);
				botonSiguiente.setVisible(false);
				tiempoLabel.setText("0:0");
				timer.start();
			}
		});
		botonSiguiente.setBounds(301, 188, 103, 21);
		panelPreguntas.add(botonSiguiente);
		timer.start();
		
		botonRespuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(respuestas.get(uActual.getOpcion()) == algebra.getResultado() ) {
					respuestaLabel.setText("Respuesta: \nCorrecta");
					botonSiguiente.setVisible(true);
					int tiempo=0, ayuda=0,errores=0;
					tiempo = hours*60 + minutes*60+second;
					ayuda = uActual.getHelp();
					timer.stop();
					uActual.setValoresDificultad(tiempo, ayuda, errores);
					uActual.setDificultadMateria(uActual.proceso(), "Algebra");
					botonRespuesta.setVisible(false);
					botonAyuda.setVisible(false);
					timer.stop();
					for(int i = 0;i<respuestasArrayButton.length;i++) {
						if(!(respuestasArrayButton[i].getText().equals(algebra.getResultado()+""))) {
							respuestasArrayButton[i].setVisible(false);
						}
					}
						
				}else {
					
					respuestaLabel.setText("Respuesta: \nIncorrecta");
					uActual.sumarErrores();
				}
			}
		});
		
		botonSiguiente.setVisible(false);
		
		facilBoton.setVisible(false);
		normalBoton.setVisible(false);
		dificilBoton.setVisible(false);
		
	}
	/*
	public void simpleTimer(JLabel tiempoLabel) {
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				second++;
				
				tiempoLabel.setText(""+second);
			}
		}); 
			
	}
	*/
	public void actualizar(JRadioButton[] respuestasArrayButton, JTextField pregunta, Usuario uActual, Algebra algebra) {
		int difUsuario = Integer.parseInt(uActual.getDificultadMateria("Algebra"));
		String preguntaActualizar;
		if(difUsuario <6) {
			preguntaActualizar = algebra.preguntaFacil();
		}else if(difUsuario<8) {
			preguntaActualizar = algebra.preguntaNormal();
		}else {
			preguntaActualizar = algebra.preguntaDificil();
		}
		
		pregunta.setText(preguntaActualizar);
		
		ArrayList<Integer> respuestas = algebra.obtenerRespuestas();
		
		for(int i=0;i<respuestasArrayButton.length;i++) {
			respuestasArrayButton[i].setText(respuestas.get(i)+"");
			respuestasArrayButton[i].setVisible(true);
			respuestasArrayButton[i].setSelected(false);
		}
		uActual.setOpcion(0);
		second = 0;
		minutes=0;
		hours=0;
		uActual.resetFL();
		
	}
	
	public void Timer(JLabel tiempoLabel) {
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				second++;
				
				tiempoLabel.setText(minutes+":"+second);
				
				if(second==60) {
					second = 0;
					minutes++;
					tiempoLabel.setText(minutes+":"+second);
				}
				
				if(minutes == 60) {
					minutes = 0;
					hours++;
					tiempoLabel.setText(hours+":"+minutes+":"+second);
				}
			}
		}); 
			
	}
	
	
}
