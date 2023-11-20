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

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
