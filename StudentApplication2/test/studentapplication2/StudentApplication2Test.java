package studentapplication2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import studentapplication2.StudentApplication2;

public class StudentApplication2Test {

    @Test
    public void testCaptureStudent() {
        // Create a StudentApplication2 instance
        StudentApplication2 app = new StudentApplication2();
        
        // Create a mock scanner for input
        Scanner scanner = new Scanner("1\n1\nJohn\n18\n");

        // Capture a new student
        app.captureStudent(scanner);
        
        // Check if the student is added to the students list
        assertFalse(app.students.isEmpty());
    }

    @Test
    public void testSearchForStudent_StudentFound() {
        // Create a StudentApplication2 instance
        StudentApplication2 app = new StudentApplication2();

        // Add a student to the list
        Student student = new Student(1, "John", 18);
        app.students.add(student);

        // Create a mock scanner for input
        Scanner scanner = new Scanner("2\n1\n");

        // Search for a student
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        app.searchForStudent(scanner);

        // Check if the student is found
        String expectedOutput = "Student Found:\n1 John 18";
        assertEquals(expectedOutput, outContent.toString().trim());
    }

    @Test
    public void testSearchForStudent_StudentNotFound() {
        // Create a StudentApplication2 instance
        StudentApplication2 app = new StudentApplication2();

        // Create a mock scanner for input
        Scanner scanner = new Scanner("2\n1\n");

        // Search for a student
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        app.searchForStudent(scanner);

        // Check if the student is not found
        String expectedOutput = "Student not found.";
        assertEquals(expectedOutput, outContent.toString().trim());
    }

    @Test
    public void testDeleteStudent_StudentFound() {
        // Create a StudentApplication2 instance
        StudentApplication2 app = new StudentApplication2();

        // Add a student to the list
        Student student = new Student(1, "John", 18);
        app.students.add(student);

        // Create a mock scanner for input
        Scanner scanner = new Scanner("3\n1\ny\n");

        // Delete a student
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        app.deleteStudent(scanner);

        // Check if the student is deleted
        String expectedOutput = "Student Found:\n1 John 18\nConfirm deletion (y/n): Student deleted successfully.";
        assertEquals(expectedOutput, outContent.toString().trim());
        assertTrue(app.students.isEmpty()); // Check if the list is empty
    }

    // You can similarly write test methods for other functionalities (viewStudentReport, loadStudentsFromFile, saveStudentsToFile).
}
