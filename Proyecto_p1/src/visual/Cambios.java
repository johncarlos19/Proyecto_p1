package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class Cambios extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Cambios dialog = new Cambios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Cambios() {
		setBounds(100, 100, 450, 492);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton buttonadd = new JButton(">");
		buttonadd.setBounds(196, 211, 47, 33);
		contentPanel.add(buttonadd);
		
		JButton buttonremove = new JButton("<");
		buttonremove.setBounds(196, 273, 47, 33);
		contentPanel.add(buttonremove);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 129, 157, 280);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(0, 0, 157, 280);
		panel.add(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(267, 129, 157, 280);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		table_1 = new JTable();
		table_1.setBounds(0, 0, 157, 280);
		panel_1.add(table_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Cambiar");
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
