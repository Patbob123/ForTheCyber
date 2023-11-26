import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * BoxJab stuns the target
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
    public BoxJab(){
        name ="BoxJab";
        critChance = 7;
    }
    public ArrayList<Entity> target(Entity attacker, Side[] entireField, int side){
        ArrayList<Entity> potentialTargets = entireField[1-side].getEntities();
        
        ArrayList<Entity> targets = new ArrayList<Entity>();
        targets.add(potentialTargets.get(Greenfoot.getRandomNumber(potentialTargets.size())));
        
        return targets;
    }
    public ArrayList<Entity> performMove(ArrayList<Entity> targets, Entity attacker){ 
        Entity firstTarget = targets.get(0);
        firstTarget.stun(true);
        if(checkIfCrit()){
            firstTarget.takeDamage(attacker.getAttack()*4); // 2x Damage
        }
        else{
            firstTarget.takeDamage(attacker.getAttack()*2);
        }
        attacker.meleeAttackAnimation(firstTarget, "boxJab");
        return targets;
    } 
}
