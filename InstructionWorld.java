import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class InstructionWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstructionWorld extends SuperWorld
{
    GreenfootImage bg;
    ArrayList<ArrayList<Enemy>> stages;
    /**
     * Constructor for objects of class InstructionWorld.
     * 
     */
    public InstructionWorld(ArrayList<ArrayList<Enemy>> stages)
    {    
        super(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT, 1); 
        this.stages = stages;
        // Bg Image
        bg = new GreenfootImage("instuctions.png");
        setBackground(bg);
    }
    /**
     * Act method to click to the next world
     */
    public void act() {
        super.act();
        
        //if mouse click 
        if(Greenfoot.mouseClicked(null)){
            goToWorld(new BuilderWorld(stages));
        }
        
    }
}
