import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Pincer deals medium single target damage to one enemy
 * 
 * @author Vincent
 * <p>
 * Modified by: Jaiden
 * </p>
 * 
 * @version November 2023
 */
public class Pincer extends Attack
{
    /**
     * Constructor for Pincer
     */
    public Pincer(){
        name = "Pincer";
    }
    
    /**
     * Gets the entities of the attacker
     *
     * @param attacker            The one attacking
     * @param entireField         An array that holds entities 
     * @param side                The side the entities are on (enemy or main character)
     * 
     * @retruns A list of entities (one enemy inside)
     */
    public ArrayList<Entity> target(Entity attacker, Side[] entireField, int side){
        ArrayList<Entity> potentialTargets = entireField[1-side].getEntities();
        
        ArrayList<Entity> targets = new ArrayList<Entity>();
        targets.add(potentialTargets.get(Greenfoot.getRandomNumber(potentialTargets.size())));
        
        return targets;
    }
    
    /**
     * Attacks the selected entity
     * 
     * @param targets              An arraylist of the attackers targets
     * @param attacker             The one attacking
     * 
     * @returns A list of entities
     */
    public ArrayList<Entity> performMove(ArrayList<Entity> targets, Entity attacker){
        // Deal medium single target damage
        
        targets.get(0).takeDamage(attacker.getAttack()*3);
        attacker.meleeAttackAnimate(targets.get(0), "pincer");
        
        return targets;
    } 
}