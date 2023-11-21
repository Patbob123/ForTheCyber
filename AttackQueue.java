import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
/**
* Write a description of class attackQueue here.
* 
* @author (your name) 
* @version (a version number or a date)
*/
public class AttackQueue extends Actor
{
    private Queue<Entity> entities;
    
    public AttackQueue(LinkedList<Entity> entities){
        this.entities = (Queue<Entity>)entities.clone();
        
        GreenfootImage queueImage = new GreenfootImage(500, 40);
        setImage(queueImage);
    }
    public void updateQueue(LinkedList<Entity> entities){
        this.entities = (Queue<Entity>)entities.clone();;
        displayQueue();
    }
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
