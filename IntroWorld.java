import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * THE SECOND WORLD: Used to display the opening story for the simulation
 * 
 * @author Edmond
 * @version nov2023
 */
public class IntroWorld extends SuperWorld
{
    private GreenfootImage scene1, scene2, scene3, scene4, click;
    private int acts, currActs;
    private boolean mouseIsClicked;
    private Fader fade, fadeOut;
    /**
     * Constructor for objects of class IntroWorld.
     */
    public IntroWorld()
    {    
        super(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT, 1); 
        
        // Story Board Images
        scene1 = new GreenfootImage("transparentBg.png");
        scene2 = new GreenfootImage("ohnoBg.png");
        scene3 = new GreenfootImage("deaddogBg.png");
        scene4 = new GreenfootImage("takerevengeBg.png");
        click = new GreenfootImage("click.png");
        
        fade = new Fader(60*2,false);
        fadeOut = new Fader(60*2,true);
        addObject(fade, Constants.WORLD_WIDTH/2, Constants.WORLD_HEIGHT/2);
        sm.stopSounds();
        setBackground(scene1);
    }
    
    /**
     * Act method controls the timming of the story board and the sound effects
     */
    public void act() {
        super.act();
        acts++;
        
        if (acts == 90){
            sm.playSound("blast");
        }
        
        if (acts == (100)){
            setBackground(scene2);
        }
        
        if (acts == (60*2 + 60*3)){
            sm.playSound("boom");
            setBackground(scene3);
        }
        
        if (acts > (60*5 + 60*2 + 60*3)){
            setBackground(scene4);
        }
        
        if (acts == (60*2 + 60*5 + 60*2 + 60*4)){
            scene4.drawImage(click, 0, 0); //display some text to let the user know to click to proceed
        }
        
        if(acts > (60*5 + 60*2 + 60*4)) {
            if(Greenfoot.mouseClicked(null)){ //if mouse click and more than 4 seconds
                mouseIsClicked = true;
                sm.playSound("blip");
            }
        }
        
        if(mouseIsClicked){
            addObject(fadeOut, Constants.WORLD_WIDTH/2, Constants.WORLD_HEIGHT/2);
            currActs++;
            if (currActs >= fadeOut.getMaxDuration()){
                Greenfoot.setWorld(new EnemyWorld());
            }
        }
    }
}
