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
public class EnemyWorld extends World
{
    private int enemyPerWave;
    private HashMap<Integer, Enemy> enemyDict;
    private ArrayList<ArrayList<Enemy>> waves;
    private GreenfootImage title;

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
        enemyPerWave = 10;
        generateEnemies(0);
        generateEnemies(1);
        generateEnemies(2);
        generateEnemies(3);
        
        Presser nextButton = new Presser(goBuilderWorld, "ready.png", "ready.png");
        addObject(nextButton, 800, 700);
        
        title = new GreenfootImage("enemyWaveText.png");
        displayEnemies(getStages().get(0), 200);
        displayEnemies(getStages().get(1), 350);
        displayEnemies(getStages().get(2), 500);    
        displayEnemies(getStages().get(3), 650);
        setBackground(title); 
        
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
        Greenfoot.setWorld(new BuilderWorld(getStages()));
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
