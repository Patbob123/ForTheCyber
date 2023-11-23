import greenfoot.*;
/**
 * Write a description of class RobotArm here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RobotArm extends Augment 
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class RobotArm
     */
    public RobotArm()
    {
        portraitImage = new GreenfootImage("augment/robotarm.png");
        scaleImage(portraitImage);
        
        name = "Robot Arm";
        desc = "Go invis";
    }

    public String activateLevelUp(){
        owner.setAttack(owner.getAttack()+2);
        owner.setSpeed(owner.getSpeed()+1);
        
        return owner+" gained 2 attack and 1 speed from "+getName();
    }
}