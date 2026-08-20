package studentmanagement;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class DisplayFrame extends JFrame {

	private int id;
	
	private JTextField idInput;
	
	private JButton fetchBtn;
	
	private JTextArea area;
	
	private StudentApp studentapp;

	public DisplayFrame() {
		
		setTitle("Display");
		setSize(400,300);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setLayout(new BorderLayout(10, 10));
		
		JLabel heading = new JLabel("STUDENT DETAILS", SwingConstants.CENTER);
        add(heading, BorderLayout.NORTH);
        
		JPanel centerPanel = new JPanel(new GridLayout(4, 1, 5, 10));
        centerPanel.setBorder(new EmptyBorder(10, 20, 10, 20)); 
        
        JPanel first = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel idLabel = new JLabel("Id");
        idInput = new JTextField(10);
        first.add(idLabel);
        first.add(idInput);
        centerPanel.add(first);
        
        JPanel second = new JPanel(new FlowLayout(FlowLayout.CENTER));
        fetchBtn = new JButton("Fetch");
        second.add(fetchBtn);
        centerPanel.add(second);
        
        JPanel third = new JPanel(new FlowLayout(FlowLayout.LEFT));
        area = new JTextArea(350,250);
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
					area.setText(studentapp.display(id));
				} catch (NumberFormatException e1) {

					JOptionPane.showMessageDialog(fetchBtn, "Valid input only");
				}
				catch(Exception e2) {
					JOptionPane.showMessageDialog(fetchBtn, e2);
				}
				
			}
			
		});
	}
}
