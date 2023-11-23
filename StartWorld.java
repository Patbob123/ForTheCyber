import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartWorld extends World
{
    private int acts;
    
    private static GifImage startBg;
    private GreenfootSound startMusic;
    /**
     * Constructor for objects of class StartWorld.
     * 
     */
    public StartWorld()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1008, 816, 1); 
        
        
        startBg = new GifImage ("startBg.gif"); //add this in when added startBg
        setBackground (startBg.getCurrentImage());
        /**
        startMusic = new GreenfootSound ("startMusic.mp3"); // add this when added startMusic
        */
    }
    
    public void act (){
        acts++;
        if(acts > 120 && Greenfoot.mouseClicked(null)){
            stopped();
            Greenfoot.setWorld(new IntroWorld());
        }
        
        setBackground (startBg.getCurrentImage()); // add when added startBg 
        
    }
    
    public void started (){
        //startMusic.playLoop();//on play, play music
    }
    
    public void stopped (){
        //startMusic.stop();//on pause, pause music
    }
}
