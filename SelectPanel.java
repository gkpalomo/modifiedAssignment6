// Assignment #: 6
//         Name: Giovanni Palomo
//    StudentID: 1210682158
//      Lecture: MWF 8:35am
//  Description: The SelectPanel class contains a constructor
//				 for the SelectPanel to be used in the tabbed
//				 pane in the assignment6 class

import java.awt.*;   
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.util.*;

public class SelectPanel extends JPanel
 {
   private Vector <Project> projectList, selectedList;//original vector and the selected projects vector 
   private int selectProjs, selectedIndex1,selectedIndex2,selProjNum;
   private String selProjName,selProjLocation;
   private JLabel label1, label2, label3;
   private JPanel buttonPanel, listPanel1, listPanel2, innerPanel;
   private JButton addButton, removeButton;
   private JList list1, list2;//created from the two vectors above
   private JScrollPane sp1, sp2;
   private Project selectedProject1,selectedProject2; 
   //
   
   //Container content = getContentPane();


   //Constructor initialize each component and arrange them using
   //certain layouts
   public SelectPanel(Vector <Project> projectList)
     {
      this.projectList = projectList;
      
      
      selectedList = new Vector<Project>();
     
      
     // Container content = getContentPane();
      
      label1 = new JLabel("Available project(s)");
      //JTextField textField1;
      list1 = new JList<Project>(this.projectList);
      list1.setBorder(BorderFactory.createEtchedBorder());
      list1.setForeground(Color.black);
      list1.setBackground(Color.white);
      //set the foreground color of the selected cell
      list1.setSelectionForeground(Color.red);

      //set the background color of the selected cell
      list1.setSelectionBackground(Color.gray);

      //only allows one item to be slected each time
      list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      //returns the number of visible rows displayed without a scrollbar(default is 8)
      list1.setVisibleRowCount(10);

      //add scrollpane to the JList in case there are more countries to display
      sp1 = new JScrollPane(list1,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
  		    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
   //   sp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
     // scrollPanel1 = new JPanel();
     // scrollPanel1.add(sp1);
      
      addButton = new JButton("Add");
      removeButton = new JButton("Remove");
      //JTextField textField2;

      
      
      
      label2 = new JLabel("Selected project(s)");
      list2 = new JList<Project>(selectedList);
      list2.setBorder(BorderFactory.createEtchedBorder());
      list2.setForeground(Color.black);
      list2.setBackground(Color.white);
     // list2.setSelectionForeground(Color.red);
      //list2.setSelectionBackground(Color.gray);
      //list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      //list2.setVisibleRowCount(10);
      sp2 = new JScrollPane(list2,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
  		    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
     // sp2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      //scrollPanel2 = new JPanel();
     // scrollPanel2.add(sp2);
      label3 = new JLabel("The total number of selected projects: " + selectProjs);
      
      buttonPanel = new JPanel();
      buttonPanel.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));//creates empty border for spacing between elements
      buttonPanel.setLayout(new GridLayout(1,2,8,8));
      buttonPanel.add(addButton);
      addButton.setBorder(BorderFactory.createBevelBorder(4));//creates bevel border for add button
      buttonPanel.add(removeButton);
      removeButton.setBorder(BorderFactory.createBevelBorder(4));//creates bevel border for remove button
      
      listPanel1 = new JPanel();
      listPanel1.setBorder(BorderFactory.createEtchedBorder());//creates etched border
      listPanel1.setLayout(new BorderLayout());
      listPanel1.add(label1, BorderLayout.NORTH);
      listPanel1.add(sp1, BorderLayout.CENTER);
      //listPanel1.add(list1, BorderLayout.CENTER);
      
      listPanel2 = new JPanel();
      listPanel2.setBorder(BorderFactory.createEtchedBorder());//creates border for visual effects
      listPanel2.setLayout(new BorderLayout());
      listPanel2.add(label2, BorderLayout.NORTH);
      listPanel2.add(sp2, BorderLayout.CENTER);
      //listPanel2.add(list2, BorderLayout.CENTER);
       
      
      innerPanel = new JPanel();
      innerPanel.setLayout(new GridLayout(3,1));
      innerPanel.add(listPanel1);
      innerPanel.add(buttonPanel);
      innerPanel.add(listPanel2);    
      
      //selectedProject2 = selectedProject1;
      
      //outsidePanel = new JPanel();
     this.setLayout(new BorderLayout());
      add(innerPanel, BorderLayout.CENTER);
      add(label3, BorderLayout.SOUTH);
      
     // countryList.addListSelectionListener (new CountryListListener()); use this template for jlist
      addButton.addActionListener(new ButtonListener());
      removeButton.addActionListener(new ButtonListener());
     // label3.addActionListener(new ButtonListener());
      list1.addListSelectionListener(new ProjectListListener());
      
      //register the different listener objects with their sources
    
      //add(outsidePanel);
         
       // organize components for the select panel
  }

 //This method updates refresh the JList of projects with
 //updated vector information
 public void updateProjectList()
  {
	 list1.updateUI();
    // calls updateUI() for the JList list1
  }
 
 private class ProjectListListener implements ListSelectionListener
 {
    //implement the abstract method inside ListSelectionListener
    public void valueChanged(ListSelectionEvent event)
    {
       //Decide which country is selected
    	Object source = event.getSource();
    	
    	if(source == list1)
    	{
       selectedProject1 = (Project) list1.getSelectedValue();      
       selectedIndex1 = list1.getSelectedIndex();
    	}
    	
       //selectedIndex2 = list2.getSelectedIndex();
       //selectedList.addElement(selectedProject);
    }
}

 //ButtonListener class listens to see if any of
 //buttons is pushed, and perform their corresponding action.
 private class ButtonListener implements ActionListener //creates the object ButtonListener to use with the add or remove button 
  {
       public void actionPerformed(ActionEvent event)
        {
          
    	   Object source = event.getSource();

           //if user selects a project name and press the "Add" button
           if(source == addButton && !selectedList.contains(selectedProject1) && !selectedProject1.getProjTitle().equals(null))//proj must be non-empty
           {
        	   
   				

   					selectedList.contains(selectedProject1);
   					selectedList.add(selectedProject1);
   					selectProjs += 1; //increments value of selectProjs by 1 each time a project is added to the second jlist
   					label3.setText("The total number of selected projects: " + selectProjs);//updates jlabel to display number of selected projects 
   					list2.updateUI();
   					list1.updateUI();
   					list1.clearSelection();
   					updateProjectList();
   					
   					
  					//update the vector, add the project to lsit2
   					
   				//}
   			

        	  
			 		
			}

			else if(source == removeButton && selectedList.contains(selectedProject1) && !selectedProject1.getProjTitle().equals(null))
			{
				
	   				selectedList.remove(selectedProject1);
	   				selectProjs -= 1;
   					label3.setText("The total number of selected projects: " + selectProjs);
	   				list2.updateUI();
	   				list1.updateUI();
	   				list1.clearSelection();
	   	              updateProjectList();
	   	              
	  					//update the vector, remove the project from list2
	   					
	   				
	   			

			}
    	   
    	   //TO BE COMPLETED
        }
  } //end of ButtonListener class
 
} //end of SelectPanel class