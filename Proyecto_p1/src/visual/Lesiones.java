package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import logico.Baloncesto;
import logico.Jugador;
import logico.Lesion;

import javax.swing.SpinnerNumberModel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Lesiones extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private Date fecha_actual = new Date();
	
	private int indexEquipo;
	private int indexJugador;
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] fila;
	private int identificador;
	
	private JSpinner spinnerdia;
	private JSpinner spinnermes;
	private JSpinner spinnerano;
	private JComboBox cbxtipo;
	private JTextArea txtDetalles;
	private JButton btnEliminar;
	
	private boolean agregando = false;
	
	private static Date fechaActual = new Date();
	

	public Lesiones(int indexEquipo, int indexJugador) {
		this.indexEquipo = indexEquipo;
		this.indexJugador = indexJugador;
		setTitle("Lesiones del jugador: " + Baloncesto.getInstance().getMisEquipos().get(indexEquipo).getNominaJugadores().get(indexJugador).getNombre());
		setBounds(100, 100, 490, 365);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JPanel panel_2 = new JPanel();
				panel_2.setBounds(209, 0, 245, 272);
				panel.add(panel_2);
				panel_2.setLayout(null);
				
				JPanel panel_3 = new JPanel();
				panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Fecha:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel_3.setBounds(0, 0, 245, 98);
				panel_2.add(panel_3);
				panel_3.setLayout(null);
				
				JLabel lblD = new JLabel("D\u00EDa");
				lblD.setBounds(10, 31, 36, 14);
				panel_3.add(lblD);
				
				spinnerdia = new JSpinner();
				spinnerdia.setEnabled(false);
				spinnerdia.setModel(new SpinnerNumberModel(1, 1, 31, 1));
				spinnerdia.setBounds(10, 56, 36, 20);
				panel_3.add(spinnerdia);
				
				JLabel lblMes = new JLabel("Mes");
				lblMes.setBounds(82, 31, 46, 14);
				panel_3.add(lblMes);
				
				spinnermes = new JSpinner();
				spinnermes.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent e) {
						int max = mesDia(Integer.parseInt(spinnermes.getValue().toString()), Integer.parseInt(spinnerano.getValue().toString()));
						
						if (Integer.parseInt(spinnerdia.getValue().toString())>mesDia(Integer.parseInt(spinnermes.getValue().toString()), Integer.parseInt(spinnerano.getValue().toString()))) {
							spinnerdia.setModel(new SpinnerNumberModel(30, 1, max, 1));
						}else {
							spinnerdia.setModel(new SpinnerNumberModel(Integer.parseInt(spinnerdia.getValue().toString()), 1, max, 1));
						}
					}

					private int mesDia(int mes, int anyo) {
						int numDias=0;
						switch (mes) {
				        case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				            numDias = 31;
				            break;
				        case 4: case 6: case 9: case 11:
				            numDias = 30;
				            break;
				        case 2:
				            if((anyo%4==0 && anyo%100!=0) || anyo%400==0){
				                numDias = 29;
				            }
				            else{
				                numDias = 28;
				            }
				            break;
				        default:
				            System.out.println("\nEl mes " + mes + " es incorrecto.");
				            break;
						}
						return numDias;
					}
				});
				spinnermes.setEnabled(false);
				spinnermes.setModel(new SpinnerNumberModel(1, 1, 12, 1));
				spinnermes.setBounds(82, 56, 46, 20);
				panel_3.add(spinnermes);
				
				JLabel lblAo = new JLabel("A\u00F1o");
				lblAo.setBounds(154, 31, 46, 14);
				panel_3.add(lblAo);
				
				spinnerano = new JSpinner();
				spinnerano.setEnabled(false);
				spinnerano.setModel(new SpinnerNumberModel(new Integer(2019), new Integer(2019), null, new Integer(1)));
				spinnerano.setBounds(154, 56, 71, 20);
				panel_3.add(spinnerano);
				
				JPanel panel_4 = new JPanel();
				panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel_4.setBounds(0, 98, 245, 58);
				panel_2.add(panel_4);
				panel_4.setLayout(null);
				
				cbxtipo = new JComboBox();
				cbxtipo.setEnabled(false);
				cbxtipo.setBounds(62, 19, 120, 20);
				panel_4.add(cbxtipo);
				cbxtipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Aguda", "Media", "Grave"}));
				
				JPanel panel_5 = new JPanel();
				panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Detalles:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel_5.setBounds(0, 155, 245, 117);
				panel_2.add(panel_5);
				panel_5.setLayout(new BorderLayout(0, 0));
				
				JScrollPane scrollPane = new JScrollPane();
				panel_5.add(scrollPane, BorderLayout.CENTER);
				
				txtDetalles = new JTextArea();
				txtDetalles.setEnabled(false);
				txtDetalles.setLineWrap(true);
				scrollPane.setViewportView(txtDetalles);
			}
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Lista de lesiones:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(0, 0, 199, 272);
			panel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			panel_1.add(scrollPane, BorderLayout.CENTER);
			
			String[] header = {"Fecha", "Gravedad"};
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
						identificador = table.getSelectedRow();
						agregando = false;
						setInfo();
						setCampos(false);
						btnEliminar.setEnabled(true);
					}
				}
			});
			
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setModel(model);
			cargarTabla();
			
			scrollPane.setViewportView(table);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAgregar = new JButton("Agregar");
				btnAgregar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						btnEliminar.setEnabled(false);
						if(agregando) {
							int dia = Integer.parseInt(spinnerdia.getValue().toString());
							int mes = Integer.parseInt(spinnermes.getValue().toString());
							int anno = Integer.parseInt(spinnerano.getValue().toString());
							Date fecha = new Date(anno, mes, dia);
							int tipo = cbxtipo.getSelectedIndex();
							String detalles = txtDetalles.getText();
							
							if(tipo > 0 && !detalles.equalsIgnoreCase("")) {
								Lesion lesion = new Lesion(tipo, fecha, detalles);
								Baloncesto.getInstance().getMisEquipos().get(indexEquipo).getNominaJugadores().get(indexJugador).getLesionJugador().add(lesion);
								clearInfo();
								JOptionPane.showMessageDialog(null, "Registro de la lesión exitosa", "Información", JOptionPane.INFORMATION_MESSAGE);
							}else {
								JOptionPane.showMessageDialog(null, "Llene los campos correctamente", "Revise los campos", JOptionPane.WARNING_MESSAGE);
							}
						}else {
							clearInfo();
						}
					}
				});
				
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int option = JOptionPane.showConfirmDialog(null, "¿Está segur@ que desea eliminar este registro?","Información",JOptionPane.WARNING_MESSAGE);
						if(option == JOptionPane.OK_OPTION) {
							Baloncesto.getInstance().getMisEquipos().get(indexEquipo).getNominaJugadores().get(indexJugador).getLesionJugador().remove(identificador);
							Baloncesto.getInstance().escribirDatos();
							cargarTabla();
							btnEliminar.setEnabled(false);
							clearInfo();
							agregando = false;
							setCampos(false);
						}
					}
				});
				btnEliminar.setEnabled(false);
				buttonPane.add(btnEliminar);
				btnAgregar.setActionCommand("Cancel");
				buttonPane.add(btnAgregar);
			}
			
			JButton btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			buttonPane.add(btnSalir);
		}
	}

	protected void clearInfo() {
		if(!agregando) {
			agregando = true;
			spinnerdia.setValue(fechaActual.getDate());
			spinnermes.setValue(fechaActual.getMonth() + 1);
			spinnerano.setValue(fechaActual.getYear() + 1900);
			cbxtipo.setSelectedIndex(0);
			txtDetalles.setText("");
			setCampos(true);
		}else {
			agregando = false;
			spinnerdia.setValue(fechaActual.getDate());
			spinnermes.setValue(fechaActual.getMonth() + 1);
			spinnerano.setValue(fechaActual.getYear() + 1900);
			cbxtipo.setSelectedIndex(0);
			txtDetalles.setText("");
			setCampos(false);
			Baloncesto.getInstance().escribirDatos();
			cargarTabla();
		}
	}
	
	private void setCampos(boolean habilitar) {
		if(habilitar) {
			spinnerdia.setEnabled(true);
			spinnermes.setEnabled(true);
			spinnerano.setEnabled(true);
			cbxtipo.setEnabled(true);
			txtDetalles.setEnabled(true);
		}else {
			spinnerdia.setEnabled(false);
			spinnermes.setEnabled(false);
			spinnerano.setEnabled(false);
			cbxtipo.setEnabled(false);
			txtDetalles.setEnabled(false);
		}
	}

	private void cargarTabla() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (Lesion lesion : Baloncesto.getInstance().getMisEquipos().get(indexEquipo).getNominaJugadores().get(indexJugador).getLesionJugador()) {
			fila[0] = lesion.getFechaLesion().getDate() + "/" + lesion.getFechaLesion().getMonth() + "/" + lesion.getFechaLesion().getYear();
			fila[1] = lesion.getTipoLesion();
			model.addRow(fila);
		}
	}

	protected void setInfo() {
		spinnerdia.setValue(Baloncesto.getInstance().getMisEquipos().get(indexEquipo).getNominaJugadores().get(indexJugador).getLesionJugador().get(identificador).getFechaLesion().getDate());
		spinnermes.setValue(Baloncesto.getInstance().getMisEquipos().get(indexEquipo).getNominaJugadores().get(indexJugador).getLesionJugador().get(identificador).getFechaLesion().getMonth());
		spinnerano.setValue(Baloncesto.getInstance().getMisEquipos().get(indexEquipo).getNominaJugadores().get(indexJugador).getLesionJugador().get(identificador).getFechaLesion().getYear());
		cbxtipo.setSelectedIndex(Baloncesto.getInstance().getMisEquipos().get(indexEquipo).getNominaJugadores().get(indexJugador).getLesionJugador().get(identificador).getTipoLesion());
		txtDetalles.setText(Baloncesto.getInstance().getMisEquipos().get(indexEquipo).getNominaJugadores().get(indexJugador).getLesionJugador().get(identificador).getDetalleLesion());
	}
}
