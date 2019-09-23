public class Camper implements Comparable
{
 String Name;
 int Age;
 char Sex;
 
 public Camper (String N, int A, char S) //Constructer with data
 {
  Name = N;
  Age = A;
  Sex = S;
 }
 
 public Camper() //Constructer without data, all values should be changed
 {
  Name = "ERROR";
  Age = -1;
  Sex = 'x';
 }
 
 public int compareTo(Object y) //Compair by ALphabet
 {
  Camper temp = (Camper)y;
  return Name.compareTo(temp.Name);
 }
 
 public String toString() //Print statement
 {
  return ("Name: " + Name + "\nAge: " + Age + "\nSex: " + Sex);
 }
}