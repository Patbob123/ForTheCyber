import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.LinkedList;
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
    private int enemyPerWave, acts;
    private HashMap<Integer, Enemy> enemyDict;
    private ArrayList<ArrayList<Enemy>> waves;
    private GreenfootImage enemyBg;

    /**
     * Constructor for Enemy World
     */
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
        displayEnemies(200);

        setBackground(enemyBg); 

    }
    /**
     * Act method
     */
    public void act(){
        super.act();
        acts++;
    }
    
    /**
     *  Generate a set of enemies for each wave
     *  
     *  @param difficulty       The stage of the battle
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
     * 
     * @param height         Height of the enemies
     */
    public void displayEnemies(int height){
        for(int i = 0; i < getStages().size(); i++){
            ArrayList<Enemy> wave = getStages().get(i);
            TextPlace waveNumber = TextPlace.initTextDisplay("Select Augment", getWidth()/6, height+i*125, 90, true);
            addObject(waveNumber, 0, 0);
            if(i == getStages().size()-1){
                waveNumber.setSentence("!BOSS");
            }else{
                waveNumber.setSentence("WAVE "+(i+1));
            }
            waveNumber.multiplyScale(3);
            
            LinkedList<Entity> enemies = new LinkedList<Entity>();
            for (Enemy e: wave){
                enemies.add(e);
            }   
            EnemyPreview enemyPreview = new EnemyPreview(enemies, 2);
            addObject(enemyPreview, getWidth()/3, height+10+i*125);
            enemyPreview.displayQueue();
        }
        
    }
    
    /**
     * Gets enemies in that stage
     * 
     * @param getStages        An arraylist that stores enemies in that stage
     * @return                 List of enemies
     */
    public ArrayList<ArrayList<Enemy>> getStages(){
        return waves;
    }
    
    /**
     * Adds enemy image to the world 
     * 
     * @param e                An enemy object 
     */
    public void showEnemyInfo(Enemy e){
        EnemyDisplay ed = new EnemyDisplay(e);
        addObject(ed, Constants.WORLD_WIDTH/2, Constants.WORLD_HEIGHT/2);
    }
    
    /**
     * Method to go to Builder World
     */
    public void goToBuilderWorld(){
        goToWorld(new BuilderWorld(getStages()));
    }
    
    /**
     * Lambdas functions for presser
     */
    public Function goBuilderWorld = () -> goToBuilderWorld();
}
