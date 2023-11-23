import greenfoot.GreenfootSound;

/**
 * Write a description of class Sound here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sound  
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
         sounds[0].playLoop();
    }
    public void pauseSoundLoop(String sound){
        sounds[0].pause();
    }
    public void stopSoundLoop(String sound){
        sounds[0].stop();
    }
    public int getSoundIndex(){
        return soundIndex;
    }
}
