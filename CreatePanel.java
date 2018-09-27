// Assignment #: 6 
//         Name: Giovanni Palomo
//    StudentID: 1210682158
//      Lecture: MWF 8:35am
//  Description: the CreatePanel class in java creates the 
//               create tab in the GUI for assignment 6 (tabbed pane)

import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.util.*;

public class CreatePanel extends JPanel
 {
   private Vector <Project> projectList;//vector shared between the two panel classes 
   private JButton button1;
   private JLabel label1, label2, label3, label4;
   private JTextField field1,field2,field3;
   private JTextArea area1;
   private JPanel panel1,panel2,panel3,panel4;
   private SelectPanel sPanel;
   private JScrollPane scroll;
   private JList projList;
   
   private String projName, projLocation;
   private int projNum;
   private boolean error1,error2,error3,error4;

 //Constructor initializes components and organize them using certain layouts
 public CreatePanel(Vector <Project> projectList, SelectPanel sPanel)
  {
    this.projectList = projectList;
    
    this.sPanel = sPanel;
    //area1 = new JTextArea(this.projectList.toString());
    area1 = new JTextArea("No Project");
    label1 = new JLabel("Project Title");
    label2 = new JLabel("Project Number");
    label3 = new JLabel("Project Location");
    label4 = new JLabel("");
    field1 = new JTextField();
    field2 = new JTextField();
    field3 = new JTextField();
    button1 = new JButton("Create a project");
    projList = new JList(projectList);
    
    panel1 = new JPanel(); //grid panel
    panel1.setLayout(new GridLayout(4,2));
    panel1.add(label1);
    panel1.add(field1);
    panel1.add(label2);
    panel1.add(field2);
    panel1.add(label3);
    panel1.add(field3); 
    
    panel4 = new JPanel();
    panel4.setLayout(new FlowLayout());
    panel4.add(button1);
    
    panel2 = new JPanel();
    panel2.setLayout(new GridLayout(3,1));
    panel2.add(panel4);
    
    panel3 = new JPanel(); //left side panel
    panel3.setLayout(new GridLayout(3,1));
    panel3.add(label4);
    label4.setForeground(Color.RED);
    panel3.add(panel1);
    panel3.add(panel2);  
      // orgranize components here
      // here is an example
      
     // button1 = new JButton("Create a project");
      
    scroll = new JScrollPane(area1, 
		    ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
		    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);//adds the text area to a scroll pane
      
      setLayout(new GridLayout(1,2));
      add(panel3);
     // add(button1);
     // add(area1);
      add(scroll);
     // JScrollPane sp = new JScrollPane(area1);
      
      
      button1.addActionListener(new ButtonListener()); //register the listener object with the button to add projecs 
  }


  //ButtonListener is a listener class that listens to
  //see if the buttont "Create a project" is pushed.
  //When the event occurs, it add the project information
  //in the text fields to the text area
  //and the list of project information,
  //and it also does error checking.
  private class ButtonListener implements ActionListener
   {
    public void actionPerformed(ActionEvent event)
     {
    	
    	//booleans for use with the error handling of adding a project
		error1=false;
		error2=false;
		error3=false;
		error4=false;
		Object source = event.getSource();
		
		
		
		if(source == button1 && field1.getText().length() > 0 && field3.getText().length()>0 && field2.getText().length()>0) //proj must have all fields filled 
		{
			
			try
			{
				projNum = Integer.parseInt(field2.getText());	//tries to parse the value as an int, sends error if not int
				projName = (field1.getText());
				projLocation = field3.getText();
							
			}
			catch (java.lang.NumberFormatException e1)
			{
				label4.setText("Please enter an integer for the project number");//error message to print
				error1 = true;
				field1.setText("");//resets the fields so loop doesnt get stuck 
				field2.setText("");
				field3.setText("");
				//projList.clearSelection();	
				//projNum = Integer.parseInt(field2.getText());
				return;
			}
			
			
			for(int i=0;i<projectList.size();i++)//for loop to cycle through vector
			{
				
				
				if(projectList.get(i).getProjNumber() == projNum || projectList.get(i).getProjTitle().equals(projName))//searches for duplicate project numbers and duplicate project names
				{
					label4.setText("Duplicate projects not allowed");
					error4 = true;
					field1.setText("");//resets fields
					field2.setText("");
					field3.setText("");
					//projList.clearSelection();
					//break;
					//return;
				}
			}
			
		
				
		
			
			if(error1 != true && error2 != true && error3 != true && error4 != true)//if all criteria are met for it to be a new project, creates and adds to vector
			{
				
				Project proj = new Project();
				proj.setProjLocation(projLocation);
				proj.setProjNumber(projNum);
				proj.setProjTitle(projName);
				
				projectList.add(proj);
				sPanel.updateProjectList();
				if(projectList.size() == 1)
				{
					area1.setText("");
				}
				//projList.add(projectList.get);
				area1.append(proj.toString());
				field1.setText("");
				field2.setText("");
				field3.setText("");
		 		//clear the selection from countryList
		 		//projList.clearSelection();
		 		label4.setText("Project added.");
		 		//projNum = 0;
				//return;
			}
			
			//projList.clearSelection();
			
		}
		
		else if(source == button1 && (field1.getText().length() == 0 || field3.getText().length() == 0))
		{
			label4.setText("Please enter all fields");
			//error2 = true;
			field1.setText("");
			field2.setText("");
			field3.setText("");
			//projList.clearSelection();
			//projName = (field1.getText());
			//projLocation = field3.getText();
		}
		
		else
		{
			label4.setText("Please enter all fields");

			field1.setText("");
			field2.setText("");
			field3.setText("");
			//projList.clearSelection();
		}
	

		
			//label4.setText("Please enter all fields");
			
		
         // if there is no error, add a project to project list
         // otherwise, show an error message

     } //end of actionPerformed method
  } //end of ButtonListener class
  


} //end of CreatePanel class