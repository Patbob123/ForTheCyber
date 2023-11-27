import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * BoxJab is a single target attack that can stun, with a chance to deal bonus damage
 * 
 * @author Vincent
 * <p>
 * Modified by: Jaiden
 * </p>
 * 
 * @version November 2023
 */
public class BoxJab extends Attack
{
    /**
     * Constructor for BoxJab
     */
    public BoxJab(){
        name ="BoxJab";
        critChance = 7;
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
        Entity firstTarget = targets.get(0);
        
        //Stun the Enemy
        firstTarget.stun(true);
        
        // Check if it was a critical attack
        if(checkIfCrit()){
            firstTarget.takeDamage(attacker.getAttack()*4); // 2x Damage
        }
        else{
            firstTarget.takeDamage(attacker.getAttack()*2);
        }
        attacker.meleeAttackAnimate(firstTarget, "boxJab");
        return targets;
    } 
}
