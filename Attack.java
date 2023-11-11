import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Attack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Attack extends SuperSmoothMover
{
    Entity attacker;
    Entity target;
    private double AD;
    public Attack (Entity attacker){
        this.attacker = attacker;
        AD = attacker.getAttack();
    }
    public void attackMove (Entity target){
        
        target.takeDamage(AD);
    }
    /**
     * Act - do whatever the Attack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //asdasds
    }    
}
