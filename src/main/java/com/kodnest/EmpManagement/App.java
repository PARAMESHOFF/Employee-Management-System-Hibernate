package com.kodnest.EmpManagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class App extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
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
	public App() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EMPLOYEE DETAILS");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		lblNewLabel.setBounds(145, 10, 147, 25);
		contentPane.add(lblNewLabel);
		
		JButton ADDEMP = new JButton("ADD EMP");
		ADDEMP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddEmployee add = new AddEmployee();
		        add.setVisible(true);
		        dispose();
				
			}
		});
		ADDEMP.setBounds(46, 62, 127, 44);
		contentPane.add(ADDEMP);
		
		JButton search = new JButton("SEARCH EMP");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchEmp ser = new SearchEmp();
				ser.setVisible(true);
				dispose();
			}
		});
		search.setBounds(276, 62, 127, 44);
		contentPane.add(search);
		
		JButton View = new JButton("VIEW EMP");
		View.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewEmp view = new ViewEmp();
				view.setVisible(true);
				dispose();
			}
		});
		View.setBounds(46, 143, 127, 44);
		contentPane.add(View);
		
		JButton Update = new JButton("UPDATE EMP");
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateEmp update = new UpdateEmp();
				update.setVisible(true);
				dispose();
			}
		});
		Update.setBounds(276, 143, 127, 44);
		contentPane.add(Update);
		
		JButton Delete = new JButton("DELETE EMP");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteEmp delete = new DeleteEmp();
				delete.setVisible(true);
				dispose();
			}
		});
		Delete.setBounds(165, 210, 122, 43);
		contentPane.add(Delete);

	}
}
