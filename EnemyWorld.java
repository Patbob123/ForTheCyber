import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
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
    private int enemyPerStage;
    private HashMap<Integer, Enemy> enemyDict;
    private ArrayList<ArrayList<Enemy>> stages;
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
        }};

        stages = new ArrayList<ArrayList<Enemy>>();
        enemyPerStage = 10;
        generateEnemies(0);
        generateEnemies(1);
        
        Presser nextButton = new Presser(goBuilderWorld, "ready.png", "ready.png");
        addObject(nextButton, 500, 700);
    }
    public void generateEnemies(int difficulty){
        ArrayList <Enemy> stageEnemies = new ArrayList <Enemy>();
        int random;
        if (difficulty == 0){ // Tier 1 enemies
            int numOfHardEnemies = 2;
            
            for(int i = 0; i < enemyPerStage; i++){
                random = Greenfoot.getRandomNumber(3);
                stageEnemies.add(enemyDict.get(random));
            }

        } else if (difficulty == 1){ // Tier 2 enemies
            for(int i = 0; i < enemyPerStage; i++){
                
                random = Greenfoot.getRandomNumber(3);
                stageEnemies.add(enemyDict.get(random+3));
              
            }
        }
        stages.add(stageEnemies);
    }
    public ArrayList<ArrayList<Enemy>> getStages(){
        return stages;
    }
    public void goToBuilderWorld(){
        Greenfoot.setWorld(new BuilderWorld(getStages()));
    }

    
    public Function goBuilderWorld = () -> goToBuilderWorld();
}
