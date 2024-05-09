/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog5121project1;

import java.util.Scanner;
/**
 *
 * @author Joel
 */
public class Kanban
{
   
   
    public static void Main(User user) {
    //Array that will hold all instances of the objKan object. this allows up to 50 tasks to be created
    Scanner input = new Scanner(System.in);
    
    //ask user for the amount of tasks they want.
    System.out.println("How many tasks would you like to create?\n" + 
                       "Please input an integer value.");
    //recieves the amount of tasks the user wants then makes the array that size.
    int Size = input.nextInt();
    ObjKan[] kanban = new ObjKan[Size];
    
    //When the option menu is shown for add tasks etc this variable tracks which code to execute
    int choice = 0;
    
    //When the option menu is shown for defining the status this variable tracks what the status must become.
    int statusChoice;
    
    //These variables will be used for object construction.
    String name;
    int number = 0;
    String description;
    String devDetails;
    int duration;
    String ID;
    String status;
    
    String output;
    
    //Terminates the loop if they choose option 3 or the amount of tasks defined by the size they chose is reached.
    while ((choice != 3) && (number < Size)) { 
        System.out.println("Option 1) Add tasks.\n" + 
                           "Option 2) Show Report.\n" + 
                           "Option 3) Quit.\n" + 
                           "Please input a number from 1-3 to select the appropriate option.");
        choice = input.nextInt();
        
        //activates if the user chose option 1
        if (choice == 1) {
            //Recieve user inputs to create the objKan object
            System.out.println("Input task name");
            name = input.nextLine();
            name = input.nextLine();
            
            System.out.println("Input task description of less than 50 characters");
            description = input.nextLine();
            
            System.out.println("Input the first and last name of the developer\n" + 
                               "assigned to this task");
            devDetails = input.nextLine();
            
            System.out.println("Input the length of the task in hours");
            duration = input.nextInt();
            
            System.out.println("1) To do\n" +
                               "2) Doing\n" + 
                               "3) Done\n" + 
                               "Select an option by choosing a number between 1-3");
            statusChoice = input.nextInt();
           
            status = assignStatus(statusChoice) ;
            
                       
            ID = createTaskID(name, number, devDetails);
            
            output = execution(name, number, description, devDetails, duration, 
                               ID, status, kanban);
            System.out.println(output + "\n");
            
            //if the object was sucessfully made then the output will become task sucessfully captured. This is used to 
            //know when the program should increment the counter. if no object was created then the counter
            //should not increment.
            if (output.equals("Task sucessfully captured")) {
               number = number + 1; 
            }    
                
          
        }
        //option 2 is under devleopment so this message is issued.
        if (choice == 2) { 
        
            System.out.println("Coming Soon!");
            
        }
    
    }
    
    System.out.println(printTaskDetails(kanban, number));
    
    
    System.out.println("Total duration of tasks: " + String.valueOf(returnTotalHours(kanban, number)));
    
        
    
     
    
    }
    
    //This method creates the object if the criteria of choosing an integer between 1-3 for the status was done
    //and the description is less than 50 characters. Putting it into its own method like this
    //simplifies unit testing later.
    public static String execution(String name, int number, String description,  String devDetails, 
                                 int duration, String ID, String status, ObjKan[] kanban) {
        String error = "";
        boolean check = true; 
        String result;
        
         if (!checkTaskDescription(description)) {
                check = false;
                //This constructs a custom error message so that the user knows why their object wasn't constructed.
                error = "Please enter a task description of 50 characters or less" + "\n";
            }
            
            if (status.equals("error")) {
               check = false; 
               //This constructs a custom error message so that the user knows why their object wasn't constructed.
               error = error + "Task status choice must be an integer between 1 and 3" + "\n";
            }
                
            if (check) {
            
                kanban[number] = new ObjKan(name, number, description, devDetails, duration, ID, status);
                result = "Task sucessfully captured";
                
                System.out.println(kanban[number].toString());
                
            }
            else {
                result = error;
            }
            return result;
        
    }
    //Takes statusChoice and returns the appropriate string that corrolates to that choice. if "error" is returned 
    //an error message will be issued to the user and the object will not be created.
    public static String assignStatus(int statusChoice) {
     
        return switch (statusChoice){
            case 1 -> "To do";
            case 2 -> "Doing";
            case 3 -> "Done";
            default -> "error";
        };
        
    }
    //returns whether or not the description is less than 50 characters.
    public static Boolean checkTaskDescription(String description) {
    
        return description.length() <= 50;
    }
    
    //Creates the taskID based on the criteria of the project. first to characters of the task name
    //, a colon, the task number, a colon then the last 3 leters of the developers first and last name.
    public static String createTaskID(String name, int number, String devDetails) {
    String ID;
    
    ID = name.substring(0,2) + ":";
    ID = ID + String.valueOf(number) + ":";
    ID = ID + devDetails.substring(devDetails.length() - 3, devDetails.length());
    return ID.toUpperCase();
    }
    
    //A loop that executes the toString function of objKan for every object in the array and collects it
    //into a single string to be displayed.
    public static String printTaskDetails(ObjKan[] kanban, int size) {
        
    String Result = "";
    for (int i = 0; i < size; i++) {
        
        Result = Result + kanban[i].toString() + "\n";
    }
    
    return Result;
        
    }
    
    //Extracts the duration attribute of every objKan object in the array and adds them together
    public static int returnTotalHours(ObjKan[] kanban, int size) {
    int totDuration = 0;
    for (int i = 0; i < size; i++) {
        
        totDuration = totDuration + kanban[i].returnDuration();
    }
    return totDuration;    
    }
}
