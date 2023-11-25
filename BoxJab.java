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
        return entireField[1-side].getEntities();
    }
    public ArrayList<Entity> performMove(ArrayList<Entity> targets, Entity attacker){
        ((BattleWorld)attacker.getWorld()).getSM().playSound("boxJab");
        
        Entity firstTarget = targets.get(Greenfoot.getRandomNumber(targets.size()));
        
        if(checkIfCrit()){
            firstTarget.takeDamage(attacker.getAttack()*4); // 2x Damage
        }
        else{
            firstTarget.takeDamage(attacker.getAttack()*3);
        }
        attacker.meleeAttackAnimation(firstTarget);
        return targets;
    } 
}
