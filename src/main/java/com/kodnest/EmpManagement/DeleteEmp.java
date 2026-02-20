package com.kodnest.EmpManagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteEmp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteEmp frame = new DeleteEmp();
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
	public DeleteEmp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DELETE EMPLOYEE");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lblNewLabel.setBounds(140, 10, 141, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID    :");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		lblNewLabel_1.setBounds(32, 112, 40, 21);
		contentPane.add(lblNewLabel_1);
		
		id = new JTextField();
		id.setBounds(82, 111, 117, 26);
		contentPane.add(id);
		id.setColumns(10);
		
		JButton btnNewButton = new JButton("DELETE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(DeleteEmp.this, "Enter the ID to Delete Employee");
					id.requestFocus();
					return;
				}
				
				Session session = Hibernate.getSession();
				Employee emp = session.get(Employee.class, Integer.parseInt(id.getText()));
				if(emp != null) {
				session.remove(emp);
				JOptionPane.showMessageDialog(DeleteEmp.this, "Employee Deleted Succesfully");
				id.setText("");
				id.requestFocus();
				return;
			} else {
				JOptionPane.showMessageDialog(DeleteEmp.this, "No Employee is to Delete in this ID : " + id.getText());
				id.setText("");
				id.requestFocus();
				
			}
				
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		btnNewButton.setBounds(269, 70, 101, 32);
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
		btnBack.setBounds(269, 154, 101, 32);
		contentPane.add(btnBack);

	}

}
