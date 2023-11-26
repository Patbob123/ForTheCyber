import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Plasma Beam deals medium damage to two random targets
 * 
 * @author Vincent
 * <p>
 * Modified by: Jaiden, Dawson
 * </p>
 * 
 * @version November 2023
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
        
        int potentialTargetsNumber = potentialTargets.size();
        
        // Select two targets from an ArrayList of all enemies
        for(int i = 0; i < potentialTargetsNumber; i++){
            Entity firstTarget = potentialTargets.get(i);
            targets.add(firstTarget);
            if(i==1) break;
        }
        
        return targets;
    }
    public ArrayList<Entity> performMove(ArrayList<Entity> targets, Entity attacker){
        ((BattleWorld)attacker.getWorld()).getSM().playSound("plasmaBeam");
        
        for(Entity e: targets){
            e.takeDamage(attacker.getAttack()/2);
            attacker.rangeAttackAnimation(projectileImageUrl, e);
        }
        
        return targets;
    } 
}
