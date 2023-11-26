import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Create next wave display image
 * 
 * @author Jaiden
 * @version November 2023
 */
public class NextWave extends Popup
{
    private int acts;
    private int actsPerFrame;
    private int frames;
    private int curFrame;
    private GreenfootImage[] nextWaveImages;
    
    public NextWave() {
        frames = 10;
        curFrame = 0;
        acts = 0;
        actsPerFrame = 8;
        
        nextWaveImages = new GreenfootImage[frames];
        for(int i = 0; i < frames; i++){
            nextWaveImages[i] = new GreenfootImage("nextwave/nextwave"+(i+1)+".png");
            nextWaveImages[i].scale(nextWaveImages[i].getWidth()*Constants.IMAGE_SCALING, nextWaveImages[i].getHeight()*Constants.IMAGE_SCALING);
        }

        
        setImage(nextWaveImages[curFrame]);
    }
    
    public void act() {
        acts++;
        if(acts >= actsPerFrame){
            acts = 0;
            curFrame++;
            if(curFrame >= nextWaveImages.length){
                getWorld().removeObject(this);
                return;
            }
            setImage(nextWaveImages[curFrame]);
        }
        
        
    }
    
    
}
