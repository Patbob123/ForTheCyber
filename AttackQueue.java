import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
* Write a description of class attackQueue here.
* 
* @author (your name) 
* @version (a version number or a date)
*/
public class AttackQueue extends Actor
{
    private ArrayList<Entity> entities;
    
    public AttackQueue(ArrayList<Entity> entities){
        this.entities = entities;
        
        GreenfootImage queueImage = new GreenfootImage(400, 40);
        setImage(queueImage);
    }
    public void updateQueue(ArrayList<Entity> entities){
        this.entities = entities;
        displayQueue();
    }
    public void displayQueue(){
        for(int i = 0; i < entities.size(); i++){
            GreenfootImage headImage = entities.get(i).getPortrait();
            getImage().drawImage(headImage, i*40, 0);
        }
    }
}
