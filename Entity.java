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
        slot.setEntity(this);
        int targetX = slot.getX(); //gets slot x-coord
        int targetY = slot.getY(); //gets slot x-coord
        int xDistance = targetX - getX(); //gets x distance to the slot
        int yDistance = targetY - getY(); //gets y distance to the slot
        
        double distance = Math.sqrt(xDistance * xDistance + yDistance * yDistance); //calculate distance to the slot
        
        turnTowards(xDistance, yDistance);
        
        while(distance > 1) {
            move(1);
            distance = Math.sqrt(Math.pow(targetX - getX(), 2) + Math.pow(targetY - getY(), 2)); //updates distance
        }
        
        setRotation(0); 
        
        //setLocation(slot.getX(), slot.getY());
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