import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList; // import the ArrayList class
/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * 
 * MAKE WOBBLE IDLE AND WALK SMOOTHLY TO SLOT
 * 
 */
public abstract class Entity extends SuperSmoothMover implements Comparable<Entity>
{
    protected double hp;
    protected double speed;
    protected double attack;
    protected double defense;
    
    protected String name;
    protected int side;
    
    protected GreenfootImage testCharImage = new GreenfootImage(90, 90);
    
    protected ArrayList<Attack> attacks = new ArrayList<Attack>();
    
    public Entity(){
        testCharImage.setColor(Color.BLUE);
        testCharImage.fill();
        setImage(testCharImage);
    }
    
    public void act() 
    {
        
    }    
    
    public void attack(Entity target){
        target.takeDamage(attack);        
    }
    
    public int getSide(){
        return this.side;
    }
    
    
    
    public void toSlot(Slot slot){
        //FOR NOW
        slot.setEntity(this);
        
        
        setLocation(slot.getX(), slot.getY());
    }
    public void takeDamage(double damage) {
        this.hp -= damage;
    }
    
    public boolean die() {
        return this.hp == 0;
    }
    
    public int compareTo(Entity e)
    {
        if (this.speed < e.speed) return -1;
        if (this.speed > e.speed) return 1;
        return 0;
    }
}