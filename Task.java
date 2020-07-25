/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaskOrganization;

import java.util.ArrayList;

/**
 *
 * @author melissacmitchell
 */
public class Task implements java.io.Serializable {
    
    //declare variables
    Category category;                                  
    int month;
    int year;
    int day;
    String instructions;
    boolean repeating;
    boolean authentication;
    int everyMonth;
    
    
    //copy constructor
    Task(Task taskToCopy) {
        category = taskToCopy.category;
        month = taskToCopy.month;
        year = taskToCopy.year;
        day = taskToCopy.day;
        instructions = taskToCopy.instructions;
        repeating = taskToCopy.repeating;
        authentication = taskToCopy.authentication;
        everyMonth = taskToCopy.everyMonth;
    }
    
    //value constructor
    Task(int month, int day, int year, Category category, String instructions, boolean repeating, boolean authentication) {
        this.category = category;
        this.month = month;
        this.year = year;
        this.day = day;
        this.instructions = instructions;
        this.repeating = repeating;
        this.authentication = authentication;
        this.everyMonth = everyMonth;
    }
    
    private void incrementMonth() {
        //increments the month
        month += 1;
        //if the month goes past December, reset to January and increment year
        if (month == 13) {
            month = 1;
            year += 1;
        }
    }
    
    private Task next() {
        if (month == 1 && year == 2021) {
            return null;
        }
        
        Task taskToReturn = new Task(this);
        
        //if this task isn't repeating, set the next one to be null
        if (!repeating) {
            month = 1;
            year = 2021;
        //otherwise, set month to next calendar month
        } else {
            incrementMonth();
        }        
        
        return taskToReturn;
    }
    
    //creates future tasks for the current task
    public void createFuture(ArrayList<Task> tasks) {
        Task tasksToAdd = next();
        while (tasksToAdd != null) {
            tasks.add(tasksToAdd);
            tasksToAdd = next();
        }
    }
    
    //updates the future tasks for the current task
    public void updateFuture(ArrayList<Task> tasks, Task original) {
        
        int searchMonth = month;
        int searchYear = year;
        int searchDay = day;

        // The first increment needs to be outside the while loop
        incrementMonth();
        
        //nested loops to update future task
        //while the search year is still in range
        while (searchYear < 2021) {
        
            //for every task
            for(Task task : tasks){
                
                //if the task is a future task of the original, update it
                if (((task.month > original.month && task.year == original.year && task.day == original.day) 
                            || task.year > original.year) &&
                        task.month == original.month &&
                        task.day == original.day &&
                        task.year == original.year &&
                        task.instructions.equals(original.instructions) &&
                        task.category == original.category &&
                        task.repeating == original.repeating &&
                        task.everyMonth == original.everyMonth) {

                    task.year = searchYear;
                    task.month = searchMonth;
                    task.day = day;
                    task.instructions = instructions;
                    task.category = category;
                    task.repeating = repeating;
                    task.everyMonth = everyMonth;
                    
                    
                    original.month = searchMonth;
                    original.year = searchYear;
                    original.day = searchDay;
                    break;
                }
            }
            
            //the second increment needs to be after a match is found
            incrementMonth();
            
        }

    }
    
    //deletes future tasks
    public void deleteFuture(ArrayList<Task> tasks) {
        
        //while year in range
        while (year < 2021) {
            
            //for every task, if it matches the original task, delete it
            for(Task task : tasks){
                
                if (((task.month > month && task.year == year) 
                            || task.year > year) &&
                        task.day == day &&
                        task.category == category &&
                        task.repeating == repeating &&
                        task.everyMonth == everyMonth)  {

                    tasks.remove(task);
                    
                    break;

                }
            }
            
            incrementMonth();
        }

    }
    
    //getters and setters
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
    
    public boolean getAuthentication() {
        return authentication;
    }

    public void setAuthentication(boolean no) {
        this.authentication = no;
    }
    
    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
    
    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }
    
    public void setYear(int year) {
        this.year = year;
    }

    public boolean getRepeating() {
        return repeating;
    }

    public void setRecurring(boolean fixed) {
        this.repeating = fixed;
    }
    

}
