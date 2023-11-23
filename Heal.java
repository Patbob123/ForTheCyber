import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Heal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heal extends Attack
{
    
    public ArrayList<Entity> target(Entity attacker, Side[] entireField, int side){
        return entireField[side].getEntities();
    }
    public ArrayList<Entity> performMove(ArrayList<Entity> targets, Entity attacker){
        Entity firstTarget = targets.get(Greenfoot.getRandomNumber(targets.size()));
        firstTarget.takeDamage(attacker.getAttack()/4);
        attacker.heal(attacker.getAttack());
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
