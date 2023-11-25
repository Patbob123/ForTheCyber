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
        
        setPaintOrder(  
            Popup.class,
            Presser.class,
            SuperTextBox.class,
            TextManager.class,
            CustomizePanel.class,
            AttackQueue.class,
            Container.class,
            HPBar.class,
            Effect.class,
            
            
            
            StatBar.class,
            SuperSmoothMover.class,
            UserChar.class,
            Attack.class,
            Enemy.class
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
    public void act(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse == null) return;
        if(Greenfoot.mouseClicked(null)){
            Cursor cursorAnim = new Cursor();
            addObject(cursorAnim, mouse.getX(), mouse.getY());
        }
    }
    
}
