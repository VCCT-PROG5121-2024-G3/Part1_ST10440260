/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package prog5121project1;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joel
 */
public class KanbanTest
{
    
    public KanbanTest()
    {
        
    }
    
    @Test
    public void testMain()
    {
        
    
        
    }
    
    @Test
    public void testExecution1()
    {
        System.out.println("Test case 1");
        String name = "Login Feature";
        int number = 0;
        String description = "Create login to authenticate users";
        String devDetails = "Robyn Harrison";
        int duration = 8;
        String status = "To DO";
        ObjKan[] kanban = new ObjKan[2];
        String expResult = "Task sucessfully captured";
        String result = Kanban.execution(name, number, description, 
                                         devDetails, duration, status, kanban);
        assertEquals(expResult, result);
    
        if (result.equals("Please enter a task description of 50 "
                + "characters or less")) {
        fail("failure test 1");
        }
    }
    @Test
    public void testCreateTaskID1() { 
        System.out.println("Test ID 1");
        String name = "Login Feature";
        int number = 0;
        String devDetails = "Robyn Harrison"; 
        String expResult = "LO:0:BYN";
        String result = Kanban.createTaskID(name, number, devDetails);
        assertEquals(expResult,result);
    }
    
    @Test
    public void testCreateTaskID2() { 
        System.out.println("Test ID 2");
        String name = "Add Task Feature";
        int number = 1;
        String devDetails = "Mike Smith"; 
        String expResult = "AD:1:IKE";
        String result = Kanban.createTaskID(name, number, devDetails);
        assertEquals(expResult,result);
    }
    
    @Test
    public void testExecution2()
    {
        System.out.println("test case 2");
        String name = "Add Task Feature";
        int number = 1;
        String description = "Create Add Task feature to add task users";
        String devDetails = "Mike Smith";
        int duration = 10;
        String status = "Doing";
        ObjKan[] kanban = new ObjKan[2];
        String expResult = "Task sucessfully captured";
        String result = Kanban.execution(name, number, description, devDetails,
                                        duration, status, kanban);
        assertEquals(expResult, result);
              
         if (result.equals("Please enter a task description of 50 characters "
                 + "or less")) {
        fail("failure test 2");
        }
    
    }

    
    
}
