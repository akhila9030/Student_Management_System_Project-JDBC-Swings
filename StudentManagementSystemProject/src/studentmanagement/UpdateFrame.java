package studentmanagement;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class UpdateFrame extends JFrame {

	private int id;
	private String newName;
	private String newCourse;
	private int newMarks;
	
	private JTextField idInput;
	private JTextField newOption;
	
	private JTextArea area;
	
	private JButton updateBtn;
	
	private JCheckBox nameBox;
	private JCheckBox courseBox;
	private JCheckBox marksBox;
	
	private StudentApp studentapp;
	
	public UpdateFrame() {
		setTitle("Updation");
		setSize(400,300);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setLayout(new BorderLayout(10, 10));
		
		JLabel heading = new JLabel("UPDATE RECORDS", SwingConstants.CENTER);
        add(heading, BorderLayout.NORTH);
        
		JPanel centerPanel = new JPanel(new GridLayout(5, 1, 5, 10));
        centerPanel.setBorder(new EmptyBorder(10, 20, 10, 20)); 
        
        JPanel first = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel idLabel = new JLabel("Id");
        idInput = new JTextField(10);
        first.add(idLabel);
        first.add(idInput);
        centerPanel.add(first);
        
        JPanel second = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel choice = new JLabel("select options to update ");
        nameBox = new JCheckBox("Name");
        courseBox = new JCheckBox("Course");
        marksBox = new JCheckBox("Marks");
        second.add(choice);
        second.add(nameBox);
        second.add(courseBox);
        second.add(marksBox);
        centerPanel.add(second);
        
        JPanel fourth = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel optionLabel = new JLabel("New");
        newOption = new JTextField(10);
        updateBtn = new JButton("Update");
        fourth.add(optionLabel);
        fourth.add(newOption);
        fourth.add(updateBtn);
        centerPanel.add(fourth);
       
        
        JPanel sixth = new JPanel(new FlowLayout(FlowLayout.LEFT));
        area = new JTextArea(350,250);
        area.setEditable(false);
        sixth.add(area);
        centerPanel.add(sixth);
        
        add(centerPanel,BorderLayout.CENTER);
        
        setUpButtons();
	}

	private void setUpButtons() {
		
		studentapp = new StudentApp();
		Student student = new Student();
		updateBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
				String inputId = idInput.getText();
				if(inputId.isEmpty()) {
					JOptionPane.showMessageDialog(updateBtn, "Id is Empty");
					return;
				}
				id = Integer.parseInt(inputId);
				
				if(nameBox.isSelected()) {
					newName = newOption.getText();
					if(newName.isEmpty()) {
						JOptionPane.showMessageDialog(updateBtn, "To perform updation,You should give new input");
					}
					else {
						student.setId(id);
						student.setName(newName);
					area.setText(studentapp.updateName(student));
					}
				}
				else if(courseBox.isSelected()) {
					newCourse = newOption.getText();
					if(newCourse.isEmpty()) {
						JOptionPane.showMessageDialog(updateBtn, "To perform updation,You should give new input");
					}
					else {
						student.setId(id);
						student.setCourse(newCourse);;
					area.setText(studentapp.updateCourse(student));
					}
					
				}
				else if(marksBox.isSelected()){
					
					String input = newOption.getText();
					if(input.isEmpty()) {
						JOptionPane.showMessageDialog(updateBtn, "To perform updation,You should give new input");
					}
					else {
					newMarks = Integer.parseInt(input);	
					student.setId(id);
					student.setMarks(newMarks);;
					area.setText(studentapp.updateMarks(student));
					}
					
				}
				else {
					JOptionPane.showMessageDialog(updateBtn, "select at least one to perform updation");
				}
				}catch (NumberFormatException e1) {

					JOptionPane.showMessageDialog(updateBtn, "Valid input only");
				}
				catch(Exception e2) {
					JOptionPane.showMessageDialog(updateBtn, e2.getMessage());
				}
			}
			
		});
	}

}
