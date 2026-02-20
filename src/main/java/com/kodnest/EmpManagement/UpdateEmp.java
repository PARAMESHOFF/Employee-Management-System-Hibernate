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

public class UpdateEmp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id;
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
					UpdateEmp frame = new UpdateEmp();
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
	public UpdateEmp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UPDATE EMPLOYEE");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lblNewLabel.setBounds(140, 10, 153, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 10));
		lblNewLabel_1.setBounds(111, 70, 10, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("NAME");
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 10));
		lblNewLabel_1_1.setBounds(91, 107, 30, 21);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("SALARY");
		lblNewLabel_1_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 10));
		lblNewLabel_1_2.setBounds(83, 144, 38, 21);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("DESIGNATION");
		lblNewLabel_1_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 10));
		lblNewLabel_1_3.setBounds(52, 181, 69, 21);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("DEPARTMENT");
		lblNewLabel_1_4.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 10));
		lblNewLabel_1_4.setBounds(52, 218, 69, 21);
		contentPane.add(lblNewLabel_1_4);
		
		id = new JTextField();
		id.setFont(new Font("Yu Gothic Light", Font.PLAIN, 10));
		id.setBounds(140, 67, 121, 27);
		contentPane.add(id);
		id.setColumns(10);
		
		name = new JTextField();
		name.setFont(new Font("Yu Gothic Light", Font.PLAIN, 10));
		name.setColumns(10);
		name.setBounds(140, 104, 121, 27);
		contentPane.add(name);
		
		salary = new JTextField();
		salary.setFont(new Font("Yu Gothic Light", Font.PLAIN, 10));
		salary.setColumns(10);
		salary.setBounds(140, 141, 121, 27);
		contentPane.add(salary);
		
		desg = new JTextField();
		desg.setFont(new Font("Yu Gothic Light", Font.PLAIN, 10));
		desg.setColumns(10);
		desg.setBounds(140, 178, 121, 27);
		contentPane.add(desg);
		
		dep = new JTextField();
		dep.setFont(new Font("Yu Gothic Light", Font.PLAIN, 10));
		dep.setColumns(10);
		dep.setBounds(140, 215, 121, 27);
		contentPane.add(dep);
		
		JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(UpdateEmp.this, "Enter the ID to Update the Employee");
					id.requestFocus();
					return;
				}
				if(name.getText().trim().isEmpty() &&
						   salary.getText().trim().isEmpty() &&
						   desg.getText().trim().isEmpty() &&
						   dep.getText().trim().isEmpty()) {

						    JOptionPane.showMessageDialog(UpdateEmp.this,
						        "Enter at least one field to update");
						    return;
						}
				Session session = Hibernate.getSession();
				Transaction tx = session.beginTransaction();
				
				Employee emp = session.get(Employee.class, Integer.parseInt(id.getText()));
				
				if(emp != null) {
					
					if(!name.getText().trim().isEmpty()) {
						emp.setName(name.getText());
					}
					
					if(!salary.getText().trim().isEmpty()) {
						emp.setSalary(Integer.parseInt(salary.getText()));
					}
					
					if(!desg.getText().trim().isEmpty()) {
						emp.setDesignation(desg.getText());
					}
					
					if(!dep.getText().trim().isEmpty()) {
						emp.setDepartment(dep.getText());
					}
					id.setText("");
					name.setText("");
					salary.setText("");
					desg.setText("");
					dep.setText("");
				}
				else {
					JOptionPane.showMessageDialog(UpdateEmp.this, "No Emp Found This ID: " + id.getText() );
					id.setText("");
					name.setText("");
					salary.setText("");
					desg.setText("");
					dep.setText("");
					id.requestFocus();
				}
				
				session.close();

				 
				
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		btnNewButton.setBounds(299, 107, 95, 32);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				App app = new App();
		        app.setVisible(true);
		        dispose();
			}
		});
		btnBack.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		btnBack.setBounds(299, 181, 95, 32);
		contentPane.add(btnBack);

	}

}
