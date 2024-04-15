/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog5121project1;

import javax.swing.JOptionPane;

/**
 *
 * @author Joel
 */
public class Register
{
    

    
 //Asks user for username and password   
public static void Request()
{
    
    String Username = " ";
    String Password = " ";
    
    //Set Username and Password with user input.  
    Username = JOptionPane.showInputDialog("Input Username with no more than 5 characters and an underscore");
    Password = JOptionPane.showInputDialog("""
                                        Input Password with a mix of capital and lowercase,
                                        numbers and special characters,
                                        that is at least 8 characters long""");
    
  
//Checks to see if the password and username match the criteria. if it does a new
//User instance is created.
if (Validate(Username, Password))
{
  
  JOptionPane.showMessageDialog(null, "Username and Password are valid.");  
  
  String firstName = JOptionPane.showInputDialog("Input your First Name");
  String lastName = JOptionPane.showInputDialog("Input your Last Name") ;
  
  JOptionPane.showMessageDialog(null, "Welcome " + firstName + " " + lastName + " \n " + 
                               " it is great to see you again." );
  
  Login.Request(Username, Password, firstName, lastName);
}
else {
    Request();
}
            
}
//Checks to see if username and password match the criteria
public static boolean Validate(String Username, String Password)
{
    String error = "";
    
    boolean valid = false;
    boolean userValid = false;
    boolean checkPasswordComplexity = false;
    
    //Special and num represent all special characters or numbers respectively.
    String special = "~`!@#$%^&*()_-={}[]|:;<>,.?/";
    String Num = "1234567890";
    //This is used later to check if a mixtures of uppercase and lowercase characters were used.
    String lowerCase = Password.toLowerCase();
    String UpperCase = Password.toUpperCase();
    
    //Checks to see if a mixture of upper and lowercase characters were used.
    boolean LowerUpper = ((!Password.equals(lowerCase))) && (!Password.equals(UpperCase));
    
    boolean Complexity = ((Check(Password, Num)) && (Check(Password, special)));
    
    int length = Username.length();
    
    //Check for Username length equal to or less than 5 and if the username contains an underscore 
    
    
    if ((length <= 5) && (Username.contains("_")))
    {
    userValid = true;   
    }
    else{
        error = "Username is not correctly formatted, please ensure\n" +
                "that your username contains an underscore and is no\n" +
                "more than 5 characters in length.\n";
    } 
         
    //Check Password length 8 or more and contains uppercase and lowercase 
    //Check to see if there are numbers and special characters
    if (((Password.length() > 8) && (LowerUpper)) && (Complexity))
    {
      
            checkPasswordComplexity = true;      
     
    }
       else{
            error = error + "Password is not correctly formatted, please ensure\n" +
                                    "that the password contains at least 8 characters, a\n" +
                                    "capital letter, a number and a special character.";
        }
         
    //Returns true if the username and password were validated
    if ((userValid)   &&  (checkPasswordComplexity))
    {
        valid = true;       
    }
    else{
        JOptionPane.showMessageDialog(null,error);
    }
    
    return valid;
}
//Checks every single individual character of a string to see if the Password 
//shares any characters with the search string
public static boolean Check(String Password, String Search)
{
 boolean valid = false;
 //loops for the length of the search string
 for (int i = 0; i < Search.length(); i++)
 {
   //each loop checks a new character. 
   //Loop breaks once a single instance is found. 
   if  ((Password.indexOf(Search.charAt(i)) != -1))
   {
    valid = true;
   }        
 }
 
 return valid;
}   
}
