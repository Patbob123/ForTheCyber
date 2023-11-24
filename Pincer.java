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
        ((BattleWorld)attacker.getWorld()).getSM().playSound("pincer");
        
        Entity firstTarget = targets.get(Greenfoot.getRandomNumber(targets.size()));
        firstTarget.takeDamage(attacker.getAttack()*2);
        return targets;
    } 
   
    public void act()
    {
        // Add your action code here.
    }
}