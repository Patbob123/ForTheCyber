import greenfoot.*;
/**
 * Write a description of class Sound here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sound extends Actor
{
    private int soundIndex;
    private GreenfootSound[] sounds;
    /**
     * Constructor for objects of class Sound
     */
    public Sound(String soundFile, int volume)
    {
        soundIndex = 0;
        sounds = new GreenfootSound[20];
        for(int i = 0; i < sounds.length; i++){
            sounds[i] = new GreenfootSound(soundFile);
            sounds[i].setVolume(volume);
        }
    }
    public void playSound(){
        sounds[soundIndex].play();
        if(soundIndex > sounds.length-1){
            soundIndex = 0;
        } else {
            soundIndex++;    
        }
    }
    public void playSoundLoop(){
         sounds[soundIndex].playLoop();
    }
    public void pauseSoundLoop(){
        sounds[soundIndex].pause();
    }
    public void stopSoundLoop(){
        sounds[soundIndex].stop();
    }

    public int getSoundIndex(){
        return soundIndex;
    }
}
