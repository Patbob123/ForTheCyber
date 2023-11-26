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
    
    
    public Levelup() {
        //flash 6 times in 3 seconds
        flashDuration = 60;
        flashTime = 10;
        popupImage = new GreenfootImage("levelup.png");
        altImage = new GreenfootImage("levelup2.png");
        
        popupImage.scale(popupImage.getWidth()*Constants.IMAGE_SCALING, popupImage.getHeight()*Constants.IMAGE_SCALING);
        altImage.scale(altImage.getWidth()*Constants.IMAGE_SCALING, altImage.getHeight()*Constants.IMAGE_SCALING);
        
        setImage(popupImage);
    }
    
    public void act() {
        flashDuration--;
        if(flashDuration % flashTime == 0) {
            //switch to another frame
            setImage(altImage);
            if(flashDuration % (flashTime*2) == 0){
                setImage(popupImage);
            }
        }
        
        if(flashDuration <= 0) {
            getWorld().removeObject(this);
            return;
        }
        
    }
    
    
}
