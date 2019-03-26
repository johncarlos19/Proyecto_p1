package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dimention;

	
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	 
	public Principal() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);;
		

		JPanel panel = new JPanel();
		panel.setVisible(false);
		panel.setEnabled(false);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnNba = new JButton();
		btnNba.setIcon(new ImageIcon(Principal.class.getResource("/imagen/logoprincipal2.png")));
		btnNba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add(btnNba, BorderLayout.CENTER);
		
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1340, 21);
		panel_1.add(menuBar);
		
		JMenu mnEquipo = new JMenu("Equipo");
		menuBar.add(mnEquipo);
		
		JMenuItem mntmRegistrar = new JMenuItem("Registrar");
		mnEquipo.add(mntmRegistrar);
		
		JMenuItem mntmLista = new JMenuItem("Lista");
		mnEquipo.add(mntmLista);
		
		JMenu mnCalendario = new JMenu("Calendario");
		menuBar.add(mnCalendario);
		
		JMenuItem mntmVerCalendario = new JMenuItem("Ver Calendario");
		mnCalendario.add(mntmVerCalendario);
		
		JMenu mnEstadisticas = new JMenu("Estadisticas");
		menuBar.add(mnEstadisticas);
		
		JMenuItem mntmEstadisticaDelEquipo = new JMenuItem("Estadistica Del Equipo");
		mnEstadisticas.add(mntmEstadisticaDelEquipo);
		
		JMenuItem mntmEstadisticaDelJugador = new JMenuItem("Estadistica Del Jugador");
		mnEstadisticas.add(mntmEstadisticaDelJugador);
		
		JMenuItem mntmEstadisticaDelPartido = new JMenuItem("Estadistica Del Partido");
		mnEstadisticas.add(mntmEstadisticaDelPartido);
		
		JButton btnJuego = new JButton("Juego");
		btnJuego.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnJuego.setBounds(598, 248, 184, 167);
		panel_1.add(btnJuego);
		dimention = super.getToolkit().getScreenSize();
		super.setSize(dimention.width,(dimention.height-50));
		setLocationRelativeTo(null);
		
		
		dimention=super.getToolkit().getScreenSize();
		super.setSize(dimention.width,(dimention.height-50));
	}
}
