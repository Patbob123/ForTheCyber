import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.FontFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Adds stats to the user character after selecting stats in the battle world
 * 
 * @author Dawson
 * @version November 2023
 */
public class StatSetter extends Actor
{
    private int length;
    private Presser addButton;
    private Presser subButton;
    
    private int x;
    private int y;
    
    private TextPlace amountDisplay;
    private TextPlace descDisplay;
    
    /**
     * Constructor for StatSetter
     * 
     * @param buttonAction              The Function object that will run 
     * @param increment                 Controls how much stats is added per click
     * @param text                      The name of the file image
     * @param x                         X position 
     * @param y                         Y position
     */
    public StatSetter(SetterFunction buttonAction, int increment, String text, int x, int y){
        length = 210;
        this.x = x;
        this.y = y;
        
        addButton = new Presser(buttonAction, "arrow.png", "arrowclicked.png",  increment);
        subButton = new Presser(buttonAction, "arrow.png", "arrowclicked.png", -increment);
        
        setImage(new GreenfootImage(1,1));
    }
    
    /**
     * Method to add to world
     * 
     * @param w      The world it gets added to
     */
    public void addedToWorld(World w){
        amountDisplay = TextPlace.initTextDisplay("Select Augment", x+length/2, y+10, 100, true);
        descDisplay = TextPlace.initTextDisplay("Select Augment", getX(), getY()+10);

        getWorld().addObject(subButton, x, y);
        getWorld().addObject(amountDisplay, x+length/2, y);
        getWorld().addObject(addButton, x+length, y); 

        amountDisplay.setSentence("1");
    }
    
    /**
     * Updates the display of the stat
     * 
     * @param amount          The amount it gets set to
     */
    public void update(double amount){
        amountDisplay.setSentence(String.valueOf((int)amount));
    }


}
