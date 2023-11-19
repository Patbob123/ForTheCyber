import greenfoot.*;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * Write a description of class BattleManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BattleManager extends Actor
{
    private ArrayList<Entity> entities;
    private Queue<Entity> attackList;
    private Side[] entireField;
    private double turnSpeed; //multiplier
    private int turnNumber; 
    private int trueTurnNumber;
    private int curAttackerIndex;
    private Entity curAttacker;
    
     
    private Slot originalAttackerSlot;
    public BattleManager(ArrayList<Entity> entities, Side[] entireField)
    {
        this.entities = entities;
        this.entireField = entireField;
        this.turnSpeed = 1;
        this.turnNumber = 0;
        this.trueTurnNumber = 0;
        this.curAttackerIndex = 0;
        
        createAttackOrder();
        
        setImage(new GreenfootImage(1,1));
    }
    public void createAttackOrder(){
        attackList = new LinkedList<Entity>();
        int entityIndex = 0;
        int setAttackListSize = 20;
        outerloop:
        while(attackList.size() < setAttackListSize){
            trueTurnNumber++;
            for(int i = entities.size()-1; i >= 0; i--){
                if(trueTurnNumber%entities.get(i).getSpeed()==0){
                    attackList.add(entities.get(i));
                    if(attackList.size() >= setAttackListSize) break outerloop;
                }
            }
        }
    }
    public void nextTurn(){
       
        turnNumber++;
        curAttacker = attackList.poll();
        originalAttackerSlot = curAttacker.getSlot();
        
        Side targetSide = entireField[1-curAttacker.getSide()];
        Entity target = targetSide.getRandomEntity();
        System.out.println(targetSide.getEntities());
        curAttacker.attack(target);
        
        ((BattleWorld)getWorld()).getTM().addSentence(
            "@Turn: @"+turnNumber+" /n "+curAttacker + " !attacked " + target);
        
        if(target.isDead()){
            entireField[1-curAttacker.getSide()].getEntities().remove(target);
            entities.remove(target);
            target.removeFromWorld();
            createAttackOrder();
        }
        
        curAttackerIndex++;
        if(curAttackerIndex >= attackList.size()){
            curAttackerIndex = 0;
        }
    }
    public void act(){
        if(entireField[0].getEntities().size()==0||entireField[1].getEntities().size()==0){
            System.out.println("BATTLE ENDED");
            getWorld().removeObject(this);
        }
        if(curAttacker.isAttackFinished()){
            curAttacker.initToSlot(originalAttackerSlot);
            nextTurn();
        }
    }
}
