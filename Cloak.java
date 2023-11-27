import greenfoot.*;
/**
 * Gives the user the chance to dodge attacks
 * 
 * @author Dawson
 * @version November 2023
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

    /**
     * Methdo to initialize dodge
     */
    public void activateInitial(){
        owner.setDodge();
    }
        
}
