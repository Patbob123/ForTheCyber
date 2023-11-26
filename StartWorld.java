import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * THE FIRST WORLD: Simulation start screen with music, animated Logo, animated bg, and faders
 * <p>
 * Click to proceed
 * </p>
 * @author Edmond 
 * @version 2023 Nov 24
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
     * Constructor for the StartWorld
     */
    public StartWorld()
    {
        super(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT, 1);  

        //Making new background images
        startBg = new GifImage ("startBg.gif"); 
        transparentBg = new GreenfootImage ("transparentBg.png");
        setBackground (transparentBg);

        //Making frames of logo animation
        logoF1 = new GreenfootImage("logof1.png");
        logoF2 = new GreenfootImage("logof2.png");
        logoF3 = new GreenfootImage("logof3.png");
        whiteBg = new GreenfootImage("whiteBg.png");
        bgImage = startBg.getCurrentImage();

        //faders
        fade = new Fader ((60*4), false); //60 acts = 1 second, so 4 seconds for fader
        fadeOut = new Fader ((60*2), true);

        //setting initial values for variables
        playLoopedAnim = true;
        mouseIsClicked = false;
        currActs = 0;

        //add fader object to fade in on creation
        addObject(fade, Constants.WORLD_WIDTH/2, Constants.WORLD_HEIGHT/2);

    }
    
    /**
     * Main act method loops through all the music and ambient sounds
     */
    public void act (){
        super.act();
        
        //keep track of acts, animate bg
        acts++;
        animateBg();

        if(acts==1){
            //this instead of constructor so the music doesnt play before simulation is run
            sm.playSoundLoop("Jaded");
            sm.fadeIn("Jaded");
        }
        
        if (acts == 10){
            //play rain ambience
            sm.playSoundLoop("rain");
        }
        
        if(Greenfoot.mouseClicked(null)){
            //click sound
            sm.playSound("blip");
        }
        
        if(acts > 240 && Greenfoot.mouseClicked(null)){ //if mouse clicked and more than 4 seconds
            //tells everyone that the mouse has been clicked, so get ready to switch worlds
            mouseIsClicked = true;
            
            //fade out music + ambience
            sm.fadeOut("Jaded");
            sm.fadeOut("rain");
        }
        
        if(mouseIsClicked){
            //add fade out object
            addObject(fadeOut, Constants.WORLD_WIDTH/2, Constants.WORLD_HEIGHT/2);
            
            //mark how many acts has passed
            currActs++;
            
            if (currActs >= fadeOut.getMaxDuration()){
                //when fader is done, stop sounds and switch worlds
                sm.stopSounds();
                Greenfoot.setWorld(new IntroWorld());
            }
        }
        
        //logo "glitches" out a lot at beginnning, but becomes fairly solid as time passes
        if(playLoopedAnim){
            if(acts < (60*2)){
                if(randNum(20) > 1){
                        transparentBg.drawImage(currImg, 0, 0);
                }
            } else if (acts < (60*5)){
                if(randNum(50) > 1){
                        transparentBg.drawImage(currImg, 0, 0);
                }
            } else if (acts < (60*8)){
                if(randNum(80) > 1){
                        transparentBg.drawImage(currImg, 0, 0);
                }
            } else {
                if(randNum(120) > 1){
                        transparentBg.drawImage(currImg, 0, 0);
                }
            }
        } 
        
        if(acts == (60*30)){ //if wait 30 sec, easter egg (logo dies)
            playLoopedAnim = false;
            sm.playSound("electricshock");
        }

    }
    
    private void animateBg(){
        currImg = getLogoImg();
        bgImage = startBg.getCurrentImage();
        transparentBg.drawImage(bgImage, 0, 0);
    }
    
    private GreenfootImage getLogoImg(){
        //return current frame of logo animation
        if (acts % 3 == 0){
            return logoF1;
        }
        if (acts % 3 == 1){
            return logoF2;
        }
        if (acts % 3 == 2){
            return logoF3;
        }
        return logoF1;
    }
    
    private int randNum(int max){
        return Greenfoot.getRandomNumber(max);
    }
}
