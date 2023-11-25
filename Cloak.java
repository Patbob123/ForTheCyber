import greenfoot.*;
/**
 * Write a description of class Cloak here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cloak extends Augment 
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Cloak
     */
    public Cloak()
    {
        portraitImage = new GreenfootImage("augment/cloak.png");
        scaleImage(portraitImage);
        
        name = "Stealth Cloak";
        desc = "Dodge chance of 30%";
    }

    public void activateInitial(){
        owner.setDodge();
    }
        
}
