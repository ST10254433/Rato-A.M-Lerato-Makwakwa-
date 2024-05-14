/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentapplication2;

/**
 *
 * @author lab_services_student
 */

import java.util.*;
import java.io.*;
import java.io.FileWriter;

class Student implements Serializable {
    int studentId;
    private String studentName;
    private int age;

    Student(int studentId, String studentName, int age) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
    }

    public String toString() {
        return studentId + " " + studentName + " " + age;
    }
}
    /**
     * @param args the command line arguments
     */

public class StudentApplication2 {
    private static final String FILE_NAME = "students.txt";
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        loadStudentsFromFile();

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("1. Capture a New Student");
            System.out.println("2. Search for a Student");
            System.out.println("3. Delete a Student");
            System.out.println("4. View Student Report");
            System.out.println("5. Exit");
            System.out.println("------------------------------------------------");
            System.out.print("Enter Your Choice: ");
            
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    captureStudent(scanner);
                    break;
                case 2:
                    searchForStudent(scanner);
                    break;
                case 3:
                    deleteStudent(scanner);
                    break;
                case 4:
                    viewStudentReport();
                    break;
                case 5:
                    saveStudentsToFile();
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (true);
    }

    static void captureStudent(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();

        System.out.print("Enter Student Name: ");
        String studentName = scanner.next();
       

        int age;
        do {
            System.out.print("Enter Student Age: ");
            age = scanner.nextInt();
            if (age < 16) {
                System.out.println("Invalid age. Age must be 16 or greater.");
            }
        } while (age < 16);

        Student student = new Student(studentId, studentName, age);
        students.add(student);
        System.out.println("Student details saved successfully.");
        System.out.println("------------------------------------------------");
    }

    private static void searchForStudent(Scanner scanner) {
        System.out.print("Enter Student ID to Search: ");
        int studentIdToSearch = scanner.nextInt();
        System.out.print("Enter Your Choice: ");
        

        for (Student student : students) {
            if (student.studentId == studentIdToSearch) {
                System.out.println("Student Found:");
                System.out.println(student);
                return;
            }
        }

        System.out.println("Student not found.");
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.print("Enter Student ID to Delete: ");
        int studentIdToDelete = scanner.nextInt();

        for (Student student : students) {
            if (student.studentId == studentIdToDelete) {
                System.out.println("Student Found:");
                System.out.println(student);

                System.out.print("Confirm deletion (y/n): ");
                String confirmation = scanner.next().toLowerCase();
                if (confirmation.equals("y")) {
                    students.remove(student);
                    System.out.println("Student deleted successfully.");
                }
                return;
            }
        }

        System.out.println("Student not found.");
    }

    private static void viewStudentReport() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            System.out.println("Student Report:");
            System.out.println("------------------------------------------------");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    private static void loadStudentsFromFile() {
        try {
            FileInputStream fileIn = new FileInputStream("students.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            students = (ArrayList<Student>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            // If the file doesn't exist or there's an error reading, start with an empty list.
            students = new ArrayList<>();
        }
    }

    private static void saveStudentsToFile() {
        try {
            FileOutputStream fileOut = new FileOutputStream("students.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(students);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isStudentAgeValid(String abc) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public boolean isStudentAgeValid(int i) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }


    public boolean deleteStudent(int i) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }


    public Student searchForStudent(int i) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }


 
}

