import greenfoot.*;
/**
 * Gives the user the ability to stun on it's attack
 * 
 * @author Dawson
 * @version November 2023
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
        desc = "The enemy's turn will /n be skipped due to the taser's shock.";
    }

    /**
     * Method to initialize stunner
     */
    public void activateInitial(){
        owner.setStunner();
    }
}
