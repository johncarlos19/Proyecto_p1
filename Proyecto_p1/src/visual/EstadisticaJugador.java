package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import logico.Baloncesto;
import logico.Equipo;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class EstadisticaJugador extends JDialog{

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] fila;
	private JScrollPane scrollPane;
	private JPanel panel;
	private Equipo equiGrafica=null;
	//Thread h1;
	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		try {
			EstadisticaEquipo dialog = new EstadisticaEquipo();
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
	public EstadisticaJugador() {
		setTitle("Estadisticas De Jugadores");
		setBounds(100, 100, 338, 601);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(330, 11, 878, 507);
		equiGrafica=Baloncesto.getInstance().getMisEquipos().get(0);
		init(equiGrafica);
		contentPanel.add(panel);
		//panel.setLayout(new BorderLayout(0, 0));
		
		//h1 = new Thread(this);
		//h1.start();
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 310, 507);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				String code = (String)table.getModel().getValueAt(index, 1);
				setBounds(100, 100, 1234, 601);
				//init(Baloncesto.getInstance().getMisEquipos().get(0));
				equiGrafica=buscarEquipo(code);
				init(equiGrafica);
				
			}
		});
		table.setVisible(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table.setDefaultRenderer(Object.class, new ImgTabla());
		((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setBackground(new Color(0,0,0,0));
		table.setGridColor(Color.BLACK);
		table.setForeground(Color.BLACK);
		table.setDefaultRenderer(Object.class, new ImgTabla());
		String[] header = {"Logo","Nombre Del Equipo"};
		model = new DefaultTableModel(null,header) {
			@Override
			public boolean isCellEditable(int filas, int columnas) {
				if(columnas==4) {
					return true;
				}else {
					return false;
				}
			}
		};
		
		table.setRowHeight(32);
		
		table.setModel(model);
		table.setOpaque(false);
		cargarTabla();
		scrollPane.setBackground(new Color(0,0,0,0));
		((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
		table.setShowGrid(true);
		scrollPane.setViewportView(table);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		
		//scrollPane.setColumnHeaderView(table);
		
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
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private Equipo buscarEquipo(String nombre) {
		Equipo aux = null;
				int i=0;
		while (i<Baloncesto.getInstance().getMisEquipos().size()) {
			if (Baloncesto.getInstance().getMisEquipos().get(i).getNombre().equalsIgnoreCase(nombre)) {
				aux=Baloncesto.getInstance().getMisEquipos().get(i);
			}
			i++;
			
		}
		System.out.println(aux.getNombre());
		return aux;
	}
	/*
	@Override
	public void run() {
		Thread ct = Thread.currentThread();
        while (ct == h1) {
        	
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
	}*/
	
    private void init(Equipo aux) {
        
			
		panel.setVisible(true);
		panel.setOpaque(false);
    	//getContentPane().add(panel);
        // Fuente de Datos
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < aux.getNominaJugadores().size(); i++) {
        	dataset.setValue(aux.getNominaJugadores().get(i).getPuntoJugador().getTiroLibre(),"Tiro Libre",aux.getNominaJugadores().get(i).getNombre());
        	dataset.setValue(aux.getNominaJugadores().get(i).getPuntoJugador().getTiroDoble(),"Tiro Doble",aux.getNominaJugadores().get(i).getNombre());
        	dataset.setValue(aux.getNominaJugadores().get(i).getPuntoJugador().getTiroTriple(),"Tiro Triple",aux.getNominaJugadores().get(i).getNombre());
		}
/*        dataset.setValue(8, "Mujeres", "Lunes");
        dataset.setValue(7, "Hombres", "Lunes");
        dataset.setValue(9, "Mujeres", "Martes");
        dataset.setValue(4, "Hombres", "Martes");
        dataset.setValue(4, "Mujeres", "Miercoles");
        dataset.setValue(5, "Hombres", "Miercoles");
        dataset.setValue(8, "Mujeres", "Jueves");
        dataset.setValue(9, "Hombres", "Jueves");
        dataset.setValue(7, "Mujeres", "Viernes");
        dataset.setValue(8, "Hombres", "Viernes");*/
        // Creando el Grafico
        JFreeChart chart = ChartFactory.createBarChart3D
        ("Puntos Acumulado VS Jugadores","Jugadores", "Puntos", 
        dataset, PlotOrientation.VERTICAL, true,true, false);
        //chart.setBackgroundPaint(Color.WHITE);
        chart.getTitle().setPaint(Color.black); 
        CategoryPlot p = chart.getCategoryPlot(); 
        p.setRangeGridlinePaint(Color.BLUE);
        panel.setLayout(new BorderLayout(0, 0));
       // try {
		//	ChartUtilities.saveChartAsJPEG(new File("grafico.jpg"), chart, 878, 507);
		//} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
        //Icon icono = new ImageIcon(new ImageIcon(Principal.class.getResource("/grafico.jpg")).getImage().getScaledInstance(878, 507, Image.SCALE_DEFAULT));
		//lblGrafica.setIcon(icono);
        // Mostrar Grafico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setDisplayToolTips(false);
        panel.add(chartPanel);
        chartPanel.setBounds(0, 0, 878, 507);
    	}
	
	private void cargarTabla() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (int i = 0; i < Baloncesto.getInstance().getMisEquipos().size(); i++) {
			//
					//.getImage().getScaledInstance(ColumnConst, lblLogoequipo11.getHeight(), Image.SCALE_DEFAULT));
			Icon icono111 = new ImageIcon(Baloncesto.getInstance().getMisEquipos().get(i).getLogo().getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
			JLabel log = new JLabel();
			log.setIcon(icono111);
			log.setHorizontalAlignment(SwingConstants.CENTER);
			log.setHorizontalTextPosition(SwingConstants.CENTER);
			//log.setVerticalTextPosition(SwingConstants.BOTTOM);
			//Icon icono222 = new ImageIcon(Baloncesto.getInstance().getJuegoRecord().get(i).getEquipoJuego()[1].getLogo().getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
			//JLabel log1 = new JLabel(Baloncesto.getInstance().getJuegoRecord().get(i).getEquipoJuego()[1].getNombre());
			//log1.setIcon(icono222);
			//log1.setVerticalTextPosition(SwingConstants.BOTTOM);
			//log1.setHorizontalAlignment(SwingConstants.CENTER);
			//log1.setHorizontalTextPosition(SwingConstants.CENTER);
			//JLabel fecha = new JLabel();
			//fecha.setText(Baloncesto.getInstance().getJuegoRecord().get(i).getFechaJuego().getDate()+"/"+Baloncesto.getInstance().getJuegoRecord().get(i).getFechaJuego().getMonth()+"/"+(Baloncesto.getInstance().getJuegoRecord().get(i).getFechaJuego().getYear()));
			//fecha.setHorizontalAlignment(SwingConstants.CENTER);
			//fecha.setHorizontalTextPosition(SwingConstants.CENTER);
			fila[0]= log;
			fila[1] =Baloncesto.getInstance().getMisEquipos().get(i).getNombre();
			model.addRow(fila);
		}
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(60);
		columnModel.getColumn(1).setPreferredWidth(247);

		
	}

}
