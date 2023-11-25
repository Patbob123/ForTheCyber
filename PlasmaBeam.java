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
    private String projectileImageUrl;
    public PlasmaBeam(){
        name = "PlasmaBeam";
        projectileImageUrl = "attack/laserbeam.png";
    }
    public double calculateDamage(Entity attacker){
        return baseDamage+(attacker.getAttack()*AD_ratio);
    }
    public ArrayList<Entity> target(Entity attacker, Side[] entireField, int side){
        ArrayList<Entity> potentialTargets = entireField[1-side].getEntities();
        
        ArrayList<Entity> targets = new ArrayList<Entity>();
        Entity firstTarget = potentialTargets.get(Greenfoot.getRandomNumber(potentialTargets.size()));
        targets.add(firstTarget);
        potentialTargets.remove(firstTarget);
        
        Entity secondTarget = potentialTargets.get(Greenfoot.getRandomNumber(potentialTargets.size()));
        targets.add(secondTarget);
        potentialTargets.remove(secondTarget);
        
        return targets;
    }
    public ArrayList<Entity> performMove(ArrayList<Entity> targets, Entity attacker){
        ((BattleWorld)attacker.getWorld()).getSM().playSound("plasmaBeam");
        
        for(Entity e: targets){
            e.takeDamage(attacker.getAttack()/2);
        }
        attacker.rangeAttackAnimation(projectileImageUrl, targets.get(0));
        return targets;
    } 
}
