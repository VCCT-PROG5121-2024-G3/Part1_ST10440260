/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog5121project1;

/**
 *
 * @author Joel Fredrick May ST10440260@vcconnect.edu.za
 */
public class ObjKan
{
//------------------------------Attributes--------------------------------------
    private String name;
    private int number;
    private String description;
    private String devDetails;
    private int duration;
    private String ID;
    private String status;
    
 
//-----------------------------Constructors-------------------------------------
    public ObjKan(String pname, int pnumber, String pdescription, 
                 String pdevDetails, int pduration, String pID, String pstatus){
    
            name = pname;
            number = pnumber;
            description = pdescription;
            devDetails = pdevDetails;
            duration = pduration;
            ID = pID;
            status = pstatus;
    }
    public ObjKan(){}
    
//--------------------------Functions and methods-------------------------------   
    //Returns a variety of attributes of the object
    public String returnName() {
        return name;
    }
    
    public String returnDescription() {
        return description;
    }
    
    public String returnDevDetails() {
        return devDetails;
    }
    
    public int returnDuration() {
        return duration;
    }
    
    public String returnID() {
        return ID;
    }
    
    public String returnStatus() {
        return status;
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
//--------------------------------End of file-----------------------------------
}
