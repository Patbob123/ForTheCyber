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
    
    /**
     * Constructor for Slot
     * 
     * @param x     The x-position
     * @param y     The y-position
     */
    public Slot(int x, int y){
        this.x = x;
        this.y = y;
        
        setImage(new GreenfootImage(1,1));
    }
    
    /**
     * Get x position
     * 
     * @return x coord
     */
    public int peekX(){
        return x;
    }
    
    /**
     * Get y position
     * 
     * @return y coord
     */
    public int peekY(){
        return y;
    }
    
    /**
     * Method to set entity 
     */
    public void setEntity(Entity entity){
        this.entity = entity;
    }
    
    /**
     * Method to get entity
     * 
     * @return entity
     */
    public Entity getEntity(){
        return this.entity;
    }
    public void act() 
    {
        // Add your action code here.
    }
}
