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
public class ShowReportTest
{

    /**
     * Test of ShowDone method, of class ShowReport.
     */
    @Test
    public void testShowDone()
    {
        System.out.println("ShowDone");
        ObjKan[] kanban = {new ObjKan("Create Login",0,null,"Mike Smith",
                           5,null,"To Do"), new ObjKan("Create Add Features",
                           1,null,"Edward Harrison",8,null,"Doing"),
                           new ObjKan("Create Reports",2,null,"Samantha Paulson",
                           2,null,"Done"),new ObjKan("Add Arrays",3,null,
                           "Glenda Oberholzer",11,null,"To Do")};
        Integer count = 3;
        String[] names = {"Create Login","Create Add Features","Create Reports",
                          "Add Arrays"};
        String[] status = {"To Do","Doing","Done","To Do"};
        String[] developer = {"Mike Smith","Edward Harrison","Samantha Paulson",
                              "Glenda Oberholzer"};
        Integer[] duration = {5,8,2,11};
        String expResult = "Task Name: Create Reports" + "\n" +
                           "Developer: Samantha Paulson" + "\n" + 
                           "Duration: 2" + "\n";
        String result = ShowReport.ShowDone(kanban, count, names, status, developer, duration);
        assertEquals(expResult, result);
    }

    /**
     * Test of LongestDuration method, of class ShowReport.
     */
    @Test
    public void testLongestDuration()
    {
        System.out.println("LongestDuration");
        ObjKan[] kanban = {new ObjKan("Create Login",0,null,"Mike Smith",
                           5,null,"To Do"), new ObjKan("Create Add Features",
                           1,null,"Edward Harrison",8,null,"Doing"),
                           new ObjKan("Create Reports",2,null,"Samantha Paulson",
                           2,null,"Done"),new ObjKan("Add Arrays",3,null,
                           "Glenda Oberholzer",11,null,"To Do")};
        Integer count = 3;
        String[] names = {"Create Login","Create Add Features","Create Reports",
                          "Add Arrays"};
        String[] status = {"To Do","Doing","Done","To Do"};
        String[] developer = {"Mike Smith","Edward Harrison","Samantha Paulson",
                              "Glenda Oberholzer"};
        Integer[] duration = {5,8,2,11};
        String expResult = "Developer Glenda Oberholzer is working on the " + 
                           "task with the greatest duration of 11 Hours" + "\n";
        String result = ShowReport.LongestDuration(kanban, count, duration, developer);
        assertEquals(expResult, result);
    }

    /**
     * Test of SearchbyName method, of class ShowReport.
     */
    @Test
    public void testSearchbyName()
    {
        System.out.println("SearchbyName");
        ObjKan[] kanban = {new ObjKan("Create Login",0,null,"Mike Smith",
                           5,null,"To Do"), new ObjKan("Create Add Features",
                           1,null,"Edward Harrison",8,null,"Doing"),
                           new ObjKan("Create Reports",2,null,"Samantha Paulson",
                           2,null,"Done"),new ObjKan("Add Arrays",3,null,
                           "Glenda Oberholzer",11,null,"To Do")};
        Integer count = 3;
        String[] names = {"Create Login","Create Add Features","Create Reports",
                          "Add Arrays"};
        String[] status = {"To Do","Doing","Done","To Do"};
        String[] developer = {"Mike Smith","Edward Harrison","Samantha Paulson",
                              "Glenda Oberholzer"};
        Integer[] duration = {5,8,2,11};
        String expResult = "Task Name: Create Login" + "\n" + 
                           "Developer: Mike Smith" + "\n" + 
                           "Status: To Do" + "\n";
        String result = ShowReport.SearchbyName(kanban, count, names, developer, status);
        assertEquals(expResult, result);
    }

    /**
     * Test of SearchbyDev method, of class ShowReport.
     */
    @Test
    public void testSearchbyDev()
    {
        System.out.println("SearchbyDev");
        ObjKan[] kanban = {new ObjKan("Create Login",0,null,"Mike Smith",
                           5,null,"To Do"), new ObjKan("Create Add Features",
                           1,null,"Edward Harrison",8,null,"Doing"),
                           new ObjKan("Create Reports",2,null,"Samantha Paulson",
                           2,null,"Done"),new ObjKan("Add Arrays",3,null,
                           "Glenda Oberholzer",11,null,"To Do")};
        Integer count = 3;
        String[] names = {"Create Login","Create Add Features","Create Reports",
                          "Add Arrays"};
        String[] status = {"To Do","Doing","Done","To Do"};
        String[] developer = {"Mike Smith","Edward Harrison","Samantha Paulson",
                              "Glenda Oberholzer"};
        Integer[] duration = {5,8,2,11};
        String expResult = "Task Name: Create Reports\nStatus: Done\n";
        String result = ShowReport.SearchbyDev(kanban, count, names, developer, status);
        assertEquals(expResult, result);
    }

    /**
     * Test of DeleteTask method, of class ShowReport.
     */
    @Test
    public void testDeleteTask()
    {
        System.out.println("DeleteTask");
        ObjKan[] kanban = {new ObjKan("Create Login",0,"","Mike Smith",
                           5,"","To Do"), new ObjKan("Create Add Features",
                           1,"","Edward Harrison",8,"","Doing"),
                           new ObjKan("Create Reports",2,"","Samantha Paulson",
                           2,"","Done"),new ObjKan("Add Arrays",3,"",
                           "Glenda Oberholzer",11,"","To Do")};
        Integer count = 3;
        String[] names = {"Create Login","Create Add Features","Create Reports",
                          "Add Arrays"};
        String[] status = {"To Do","Doing","Done","To Do"};
        String[] developer = {"Mike Smith","Edward Harrison","Samantha Paulson",
                              "Glenda Oberholzer"};
        Integer[] duration = {5,8,2,11};
        String[] ID = new String[4];
        boolean expResult = true;
        boolean result = ShowReport.DeleteTask(kanban, count, developer, names, ID, duration, status);
        assertEquals(expResult, result);
    }
 
    
}
