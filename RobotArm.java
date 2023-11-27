import greenfoot.*;
/**
 * Increases the user's attack and speed each time they level up
 * 
 * @author Dawson
 * @version November 2023
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
        desc = "Gain a powerful arm to destroy your enemies. /n Level Up: /n Strength + 2 /n Speed +1";
    }

    /**
     * Method to level up the augment
     */
    public String activateLevelUp(){
        addLevelup();
        
        owner.setAttack(owner.getAttack()+2);
        owner.setSpeed(owner.getSpeed()+1);
        
        return owner+" gained 2 attack and 1 speed from "+getName();
    }
}
