import greenfoot.*;
import java.util.ArrayList;
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
    
    private HashMap<String, Sound> soundFiles = new HashMap<>();
    private ArrayList<Sound> playingSounds = new ArrayList<>();
    
    private GreenfootSound[] sounds;
    private int soundsIndex;
    //private Arr
    public SoundManager()
    {
        soundFiles.put("builderMusic", new Sound("builderMusic.mp3",50 ));
        soundFiles.put("Jaded", new Sound("Jaded.mp3",50 ));
        //soundFiles.put("attack", new Sound("attack.wav",12 ));
        //soundFiles.put("takeDamage", new Sound("takeDamage.wav",12 ));
        //soundFiles.put("buttonPress", new Sound("buttonPress.wav",12 ));
        //soundFiles.put("buttonPress", new Sound("buttonclick.mp3",12 ));
        soundFiles.put("blast", new Sound("blaster.mp3",50 ));
        soundFiles.put("boom", new Sound("boom.mp3",60 ));
        soundFiles.put("bodySlam", new Sound("attacks/bodyslam.wav",100 ));
        soundFiles.put("deathRay", new Sound("attacks/deathray.wav",100 ));
        soundFiles.put("pincer", new Sound("attacks/pincer.wav",100 ));
        soundFiles.put("plasmaBeam", new Sound("attacks/plasmabeam.wav",100));
        soundFiles.put("boxJab", new Sound("attacks/boxjab.wav",100 ));
        soundFiles.put("shotgun", new Sound("attacks/shotgun.wav",100 ));
        soundFiles.put("heal", new Sound("attacks/heal.wav",100 ));
        soundFiles.put("click", new Sound("buttonclick.wav",100 ));
        soundFiles.put("hover", new Sound("buttonhover.wav",100 ));
        soundFiles.put("blip", new Sound("blip.wav",80));
        soundFiles.put("rain", new Sound("rainambient.mp3",50));
        
        
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
            if(set.getValue().isPlaying()){
                playingSounds.add(set.getValue());
                set.getValue().pauseSoundLoop();
            }
            
        }
        
    }
    public void resumeSounds(){
        
        for(int i = 0; i < playingSounds.size(); i++){
            playingSounds.get(i).playSoundLoop();
        }
        playingSounds.clear();
    }
    public void stopSounds(){
        for(Map.Entry<String, Sound> set: soundFiles.entrySet()){
            set.getValue().stopSoundLoop();
        }
    }
    public void fadeIn(String sound){
        soundFiles.get(sound).soundFadeIn();
    }
    public void fadeOut(String sound){
        soundFiles.get(sound).soundFadeOut();
    }
    
}
