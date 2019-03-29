package visual;
import java.awt.BorderLayout;
import java.awt.Color;
//import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.Icon;
//import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Cursor;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JPanel panelMenuPrinc;
	private JPanel panelInicioJuego;
	private JTable table;
	private JTable table_1;
	private JButton btnFin;
	private JButton btnCambio;
	private JButton btnPunto;
	//private Dimension dimention;

	
	 
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

	

	 
	public Principal() throws IOException {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 811);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		/*
		archivoSalida = new File("src/imagen/hola.jpg");
		//Principal.class.getResource("/imagen/hola.jpg").toURI()
		System.out.println(archivoSalida.toString());
		FileInputStream lector = new FileInputStream(ic);
	    FileOutputStream escritor = new FileOutputStream(archivoSalida);
		 int unByte;     
	     // Informa que se está copiando el archivo
	     System.out.println("\n\tEl archivo está siendo copiado....");
	     // Lee el archivoEntrada y guarda la informacion en el archivoSalida
	     try {
				while ((unByte = lector.read()) != -1)
				   escritor.write(unByte);
				
			    lector.close();
		        escritor.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	     System.out.println("\tEl archivo ha sido copiado con éxito....\n");*/
		
		//
		
		
		
		JPanel panelPantallaPotect = new JPanel();
		 panelPantallaPotect.setBounds(5, 5, 1340, 792);
		contentPane.add(panelPantallaPotect);
		
		JButton btnNba = new JButton();
		btnNba.setBounds(0, 0, 1340, 792);
		btnNba.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		
		btnNba.setOpaque(false);
		btnNba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				panelPantallaPotect.setVisible(false);
				//panelMenuPrinc.setVisible(true);
			}
		});
		Icon icon11 = new ImageIcon(new ImageIcon(Principal.class.getResource("/imagen/1530966.jpg")).getImage().getScaledInstance(btnNba.getWidth(), btnNba.getHeight(), Image.SCALE_DEFAULT));
		panelPantallaPotect.setLayout(null);
		btnNba.setIcon(icon11);
		panelPantallaPotect.add(btnNba);
		
		contentPane.setLayout(null);
		

		
		
		
		panelMenuPrinc = new JPanel();
		panelMenuPrinc.setBounds(5, 5, 1340, 762);
		contentPane.add(panelMenuPrinc);
		panelMenuPrinc.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		//menuBar.setVisible(false);
		menuBar.setBounds(0, 0, 1340, 21);
		panelMenuPrinc.add(menuBar);
		
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
		btnJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenuPrinc.setVisible(false);
				panelInicioJuego.setVisible(true);
				btnCambio.setVisible(true);
				btnFin.setVisible(true);
				btnPunto.setVisible(true);
			}
		});
		btnJuego.setForeground(Color.WHITE);
		btnJuego.setHorizontalTextPosition(SwingConstants.CENTER);
		btnJuego.setIcon(new ImageIcon(Principal.class.getResource("/imagen/botoninhhddddddddddddd11i.gif")));
		btnJuego.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnJuego.setBounds(559, 245, 184, 167);
		panelMenuPrinc.add(btnJuego);
		
		JLabel fondoPrin = new JLabel("");
		fondoPrin.setIcon(new ImageIcon(Principal.class.getResource("/imagen/1530905.jpg")));
		fondoPrin.setBounds(0, 21, 1340, 741);
		panelMenuPrinc.add(fondoPrin);
		
		


		panelInicioJuego = new JPanel();
		panelInicioJuego.setBounds(5, 5, 1340, 792);
		//panelInicioJuego.setVisible(false);
		//panelInicioJuego.setEnabled(false);
		contentPane.add(panelInicioJuego);;
		panelInicioJuego.setLayout(null);
		{
		JPanel panel_equipo1 = new JPanel();
		panel_equipo1.setBounds(72, 23, 390, 506);
		panel_equipo1.setOpaque(false);
		panelInicioJuego.add(panel_equipo1);
		panel_equipo1.setLayout(null);
		
		JLabel lblEquipo1 = new JLabel("Equipo1");
		lblEquipo1.setForeground(Color.WHITE);
		lblEquipo1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEquipo1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo1.setBounds(123, 11, 131, 31);
		panel_equipo1.add(lblEquipo1);
		
		JLabel lblLogoequip = new JLabel("logo_equip1");
		lblLogoequip.setForeground(Color.WHITE);
		lblLogoequip.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogoequip.setBounds(100, 53, 177, 147);
		panel_equipo1.add(lblLogoequip);
		
		JPanel panel_jugador_principal1 = new JPanel();
		panel_jugador_principal1.setOpaque(false);
		panel_jugador_principal1.setForeground(Color.WHITE);
		panel_jugador_principal1.setBounds(42, 281, 292, 189);
		panel_equipo1.add(panel_jugador_principal1);
		panel_jugador_principal1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_equi1 = new JScrollPane();
		scrollPane_equi1.setOpaque(false);
		panel_jugador_principal1.add(scrollPane_equi1, BorderLayout.CENTER);
		
		table = new JTable();
		table.setOpaque(false);
		scrollPane_equi1.setColumnHeaderView(table);
		
		JLabel lblJugadoresEnJuego = new JLabel("Jugadores En juego");
		lblJugadoresEnJuego.setForeground(Color.WHITE);
		lblJugadoresEnJuego.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugadoresEnJuego.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblJugadoresEnJuego.setBounds(88, 232, 200, 31);
		panel_equipo1.add(lblJugadoresEnJuego);
		
		JPanel panel_equipo2 = new JPanel();
		panel_equipo2.setOpaque(false);
		panel_equipo2.setBounds(863, 23, 390, 506);
		panelInicioJuego.add(panel_equipo2);
		panel_equipo2.setLayout(null);
		
		JLabel lblEquipo2 = new JLabel("Equipo1");
		lblEquipo2.setForeground(Color.WHITE);
		lblEquipo2.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEquipo2.setBounds(136, 11, 131, 31);
		panel_equipo2.add(lblEquipo2);
		
		JLabel lblLogoequip2 = new JLabel("logo_equip2");
		lblLogoequip2.setForeground(Color.WHITE);
		lblLogoequip2.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogoequip2.setBounds(113, 53, 177, 147);
		panel_equipo2.add(lblLogoequip2);
		
		JPanel panel_jugador_principal2 = new JPanel();
		panel_jugador_principal2.setForeground(Color.WHITE);
		panel_jugador_principal2.setBounds(55, 281, 292, 189);
		panel_equipo2.add(panel_jugador_principal2);
		panel_jugador_principal2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_equi2 = new JScrollPane();
		panel_jugador_principal2.add(scrollPane_equi2, BorderLayout.CENTER);
		
		table_1 = new JTable();
		scrollPane_equi2.setColumnHeaderView(table_1);
		
		JLabel lblJugadoresEnJuego2 = new JLabel("Jugadores En juego");
		lblJugadoresEnJuego2.setForeground(Color.WHITE);
		lblJugadoresEnJuego2.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugadoresEnJuego2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblJugadoresEnJuego2.setBounds(101, 232, 200, 31);
		panel_equipo2.add(lblJugadoresEnJuego2);
		
		JLabel lblfondojuego = new JLabel("");
		lblfondojuego.setBounds(0, 5, 1340, 757);
		lblfondojuego.setHorizontalAlignment(SwingConstants.CENTER);
		lblfondojuego.setHorizontalTextPosition(SwingConstants.CENTER);
		Icon icono = new ImageIcon(new ImageIcon(Principal.class.getResource("/imagen/fondo-pvk-team-carbono-rojo-negro-1900x1092.jpg")).getImage().getScaledInstance(lblfondojuego.getWidth(), lblfondojuego.getHeight(), Image.SCALE_DEFAULT));
		
		btnPunto = new JButton("Punto");
		btnPunto.setVisible(false);
		btnPunto.setBackground(new Color(255, 99, 71));
		btnPunto.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnPunto.setBounds(593, 236, 141, 49);
		panelInicioJuego.add(btnPunto);
		
		btnCambio = new JButton("Cambio");
		btnCambio.setVisible(false);
		btnCambio.setBackground(new Color(255, 99, 71));
		btnCambio.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnCambio.setBounds(593, 318, 141, 49);
		panelInicioJuego.add(btnCambio);
		
		btnFin = new JButton("Fin");
		btnFin.setVisible(false);
		btnFin.setBackground(new Color(255, 99, 71));
		btnFin.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnFin.setBounds(593, 405, 141, 49);
		panelInicioJuego.add(btnFin);
		
		JLabel lblversus = new JLabel("VS");
		lblversus.setBounds(543, 24, 231, 128);
		lblversus.setForeground(Color.WHITE);
		lblversus.setFont(new Font("AbandoN", Font.PLAIN, 71));
		lblversus.setHorizontalAlignment(SwingConstants.CENTER);
		panelInicioJuego.add(lblversus);
		
		JLabel lblpuntequip1 = new JLabel("0");
		lblpuntequip1.setHorizontalAlignment(SwingConstants.CENTER);
		lblpuntequip1.setForeground(Color.WHITE);
		lblpuntequip1.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblpuntequip1.setBounds(472, 145, 45, 55);
		panelInicioJuego.add(lblpuntequip1);
		
		JLabel lblcanha = new JLabel("");
		lblcanha.setHorizontalAlignment(SwingConstants.CENTER);
		lblcanha.setBounds(333, 528, 682, 197);
		Icon iconoCancha = new ImageIcon(new ImageIcon(Principal.class.getResource("/imagen/d-basketball-field-white-background-illustration-49785575.gif")).getImage().getScaledInstance(lblcanha.getWidth(), lblcanha.getHeight(), Image.SCALE_DEFAULT));
		
		JLabel lblPivot = new JLabel("Example");
		lblPivot.setIcon(new ImageIcon(Principal.class.getResource("/imagen/usuario.png")));
		lblPivot.setBounds(408, 563, 73, 34);
		panelInicioJuego.add(lblPivot);
		
		JLabel lblPivotequip2 = new JLabel("Example");
		lblPivotequip2.setIcon(new ImageIcon(Principal.class.getResource("/imagen/usuario.png")));
		lblPivotequip2.setBounds(875, 563, 73, 34);
		panelInicioJuego.add(lblPivotequip2);
		
		JLabel lblEscolta1 = new JLabel("Example");
		lblEscolta1.setIcon(new ImageIcon(Principal.class.getResource("/imagen/usuario.png")));
		lblEscolta1.setBounds(472, 671, 73, 38);
		panelInicioJuego.add(lblEscolta1);
		
		JLabel lblEscolta1equip2 = new JLabel("Example");
		lblEscolta1equip2.setIcon(new ImageIcon(Principal.class.getResource("/imagen/usuario.png")));
		lblEscolta1equip2.setBounds(909, 660, 73, 38);
		panelInicioJuego.add(lblEscolta1equip2);
		
		JLabel lblEscolta2 = new JLabel("Example");
		lblEscolta2.setIcon(new ImageIcon(Principal.class.getResource("/imagen/usuario.png")));
		lblEscolta2.setBounds(491, 538, 73, 38);
		panelInicioJuego.add(lblEscolta2);
		
		JLabel lblEscolta2equip2 = new JLabel("Example");
		lblEscolta2equip2.setIcon(new ImageIcon(Principal.class.getResource("/imagen/usuario.png")));
		lblEscolta2equip2.setBounds(766, 550, 73, 34);
		panelInicioJuego.add(lblEscolta2equip2);
		
		JLabel lblBase = new JLabel("Example");
		lblBase.setIcon(new ImageIcon(Principal.class.getResource("/imagen/usuario.png")));
		lblBase.setBounds(554, 600, 73, 34);
		panelInicioJuego.add(lblBase);
		
		JLabel lblBaseEquip2 = new JLabel("Example");
		lblBaseEquip2.setIcon(new ImageIcon(Principal.class.getResource("/imagen/usuario.png")));
		lblBaseEquip2.setBounds(722, 595, 73, 38);
		panelInicioJuego.add(lblBaseEquip2);
		
		JLabel lblAlero = new JLabel("Example");
		lblAlero.setIcon(new ImageIcon(Principal.class.getResource("/imagen/usuario.png")));
		lblAlero.setBounds(355, 660, 100, 49);
		panelInicioJuego.add(lblAlero);
		
		JLabel lblAleroequi2 = new JLabel("Example");
		lblAleroequi2.setIcon(new ImageIcon(Principal.class.getResource("/imagen/usuario.png")));
		lblAleroequi2.setBounds(808, 670, 73, 41);
		panelInicioJuego.add(lblAleroequi2);
		lblcanha.setIcon(iconoCancha);
		panelInicioJuego.add(lblcanha);
		
		JLabel lblpuntequip12 = new JLabel("0");
		lblpuntequip12.setHorizontalAlignment(SwingConstants.CENTER);
		lblpuntequip12.setForeground(Color.WHITE);
		lblpuntequip12.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblpuntequip12.setBounds(808, 145, 45, 55);
		panelInicioJuego.add(lblpuntequip12);
		lblfondojuego.setIcon(icono);
		panelInicioJuego.add(lblfondojuego);
		//Este codigo listo para modificar al equipo
		
		//File ic;
		//File archivoSalida;
		/*File direc;
		File archiv;
		direc = new File("src");
			direc.mkdir();
			direc = new File(direc,"imagen");
			direc.mkdir();
			archiv = new File(direc,"hola.jpg");
			archiv.createNewFile();*
			
			//*
		try {
			
			try {
				ic = new File( Principal.class.getResource("/imagen/1530966.jpg").toURI());
				ImageIcon icon = new ImageIcon(ic.toString());
				System.out.println(ic.toString());
				Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lblfondojuego.getWidth(), lblfondojuego.getHeight(), Image.SCALE_DEFAULT));
				lblfondojuego.setIcon(icono);
				panelInicioJuego.add(lblfondojuego);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Error cargando la imagen "+ ex);
			} */
		}
		
		
		

		/*dimention = super.getToolkit().getScreenSize();
		super.setSize(dimention.width,(dimention.height-50));
		setLocationRelativeTo(null);
		
		
		dimention=super.getToolkit().getScreenSize();
		super.setSize(dimention.width,(dimention.height-50));*/
	}
}
