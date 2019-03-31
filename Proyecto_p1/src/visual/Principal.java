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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
import javax.swing.table.DefaultTableModel;

import logico.Baloncesto;
import logico.Equipo;
import logico.Juego;

import java.awt.Cursor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JPanel panelMenuPrinc;
	private JPanel panelInicioJuego;
	private static JTable table;
	private static DefaultTableModel tableModelEquip1;
	private static JTable table_1;
	private static DefaultTableModel tableModel_1Equip2;
	private JPanel panelEquipoAJugar;
	private JButton btnFin;
	private JButton btnCambio;
	private JButton btnPunto;
	private JLabel lblEquipo1;
	private JLabel lblEquipo2;
	private JLabel lblLogoequip;
	private JLabel lblLogoequip2;
	
	private JButton btnJuego;
	private boolean enJuego = false;
	private JButton buttonBackSpace;
	private static Date fechaActual = new Date();
	//inicio fecha para iniciar torneo
	private JSpinner spinnerDia;
	private JSpinner spinnerMes;
	private JSpinner spinnerAno; 
	private JLabel lblIngreseLaFecha;
	private JLabel lblDa;
	private JLabel lblMes;
	private JLabel lblAo;
	private JButton btnCrear;
	//
	//quien juega hoy
	private JLabel lblHoyFecha;
	private JLabel lblLogoequipo11;
	private JLabel lblLogoequipo22;
	private JLabel lblNombre1;
	private JLabel lblNombre2;
	//private Dimension dimention;

	
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println("Fecha1 "+fechaActual.getMonth());
						FileInputStream f= new FileInputStream("src/Baloncesto.dat");
						ObjectInputStream os = new ObjectInputStream(f);
						int punt = os.readInt();
						Baloncesto.getInstance().setCantJuegos(punt);
						System.out.println(Baloncesto.getInstance().getCantJuegos());
						ArrayList<Equipo> aux = (ArrayList<Equipo>) os.readObject();
						Baloncesto.getInstance().setMisEquipos(aux);
						System.out.println(Baloncesto.getInstance().getMisEquipos().size());
						ArrayList<Juego> aux1 = (ArrayList<Juego>) os.readObject();
						Baloncesto.getInstance().setJuegoRecord(aux1);
						System.out.println(Baloncesto.getInstance().getJuegoRecord().size());
						
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (FileNotFoundException ex) {
					Principal frame;
					try {
						frame = new Principal();
						frame.setVisible(true);
						System.err.println("Error "+ex);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					;
					// TODO: handle exception
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	 
	public Principal() throws IOException {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 811);
		fechaActual.setMonth(fechaActual.getMonth());
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
		
		
		/*
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
		*/
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
		mntmRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarEquipo agreEquipo = new AgregarEquipo();
				agreEquipo.setModal(true);
				agreEquipo.setLocationRelativeTo(null);
				agreEquipo.setVisible(true);
			}
		});
		mnEquipo.add(mntmRegistrar);
		
		JMenuItem mntmLista = new JMenuItem("Lista");
		mntmLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarEquipos listequip = new ListarEquipos();
				listequip.setModal(true);
				listequip.setLocationRelativeTo(null);
				listequip.setVisible(true);
			}
		});
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
		
		
		btnJuego = new JButton("Juego");
		btnJuego.setEnabled(false);
		if (Baloncesto.getInstance().getJuegoRecord().size()==0 && Baloncesto.getInstance().getCantJuegos()==0) {
			btnJuego.setText("Crear Torneo");
			btnJuego.setEnabled(true);
		}else if (Baloncesto.getInstance().getJuegoRecord().size()!=Baloncesto.getInstance().getCantJuegos() && enJuego==false) {
			btnJuego.setText("Iniciar\n Juego");
		}else if (Baloncesto.getInstance().getJuegoRecord().size()!=Baloncesto.getInstance().getCantJuegos() && enJuego==true) {
			btnJuego.setText("Renaudar\n Juego");
			btnJuego.setEnabled(true);
		}
		btnJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnJuego.getText().toString().equalsIgnoreCase("Crear Torneo")) {
					btnJuego.setEnabled(false);
					btnJuego.setVisible(false);
					btnCrear.setVisible(true);
					lblIngreseLaFecha.setVisible(true);
					lblAo.setVisible(true);
					lblDa.setVisible(true);
					lblMes.setVisible(true);
					spinnerAno.setVisible(true);
					spinnerDia.setVisible(true);
					spinnerMes.setVisible(true);
					
					btnCrear.setEnabled(true);
					lblIngreseLaFecha.setEnabled(true);
					lblAo.setEnabled(true);
					lblDa.setEnabled(true);
					lblMes.setEnabled(true);
					spinnerAno.setEnabled(true);
					spinnerDia.setEnabled(true);
					spinnerMes.setEnabled(true);
					
				}else if (btnJuego.getText().toString().equalsIgnoreCase("Iniciar\n Juego") && enJuego==false) {
					panelMenuPrinc.setVisible(false);
					panelInicioJuego.setVisible(true);
					btnCambio.setVisible(true);
					btnFin.setVisible(true);
					btnPunto.setVisible(true);
					buttonBackSpace.setVisible(true);
					buttonBackSpace.setEnabled(true);
					btnJuego.setText("Renaudar\n Juego");
					lblEquipo1.setText(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[0].getNombre());
					lblEquipo2.setText(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[1].getNombre());

					Icon icono = new ImageIcon(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[0].getLogo().getImage().getScaledInstance(lblLogoequipo11.getWidth(), lblLogoequipo11.getHeight(), Image.SCALE_DEFAULT));
					lblLogoequip.setIcon(icono);
					lblLogoequip.setText(null);
					Icon icono1 = new ImageIcon(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[1].getLogo().getImage().getScaledInstance(lblLogoequipo22.getWidth(), lblLogoequipo22.getHeight(), Image.SCALE_DEFAULT));
					lblLogoequip2.setIcon(icono1);
					lblLogoequip2.setText(null);
					enJuego=true;
				}else if (btnJuego.getText().toString().equalsIgnoreCase("Renaudar\n Juego") && enJuego==true) {
					panelMenuPrinc.setVisible(false);
					panelInicioJuego.setVisible(true);
					btnCambio.setVisible(true);
					btnFin.setVisible(true);
					btnPunto.setVisible(true);
					buttonBackSpace.setVisible(true);
					buttonBackSpace.setEnabled(true);
				}
				
				
			}
		});
		btnJuego.setOpaque(false);
		btnJuego.setContentAreaFilled(false);
		//btnJuego.setBorderPainted(false);
		btnJuego.setForeground(Color.WHITE);
		btnJuego.setHorizontalTextPosition(SwingConstants.CENTER);
		btnJuego.setIcon(new ImageIcon(Principal.class.getResource("/imagen/botoninhhddddddddddddd1221i.gif")));
		btnJuego.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnJuego.setBounds(565, 214, 184, 167);
		
		panelMenuPrinc.add(btnJuego);
		
		lblIngreseLaFecha = new JLabel("Ingrese La Fecha De Inicio Del Torneo");
		lblIngreseLaFecha.setEnabled(false);
		lblIngreseLaFecha.setVisible(false);
		
		panelEquipoAJugar = new JPanel();
		panelEquipoAJugar.setBounds(254, 72, 780, 306);
		panelEquipoAJugar.setOpaque(false);
		panelMenuPrinc.add(panelEquipoAJugar);
		panelEquipoAJugar.setLayout(null);
		
		lblLogoequipo11 = new JLabel("logoEquipo1");
		lblLogoequipo11.setForeground(Color.WHITE);
		lblLogoequipo11.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogoequipo11.setBounds(35, 128, 183, 178);
		panelEquipoAJugar.add(lblLogoequipo11);
		
		lblLogoequipo22 = new JLabel("logoEquipo2");
		lblLogoequipo22.setForeground(Color.WHITE);
		lblLogoequipo22.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogoequipo22.setBounds(578, 128, 183, 178);
		panelEquipoAJugar.add(lblLogoequipo22);
		
		
		
		lblNombre1 = new JLabel("nombre1");
		lblNombre1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre1.setForeground(Color.WHITE);
		lblNombre1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre1.setBounds(61, 53, 121, 33);
		panelEquipoAJugar.add(lblNombre1);
		
		lblNombre2 = new JLabel("nombre2");
		lblNombre2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre2.setForeground(Color.WHITE);
		lblNombre2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre2.setBounds(608, 53, 121, 33);
		panelEquipoAJugar.add(lblNombre2);
		
		lblHoyFecha = new JLabel("example");
		menuPrincipalJuegoMostrar();
		
		lblHoyFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoyFecha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHoyFecha.setForeground(Color.WHITE);
		lblHoyFecha.setBounds(284, 11, 236, 41);
		panelEquipoAJugar.add(lblHoyFecha);
		
		lblIngreseLaFecha.setForeground(Color.WHITE);
		lblIngreseLaFecha.setBackground(Color.WHITE);
		lblIngreseLaFecha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIngreseLaFecha.setBounds(501, 181, 322, 101);
		panelMenuPrinc.add(lblIngreseLaFecha);
		
		lblDa = new JLabel("D\u00EDa");
		lblDa.setEnabled(false);
		lblDa.setVisible(false);
		lblDa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDa.setForeground(Color.WHITE);
		lblDa.setBounds(530, 293, 46, 14);
		panelMenuPrinc.add(lblDa);
		
		lblMes = new JLabel("Mes");
		lblMes.setEnabled(false);
		lblMes.setVisible(false);
		lblMes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMes.setForeground(Color.WHITE);
		lblMes.setBounds(627, 293, 46, 14);
		panelMenuPrinc.add(lblMes);
		
		lblAo = new JLabel("A\u00F1o");
		lblAo.setEnabled(false);
		lblAo.setVisible(false);
		lblAo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAo.setForeground(Color.WHITE);
		lblAo.setBounds(726, 293, 46, 14);
		panelMenuPrinc.add(lblAo);
		
		btnCrear = new JButton("Crear");
		btnCrear.setEnabled(false);
		btnCrear.setVisible(false);
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int day = Integer.parseInt(spinnerDia.getValue().toString());
				int mes = Integer.parseInt(spinnerMes.getValue().toString());
				int ano = Integer.parseInt(spinnerAno.getValue().toString());
				if (((ano == (fechaActual.getYear()+1900) && mes> fechaActual.getMonth()) || (ano == (fechaActual.getYear()+1900) && mes== fechaActual.getMonth() && day >= fechaActual.getDate()) || (ano > (fechaActual.getYear()+1900)))  && Baloncesto.getInstance().getMisEquipos().size()>=2) {
					Date aux = new Date(ano, mes, day);
					Baloncesto.getInstance().crearPartido(Baloncesto.getInstance().getMisEquipos(), aux);
					
					JOptionPane.showMessageDialog(null, "Torneo Creado", "Torneo", JOptionPane.INFORMATION_MESSAGE);
					menuPrincipalJuegoMostrar();
					btnJuego.setVisible(true);
					btnCrear.setVisible(false);
					lblIngreseLaFecha.setVisible(false);
					lblAo.setVisible(false);
					lblDa.setVisible(false);
					lblMes.setVisible(false);
					spinnerAno.setVisible(false);
					spinnerDia.setVisible(false);
					spinnerMes.setVisible(false);
					btnJuego.setText("Iniciar\n Juego");
					
					btnCrear.setEnabled(false);
					lblIngreseLaFecha.setEnabled(false);
					lblAo.setEnabled(false);
					lblDa.setEnabled(false);
					lblMes.setEnabled(false);
					spinnerAno.setEnabled(false);
					spinnerDia.setEnabled(false);
					spinnerMes.setEnabled(false);
					
					if (Baloncesto.getInstance().getJuegoRecord().size()==0 && Baloncesto.getInstance().getCantJuegos()==0) {
						btnJuego.setText("Crear Torneo");
						btnJuego.setEnabled(true);
					}else if (Baloncesto.getInstance().getJuegoRecord().size()!=Baloncesto.getInstance().getCantJuegos() && enJuego==false) {
						btnJuego.setText("Iniciar\n Juego");
					}else if (Baloncesto.getInstance().getJuegoRecord().size()!=Baloncesto.getInstance().getCantJuegos() && enJuego==true) {
						btnJuego.setText("Renaudar\n Juego");
					}
				}else if(Baloncesto.getInstance().getMisEquipos().size()<2){
					 
							JOptionPane.showMessageDialog(null, "Para poder crear el torneo, el minimo de equipo para jugar es de 2", "Torneo", JOptionPane.WARNING_MESSAGE);
						
				}else {
					 
							JOptionPane.showMessageDialog(null, "Esa fecha no es valida", "Torneo", JOptionPane.WARNING_MESSAGE);
						
				}
				
			}
		});
		btnCrear.setBounds(595, 379, 112, 32);
		panelMenuPrinc.add(btnCrear);
		
		spinnerDia = new JSpinner();
		spinnerDia.setEnabled(false);
		spinnerDia.setVisible(false);
		spinnerDia.setModel(new SpinnerNumberModel(fechaActual.getDate(), 1, 31, 1));
		spinnerDia.setBounds(530, 333, 48, 20);
		panelMenuPrinc.add(spinnerDia);
		
		spinnerMes = new JSpinner();
		spinnerMes.setEnabled(false);
		spinnerMes.setVisible(false);
		System.out.println("Fecha "+fechaActual.getMonth());
		spinnerMes.setModel(new SpinnerNumberModel(fechaActual.getMonth(), 1, 12, 1));
		System.out.println("Fecha "+fechaActual.getMonth());
		spinnerMes.setBounds(627, 333, 46, 20);
		panelMenuPrinc.add(spinnerMes);
		
		spinnerAno = new JSpinner();
		spinnerAno.setEnabled(false);
		spinnerAno.setVisible(false);
		spinnerAno.setModel(new SpinnerNumberModel(new Integer(fechaActual.getYear()+1900), new Integer(fechaActual.getYear()+1900), null, new Integer(1)));
		spinnerAno.setBounds(726, 333, 56, 20);
		panelMenuPrinc.add(spinnerAno);
		
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
		
		lblEquipo1 = new JLabel("Equipo1");
		lblEquipo1.setForeground(Color.WHITE);
		lblEquipo1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEquipo1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo1.setBounds(123, 11, 131, 31);
		panel_equipo1.add(lblEquipo1);
		
		lblLogoequip = new JLabel("logo_equip1");
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
		
		lblEquipo2 = new JLabel("Equipo1");
		lblEquipo2.setForeground(Color.WHITE);
		lblEquipo2.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEquipo2.setBounds(136, 11, 131, 31);
		panel_equipo2.add(lblEquipo2);
		
		lblLogoequip2 = new JLabel("logo_equip2");
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
		
		buttonBackSpace = new JButton("");
		buttonBackSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonBackSpace.setVisible(false);
				buttonBackSpace.setEnabled(false);
				panelMenuPrinc.setVisible(true);
				panelInicioJuego.setVisible(false);
				btnCambio.setVisible(false);
				btnFin.setVisible(false);
				btnPunto.setVisible(false);
			}
		});
		buttonBackSpace.setIcon(new ImageIcon(Principal.class.getResource("/com/sun/javafx/scene/control/skin/caspian/fxvk-backspace-button.png")));
		buttonBackSpace.setBounds(10, 23, 45, 27);
		buttonBackSpace.setVisible(false);
		buttonBackSpace.setEnabled(false);
		
		panelInicioJuego.add(buttonBackSpace);
		lblfondojuego.setIcon(icono);
		panelInicioJuego.add(lblfondojuego);
		}
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
	
	private void menuPrincipalJuegoMostrar() {
		try {
			if (fechaActual.getDate()==Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getFechaJuego().getDate() && Baloncesto.getInstance().getJuegoRecord().size()!=0) {
				panelEquipoAJugar.setVisible(true);
				btnJuego.setEnabled(true);
				lblHoyFecha.setText("Hoy");
				
				//Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[0].getLogo()
				Icon icono = new ImageIcon(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[0].getLogo().getImage().getScaledInstance(lblLogoequipo11.getWidth(), lblLogoequipo11.getHeight(), Image.SCALE_DEFAULT));
				lblLogoequipo11.setIcon(icono);
				lblLogoequipo11.setText(null);
				lblNombre1.setText(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[0].getNombre());
				Icon icono1 = new ImageIcon(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[1].getLogo().getImage().getScaledInstance(lblLogoequipo22.getWidth(), lblLogoequipo22.getHeight(), Image.SCALE_DEFAULT));
				lblLogoequipo22.setIcon(icono1);
				lblLogoequipo22.setText(null);
				lblNombre2.setText(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[1].getNombre());
			}else if(fechaActual.getDate()+1==Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getFechaJuego().getDate()) {
				panelEquipoAJugar.setVisible(true);
				lblHoyFecha.setText("Mañana");
				btnJuego.setEnabled(false);
				//Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[0].getLogo()
				Icon icono = new ImageIcon(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[0].getLogo().getImage().getScaledInstance(lblLogoequipo11.getWidth(), lblLogoequipo11.getHeight(), Image.SCALE_DEFAULT));
				lblLogoequipo11.setIcon(icono);
				lblLogoequipo11.setText(null);
				lblNombre1.setText(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[0].getNombre());
				Icon icono1 = new ImageIcon(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[1].getLogo().getImage().getScaledInstance(lblLogoequipo22.getWidth(), lblLogoequipo22.getHeight(), Image.SCALE_DEFAULT));
				lblLogoequipo22.setIcon(icono1);
				lblLogoequipo22.setText(null);
				lblNombre2.setText(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[1].getNombre());
			
			}else if(Baloncesto.getInstance().getJuegoRecord().size()!=0) {
				int dia = Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getFechaJuego().getDate();
				int mes = Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getFechaJuego().getMonth();
				int year = Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getFechaJuego().getYear();
				panelEquipoAJugar.setVisible(true);
				btnJuego.setEnabled(false);
				lblHoyFecha.setText(Integer.toString(dia)+"/"+Integer.toString(mes)+"/"+Integer.toString(year));
				//Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[0].getLogo()
				Icon icono = new ImageIcon(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[0].getLogo().getImage().getScaledInstance(lblLogoequipo11.getWidth(), lblLogoequipo11.getHeight(), Image.SCALE_DEFAULT));
				lblLogoequipo11.setIcon(icono);
				lblLogoequipo11.setText(null);
				lblNombre1.setText(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[0].getNombre());
				Icon icono1 = new ImageIcon(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[1].getLogo().getImage().getScaledInstance(lblLogoequipo22.getWidth(), lblLogoequipo22.getHeight(), Image.SCALE_DEFAULT));
				lblLogoequipo22.setIcon(icono1);
				lblLogoequipo22.setText(null);
				lblNombre2.setText(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[1].getNombre());
			
			}
		} catch (IndexOutOfBoundsException e) {
			panelEquipoAJugar.setVisible(false);
			/*lblHoyFecha.setVisible(false);
			lblLogoequipo11.setVisible(false);
			lblLogoequipo11.setVisible(false);
			lblNombre1.setVisible(false);
			lblLogoequipo22.setVisible(false);
			lblLogoequipo22.setVisible(false);
			lblNombre2.setVisible(false);*/
			// TODO: handle exception
			//e.printStackTrace();
		}
		
	}
	
	
}
