import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Pincer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pincer extends Attack
{
    public Pincer(){
        name = "Pincer";
    }
    public ArrayList<Entity> target(Entity attacker, Side[] entireField, int side){
        return entireField[1-side].getEntities();
    }
    public ArrayList<Entity> performMove(ArrayList<Entity> targets, Entity attacker){
        Entity firstTarget = targets.get(Greenfoot.getRandomNumber(targets.size()));
        firstTarget.takeDamage(attacker.getAttack());
        for(Entity e: targets){
            if(e!=firstTarget){
                e.takeDamage(attacker.getAttack()/6);
            }
        }
        return targets;
    } 
   
    public void act()
    {
        // Add your action code here.
    }
}
