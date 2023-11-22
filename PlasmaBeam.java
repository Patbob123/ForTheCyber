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
    /*
    public PlasmaBeam (Entity attacker){
        super(attacker);
        moveDamage = calculateDamage();
    }
    */
    public PlasmaBeam(){
        name = "PlasmaBeam";
    }
    public double calculateDamage(Entity attacker){
        return baseDamage+(attacker.getAttack()*AD_ratio);
    }
    /*
    public void updateMove(){
        moveDamage = calculateDamage();
    }
    */
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
}
