import greenfoot.*;
/**
 * Write a description of class LongArm here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        desc = "Attacks all enemies. Enemies will get hit 6 times.";
    }

    public void activateInitial(){
        owner.setWideRange();
    }
}
