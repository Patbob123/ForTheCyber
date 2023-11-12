import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Attack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Attack extends SuperSmoothMover
{
    Entity attacker;
    Entity target;
    
    //Grab the entity's stats for damage ratios
    protected double AD;
    protected double HP;
    protected double DEF;
    protected double SPD;
    protected int duration = 180;
    /*
    public Attack (Entity attacker){
        this.attacker = attacker;
        AD = attacker.getAttack();
    }
    */
    public abstract void dealDamage(Entity attacker, Entity target);
    public int getDuration(){
        return duration;
    }
       
}
