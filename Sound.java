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
    private int defaultVolume;
    private int volume;
    private int fadeIn; //0 = none, 1 = fade in, 2 = fade out
    /**
     * Constructor for objects of class Sound
     */
    public Sound(String soundFile, int defaultVolume)
    {
        this.defaultVolume = defaultVolume;
        volume = defaultVolume;
        soundIndex = 0;
        sounds = new GreenfootSound[20];
        for(int i = 0; i < sounds.length; i++){
            sounds[i] = new GreenfootSound(soundFile);
            sounds[i].setVolume(defaultVolume);
        }
    }
    public void playSound(){
        
        sounds[soundIndex].play();
        if(soundIndex >= sounds.length-1){
            soundIndex = 0;
        } else {
            soundIndex++;    
        }
    }
    public void playSoundLoop(){
         sounds[soundIndex].playLoop();
    }
    public void soundFadeIn(){
        this.fadeIn = 1;
        volume = 0;
        sounds[soundIndex].setVolume(volume);
    }
    public void soundFadeOut(){
        this.fadeIn = 2;
        volume = defaultVolume;
        sounds[soundIndex].setVolume(volume);
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
    public boolean isPlaying(){
        return sounds[soundIndex].isPlaying();
    }
    public void act(){
        if(fadeIn == 1){
            if(volume < defaultVolume){
                volume++;
            }
        }else if(fadeIn == 2){
            if(volume > 0){
                volume--;
            }
        }
        sounds[soundIndex].setVolume(volume);

    }

}
