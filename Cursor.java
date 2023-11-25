import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Create next wave display image
 * 
 * @author Jaiden
 * @version November 2023
 */
public class Cursor extends Popup
{
    private int acts;
    private int actsPerFrame;
    private int frames;
    private int curFrame;
    private GreenfootImage[] cursorImages;
    
    public Cursor() {
        frames = 5;
        curFrame = 0;
        acts = 0;
        actsPerFrame = 8;
        
        cursorImages = new GreenfootImage[frames];
        for(int i = 0; i < frames; i++){
            cursorImages[i] = new GreenfootImage("click/"+(i+1)+".png");
            cursorImages[i].scale(cursorImages[i].getWidth()*Constants.IMAGE_SCALING, cursorImages[i].getHeight()*Constants.IMAGE_SCALING);
        }

        
        setImage(cursorImages[curFrame]);
    }
    
    public void act() {
        acts++;
        if(acts >= actsPerFrame){
            acts = 0;
            curFrame++;
            if(curFrame >= cursorImages.length){
                getWorld().removeObject(this);
                return;
            }
            setImage(cursorImages[curFrame]);
        }
        
        
    }
    
    
}
