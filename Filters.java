/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaskOrganization;

/**
 *
 * @author melissacmitchell
 */
//filters
public class Filters {
    
    //checks whether task passes task filter
    static public boolean passesTaskFilter(Task task, DisplayFilter displayFilter) {
        boolean boolToReturn = false;
        
        switch (displayFilter) {
            case Both:
                boolToReturn = true;
                break;
            case Single:
                if (!task.getRepeating()) {
                    boolToReturn = true;
                }
                break;
            case Repeating:
                if (task.getRepeating()) {
                    boolToReturn = true;
                }
                break;
        }  

        return boolToReturn;
    }

    //passes the category filter
    static public boolean passesCategoryFilter(Task task, 
            Category category) {
        
        boolean boolToReturn = false;
        
        if (category == null) {
            boolToReturn = true;
        } else if (task.category == category) {
            boolToReturn = true;
        }

        return boolToReturn;
    }

    //passes the month filter
    static public boolean passesMonthFilter(Task task, 
            int month) {
        
        boolean boolToReturn = false;
        
        if (month == -1) {
            boolToReturn = true;
        } else if (task.month == month) {
            boolToReturn = true;
        }
        
        return boolToReturn;
    }

    //passes the year filter
    static public boolean passesYearFilter(Task task, 
            int year) {
        
        boolean boolToReturn = false;
        
        if (year == -1) {
            boolToReturn = true;
        } else if (task.year == year) {
            boolToReturn = true;
        }
        
        return boolToReturn;
    }
    
    //passes the day filter
    static public boolean passesDayFilter(Task task, 
            int day) {
        
        boolean boolToReturn = false;
        
        if (day == -1) {
            boolToReturn = true;
        } else if (task.day == day) {
            boolToReturn = true;
        }

        return boolToReturn;
    }
}

