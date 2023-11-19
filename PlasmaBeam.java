import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    public double calculateDamage(Entity attacker){
        return baseDamage+(attacker.getAttack()*AD_ratio);
    }
    /*
    public void updateMove(){
        moveDamage = calculateDamage();
    }
    */
    public void dealDamage (Entity attacker, Entity target){
        double damage = calculateDamage(attacker); 
        target.takeDamage(damage);
    } 
}
