import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IntroWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntroWorld extends World
{
    private int acts;
    
    /**
     * Constructor for objects of class IntroWorld.
     * 
     */
    public IntroWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }
    
    public void act() {
        acts++;
        
        if(acts > 300) {
            //display some text to let the user know to click to go to BuilderWorld
            if(Greenfoot.mouseClicked(null)) {
                Greenfoot.setWorld(new EnemyWorld());
            }
        }
       
        
    }
}
