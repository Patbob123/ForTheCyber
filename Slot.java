import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Slot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
