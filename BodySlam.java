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
    public BodySlam(){
        name = "BodySlam";
    }
    public ArrayList<Entity> target(Entity attacker, Side[] entireField, int side){
        return entireField[1-side].getEntities();
    }
    public ArrayList<Entity> performMove(ArrayList<Entity> targets, Entity attacker){
        ((BattleWorld)attacker.getWorld()).getSM().playSound("bodySlam");
        
        Entity firstTarget = targets.get(Greenfoot.getRandomNumber(targets.size()));
        firstTarget.takeDamage(attacker.getAttack());
        for(Entity e: targets){
            if(e!=firstTarget){
                e.takeDamage(attacker.getAttack()/6);
            }
        }
        attacker.meleeAttackAnimation(firstTarget);
        return targets;
    } 
    public void act()
    {
        // Add your action code here.
    }
}
