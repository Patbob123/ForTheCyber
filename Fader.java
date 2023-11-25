import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Levelup here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fader extends Popup
{
    private int fadeDuration;
    private int maxDuration;
    private boolean reverse;
    
    public Fader(int maxDuration, boolean reverse) {
        this.reverse = reverse;
        this.maxDuration = maxDuration;
        fadeDuration = reverse ? maxDuration: 0;
        popupImage = new GreenfootImage(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT);
        popupImage.fill();
        
        popupImage.setTransparency(255-(int)(((double)fadeDuration/maxDuration)*255));
        setImage(popupImage);
    }
    
    public void act() {
        fadeDuration += reverse ? -1 : 1;
        if(fadeDuration > maxDuration || fadeDuration < 0){
            getWorld().removeObject(this);
            return;
        }
        getImage().setTransparency(255-(int)(((double)fadeDuration/maxDuration)*255));
        
    }
    
    public int getMaxDuration(){
        return maxDuration;
    }
    
}
