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
    protected double AD;
    protected double HP;
    protected double DEF;
    protected double SPD;
    public Attack (Entity attacker){
        this.attacker = attacker;
        AD = attacker.getAttack();
    }
    abstract void attackMove(Entity target);
       
}
