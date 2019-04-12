package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logico.Baloncesto;
import logico.Equipo;
import logico.Jugador;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;

public class VerEquipo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] fila;
	private int identificador;
	private int index1;
	
	private JLabel lblTotal;
	private JLabel lblTriples;
	private JLabel lblDobles;
	private JLabel lblLibres;
	private JLabel lblNumfaltas;
	private JLabel lblAltura;
	private JLabel lblMasa;
	private JLabel lblPosiscione;
	private JLabel lblName;
	private JLabel lblNumber;
	private JLabel lblNumRebotes;
	private JLabel lblNumAsis;
	private JLabel lblNumBloq;
	private JLabel lblNumRobos;
	
	private JButton btnEliminarJugador;
	private JButton btnAadirJugador;
	private JButton btnLesiones;
	
	private boolean cambio = false;
	private JLabel lblCoach_1;
	private JTextField txtCoach;

	public VerEquipo(Equipo equipo) {
		index1 = getIndiceEquipo(equipo);
		
		setResizable(false);
		String titulo = equipo.getNombre();
		setTitle(titulo + "\r\n");
		setBounds(100, 100, 756, 507);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel Jugadores = new JPanel();
			Jugadores.setBorder(new TitledBorder(null, "Lista de jugadores:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			Jugadores.setBounds(266, 5, 228, 438);
			contentPanel.add(Jugadores);
			Jugadores.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				Jugadores.add(scrollPane, BorderLayout.CENTER);
				{
					String[] header = {"Nombre", "Número"};
					model = new DefaultTableModel(null, header){
						@Override
						public boolean isCellEditable(int filas, int columnas) {
								return false;
						}
					};
					
					table = new JTable();
					
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if(table.getSelectedRow()>=0){
								int index = table.getSelectedRow();
								identificador = (int) table.getModel().getValueAt(index, 1);
								setInfo();
								setEliminar(Baloncesto.getInstance().getMisEquipos().get(index1).getNominaJugadores().get(indexPorNumero(identificador)).getPosicion());
								btnLesiones.setEnabled(true);
							}
						}
					});
					
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table.setModel(model);
					cargarTabla();
					
					scrollPane.setViewportView(table);
				}
			}
		}
		
		JPanel InfoJugador = new JPanel();
		InfoJugador.setBorder(new TitledBorder(null, "Informaci\u00F3n del jugador seleccionado:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		InfoJugador.setBounds(504, 5, 236, 438);
		contentPanel.add(InfoJugador);
		InfoJugador.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 25, 94, 14);
		InfoJugador.add(lblNombre);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setBounds(10, 55, 94, 14);
		InfoJugador.add(lblNmero);
		
		JLabel lblPosicin = new JLabel("Posici\u00F3n:");
		lblPosicin.setBounds(10, 85, 94, 14);
		InfoJugador.add(lblPosicin);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(10, 115, 94, 14);
		InfoJugador.add(lblPeso);
		
		JLabel lblEstatura = new JLabel("Estatura:");
		lblEstatura.setBounds(10, 145, 94, 14);
		InfoJugador.add(lblEstatura);
		
		JLabel lblTirosLibres = new JLabel("Tiros Libres:");
		lblTirosLibres.setBounds(10, 175, 94, 14);
		InfoJugador.add(lblTirosLibres);
		
		JLabel lblTirosDobles = new JLabel("Tiros Dobles:");
		lblTirosDobles.setBounds(10, 205, 94, 14);
		InfoJugador.add(lblTirosDobles);
		
		lblLibres = new JLabel("<Seleccione>");
		lblLibres.setBounds(114, 175, 112, 14);
		InfoJugador.add(lblLibres);
		
		lblAltura = new JLabel("<Seleccione>");
		lblAltura.setBounds(114, 145, 112, 14);
		InfoJugador.add(lblAltura);
		
		lblMasa = new JLabel("<Seleccione>");
		lblMasa.setBounds(114, 115, 112, 14);
		InfoJugador.add(lblMasa);
		
		lblPosiscione = new JLabel("<Seleccione>");
		lblPosiscione.setBounds(114, 85, 112, 14);
		InfoJugador.add(lblPosiscione);
		
		lblName = new JLabel("<Seleccione>");
		lblName.setBounds(114, 25, 112, 14);
		InfoJugador.add(lblName);
		
		lblNumber = new JLabel("<Seleccione>");
		lblNumber.setBounds(114, 55, 112, 14);
		InfoJugador.add(lblNumber);
		
		JLabel lblTirosTriple = new JLabel("Tiros Triple:");
		lblTirosTriple.setBounds(10, 235, 94, 14);
		InfoJugador.add(lblTirosTriple);
		
		JLabel lblPuntosTotales = new JLabel("Puntos Totales:");
		lblPuntosTotales.setBounds(10, 265, 94, 14);
		InfoJugador.add(lblPuntosTotales);
		
		JLabel lblFaltas = new JLabel("Faltas:");
		lblFaltas.setBounds(10, 295, 94, 14);
		InfoJugador.add(lblFaltas);
		
		lblTotal = new JLabel("<Seleccione>");
		lblTotal.setBounds(114, 265, 112, 14);
		InfoJugador.add(lblTotal);
		
		lblTriples = new JLabel("<Seleccione>");
		lblTriples.setBounds(114, 235, 112, 14);
		InfoJugador.add(lblTriples);
		
		lblDobles = new JLabel("<Seleccione>");
		lblDobles.setBounds(114, 205, 112, 14);
		InfoJugador.add(lblDobles);
		
		lblNumfaltas = new JLabel("<Seleccione>");
		lblNumfaltas.setBounds(114, 295, 112, 14);
		InfoJugador.add(lblNumfaltas);
		
		JLabel lblRebotes = new JLabel("Rebotes:");
		lblRebotes.setBounds(10, 325, 94, 14);
		InfoJugador.add(lblRebotes);
		
		JLabel lblAsistencia = new JLabel("Asistencia:");
		lblAsistencia.setBounds(10, 355, 94, 14);
		InfoJugador.add(lblAsistencia);
		
		JLabel lblBloqueos = new JLabel("Bloqueos:");
		lblBloqueos.setBounds(10, 385, 94, 14);
		InfoJugador.add(lblBloqueos);
		
		JLabel lblRobos = new JLabel("Robos:");
		lblRobos.setBounds(10, 415, 94, 14);
		InfoJugador.add(lblRobos);
		
		lblNumRebotes = new JLabel("<Seleccione>");
		lblNumRebotes.setBounds(114, 325, 112, 14);
		InfoJugador.add(lblNumRebotes);
		
		lblNumAsis = new JLabel("<Seleccione>");
		lblNumAsis.setBounds(114, 355, 112, 14);
		InfoJugador.add(lblNumAsis);
		
		lblNumBloq = new JLabel("<Seleccione>");
		lblNumBloq.setBounds(114, 385, 112, 14);
		InfoJugador.add(lblNumBloq);
		
		lblNumRobos = new JLabel("<Seleccione>");
		lblNumRobos.setBounds(114, 415, 112, 14);
		InfoJugador.add(lblNumRobos);
		{
			JPanel InfoEquipo = new JPanel();
			InfoEquipo.setBorder(new TitledBorder(null, "Informaci\u00F3n del equipo:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			InfoEquipo.setBounds(10, 5, 246, 438);
			contentPanel.add(InfoEquipo);
			InfoEquipo.setLayout(null);
			{
				JLabel lblFoto = new JLabel("pic");
				lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
				lblFoto.setHorizontalTextPosition(SwingConstants.CENTER);
				lblFoto.setBounds(51, 97, 144, 144);
				InfoEquipo.add(lblFoto);
				
				lblFoto.setText(null);
				lblFoto.setIcon(new ImageIcon(equipo.getLogo().getImage().getScaledInstance(144, 144, Image.SCALE_DEFAULT)));
			}
			
			JLabel lblNombreEquipo = new JLabel(equipo.getNombre());
			lblNombreEquipo.setFont(new Font("Tahoma", Font.PLAIN, 23));
			lblNombreEquipo.setHorizontalAlignment(SwingConstants.CENTER);
			lblNombreEquipo.setBounds(10, 27, 226, 42);
			InfoEquipo.add(lblNombreEquipo);
			
			JLabel lblCoach = new JLabel("Coach:");
			lblCoach.setBounds(10, 298, 46, 14);
			InfoEquipo.add(lblCoach);
			
			JLabel lblCancha = new JLabel("Cancha:");
			lblCancha.setBounds(10, 337, 46, 14);
			InfoEquipo.add(lblCancha);
			
			JLabel lblCanchaE = new JLabel(equipo.getCancha());
			lblCanchaE.setBounds(66, 337, 170, 14);
			InfoEquipo.add(lblCanchaE);
			
			lblCoach_1 = new JLabel(equipo.getCoach());
			lblCoach_1.setBounds(66, 298, 170, 14);
			InfoEquipo.add(lblCoach_1);
			lblCoach_1.setEnabled(true);
			
			txtCoach = new JTextField();
			txtCoach.setEditable(false);
			txtCoach.setEnabled(false);
			txtCoach.setVisible(false);
			txtCoach.setBounds(66, 295, 170, 20);
			InfoEquipo.add(txtCoach);
			txtCoach.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				
				btnAadirJugador = new JButton("A\u00F1adir Jugador");
				btnAadirJugador.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						AñadirJugador yeet = new AñadirJugador(index1);
						yeet.setModal(true);
						yeet.setLocationRelativeTo(null);
						yeet.setVisible(true);
						Baloncesto.getInstance().escribirDatos();
						cargarTabla();
						setAnnadir();
					}
				});
				
				JButton btnCambiarCoach = new JButton("Cambiar Coach");
				btnCambiarCoach.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(cambio) {
							cambio = false;
							txtCoach.setEditable(false);
							txtCoach.setEnabled(false);
							txtCoach.setVisible(false);
							lblCoach_1.setEnabled(true);
							equipo.setCoach(txtCoach.getText());
							Baloncesto.getInstance().escribirDatos();
							lblCoach_1.setText(equipo.getCoach());
						}else {
							cambio = true;
							lblCoach_1.setEnabled(false);
							txtCoach.setEditable(true);
							txtCoach.setEnabled(true);
							txtCoach.setVisible(true);
							txtCoach.setText(equipo.getCoach());
						}
					}
				});
				
				btnLesiones = new JButton("Lesiones");
				btnLesiones.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Lesiones lesion = new Lesiones(index1, indexPorNumero(identificador));
						lesion.setModal(true);
						lesion.setLocationRelativeTo(null);
						lesion.setVisible(true);
						//Baloncesto.getInstance().escribirDatos();
						btnLesiones.setEnabled(false);
					}
				});
				btnLesiones.setEnabled(false);
				buttonPane.add(btnLesiones);
				buttonPane.add(btnCambiarCoach);
				buttonPane.add(btnAadirJugador);
				setAnnadir();
				
				btnEliminarJugador = new JButton("Eliminar Jugador");
				btnEliminarJugador.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int option = JOptionPane.showConfirmDialog(null, "¿Está segur@ que desea eliminar el jugador?","Información",JOptionPane.WARNING_MESSAGE);
						if(option == JOptionPane.OK_OPTION) {
							Baloncesto.getInstance().getMisEquipos().get(index1).getNominaJugadores().remove(indexPorNumero(identificador));
							Baloncesto.getInstance().escribirDatos();
							cargarTabla();
							btnEliminarJugador.setEnabled(false);
							btnAadirJugador.setEnabled(true);
						}
					}
				});
				btnEliminarJugador.setEnabled(false);
				buttonPane.add(btnEliminarJugador);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				
			}
		}
	}


	private void setAnnadir() {
		if(Baloncesto.getInstance().getMisEquipos().get(index1).getNominaJugadores().size() >= 15) {
			btnAadirJugador.setEnabled(false);
		}else {
			btnAadirJugador.setEnabled(true);
		}
		
	}
	
	private void setEliminar(String pos) {
		if(!checkPosJugadores(pos)) {
			btnEliminarJugador.setEnabled(false);
		}else {
			btnEliminarJugador.setEnabled(true);
		}
		
	}
	
	protected boolean checkPosJugadores(String pos) {
		boolean listo = true;
		int cant = 0;
		
		for (Jugador jugador : Baloncesto.getInstance().getMisEquipos().get(index1).getNominaJugadores()) {
			if(pos.equalsIgnoreCase(jugador.getPosicion())) {
				cant += 1;
			}
		}
		
		if(cant == 1) {
			listo = false;
		}
		
		return listo;
	}


	protected void setInfo() {
		int index2 = indexPorNumero(identificador);
		lblName.setText(Baloncesto.getInstance().getMisEquipos().get(index1).getNominaJugadores().get(index2).getNombre());
		lblNumber.setText(Integer.toString(Baloncesto.getInstance().getMisEquipos().get(index1).getNominaJugadores().get(index2).getNumero()));
		lblPosiscione.setText(Baloncesto.getInstance().getMisEquipos().get(index1).getNominaJugadores().get(index2).getPosicion());
		lblAltura.setText(Float.toString(Baloncesto.getInstance().getMisEquipos().get(index1).getNominaJugadores().get(index2).getEstatura()) + " metros");
		lblLibres.setText(Integer.toString(Baloncesto.getInstance().getMisEquipos().get(index1).getNominaJugadores().get(index2).getPuntoJugador().getTiroLibre()));
		lblDobles.setText(Integer.toString(Baloncesto.getInstance().getMisEquipos().get(index1).getNominaJugadores().get(index2).getPuntoJugador().getTiroDoble()));
		lblTriples.setText(Integer.toString(Baloncesto.getInstance().getMisEquipos().get(index1).getNominaJugadores().get(index2).getPuntoJugador().getTiroTriple()));
		lblMasa.setText(Float.toString(Baloncesto.getInstance().getMisEquipos().get(index1).getNominaJugadores().get(index2).getPeso()) + " Kg");
		lblTotal.setText(Integer.toString(Baloncesto.getInstance().getMisEquipos().get(index1).getNominaJugadores().get(index2).getPuntoJugador().cantPunto()));
		lblNumfaltas.setText(Integer.toString(Baloncesto.getInstance().getMisEquipos().get(index1).getNominaJugadores().get(index2).getPuntoJugador().getCantFalta()));
		lblNumRebotes.setText(Integer.toString(Baloncesto.getInstance().getMisEquipos().get(index1).getNominaJugadores().get(index2).getPuntoJugador().getRebotes()));
		lblNumAsis.setText(Integer.toString(Baloncesto.getInstance().getMisEquipos().get(index1).getNominaJugadores().get(index2).getPuntoJugador().getAsistencias()));
		lblNumBloq.setText(Integer.toString(Baloncesto.getInstance().getMisEquipos().get(index1).getNominaJugadores().get(index2).getPuntoJugador().getBloqueos()));
		lblNumRobos.setText(Integer.toString(Baloncesto.getInstance().getMisEquipos().get(index1).getNominaJugadores().get(index2).getPuntoJugador().getRobos()));	
	}	


	private int indexPorNumero(int identificador2) {
		int indice = -1;
		boolean encontrado = false;
		int i = 0;
		
		while(!encontrado && i < Baloncesto.getInstance().getMisEquipos().get(index1).getNominaJugadores().size()) {
			if(identificador2 == Baloncesto.getInstance().getMisEquipos().get(index1).getNominaJugadores().get(i).getNumero()) {
				indice = i;
				encontrado = true;
			}
			i++;
		}
		
		
		return indice;
	}


	private int getIndiceEquipo(Equipo equipo) {
		int index = 0;
		int i = 0;
		boolean encontrado = false;
		
		while (!encontrado && i < Baloncesto.getInstance().getMisEquipos().size()) {
			if(equipo.getNombre().equalsIgnoreCase(Baloncesto.getInstance().getMisEquipos().get(i).getNombre())) {
				encontrado = true;
				index = i;
			}
			
			i++;
		}
		
		return index;
	}

	protected void cargarTabla() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (Jugador jugador : Baloncesto.getInstance().getMisEquipos().get(index1).getNominaJugadores()) {
			fila[0] = jugador.getNombre();
			fila[1] = jugador.getNumero();
			model.addRow(fila);
		}
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(170);
		columnModel.getColumn(0).setResizable(false);
		columnModel.getColumn(1).setResizable(false);
	}
}
