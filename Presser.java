import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Button class that runs its Function object's function when clicked by the mouse
 * 
 * @author Dawson
 * @version 2023-06-20
 */

public class Presser extends Actor
{
    private int startX;
    private int startY;
    
    private SetterFunction setterAction;
    private Function action;
    private GreenfootImage buttonImage;
    private GreenfootImage hoverButtonImage;
    
    private int increment;
    
    /**
     * @param buttonAction  The Function object that will run
     * @param buttonFile    The image of the button's directory
     */
    public Presser(SetterFunction buttonAction, String buttonFile, String hoverButtonFile, int increment){
        buttonImage = new GreenfootImage(buttonFile);
        hoverButtonImage = new GreenfootImage(hoverButtonFile);
        this.increment = increment;
        if(increment > 0) {
            buttonImage.mirrorHorizontally();
            hoverButtonImage.mirrorHorizontally();
        }
        
        buttonImage.scale(buttonImage.getWidth()*Constants.IMAGE_SCALING, buttonImage.getHeight()*Constants.IMAGE_SCALING);
        hoverButtonImage.scale(hoverButtonImage.getWidth()*Constants.IMAGE_SCALING, hoverButtonImage.getHeight()*Constants.IMAGE_SCALING);
        setImage(buttonImage);
        setterAction = buttonAction;
        
        
    }
    public Presser(Function buttonAction, String buttonFile){
        buttonImage = new GreenfootImage(50, 50);
        buttonImage.setColor(Color.YELLOW);
        buttonImage.fill();
        //buttonImage = new GreenfootImage(buttonFile);
        buttonImage.scale(buttonImage.getWidth(), buttonImage.getHeight());
        setImage(buttonImage);
        action = buttonAction;
    }
    
    /**
     * Act method
     * For clicking and hovering
     */
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            runAction();
        }
        detectHover();
    }
    
    /**
     * Mutator for X and Y
     */
    protected void addedToWorld(World w){
        startX = getX();
        startY = getY();
    }
    
    /**
     * Running the Function object's function
     */
    public void runAction() {
        if(setterAction != null) setterAction.applySetter(increment);
        if(action != null) action.apply();
    }
    
    /**
     * Checks if the mouse is hovering over the button, if so, move the button up for a visual effect
     * KNOWN ISSUE: if the mouse is on the bottom of the button, then it will start jittering due to the mouse rapidly entering and leaving the button
     */
    private void detectHover(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse!=null){
            List hovering = getWorld().getObjectsAt(mouse.getX(), mouse.getY(), Presser.class);
            if(hovering.contains(this)){
                setImage(hoverButtonImage); //Moves the button up
            }else{
                setImage(buttonImage); //Moves the button back to starting position
            }
        }
    }
}
