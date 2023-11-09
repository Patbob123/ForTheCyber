import greenfoot.*;
import java.util.ArrayList;

/**
 * Write a description of class BattleManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BattleManager extends Actor
{
    private ArrayList<Entity> entities;
    private Side[] entireField;
    private double turnSpeed; //multiplier
    private int turnNumber; 
    private int curAttackerIndex;
    private Entity curAttacker;
    
    private Slot originalAttackerSlot;
    public BattleManager(ArrayList<Entity> entities, Side[] entireField)
    {
        this.entities = entities;
        this.entireField = entireField;
        this.turnSpeed = 1;
        this.turnNumber = 0;
        this.curAttackerIndex = 0;
        
        setImage(new GreenfootImage(1,1));
    }
    public void nextTurn(){
        turnNumber++;
        System.out.println("Turn: "+turnNumber);
        curAttacker = entities.get(curAttackerIndex);
        originalAttackerSlot = curAttacker.getSlot();
        
        Side targetSide = entireField[1-curAttacker.getSide()];
        Entity target = targetSide.getRandomEntity();
        
        curAttacker.attack(target);
        
        
        //if(target.isDead()) entities.remove(target);
        curAttackerIndex++;
        if(curAttackerIndex >= entities.size()){
            curAttackerIndex = 0;
        }
    }
    public void act(){
        //System.out.println(curAttacker);
        if(entireField[0].getEntities().size()==0||entireField[0].getEntities().size()==0){
            System.out.println("BATTLE ENDED");
            getWorld().removeObject(this);
        }
        if(curAttacker.isAttackFinished()){
            curAttacker.initToSlot(originalAttackerSlot);
            nextTurn();
        }
    }
}
