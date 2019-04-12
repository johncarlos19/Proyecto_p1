package visual;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logico.Baloncesto;
import logico.Juego;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.util.Date;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EstadisticaPartido extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JScrollPane scrollPane;
	private static DefaultTableModel model;
	private static Object[] fila;
	private Date fechaActual = new Date();
	private JLabel lblLogoequipo;
	private JLabel lblLogoequipo_1;
	private String nombreEquipo1=null;
	private String nombreEquipo2=null;
	private JLabel lblpunto2;
	private JLabel lblpunto1; 
	private JLabel lblTriple;
	private JLabel lblTriple1;
	private JLabel lblTriple2;
	private JLabel lblDoble1;
	private JLabel lblDoble2;
	private JLabel lblLibre2;
	private JLabel lblLibre1;
	private JLabel lblMejoresJugadores;
	private JLabel lblJugador1;
	private JLabel lblJugador2;
	private JLabel lblPuntoJugador;
	private JLabel lblPuntoJugador2;
	private JLabel lblAsisequip1;
	private JLabel lblAsistencia;
	private JLabel lblAsisequip2;
	private JLabel lblReboteequip1;
	private JLabel lblReboteequip2;
	
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			EstadisticaPartido dialog = new EstadisticaPartido();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public EstadisticaPartido() {
		setTitle("Estadistica Del Partido");
		setBounds(100, 100, 332, 553);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setResizable(false);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 11, 302, 459);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane, BorderLayout.CENTER);
				
				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int index = table.getSelectedRow();
						//btnIngresarAlCarro.setEnabled(true);
						//spinner.setEnabled(true);
						//btnEliminar.setEnabled(false);
						nombreEquipo1 = ((JLabel)table.getModel().getValueAt(index, 0)).getText().toString();
						nombreEquipo2 = ((JLabel)table.getModel().getValueAt(index, 2)).getText().toString();
						cargarPanel();
						setBounds(100, 100, 891, 553);

					}
				});
				table.setVisible(true);
				table.setFont(new Font("Tahoma", Font.PLAIN, 18));
				table.setDefaultRenderer(Object.class,new ImgTabla11());
				((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setBackground(new Color(0,0,0,0));
				table.setGridColor(Color.black);
				table.setForeground(Color.black);
				table.setDefaultRenderer(Object.class, new ImgTabla11());
				String[] header = {"","", ""};
				model = new DefaultTableModel(null,header) {
					@Override
					public boolean isCellEditable(int filas, int columnas) {
						if(columnas==4) {
							return true;
						}else {
							return false;
						}
					}
				};
				
				table.setRowHeight(46);
				table.setModel(model);
				table.setOpaque(false);
				cargarTabla();
				scrollPane.setBackground(Color.BLACK);
				//((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
				table.setShowGrid(true);
				scrollPane.setViewportView(table);
				//scrollPane.getViewport().setOpaque(false);
				scrollPane.setOpaque(false);
				//scrollPane.setColumnHeaderView(table);
			}
		}
		
		JPanel panelEquipo = new JPanel();
		panelEquipo.setBounds(322, 11, 543, 459);
		contentPanel.add(panelEquipo);
		panelEquipo.setLayout(null);
		
		lblLogoequipo = new JLabel("logoEquipo1");
		lblLogoequipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogoequipo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLogoequipo.setBounds(24, 22, 132, 121);
		panelEquipo.add(lblLogoequipo);
		
		lblLogoequipo_1 = new JLabel("logoEquipo2");
		lblLogoequipo_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogoequipo_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLogoequipo_1.setBounds(401, 22, 132, 121);
		panelEquipo.add(lblLogoequipo_1);
		
		JLabel lblVs = new JLabel("VS");
		lblVs.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblVs.setBounds(254, 11, 39, 40);
		panelEquipo.add(lblVs);
		
		lblpunto2 = new JLabel("0");
		lblpunto2.setHorizontalAlignment(SwingConstants.CENTER);
		lblpunto2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblpunto2.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblpunto2.setBounds(343, 52, 51, 40);
		panelEquipo.add(lblpunto2);
		
		lblpunto1 = new JLabel("0");
		lblpunto1.setHorizontalAlignment(SwingConstants.CENTER);
		lblpunto1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblpunto1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblpunto1.setBounds(156, 52, 51, 40);
		panelEquipo.add(lblpunto1);
		
		 lblTriple = new JLabel("Triple");
		 lblTriple.setHorizontalAlignment(SwingConstants.CENTER);
		lblTriple.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTriple.setBounds(242, 103, 63, 32);
		panelEquipo.add(lblTriple);
		
		lblTriple1 = new JLabel("0");
		lblTriple1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTriple1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTriple1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTriple1.setBounds(162, 103, 39, 40);
		panelEquipo.add(lblTriple1);
		
		 lblTriple2 = new JLabel("0");
		lblTriple2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTriple2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTriple2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTriple2.setBounds(349, 103, 39, 40);
		panelEquipo.add(lblTriple2);
		
		 lblDoble1 = new JLabel("0");
		lblDoble1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDoble1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDoble1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoble1.setBounds(162, 162, 39, 40);
		panelEquipo.add(lblDoble1);
		
		JLabel lblDoble = new JLabel("Doble");
		lblDoble.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoble.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDoble.setBounds(242, 162, 63, 32);
		panelEquipo.add(lblDoble);
		
		 lblDoble2 = new JLabel("0");
		lblDoble2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDoble2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDoble2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoble2.setBounds(349, 162, 39, 40);
		panelEquipo.add(lblDoble2);
		
		 lblLibre1 = new JLabel("0");
		lblLibre1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLibre1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLibre1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLibre1.setBounds(162, 213, 39, 40);
		panelEquipo.add(lblLibre1);
		
		JLabel lblLibre = new JLabel("Libre");
		lblLibre.setHorizontalAlignment(SwingConstants.CENTER);
		lblLibre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLibre.setBounds(248, 213, 51, 32);
		panelEquipo.add(lblLibre);
		
		 lblLibre2 = new JLabel("0");
		lblLibre2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLibre2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLibre2.setHorizontalAlignment(SwingConstants.CENTER);
		lblLibre2.setBounds(349, 213, 39, 40);
		panelEquipo.add(lblLibre2);
		
		lblMejoresJugadores = new JLabel("Mejores Jugadores");
		lblMejoresJugadores.setHorizontalAlignment(SwingConstants.CENTER);
		lblMejoresJugadores.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMejoresJugadores.setBounds(188, 366, 171, 22);
		panelEquipo.add(lblMejoresJugadores);
		
		lblJugador1 = new JLabel("lJugador1");
		lblJugador1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblJugador1.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugador1.setBounds(30, 366, 122, 22);
		panelEquipo.add(lblJugador1);
		
		lblJugador2 = new JLabel("lJugador1");
		lblJugador2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblJugador2.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugador2.setBounds(397, 366, 122, 22);
		panelEquipo.add(lblJugador2);
		
		lblPuntoJugador = new JLabel("0");
		lblPuntoJugador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPuntoJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntoJugador.setBounds(69, 397, 46, 32);
		panelEquipo.add(lblPuntoJugador);
		
		lblPuntoJugador2 = new JLabel("0");
		lblPuntoJugador2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntoJugador2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPuntoJugador2.setBounds(434, 397, 46, 32);
		panelEquipo.add(lblPuntoJugador2);
		
		lblReboteequip1 = new JLabel("0");
		lblReboteequip1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblReboteequip1.setHorizontalAlignment(SwingConstants.CENTER);
		lblReboteequip1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblReboteequip1.setBounds(162, 264, 39, 40);
		panelEquipo.add(lblReboteequip1);
		
		JLabel lblRebote = new JLabel("Rebote");
		lblRebote.setHorizontalAlignment(SwingConstants.CENTER);
		lblRebote.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRebote.setBounds(239, 264, 69, 32);
		panelEquipo.add(lblRebote);
		
		lblReboteequip2 = new JLabel("0");
		lblReboteequip2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblReboteequip2.setHorizontalAlignment(SwingConstants.CENTER);
		lblReboteequip2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblReboteequip2.setBounds(349, 264, 39, 40);
		panelEquipo.add(lblReboteequip2);
		
		lblAsisequip1 = new JLabel("0");
		lblAsisequip1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAsisequip1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAsisequip1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAsisequip1.setBounds(162, 315, 39, 40);
		panelEquipo.add(lblAsisequip1);
		
		lblAsistencia = new JLabel("Asistencia");
		lblAsistencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblAsistencia.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAsistencia.setBounds(223, 315, 100, 32);
		panelEquipo.add(lblAsistencia);
		
		lblAsisequip2 = new JLabel("0");
		lblAsisequip2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAsisequip2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAsisequip2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAsisequip2.setBounds(349, 315, 39, 40);
		panelEquipo.add(lblAsisequip2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	private void cargarPanel() {
		int i=0;
		Juego aux = null;
		while (i<Baloncesto.getInstance().getCantJuegos()) {
			if (Baloncesto.getInstance().getJuegoRecord().get(i).getEquipoJuego()[0].getNombre().equalsIgnoreCase(nombreEquipo1) && Baloncesto.getInstance().getJuegoRecord().get(i).getEquipoJuego()[1].getNombre().equalsIgnoreCase(nombreEquipo2)) {
			aux=Baloncesto.getInstance().getJuegoRecord().get(i);	
			}
			i++;
		}
		Icon icono111 = new ImageIcon(aux.getEquipoJuego()[0].getLogo().getImage().getScaledInstance(lblLogoequipo.getWidth(),lblLogoequipo.getHeight(), Image.SCALE_DEFAULT));
		lblLogoequipo.setIcon(icono111);
		lblLogoequipo.setText(null);
		Icon icono1111 = new ImageIcon(aux.getEquipoJuego()[1].getLogo().getImage().getScaledInstance(lblLogoequipo_1.getWidth(),lblLogoequipo_1.getHeight(), Image.SCALE_DEFAULT));
		lblLogoequipo_1.setIcon(icono1111);
		lblLogoequipo_1.setText(null);
		lblpunto1.setText(Integer.toString(aux.getEquipoJuego()[0].cantPuntoDelEquipo()));
		lblpunto2.setText(Integer.toString(aux.getEquipoJuego()[1].cantPuntoDelEquipo()));
		lblTriple1.setText(Integer.toString(aux.getEquipoJuego()[0].cantTiro(3)));
		lblTriple2.setText(Integer.toString(aux.getEquipoJuego()[1].cantTiro(3)));
		lblDoble1.setText(Integer.toString(aux.getEquipoJuego()[0].cantTiro(2)));
		lblDoble2.setText(Integer.toString(aux.getEquipoJuego()[1].cantTiro(2)));
		lblLibre1.setText(Integer.toString(aux.getEquipoJuego()[0].cantTiro(1)));
		lblLibre2.setText(Integer.toString(aux.getEquipoJuego()[1].cantTiro(1)));
		lblAsisequip1.setText(Integer.toString(aux.getEquipoJuego()[0].cantTiro(5)));
		lblAsisequip2.setText(Integer.toString(aux.getEquipoJuego()[1].cantTiro(5)));
		lblReboteequip1.setText(Integer.toString(aux.getEquipoJuego()[0].cantTiro(4)));
		lblReboteequip2.setText(Integer.toString(aux.getEquipoJuego()[1].cantTiro(4)));
		lblJugador1.setText(mejorJugador(0, aux));
		lblJugador2.setText(mejorJugador(1, aux));

	}
	private void cargarTabla() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (int i = 0; i < Baloncesto.getInstance().getCantJuegos(); i++) {
			//
					//.getImage().getScaledInstance(ColumnConst, lblLogoequipo11.getHeight(), Image.SCALE_DEFAULT));
			Icon icono111 = new ImageIcon(Baloncesto.getInstance().getJuegoRecord().get(i).getEquipoJuego()[0].getLogo().getImage().getScaledInstance(32,32, Image.SCALE_DEFAULT));
			JLabel log = new JLabel(Baloncesto.getInstance().getJuegoRecord().get(i).getEquipoJuego()[0].getNombre());
			log.setIcon(icono111);
			log.setForeground(Color.black);
			log.setBackground(Color.black);

			log.setHorizontalAlignment(SwingConstants.CENTER);
			log.setHorizontalTextPosition(SwingConstants.CENTER);
			log.setVerticalTextPosition(SwingConstants.BOTTOM);
			Icon icono222 = new ImageIcon(Baloncesto.getInstance().getJuegoRecord().get(i).getEquipoJuego()[1].getLogo().getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
			JLabel log1 = new JLabel(Baloncesto.getInstance().getJuegoRecord().get(i).getEquipoJuego()[1].getNombre());
			log1.setIcon(icono222);
			log1.setVerticalTextPosition(SwingConstants.BOTTOM);
			log1.setHorizontalAlignment(SwingConstants.CENTER);
			log1.setForeground(Color.black);
			log1.setBackground(Color.black);
			log1.setHorizontalTextPosition(SwingConstants.CENTER);
			JLabel fecha = new JLabel();
			fecha.setText(Baloncesto.getInstance().getJuegoRecord().get(i).getFechaJuego().getDate()+"/"+Baloncesto.getInstance().getJuegoRecord().get(i).getFechaJuego().getMonth()+"/"+(Baloncesto.getInstance().getJuegoRecord().get(i).getFechaJuego().getYear()));
			fecha.setHorizontalAlignment(SwingConstants.CENTER);
			fecha.setHorizontalTextPosition(SwingConstants.CENTER);
			fecha.setForeground(Color.black);
			fecha.setBackground(Color.black);

			fila[0]= log;
			/*if (fechaActual.getDate()==Baloncesto.getInstance().getJuegoRecord().get(i).getFechaJuego().getDate()) {
				fecha.setText("Hoy");
				fila[1] = fecha;
			}else if(fechaActual.getDate()+1==Baloncesto.getInstance().getJuegoRecord().get(i).getFechaJuego().getDate()) {
				fecha.setText("Mañana");
				fila[1] = fecha;
			}else {*/
				fila[1] = fecha;
			//}
			fila[2] = log1;
			model.addRow(fila);
		}
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(100);
		columnModel.getColumn(1).setPreferredWidth(100);
		columnModel.getColumn(2).setPreferredWidth(100);
		columnModel.getColumn(0).setResizable(false);
		columnModel.getColumn(1).setResizable(false);
		columnModel.getColumn(2).setResizable(false);
		
	}
	
	private String mejorJugador(int posi,Juego auxJueg) {
		int cant=0,i=0;
		String nombre1=null;
		while (i<auxJueg.getEquipoJuego()[posi].getNominaJugadores().size()) {
			if (auxJueg.getEquipoJuego()[posi].getNominaJugadores().get(i).getPuntoJugador().cantPunto()>cant) {
				cant=auxJueg.getEquipoJuego()[posi].getNominaJugadores().get(i).getPuntoJugador().cantPunto();
				nombre1=auxJueg.getEquipoJuego()[posi].getNominaJugadores().get(i).getNombre();
			}
			i++;
		}
		if (posi==0) {
			lblPuntoJugador.setText(Integer.toString(cant)+"/"+Integer.toString(auxJueg.getEquipoJuego()[0].cantPuntoDelEquipo()));
		}else {
			lblPuntoJugador2.setText(Integer.toString(cant)+"/"+Integer.toString(auxJueg.getEquipoJuego()[1].cantPuntoDelEquipo()));
		}
		
		
		return nombre1;
	}
	
	private class ImgTabla11 extends DefaultTableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
			if (o instanceof JLabel) {
				JLabel lbl = (JLabel)o;
				lbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lbl.setBackground(Color.BLACK);
				lbl.setForeground(Color.BLACK);
				lbl.setOpaque(false);
				return lbl;
			}
			
			return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
		}

		
	}
}
