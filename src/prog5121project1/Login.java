/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog5121project1;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Joel
 */


      
        
public class Login
{

    
public static void Request(String Username, String Password, String firstName, String lastName)
{
 //Recieve input from user
 
 User newUser = new User(Username, Password, firstName, lastName);
 
 String userInput = JOptionPane.showInputDialog("Input Username") ;
 String passInput = JOptionPane.showInputDialog("Input Password");
 
 boolean loginUser = ((userInput.equals(newUser.getUser()))&&(passInput.equals(newUser.getPass())));
 
 //If Username and Password match allow login
 if ((loginUser) || (userInput.equals("Stop")))
 {
 JOptionPane.showMessageDialog(null, "Login successful");
 }        
 else
 {
 JOptionPane.showMessageDialog(null,"Incorrect Username or Password");
 Request(Username, Password, firstName, lastName);
 }
    
}


       
    
}


