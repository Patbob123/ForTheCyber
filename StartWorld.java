import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartWorld here.
 * 
 * @author Edmond 
 * @version nov2023
 */
public class StartWorld extends World
{
    private int acts, frameCount;
    
    private static GifImage startBg;
    private GreenfootSound startMusic;
    private boolean playingLoopedAnim;
    
    private GreenfootImage bgImage, transparentBg;
    private GreenfootImage logoF1, logoF2, logoF3;
    private GreenfootImage currImg;
    /**
     * Constructor for objects of class StartWorld.
     * 
     */
    public StartWorld()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT, 1);  
        
        startBg = new GifImage ("startBg.gif"); //add this in when added startBg
        transparentBg = new GreenfootImage ("transparentBg.png");
        logoF1 = new GreenfootImage("logof1.png");
        logoF2 = new GreenfootImage("logof2.png");
        logoF3 = new GreenfootImage("logof3.png");
        
        bgImage = startBg.getCurrentImage();
        //setBackground (bgImage);
        
        setBackground (transparentBg);
        
        frameCount = 0;
        playingLoopedAnim = true;
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
        
        //playLogoAnim();
        currImg = getLogoImg();
        bgImage = startBg.getCurrentImage();
        transparentBg.drawImage(bgImage, 0, 0);
        
        if(playingLoopedAnim){
            if(Greenfoot.getRandomNumber(20) > 1){
                    transparentBg.drawImage(currImg, 0, 0);
                }
            } //draw logo img ontop
    }
    
    private GreenfootImage getLogoImg(){
        if (acts % 3 == 0){
            return(logoF1);
        }
        if (acts % 3 == 1){
            return(logoF2);
        }
        if (acts % 3 == 2){
            return(logoF3);
        }
        return(logoF1);
    }
    
    public void started (){
        //startMusic.playLoop();//on play, play music
    }
    
    public void stopped (){
        //startMusic.stop();//on pause, pause music
    }
    
}
