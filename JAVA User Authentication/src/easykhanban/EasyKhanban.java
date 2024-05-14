/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package easykhanban;
//import java

import java.awt.Component;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.Icon;
import javax.swing.JOptionPane;

public class EasyKhanban {
    private static int taskCounter = 0;
    private static int totalHours = 0;
    // Declare the Arrays (ArrayList)
    private ArrayList<String> developer = new ArrayList<>();
    private ArrayList<String> taskName = new ArrayList<>();
    private ArrayList<Integer> taskID = new ArrayList<>();
    private ArrayList<Integer> taskDuration = new ArrayList<>();
    private ArrayList<String> taskStatus = new ArrayList<>();

    public static void main(String[] args) {
        EasyKhanban mainObj = new EasyKhanban();
        //We declare our start method inside the main method.
        mainObj.start();
    }

    private void start() {
        //We create an array of 2 elements.
        String[] buttons = { "REGISTER", "LOGIN" };
        //We use JOptionPane To ask the user questions to input or select one of the above options.
        int rc = JOptionPane.showOptionDialog(null, "Hi, How are you? Please select one of the options below.",
                "Confirmation", JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[1]);

        if (rc == 0) {
            //We then use if statement and assigning operators to check if the condition is true with using register or login
            registerUser();
        } else if (rc == 1) {
            loginUser();
        } else if (rc == 2){
        }
        //we end with option menu with every methods we create
        optionMenu();
    }

    private static void registerUser() {
        //The user must first register 
        String username = JOptionPane.showInputDialog(null,
                "Enter username (must contain an underscore and be no more than 5 characters long)");
        while (!isValidUsername(username)) {
            username = JOptionPane.showInputDialog(null,
                    "Invalid username. Please enter a username that contains an underscore and is no more than 5 characters long:");
                   }

        String password = JOptionPane.showInputDialog(null,
                "Enter password (must be at least 8 characters long, contain a capital letter, a number, and a special character):");
        while (!isValidPassword(password)) {
            password = JOptionPane.showInputDialog(null,
                    "Invalid password. Please enter a password at least 8 characters long, containing a capital letter, a number, and a special character:");
             //We check if password matches the requirements by using the while loop
        }

        Component parent = null;
        JOptionPane.showMessageDialog(parent, "REGISTRATION/LOGIN SUCCESSFUL");
    }

    private static void loginUser() {
        String username = JOptionPane.showInputDialog(null, "Enter your username:");
        String password = JOptionPane.showInputDialog(null, "Enter your password:");

        // Perform login validation here
        // ...
    }

    private static boolean isValidUsername(String username) {
        //Boolean
        return username.length() <= 5 && username.contains("_");
    }

    private static boolean isValidPassword(String password) {
        //We use the boolean to check or validate whether the password is true or false.//
        return password.length() >= 8 && Pattern.matches(".*[A-Z].*", password)
                && Pattern.matches(".*\\d.*", password) && Pattern.matches(".*[!@#$%^&()].*", password);
    }

    public void optionMenu() {
        String[] options = {"Display Tasks with Status 'Done'", "Display Task with Longest Duration",
                "Search Task by Name", "Search Tasks by Developer", "Delete Task", "Display All Tasks", "Exit"};

        int opt = JOptionPane.showOptionDialog(null, "Welcome to EasyKhanban!", "EasyKhanban Task Details",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        switch (opt) {
            case 0:
                displayTasksWithStatus("Done");
                break;
            case 1:
                displayTaskWithLongestDuration();
                break;
            case 2:
                searchTaskByName();
                break;
            case 3:
                searchTasksByDeveloper();
                break;
            case 4:
                deleteTask();
                break;
            case 5:
                displayAllTasks();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Goodbye");
        }
    }

    public void displayTasksWithStatus(String status) {
        StringBuilder display = new StringBuilder();
        for (int i = 0; i < taskStatus.size(); i++) {
            if (taskStatus.get(i).equalsIgnoreCase(status)) {
                display.append("Developer: ").append(developer.get(i)).append("\n")
                        .append("Task Name: ").append(taskName.get(i)).append("\n")
                        .append("Task Duration: ").append(taskDuration.get(i)).append("\n")
                        .append("----------------------------\n");
            }
        }
        JOptionPane.showMessageDialog(null, "Tasks with Status \"" + status + "\":\n" + display.toString());
        optionMenu();
    }

    public void displayTaskWithLongestDuration() {
        int maxDurationIndex = 0;
        int maxDuration = taskDuration.get(0);

        for (int i = 1; i < taskDuration.size(); i++) {
            int currentDuration = taskDuration.get(i);
            if (currentDuration > maxDuration) {
                maxDuration = currentDuration;
                maxDurationIndex = i;
            }
        }

        JOptionPane.showMessageDialog(null, "Task with Longest Duration:\n" +
                "Developer: " + developer.get(maxDurationIndex) + "\n" +
                "Task Duration: " + taskDuration.get(maxDurationIndex));
        optionMenu();
    }

    public void searchTaskByName() {
        String taskNameToSearch = JOptionPane.showInputDialog(null, "Enter the Task Name:");
        boolean taskFound = false;
        StringBuilder display = new StringBuilder();

        for (int i = 0; i < taskName.size(); i++) {
            if (taskName.get(i).equalsIgnoreCase(taskNameToSearch)) {
                display.append("Task Name: ").append(taskName.get(i)).append("\n")
                        .append("Developer: ").append(developer.get(i)).append("\n")
                        .append("Task Status: ").append(taskStatus.get(i)).append("\n");
                taskFound = true;
                break;
            }
        }

        if (taskFound) {
            JOptionPane.showMessageDialog(null, "Task Found:\n" + display.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Task Not Found.");
        }
        optionMenu();
    }

    public void searchTasksByDeveloper() {
        String developerNameToSearch = JOptionPane.showInputDialog(null, "Enter the Developer Name:");
        boolean tasksFound = false;
        StringBuilder display = new StringBuilder();

        for (int i = 0; i < developer.size(); i++) {
            if (developer.get(i).equalsIgnoreCase(developerNameToSearch)) {
                display.append("Task Name: ").append(taskName.get(i)).append("\n")
                        .append("Task Status: ").append(taskStatus.get(i)).append("\n")
                        .append("----------------------------\n");
                tasksFound = true;
            }
        }

        if (tasksFound) {
            JOptionPane.showMessageDialog(null, "Tasks Assigned to " + developerNameToSearch + ":\n" + display.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No Tasks Assigned to " + developerNameToSearch);
        }
        optionMenu();
    }

    public void deleteTask() {
        String taskNameToDelete = JOptionPane.showInputDialog(null, "Enter the Task Name to Delete:");
        boolean taskDeleted = false;

        for (int i = 0; i < taskName.size(); i++) {
            if (taskName.get(i).equalsIgnoreCase(taskNameToDelete)) {
                developer.remove(i);
                taskName.remove(i);
                taskID.remove(i);
                taskDuration.remove(i);
                taskStatus.remove(i);
                taskDeleted = true;
                break;
            }
        }

        if (taskDeleted) {
            JOptionPane.showMessageDialog(null, "Task \"" + taskNameToDelete + "\" Deleted Successfully.");
        } else {
            JOptionPane.showMessageDialog(null, "Task Not Found.");
        }
        optionMenu();
    }

    public void displayAllTasks() {
        StringBuilder display = new StringBuilder();

        for (int i = 0; i < taskName.size(); i++) {
            display.append("Task ID: ").append(taskID.get(i)).append("\n")
                    .append("Developer: ").append(developer.get(i)).append("\n")
                    .append("Task Name: ").append(taskName.get(i)).append("\n")
                    .append("Task Duration: ").append(taskDuration.get(i)).append("\n")
                    .append("Task Status: ").append(taskStatus.get(i)).append("\n")
                    .append("----------------------------\n");
        }

        JOptionPane.showMessageDialog(null, "All Tasks:\n" + display.toString());
        optionMenu();
    }

    public void addTask(String developerName, String taskName, int taskDuration, String taskStatus) {
        developer.add(developerName);
        this.taskName.add(taskName);
        taskID.add(taskID.size() + 1);
        this.taskDuration.add(taskDuration);
        this.taskStatus.add(taskStatus);
    }

    public void populateArrays() {
        // Test Data Task 1
        addTask("Mike Smith", "Create Login", 5, "To Do");
        // Test Data Task 2
        addTask("Edward Harrison", "Create Add Features", 8, "Doing");
        // Test Data Task 3
        addTask("Samantha Paulson", "Create Reports", 2, "Done");
        // Test Data Task 4
        addTask("Glenda Oberholzer", "Add Arrays", 11, "To Do");
    }

    public EasyKhanban() {
        populateArrays();
        //Populating the arrays
    }
}


    

