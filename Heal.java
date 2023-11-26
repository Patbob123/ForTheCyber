import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Heal the attacker for a large amount and all other allies for a small amount
 * 
 * @author Vincent
 * <p>
 * Modified by: Jaiden
 * </p>
 * 
 * @version November 2023
 */
public class Heal extends Attack
{
    /**
     * Constructor for Heal
     */
    public Heal(){
        name = "Heal";
    }
    
    /**
     * Gets the entities of the attacker
     *
     * @param attacker            The one attacking
     * @param entireField         An array that holds entities 
     * @param side                The side the entities are on (enemy or main character)
     * 
     * @return A list of entities
     */
    public ArrayList<Entity> target(Entity attacker, Side[] entireField, int side){
        return entireField[side].getEntities();
    }
    
    /**
     * Attacks the selected enemies
     * 
     * @param targets              An arraylist of the attackers targets
     * @param attacker             The one attacking
     * 
     * @returns A list of entities
     */
    public ArrayList<Entity> performMove(ArrayList<Entity> targets, Entity attacker){
        ((BattleWorld)attacker.getWorld()).getSM().playSound("heal");
        
        // Heal the main user for a large amount
        attacker.heal(attacker.getAttack());
        
        // Heal all other allies for a small amount
        for(Entity e: targets){
            if(e!=attacker){
                e.heal(attacker.getAttack()/6);
            }
        }
        return targets;
    } 
}
