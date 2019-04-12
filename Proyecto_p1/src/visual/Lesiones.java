package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.border.TitledBorder;
import javax.swing.SpinnerNumberModel;

public class Lesiones extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTable table;
	
	private Date fecha_actual = new Date();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Lesiones dialog = new Lesiones();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Lesiones() {
		//System.out
		setTitle("Lesiones");
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
				panel_2.setBounds(209, 11, 245, 261);
				panel.add(panel_2);
				panel_2.setLayout(null);
				
				JPanel panel_3 = new JPanel();
				panel_3.setBorder(new TitledBorder(null, "Fecha", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_3.setBounds(0, 11, 245, 87);
				panel_2.add(panel_3);
				panel_3.setLayout(null);
				
				JLabel lblD = new JLabel("D\u00EDa");
				lblD.setBounds(10, 31, 36, 14);
				panel_3.add(lblD);
				
				JSpinner spinnerdia = new JSpinner();
				spinnerdia.setModel(new SpinnerNumberModel(1, 1, 30, 1));
				spinnerdia.setBounds(10, 56, 36, 20);
				panel_3.add(spinnerdia);
				
				JLabel lblMes = new JLabel("Mes");
				lblMes.setBounds(82, 31, 46, 14);
				panel_3.add(lblMes);
				
				JSpinner spinnermes = new JSpinner();
				spinnermes.setModel(new SpinnerNumberModel(1, 1, 12, 1));
				spinnermes.setBounds(82, 56, 46, 20);
				panel_3.add(spinnermes);
				
				JLabel lblAo = new JLabel("A\u00F1o");
				lblAo.setBounds(179, 31, 46, 14);
				panel_3.add(lblAo);
				
				JSpinner spinnerano = new JSpinner();
				spinnerano.setBounds(154, 56, 71, 20);
				panel_3.add(spinnerano);
				
				JPanel panel_4 = new JPanel();
				panel_4.setBorder(new TitledBorder(null, "Tipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_4.setBounds(0, 109, 245, 35);
				panel_2.add(panel_4);
				panel_4.setLayout(null);
				
				JComboBox cbxtipo = new JComboBox();
				cbxtipo.setBounds(53, 11, 120, 20);
				panel_4.add(cbxtipo);
				cbxtipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Aguda", "Media", "Grave"}));
				
				JPanel panel_5 = new JPanel();
				panel_5.setBorder(new TitledBorder(null, "Detalles", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_5.setBounds(0, 155, 245, 106);
				panel_2.add(panel_5);
				panel_5.setLayout(null);
				
				textField = new JTextField();
				textField.setBounds(10, 23, 225, 72);
				panel_5.add(textField);
				textField.setColumns(10);
			}
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(10, 11, 189, 261);
			panel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			table = new JTable();
			panel_1.add(table, BorderLayout.NORTH);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Aceptar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Agregar ");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
