package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

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

public class VerEquipo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] fila;
	private String identificador = "";
	private int index;

	public VerEquipo(Equipo equipo) {
		index = getIndiceEquipo(equipo);
		
		setResizable(false);
		String titulo = equipo.getNombre();
		setTitle(titulo + "\r\n");
		setBounds(100, 100, 630, 404);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					String[] header = {"Nombre", "Número", "Poscición", "Estatura", "Peso"};
					model = new DefaultTableModel();
					model.setColumnIdentifiers(header);
					
					table = new JTable();
					
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if(table.getSelectedRow()>=0){
								//btnVer.setEnabled(true);
								int index = table.getSelectedRow();
								identificador = (String)table.getModel().getValueAt(index, 0);
							}
						}
					});
					
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table.setModel(model);
					cargarTabla(index);
					
					scrollPane.setViewportView(table);
				}
			}
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
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
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

	protected void cargarTabla(int index) {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (Jugador jugador : Baloncesto.getInstance().getMisEquipos().get(index).getNominaJugadores()) {
			fila[0] = jugador.getNombre();
			fila[1] = jugador.getNumero();
			fila[2] = jugador.getPosicion();
			fila[3] = Float.toString(jugador.getEstatura()) + " metros";
			fila[4] = Float.toString(jugador.getPeso()) + " kilogramos";
			model.addRow(fila);
		}
	}
}
