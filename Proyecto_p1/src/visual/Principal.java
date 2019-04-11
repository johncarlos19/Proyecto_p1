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
import java.io.Serializable;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import logico.Baloncesto;
import logico.Equipo;
import logico.Juego;
import logico.Jugador;

import java.awt.Cursor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.applet.AudioClip;

public class Principal extends JFrame /*implements Runnable*/ {

	/**
	 * 
	 */
	//Thread h1;
	private JPanel contentPane;
	private JPanel panelMenuPrinc;
	private JPanel panelInicioJuego;
	private static JTable table_Equip1;
	private static DefaultTableModel tableModel_Equip1;
	private static JTable table__Equip2;
	private static DefaultTableModel tableModel_1Equip2;
	private JPanel panelEquipoAJugar;
	private JButton btnFin;
	private JButton btnCambio;
	private JButton btnFalta;
	private JButton btnLibre;
	private JButton btnDoble;
	private JButton btnTriple;
	private JLabel lblEquipo1;
	private JLabel lblEquipo2;
	private JLabel lblLogoequip;
	private JLabel lblLogoequip2;
	
	private JButton btnJuego;
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
	private static DefaultTableModel model_Equip1;
	private static Object[] fila_Equip1;
	private static DefaultTableModel model_Equip2;
	private static Object[] fila_Equip2;
	private String nombreJugador;
	private String posisionJugador;
	private int equipoSeleccionado=-1;
	private JLabel lblpuntequip1;
	private JLabel lblpuntequip12;
	private JButton btnReiniciarTorneo;
	
	//asignacion de equipo en el campo
	private JLabel lblPivot;
	private JLabel lblAlas_Pivot;
	private JLabel lblEscolta;
	private JLabel lblBase;
	private JLabel lblAlero;
	
	private JLabel lblPivotequip2;
	private JLabel lblAla_Pivotequip2;
	private JLabel lblEscoltaequip2;
	private JLabel lblBaseEquip2;
	private JLabel lblAleroequi2;
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
						boolean en = os.readBoolean();
						Baloncesto.getInstance().setEnJuego(en);
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

	

	 
	public Principal() throws IOException  {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/imagen/logoprincipal2.png")));
		setTitle("Baloncesto");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1351, 797);
		setResizable(false);
		fechaActual.setMonth(fechaActual.getMonth()+1);
		//h1 = new Thread(this);
		//h1.start();
		
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
		btnReiniciarTorneo = new JButton("Reiniciar Torneo");
		btnReiniciarTorneo.setEnabled(false);
		btnReiniciarTorneo.setVisible(false);
		btnReiniciarTorneo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Baloncesto.getInstance().reiniciarTorneo();
				Baloncesto.getInstance().setCantJuegos(0);
				btnJuego.setText("Crear Torneo");
				btnJuego.setEnabled(true);
				btnReiniciarTorneo.setVisible(false);
				menuPrincipalJuegoMostrar();
			}
		});
		btnReiniciarTorneo.setFont(new Font("Swis721 BdCnOul BT", Font.BOLD, 24));
		btnReiniciarTorneo.setBounds(551, 419, 206, 46);
		panelMenuPrinc.add(btnReiniciarTorneo);
		
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
		mntmVerCalendario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Calendario miCalen = new Calendario();
			miCalen.setModal(true);
			miCalen.setLocationRelativeTo(null);
			miCalen.setVisible(true);
			
			}
		});
		mnCalendario.add(mntmVerCalendario);
		
		JMenu mnEstadisticas = new JMenu("Estadisticas");
		menuBar.add(mnEstadisticas);

		JMenuItem mntmEstadisticaDelEquipo = new JMenuItem("Estadistica Del Equipo");
		mntmEstadisticaDelEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EstadisticaEquipo estadisticaEquipo = new EstadisticaEquipo();
				estadisticaEquipo.setModal(true);
				estadisticaEquipo.setLocationRelativeTo(null);
				estadisticaEquipo.setVisible(true);
			}
		});
		mnEstadisticas.add(mntmEstadisticaDelEquipo);
		
		JMenuItem mntmEstadisticaDelJugador = new JMenuItem("Estadistica Del Jugador");
		mntmEstadisticaDelJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EstadisticaJugador miestaJuga = new EstadisticaJugador();
				miestaJuga.setModal(true);
				miestaJuga.setLocationRelativeTo(null);
				miestaJuga.setVisible(true);
			}
		
		});
		mnEstadisticas.add(mntmEstadisticaDelJugador);
		
		JMenuItem mntmEstadisticaDelPartido = new JMenuItem("Estadistica Del Partido");
		mntmEstadisticaDelPartido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EstadisticaPartido miestPartido = new EstadisticaPartido();
				miestPartido.setModal(true);
				miestPartido.setLocationRelativeTo(null);
				miestPartido.setVisible(true);
			}
		});
		mnEstadisticas.add(mntmEstadisticaDelPartido);
		
		
		btnJuego = new JButton("Juego");
		btnJuego.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnJuego.setEnabled(false);
		if (Baloncesto.getInstance().getJuegoRecord().size()==0 && Baloncesto.getInstance().getCantJuegos()==0) {
			btnJuego.setText("Crear Torneo");
			btnJuego.setEnabled(true);
			btnReiniciarTorneo.setEnabled(false);
			btnReiniciarTorneo.setVisible(false);
		}else if (Baloncesto.getInstance().getJuegoRecord().size()!=Baloncesto.getInstance().getCantJuegos() && Baloncesto.getInstance().isEnJuego()==false) {
			btnJuego.setText("Iniciar\n Juego");
			btnReiniciarTorneo.setEnabled(true);
			btnReiniciarTorneo.setVisible(true);
		}else if (Baloncesto.getInstance().getJuegoRecord().size()!=Baloncesto.getInstance().getCantJuegos() && Baloncesto.getInstance().isEnJuego()==true) {
			btnJuego.setText("Renaudar\n Juego");
			btnJuego.setEnabled(true);
			btnReiniciarTorneo.setEnabled(true);
			btnReiniciarTorneo.setVisible(true);
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
					btnReiniciarTorneo.setVisible(false);
					
					btnCrear.setEnabled(true);
					lblIngreseLaFecha.setEnabled(true);
					lblAo.setEnabled(true);
					lblDa.setEnabled(true);
					lblMes.setEnabled(true);
					spinnerAno.setEnabled(true);
					spinnerDia.setEnabled(true);
					spinnerMes.setEnabled(true);
					
				}else if (btnJuego.getText().toString().equalsIgnoreCase("Iniciar\n Juego") && Baloncesto.getInstance().isEnJuego()==false) {
					panelMenuPrinc.setVisible(false);
					panelInicioJuego.setVisible(true);
					btnCambio.setVisible(true);
					btnFin.setVisible(true);
					btnDoble.setVisible(true);
					btnFalta.setVisible(true);
					btnLibre.setVisible(true);
					btnTriple.setVisible(true);
					buttonBackSpace.setVisible(true);
					buttonBackSpace.setEnabled(true);
					btnJuego.setText("Renaudar\n Juego");
					asignarPuestJugador(0);
					asignarPuestJugador(1);
					cargarTabla(0);
					cargarTabla(1);
					cargarPantalla(0);
					cargarPantalla(1);
					lblEquipo1.setText(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[0].getNombre());
					lblEquipo2.setText(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[1].getNombre());

					Icon icono = new ImageIcon(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[0].getLogo().getImage().getScaledInstance(lblLogoequipo11.getWidth(), lblLogoequipo11.getHeight(), Image.SCALE_DEFAULT));
					lblLogoequip.setIcon(icono);
					lblLogoequip.setText(null);
					Icon icono1 = new ImageIcon(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[1].getLogo().getImage().getScaledInstance(lblLogoequipo22.getWidth(), lblLogoequipo22.getHeight(), Image.SCALE_DEFAULT));
					lblLogoequip2.setIcon(icono1);
					lblLogoequip2.setText(null);
					Baloncesto.getInstance().setEnJuego(true);
				}else if (btnJuego.getText().toString().equalsIgnoreCase("Renaudar\n Juego") && Baloncesto.getInstance().isEnJuego()==true) {
					
					panelMenuPrinc.setVisible(false);
					panelInicioJuego.setVisible(true);
					btnCambio.setVisible(true);
					btnFin.setVisible(true);
					btnDoble.setVisible(true);
					btnFalta.setVisible(true);
					btnLibre.setVisible(true);
					btnTriple.setVisible(true);
					cargarTabla(0);
					cargarTabla(1);
					cargarPantalla(0);
					cargarPantalla(1);
					lblEquipo1.setText(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[0].getNombre());
					lblEquipo2.setText(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[1].getNombre());

					Icon icono = new ImageIcon(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[0].getLogo().getImage().getScaledInstance(lblLogoequipo11.getWidth(), lblLogoequipo11.getHeight(), Image.SCALE_DEFAULT));
					lblLogoequip.setIcon(icono);
					lblLogoequip.setText(null);
					Icon icono1 = new ImageIcon(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[1].getLogo().getImage().getScaledInstance(lblLogoequipo22.getWidth(), lblLogoequipo22.getHeight(), Image.SCALE_DEFAULT));
					lblLogoequip2.setIcon(icono1);
					lblLogoequip2.setText(null);
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
		btnJuego.setBounds(551, 221, 197, 197);
		Icon iconn = new ImageIcon(new ImageIcon(Principal.class.getResource("/imagen/botoninhhddddddddddddd1221i.gif")).getImage().getScaledInstance(187, 161, Image.SCALE_DEFAULT));
		
		btnJuego.setIcon(iconn);
		btnJuego.setFont(new Font("Swis721 BdCnOul BT", Font.PLAIN, 24));
		
		
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
		lblLogoequipo11.setBounds(35, 35, 183, 178);
		panelEquipoAJugar.add(lblLogoequipo11);
		
		lblLogoequipo22 = new JLabel("logoEquipo2");
		lblLogoequipo22.setForeground(Color.WHITE);
		lblLogoequipo22.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogoequipo22.setBounds(562, 35, 183, 178);
		panelEquipoAJugar.add(lblLogoequipo22);
		
		
		
		lblNombre1 = new JLabel("nombre1");
		lblNombre1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre1.setForeground(Color.WHITE);
		lblNombre1.setFont(new Font("Alien Encounters", Font.PLAIN, 18));
		lblNombre1.setBounds(0, 233, 263, 33);
		panelEquipoAJugar.add(lblNombre1);
		
		lblNombre2 = new JLabel("nombre2");
		lblNombre2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre2.setForeground(Color.WHITE);
		lblNombre2.setFont(new Font("Alien Encounters", Font.PLAIN, 18));
		lblNombre2.setBounds(534, 233, 246, 33);
		panelEquipoAJugar.add(lblNombre2);
		
		lblHoyFecha = new JLabel("example");
		menuPrincipalJuegoMostrar();
		
		lblHoyFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoyFecha.setFont(new Font("2015 Cruiser Hollow", Font.BOLD, 34));
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
					btnReiniciarTorneo.setEnabled(true);
					btnReiniciarTorneo.setVisible(true);
					
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
					}else if (Baloncesto.getInstance().getJuegoRecord().size()!=Baloncesto.getInstance().getCantJuegos() && Baloncesto.getInstance().isEnJuego()==false) {
						btnJuego.setText("Iniciar\n Juego");
					}else if (Baloncesto.getInstance().getJuegoRecord().size()!=Baloncesto.getInstance().getCantJuegos() && Baloncesto.getInstance().isEnJuego()==true) {
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
		
		fondoPrin.setBounds(0, 21, 1340, 741);
Icon icon1o = new ImageIcon(new ImageIcon(Principal.class.getResource("/imagen/videoplayback.gif")).getImage().getScaledInstance(fondoPrin.getWidth(), fondoPrin.getHeight(), Image.SCALE_DEFAULT));
		
		fondoPrin.setIcon(icon1o);
		panelMenuPrinc.add(fondoPrin);
		
		
		/*
		
		panelInicioJuego = new JPanel();
		panelInicioJuego.setBounds(5, 5, 1340, 792);
		//panelInicioJuego.setVisible(false);
		//panelInicioJuego.setEnabled(false);
		contentPane.add(panelInicioJuego);;
		panelInicioJuego.setLayout(null);
		{
			lblPivot = new JLabel("Example");
			lblPivot.setIcon(new ImageIcon(Principal.class.getResource("/imagen/usuario.png")));
			lblPivot.setBounds(408, 574, 73, 34);
			panelInicioJuego.add(lblPivot);
			
			lblPivotequip2 = new JLabel("Example");
			lblPivotequip2.setIcon(new ImageIcon(Principal.class.getResource("/imagen/usuario.png")));
			lblPivotequip2.setBounds(882, 574, 73, 34);
			panelInicioJuego.add(lblPivotequip2);
			
			lblAlas_Pivot = new JLabel("Example");
			lblAlas_Pivot.setIcon(new ImageIcon(Principal.class.getResource("/imagen/usuario.png")));
			lblAlas_Pivot.setBounds(471, 631, 73, 38);
			panelInicioJuego.add(lblAlas_Pivot);
			
			lblAla_Pivotequip2 = new JLabel("Example");
			lblAla_Pivotequip2.setIcon(new ImageIcon(Principal.class.getResource("/imagen/usuario.png")));
			lblAla_Pivotequip2.setBounds(845, 631, 73, 38);
			panelInicioJuego.add(lblAla_Pivotequip2);
			
			lblEscolta = new JLabel("Example");
			lblEscolta.setIcon(new ImageIcon(Principal.class.getResource("/imagen/usuario.png")));
			lblEscolta.setBounds(491, 548, 73, 38);
			panelInicioJuego.add(lblEscolta);
			
			lblEscoltaequip2 = new JLabel("Example");
			lblEscoltaequip2.setIcon(new ImageIcon(Principal.class.getResource("/imagen/usuario.png")));
			lblEscoltaequip2.setBounds(766, 550, 73, 34);
			panelInicioJuego.add(lblEscoltaequip2);
			
			lblBase = new JLabel("Example");
			lblBase.setIcon(new ImageIcon(Principal.class.getResource("/imagen/usuario.png")));
			lblBase.setBounds(554, 600, 73, 34);
			panelInicioJuego.add(lblBase);
			
			lblBaseEquip2 = new JLabel("Example");
			lblBaseEquip2.setIcon(new ImageIcon(Principal.class.getResource("/imagen/usuario.png")));
			lblBaseEquip2.setBounds(722, 595, 73, 38);
			panelInicioJuego.add(lblBaseEquip2);
			
			lblAlero = new JLabel("Example");
			lblAlero.setIcon(new ImageIcon(Principal.class.getResource("/imagen/usuario.png")));
			lblAlero.setBounds(365, 660, 100, 38);
			panelInicioJuego.add(lblAlero);
			
			lblAleroequi2 = new JLabel("Example");
			lblAleroequi2.setIcon(new ImageIcon(Principal.class.getResource("/imagen/usuario.png")));
			lblAleroequi2.setBounds(899, 659, 73, 41);
			panelInicioJuego.add(lblAleroequi2);
			
		JPanel panel_equipo1 = new JPanel();
		panel_equipo1.setBounds(27, 23, 435, 506);
		panel_equipo1.setOpaque(false);
		panelInicioJuego.add(panel_equipo1);
		panel_equipo1.setLayout(null);
		
		lblEquipo1 = new JLabel("Equipo1");
		lblEquipo1.setForeground(Color.WHITE);
		lblEquipo1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEquipo1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo1.setBounds(158, 11, 131, 31);
		panel_equipo1.add(lblEquipo1);
		
		lblLogoequip = new JLabel("logo_equip1");
		lblLogoequip.setForeground(Color.WHITE);
		lblLogoequip.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogoequip.setBounds(133, 53, 177, 147);
		panel_equipo1.add(lblLogoequip);
		
		JPanel panel_jugador_principal1 = new JPanel();
		panel_jugador_principal1.setOpaque(false);
		panel_jugador_principal1.setForeground(Color.WHITE);
		panel_jugador_principal1.setBounds(42, 281, 355, 189);
		panel_equipo1.add(panel_jugador_principal1);
		panel_jugador_principal1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_equi1 = new JScrollPane();
		scrollPane_equi1.setOpaque(false);
		panel_jugador_principal1.add(scrollPane_equi1, BorderLayout.CENTER);
		
		table_Equip1 = new JTable();
		table_Equip1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table_Equip1.getSelectedRow();
				//btnIngresarAlCarro.setEnabled(true);
				//spinner.setEnabled(true);
				//btnEliminar.setEnabled(false);
				nombreJugador = (String)table_Equip1.getModel().getValueAt(index, 0);
				posisionJugador = (String)table_Equip1.getModel().getValueAt(index, 2);
				btnCambio.setEnabled(true);
				equipoSeleccionado=0;
			}
		});
		table_Equip1.setOpaque(false);
		table_Equip1.setBackground(new Color(0,0,0,0));
		//scrollPane_equi1.setColumnHeaderView(table_Equip1);
		table_Equip1.setFont(new Font("Tahoma", Font.BOLD, 13));
		table_Equip1.setDefaultRenderer(Object.class, new ImgTabla());
		((DefaultTableCellRenderer)table_Equip1.getDefaultRenderer(Object.class)).setBackground(new Color(0,0,0,0));
		table_Equip1.setGridColor(Color.WHITE);
		table_Equip1.setForeground(Color.WHITE);
		String[] header = {"Nombre","Numero", "Posición","Libre","Doble","Triple","Falta"};
		model_Equip1 = new DefaultTableModel(null,header) {
			@Override
			public boolean isCellEditable(int filas, int columnas) {
				if(columnas==8) {
					return true;
				}else {
					return false;
				}
			}
		};
		table_Equip1.setRowHeight(32);
		table_Equip1.setModel(model_Equip1);
		table_Equip1.setOpaque(false);
		try {
			cargarTabla(0);
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
		scrollPane_equi1.setBackground(new Color(0,0,0,0));
		((DefaultTableCellRenderer)table_Equip1.getDefaultRenderer(Object.class)).setOpaque(false);
		table_Equip1.setShowGrid(true);
		scrollPane_equi1.setViewportView(table_Equip1);
		scrollPane_equi1.getViewport().setOpaque(false);
		scrollPane_equi1.setOpaque(false);
		
		JLabel lblJugadoresEnJuego = new JLabel("Jugadores En juego");
		lblJugadoresEnJuego.setForeground(Color.WHITE);
		lblJugadoresEnJuego.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugadoresEnJuego.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblJugadoresEnJuego.setBounds(123, 232, 200, 31);
		panel_equipo1.add(lblJugadoresEnJuego);
		
		JPanel panel_equipo2 = new JPanel();
		panel_equipo2.setOpaque(false);
		panel_equipo2.setBounds(863, 23, 447, 506);
		panelInicioJuego.add(panel_equipo2);
		panel_equipo2.setLayout(null);
		
		lblEquipo2 = new JLabel("Equipo1");
		lblEquipo2.setForeground(Color.WHITE);
		lblEquipo2.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEquipo2.setBounds(160, 11, 131, 31);
		panel_equipo2.add(lblEquipo2);
		
		lblLogoequip2 = new JLabel("logo_equip2");
		lblLogoequip2.setForeground(Color.WHITE);
		lblLogoequip2.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogoequip2.setBounds(136, 53, 177, 147);
		panel_equipo2.add(lblLogoequip2);
		
		JPanel panel_jugador_principal2 = new JPanel();
		panel_jugador_principal2.setOpaque(false);
		panel_jugador_principal2.setForeground(Color.WHITE);
		panel_jugador_principal2.setBounds(55, 281, 357, 189);
		panel_equipo2.add(panel_jugador_principal2);
		panel_jugador_principal2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_equi2 = new JScrollPane();
		scrollPane_equi2.setOpaque(false);
		panel_jugador_principal2.add(scrollPane_equi2, BorderLayout.CENTER);
		
		table__Equip2 = new JTable();
		table__Equip2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table__Equip2.getSelectedRow();
				//btnIngresarAlCarro.setEnabled(true);
				//spinner.setEnabled(true);
				//btnEliminar.setEnabled(false);
				nombreJugador = (String)table__Equip2.getModel().getValueAt(index, 0);
				posisionJugador = (String)table_Equip1.getModel().getValueAt(index, 2);
				btnCambio.setEnabled(true);
				equipoSeleccionado=1;
				
			}
		});
		table__Equip2.setVisible(true);
		table__Equip2.setOpaque(false);
		table__Equip2.setBackground(new Color(0,0,0,0));
		table__Equip2.setFont(new Font("Tahoma", Font.BOLD, 13));
		table__Equip2.setDefaultRenderer(Object.class, new ImgTabla());
		((DefaultTableCellRenderer)table__Equip2.getDefaultRenderer(Object.class)).setBackground(new Color(0,0,0,0));
		table__Equip2.setGridColor(Color.WHITE);
		table__Equip2.setForeground(Color.WHITE);
		table__Equip2.setDefaultRenderer(Object.class, new ImgTabla());
		String[] header1 = {"Nombre","Numero", "Posición","Libre","Doble","Triple","Falta"};
		model_Equip2 = new DefaultTableModel(null,header1) {
			@Override
			public boolean isCellEditable(int filas, int columnas) {
				if(columnas==8) {
					return true;
				}else {
					return false;
				}
			}
		};
		table__Equip2.setRowHeight(32);
		table__Equip2.setModel(model_Equip2);
		table__Equip2.setOpaque(false);
		try {
			cargarTabla(1);
		} catch (Exception e) {
			// TODO: handle exception
		}
		scrollPane_equi2.setBackground(new Color(0,0,0,0));
		((DefaultTableCellRenderer)table__Equip2.getDefaultRenderer(Object.class)).setOpaque(false);
		table__Equip2.setShowGrid(true);
		scrollPane_equi2.setViewportView(table__Equip2);
		scrollPane_equi2.getViewport().setOpaque(false);
		scrollPane_equi2.setOpaque(false);
		
		
		//scrollPane_equi2.setColumnHeaderView(table__Equip2);
		
		JLabel lblJugadoresEnJuego2 = new JLabel("Jugadores En juego");
		lblJugadoresEnJuego2.setForeground(Color.WHITE);
		lblJugadoresEnJuego2.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugadoresEnJuego2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblJugadoresEnJuego2.setBounds(125, 232, 200, 31);
		panel_equipo2.add(lblJugadoresEnJuego2);
		
		JLabel lblfondojuego = new JLabel("");
		lblfondojuego.setBounds(0, 5, 1340, 757);
		lblfondojuego.setHorizontalAlignment(SwingConstants.CENTER);
		lblfondojuego.setHorizontalTextPosition(SwingConstants.CENTER);
		Icon icono = new ImageIcon(new ImageIcon(Principal.class.getResource("/imagen/fondo-pvk-team-carbono-rojo-negro-1900x1092.jpg")).getImage().getScaledInstance(lblfondojuego.getWidth(), lblfondojuego.getHeight(), Image.SCALE_DEFAULT));
		
		btnTriple = new JButton("Triple");
		btnTriple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anotarPuntos(3, false);
				cargarPantalla(0);
				cargarPantalla(1);
				cargarTabla(0);
				cargarTabla(1);
				btnCambio.setEnabled(false);
			}
		});
		btnTriple.setVisible(false);
		btnTriple.setBackground(new Color(255, 99, 71));
		btnTriple.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnTriple.setBounds(744, 258, 141, 54);
		panelInicioJuego.add(btnTriple);
		
		btnDoble = new JButton("Doble");
		btnDoble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anotarPuntos(2, false);
				cargarPantalla(0);
				cargarPantalla(1);
				cargarTabla(0);
				cargarTabla(1);
				btnCambio.setEnabled(false);
			}
		});
		btnDoble.setVisible(false);
		btnDoble.setBackground(new Color(255, 99, 71));
		btnDoble.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnDoble.setBounds(593, 258, 141, 54);
		panelInicioJuego.add(btnDoble);
		
		btnLibre = new JButton("Libre");
		btnLibre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anotarPuntos(1, false);
				cargarPantalla(0);
				cargarPantalla(1);
				cargarTabla(0);
				cargarTabla(1);
				btnCambio.setEnabled(false);
			}
		});
		btnLibre.setVisible(false);
		btnLibre.setBackground(new Color(255, 99, 71));
		btnLibre.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLibre.setBounds(442, 258, 141, 54);
		panelInicioJuego.add(btnLibre);
		
		
		btnFalta = new JButton("Falta");
		btnFalta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jugador aux=anotarPuntos(1, true);
				if (aux!=null) {
					JOptionPane.showMessageDialog(null, "El jugador "+aux.getNombre()+" Ha cometido 5 falta, el jugador será expulsado del juego, por favor elegir el jugador con quien desea cambiar", "Juego En Vivo", JOptionPane.INFORMATION_MESSAGE);
					Cambios micambi= new Cambios(aux.getPosicion(), equipoSeleccionado, aux.getNombre());
					micambi.setModal(true);
					micambi.setLocationRelativeTo(null);
					micambi.setVisible(true);
				}
				cargarPantalla(0);
				cargarPantalla(1);
				cargarTabla(0);
				cargarTabla(1);
				btnCambio.setEnabled(false);
			}
		});
		btnFalta.setVisible(false);
		btnFalta.setBackground(new Color(255, 99, 71));
		btnFalta.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnFalta.setBounds(593, 323, 141, 49);
		panelInicioJuego.add(btnFalta);
		
		btnCambio = new JButton("Cambio");
		btnCambio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cambios micambi= new Cambios(posisionJugador, equipoSeleccionado, nombreJugador);
				micambi.setModal(true);
				micambi.setLocationRelativeTo(null);
				micambi.setVisible(true);
				btnCambio.setEnabled(false);
				cargarPantalla(0);
				cargarPantalla(1);
				cargarTabla(0);
				cargarTabla(1);
			}
		});
		btnCambio.setVisible(false);
		btnCambio.setEnabled(false);
		btnCambio.setBackground(new Color(255, 99, 71));
		btnCambio.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnCambio.setBounds(593, 383, 141, 49);
		panelInicioJuego.add(btnCambio);
		
		btnFin = new JButton("Fin");
		btnFin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Baloncesto.getInstance().setEnJuego(false);
				Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).setJugo(true);
				
				agregarPuntoJugador(0);
				agregarPuntoJugador(1);
				JOptionPane.showMessageDialog(null, "El ganador es "+ganadorEquipo(), "Juego En Vivo", JOptionPane.INFORMATION_MESSAGE);
				

				Baloncesto.getInstance().setCantJuegos(Baloncesto.getInstance().getCantJuegos()+1);
				btnJuego.setText("Iniciar\n Juego");
				if (Baloncesto.getInstance().getJuegoRecord().size()!=Baloncesto.getInstance().getCantJuegos() && Baloncesto.getInstance().isEnJuego()==false) {
					btnJuego.setText("Iniciar\n Juego");
				}
				menuPrincipalJuegoMostrar();
				btnJuego.setVisible(true);
				if (fechaActual.getDate()==Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getFechaJuego().getDate() && Baloncesto.getInstance().getJuegoRecord().size()!=0) {
					btnJuego.setEnabled(true);
				}else {
					btnJuego.setEnabled(false);
				}
				cargarPantalla(0);
				cargarPantalla(1);
				cargarTabla(0);
				cargarTabla(1);
				buttonBackSpace.setVisible(false);
				buttonBackSpace.setEnabled(false);
				panelMenuPrinc.setVisible(true);
				panelInicioJuego.setVisible(false);
				btnCambio.setVisible(false);
				btnFin.setVisible(false);
				btnFalta.setVisible(false);
				btnDoble.setVisible(false);
				btnFalta.setVisible(false);
				btnLibre.setVisible(false);
				btnTriple.setVisible(false);
				btnCambio.setEnabled(false);
			}
		});
		btnFin.setVisible(false);
		btnFin.setBackground(new Color(255, 99, 71));
		btnFin.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnFin.setBounds(593, 443, 141, 49);
		panelInicioJuego.add(btnFin);
		
		JLabel lblversus = new JLabel("VS");
		lblversus.setBounds(542, 23, 231, 128);
		lblversus.setForeground(Color.WHITE);
		lblversus.setFont(new Font("AbandoN", Font.PLAIN, 71));
		lblversus.setHorizontalAlignment(SwingConstants.CENTER);
		panelInicioJuego.add(lblversus);
		
		lblpuntequip1 = new JLabel("0");
		lblpuntequip1.setHorizontalAlignment(SwingConstants.CENTER);
		lblpuntequip1.setForeground(Color.WHITE);
		lblpuntequip1.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblpuntequip1.setBounds(472, 145, 111, 55);
		panelInicioJuego.add(lblpuntequip1);
		
		JLabel lblcanha = new JLabel("");
		lblcanha.setHorizontalAlignment(SwingConstants.CENTER);
		lblcanha.setBounds(333, 528, 682, 197);
		Icon iconoCancha = new ImageIcon(new ImageIcon(Principal.class.getResource("/imagen/d-basketball-field-white-background-illustration-49785575.gif")).getImage().getScaledInstance(lblcanha.getWidth(), lblcanha.getHeight(), Image.SCALE_DEFAULT));
		
		
		
		lblcanha.setIcon(iconoCancha);
		panelInicioJuego.add(lblcanha);
		
		lblpuntequip12 = new JLabel("0");
		lblpuntequip12.setHorizontalAlignment(SwingConstants.CENTER);
		lblpuntequip12.setForeground(Color.WHITE);
		lblpuntequip12.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblpuntequip12.setBounds(744, 145, 109, 55);
		panelInicioJuego.add(lblpuntequip12);
		
		buttonBackSpace = new JButton("");
		buttonBackSpace.setOpaque(false);
		buttonBackSpace.setContentAreaFilled(false);
		buttonBackSpace.setBorderPainted(false);
		buttonBackSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonBackSpace.setVisible(false);
				buttonBackSpace.setEnabled(false);
				panelMenuPrinc.setVisible(true);
				panelInicioJuego.setVisible(false);
				btnCambio.setVisible(false);
				btnFin.setVisible(false);
				btnFalta.setVisible(false);
				btnDoble.setVisible(false);
				btnFalta.setVisible(false);
				btnLibre.setVisible(false);
				btnTriple.setVisible(false);
			}
		});
		buttonBackSpace.setIcon(new ImageIcon(Principal.class.getResource("/com/sun/javafx/scene/control/skin/caspian/fxvk-backspace-button.png")));
		buttonBackSpace.setBounds(0, 5, 63, 38);
		buttonBackSpace.setVisible(false);
		buttonBackSpace.setEnabled(false);
		
		panelInicioJuego.add(buttonBackSpace);
		lblfondojuego.setIcon(icono);
		panelInicioJuego.add(lblfondojuego);
		}
		
		*/
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
	
	protected boolean asignarPuestJugador(int posi) {
		boolean listo = false;
		String[] pos = {"Base", "Escolta", "Alero", "Ala-Pivot", "Pivot"};
		boolean[] posReady = {false, false, false, false, false};
		for(int i = 0; i < 5; i++) {
		for (int k=0;k<Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[posi].getNominaJugadores().size();k++) {
			
				if(posReady[i]==false && pos[i].equalsIgnoreCase(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[posi].getNominaJugadores().get(k).getPosicion())) {
					posReady[i] = true;
					Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[posi].getNominaJugadores().get(k).setJugando(true);
				}
			}
		}
		
		for(int i = 0; i < 5; i++) {
			if(posReady[i]==true) {
				listo = true;
			}
		}
		
		return listo;
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
			}else if(fechaActual.getDate()+1==Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getFechaJuego().getDate() || (1==Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getFechaJuego().getDate() && fechaActual.getMonth()+1==Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getFechaJuego().getMonth())) {
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
			
			}else if(Baloncesto.getInstance().getJuegoRecord().size()!=0 && !btnJuego.getText().toString().equalsIgnoreCase("Renaudar\n Juego")) {
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
			
			}else if(Baloncesto.getInstance().getJuegoRecord().size()!=0) {
				int dia = Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getFechaJuego().getDate();
				int mes = Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getFechaJuego().getMonth();
				int year = Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getFechaJuego().getYear();
				panelEquipoAJugar.setVisible(true);
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
	
	private Jugador anotarPuntos(int punt, Boolean falta) {
		int i=0;
		Jugador aux = null;
		if (equipoSeleccionado!=-1) {
			while (i<Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equipoSeleccionado].getNominaJugadores().size()) {
				if (Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equipoSeleccionado].getNominaJugadores().get(i).getNombre().equalsIgnoreCase(nombreJugador)) {
					if (punt==1 && falta==false) {
						Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equipoSeleccionado].getNominaJugadores().get(i).getPuntoJugador().setTiroLibre(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equipoSeleccionado].getNominaJugadores().get(i).getPuntoJugador().getTiroLibre()+1);
					}
					if (punt==1 && falta==true) {
						Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equipoSeleccionado].getNominaJugadores().get(i).getPuntoJugador().setCantFalta(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equipoSeleccionado].getNominaJugadores().get(i).getPuntoJugador().getCantFalta()+1);
						if (Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equipoSeleccionado].getNominaJugadores().get(i).getPuntoJugador().getCantFalta()==5) {
							aux=Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equipoSeleccionado].getNominaJugadores().get(i);
						}
					}
					if (punt==2 && falta==false) {
						Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equipoSeleccionado].getNominaJugadores().get(i).getPuntoJugador().setTiroDoble(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equipoSeleccionado].getNominaJugadores().get(i).getPuntoJugador().getTiroDoble()+1);
					}
					if (punt==3 && falta==false) {
						Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equipoSeleccionado].getNominaJugadores().get(i).getPuntoJugador().setTiroTriple(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equipoSeleccionado].getNominaJugadores().get(i).getPuntoJugador().getTiroTriple()+1);
					}
				}
				i++;
			}
		}
		return aux;
	}
	
	private String ganadorEquipo() {
		String aux=null;
		String auxPerdio=null;
		int puntoEquip1=Integer.parseInt(lblpuntequip1.getText().toString());
		int puntoEquip2=Integer.parseInt(lblpuntequip12.getText().toString());
		int i=0;
		if (puntoEquip1>puntoEquip2) {
			aux = Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[0].getNombre();
			auxPerdio = Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[1].getNombre();
		}else if (puntoEquip1<puntoEquip2) {
			aux = Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[1].getNombre();
			auxPerdio = Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[0].getNombre();
		}
		
		while (i<Baloncesto.getInstance().getMisEquipos().size()) {
			if (Baloncesto.getInstance().getMisEquipos().get(i).getNombre().equalsIgnoreCase(aux)) {
				Baloncesto.getInstance().getMisEquipos().get(i).setPuntos(Baloncesto.getInstance().getMisEquipos().get(i).getPuntos()+1);
			}
			if (Baloncesto.getInstance().getMisEquipos().get(i).getNombre().equalsIgnoreCase(auxPerdio)) {
				Baloncesto.getInstance().getMisEquipos().get(i).setJuegosPerdidos(Baloncesto.getInstance().getMisEquipos().get(i).getJuegosPerdidos()+1);
			}
			i++;
		}
		
		return aux;
	}
	
	private void cargarPantalla(int sele) {
		int i=0;
		int sumaPunto=0;
		if (sele!=-1) {
			while (i<Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[sele].getNominaJugadores().size()) {
					sumaPunto+=Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[sele].getNominaJugadores().get(i).getPuntoJugador().cantPunto();
					
				i++;
			}
			if (sele==0) {
				lblpuntequip1.setText(Integer.toString(sumaPunto));
			}
			if (sele==1) {
				lblpuntequip12.setText(Integer.toString(sumaPunto));
			}
		}
		equipoSeleccionado=-1;
		nombreJugador=null;
		Baloncesto.getInstance().escribirDatos();
	}
	
	private void agregarPuntoJugador(int posi) {
		int i=0;
		while (i<Baloncesto.getInstance().getMisEquipos().size()) {
			if (Baloncesto.getInstance().getMisEquipos().get(i).getNombre().equalsIgnoreCase(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[posi].getNombre())) {
				int k=0;
				while (k<Baloncesto.getInstance().getMisEquipos().get(i).getNominaJugadores().size()) {
					int j=0;
					while (j<Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[posi].getNominaJugadores().size()) {
						if (Baloncesto.getInstance().getMisEquipos().get(i).getNominaJugadores().get(k).getNombre().equalsIgnoreCase(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[posi].getNominaJugadores().get(j).getNombre())) {
							int tiroLibre=Baloncesto.getInstance().getMisEquipos().get(i).getNominaJugadores().get(k).getPuntoJugador().getTiroLibre();
							int tiroDoble=Baloncesto.getInstance().getMisEquipos().get(i).getNominaJugadores().get(k).getPuntoJugador().getTiroDoble();
							int tiroTriple=Baloncesto.getInstance().getMisEquipos().get(i).getNominaJugadores().get(k).getPuntoJugador().getTiroTriple();
							int cantFalta=Baloncesto.getInstance().getMisEquipos().get(i).getNominaJugadores().get(k).getPuntoJugador().getCantFalta();
							
							Baloncesto.getInstance().getMisEquipos().get(i).getNominaJugadores().get(k).getPuntoJugador().setTiroLibre(tiroLibre+Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[posi].getNominaJugadores().get(j).getPuntoJugador().getTiroLibre());
							Baloncesto.getInstance().getMisEquipos().get(i).getNominaJugadores().get(k).getPuntoJugador().setTiroDoble(tiroDoble+Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[posi].getNominaJugadores().get(j).getPuntoJugador().getTiroDoble());
							Baloncesto.getInstance().getMisEquipos().get(i).getNominaJugadores().get(k).getPuntoJugador().setTiroTriple(tiroTriple+Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[posi].getNominaJugadores().get(j).getPuntoJugador().getTiroTriple());
							Baloncesto.getInstance().getMisEquipos().get(i).getNominaJugadores().get(k).getPuntoJugador().setCantFalta(cantFalta+Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[posi].getNominaJugadores().get(j).getPuntoJugador().getCantFalta());
							
						}
						j++;
					}
					k++;
				}
			}
			i++;
		}
		Baloncesto.getInstance().escribirDatos();
	}
	
	private void cargarTabla(int equip) {
		if (equip==1) {
			model_Equip2.setRowCount(0);
			fila_Equip2 = new Object[model_Equip2.getColumnCount()];
		}else if (equip==0) {
			model_Equip1.setRowCount(0);
			fila_Equip1 = new Object[model_Equip1.getColumnCount()];	
		}
		
		

		for (int i = 0; i < Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().size(); i++) {
			if (equip==1 && (Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getPosicion().equalsIgnoreCase("Base") || Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getPosicion().equalsIgnoreCase("Escolta") || Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getPosicion().equalsIgnoreCase("Alero") || Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getPosicion().equalsIgnoreCase("Ala-Pivot") || Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getPosicion().equalsIgnoreCase("Pivot")) && Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).isJugando()==true) {
				fila_Equip2[0]=Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[1].getNominaJugadores().get(i).getNombre();
				fila_Equip2[1] = Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[1].getNominaJugadores().get(i).getNumero();
				fila_Equip2[2] = Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[1].getNominaJugadores().get(i).getPosicion();
				fila_Equip2[3] = Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[1].getNominaJugadores().get(i).getPuntoJugador().getTiroLibre();
				fila_Equip2[4] = Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[1].getNominaJugadores().get(i).getPuntoJugador().getTiroDoble();
				fila_Equip2[5] = Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[1].getNominaJugadores().get(i).getPuntoJugador().getTiroTriple();
				fila_Equip2[6] = Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[1].getNominaJugadores().get(i).getPuntoJugador().getCantFalta();
				model_Equip2.addRow(fila_Equip2);
				
				//{"<Seleccione>", "Base", "Escolta", "Alero", "Ala-Pivot", "Pivot"}
				if (Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getPosicion().equalsIgnoreCase("Base")) {
					lblBaseEquip2.setText(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getNombre());
					System.out.println("Hecho");
				}
				if (Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getPosicion().equalsIgnoreCase("Escolta")) {
					lblEscoltaequip2.setText(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getNombre());
				}
				if (Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getPosicion().equalsIgnoreCase("Alero")) {
					lblAleroequi2.setText(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getNombre());
				}
				if (Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getPosicion().equalsIgnoreCase("Ala-Pivot")) {
					lblAla_Pivotequip2.setText(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getNombre());
				}
				if (Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getPosicion().equalsIgnoreCase("Pivot")) {
					lblPivotequip2.setText(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getNombre());
				}
				
	
				
			}else if (equip==0 && (Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getPosicion().equalsIgnoreCase("Base") || Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getPosicion().equalsIgnoreCase("Escolta") || Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getPosicion().equalsIgnoreCase("Alero") || Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getPosicion().equalsIgnoreCase("Ala-Pivot") || Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getPosicion().equalsIgnoreCase("Pivot")) && Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).isJugando()==true) {
				fila_Equip1[0]= Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[0].getNominaJugadores().get(i).getNombre();
				fila_Equip1[1] = Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[0].getNominaJugadores().get(i).getNumero();
				fila_Equip1[2] = Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[0].getNominaJugadores().get(i).getPosicion();
				fila_Equip1[3] = Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[0].getNominaJugadores().get(i).getPuntoJugador().getTiroLibre();
				fila_Equip1[4] = Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[0].getNominaJugadores().get(i).getPuntoJugador().getTiroDoble();
				fila_Equip1[5] = Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[0].getNominaJugadores().get(i).getPuntoJugador().getTiroTriple();
				fila_Equip1[6] = Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[0].getNominaJugadores().get(i).getPuntoJugador().getCantFalta();
				model_Equip1.addRow(fila_Equip1);
			
				
				if (Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getPosicion().equalsIgnoreCase("Base")) {
					lblBase.setText(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getNombre());
				}
				if (Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getPosicion().equalsIgnoreCase("Escolta")) {
					lblEscolta.setText(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getNombre());
				}
				if (Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getPosicion().equalsIgnoreCase("Alero")) {
					lblAlero.setText(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getNombre());
				}
				if (Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getPosicion().equalsIgnoreCase("Ala-Pivot")) {
					lblAlas_Pivot.setText(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getNombre());
				}
				if (Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getPosicion().equalsIgnoreCase("Pivot")) {
					lblPivot.setText(Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getNombre());
				}
				
				
				
			}
		}
		
		
	}
}
