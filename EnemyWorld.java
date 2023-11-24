import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Enemies
 * 
 * Tier 1 Mobs
 * - Gunner 
 * - Melee 
 * - Buffer 
 * 
 * Tier 2 Mobs
 * - Juggernaut 
 * - Deathray 
 * - Skelecop 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyWorld extends SuperWorld
{
    private int enemyPerWave, acts, currActs;
    private boolean goingToBuilderWorld;
    private HashMap<Integer, Enemy> enemyDict;
    private ArrayList<ArrayList<Enemy>> waves;
    private GreenfootImage enemyBg;
    private Fader fade,fadeOut;

    public EnemyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT, 1);
        
        enemyDict = new HashMap<Integer, Enemy>(){{
            put(0,new Gunner());
            put(1,new Melee());
            put(2,new Sustainer());
            put(3,new Juggernaut());
            put(4,new Mech57());
            put(5,new SkeleCop());
            put(6, new Boss());
        }};

        waves = new ArrayList<ArrayList<Enemy>>();
        enemyPerWave = 6;
        generateEnemies(0);
        generateEnemies(1);
        generateEnemies(2);
        generateEnemies(3);
        
        Presser nextButton = new Presser(goBuilderWorld, "ready.png", "ready.png");
        addObject(nextButton, 800, 700);
        
        enemyBg = new GreenfootImage("enemyWaveText.png");
        enemyBg.scale(enemyBg.getWidth()*Constants.IMAGE_SCALING, enemyBg.getHeight()*Constants.IMAGE_SCALING);
        
        displayEnemies(getStages().get(0), 200);
        displayEnemies(getStages().get(1), 350);
        displayEnemies(getStages().get(2), 500);    
        displayEnemies(getStages().get(3), 650);
        setBackground(enemyBg); 
        
        fade = new Fader ((60*2), false); //60 acts = 1 second, so 4 seconds for fader
        fadeOut = new Fader ((60*2), true);
        
        goingToBuilderWorld = false;
        
        addObject(fade, Constants.WORLD_WIDTH/2, Constants.WORLD_HEIGHT/2);
    }
    public void act(){
        acts++;
        if(goingToBuilderWorld){
            currActs++;
            if (currActs >= fadeOut.getMaxDuration()){
                sm.stopSounds();
                goingToBuilderWorld = false;
                Greenfoot.setWorld(new BuilderWorld(getStages()));
            }
        }
    }
    public void generateEnemies(int difficulty){
        ArrayList <Enemy> waveEnemies = new ArrayList <Enemy>();
        int random;
        if (difficulty == 0){ // Tier 1 enemies
            
            for(int i = 0; i < enemyPerWave; i++){
                random = Greenfoot.getRandomNumber(3);
                waveEnemies.add(enemyDict.get(random));
            }

        } else if (difficulty == 1){ // Tier 2 enemies
            for(int i = 0; i < enemyPerWave; i++){
                random = Greenfoot.getRandomNumber(6);
                waveEnemies.add(enemyDict.get(random));
            }
        } else if (difficulty == 2){
            for(int i = 0; i < enemyPerWave; i++){
                random = Greenfoot.getRandomNumber(3);
                waveEnemies.add(enemyDict.get(random+3));
            }
        } else if (difficulty == 3){
           enemyPerWave = 1; 
           for(int i = 0; i < enemyPerWave; i++){
                waveEnemies.add(enemyDict.get(6));
            } 
        }
        waves.add(waveEnemies);
    }
    public ArrayList<ArrayList<Enemy>> getStages(){
        return waves;
    }
    public void goToBuilderWorld(){
        goingToBuilderWorld = true;
        sm.playSound("blip");
        addObject(fadeOut, Constants.WORLD_WIDTH/2, Constants.WORLD_HEIGHT/2);
    }
    public void displayEnemies(ArrayList<Enemy> wave, int height){
        for (int i = 0; i< wave.size(); i++){
            GreenfootImage img = wave.get(i).getPortrait();
            UI portrait = new UI(img,false);
            addObject(portrait, (i*50)+450, height);
        }   
    }

    public Function goBuilderWorld = () -> goToBuilderWorld();
}
