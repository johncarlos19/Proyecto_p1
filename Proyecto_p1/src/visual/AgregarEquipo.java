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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class AgregarEquipo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	private JLabel lblImagen;
	
	private File fichero;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarEquipo dialog = new AgregarEquipo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarEquipo() {
		setTitle("Registrar Equipo");
		setResizable(false);
		setBounds(100, 100, 702, 515);
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
			
			textField = new JTextField();
			textField.setBounds(10, 63, 169, 20);
			panel.add(textField);
			textField.setColumns(10);
			{
				JLabel lblCoach = new JLabel("Nombre del Coach:");
				lblCoach.setBounds(10, 94, 133, 14);
				panel.add(lblCoach);
			}
			{
				textField_1 = new JTextField();
				textField_1.setBounds(10, 119, 169, 20);
				panel.add(textField_1);
				textField_1.setColumns(10);
			}
			{
				JLabel lblCancha = new JLabel("Nombre de la cancha:");
				lblCancha.setBounds(10, 150, 169, 14);
				panel.add(lblCancha);
			}
			{
				textField_2 = new JTextField();
				textField_2.setBounds(10, 175, 169, 20);
				panel.add(textField_2);
				textField_2.setColumns(10);
			}
			{
				lblImagen = new JLabel("Imagen");
				lblImagen.setBorder(new LineBorder(new Color(0, 0, 0)));
				lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
				lblImagen.setHorizontalTextPosition(SwingConstants.CENTER);
				lblImagen.setBounds(199, 38, 144, 144);
				panel.add(lblImagen);
			}
			
			Button button = new Button("Cargar Imagen");
			
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int resultado;
					CargarImagen ventana = new CargarImagen();
					FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG y PNG", "JPG", "PNG");
					ventana.fileChooser.setFileFilter(filtro);
					resultado = ventana.fileChooser.showOpenDialog(null);
					if(JFileChooser.APPROVE_OPTION == resultado && ventana.fileChooser.getSelectedFile().getPath().equalsIgnoreCase("JPG")) {
						fichero = ventana.fileChooser.getSelectedFile();
						try {
							ImageIcon icon = new ImageIcon(fichero.toString());
							Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
							lblImagen.setText(null);
							lblImagen.setIcon(icono);
						}catch(Exception ex) {
							JOptionPane.showMessageDialog(null, "Error cargando la imagen "+ ex);
						}
					}else {
						JOptionPane.showMessageDialog(null, "La imagen debe ser JPG o PNG", "Formato incorrecto", JOptionPane.WARNING_MESSAGE);
					}
				}
			});
			button.setBounds(199, 188, 144, 22);
			panel.add(button);
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
			textField_3 = new JTextField();
			textField_3.setBounds(66, 65, 251, 20);
			panel.add(textField_3);
			textField_3.setColumns(10);
		}
		{
			JLabel lblPeso = new JLabel("Peso:");
			lblPeso.setBounds(10, 104, 37, 14);
			panel.add(lblPeso);
		}
		{
			textField_4 = new JTextField();
			textField_4.setBounds(66, 98, 80, 20);
			panel.add(textField_4);
			textField_4.setColumns(10);
		}
		{
			JLabel lblPosicin = new JLabel("Posici\u00F3n:");
			lblPosicin.setBounds(10, 139, 62, 14);
			panel.add(lblPosicin);
		}
		{
			textField_5 = new JTextField();
			textField_5.setBounds(237, 96, 80, 20);
			panel.add(textField_5);
			textField_5.setColumns(10);
		}
		{
			JLabel lblEstatura = new JLabel("Estatura:");
			lblEstatura.setBounds(159, 104, 68, 14);
			panel.add(lblEstatura);
		}
		{
			textField_6 = new JTextField();
			textField_6.setBounds(66, 136, 80, 20);
			panel.add(textField_6);
			textField_6.setColumns(10);
		}
		{
			JLabel lblNmero = new JLabel("N\u00FAmero:");
			lblNmero.setBounds(159, 139, 68, 14);
			panel.add(lblNmero);
		}
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner.setBounds(237, 136, 80, 20);
		panel.add(spinner);
		{
			JLabel lblCdigo = new JLabel("C\u00F3digo:");
			lblCdigo.setBounds(10, 34, 46, 14);
			panel.add(lblCdigo);
		}
		{
			textField_7 = new JTextField();
			textField_7.setEditable(false);
			textField_7.setBounds(66, 31, 251, 20);
			panel.add(textField_7);
			textField_7.setColumns(10);
		}
		{
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Jugadores:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(377, 11, 309, 431);
			contentPanel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			panel_1.add(scrollPane, BorderLayout.CENTER);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnAgregarJugador = new JButton("Agregar Jugador");
			btnAgregarJugador.setEnabled(false);
			buttonPane.add(btnAgregarJugador);
			{
				JButton okButton = new JButton("Registrar Equipo");
				okButton.setEnabled(false);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
