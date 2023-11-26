import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Attack super class that stores the abstract methods for all subclasses of attack
 * 
 * @author Vincent
 * <p>
 * Modified by: Jaiden, Dawson
 * </p>
 * 
 * @version November 2023
 */
public abstract class Attack extends SuperSmoothMover
{
    Entity attacker;
    Entity target;
    
    //Grab the entity's stats for damage ratios
    protected double AD;
    protected double HP;
    protected double DEF;
    protected double SPD;
    protected int duration = 120;
    protected String name;
    protected int critChance;
    
    /**
     * Constructor for Attack
     */
    public Attack (){
        
    }
    /**
     * Action when attack is perform
     * 
     * @param targets     An arraylist for attackers targets
     * @param attacker    The attacker
     */
    public abstract ArrayList<Entity> performMove(ArrayList<Entity> targets, Entity attacker); 
    
    /**
     * Targeting system for the attack
     * 
     * @param attacker          The attacker
     * @param entireField       An array that holds the sides the entities are on
     * @param side              The side the entity is on
     */
    public abstract ArrayList<Entity> target(Entity attacker, Side[] entireField, int side);  
    
    /**
     * Check if attack was a critical hit or not
     */
    public boolean checkIfCrit(){
        int luck = Greenfoot.getRandomNumber(10);
        if(critChance >= luck){
            return true;
        }
        return false;
    }   
    
    /**
     * Method to get duration
     * 
     * @return duration
     */
    public int getDuration(){
        return duration;
    }
    
    /**
     * Method to get name
     * 
     * @return name
     */
    public String getName(){
        return name;
    }
}
