package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import logico.Baloncesto;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cambios extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JPanel buttonPane;
	private JScrollPane scrollPane;
	private static DefaultTableModel model;
	private static Object[] fila;
	private JButton okButton;
	private String nombreJugador=null;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			Cambios dialog = new Cambios(null,0,null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public Cambios(String posicion, int equip,String nombreJugaAnterior) {
		setBounds(100, 100, 446, 492);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 398);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				nombreJugador = (String)table.getModel().getValueAt(index, 0);
				okButton.setEnabled(true);
			}
		});
		table.setVisible(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table.setDefaultRenderer(Object.class, new ImgTabla());
		((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setBackground(new Color(0,0,0,0));
		table.setGridColor(Color.BLACK);
		table.setForeground(Color.BLACK);
		table.setDefaultRenderer(Object.class, new ImgTabla());
		String[] header =  {"Nombre","Numero", "Posición","Libre","Doble","Triple","Falta"};
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
		
		table.setRowHeight(32);
		
		table.setModel(model);
		table.setOpaque(false);
		cargarTabla(equip,posicion);
		scrollPane.setBackground(new Color(0,0,0,0));
		((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
		table.setShowGrid(true);
		scrollPane.setViewportView(table);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Cambiar");
				okButton.setEnabled(false);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						for (int i = 0; i < Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().size() ; i++) {
							if (Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getNombre().equalsIgnoreCase(nombreJugaAnterior)) {
								Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).setJugando(false);
							}
							if (Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getNombre().equalsIgnoreCase(nombreJugador)) {
								Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).setJugando(true);
							}
						}
						JOptionPane.showMessageDialog(null, "Cambio realizado", "Cambio De Jugador", JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
				});
				okButton.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	private void cargarTabla(int equip, String poos) {


			model.setRowCount(0);
			fila= new Object[model.getColumnCount()];	

		
		

		for (int i = 0; i < Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().size(); i++) {
			if ((Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getPosicion().equalsIgnoreCase(poos)) && Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).isJugando()==false && Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getPuntoJugador().getCantFalta()!=5) {
				fila[0]=Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getNombre();
				fila[1] = Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getNumero();
				fila[2] = Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getPosicion();
				fila[3] = Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getPuntoJugador().getTiroLibre();
				fila[4] = Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getPuntoJugador().getTiroDoble();
				fila[5] = Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getPuntoJugador().getTiroTriple();
				fila[6] = Baloncesto.getInstance().getJuegoRecord().get(Baloncesto.getInstance().getCantJuegos()).getEquipoJuego()[equip].getNominaJugadores().get(i).getPuntoJugador().getCantFalta();
				model.addRow(fila);
				
				
			}
		}
		
		
	}
}
