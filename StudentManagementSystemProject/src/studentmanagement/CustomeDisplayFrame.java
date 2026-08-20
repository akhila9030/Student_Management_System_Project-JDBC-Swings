package studentmanagement;

import java.awt.BorderLayout;


import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class CustomeDisplayFrame extends JFrame {

	private int id;
	
	private JTextField idInput;
	
	private JCheckBox idBox;
	private JCheckBox nameBox;
	
	private JButton fetchBtn;
	
	private JTextArea area;
	
	private StudentApp studentapp;
	
	public CustomeDisplayFrame() {
		
		setTitle("Custome Display");
		setSize(400,300);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setLayout(new BorderLayout(10, 10));
		
		JLabel heading = new JLabel("CUSTOME STUDENT DETAILS", SwingConstants.CENTER);
        add(heading, BorderLayout.NORTH);
        
		JPanel centerPanel = new JPanel(new GridLayout(3, 1, 5, 10));
        centerPanel.setBorder(new EmptyBorder(10, 20, 10, 20)); 
        
        JPanel first = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel idLabel = new JLabel("Id");
        idInput = new JTextField(10);
        JLabel label = new JLabel("Details");
        idBox = new JCheckBox("Id");
        nameBox = new JCheckBox("Name");
        first.add(idLabel);
        first.add(idInput);
        first.add(label);
        first.add(idBox);
        first.add(nameBox);
        centerPanel.add(first);
        
        JPanel second = new JPanel(new FlowLayout(FlowLayout.CENTER));
        fetchBtn = new JButton("Fetch");
        second.add(fetchBtn);
        centerPanel.add(second);
        
        JPanel third = new JPanel(new FlowLayout(FlowLayout.LEFT));
        area = new JTextArea(400,300);
        area.setEditable(false);
        third.add(area);
        centerPanel.add(third);
        
        add(centerPanel,BorderLayout.CENTER);
        
        setUpButtons();
        
	}

	private void setUpButtons() {

		studentapp = new StudentApp();
		
		fetchBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					
					String inputId = idInput.getText();
					if(inputId.isEmpty()) {
						JOptionPane.showMessageDialog(fetchBtn, "Id shouldn't be empty");
						return;
					}
					
					id = Integer.parseInt(inputId);
					
					if(idBox.isSelected() && nameBox.isSelected()) {
						area.setText(studentapp.customeDisplay(id));
					}
					else {
						area.setText("you should select id and name to fetch student record");
					}
				} catch (NumberFormatException e1) {

					JOptionPane.showMessageDialog(fetchBtn, "Valid input only");
				}
				catch(Exception e2) {
					JOptionPane.showMessageDialog(fetchBtn, e2.getMessage());
				}			
			}
			
		});
		
		
	}
}
