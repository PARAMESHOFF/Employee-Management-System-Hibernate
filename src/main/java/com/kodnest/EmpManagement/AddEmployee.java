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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddEmployee extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField salary;
	private JTextField desg;
	private JTextField dep;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmployee frame = new AddEmployee();
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
	public AddEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD EMPLOYEE");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lblNewLabel.setBounds(157, 10, 145, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NAME ");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(73, 77, 50, 24);
		contentPane.add(lblNewLabel_1);
		
		name = new JTextField();
		name.setBounds(133, 78, 108, 24);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("SALARY ");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(66, 116, 57, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DESIGNATION ");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 10));
		lblNewLabel_3.setBounds(35, 150, 88, 24);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("DEPARTMENT");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 10));
		lblNewLabel_4.setBounds(40, 184, 83, 24);
		contentPane.add(lblNewLabel_4);
		
		salary = new JTextField();
		salary.setBounds(133, 114, 108, 24);
		contentPane.add(salary);
		salary.setColumns(10);
		
		desg = new JTextField();
		desg.setBounds(133, 151, 108, 24);
		contentPane.add(desg);
		desg.setColumns(10);
		
		dep = new JTextField();
		dep.setBounds(133, 185, 108, 24);
		contentPane.add(dep);
		dep.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(name.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(AddEmployee.this, "Please Enter Name");
					name.requestFocus();
					return;
				}
				if(salary.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(AddEmployee.this, "Please Enter Salary");
					salary.requestFocus();
					return;
				}
				if(desg.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(AddEmployee.this, "Please Enter Designation");
					desg.requestFocus();
					return;
				}
				if(dep.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(AddEmployee.this, "Please Enter Department");
					dep.requestFocus();
					return;
				}
				String nname = name.getText();
				int nsalary = Integer.parseInt(salary.getText());
				String ndes = desg.getText();
				String ndep =  dep.getText();
				Employee emp = new Employee(nname, nsalary, ndes, ndep);
				Session session = Hibernate.getSession();
				Transaction tx = session.beginTransaction();
				session.persist(emp);
				tx.commit();
				
				
				
				int generatedId = emp.getId();   

				JOptionPane.showMessageDialog(AddEmployee.this,
				        "Employee added successfully!\nEmployee ID: " + generatedId);

				name.setText("");
				salary.setText("");
				desg.setText("");
				dep.setText("");
				session.close();
				
				
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		btnNewButton.setBounds(293, 79, 100, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				App app = new App();
		        app.setVisible(true);
		        dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		btnNewButton_1.setBounds(293, 152, 100, 31);
		contentPane.add(btnNewButton_1);

	}

}
