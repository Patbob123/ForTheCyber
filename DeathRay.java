import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Death Ray does Massive DAMAGE to the first target and AOE damage all other targets, but at the cost of some self inflicted damage
 * 
 * @author Vincent
 * <p>
 * Modified by: Jaiden
 * </p>
 * 
 * @version November 2023
 */
public class DeathRay extends Attack
{
    private String projectileImageUrl;
    
    /**
     * Constructor for DeathRay
     */
    public DeathRay(){
        name = "DeathRay";
        projectileImageUrl = "attack/deathray.png";
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
        ((BattleWorld)attacker.getWorld()).getSM().playSound("deathRay");
        
        // Deal Massive damage first Target
        Entity firstTarget = targets.get(Greenfoot.getRandomNumber(targets.size()));
        firstTarget.takeDamage(attacker.getAttack()*2);
        
        // Deal AOE damage to all other targets
        for(Entity e: targets){
            if(e!=firstTarget){
                e.takeDamage(attacker.getAttack()/2);
            }
        }
        
        //Take Self Inflicted Damage for Using Death Ray
        attacker.takeDamage(attacker.getAttack()/3);
        attacker.rangeAttackAnimation(projectileImageUrl, firstTarget);
        return targets;
    } 
}
