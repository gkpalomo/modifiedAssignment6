// Assignment #: 6
//         Name: Giovanni Palomo
//    StudentID: 1210682158
//      Lecture: MWF 8:35am
//  Description: The class Project represents a project to be used
//               in assignment 6 for creating objects of type project

public class Project
 {
   private String projTitle;
   private int projNumber;
   private String projLocation;

   //Constructor to initialize all member variables
   public Project()
    {
      projTitle = "?";
      projNumber = 0;
      projLocation = "?";
    }

   //Accessor methods
   public String getProjTitle()
    {
      return projTitle;
    }

   public int getProjNumber()
    {
      return projNumber;
    }

   public String getProjLocation()
    {
	   return projLocation;
	}

   //Mutator methods
   public void setProjTitle(String aTitle)
    {
     projTitle = aTitle;
    }

   public void setProjNumber(int aNumber)
    {
     projNumber = aNumber;
    }

   public void setProjLocation(String aLocation)
    {
      projLocation = aLocation;
    }


   //toString() method returns a string containing its title, number, and location
   public String toString()
    {
      String result = "\nProject Title:\t\t" + projTitle
                    + ",\nProject Number:\t" + projNumber
                    + ",\nProject Location:\t" + projLocation + "\n\n";
      return result;
     }
  }