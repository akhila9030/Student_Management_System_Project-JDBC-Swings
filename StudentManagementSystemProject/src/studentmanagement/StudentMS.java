package studentmanagement;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StudentMS {

	private JButton displayBtn;
	private JButton customeDisplayBtn;
	private JButton insertBtn;
	private JButton deleteBtn;
	private JButton updateBtn;
	private JFrame frame;
	public StudentMS() {
		
		frame = new JFrame("Student Management System Project");
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		frame.setLayout(null);

        //  Title
        JLabel heading = new JLabel("STUDENT MANAGEMENT SYSTEM");
        heading.setBounds(95, 20, 250, 20);
        frame.add(heading);
             
        // Buttons
        displayBtn = new JButton("Display Record");
        displayBtn.setBounds(30, 60, 130, 30);
        frame.add(displayBtn);
        
        customeDisplayBtn = new JButton("Custome Display Record");
        customeDisplayBtn.setBounds(175, 60, 175, 30);
        frame.add(customeDisplayBtn);
        
        insertBtn = new JButton("Insert Record");
        insertBtn.setBounds(30, 120, 130, 30);
        frame.add(insertBtn);
        
        deleteBtn = new JButton("Delete Record");
        deleteBtn.setBounds(185, 120, 130, 30);
        frame.add(deleteBtn);
        
        updateBtn = new JButton("Update Record");
        updateBtn.setBounds(125, 180, 130, 30);
        frame.add(updateBtn);
        
        frame.setVisible(true);
        setUpButtons();
		
	}
	private void openFrame(JFrame childFrame) {
		int sideX = frame.getX() + frame.getWidth() -100;
		int sideY = frame.getY();
		childFrame.setLocation(sideX, sideY);
		childFrame.setVisible(true);
	}
	
	
	private void setUpButtons() {

		insertBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				openFrame(new InsertFrame());
			}
			
		});
		
		deleteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				openFrame(new DeleteFrame());
			}
			
		});
		
		updateBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				openFrame(new UpdateFrame());
			}
			
		});
		
		displayBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				openFrame(new DisplayFrame());
			}
			
		});
		
		customeDisplayBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				openFrame(new CustomeDisplayFrame());
			}
			
		});
		
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(()-> {
			new StudentMS();
		});
	}
	
}
 
   
  



