package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Baloncesto;
import logico.Equipo;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarEquipos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] fila;
	private String identificador = "";
	
	private JButton btnVer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarEquipos dialog = new ListarEquipos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarEquipos() {
		setTitle("Listar Equipos");
		setResizable(false);
		setBounds(100, 100, 705, 496);
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
					String[] header = {"Nombre", "Coach", "Cancha"};
					model = new DefaultTableModel();
					model.setColumnIdentifiers(header);
					
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if(table.getSelectedRow()>=0){
								btnVer.setEnabled(true);
								int index = table.getSelectedRow();
								identificador = (String)table.getModel().getValueAt(index, 0);
				
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
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSalir = new JButton("Salir");
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				{
					btnVer = new JButton("Ver");
					btnVer.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(!identificador.equalsIgnoreCase("")){
								VerEquipo ver = new VerEquipo(buscarEquipoPorNombre(identificador));
								ver.setModal(true);
								ver.setVisible(true);
							}
						}
					});
					btnVer.setEnabled(false);
					buttonPane.add(btnVer);
				}
				buttonPane.add(btnSalir);
			}
		}
	}
	
	protected Equipo buscarEquipoPorNombre(String identificador2) {
		Equipo aux = null;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i < Baloncesto.getInstance().getMisEquipos().size()) {
			if(Baloncesto.getInstance().getMisEquipos().get(i).getNombre().equalsIgnoreCase(identificador2)) {
				encontrado = true;
				aux = Baloncesto.getInstance().getMisEquipos().get(i);
			}
			i++;
		}
		return aux;
	}

	private void cargarTabla() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (int i = 0; i < Baloncesto.getInstance().getMisEquipos().size(); i++) {
			fila[0] = Baloncesto.getInstance().getMisEquipos().get(i).getNombre();
			fila[1] = Baloncesto.getInstance().getMisEquipos().get(i).getCoach();
			fila[2] = Baloncesto.getInstance().getMisEquipos().get(i).getCancha();
			model.addRow(fila);
		}
		
	}
}
