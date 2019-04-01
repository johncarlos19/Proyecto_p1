package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import javafx.scene.layout.Border;
import logico.Baloncesto;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.Console;
import java.awt.event.ActionEvent;

public class Calendario extends JDialog {
	private JTable table;
	private JScrollPane scrollPane;
	private static DefaultTableModel model;
	private static Object[] fila;
	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		try {
			Calendario dialog = new Calendario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
	/**
	 * Create the dialog.
	 */
	public Calendario() {
		setFont(new Font("Lucida Fax", Font.BOLD, 12));
		setTitle("Calendario");
		setBounds(100, 100, 629, 462);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setFont(new Font("Lucida Fax", Font.BOLD, 13));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setOpaque(false);
		panel.setLayout(null);
		JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(Calendario.class.getResource("/imagen/1530905.jpg")));
			label.setBounds(0, 0, 613, 388);
			panel.add(label);
			
		scrollPane = new JScrollPane(label,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(0, 0, 613, 388);
		//javax.swing.border.Border border1 = BorderFactory.createEmptyBorder(0,0,0,0);
		//scrollPane.setBorder(null);
		//scrollPane
		
		panel.add(scrollPane);
		{
			table = new JTable();
			table.setVisible(true);
			table.setFont(new Font("Tahoma", Font.PLAIN, 18));
			table.setDefaultRenderer(Object.class, new ImgTabla());
			String[] header = {"","", ""};
			model = new DefaultTableModel(null,header);
			table.setRowHeight(130);
			table.setModel(model);
			table.setOpaque(false);
			cargarTabla();
			scrollPane.setViewportView(table);
			scrollPane.setOpaque(false);
			//scrollPane.setColumnHeaderView(table);
		}
		{
			
		}
	}
	private void cargarTabla() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (int i = 0; i < Baloncesto.getInstance().getJuegoRecord().size(); i++) {
			//
					//.getImage().getScaledInstance(ColumnConst, lblLogoequipo11.getHeight(), Image.SCALE_DEFAULT));
			Icon icono111 = new ImageIcon(Baloncesto.getInstance().getJuegoRecord().get(i).getEquipoJuego()[0].getLogo().getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
			JLabel log = new JLabel(Baloncesto.getInstance().getJuegoRecord().get(i).getEquipoJuego()[0].getNombre());
			log.setIcon(icono111);
			log.setHorizontalAlignment(SwingConstants.CENTER);
			log.setHorizontalTextPosition(SwingConstants.CENTER);
			log.setVerticalTextPosition(SwingConstants.BOTTOM);
			Icon icono222 = new ImageIcon(Baloncesto.getInstance().getJuegoRecord().get(i).getEquipoJuego()[1].getLogo().getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
			JLabel log1 = new JLabel(Baloncesto.getInstance().getJuegoRecord().get(i).getEquipoJuego()[1].getNombre());
			log1.setIcon(icono222);
			log1.setVerticalTextPosition(SwingConstants.BOTTOM);
			log1.setHorizontalAlignment(SwingConstants.CENTER);
			log1.setHorizontalTextPosition(SwingConstants.CENTER);
			JLabel fecha = new JLabel(Baloncesto.getInstance().getJuegoRecord().get(i).getFechaJuego().getDate()+"/"+Baloncesto.getInstance().getJuegoRecord().get(i).getFechaJuego().getMonth()+"/"+(Baloncesto.getInstance().getJuegoRecord().get(i).getFechaJuego().getYear()));
			fecha.setHorizontalAlignment(SwingConstants.CENTER);
			fecha.setHorizontalTextPosition(SwingConstants.CENTER);
			fila[0]= log;
			fila[1] = fecha;
			fila[2] = log1;
			model.addRow(fila);
		}
		
		
	}
}
