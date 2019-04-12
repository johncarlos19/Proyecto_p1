package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import javafx.scene.layout.ColumnConstraints;
import logico.Baloncesto;
import logico.Equipo;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ListarEquipos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] fila;
	private String identificador = "";
	
	private JButton btnVer;

	public ListarEquipos() {
		setTitle("Listar Equipos");
		setResizable(false);
		setBounds(100, 100, 790, 496);
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
					
					//model.setColumnIdentifiers(header);
					//model.set
					table = new JTable();
					
					
					table.setFont(new Font("Tahoma", Font.PLAIN, 18));
					table.setDefaultRenderer(Object.class, new ImgTabla());
					String[] header = {"Logo","Nombre", "Coach", "Cancha"};
					//Icon icono11 = new ImageIcon(Baloncesto.getInstance().getMisEquipos().get(0).getLogo().getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
					
					model = new DefaultTableModel(null, header){
						@Override
						public boolean isCellEditable(int filas, int columnas) {
								return false;
						}
					};
					
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if(table.getSelectedRow()>=0){
								btnVer.setEnabled(true);
								int index = table.getSelectedRow();
								identificador = (String)table.getModel().getValueAt(index, 1);
								//identificador = ((JLabel)table.getModel().getValueAt(index, 1)).getText();

							}
						}
					});
					
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					
					//table.setValueAt(icono11, 1, 1);
					table.setRowHeight(40);
					table.setModel(model);
					table.setOpaque(false);
					cargarTabla();
					scrollPane.setViewportView(table);
					scrollPane.setOpaque(false);
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
							
							cargarTabla();
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
			//
					//.getImage().getScaledInstance(ColumnConst, lblLogoequipo11.getHeight(), Image.SCALE_DEFAULT));
			Icon icono111 = new ImageIcon(Baloncesto.getInstance().getMisEquipos().get(i).getLogo().getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
			//JLabel log = ;
			fila[0]=new JLabel(icono111);
			fila[1] = Baloncesto.getInstance().getMisEquipos().get(i).getNombre();
			fila[2] = Baloncesto.getInstance().getMisEquipos().get(i).getCoach();
			fila[3] = Baloncesto.getInstance().getMisEquipos().get(i).getCancha();
			model.addRow(fila);
			
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			table.getTableHeader().setReorderingAllowed(false);
			TableColumnModel columnModel = table.getColumnModel();
			columnModel.getColumn(0).setResizable(false);
			columnModel.getColumn(1).setResizable(false);
			columnModel.getColumn(2).setResizable(false);
			columnModel.getColumn(3).setResizable(false);
		}
		
		
	}
}
