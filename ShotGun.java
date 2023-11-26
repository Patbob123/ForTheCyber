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
    public ShotGun(){
        name = "ShotGun";
        critChance = 3;
    }
    public ArrayList<Entity> target(Entity attacker, Side[] entireField, int side){
        ArrayList<Entity> potentialTargets = entireField[1-side].getEntities();
        
        ArrayList<Entity> targets = new ArrayList<Entity>();
        targets.add(potentialTargets.get(Greenfoot.getRandomNumber(potentialTargets.size())));
        
        return targets;
    }
    public ArrayList<Entity> performMove(ArrayList<Entity> targets, Entity attacker){
        ((BattleWorld)attacker.getWorld()).getSM().playSound("shotgun");
        
        Entity firstTarget = targets.get(0);
        
        //Check if ShotGun was a critical attack
        if(checkIfCrit()){
            firstTarget.takeDamage(attacker.getAttack()*6); // 6x Damage
        }
        else {
            firstTarget.takeDamage(attacker.getAttack());
        }
        return targets;
    } 
}
