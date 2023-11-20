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
