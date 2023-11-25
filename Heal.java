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
    public Heal(){
        name = "Heal";
    }
    public ArrayList<Entity> target(Entity attacker, Side[] entireField, int side){
        return entireField[side].getEntities();
    }
    public ArrayList<Entity> performMove(ArrayList<Entity> targets, Entity attacker){
        ((BattleWorld)attacker.getWorld()).getSM().playSound("heal");
        
        attacker.heal(attacker.getAttack());
        //Entity firstTarget = targets.get(Greenfoot.getRandomNumber(targets.size()));
        //firstTarget.takeDamage(attacker.getAttack()/2);
        for(Entity e: targets){
            if(e!=attacker){
                e.heal(attacker.getAttack()/6);
            }
        }
        return targets;
    } 
    
    public void act()
    {
            // Add your action code here.
    }
}
