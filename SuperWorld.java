import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Superworld is a wrapper class of all the worlds 
 * 
 * @author Dawson Li
 * @version November, 24, 2023
 */
public class SuperWorld extends World
{

    protected SoundManager sm;
    
    public SuperWorld(int width, int height, int pixel)
    {    
        super(width, height, pixel); 
        
        sm = new SoundManager();
        addObject(sm, 0, 0);
        /*
        setPaintOrder(          
            Popup.class,
            Presser.class,
            AttackQueue.class,
            Container.class,
            HPBar.class,
            Effect.class,
            SuperTextBox.class,
            CustomizePanel.class,
            TextManager.class,
            
            StatBar.class,
            SuperSmoothMover.class
        );
        */
    }
    
    
    public void started(){
        sm.resumeSounds();
    }
    public void stopped(){
        sm.pauseSounds();
    }
    public SoundManager getSM(){
        return sm;
    }
    
}
