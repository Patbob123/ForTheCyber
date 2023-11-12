import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlasmaMissile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlasmaMissile extends Attack
{
    private double baseDamage;
    private double AD_ratio = 1.0;
    private double moveDamage;
    public PlasmaMissile (Entity attacker){
        super(attacker);
        moveDamage = calculateDamage();
    }
    public double calculateDamage(){
        return baseDamage+(AD*AD_ratio);
    }
    public void updateMove(){
        moveDamage = calculateDamage();
    }
    public void attackMove (Entity target){
        target.takeDamage(moveDamage);
    } 
    public void act()
    {
        // Add your action code here.
    }
}
