import java.io.*;
import java.util.*;

class Camp
{
 public static void printHelp() //Multiple print statement to make it pretty
 {
  System.out.println("H Help: print a list of commands");
  System.out.println("E name age sex Enroll a new camper (insert)");
  System.out.println("W name Withdraw a camper (delete)");
  System.out.println("D name Display the age and gender of a camper");
  System.out.println("A Print the average age of the campers");
  System.out.println("L List all campers names in alphabetical order");
  System.out.println("S Print the number of boy and girl campers");
  System.out.println("P List all campers names in preorder");
  System.out.println("Q Quit");
 }
 
 public static void main(String [] args) throws IOException
 {
  char Com = 'z'; //The Command Variable
  Scanner read = new Scanner(new FileReader("Camp.txt"));
  BST camp = new BST(); //The Bianary search tree thatwill store data
  String Name = "Error"; //Initialization for a generic camper this value should never be used
  int Age = -1; //Initialization for a generic camper this value should never be used
  char Sex = 'x'; //Initializationfor a generic camper this value should never be used
  String use = "Error"; //Initialization for a string of many uses this value should never be used
  Camper trans = new Camper(); //Generic camper for many uses
  System.out.println("Welcome to camp");
  while (Com != 'Q') //Not Quit
  {
   System.out.println(" "); //Spacer
   Com = read.next().charAt(0); //Read next command
   if (Com == 'H') //Help command
    printHelp();
   if (Com == 'E') //Enrole a camper
   {
    System.out.println("Command E");
    Name = read.next(); //Find the data values of these cmapers
    Age = read.nextInt();
    Sex = read.next().charAt(0);
    Camper temp = new Camper (Name, Age, Sex); //Make temp this new camper
    camp.insert(temp); //Enter the camper
    System.out.println("Camper Added " + temp.Name + ", " + temp.Age + ", " + temp.Sex); //Print out the camper added
   }
   if (Com == 'W')
   {
    System.out.println("Command W"); //Remove a camper
    use = read.next(); //Search for the camper
    trans.Name = use; 
    trans = (Camper)camp.delete(trans); //Delete the selected camper
    if (trans.Name == null) //If the camper does not exist
     System.out.println("ERROR CAMPER DOES NOT EXIST");
    else //If it does
     System.out.println("Camper Removed " + trans.Name + ", " + trans.Age + ", " + trans.Sex);
   }
   if (Com == 'D') //Lookup the camper
   {
    System.out.println("Command D");
    use = read.next(); //Which camper is it
    trans.Name = use;
    trans = (Camper)camp.lookup(trans); //Find the camper
    if (trans.Name == null) //If the camper does not exist
     System.out.println("ERROR CAMPER DOES NOT EXIST");
    else //If it does
      System.out.println(trans);
   }
   if (Com == 'A') //Average Age
   {
    System.out.println("Command A");
    if (camp.count == 0) //If there are no campers
     System.out.println("There are no campers");
    else
    {
     camp.reset(0); //Make a transversal
     double avecomp = 0; //Used for average computation
     while (camp.hasNext()) //While there are items in the list
     {
      trans = (Camper)camp.getNext();
      avecomp = (avecomp + trans.Age); //The total age
     }
     avecomp = (avecomp / camp.count); //Average age
     System.out.println("Average Age: " + avecomp);
    }
   }
   if (Com == 'L') //List the campers
   {
    System.out.println("Command L");
    if (camp.count == 0) //If there are no campers
     System.out.println("There are no campers");
    else
    {
     System.out.println("The campers that are regesterd:");
     camp.reset(1); 
     while (camp.hasNext()) //List the campers in order
      {
       trans = (Camper)camp.getNext();
       System.out.println(trans.Name);
      }
    }
   }
   if (Com == 'S') //List the amount of each gender
   {
    System.out.println("Command S");
    int countM = 0; //Number of males
    int countF = 0; //Number of females
    if (camp.count == 0) 
     System.out.println("There are no campers");
    else
    {
     camp.reset(0); //Create a tansversal
     while (camp.hasNext())
      {
       trans = (Camper)camp.getNext();
       if (trans.Sex == 'M') //If they are male
        countM++;
       else //If they are female
        countF++;
      }
      System.out.println("Number of Males: " + countM);
      System.out.println("Number of Feales: " + countF);
    }
   }
   if (Com == 'P') //Transversal
   {
    System.out.println("Command P");
    if (camp.count == 0)
     System.out.println("There are no campers");
    else
    { 
     camp.reset(0); //Make the transversal
     while (camp.hasNext())
      {
       trans = (Camper)camp.getNext();
       System.out.println(trans.Name); //Print thetransversal
      }
    }
   }
  }
  System.out.println("Enjoy Camp");
 } 
} 
