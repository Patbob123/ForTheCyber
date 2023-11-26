import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Superworld is a wrapper class of all the worlds, does not need to be abstract
 * 
 * @author Dawson Li
 * @version November, 24, 2023
 */
public class SuperWorld extends World
{

    protected SoundManager sm;
    protected Fader fade, fadeOut;
    protected int currActs;
    protected boolean goingToWorld;
    private World world;
    /**
     * Constructor for SuperWorld
     * 
     * 
     */
    public SuperWorld(int width, int height, int pixel)
    {    
        super(width, height, pixel); 
        
        //setting initial values for variables
        currActs = 0;
        goingToWorld = false;
        
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
            StatBar.class,
            
            
            
            
            Effect.class,
            SuperSmoothMover.class,
            UserChar.class,
            Attack.class,
            Enemy.class
        );
        
        //faders
        fade = new Fader ((60*3), false); //60 acts = 1 second, so 3 seconds for fader
        fadeOut = new Fader ((60*2), true);
        
        //add fader object to fade in on creation
        addObject(fade, Constants.WORLD_WIDTH/2, Constants.WORLD_HEIGHT/2);
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
    
    /**
     * Track mouse info for animations
     */
    public void act(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse == null) return;
        if(Greenfoot.mouseClicked(null)){
            sm.playSound("blip");//click sound
            Cursor cursorAnim = new Cursor();
            addObject(cursorAnim, mouse.getX(), mouse.getY());
        }
        if(goingToWorld){
            currActs++;
            //when fader is done, stop sounds and switch worlds
            if(currActs >= fadeOut.getMaxDuration()){
                sm.stopSounds();
                Greenfoot.setWorld(world);
            }
        }
    }
    public void goToWorld(World w){
        goingToWorld = true;
        sm.playSound("transition");
        //add fade out object
        addObject(fadeOut, Constants.WORLD_WIDTH/2, Constants.WORLD_HEIGHT/2);
        world = w;
    }
    
}
