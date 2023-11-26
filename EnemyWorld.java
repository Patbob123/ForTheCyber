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
 * THE THIRD WORLD: Generates and displays the Enemy Lineup for each simulation 
 * 
 * @author Vincent Li
 * @version November, 24, 2023
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
        super(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT, 1);
        
        // Dictonary of all the Enemies 
        enemyDict = new HashMap<Integer, Enemy>(){{
            put(0,new Gunner());
            put(1,new Melee());
            put(2,new Sustainer());
            put(3,new Juggernaut());
            put(4,new Mech57());
            put(5,new SkeleCop());
            put(6, new Boss());
        }};
        
        // Generate the enemy lineup when world is generated
        waves = new ArrayList<ArrayList<Enemy>>();
        enemyPerWave = 6;
        generateEnemies(0);
        generateEnemies(1);
        generateEnemies(2);
        generateEnemies(3);
        
        Presser nextButton = new Presser(goBuilderWorld, "ready.png", "ready.png");
        addObject(nextButton, 800, 700);
        
        enemyBg = new GreenfootImage("enemyBg.png");
        enemyBg.scale(enemyBg.getWidth()*Constants.IMAGE_SCALING, enemyBg.getHeight()*Constants.IMAGE_SCALING);
        
        // Display the enemy icons
        displayEnemies(getStages().get(0), 200);
        displayEnemies(getStages().get(1), 350);
        displayEnemies(getStages().get(2), 500);    
        displayEnemies(getStages().get(3), 650);
        setBackground(enemyBg); 
        
        fade = new Fader ((60*2), false); 
        fadeOut = new Fader ((60*2), true);
        
        goingToBuilderWorld = false;
        
        addObject(fade, Constants.WORLD_WIDTH/2, Constants.WORLD_HEIGHT/2);
    }
    public void act(){
        super.act();
        acts++;
        
        if(goingToBuilderWorld){
            currActs++;
            if (currActs >= fadeOut.getMaxDuration()){
                goToWorld(new BuilderWorld(getStages()));
                return;
            }
        }
    }
    
    /**
     *  Generate a set of enemies for each wave
     */
    public void generateEnemies(int difficulty){
        ArrayList <Enemy> waveEnemies = new ArrayList <Enemy>();
        int random;
        if (difficulty == 0){ // Tier 1 enemies
            
            for(int i = 0; i < enemyPerWave; i++){
                random = Greenfoot.getRandomNumber(3);
                waveEnemies.add(enemyDict.get(random));
            }

        } else if (difficulty == 1){ // Tier 1 and Tier 2 enemies
            for(int i = 0; i < enemyPerWave; i++){
                random = Greenfoot.getRandomNumber(6);
                waveEnemies.add(enemyDict.get(random));
            }
        } else if (difficulty == 2){ // Tier 2 enemies
            for(int i = 0; i < enemyPerWave; i++){
                random = Greenfoot.getRandomNumber(3);
                waveEnemies.add(enemyDict.get(random+3));
            }
        } else if (difficulty == 3){ // Boss
           enemyPerWave = 1; 
           for(int i = 0; i < enemyPerWave; i++){
                waveEnemies.add(enemyDict.get(6));
            } 
        }
        waves.add(waveEnemies);
    }
    
    /**
     * Displays the enemy lineup the user will face
     */
    public void displayEnemies(ArrayList<Enemy> wave, int height){
        for (int i = 0; i< wave.size(); i++){
            GreenfootImage img = wave.get(i).getPortrait();
            UI portrait = new UI(img,false);
            addObject(portrait, (i*50)+450, height);
        }   
    }
    
    public ArrayList<ArrayList<Enemy>> getStages(){
        return waves;
    }
    public void goToBuilderWorld(){
        goingToBuilderWorld = true;
        sm.playSound("blip");
        addObject(fadeOut, Constants.WORLD_WIDTH/2, Constants.WORLD_HEIGHT/2);
    }
    
    

    public Function goBuilderWorld = () -> goToBuilderWorld();
}
