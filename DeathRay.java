import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class DeathRay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DeathRay extends Attack
{
    private String projectileImageUrl;
    
    public DeathRay(){
        name = "DeathRay";
        projectileImageUrl = "attack/deathray.png";
    }
    public ArrayList<Entity> target(Entity attacker, Side[] entireField, int side){
        return entireField[1-side].getEntities();
    }
    public ArrayList<Entity> performMove(ArrayList<Entity> targets, Entity attacker){
        ((BattleWorld)attacker.getWorld()).getSM().playSound("deathRay");
        
        Entity firstTarget = targets.get(Greenfoot.getRandomNumber(targets.size()));
        firstTarget.takeDamage(attacker.getAttack()*2);
        for(Entity e: targets){
            if(e!=firstTarget){
                e.takeDamage(attacker.getAttack()/2);
            }
        }
        attacker.takeDamage(attacker.getAttack()/3);
        attacker.rangeAttackAnimation(projectileImageUrl, firstTarget);
        return targets;
    } 
    public void act()
    {
        // Add your action code here.
    }
}
