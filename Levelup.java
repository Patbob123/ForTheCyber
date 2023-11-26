import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Create level up display 
 * 
 * @author Jaiden
 * @version November 2023
 */
public class Levelup extends Popup
{
    private int flashTime;
    private int flashDuration;
    
    /**
     * Constructor for Levelup
     */
    public Levelup() {
        flashDuration = 60; // 1 second
        flashTime = 10;
        popupImage = new GreenfootImage("levelup.png");
        altImage = new GreenfootImage("levelup2.png");
        
        popupImage.scale(popupImage.getWidth()*Constants.IMAGE_SCALING, popupImage.getHeight()*Constants.IMAGE_SCALING);
        altImage.scale(altImage.getWidth()*Constants.IMAGE_SCALING, altImage.getHeight()*Constants.IMAGE_SCALING);
        
        setImage(popupImage);
    }
    
    /**
     * Act method
     */
    public void act() {
        flashDuration--;
        
        //Switches between 2 frames
        if(flashDuration % flashTime == 0) {
            //switch to another frame
            setImage(altImage);
            if(flashDuration % (flashTime*2) == 0){
                setImage(popupImage);
            }
        }
        
        //removes object
        if(flashDuration <= 0) {
            getWorld().removeObject(this);
            return;
        }
        
    }
    
    
}
