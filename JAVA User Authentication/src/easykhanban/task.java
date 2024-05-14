/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package easykhanban;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class task {
    ArrayList<String> developer = new ArrayList<String>();
     ArrayList<String> taskName = new ArrayList<String>();
     ArrayList<String> taskID = new ArrayList<String>();
     ArrayList<String> taskDuration = new ArrayList<String>();
     ArrayList<String> taskStatus = new ArrayList<String>();
     ArrayList<String> statusName = new ArrayList<String>();
     
     public String addTask(){
        int addTask = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Tasks You Wish To Add"));
        for(int i = 0; i < addTask; i++){
            developer();
            taskName();
            taskDuration();
            taskStatus();
            taskID();
            
            
            
        }
         return null;
         
        
    }
    public String developer(){
        String input;
        do{
            input = JOptionPane.showInputDialog(null, "Enter Developer Name");
            developer.add(input);
            if(input == null){
                exit();
            }
           
        }
        while(input == "");
        return null;
        }
       
        private void exit() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
        
    public String taskName(){
        String input;
        do{
            input = JOptionPane.showInputDialog(null, "Enter taskName Name");
            taskName.add(input);
            if(input == null){
                exit();
            }
           
        }
        while(input == "");
        return null;
        } 
    public String taskID(){
        String input;
        do{
            input = JOptionPane.showInputDialog(null, "Enter taskID Name");
            developer.add(input);
            if(input == null){
                exit();
            }
           
        }
        while(input == "");
        return null;
        }
    public String taskDuration(){
        String input;
        do{
            input = JOptionPane.showInputDialog(null, "Enter taskDuration Name");
            taskName.add(input);
            if(input == null){
                exit();
            }
           
        }
        while(input == "");
        return null;
        } 
    public String taskStatus(){
        int input;
        do{
            input = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter taskStatus Name"));
                switch(input){
                    case 1:
                         statusName.add("To Do");
                         break;
                    case 2:
                        statusName.add("Done");
                        break;
                    case 3:
                        statusName.add("Doing");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "That Is Not A Task");
                    

                        
                }
            
           
        }
        while(input == 0 || input <= 4);
        return null;
        } 
    
   
    }

