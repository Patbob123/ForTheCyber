import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Generate rain effect 
 * 
 * @author Jaiden
 * @version November, 2023
 */
public class Rain extends Effect
{
    private int acts;
    private int actsPerFrame;
    private int frames;
    private int curFrame;
    private GreenfootImage[] rainImages;
    
    /**
     * Basic constructor for rain
     */
    public Rain() {
        frames = 3;
        curFrame = 0;
        acts = 0;
        actsPerFrame = 10;
        
        rainImages = new GreenfootImage[frames];
        for(int i = 0; i < frames; i++){
            rainImages[i] = new GreenfootImage("rain"+(i+1)+".png");
            rainImages[i].scale(rainImages[i].getWidth()*Constants.IMAGE_SCALING, rainImages[i].getHeight()*Constants.IMAGE_SCALING);
        }

        
        setImage(rainImages[curFrame]);
    }
    
    /**
     * Act method
     */
    public void act() {
        acts++;
        
        //Controls frames for rain
        if(acts >= actsPerFrame){
            acts = 0;
            curFrame++;
            if(curFrame >= rainImages.length){
                curFrame = 0;
            }
            setImage(rainImages[curFrame]);
        }
        
        
    }
}
