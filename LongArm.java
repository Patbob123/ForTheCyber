import greenfoot.*;
/**
 * Allows the user to attack multiple targets in one turn
 * 
 * @author Dawson
 * @version November 2023
 */
public class LongArm extends Augment 
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class LongArm
     */
    public LongArm()
    {
        portraitImage = new GreenfootImage("augment/longarm.png");
        scaleImage(portraitImage);
        
        name = "Wick's Stick";
        desc = "Attacks all enemies at once when it is your /n turn.";
    }

    /**
     * Method to initialize wide range
     */
    public void activateInitial(){
        owner.setWideRange();
    }
}
