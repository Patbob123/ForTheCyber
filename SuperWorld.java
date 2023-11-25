import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SuperWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SuperWorld extends World
{

    protected SoundManager sm;
    
    public SuperWorld(int width, int height, int pixel)
    {    
        super(width, height, pixel); 
        
        sm = new SoundManager();
        addObject(sm, 0, 0);
        setPaintOrder(  
            Popup.class,
            Presser.class,
            AttackQueue.class,
            Container.class,
            HPBar.class,
            Effect.class,
            SuperTextBox.class,
            TextManager.class,
            StatBar.class,
            CustomizePanel.class,
            SuperSmoothMover.class
        );
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
