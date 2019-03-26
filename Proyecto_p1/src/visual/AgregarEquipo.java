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

public class AgregarEquipo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	private JLabel lblImagen;
	
	private File fichero;

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
		setBounds(100, 100, 605, 638);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Informacion del equipo:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblNombreDelEquipo = new JLabel("Nombre del equipo:");
			lblNombreDelEquipo.setBounds(10, 38, 104, 14);
			panel.add(lblNombreDelEquipo);
			
			textField = new JTextField();
			textField.setBounds(10, 63, 169, 20);
			panel.add(textField);
			textField.setColumns(10);
			{
				JLabel lblCoach = new JLabel("Nombre del Coach:");
				lblCoach.setBounds(10, 94, 104, 14);
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
					FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG y PNG", "JPG", "jpg");
					ventana.fileChooser.setFileFilter(filtro);
					resultado = ventana.fileChooser.showOpenDialog(null);
					if(JFileChooser.APPROVE_OPTION == resultado) {
						fichero = ventana.fileChooser.getSelectedFile();
						try {
							ImageIcon icon = new ImageIcon(fichero.toString());
							Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
							lblImagen.setText(null);
							lblImagen.setIcon(icono);
						}catch(Exception ex) {
							JOptionPane.showMessageDialog(null, "Error cargando la imagen "+ ex);
						}
					}
				}
			});
			button.setBounds(199, 188, 144, 22);
			panel.add(button);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
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
