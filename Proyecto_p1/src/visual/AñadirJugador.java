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

public class AñadirJugador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private JTextField txtNombreJugador;
	private JTextField txtPeso;
	private JTextField txtEstatura;
	private JComboBox cbxPosicion;
	private JSpinner spnNumero;
	private JButton btnAgregarJugador;
	
	private int ubica = 1;
	private boolean noponer = true;
	
	private int index;

	public AñadirJugador(int index) {
		this.index = index;
		setTitle("Añadir Jugador");
		setResizable(false);
		setBounds(100, 100, 379, 183);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion del jugador:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			JLabel lblNombreDelJugador = new JLabel("Nombre:");
			lblNombreDelJugador.setBounds(10, 27, 62, 14);
			panel.add(lblNombreDelJugador);
		}
		{
			txtNombreJugador = new JTextField();
			txtNombreJugador.setBounds(76, 24, 276, 20);
			panel.add(txtNombreJugador);
			txtNombreJugador.setColumns(10);
		}
		{
			JLabel lblPeso = new JLabel("Peso (Kg):");
			lblPeso.setBounds(10, 52, 62, 14);
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
			txtPeso.setBounds(76, 49, 62, 20);
			panel.add(txtPeso);
			txtPeso.setColumns(10);
		}
		{
			JLabel lblPosicin = new JLabel("Posici\u00F3n:");
			lblPosicin.setBounds(148, 77, 54, 14);
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
			txtEstatura.setBounds(237, 49, 115, 20);
			panel.add(txtEstatura);
			txtEstatura.setColumns(10);
		}
		{
			JLabel lblEstatura = new JLabel("Estatura (m):");
			lblEstatura.setBounds(148, 52, 86, 14);
			panel.add(lblEstatura);
		}
		{
			JLabel lblNmero = new JLabel("N\u00FAmero:");
			lblNmero.setBounds(10, 77, 54, 14);
			panel.add(lblNmero);
		}
		
		spnNumero = new JSpinner();
		spnNumero.setModel(new SpinnerNumberModel(0, 0, 99, 1));
		spnNumero.setBounds(76, 74, 62, 20);
		panel.add(spnNumero);
		
		cbxPosicion = new JComboBox();
		String[] cbxPosi = {"<Seleccione>", "Base", "Escolta", "Alero", "Ala-Pivot", "Pivot"};
		cbxPosicion.setModel(new DefaultComboBoxModel(cbxPosi));
		cbxPosicion.setBounds(237, 74, 115, 20);
		panel.add(cbxPosicion);
		
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
						Jugador aux = new Jugador(nombreJugador, peso, estatura, posicion, numero);
						Baloncesto.getInstance().getMisEquipos().get(index).getNominaJugadores().add(aux);
						JOptionPane.showMessageDialog(null, "Registro del jugador exitoso", "Información", JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}else if(checkNumero(numero)) {
						JOptionPane.showMessageDialog(null, "El número del jugador ya está en uso", "Revise los campos", JOptionPane.WARNING_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "Llene correctamente los campos", "Revise los campos", JOptionPane.WARNING_MESSAGE);
					}
				}

				private boolean checkNumero(int numero) {
					boolean encontrado = false;
					
					for (Jugador player : Baloncesto.getInstance().getMisEquipos().get(index).getNominaJugadores()) {
						if(player.getNumero() == numero) {
							encontrado = true;
						}
					}
					
					return encontrado;
				}
			});
			buttonPane.add(btnAgregarJugador);
			{
				JButton btnCancel = new JButton("Cancelar");
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
}
