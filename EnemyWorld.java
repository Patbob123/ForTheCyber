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
    HashMap < Integer, Enemy> enemyDic = new HashMap<Integer, Enemy>();
    ArrayList <ArrayList <Enemy> > stages = new ArrayList <ArrayList <Enemy> >();
    public EnemyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        enemyDic.put(0,new Gunner());
        enemyDic.put(1,new Melee());
        enemyDic.put(2,new Sustainer());
        enemyDic.put(3,new Juggernaut());
        enemyDic.put(4,new Mech57());
        enemyDic.put(5,new SkeleCop());
    }
    
    public void generateEnemies(int Difficulty){
        ArrayList <Enemy> stageEnemies = new ArrayList <Enemy>();
        int random;
        if (Difficulty == 0){ // Tier 1 enemies
            int numOfHardEnemies = 2;
            
            for(int i = 0; i< 10; i++){
                random = Greenfoot.getRandomNumber(3);
                stageEnemies.add(enemyDic.get(random));
            }

        } else if (Difficulty == 1){ // Tier 2 enemies
            for(int i = 0; i< 10; i++){
                random = Greenfoot.getRandomNumber(3);
                stageEnemies.add(enemyDic.get(random+3));
            }
        }
        stages.add(stageEnemies);
    }
    
    public ArrayList <Enemy> getStage1 (){
        return stages.get(0); 
    }
    public ArrayList <Enemy> getStage2 (){
        return stages.get(1); 
    }
}
