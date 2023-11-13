import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StatSetters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StatSetter
{
    private int length;
    
    
    public StatSetter(SetterFunction buttonAction, int increment, String text, int x, int y, World w){
        length = 210;
        
        Presser addButton = new Presser(buttonAction, "arrow.png", "arrowclicked.png",  increment);
        Presser subButton = new Presser(buttonAction, "arrow.png", "arrowclicked.png", -increment);
        Label temp = new Label(text, Color.BLUE);
        
        w.addObject(subButton, x, y);
        w.addObject(temp, x+length/2, y);
        w.addObject(addButton, x+length, y); //no work rn
    }
}
