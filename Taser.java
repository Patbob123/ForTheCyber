import greenfoot.*;
/**
 * Write a description of class Taser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Taser extends Augment 
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Taser
     */
    public Taser()
    {
        portraitImage = new GreenfootImage("augment/taser.png");
        scaleImage(portraitImage);
        
        name = "Taser";
        desc = "Go invis";
    }

    public void activateInitial(){
        owner.setStunner();
    }
}
