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
        length = 200;
        
        Presser addButton = new Presser(buttonAction, "temp", increment);
        Presser subButton = new Presser(buttonAction, "temp", -increment);
        Label temp = new Label("temp", Color.BLUE);
        
        w.addObject(subButton, x, y);
        w.addObject(temp, x+length/2, y);
        w.addObject(addButton, x+length, y); //no work rn
    }
}
