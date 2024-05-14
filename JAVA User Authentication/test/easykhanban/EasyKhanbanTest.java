/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package easykhanban;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lab_services_student
 */
public class EasyKhanbanTest {
    
    public EasyKhanbanTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of main method, of class EasyKhanban.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        EasyKhanban.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of optionMenu method, of class EasyKhanban.
     */
    @Test
    public void testOptionMenu() {
        System.out.println("optionMenu");
        EasyKhanban instance = new EasyKhanban();
        instance.optionMenu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayTasksWithStatus method, of class EasyKhanban.
     */
    @Test
    public void testDisplayTasksWithStatus() {
        System.out.println("displayTasksWithStatus");
        String status = "";
        EasyKhanban instance = new EasyKhanban();
        instance.displayTasksWithStatus(status);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayTaskWithLongestDuration method, of class EasyKhanban.
     */
    @Test
    public void testDisplayTaskWithLongestDuration() {
        System.out.println("displayTaskWithLongestDuration");
        EasyKhanban instance = new EasyKhanban();
        instance.displayTaskWithLongestDuration();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchTaskByName method, of class EasyKhanban.
     */
    @Test
    public void testSearchTaskByName() {
        System.out.println("searchTaskByName");
        EasyKhanban instance = new EasyKhanban();
        instance.searchTaskByName();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchTasksByDeveloper method, of class EasyKhanban.
     */
    @Test
    public void testSearchTasksByDeveloper() {
        System.out.println("searchTasksByDeveloper");
        EasyKhanban instance = new EasyKhanban();
        instance.searchTasksByDeveloper();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteTask method, of class EasyKhanban.
     */
    @Test
    public void testDeleteTask() {
        System.out.println("deleteTask");
        EasyKhanban instance = new EasyKhanban();
        instance.deleteTask();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayAllTasks method, of class EasyKhanban.
     */
    @Test
    public void testDisplayAllTasks() {
        System.out.println("displayAllTasks");
        EasyKhanban instance = new EasyKhanban();
        instance.displayAllTasks();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTask method, of class EasyKhanban.
     */
    @Test
    public void testAddTask() {
        System.out.println("addTask");
        String developerName = "";
        String taskName = "";
        int taskDuration = 0;
        String taskStatus = "";
        EasyKhanban instance = new EasyKhanban();
        instance.addTask(developerName, taskName, taskDuration, taskStatus);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of populateArrays method, of class EasyKhanban.
     */
    @Test
    public void testPopulateArrays() {
        System.out.println("populateArrays");
        EasyKhanban instance = new EasyKhanban();
        instance.populateArrays();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
