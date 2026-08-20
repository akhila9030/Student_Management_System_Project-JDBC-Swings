package studentmanagement;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class DeleteFrame extends JFrame {

	private int id;
	
	private JTextField idInput ;
	
	private JTextArea area;
	
	private JButton deleteBtn;
	
	private StudentApp studentapp; 
	
	public DeleteFrame() {
		setTitle("Deletion");
		setSize(400,300);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setLayout(new BorderLayout(10, 10));
		
		JLabel heading = new JLabel("DELETE RECORDS", SwingConstants.CENTER);
        add(heading, BorderLayout.NORTH);
        
		JPanel centerPanel = new JPanel(new GridLayout(3, 1, 5, 10));
        centerPanel.setBorder(new EmptyBorder(10, 20, 10, 20)); 
        
        JPanel first = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel idLabel = new JLabel("Id");
        idInput = new JTextField(10);
        first.add(idLabel);
        first.add(idInput);
        centerPanel.add(first);
        
        JPanel second = new JPanel(new FlowLayout(FlowLayout.CENTER));
        deleteBtn = new JButton("Delete Record");
        second.add(deleteBtn);
        centerPanel.add(second);
        
        JPanel third = new JPanel(new FlowLayout(FlowLayout.LEFT));
        area = new JTextArea(400,300);
        area.setEditable(false);
        third .add(area );
        centerPanel.add(third );
        
        add(centerPanel,BorderLayout.CENTER);
		
		setUpButtons();
 
	}

	private void setUpButtons() {

		studentapp = new StudentApp();
		deleteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					String inputId = idInput.getText();
					
					if(inputId.isEmpty()) {
						JOptionPane.showMessageDialog(deleteBtn, "Id is Empty");
						return;
					}
					id = Integer.parseInt(inputId);
					
					int result = studentapp.delete(id);
					if(result>0) {
						area.setText("Student record with id "+id+" deleted successfully");					
						
					}
					else {
						area.setText(" Deletion not possible! No Student Record is there with id "+id);		
					}
					
				} catch (NumberFormatException e1) {

					JOptionPane.showMessageDialog(deleteBtn, "Valid input only");
				}
				catch(Exception e2) {
					JOptionPane.showMessageDialog(deleteBtn, e2.getMessage());
				}
			}
			
		});
	}
}
