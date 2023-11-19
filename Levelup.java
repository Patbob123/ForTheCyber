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
        flashDuration = 180;
        flashTime = 30;
        
    }
    
    public void act() {
        flashDuration--;
        if(flashDuration % flashTime == 0) {
            //switch to another frame
            
        }
        
        if(flashDuration == 0) {
            //remove popup 
        }
        
    }
    
    
}
