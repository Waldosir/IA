package NoLoOcupo;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import DatosUsuario.Usuario;
import bancoDatos.LecturaUsuarios;

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
		LecturaUsuarios l = new LecturaUsuarios();
		for(Usuario lista: l.recuperarArrayListUsuarios()) {

			mod.addElement(lista.getNombre());
		}
	}
}
