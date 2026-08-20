package studentmanagement;

import java.awt.BorderLayout;


import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class InsertFrame extends JFrame {
	
	private int id;
	private String name;
	private String course;
	private int marks;
	
	private JTextField idInput;
	private JTextField nameInput;
	private JTextField courseInput;
	private JTextField marksInput;

	private JTextArea area;
	private JButton insertBtn;
	
	private StudentApp studentapp;
	
	public InsertFrame() {
		setTitle("Insertion");
		setSize(400,300);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setLayout(new BorderLayout(10, 10));
		
		JLabel heading = new JLabel("INSERT RECORDS", SwingConstants.CENTER);
        add(heading, BorderLayout.NORTH);
        
		JPanel centerPanel = new JPanel(new GridLayout(4, 1, 5, 10));
        centerPanel.setBorder(new EmptyBorder(10, 20, 10, 20)); 
        
        // first
        
        JPanel first = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel idLabel = new JLabel("Id");
        idInput = new JTextField(10);
        JLabel nameLabel = new JLabel("Name ");
        nameInput = new JTextField(10);
        first.add(idLabel);
        first.add(idInput);
        first.add(nameLabel);
        first.add(nameInput);
        centerPanel.add(first);
		
        // second 
        JPanel second = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel courseLabel = new JLabel("Course");
        courseInput = new JTextField(9);
        JLabel marksLabel = new JLabel("Marks ");
        marksInput = new JTextField(9);
        second.add(courseLabel);
        second.add(courseInput);
        second.add(marksLabel);
        second.add(marksInput);
        centerPanel.add(second);
        
        // third 
        
        JPanel third = new JPanel(new FlowLayout(FlowLayout.CENTER));
        insertBtn = new JButton("Insert Record");
        third.add(insertBtn);
        centerPanel.add(third);
        
        // fourth
        
        JPanel fourth = new JPanel(new FlowLayout(FlowLayout.LEFT));
        area = new JTextArea(350,250);
        area.setEditable(false);
        fourth.add(area);
        centerPanel.add(fourth);
        
        
		add(centerPanel,BorderLayout.CENTER);
		
		setUpButtons();
	}


	private void setUpButtons() {

		studentapp = new StudentApp();
		Student student = new Student();
		insertBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					
					id = Integer.parseInt(idInput.getText());
					name = nameInput.getText();
					course = courseInput.getText();
					marks = Integer.parseInt(marksInput.getText());
				
					student.setId(id);
					student.setName(name);
					student.setCourse(course);
					student.setMarks(marks);
					int result = studentapp.insert(student);
					if(result>0) {
						area.setText(result+" student record inserted sucessfully!");
					}
					
				} catch (NumberFormatException e1) {

					JOptionPane.showMessageDialog(insertBtn, "Valid input only");
				}
				catch(Exception e2) {
					JOptionPane.showMessageDialog(insertBtn, e2.getMessage());
				}
			}
			
		});
	}
}
