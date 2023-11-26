import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
/**
* Displays the generated attack queue, (created from BattleManager.class)
* 
* @author Dawson
* @version November 24, 2023
*/
public class AttackQueue extends Actor
{
    private Queue<Entity> entities;
    
    /**
     * Constructor for the AttackQueue
     */
    public AttackQueue(LinkedList<Entity> entities){
        this.entities = (Queue<Entity>)entities.clone();
        
        GreenfootImage queueImage = new GreenfootImage(500, 40);
        setImage(queueImage);
    }
    public void updateQueue(LinkedList<Entity> entities){
        this.entities = (Queue<Entity>)entities.clone();;
        displayQueue();
    }
    
    /**
     * Display the attack order at the top of the screen during battle
     */
    public void displayQueue(){
        getImage().clear();
        int i = 0;
        while(!entities.isEmpty()){
            GreenfootImage headImage = entities.poll().getPortrait();
            getImage().drawImage(headImage, i*40, 0);
            i++;
        }
    }
}
