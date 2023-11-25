import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartWorld here.
 * 
 * @author Edmond 
 * @version nov2023
 */
public class StartWorld extends SuperWorld
{
    private int acts, currActs;
    private boolean mouseIsClicked, playLoopedAnim;
    private static GifImage startBg;
    private GreenfootImage bgImage, transparentBg, whiteBg;
    private GreenfootImage logoF1, logoF2, logoF3;
    private GreenfootImage currImg;
    private Fader fade, fadeOut;
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
        whiteBg = new GreenfootImage("whiteBg.png");
        bgImage = startBg.getCurrentImage();
        
        setBackground (transparentBg);
        fade = new Fader ((60*4), false); //60 acts = 1 second, so 4 seconds for fader
        fadeOut = new Fader ((60*2), true);
        playLoopedAnim = true;
        mouseIsClicked = false;
        currActs = 0;
        addObject(fade, Constants.WORLD_WIDTH/2, Constants.WORLD_HEIGHT/2);

    }
    
    public void act (){
        
        acts++;
        
        if(acts==1)sm.playSoundLoop("Jaded");
        
        if (acts == 10){
            sm.playSoundLoop("rain");
        }
        
        if(acts > 240 && Greenfoot.mouseClicked(null)){ //if mouse click and more than 4 seconds
            mouseIsClicked = true;
            sm.playSound("blip");
        }
        
        if(mouseIsClicked){
            addObject(fadeOut, Constants.WORLD_WIDTH/2, Constants.WORLD_HEIGHT/2);
            currActs++;
            if (currActs >= fadeOut.getMaxDuration()){
                sm.stopSounds();
                Greenfoot.setWorld(new IntroWorld());
            }
        }
        
        //playLogoAnim();
        currImg = getLogoImg();
        bgImage = startBg.getCurrentImage();
        transparentBg.drawImage(bgImage, 0, 0);
        
        if(playLoopedAnim){
            if(acts < (60*2)){
                if(Greenfoot.getRandomNumber(20) > 1){
                        transparentBg.drawImage(currImg, 0, 0);
                }
            } else if (acts < (60*5)){
                if(Greenfoot.getRandomNumber(50) > 1){
                        transparentBg.drawImage(currImg, 0, 0);
                }
            } else if (acts < (60*8)){
                if(Greenfoot.getRandomNumber(80) > 1){
                        transparentBg.drawImage(currImg, 0, 0);
                }
            } else {
                if(Greenfoot.getRandomNumber(120) > 1){
                        transparentBg.drawImage(currImg, 0, 0);
                }
            }
        } //draw logo img ontop
        
        if(acts >= (60*60)){ //if wait 1 min, easter egg (logo dies)
            playLoopedAnim = false;
        }

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
    
    
    
}
