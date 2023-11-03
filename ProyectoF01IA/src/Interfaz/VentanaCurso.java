package Interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import DatosUsuario.Usuario;
import bancoDatos.LecturaPregunta;
import procesadoJFL.DificultadFuzzy;

public class VentanaCurso extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	final int NUMEROTERMINARCURSO = 10;
	
	Timer timer;
	
	int second,minutes,hours;
	
	int RachaInfinita = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, String nombreCurso, LecturaPregunta preguntas, Usuario uActual, boolean CondicionInfinita) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCurso frame = new VentanaCurso(nombreCurso, preguntas, uActual, CondicionInfinita);
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
	public VentanaCurso(String nombreCurso, LecturaPregunta preguntas, Usuario uActual, boolean condicionInfinita) {
		setTitle("Ventana del curso");
		DificultadFuzzy detectaCambioDificultad = new DificultadFuzzy();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int posVX=100, posVY = 100, vTBase= 450, vTAltura = 300;
		setBounds(posVX, posVY, vTBase, vTAltura);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);//Permite mover con libertad las cosas
		setContentPane(contentPane);//Coloca la ventana en la ventana
		
		JLabel tiempoLabel = new JLabel("0:0");
		tiempoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tiempoLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		tiempoLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tiempoLabel.setBounds(329, 71, 75, 23);
		contentPane.add(tiempoLabel);
		
		Timer(tiempoLabel);
		
		JLabel textoPregunta = new JLabel("Preguntas");
		textoPregunta.setHorizontalAlignment(SwingConstants.CENTER);
		textoPregunta.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textoPregunta.setBackground(new Color(255, 255, 255));
		textoPregunta.setBounds(20, 49, 299, 62);
		contentPane.add(textoPregunta);
		
		JLabel titulolbl = new JLabel(nombreCurso);
		titulolbl.setHorizontalAlignment(SwingConstants.CENTER);
		titulolbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		titulolbl.setBounds(115, 10, 187, 29);
		contentPane.add(titulolbl);
		
		JButton botonAyuda = new JButton("Ayuda");
		botonAyuda.setBounds(234, 123, 85, 21);
		contentPane.add(botonAyuda);
		
		JButton botonSiguiente = new JButton("Sig. -->");
		
		botonSiguiente.setBounds(303, 121, 74, 21);
		contentPane.add(botonSiguiente);
		
		JLabel lblRespuesta = new JLabel("Respuesta:");
		lblRespuesta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRespuesta.setBounds(65, 125, 174, 19);
		contentPane.add(lblRespuesta);
		
		JRadioButton r1Vista = new JRadioButton("New radio button");
		JRadioButton r2Vista = new JRadioButton("New radio button");
		JRadioButton r3Vista = new JRadioButton("New radio button");
		JRadioButton r4Vista = new JRadioButton("New radio button");
		
		JRadioButton[] respuestasArrayButton = new JRadioButton[4];
		respuestasArrayButton[0] = new JRadioButton("R1");
		respuestasArrayButton[1] = new JRadioButton("R2");
		respuestasArrayButton[2] = new JRadioButton("R3");
		respuestasArrayButton[3] = new JRadioButton("R4");
		
		int posicionX = 59;
		int posicionY = 120+30;
		int posicionX2 = posicionX+133;
		int posicionY2 = posicionY +37;
		
		
		respuestasArrayButton[0].setBounds(posicionX, posicionY, 103, 21);
		respuestasArrayButton[1].setBounds(posicionX2, posicionY, 103, 21);
		respuestasArrayButton[2].setBounds(posicionX, posicionY2, 103, 21);
		respuestasArrayButton[3].setBounds(posicionX2, posicionY2, 103, 21);
		
		
		
		
		for(int i=0;i<respuestasArrayButton.length;i++) {
			contentPane.add(respuestasArrayButton[i]);
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
				if(!(respuestasArrayButton[0].isSelected())) {
					uActual.setOpcion(-1);
				}
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
				if(!(respuestasArrayButton[1].isSelected())) {
					uActual.setOpcion(-1);
				}
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
				if(!(respuestasArrayButton[2].isSelected())) {
					uActual.setOpcion(-1);
				}
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
				if(!(respuestasArrayButton[3].isSelected())) {
					uActual.setOpcion(-1);
				}
			}
		});
		
		//NoMover. Te da la vista en el Diseño
		r1Vista.setBounds(posicionX, posicionY, 103, 21);
		r2Vista.setBounds(posicionX2, posicionY, 103, 21);
		r3Vista.setBounds(posicionX, posicionY2, 103, 21);
		r4Vista.setBounds(posicionX2, posicionY2, 103, 21);
		r1Vista.setVisible(false);
		r2Vista.setVisible(false);
		r3Vista.setVisible(false);
		r4Vista.setVisible(false);
		contentPane.add(r1Vista);
		contentPane.add(r2Vista);
		contentPane.add(r3Vista);
		contentPane.add(r4Vista);
		
		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String respuestaUsuario = respuestasArrayButton[uActual.getOpcion()].getText();
					if(respuestaUsuario.equals(preguntas.getRespuesta())) {
						timer.stop();
						//Tiempo - Ayuda - Errores
						int tiempo = hours*60*60+minutes*60+second;
						int ayuda = detectaCambioDificultad.getHelp();
						int errores = detectaCambioDificultad.getMistakes();
						detectaCambioDificultad.setValoresDificultad(tiempo,ayuda,errores);
						botonAceptar.setVisible(false);
						botonAyuda.setVisible(false);
						botonSiguiente.setVisible(true);
						respuestasArrayButton[uActual.getOpcion()].setForeground(Color.GREEN);
						lblRespuesta.setText("Respuesta: Correcta");
						for(int i=0;i<4;i++) {
							respuestasArrayButton[i].setVisible(true);
						}
					}else {
						lblRespuesta.setText("Respuesta: Incorrecta.");
						respuestasArrayButton[uActual.getOpcion()].setForeground(Color.RED);
						detectaCambioDificultad.sumarErrores();
					}
				}catch(ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(contentPane, "Escoge una opcion");	
				}
				
			}
		});
		botonAceptar.setBounds(303, 187, 85, 21);
		contentPane.add(botonAceptar);
		
		
		botonAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				detectaCambioDificultad.sumarAyuda();
				if(detectaCambioDificultad.getHelp()<3) {
					labelAyuda(respuestasArrayButton, preguntas.getRespuesta(), uActual);
				}else {
					labelAyuda(respuestasArrayButton, preguntas.getRespuesta(),uActual);
					botonAyuda.setVisible(false);
				}
				
				
			}
		});
		
		JLabel lblRacha = new JLabel("Racha: 1000 seguidas");
		lblRacha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRacha.setBounds(192, 226, 185, 21);
		contentPane.add(lblRacha);
		
		
		JLabel Nivellbl = new JLabel("Nivel:"+preguntas.getDificultad().toString());
		Nivellbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Nivellbl.setBounds(10, 220, 131, 33);
		contentPane.add(Nivellbl);
		
		
		botonSiguiente.setVisible(false);
		
		JButton botonSalir = new JButton("<--Salir");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				VentanaMenuClases vMC= new VentanaMenuClases(uActual);
				vMC.setVisible(true);
			}
		});
		botonSalir.setFont(new Font("Tahoma", Font.PLAIN, 11));
		botonSalir.setBounds(10, 10, 85, 21);
		contentPane.add(botonSalir);
		
		botonSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tiempoLabel.setText(0+":"+0);
				preguntas.siguientePregunta();
				uActual.setOpcion(-1);
				botonAceptar.setVisible(true);
				botonAyuda.setVisible(true);
				botonSiguiente.setVisible(false);
				second = 0;
				minutes = 0;
				hours = 0;
				detectaCambioDificultad.verificarEstadoNivel(preguntas, uActual);
				
				if(detectaCambioDificultad.getRacha()) {
					lblRacha.setVisible(true);
					if(!condicionInfinita) {
						lblRacha.setText("Quedan:"+(NUMEROTERMINARCURSO-preguntas.getNumeroRacha(uActual)));
					}else {
						RachaInfinita++;
						lblRacha.setText("Racha:"+ RachaInfinita + " seguidas");
					}
					
				}else {
					lblRacha.setVisible(false);
					RachaInfinita = 0;
				}
				
				Nivellbl.setText("Nivel:"+preguntas.getDificultad().toString());
				colocarPregunta(respuestasArrayButton, textoPregunta, preguntas);
				lblRespuesta.setText("Respuesta:");
				detectaCambioDificultad.resetFL();
				if(preguntas.getNumeroRacha(uActual)>=NUMEROTERMINARCURSO && !preguntas.CursoTerminado(uActual)) {
					preguntas.terminarCurso(uActual);
					JOptionPane.showMessageDialog(contentPane, "Felicidades. Has terminado el curso "+nombreCurso);
					dispose();
					VentanaMenuClases vMC= new VentanaMenuClases(uActual);
					vMC.setVisible(true);
				}else {
					timer.start();
				}
				
				}
				
		});
		colocarPregunta(respuestasArrayButton, textoPregunta, preguntas);
		
		JLabel lblTxtTiempo = new JLabel("Tiempo:");
		lblTxtTiempo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTxtTiempo.setBounds(332, 48, 72, 23);
		contentPane.add(lblTxtTiempo);
		
		
		
		
		timer.start();
		lblRacha.setVisible(false);
		detectaCambioDificultad.resetFL();
	}

	private void colocarPregunta(JRadioButton[] respuestasArrayButton, JLabel textoPregunta, LecturaPregunta pregunta) {
		ArrayList<String> respuestas = new ArrayList<String>();
		for(int i = 1;i<respuestasArrayButton.length+1;i++) {
			respuestas.add(pregunta.respuestaParaUsuario(i));
		}
		Collections.shuffle(respuestas);
		for(int i=0;i<respuestasArrayButton.length;i++) {
			respuestasArrayButton[i].setForeground(Color.BLACK);
			respuestasArrayButton[i].setText(respuestas.get(i));
			respuestasArrayButton[i].setSelected(false);
		}
		textoPregunta.setText(centrarTexto(pregunta.getPregunta()));
		
	}
	
	private void labelAyuda(JRadioButton[] respuestasArrayButton, String respuesta, Usuario uActual) {
		Random rand = new Random();
        int max=3,min=0;
        int numero = rand.nextInt(max-min+1)+min;
        do {
        	if(!(respuestasArrayButton[numero].getText().equals(respuesta))&&respuestasArrayButton[numero].isVisible()) {
        		respuestasArrayButton[numero].setVisible(false);
            	break;
            }else {
            	numero = rand.nextInt(max-min+1)+min;
            }
        }while(true); 
        for(JRadioButton respuestas:respuestasArrayButton) {
        	respuestas.setSelected(false);
        }
        uActual.setOpcion(-1);
        
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
	
	public String centrarTexto(String texto) {
		String textoN="<html>";

		int i =0;
		try {
			
			for(;i<texto.length();i++) {
			
				if( (texto.charAt(i) =='/')  && (texto.charAt(i+1) == 'n')){
					textoN += "<br />";
					i++;
			}else {
				textoN += texto.charAt(i);
			}
		}
		}catch(StringIndexOutOfBoundsException e) {
			if(i<texto.length()) {
				textoN +=texto.charAt(texto.length()-1);
			}
		}
		return textoN+"</html>";
}
}
