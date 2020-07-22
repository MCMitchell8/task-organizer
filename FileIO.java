/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaskOrganization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author melissacmitchell
 */
//reads and writes the password and tasks
public class FileIO {
    
    //reads the current password
    public static String readCurrentPassword() {
        String currentPassword = "";
        
        try {
            FileInputStream fileInput;
            ObjectInputStream objectInput;
            
            fileInput = new FileInputStream("/tmp/currentPassword");
            objectInput = new ObjectInputStream(fileInput);

            
            currentPassword = (String)objectInput.readObject();
            
            objectInput.close();
            fileInput.close();

        } catch (IOException error) {
            error.printStackTrace();
            return currentPassword;
        } catch (ClassNotFoundException error) {
            error.printStackTrace();
            return currentPassword;
        }
            
        return currentPassword;
    }
    
    //writes the current password
    public static void writeCurrentPassword(String password) {
        try {
            FileOutputStream fileOutput;
            ObjectOutputStream objectOutput;
            
            fileOutput = new FileOutputStream("/tmp/currentPassword");
            objectOutput = new ObjectOutputStream(fileOutput);
            
            objectOutput.writeObject(password);
            
            objectOutput.close();
            fileOutput.close();
            
            //.println("Saved password to disk.");
            
        } catch (IOException error) {
            error.printStackTrace();
        }
 
    }      
      
    //reads the current tasks the parent has added
    public static ArrayList<Task> readTasks() {
        ArrayList<Task> tasksToReturn = null;
        //creates file
        tasksToReturn = readTasksFromFile("/tmp/tasks");
        
        return tasksToReturn;
    }
    
    //reads the tasks the child has marked complete
    public static ArrayList<Task> readCompletedTasks() {
        ArrayList<Task> tasksToReturn = null;
        //reads completed tasks file
        tasksToReturn = readTasksFromFile("/tmp/completedTasks");
        
        return tasksToReturn;
    }
    
    //reads the current task based on file name
    public static ArrayList<Task> readTasksFromFile(String fileName) {
        ArrayList<Task> tasksToReturn = null;

        //try-catch
        try {
            FileInputStream fileInput;
            ObjectInputStream objectInput;
            
            fileInput = new FileInputStream(fileName);
            objectInput = new ObjectInputStream(fileInput);
            
            tasksToReturn = (ArrayList<Task>) objectInput.readObject();
            
            objectInput.close();
            fileInput.close();


        } catch (IOException error) {
            error.printStackTrace();
        } catch (ClassNotFoundException error) {
            error.printStackTrace();
       }
        
        return tasksToReturn;
    }
    
    //writes the current tasks
    public static void writeTasks(ArrayList<Task> tasks) {
        //adds task to the tasks file
        writeTasksToFile(tasks, "/tmp/tasks");
    } 
    
    public static void writeCompletedTasks(ArrayList<Task> tasks) {
        //adds task to the completed tasks file
        writeTasksToFile(tasks, "/tmp/completedTasks");
    }
    
    //writes to file based on tasks and file name
    public static void writeTasksToFile(ArrayList<Task> tasks, String fileName) {
        //try-catch
        try {

            FileOutputStream fileOutput;
            ObjectOutputStream objectOutput;

            fileOutput = new FileOutputStream(fileName);
            objectOutput = new ObjectOutputStream(fileOutput);

            objectOutput.writeObject(tasks);

            objectOutput.close();
            fileOutput.close();

        } catch (IOException error) {
            error.printStackTrace();
        }
 
    }
    
}



