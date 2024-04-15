package prog5121project1;

 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 
/**
 *
 * @author Joel
 */
public class User
{
    
    
    private String Username;
    private String Password;
    private String firstName;
    private String lastName;
    //default constructor
    public User(){
        
    }
    //constructor
    public User (String pUsername, String pPassword, String pFirstName, String pLastName){
        
        Username = pUsername;
        Password = pPassword;
        firstName = pFirstName;
        lastName = pLastName;
        
    }
    
    public void setUser(String pUsername, String pPassword){
     
        Username = pUsername;
        Password = pPassword;
    }
    
    public String getUser(){
        return Username;
    }
    
    public String getPass(){
        return Password;
    }
    
    
}
