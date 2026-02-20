package com.kodnest.EmpManagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class SearchEmp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchEmp frame = new SearchEmp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SearchEmp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GET EMPLOYEE");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lblNewLabel.setBounds(140, 10, 161, 21);
		contentPane.add(lblNewLabel);
		
		JTextArea result = new JTextArea();
		result.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		result.setBounds(10, 89, 269, 165);
		contentPane.add(result);
		JLabel lblNewLabel_1 = new JLabel("ID   :");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		lblNewLabel_1.setBounds(35, 44, 30, 21);
		contentPane.add(lblNewLabel_1);
		
		ID = new JTextField();
		ID.setBounds(75, 41, 114, 29);
		contentPane.add(ID);
		ID.setColumns(10);

		
		JButton get = new JButton("GET");
		get.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ID.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(SearchEmp.this, "Enter the Emp ID");
					ID.requestFocus();
					return;
				}
				Session session = Hibernate.getSession();
				try {
				int nid = Integer.parseInt(ID.getText());
				
				
				
				
				Employee  emp = session.get(Employee.class, nid);
				
				if(emp != null) {
					result.setText("ID: " + emp.getId() + "\n"+
									"NAME: " + emp.getName() + "\n"+
									 "SALARY: " + emp.getSalary() + "\n"+
									 "DESIGNATION: " + emp.getDesignation()+ "\n"+
									 "DEPARTMENT: " + emp.getDepartment());
				}
				else {
					
				}
				}catch( Exception e1) {
					e1.printStackTrace();
				}
				finally {
					session.close();
				}
			}
		});
		get.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		get.setBounds(320, 86, 94, 29);
		contentPane.add(get);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				App app = new App();
		        app.setVisible(true);
		        dispose();
			}
		});
		btnBack.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		btnBack.setBounds(320, 159, 94, 29);
		contentPane.add(btnBack);
		
		
	}
}
