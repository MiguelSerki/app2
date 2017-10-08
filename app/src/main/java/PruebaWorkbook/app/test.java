package PruebaWorkbook.app;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

public class test extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private static JsoupRun jsoup;
	private WorkBook excel;
	private static int rowInt;
	private static int cell;
	private JScrollPane scrollPane;
	private JTable table;
	private String[]column;
	private Object [][] row;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
					frame.setVisible(true);
					jsoup = new JsoupRun ();
					cell = 1;
					rowInt = 24;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar link");
		btnAgregar.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
			jsoup.getLink(textField.getText());
			int i = jsoup.getData();
			jsoup.setAmount(1);
			if (i == 1) {
				JOptionPane.showMessageDialog(null, "Invalido, intente de nuevo");
			}
			else {
				((DefaultTableModel) table.getModel()).addRow(new Object[]{jsoup.getName(),jsoup.getAmount(),jsoup.getExpansion(),jsoup.getCategory(),jsoup.getPrice(), jsoup.getLink()});
				}
			textField.setText(null);
			}
		});
		
		column = new String []{"Nombre de la carta",
				"Cantidad", 
				"Edición",
				"Condición",
				"Precio", 
				"Link"};
row = new Object[][] {{}
};
		scrollPane = new JScrollPane();
		
		JLabel lblInserteElLink = new JLabel("Inserte el link de la carta");
		lblInserteElLink.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			if ((JOptionPane.showConfirmDialog(contentPane, "Desea finalizar?") == 0)){
				
				FileChooser chooser = new FileChooser();
				try {
					chooser.pickMe();
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				File a = new File("Pedido.xls");
				File b = null;
				try {
					b = new File(chooser.pickMe().getAbsolutePath());
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				CopyFile copy = new CopyFile ();
				try {
					copy.copy(a, b);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				excel = new WorkBook ();
				try {
					excel.edditExcel(rowInt, cell, "Pedido2.xls", table);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
			}
				

			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(547)
					.addComponent(btnAgregar))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblInserteElLink, GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(675, Short.MAX_VALUE)
					.addComponent(btnFinalizar)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(4)
					.addComponent(lblInserteElLink, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnAgregar)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnFinalizar)
					.addContainerGap())
		);
		
		table = new JTable(row,column);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre de la carta", "Cantidad", "Edici\u00F3n", "Condici\u00F3n", "Precio", "Link"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, String.class, String.class, Double.class, String.class
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
		table.getColumnModel().getColumn(5).setPreferredWidth(200);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
