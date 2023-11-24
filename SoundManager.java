import greenfoot.*;
import java.util.HashMap;
import java.util.Map;
import greenfoot.GreenfootSound;

/**
 * Write a description of class SoundManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SoundManager extends Actor
{
    
    HashMap<String, Sound> soundFiles = new HashMap<>();
    
    private GreenfootSound[] sounds;
    private int soundsIndex;
    //private Arr
    public SoundManager()
    {
        soundFiles.put("builderMusic", new Sound("builderMusic.mp3",100 ));
        //soundFiles.put("attack", new Sound("attack.wav",12 ));
        //soundFiles.put("takeDamage", new Sound("takeDamage.wav",12 ));
        //soundFiles.put("buttonPress", new Sound("buttonPress.wav",12 ));
        
        
        
        setImage(new GreenfootImage(1,1));
    }
    public void addedToWorld(World w){
        for(Map.Entry<String, Sound> set: soundFiles.entrySet()){
            set.getValue().setImage(new GreenfootImage(1,1));
            getWorld().addObject(set.getValue(), getX(), getY());
        }
    }
    public void playSound(String sound){
        soundFiles.get(sound).playSound();
    }
    public void playSoundLoop(String sound){
        soundFiles.get(sound).playSoundLoop();        
    }
    public void pauseSounds(){
        for(Map.Entry<String, Sound> set: soundFiles.entrySet()){
            set.getValue().pauseSoundLoop();
        }
    }
    public void resumeSounds(){
        for(Map.Entry<String, Sound> set: soundFiles.entrySet()){
            set.getValue().playSoundLoop();
        }
    }
    
}
