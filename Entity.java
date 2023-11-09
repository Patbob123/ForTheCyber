


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
    protected boolean finishedAttack;
    
    protected String name;
    protected int side;
    protected Slot slot;
    
    protected GreenfootImage testCharImage;
    protected int width;
    protected int height;
    protected boolean inhaling;
    protected int breathEveryAct;
    protected boolean onSlot;
    protected double ImageSizeScale;
    protected double toSlotSpeed;
    
    protected ArrayList<Attack> attacks = new ArrayList<Attack>();
    
    public Entity(){
        finishedAttack = false;
        onSlot = false;
        testCharImage = new GreenfootImage(90, 90);
        testCharImage.setColor(Color.BLUE);
        testCharImage.fill();
        setImage(testCharImage);
        width = getImage().getWidth();
        height = getImage().getHeight();
        inhaling = true;
        breathEveryAct = 3;
        
        ImageSizeScale = 0.05;
    }
    
    public void act() 
    {
        breathe();
        if(!onSlot) {
            toSlot();
        }else {
            finishedAttack = true;
        }
        
    }    
    

    public void attack(Entity target){
        this.finishedAttack = false;
        initToSlot(((BattleWorld)getWorld()).getAttackSlots()[getSide()]); 
     
    }
    public void executeAttack(Entity target){
        target.takeDamage(attack);
    }
    public boolean isAttackFinished(){
        return this.finishedAttack;
    }
    public Slot getSlot(){
        return this.slot;
    }
    public int getSide(){
        return this.side;
    }
    
    
    public void initToSlot(Slot slot){
        onSlot = false;
        this.slot = slot;
        double distance = getDistance();
        toSlotSpeed = distance/30;
        
        slot.setEntity(this);
    }
    public void toSlot(){
        
        int targetX = slot.getX(); //gets slot x-coord
        int targetY = slot.getY(); //gets slot x-coord
        double distance = getDistance();
        
        turnTowards(targetX, targetY);
        if(distance > 0) {
            move(distance < toSlotSpeed ? 1 : toSlotSpeed);
            distance = getDistance();
        }else if(distance == 0){
            onSlot = true;
        }
        
        setRotation(0); 

    }
    public double getDistance(){
        int targetX = slot.getX(); //gets slot x-coord
        int targetY = slot.getY(); //gets slot x-coord
        int xDistance = targetX - getX(); //gets x distance to the slot
        int yDistance = targetY - getY(); //gets y distance to the slot
        double distance = Math.sqrt(xDistance * xDistance + yDistance * yDistance); //calculate distance to the slot
        return distance;
    }
    public void takeDamage(double damage) {
        this.hp -= damage;
    }
    
    public boolean isDead() {
        return this.hp == 0;
    }
    private void breathe(){
        if(((BattleWorld)getWorld()).getAct()%3!=0) return;
        if(inhaling){ //height increases
            getImage().scale(getImage().getWidth()-1, getImage().getHeight()+1);
            inhaling  = getImage().getHeight() < height * (1+ImageSizeScale);
        }else{ //width increases
            getImage().scale(getImage().getWidth()+1, getImage().getHeight()-1);
            inhaling  = getImage().getHeight() < height * (1-ImageSizeScale);
        }
    }
    public int compareTo(Entity e)
    {
        if (this.speed < e.speed) return -1;
        if (this.speed > e.speed) return 1;
        return 0;
    }
}