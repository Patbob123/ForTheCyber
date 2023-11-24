import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class ShotGun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShotGun extends Attack
{
    
    public ShotGun(){
        name = "ShotGun";
        critChance = 5;
    }
    public ArrayList<Entity> target(Entity attacker, Side[] entireField, int side){
        return entireField[1-side].getEntities();
    }
    public ArrayList<Entity> performMove(ArrayList<Entity> targets, Entity attacker){
        ((BattleWorld)attacker.getWorld()).getSM().playSound("shotgun");
        
        Entity firstTarget = targets.get(Greenfoot.getRandomNumber(targets.size()));
        if(checkIfCrit()){
            firstTarget.takeDamage(attacker.getAttack()*6); // 2x Damage
        }
        else {
            firstTarget.takeDamage(attacker.getAttack()*3);
        }
        return targets;
    } 
}
