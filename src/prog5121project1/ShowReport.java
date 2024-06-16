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
public class ShowReport
{
    
    /**
     *
     * @param aDeveloper
     * @param aTaskNames
     * @param aTaskID
     * @param aDuration
     * @param aTaskStatus
     * @param size
     * @param kanban
     */
    public static Integer Main(String[] aDeveloper, String[] aTaskNames,
            String[] aTaskID, Integer[] aDuration, String[] aTaskStatus, 
            Integer size, ObjKan[] kanban ) {
        
        Integer TasksDeleted = 0;
        Integer choice = 0;
        Scanner input = new Scanner(System.in);
        while (choice != 7) {
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
            switch(choice) {
                
                case 1:
                    System.out.println(ShowDone(aDeveloper,aTaskNames,aDuration,
                            aTaskStatus,size));
                break;
                
                case 2:
                    System.out.println(LongestDuration(aDeveloper,aDuration,
                            size));
                break;
                
                case 3:
                    System.out.println(SearchbyName(aTaskNames,aDeveloper,
                            aTaskStatus,size));
                break;
                
                case 4:
                     System.out.println(SearchbyDev(aTaskNames,aDeveloper,
                            aTaskStatus,size));
                break;
                
                case 5:
                     if (DeleteTask(aDeveloper,aTaskNames,aTaskID,aDuration,aTaskStatus,
                            size,kanban)) {
                     TasksDeleted = TasksDeleted + 1;
                     size = size - 1;
                     }
                break;
                
                case 6:
                    System.out.println(Kanban.printTaskDetails(kanban, size));      
                break;
                
                case 7:
                    System.out.println("Thank you for using the show report "
                        + "feature");
                break;
                
                default:
                    System.out.println("Please select a valid integer");
                break;
            }
        }
    return TasksDeleted;
    }
    
    public static String ShowDone(String[] aDeveloper,String[] aTaskNames,
                        Integer[] aDuration,String[] aTaskStatus, Integer size){
        String result = "";
        
        for (int i = 0; i < size; i++) {
            if (aTaskStatus[i].equals("Done")){
            result = result + "Task Name: " + aTaskNames[i] + "\n" +
                     "Developer: " + aDeveloper[i] + "\n" +
                     "Duration: " + Integer.toString(aDuration[i]) + "\n" +"\n";
            }
        }
        return result;
    }
    
    public static String LongestDuration(String[] aDeveloper, 
            Integer[] aDuration, Integer size ) {
        Integer largestInt = 0;
        String result = "";
        for (int i = 0; i < size; i++) {
            if (aDuration[i] > largestInt) {
                largestInt = aDuration[i];
                
                result = "Developer " + aDeveloper[i] + 
                "Is working on the task " + "with the greatest duration of " + 
                aDuration[i] + " Hours";
                
            }
          }
          return result;
    }
    
    public static String SearchbyName(String[] aTaskNames,String[] aDeveloper,
                  String[] aTaskStatus,Integer size) {
    
        String result = "Please enter an actual task name";
        String search;
        search = JOptionPane.showInputDialog(null, "Please input a task name");
        
        for (int i = 0; i < size; i++) {
            if (aTaskNames[i].equals(search)) {
                result = "Task Name: " + aTaskNames[i] + "\n" +
                     "Developer: " + aDeveloper[i] + "\n" +
                     "Status: " + aTaskStatus[i];
            }
        }
        return result;
    }
    
    public static String SearchbyDev(String[] aTaskNames,String[] aDeveloper,
                                    String[] aTaskStatus, Integer size) {
    
        String result = "";
        String search;
        boolean found = false;
        search = JOptionPane.showInputDialog(null, "Please input a Developer "
                                              + "name");
        for (int i = 0; i < size; i++) {
            if (aDeveloper[i].equals(search)) {
                found = true;
                result = result + "Task Name: " + aTaskNames[i] + "\n" + 
                         "Status: " + aTaskStatus[i] + "\n";
            }
        }
        if (!found) {
           result = "Please input an actual developer name";
        }
        return result;
    }
    
    public static boolean DeleteTask(String[] aDeveloper, String[] aTaskNames,
            String[] aTaskID, Integer[] aDuration, String[] aTaskStatus, 
            Integer size, ObjKan[] kanban) { 
  
        String search;
        boolean found = false;
        search = JOptionPane.showInputDialog(null, "Please input a Task name "+
                                            "to delete");
            for (int i = 0; i < size; i++) {
                if (aTaskNames[i].equals(search)) {
                    found = true;
                    if (i != size) { 
                        for (int j = i; j < size - 1; j++) {
                            aDeveloper[j] = aDeveloper[j+1];
                            aTaskNames[j] = aTaskNames[j+1];
                            aDuration[j] = aDuration[j+1];
                            aTaskStatus[j] = aTaskStatus[j+1];
                            aTaskID[j] = aTaskID[j+1];
                            kanban[j] = kanban[j+1];
                        }
                    }
                    aDeveloper[i] = "";
                    aTaskNames[i] = "";
                    aTaskID[i] = "";
                    aDuration[i] = 0;
                    aTaskStatus[i] = "";
                    kanban[i] = new ObjKan("",0,"","",0,"","");
                   
                } 
            }
        return found;
    }
}
