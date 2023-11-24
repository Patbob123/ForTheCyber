import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class PlasmaMissile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlasmaBeam extends Attack
{
    private double baseDamage;
    private double AD_ratio = 1.0;
    private double moveDamage;
    
    public PlasmaBeam(){
        name = "PlasmaBeam";
    }
    public double calculateDamage(Entity attacker){
        return baseDamage+(attacker.getAttack()*AD_ratio);
    }
    public ArrayList<Entity> target(Entity attacker, Side[] entireField, int side){
        return entireField[1-side].getEntities();
    }
    public ArrayList<Entity> performMove(ArrayList<Entity> targets, Entity attacker){
        ((BattleWorld)attacker.getWorld()).getSM().playSound("plasmaBeam");
        
        for(Entity e: targets){
            e.takeDamage(attacker.getAttack());
        }
        return targets;
    } 
}
