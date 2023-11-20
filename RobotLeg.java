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
