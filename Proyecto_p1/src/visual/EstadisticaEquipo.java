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
import logico.Jugador;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.border.TitledBorder;

public class EstadisticaEquipo extends JDialog{

	private final JPanel contentPanel = new JPanel();
	private JPanel Grafico;
	private JTable table;
	
	private static DefaultTableModel model;
	private static Object[] fila;
	
	private ArrayList<Equipo> rankEquipos = new ArrayList<Equipo>();
	
	public EstadisticaEquipo() {
		setTitle("Estadisticas De Equipos");
		setBounds(100, 100, 871, 601);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		Grafico = new JPanel();
		Grafico.setBounds(10, 11, 640, 507);
		contentPanel.add(Grafico);
		
		JPanel Ranking = new JPanel();
		Ranking.setBorder(new TitledBorder(null, "Ranking:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Ranking.setBounds(660, 11, 185, 507);
		contentPanel.add(Ranking);
		Ranking.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			Ranking.add(scrollPane, BorderLayout.CENTER);
			{
				String[] header = {"Rank", "Equipo"};
				model = new DefaultTableModel(null, header){
					@Override
					public boolean isCellEditable(int filas, int columnas) {
							return false;
					}
				};
				table = new JTable();
				
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table.setModel(model);
				cargarTabla();
				scrollPane.setViewportView(table);
			}
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		init();
	}
	
    private void cargarTabla() {
    	setArray();
    	
    	int i = 1;
		
    	model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (Equipo team : rankEquipos) {
			fila[0] = Integer.toString(i);
			fila[1] = team.getNombre();
			model.addRow(fila);
			
			i++;
		}
	}

	private void setArray() {
		int j;
		int juegosGanados;
		Equipo temp;
		
		clonarEquipo();
		
		for (int i = 1; i < rankEquipos.size(); i++) {
			juegosGanados = rankEquipos.get(i).getPuntos();
			j = i - 1;
			while(j >= 0 && juegosGanados > rankEquipos.get(j).getPuntos()) {
				temp = rankEquipos.get(j);
				rankEquipos.set(j, rankEquipos.get(j + 1));
				rankEquipos.set(j + 1, temp);
				j--;
			}
		}
		
	}
	
	private void clonarEquipo() {
		for (Equipo aux : Baloncesto.getInstance().getMisEquipos()) {
			rankEquipos.add(aux);
		}
	}

	private void init() {
		Grafico.setOpaque(false);
  
        // Fuente de Datos
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Equipo aux : Baloncesto.getInstance().getMisEquipos()) {
        	dataset.setValue(aux.getPuntos(),"Juegos Ganados",aux.getNombre());
        	dataset.setValue(aux.getJuegosPerdidos(),"Juegos Perdidos",aux.getNombre());
		}

        // Creando el Grafico
        JFreeChart chart = ChartFactory.createBarChart3D
        ("Juegos Ganados VS Equipos","Equipos", "Juegos ganados", 
        dataset, PlotOrientation.VERTICAL, true,true, false);
        chart.getTitle().setPaint(Color.black); 
        CategoryPlot p = chart.getCategoryPlot(); 
        p.setRangeGridlinePaint(Color.BLUE);
        Grafico.setLayout(new BorderLayout(0, 0));
    
        // Mostrar Grafico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setDisplayToolTips(true);
        Grafico.add(chartPanel);
        chartPanel.setBounds(0, 0, 878, 507);
    	}
}
