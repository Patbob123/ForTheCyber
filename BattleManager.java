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
 * Battle Manger creates the order of turns for each entity, creates a textlog for TextManager.class and excutes each move
 * 
 * @author Dawson
 * @version November 24, 2023
 */
public class BattleManager extends Actor
{
    private ArrayList<Entity> entities;
    private Queue<Entity> attackList;
    private Side[] entireField;
    private double turnSpeed; 
    private int turnNumber; 
    private int trueTurnNumber;
    private int curAttackerIndex;
    private Entity curAttacker;
    
    private int initialWaitTime;
     
    private Slot originalAttackerSlot;
    
    /**
     * Constructor for BattleManger
     * 
     * @param entities             An arraylist that holds entities 
     * @param entireField          An array that keep tracks of both sides of the battle
     */
    public BattleManager(ArrayList<Entity> entities, Side[] entireField)
    {
        this.entities = entities;
        this.entireField = entireField;
        this.turnSpeed = 1;
        this.turnNumber = 0;
        this.trueTurnNumber = 1;
        this.curAttackerIndex = 0;
        this.attackList = new LinkedList<Entity>();
        
        this.initialWaitTime = 300;
        
        setImage(new GreenfootImage(1,1));
    }
    
    /**
     * Method to add the attack order to Battle World
     */
    public void addedToWorld(World w){
        createAttackOrder();
    }
    
    /**
     * Creates a queue that is ordered based on the speed of every entity on the battlefield. 
     * Order is calculated in a way to allow fast entities to attack multiple times before slow entities attack.
     * When the queue is almost finished or an entity, it refreshes a new queue. 
     */
    public void createAttackOrder(){
        Queue<Entity> tempAttackList = new LinkedList<Entity>();
        attackList = new LinkedList<Entity>();
        
        int entityIndex = 0;
        int setAttackListSize = 40; 
        
        if(this.attackList.size()!=0){
            for(int i = 0; i < setAttackListSize/4; i+=0){
                Entity e = attackList.poll();
                if(entities.contains(e)) {
                    i++;
                    tempAttackList.add(e);
                }else{
                    i--;
                }
            }
        }
        outerloop:
        while(tempAttackList.size() < setAttackListSize){
            trueTurnNumber++;
            for(int i = entities.size()-1; i >= 0; i--){
                if(trueTurnNumber%((int)(10-entities.get(i).getSpeed()/2))==0){
                    tempAttackList.add(entities.get(i));
                    if(tempAttackList.size() >= setAttackListSize){
                        break outerloop;
                    }
                }
            }
        }
        while(!tempAttackList.isEmpty()){
            attackList.add(tempAttackList.poll());
        }
        
        ((BattleWorld)getWorld()).getAttackQueue().updateQueue((LinkedList<Entity>)attackList);
    }
    
    /**
     * Main loop of the simulation. 
     * - Increments turn number.
     * - Selects an entity on the battle to perform their move.
     * - Updates the text log when a move is performed.
     */
    public void nextTurn(){
        
        turnNumber++;
        curAttacker = attackList.poll();
        originalAttackerSlot = curAttacker.getSlot();
        
        String augmentMessage = "";
        if(curAttacker.getAugment()!=null) {
            augmentMessage+=curAttacker.getAugment().activateOwnerTurn()+" /n ";
        }
        
        Attack move = curAttacker.pickRandomMove();
        String logMessage = "@Turn: @"+turnNumber;
        
        // Check if the entity is stunned, if so skip their turn     
        if(curAttacker.getStunned()){
            curAttacker.stun(false);
            logMessage += " /n !"+curAttacker+" was STUNNED ";
        }
        else{
            ArrayList<Entity> allTargets = curAttacker.attack(move, entireField);
            logMessage += " /n !"+curAttacker+" performed @"+ move.getName()+" on: ";
            for(int i = 0; i < allTargets.size(); i++){
                logMessage += "!"+allTargets.get(i)+" ";
                
                // If target dies, recalculate the attack order
                if(allTargets.get(i).isDead()){
                    
                    if(curAttacker.getAugment()!=null && Greenfoot.getRandomNumber(10) < 5) {
                        augmentMessage+=curAttacker.getAugment().activateLevelUp()+" /n ";
                    }
                    
                    entities.remove(allTargets.get(i));
                    allTargets.get(i).removeFromWorld();
                    logMessage+= allTargets.get(i)+" !died ";
                    entireField[1-curAttacker.getSide()].getEntities().remove(allTargets.get(i));
                    createAttackOrder();
                    
                }
            }
        }
        
        //Update the battle log with what happened
        ((BattleWorld)getWorld()).getTM().addSentence(logMessage);
        
        if(attackList.size() < 20){
            createAttackOrder();
        }
        ((BattleWorld)getWorld()).getAttackQueue().updateQueue((LinkedList<Entity>)attackList);
        curAttackerIndex++;
        if(curAttackerIndex >= attackList.size()){
            curAttackerIndex = 0;
        }
    }
    
    /**
     * Act method
     */
    public void act(){
        if(initialWaitTime < 0){
            if(entireField[0].getEntities().size()==0){
                ((SuperWorld)getWorld()).goToWorld(new LoseWorld());
                getWorld().removeObject(this);
                return;
            }
            if(entireField[1].getEntities().size()==0){
                ((BattleWorld)getWorld()).setupField();
                getWorld().removeObject(this);
            }
            if(curAttacker.isAttackFinished()){
                curAttacker.initToSlot(originalAttackerSlot);
                nextTurn();
            }
        }
        
        if(initialWaitTime == 300){
            ((BattleWorld)getWorld()).getTM().addSentence("BATTLE START");
            getWorld().addObject(new NextWave(), getWorld().getWidth()/2, getWorld().getHeight()/2);
        }
        
        if(initialWaitTime > 0){
            initialWaitTime--;
        }else if(initialWaitTime == 0){
            nextTurn();
            initialWaitTime--;
        }
    }
}
