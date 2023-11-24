import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IntroWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntroWorld extends World
{
    private int acts;
    
    private GreenfootImage scene1, scene2, scene3, scene4, click;
    private GreenfootSound blast;
    /**
     * Constructor for objects of class IntroWorld.
     * 
     */
    public IntroWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT, 1); 
        scene1 = new GreenfootImage("whiteBg.png");
        scene2 = new GreenfootImage("ohnoBg.png");
        scene3 = new GreenfootImage("deaddogBg.png");
        scene4 = new GreenfootImage("takerevengeBg.png");
        click = new GreenfootImage("click.png");
        blast = new GreenfootSound("blaster.mp3");
    }
    
    public void act() {
        acts++;
        
        if (acts == 0){
            setBackground(scene1);
        }
        
        if (acts == 90){
            blast.play();
        }
        
        if (acts == (100)){
            setBackground(scene2);
        }
        
        if (acts == (60*2 + 60*3)){
            setBackground(scene3);
        }
        
        if (acts > (60*5 + 60*2 + 60*3)){
            setBackground(scene4);
        }
        
        if (acts > (60*2 + 60*5 + 60*2 + 60*4)){
            scene4.drawImage(click, 0, 0);
        }
        
        if(acts > (60*5 + 60*2 + 60*4)) {
            //display some text to let the user know to click to go to BuilderWorld
            if(Greenfoot.mouseClicked(null)) {
                Greenfoot.setWorld(new EnemyWorld());
            }
        }
        
    }
}
