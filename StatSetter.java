import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.FontFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Write a description of class StatSetters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StatSetter extends Actor
{
    private int length;
    
    private TextPlace amountDisplay;
    private TextPlace descDisplay;
    public StatSetter(SetterFunction buttonAction, int increment, String text, int x, int y, World w){
        length = 210;
        
        Presser addButton = new Presser(buttonAction, "arrow.png", "arrowclicked.png",  increment);
        Presser subButton = new Presser(buttonAction, "arrow.png", "arrowclicked.png", -increment);
        //TextPlace temp = new Label(text, Color.BLUE);
        
        w.addObject(subButton, x, y);
        //w.addObject(temp, x+length/2, y);
        w.addObject(addButton, x+length, y); //no work rn
    }
    public void addedToWorld(World w){
        amountDisplay = initTextDisplay("Select Augment", getX(), getY());
        descDisplay = initTextDisplay("Select Augment", getX(), getY()+10);
        
        getWorld().addObject(amountDisplay, getX(), getY());
        getWorld().addObject(descDisplay, getX(), getY());
    }
    public TextPlace initTextDisplay(String text, int x, int y){
        try{
            TextPlace textDisplay = new TextPlace(text, x, y);
            return textDisplay;
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

}
