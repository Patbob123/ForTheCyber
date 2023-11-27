import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Body slam big damage to the primary target, and aoe damage to all other targets 
 * 
 * @author Vincent
 * <p>
 * Modified by: Jaiden
 * </p>
 * 
 * @version November 2023
 */
public class BodySlam extends Attack
{
    /**
     * Constructor for BodySlam
     */
    public BodySlam(){
        name = "BodySlam";
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
        return entireField[1-side].getEntities();
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
        Entity firstTarget = targets.get(Greenfoot.getRandomNumber(targets.size()));
        
        // Deal Full Damage to the Primary Target
        double scaledDamage = attacker.getAttack()*((attacker.getHp()/attacker.getMaxHp())*3);
        firstTarget.takeDamage(scaledDamage);
        
        //Deal Less Damage to all other targets
        for(Entity e: targets){
            if(e!=firstTarget){
                e.takeDamage(scaledDamage/3);
            }
        }
        attacker.meleeAttackAnimate(firstTarget, "bodySlam");
        return targets;
    } 
}
