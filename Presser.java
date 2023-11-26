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
    
    private AugmentFunction augmentAction;
    private SetterFunction setterAction;
    private Function action;
    private GreenfootImage buttonImage;
    private GreenfootImage hoverButtonImage;
    
    private boolean hovering;
    
    private int increment;
    private String augment;
    
    /**
     * Standard Constructor
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
    public Presser(Function buttonAction, String buttonFile, String hoverButtonFile){
        buttonImage = new GreenfootImage(buttonFile);
        hoverButtonImage = new GreenfootImage(hoverButtonFile);
        buttonImage.scale(buttonImage.getWidth()*Constants.IMAGE_SCALING, buttonImage.getHeight()*Constants.IMAGE_SCALING);
        hoverButtonImage.scale(hoverButtonImage.getWidth()*Constants.IMAGE_SCALING, hoverButtonImage.getHeight()*Constants.IMAGE_SCALING);
        setImage(buttonImage);
        action = buttonAction;
    }
    public Presser(Function buttonAction, GreenfootImage buttonImage){
        buttonImage.scale(buttonImage.getWidth()*Constants.IMAGE_SCALING, buttonImage.getHeight()*Constants.IMAGE_SCALING);
        setImage(buttonImage);
        action = buttonAction;
    }
    /**
     * Constructor for Augment Buttons
     */
    public Presser(AugmentFunction buttonAction, String buttonFile, String hoverButtonFile, String augment){
        buttonImage = new GreenfootImage(buttonFile);
        hoverButtonImage = new GreenfootImage(hoverButtonFile);
        buttonImage.scale(buttonImage.getWidth()*Constants.IMAGE_SCALING, buttonImage.getHeight()*Constants.IMAGE_SCALING);
        hoverButtonImage.scale(hoverButtonImage.getWidth()*Constants.IMAGE_SCALING, hoverButtonImage.getHeight()*Constants.IMAGE_SCALING);
        setImage(buttonImage);
        
        this.augment = augment;
        augmentAction = buttonAction;
    }
    
    /**
     * Act method
     * For clicking and hovering
     */
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            ((SuperWorld)getWorld()).getSM().playSound("click");
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
        if(augmentAction != null) augmentAction.applyAugment(augment);
        if(setterAction != null) setterAction.applySetter(increment);
        if(action != null) action.apply();
    }
    
    /**
     * Checks if the mouse is hovering over the button, if so, change button image for visual effect
     */
    private void detectHover(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse!=null&&hoverButtonImage!=null){
            List hovering = getWorld().getObjectsAt(mouse.getX(), mouse.getY(), Presser.class);
            if(hovering.contains(this)){
                setImage(hoverButtonImage); //Moves the button up
            }else{
                setImage(buttonImage); //Moves the button back to starting position
            }
        }
        if (Greenfoot.mouseMoved(null)) 
        {
            if (hovering != Greenfoot.mouseMoved(this)) 
            {
                hovering = !hovering; 
                if (hovering) 
                {
                    ((SuperWorld)getWorld()).getSM().playSound("hover");
                }
            }
        }
    }
}
