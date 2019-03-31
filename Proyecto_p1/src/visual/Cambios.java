package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JScrollPane;

public class Cambios extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTable table_1;
	private JButton buttonadd;
	private JButton buttonremove;
	private JScrollPane scrollPane_1;
	private JPanel buttonPane;
	private JRadioButton radioButton1;
	private JRadioButton radioButton2;

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
		
		buttonadd = new JButton(">");
		buttonadd.setFont(new Font("Lucida Fax", Font.BOLD, 20));
		buttonadd.setBounds(196, 211, 47, 33);
		contentPanel.add(buttonadd);
		
		buttonremove = new JButton("<");
		buttonremove.setFont(new Font("Lucida Fax", Font.BOLD, 20));
		buttonremove.setBounds(196, 273, 47, 33);
		contentPanel.add(buttonremove);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(267, 129, 157, 280);
		contentPanel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, BorderLayout.CENTER);
		
		table_1 = new JTable();
		scrollPane_1.setColumnHeaderView(table_1);
		
		JLabel label = new JLabel("Equipo 1");
		label.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 14));
		label.setBounds(88, 11, 79, 33);
		contentPanel.add(label);
		
		radioButton1 = new JRadioButton("");
		radioButton1.setBackground(SystemColor.menu);
		radioButton1.setBounds(109, 51, 30, 23);
		contentPanel.add(radioButton1);
		
		JLabel label_1 = new JLabel("Equipo 2");
		label_1.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 14));
		label_1.setBounds(258, 11, 79, 33);
		contentPanel.add(label_1);
		
		radioButton2 = new JRadioButton("");
		radioButton2.setBackground(SystemColor.menu);
		radioButton2.setBounds(278, 51, 30, 23);
		contentPanel.add(radioButton2);
		
		JLabel lblJugadores = new JLabel("JUGADORES EN JUEGO");
		lblJugadores.setFont(new Font("Lucida Fax", Font.BOLD, 13));
		lblJugadores.setBounds(5, 95, 162, 23);
		contentPanel.add(lblJugadores);
		
		JLabel lblBanca = new JLabel("JUGADORES EN BANCA");
		lblBanca.setFont(new Font("Lucida Fax", Font.BOLD, 13));
		lblBanca.setBounds(267, 91, 157, 33);
		contentPanel.add(lblBanca);
		
		JPanel panel = new JPanel();
		panel.setBounds(15, 129, 152, 280);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Cambiar");
				okButton.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
