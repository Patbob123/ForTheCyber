import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * ShotGun is a single target attack that does MASSIVE DAMAGE if it is a critcal strike, otherwise deal medium damage
 * 
 * @author Vincent
 * <p>
 * Modified by: Jaiden
 * </p>
 * 
 * @version November 2023
 */
public class ShotGun extends Attack
{
    private String projectileImageUrl;
    
    /**
     * Constructor for ShotGun
     */
    public ShotGun(){
        name = "ShotGun";
        projectileImageUrl = "attack/shotgun.png";
        critChance = 2;
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
        ((BattleWorld)attacker.getWorld()).getSM().playSound("shotgun");
        
        for(Entity e: targets){
            if(checkIfCrit()){
                e.takeDamage(attacker.getAttack()*5); // 5x Damage
            }
            else {
                e.takeDamage(attacker.getAttack());
            }
            attacker.rangeAttackAnimation(projectileImageUrl, e);
        }
        
        //Check if ShotGun was a critical attack
        
        return targets;
    } 
}
