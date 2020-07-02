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
public enum Category {
    Homework, Crafts, Housework, Piano, Miscellaneous;
    
    @Override
    //convert each enum vaue to a string
    public String toString() {
        String stringToReturn = null;
        //switch statemrnt converts enum value to string
        switch(this) {
            case Homework:
                stringToReturn = "Homework";
                break;
            case Crafts:
                stringToReturn = "Crafts";
                break;
            case Housework:
                stringToReturn = "Housework";
                break;
            case Piano:
                stringToReturn = "Piano";
                break;
            case Miscellaneous:
                stringToReturn = "Miscellaneous";
                break;
        }
        
        return stringToReturn;
    }
    
    public static Category CreateFromString(String value) {
        Category categoryToReturn = null;
        
        //switch statement converts string to enum value
        System.out.println(value);
        switch (value) {
            case "Homework":
                categoryToReturn = Category.Homework;
                break;
            case "Crafts":
                categoryToReturn = Category.Crafts;
                break;
            case "Housework":
                categoryToReturn = Category.Housework;
                break;
            case "Piano":
                categoryToReturn = Category.Piano;
                break;
            case "Miscellaneous":
                categoryToReturn = Category.Miscellaneous;
                break;
            default:
                System.out.println("switch failed");
        }
        
        return categoryToReturn;
    }
}