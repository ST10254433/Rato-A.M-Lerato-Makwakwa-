/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taskmanagerapp;

import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */

class Task {
    private String description;
    private boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    public void markAsCompleted() {
        isCompleted = true;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }
}

class TaskManager {
    private Task[] tasks;
    private int taskCount;

    public TaskManager(int capacity) {
        tasks = new Task[capacity];
        taskCount = 0;
    }

    public void addTask(String description) {
        if (taskCount < tasks.length) {
            tasks[taskCount] = new Task(description);
            taskCount++;
        } else {
            System.out.println("Task list is full. Cannot add more tasks.");
        }
    }

    public void markTaskAsCompleted(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < taskCount) {
            tasks[taskIndex].markAsCompleted();
        } else {
            System.out.println("Invalid task index. Please try again.");
        }
    }

    public void displayTasks() {
        System.out.println("Task List:");
        for (int i = 0; i < taskCount; i++) {
            Task task = tasks[i];
            System.out.print(i + 1 + ". " + task.getDescription());
            if (task.isCompleted()) {
                System.out.println(" (Completed)");
            } else {
                System.out.println();
            }
        }
    }
}

public class TaskManagerApp {
    
     /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager(10);

        while (true) {
            System.out.println("Task Management System");
            System.out.println("1. Add a task");
            System.out.println("2. Mark a task as completed");
            System.out.println("3. Display tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Task Description: ");
                    String description = scanner.nextLine();
                    taskManager.addTask(description);
                    break;
                case 2:
                    System.out.print("Enter the task index to mark as completed: ");
                    int taskIndex = scanner.nextInt();
                    taskManager.markTaskAsCompleted(taskIndex - 1);
                    break;
                case 3:
                    taskManager.displayTasks();
                    break;
                case 4:
                    System.out.println("Thank You For Using The System Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}



   
    
