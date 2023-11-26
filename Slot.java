import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Base code for creating set positions for all the entities
 * 
 * @author Dawson
 * @version November 2023
 */
public class Slot extends Actor
{
    private int x;
    private int y;
    private Entity entity;
    
    public Slot(int x, int y){
        this.x = x;
        this.y = y;
        
        setImage(new GreenfootImage(1,1));
    }
    public int peekX(){
        return x;
    }
    public int peekY(){
        return y;
    }
    public void setEntity(Entity entity){
        this.entity = entity;
    }
    public Entity getEntity(){
        return this.entity;
    }
    public void act() 
    {
        // Add your action code here.
    }
}
