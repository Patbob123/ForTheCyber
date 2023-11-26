import greenfoot.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import greenfoot.GreenfootSound;

/**
 * Sound Manager is reponsible for storing and retreving all the sound files to allow modular and reusable code in other classes
 * 
 * @author Vincent
 * <p>
 * Modified by: Dawson
 * </p>
 * @version November 2023
 */
public class SoundManager extends Actor
{
    
    private HashMap<String, Sound> soundFiles = new HashMap<>();
    private ArrayList<Sound> playingSounds = new ArrayList<>();
    
    private GreenfootSound[] sounds;
    private int soundsIndex;
    public SoundManager()
    {
        //Store all sound files into a HashMap for easy retrevial 
        soundFiles.put("builderMusic", new Sound("builderMusic.mp3",50 ));
        soundFiles.put("Jaded", new Sound("Jaded.mp3",50 ));
        soundFiles.put("blast", new Sound("blaster.mp3",40 ));
        soundFiles.put("boom", new Sound("boom.mp3",60 ));
        soundFiles.put("bodySlam", new Sound("attacks/bodyslam.wav",75 ));
        soundFiles.put("deathRay", new Sound("attacks/deathray.wav",85 ));
        soundFiles.put("pincer", new Sound("attacks/pincer.wav",75 ));
        soundFiles.put("plasmaBeam", new Sound("attacks/plasmabeam.wav",85));
        soundFiles.put("boxJab", new Sound("attacks/boxjab.wav",75 ));
        soundFiles.put("shotgun", new Sound("attacks/shotgun.wav",75 ));
        soundFiles.put("heal", new Sound("attacks/heal.wav",75 ));
        soundFiles.put("transition", new Sound("transition.wav",100 ));
        soundFiles.put("click", new Sound("buttonclick.wav",100 ));
        soundFiles.put("hover", new Sound("buttonhover.wav",100 ));
        soundFiles.put("blip", new Sound("blip.wav",80));
        soundFiles.put("rain", new Sound("rainambient.mp3",50));
        soundFiles.put("electricshock", new Sound("lightsout.mp3",50));
        soundFiles.put("battlemusic", new Sound("battlemusic.mp3",33));
        soundFiles.put("bossmusic", new Sound("bossmusic.mp3",40));
        
        setImage(new GreenfootImage(1,1));
    }
    public void addedToWorld(World w){
        for(Map.Entry<String, Sound> set: soundFiles.entrySet()){
            set.getValue().setImage(new GreenfootImage(1,1));
            getWorld().addObject(set.getValue(), getX(), getY());
        }
    }
    
    // Methods to acess Sound Objects to play sounds
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
    public void fadeInSounds(){
        for(Map.Entry<String, Sound> set: soundFiles.entrySet()){
            set.getValue().soundFadeIn();
        }
    }
    public void fadeOutSounds(){
        for(Map.Entry<String, Sound> set: soundFiles.entrySet()){
            set.getValue().soundFadeOut();
        }
    }
    public void fadeIn(String sound){
        soundFiles.get(sound).soundFadeIn();
    }
    public void fadeOut(String sound){
        soundFiles.get(sound).soundFadeOut();
    }
    
}
