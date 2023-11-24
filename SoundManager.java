import java.util.HashMap;
import greenfoot.GreenfootSound;

/**
 * Write a description of class SoundManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SoundManager  
{
    
    HashMap<String, Sound> soundFiles = new HashMap<>();
    private GreenfootSound backgroundMusic;
    private GreenfootSound attack;
    private GreenfootSound takeDamage;
    private GreenfootSound buttonPress;
    
    private GreenfootSound[] sounds;
    private int soundsIndex;
    //private Arr
    public SoundManager()
    {
        soundFiles.put("backgroundMusic", new Sound("backgroundMusic.mp3",12 ));
        soundFiles.put("attack", new Sound("attack.wav",12 ));
        soundFiles.put("takeDamage", new Sound("takeDamage.wav",12 ));
        soundFiles.put("buttonPress", new Sound("buttonPress.wav",12 ));
    }
    public void playSound(String sound){
        soundFiles.get(sound).playSound();        
    }
    public void playSoundLoop(String sound){
        soundFiles.get(sound).playSoundLoop();        
    }
    public void pauseLoop(String sound){
        soundFiles.get(sound).pauseSoundLoop();
    }
}
