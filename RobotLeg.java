import greenfoot.*;
/**
 * RobotLeg increases the user's speed and attack per levelup.
 * 
 * @author Dawson
 * @version November 2023
 */
public class RobotLeg extends Augment 
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class RobotLeg
     */
    public RobotLeg()
    {
        portraitImage = new GreenfootImage("augment/robotleg.png");
        scaleImage(portraitImage);
        
        name = "Robot Leg";
        desc = "Gain a powerful leg to destroy your enemies. /n Level Up: /n Strength + 1 /n Speed +2";
    }

    public String activateLevelUp(){
        addLevelup();
        
        owner.setAttack(owner.getAttack()+1);
        owner.setSpeed(owner.getSpeed()+2);
        
        return owner+" gained 1 attack and 2 speed from "+getName();
    }
}
