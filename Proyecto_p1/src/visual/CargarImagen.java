package visual;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JFileChooser;

public class CargarImagen extends JInternalFrame {
	
	public static JFileChooser fileChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CargarImagen frame = new CargarImagen();
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
	public CargarImagen() {
		setBounds(100, 100, 537, 397);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		fileChooser = new JFileChooser();
		getContentPane().add(fileChooser, BorderLayout.CENTER);

	}

}
