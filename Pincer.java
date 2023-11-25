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
        ArrayList<Entity> potentialTargets = entireField[1-side].getEntities();
        
        ArrayList<Entity> targets = new ArrayList<Entity>();
        targets.add(potentialTargets.get(Greenfoot.getRandomNumber(potentialTargets.size())));
        
        return targets;
    }
    public ArrayList<Entity> performMove(ArrayList<Entity> targets, Entity attacker){
        ((BattleWorld)attacker.getWorld()).getSM().playSound("pincer");
        
        targets.get(0).takeDamage(attacker.getAttack()*3);
        attacker.meleeAttackAnimation(targets.get(0));
        
        return targets;
    } 
   
    public void act()
    {
        // Add your action code here.
    }
}