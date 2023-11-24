import greenfoot.*;
/**
 * Write a description of class RobotLeg here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        desc = "Go invis";
    }

    public String activateLevelUp(){
        addLevelup();
        
        owner.setAttack(owner.getAttack()+1);
        owner.setSpeed(owner.getSpeed()+2);
        
        return owner+" gained 1 attack and 2 speed from "+getName();
    }
}
