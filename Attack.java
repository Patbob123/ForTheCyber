import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
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
    protected String name;
    
    public Attack (){
        
    }
    public abstract ArrayList<Entity> performMove(ArrayList<Entity> targets, Entity attacker);
    public abstract ArrayList<Entity> target(Entity attacker, Side[] entireField, int side);
    public int getDuration(){
        return duration;
    }
    public String getName(){
        return name;
    }
        
       
}
