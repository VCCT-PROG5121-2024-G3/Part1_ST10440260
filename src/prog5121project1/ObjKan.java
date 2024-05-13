/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog5121project1;

/**
 *
 * @author Joel
 */
public class ObjKan
{
    //attributes
    private String name;
    private int number;
    private String description;
    private String devDetails;
    private int duration;
    private String ID;
    private String status;
    
    public ObjKan(){
        
    }
    //Constructor
    public ObjKan(String pname, int pnumber, String pdescription, String pdevDetails, int pduration, String pID, String pstatus){
    
            name = pname;
            number = pnumber;
            description = pdescription;
            devDetails = pdevDetails;
            duration = pduration;
            ID = pID;
            status = pstatus;
    }
    
    //Returns the duration attribute.
    public int returnDuration() {
    
    return duration;
    }
    
    //Prints all of the information of the object.
    public String toString(){
    
        return "Task Status: " + status + "\n" +
               "Developer details: " + devDetails + "\n" + 
               "Task Number: " + String.valueOf(number) + "\n" + 
               "Task Name: " + name + "\n" +
               "Task Description: " + description + "\n" + 
               "Task ID: " + ID + "\n" +
               "Task Duration: " + String.valueOf(duration) + " Hours\n" 
               
               ;
    }
    
}
