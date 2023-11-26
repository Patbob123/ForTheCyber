import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Pincer deals medium single target damage to one enemy
 * 
 * @author Vincent
 * <p>
 * Modified by: Jaiden
 * </p>
 * 
 * @version November 2023
 */
public class Pincer extends Attack
{
    public Pincer(){
        name = "Pincer";
    }
    public ArrayList<Entity> target(Entity attacker, Side[] entireField, int side){
        ArrayList<Entity> potentialTargets = entireField[1-side].getEntities();
        
        ArrayList<Entity> targets = new ArrayList<Entity>();
        targets.add(potentialTargets.get(Greenfoot.getRandomNumber(potentialTargets.size())));
        
        return targets;
    }
    public ArrayList<Entity> performMove(ArrayList<Entity> targets, Entity attacker){
        // Deal medium single target damage
        
        targets.get(0).takeDamage(attacker.getAttack()*3);
        attacker.meleeAttackAnimation(targets.get(0), "pincer");
        
        return targets;
    } 
}