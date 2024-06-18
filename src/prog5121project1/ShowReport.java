/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog5121project1;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Joel Fredrick May ST10440260@vcconnect.edu.za
 */
public class ShowReport
{
    
    /**
     * @param count
     * @param kanban
     * @return 
     */
//============================Class Start=======================================
    public static Integer Main(Integer count, ObjKan[] kanban) {
        
        Integer TasksDeleted = 0;
        Integer choice = 0;
        Scanner input = new Scanner(System.in);
        
        //Parralel arrays required by the memo
        String[] developer = new String[count + 1];
        String[] names = new String[count + 1];
        String[] ID = new String[count + 1];
        Integer[] duration = new Integer[count + 1];
        String[] status = new String[count + 1];
        
        //Arrays are populated
        for (int i = 0; i <= count; i++)
        {
            developer[i] = kanban[i].returnDevDetails();
            names[i] = kanban[i].returnName();
            ID[i] = kanban[i].returnID();
            duration[i] = kanban[i].returnDuration();
            status[i] = kanban[i].returnStatus();
        }
        
        while (choice != 7) {
              for (int i = 0; i < count; i++)
           
            System.out.println("Input an integer between 1-7 to select a\n" +
                               "  report to see");
            
            System.out.println("(1): All Tasks that are complete\n" + 
            "(2): Developer with the longest task duration\n" +
            "(3): Search for a task by name\n" + 
            "(4): All tasks assigned to a specific developer\n" + 
            "(5): Delete a task by task name\n" + 
            "(6): All details of captured tasks\n" + 
            "(7): Exit");
            choice = input.nextInt();
            //Switch statement parses the user input to activate the appropriate
            //method
            switch(choice) {
                
                case 1:
                    System.out.println(ShowDone(kanban,count,names,status,
                                       developer,duration));
                break;
                
                case 2:
                    System.out.println(LongestDuration(kanban,count,duration
                                                       ,developer));
                break;
                
                case 3:
                    System.out.println(SearchbyName(kanban,count,names,
                                                    developer,status));
                break;
                
                case 4:
                     System.out.println(SearchbyDev(kanban,count,names,
                                                    developer,status));
                break;
                
                case 5:
                     if (DeleteTask(kanban,count,developer,names,ID,duration,
                                    status)) {
                     TasksDeleted = TasksDeleted + 1;
                     count = count - 1;
                     }
                break;
                
                case 6:
                    System.out.println(Kanban.printTaskDetails(kanban, count + 1));      
                break;
                
                case 7:
                    System.out.println("Thank you for using the show report "
                        + "feature");
                break;
                
                default:
                    System.out.println("Please select an integer between 1-7");
                break;
            }
        }
    //This tells the kanban class how to adjust the "count" variable
    return TasksDeleted;
    }
//=================================Methods======================================
    //Searches for all tasks with the "Done" status then adds it to the result
    //variable to be returned.
    public static String ShowDone(ObjKan[] kanban, Integer count,
    String[] names, String[] status,String[] developer,Integer[] duration){
        String result = "";
        
        for (int i = 0; i <= count; i++) {
            if (status[i].equals("Done")){
            result = result + "Task Name: " + names[i] + "\n" +
            "Developer: " + developer[i] + "\n" +
            "Duration: " + Integer.toString(duration[i])
            + "\n";
            }
        }
        return result;
    }
    //searches the array for the largest duration variable then returns it.
    public static String LongestDuration(ObjKan[] kanban, Integer count,
    Integer[] duration, String[] developer) {
        Integer largestInt = 0;
        String result = "";
        for (int i = 0; i <= count; i++) {
            if (duration[i] > largestInt) {
                largestInt = duration[i];
                
                result = "Developer " +  developer[i] + 
                " is working on the task with the greatest duration of " + 
                duration[i] + " Hours" + "\n";
                
            }
          }
          return result;
    }
    //User will input a task name then the array is searched. whenever there is
    //a hit the details will be added to the result variable to be returned.
    public static String SearchbyName(ObjKan[] kanban,Integer count,
    String[] names,String[] developer,String[] status) {
    
        String result = "Please enter an actual task name" + "\n";
        String search;
        search = JOptionPane.showInputDialog(null, "Please input a task name");
        
        for (int i = 0; i <= count; i++) {
            if (names[i].equals(search)) {
                result = "Task Name: " + names[i] + "\n" +
                     "Developer: " + developer[i] + "\n" +
                     "Status: " + status[i] + "\n";
            }
        }
        return result;
    }
    //User will input a dev name then the array is searched. whenever there is
    //a hit the details will be added to the result variable to be returned.
    public static String SearchbyDev(ObjKan[] kanban, Integer count,
    String[] names,String[] developer,String[] status) {
    
        String result = "";
        String search;
        boolean found = false;
        search = JOptionPane.showInputDialog(null, "Please input a Developer "
                                              + "name");
        for (int i = 0; i <= count; i++) {
            if (developer[i].equals(search)) {
                found = true;
                result = result + "Task Name: " + names[i] + "\n" 
                        + "Status: " + status[i] + "\n";
            }
        }
        if (!found) {
           result = "Please input an actual developer name" + "\n";
        }
        return result;
    }
    
    //Deletes a task by shifting every task down one step in the array and
    //overwriting the task that needs to be deleted. 
    public static boolean DeleteTask(ObjKan[] kanban, Integer count,
    String[] developer,String[] names, String[] ID,Integer[] duration,
    String[] status) { 
        
        String search;
        Integer position;
        boolean found = false;
        search = JOptionPane.showInputDialog(null, "Please input a Task name "+
                                            "to delete");
            for (int i = 0; i <= count; i++) {
                if (names[i].equals(search)) {
                    found = true;            
                    if (i < count) { 
                        position = i;
                        for (int j = position; j < count; j++) {
                            kanban[j] = kanban[j+1];
                        }
                    }
             
                    kanban[count] = null;   
              
                    for (int k = 0; k <= count; k++)
                    {
                        developer[i] = kanban[i].returnDevDetails();
                        names[i] = kanban[i].returnName();
                        ID[i] = kanban[i].returnID();
                        duration[i] = kanban[i].returnDuration();
                        status[i] = kanban[i].returnStatus();
                    }    
                } 
            }
        if (found) {
            JOptionPane.showMessageDialog(null, "Task sucessfully deleted");
        }
        else {
            JOptionPane.showMessageDialog(null, "Task not found");
        }
        return found;
    }
}
//==============================End Of File=====================================