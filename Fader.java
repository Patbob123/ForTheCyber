import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates fade in and fade out screen
 * 
 * @author Jaiden
 * <p>
 * Modified by: Dawson
 * </p>
 * @version November 2023
 */
public class Fader extends Popup
{
    private int fadeDuration;
    private int maxDuration;
    private boolean reverse;
    
    /**
     * Constructor for Fader 
     * 
     * @param maxDuration          Length of fader 
     * @param reverse              Boolean to determine whether to fade in or out
     */
    public Fader(int maxDuration, boolean reverse) {
        this.reverse = reverse;
        this.maxDuration = maxDuration;
        fadeDuration = reverse ? maxDuration: 0;
        popupImage = new GreenfootImage(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT);
        popupImage.fill();
        popupImage.setTransparency(255-(int)(((double)fadeDuration/maxDuration)*255));
        setImage(popupImage);
    }
    
    /**
     * Act method
     */
    public void act() {
        // Check whether or not to fade in or fade out
        fadeDuration += reverse ? -1 : 1;
        
        if(fadeDuration > maxDuration || fadeDuration < 0){
            getWorld().removeObject(this);
            return;
        }
        getImage().setTransparency(255-(int)(((double)fadeDuration/maxDuration)*255));
        
    }
    
    /**
     * Method to get max duration
     * 
     * @return duration
     */
    public int getMaxDuration(){
        return maxDuration;
    }
    
}
