package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import logico.Baloncesto;
import logico.Equipo;
import logico.Jugador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AgregarEquipo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreEquipo;
	private JTextField txtNombreCoach;
	private JTextField txtNombreCancha;
	
	private JLabel lblImagen;
	
	private File fichero = null;
	private JTextField txtNombreJugador;
	private JTextField txtPeso;
	private JTextField txtEstatura;
	private JTextField txtCodigo;
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] fila;
	private String identificador = "";
	
	private JComboBox cbxPosicion;
	private JSpinner spnNumero;
	private JButton btnRegistrar;
	private JButton btnAgregarJugador;
	
	private boolean ficheroListo = false;
	
	private int ubica = 1;
	private boolean noponer = true;
	
	private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
	private JButton btnBorrar;
	
	private int minJugadores = 1;
	private int maxJugadores = 3;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public AgregarEquipo() {
		setTitle("Registrar Equipo");
		setResizable(false);
		setBounds(100, 100, 702, 515);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(5, 5, 362, 235);
			panel.setBorder(new TitledBorder(null, "Informacion del equipo:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblNombreDelEquipo = new JLabel("Nombre del equipo:");
			lblNombreDelEquipo.setBounds(10, 38, 151, 14);
			panel.add(lblNombreDelEquipo);
			
			txtNombreEquipo = new JTextField();
			txtNombreEquipo.setBounds(10, 63, 169, 20);
			panel.add(txtNombreEquipo);
			txtNombreEquipo.setColumns(10);
			{
				JLabel lblCoach = new JLabel("Nombre del Coach:");
				lblCoach.setBounds(10, 94, 133, 14);
				panel.add(lblCoach);
			}
			{
				txtNombreCoach = new JTextField();
				txtNombreCoach.setBounds(10, 119, 169, 20);
				panel.add(txtNombreCoach);
				txtNombreCoach.setColumns(10);
			}
			{
				JLabel lblCancha = new JLabel("Nombre de la cancha:");
				lblCancha.setBounds(10, 150, 169, 14);
				panel.add(lblCancha);
			}
			{
				txtNombreCancha = new JTextField();
				txtNombreCancha.setBounds(10, 175, 169, 20);
				panel.add(txtNombreCancha);
				txtNombreCancha.setColumns(10);
			}
			{
				lblImagen = new JLabel("Imagen");
				lblImagen.setBorder(new LineBorder(new Color(0, 0, 0)));
				lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
				lblImagen.setHorizontalTextPosition(SwingConstants.CENTER);
				lblImagen.setBounds(199, 38, 144, 144);
				panel.add(lblImagen);
			}
			
			Button btnCargar = new Button("Cargar Imagen");
			
			btnCargar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int resultado;
					CargarImagen ventana = new CargarImagen();
					FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG y PNG y GIF", "JPG", "PNG", "GIF");
					ventana.fileChooser.setFileFilter(filtro);
					resultado = ventana.fileChooser.showOpenDialog(null);
					if(JFileChooser.APPROVE_OPTION == resultado/* && ventana.fileChooser.getSelectedFile().getPath().equalsIgnoreCase("JPG")*/) {
						fichero = ventana.fileChooser.getSelectedFile();
						ficheroListo = true;
						try {
							ImageIcon icon = new ImageIcon(fichero.toString());
							Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
							lblImagen.setText(null);
							lblImagen.setIcon(icono);
						}catch(Exception ex) {
							JOptionPane.showMessageDialog(null, "Error cargando la imagen "+ ex);
						}
					}/*else {
						JOptionPane.showMessageDialog(null, "La imagen debe ser JPG o PNG", "Formato incorrecto", JOptionPane.WARNING_MESSAGE);
					}*/
				}
			});
			btnCargar.setBounds(199, 188, 144, 22);
			panel.add(btnCargar);
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion del jugador:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(5, 251, 362, 191);
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			JLabel lblNombreDelJugador = new JLabel("Nombre:");
			lblNombreDelJugador.setBounds(10, 68, 62, 14);
			panel.add(lblNombreDelJugador);
		}
		{
			txtNombreJugador = new JTextField();
			txtNombreJugador.setBounds(66, 65, 251, 20);
			panel.add(txtNombreJugador);
			txtNombreJugador.setColumns(10);
		}
		{
			JLabel lblPeso = new JLabel("Peso:");
			lblPeso.setBounds(10, 104, 37, 14);
			panel.add(lblPeso);
		}
		{
			txtPeso = new JTextField();
			txtPeso.addKeyListener(new KeyAdapter() {
			      @Override
			      public void keyTyped(KeyEvent e) {
			        char c = e.getKeyChar();
			        if (ubica!=1) {
			          ubica=1;
			          noponer=true;
			        }
			        if (!Character.isDigit(c) && (!(c==46) || noponer!=true)) {
			          e.consume();
			        }
			        if ((c==46)) {
			          noponer=false;
			        }
			      }
			    });
			txtPeso.setBounds(66, 98, 70, 20);
			panel.add(txtPeso);
			txtPeso.setColumns(10);
		}
		{
			JLabel lblPosicin = new JLabel("Posici\u00F3n:");
			lblPosicin.setBounds(146, 135, 54, 14);
			panel.add(lblPosicin);
		}
		{
			txtEstatura = new JTextField();
			txtEstatura.addKeyListener(new KeyAdapter() {
			      @Override
			      public void keyTyped(KeyEvent e) {
			        char c = e.getKeyChar();
			        if (ubica!=2) {
			          ubica=2;
			          noponer=true;
			        }
			        if (!Character.isDigit(c) && (!(c==46) || noponer!=true)) {
			          e.consume();
			        }
			        if ((c==46)) {
			          noponer=false;
			        }
			      }
			    });
			txtEstatura.setBounds(210, 96, 107, 20);
			panel.add(txtEstatura);
			txtEstatura.setColumns(10);
		}
		{
			JLabel lblEstatura = new JLabel("Estatura:");
			lblEstatura.setBounds(146, 104, 54, 14);
			panel.add(lblEstatura);
		}
		{
			JLabel lblNmero = new JLabel("N\u00FAmero:");
			lblNmero.setBounds(10, 135, 54, 14);
			panel.add(lblNmero);
		}
		
		spnNumero = new JSpinner();
		spnNumero.setModel(new SpinnerNumberModel(0, 0, 99, 1));
		spnNumero.setBounds(66, 129, 70, 20);
		panel.add(spnNumero);
		{
			JLabel lblCdigo = new JLabel("C\u00F3digo:");
			lblCdigo.setBounds(10, 34, 46, 14);
			panel.add(lblCdigo);
		}
		{
			txtCodigo = new JTextField();
			txtCodigo.setEditable(false);
			txtCodigo.setBounds(66, 31, 251, 20);
			panel.add(txtCodigo);
			txtCodigo.setColumns(10);
		}
		
		cbxPosicion = new JComboBox();
		String[] cbxPosi = {"<Seleccione>", "Base", "Escolta", "Alero", "Ala-Pivot", "Pivot"};
		cbxPosicion.setModel(new DefaultComboBoxModel(cbxPosi));
		cbxPosicion.setBounds(210, 129, 107, 20);
		panel.add(cbxPosicion);
		//cargarCbxPos();
		{
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Jugadores:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(377, 11, 309, 431);
			contentPanel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			panel_1.add(scrollPane, BorderLayout.CENTER);
			
			String[] header = {"Nombre", "Número"};
			model = new DefaultTableModel();
			model.setColumnIdentifiers(header);
			
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(table.getSelectedRow()>=0){
						btnBorrar.setEnabled(true);
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
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnAgregarJugador = new JButton("Agregar Jugador");
			btnAgregarJugador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					boolean ready = false;
					String nombreJugador = txtNombreJugador.getText();
					
					float peso = 0;
					if(!txtPeso.getText().equalsIgnoreCase("")){
						peso = (float) Double.parseDouble(txtPeso.getText());
						ready = true;
					}else {
						ready = false;
					}
					
					String code = txtCodigo.getText();
					
					float estatura = 0;
					if(!txtEstatura.getText().equalsIgnoreCase("")) {
						estatura = (float) Double.parseDouble(txtEstatura.getText());
						ready = true;
					}else {
						ready = false;
					}
					
					String posicion = cbxPosicion.getSelectedItem().toString();
					int numero = Integer.parseInt(spnNumero.getValue().toString());
					
					if(!nombreJugador.equalsIgnoreCase("") && !posicion.equalsIgnoreCase("<Seleccione>") && !checkNumero(numero) && ready) {
						Jugador aux = new Jugador(nombreJugador, peso, estatura, posicion, numero, code);
						jugadores.add(aux);
						JOptionPane.showMessageDialog(null, "Registro del jugador exitoso", "Información", JOptionPane.INFORMATION_MESSAGE);
						cargarTabla();
						cleanPlantillaJugadores();
					}else if(checkNumero(numero)) {
						JOptionPane.showMessageDialog(null, "El número del jugador ya está en uso", "Revise los campos", JOptionPane.WARNING_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "Llene correctamente los campos", "Revise los campos", JOptionPane.WARNING_MESSAGE);
					}
					
					setBtn();
				}

				private boolean checkNumero(int numero) {
					boolean encontrado = false;
					
					for (Jugador player : jugadores) {
						if(player.getNumero() == numero) {
							encontrado = true;
						}
					}
					
					return encontrado;
				}
			});
			buttonPane.add(btnAgregarJugador);
			{
				btnRegistrar = new JButton("Registrar Equipo");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String nombreEquipo = txtNombreEquipo.getText();
						String nombreCoach = txtNombreCoach.getText();
						String nombreCancha = txtNombreCancha.getText();
						
						if((fichero != null) && !nombreEquipo.equalsIgnoreCase("") && !nombreCoach.equalsIgnoreCase("") && !nombreCancha.equalsIgnoreCase("") && !checkEquipos(nombreEquipo)) {
							Equipo aux = new Equipo(nombreEquipo, nombreCoach, nombreCancha, fichero);
							try {
								aux.guardarLogo();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							aux.setNominaJugadores(jugadores);
							Baloncesto.getInstance().agregarEquipo(aux);
							JOptionPane.showMessageDialog(null, "Registro de equipo exitoso", "Información", JOptionPane.INFORMATION_MESSAGE);
							reset();
						}else if(checkEquipos(nombreEquipo)) {
							JOptionPane.showMessageDialog(null, "Ya existe un equipo con el mismo nombre", "Revise los campos", JOptionPane.WARNING_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null, "Llene correctamente los campos", "Revise los campos", JOptionPane.WARNING_MESSAGE);
						}
					}

					private boolean checkEquipos(String nombreEquipo) {
						boolean encontrado = false;
						
						for (Equipo team : Baloncesto.getInstance().getMisEquipos()) {
							if(team.getNombre().equalsIgnoreCase(nombreEquipo)) {
								encontrado = true;
							}
						}
						
						return encontrado;
					}
				});
				
				btnBorrar = new JButton("Eliminar Jugador");
				btnBorrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(!identificador.equalsIgnoreCase("")) {
							int option = JOptionPane.showConfirmDialog(null, "¿Está segur@ que desea eliminar el jugador?","Información",JOptionPane.WARNING_MESSAGE);
							if(option == JOptionPane.OK_OPTION) {
								jugadores.remove(indicePorNombre(identificador));
								cargarTabla();
								setBtn();
								btnBorrar.setEnabled(false);
							}
						}
					}
				});
				btnBorrar.setEnabled(false);
				buttonPane.add(btnBorrar);
				btnRegistrar.setEnabled(false);
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnCancel = new JButton("Salir");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
	}

	protected void setBtn() {
		if(jugadores.size() >= minJugadores) {
			btnRegistrar.setEnabled(true);
		}else {
			btnRegistrar.setEnabled(false);
		}
		
		if(jugadores.size() >= maxJugadores) {
			btnAgregarJugador.setEnabled(false);
		}else {
			btnAgregarJugador.setEnabled(true);
		}
	}

	protected int indicePorNombre(String identificador2) {
		int indice = -1;
		int i = 0;
		boolean encontrado = false;
		
		while(!encontrado && i < jugadores.size()) {
			if(jugadores.get(i).getNombre().equalsIgnoreCase(identificador2)) {
				indice = i;
			}
			
			i++;
		}
		
		return indice;
	}

	private void cargarTabla() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (int i = 0; i < jugadores.size(); i++) {
			fila[0] = jugadores.get(i).getNombre();
			fila[1] = jugadores.get(i).getNumero();
			model.addRow(fila);
		}
		
	}

	/*private void cargarCbxPos() {
		cbxPosicion.removeAllItems();
		String[] cbxPos = {"<Seleccione>", "Base", "Escolta", "Alero", "Ala-Pivot", "Pivot"};
		cbxPosicion.addItem(cbxPos[0]);
		boolean encontrado = false;
		int y = 0;
		
		for(int i = 1; i <= 5; i++) {
			while(!encontrado && i < jugadores.size()) {
				if(jugadores.get(y).getPosicion().equalsIgnoreCase(cbxPos[i])) {
					encontrado = true;
				}
				y++;
			}
			
			y = 0;
			
			if(!encontrado) {
				cbxPosicion.addItem(cbxPos[i]);
			}else {
				encontrado = false;
			}
		}
	}*/

	protected void cleanPlantillaEquipo() {
		txtNombreEquipo.setText("");
		txtNombreCoach.setText("");
		txtNombreCancha.setText("");
		fichero = null;
		lblImagen.setIcon(null);
		lblImagen.setText("Imagen");
	}

	protected void cleanPlantillaJugadores() {
		txtNombreJugador.setText("");
		txtPeso.setText("");
		txtCodigo.setText("");
		txtEstatura.setText("");
		cbxPosicion.setSelectedIndex(0);
		spnNumero.setValue(Integer.parseInt("0"));
	}
	
	protected void reset() {
		cleanPlantillaJugadores();
		cleanPlantillaEquipo();
		btnRegistrar.setEnabled(false);
		btnAgregarJugador.setEnabled(true);
		btnBorrar.setEnabled(false);
		jugadores.clear();
		cargarTabla();
	}
}
