import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Levelup here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Levelup extends Popup
{
    private int flashTime;
    private int flashDuration;
    
    
    public Levelup() {
        //flash 6 times in 3 seconds
        flashDuration = 60;
        flashTime = 10;
        popupImage = new GreenfootImage(500, 500);
        popupImage.fill();
        altImage = new GreenfootImage(1,1);
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
