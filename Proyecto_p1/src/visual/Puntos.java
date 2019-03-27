package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.awt.Color;

public class Puntos extends JDialog {
	private JTable table;
	private JRadioButton radbotonequipo1;
	private JRadioButton radbotonequipo2;
	private JButton btnLibre;
	private JButton btnDoble;
	private JButton btnTriple;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Puntos dialog = new Puntos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Puntos() {
		setForeground(new Color(0, 0, 0));
		setTitle("PUNTOS");
		getContentPane().setBackground(new Color(128, 0, 0));
		setBounds(100, 100, 548, 433);
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(128, 0, 0));
			buttonPane.setBounds(0, 384, 532, 10);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
		}
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(222, 184, 135));
		panel.setBounds(10, 11, 512, 372);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblEquipo = new JLabel("Equipo 1");
		lblEquipo.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		lblEquipo.setBounds(111, 11, 73, 33);
		panel.add(lblEquipo);
		
		JLabel lblEquipo_1 = new JLabel("Equipo 2");
		lblEquipo_1.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		lblEquipo_1.setBounds(335, 11, 64, 33);
		panel.add(lblEquipo_1);
		
		radbotonequipo1 = new JRadioButton("");
		radbotonequipo1.setBackground(new Color(222, 184, 135));
		radbotonequipo1.setBounds(124, 51, 30, 23);
		panel.add(radbotonequipo1);
		
		radbotonequipo2 = new JRadioButton("");
		radbotonequipo2.setBackground(new Color(222, 184, 135));
		radbotonequipo2.setBounds(355, 51, 30, 23);
		panel.add(radbotonequipo2);
		
		btnLibre = new JButton("Libre");
		btnLibre.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		btnLibre.setBounds(318, 146, 89, 23);
		panel.add(btnLibre);
		
		btnDoble = new JButton("Doble");
		btnDoble.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		btnDoble.setBounds(318, 196, 89, 23);
		panel.add(btnDoble);
		
		btnTriple = new JButton("Triple");
		btnTriple.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		btnTriple.setBounds(318, 242, 89, 23);
		panel.add(btnTriple);
		
		JLabel lblTiros = new JLabel("Tiros:");
		lblTiros.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
		lblTiros.setBounds(335, 106, 46, 14);
		panel.add(lblTiros);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(27, 117, 220, 244);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		JLabel lblJugadores = new JLabel("Jugadores:");
		lblJugadores.setFont(new Font("Lucida Fax", Font.PLAIN, 13));
		lblJugadores.setBounds(27, 81, 127, 33);
		panel.add(lblJugadores);
	}
}
