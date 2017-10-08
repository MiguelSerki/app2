package PruebaWorkbook.app;

import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Scrollbar;
import javax.swing.border.SoftBevelBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Table {

	private JFrame frame;
	private String [] column;
	private Object [][]row;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Table window = new Table();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Table() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		column = new String []{"Nombre de la carta",
								"Cantidad", 
								"Edición",
								"Condición",
								"Precio", 
								"Subtotal", 
								"Link"};
		row = new Object[][] {{" Nombre",0," Edición"," Condición",0,0,"","","",""}
			};
		
		JScrollPane scrollPane = new JScrollPane();

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable(row,column);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{" Nombre", new Integer(0), " Edici\u00F3n", " Condici\u00F3n", null, null, ""},
			},
			new String[] {
				"Nombre de la carta", "Cantidad", "Edici\u00F3n", "Condici\u00F3n", "Precio", "Subtotal", "Link"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, String.class, String.class, Double.class, Double.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(153);
		table.getColumnModel().getColumn(1).setPreferredWidth(54);
		table.getColumnModel().getColumn(2).setPreferredWidth(128);
		table.getColumnModel().getColumn(3).setPreferredWidth(121);
		table.getColumnModel().getColumn(4).setPreferredWidth(54);
		table.getColumnModel().getColumn(5).setPreferredWidth(62);
		table.getColumnModel().getColumn(6).setPreferredWidth(220);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((DefaultTableModel) table.getModel()).addRow(new Object[]{"",""});
			}
		});
		scrollPane.setRowHeaderView(btnNewButton);
		frame.getContentPane().setLayout(groupLayout);
		
	}
}
