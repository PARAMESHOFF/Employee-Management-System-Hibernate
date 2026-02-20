package com.kodnest.EmpManagement;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;

import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ViewEmp extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	private JButton btnBack;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEmp frame = new ViewEmp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewEmp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);

		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblTitle = new JLabel("VIEW EMPLOYEE");
		lblTitle.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		lblTitle.setBounds(160, 10, 200, 25);
		contentPane.add(lblTitle);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 446, 216);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("NAME");
		model.addColumn("GENDER");
		model.addColumn("SALARY");

		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "NAME", "SALARY", "DESIGNATION", "DEPARTMENT"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, String.class, Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);

		// VERY IMPORTANT LINE
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("VIEW");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Session session = Hibernate.getSession();
				List<Employee> emp = session.createQuery("from Employee", Employee.class).list();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				for(Employee em : emp) {
				    model.addRow(new Object[]{
				        em.getId(),
				        em.getName(),
				        em.getSalary(),
				        em.getDesignation(),
				        em.getDepartment()
				    });
				}
				session.close();
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		btnNewButton.setBounds(45, 271, 96, 32);
		contentPane.add(btnNewButton);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				App app = new App();
		        app.setVisible(true);
		        dispose();
			}
		});
		btnBack.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		btnBack.setBounds(264, 271, 96, 32);
		contentPane.add(btnBack);
	}
}
