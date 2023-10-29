package Interfaz;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DatosUsuario.LecturaDatos;
import DatosUsuario.Usuario;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class VentanaAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAdmin frame = new VentanaAdmin();
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
	public VentanaAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		//contentPane.add(list);
		DefaultListModel mod = new DefaultListModel();
		
		JScrollPane listScroller = new JScrollPane();
		listScroller.setBounds(309, 68, 17, 48);
		contentPane.add(listScroller);
		
		JList list = new JList();
		contentPane.add(list);
		list.setBounds(217, 68, 78, 78);
		list.setModel(mod);
		LecturaDatos l = new LecturaDatos();
		for(Usuario lista: l.recuperarArrayListUsuarios()) {

			mod.addElement(lista.getNombre());
		}
	}
}
