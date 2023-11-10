import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UI extends Actor
{
    public UI(int width, int height) {
        GreenfootImage rectangleImage = new GreenfootImage(width, height);
        rectangleImage.setColor(Color.BLACK);
        rectangleImage.fill();
        setImage(rectangleImage);
    }
    
    /**
     * Act - do whatever the UI wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
