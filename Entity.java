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
    protected double maxHP;
    protected double maxSpeed;
    protected double maxAttack;
    protected double maxDefense;
    
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
    
    protected ArrayList<Attack> attackSet = new ArrayList<Attack>(); 
    
    protected PlasmaMissile plasmaMissile = new PlasmaMissile();
    public Entity(){
        hp = maxHP;
        attack = maxAttack;
        speed = maxSpeed;
        defense = maxDefense;
        
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
        
        //Temporary
        addAttack(plasmaMissile);
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
        System.out.println(attackSet.size());
        int atkNum = Greenfoot.getRandomNumber(attackSet.size()); // Pick a move out of the arraylist of moves
        attackSet.get(atkNum).dealDamage(this,target); // Call the dealDamage method in the attackmove class 
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
    
    //Move to correct slot
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
    
    //Idle animation
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
    public void addAttack(Attack attackMove){
        attackSet.add(attackMove);
    }
    
    //getter attack, speed, hp, defense
    public double getAttack(){
        //attack == dmg for now
        return(this.attack);
    }
    public double getSpeed(){
        return(this.speed);
    }
    public double getDef(){
        return(this.defense);
    }
    public double getHp(){
        return(this.hp);
    } 
    
    //setters for attack, speed, hp, defense
    public void setAttack(double setattack){
        //set attack... attack == dmg for now
        this.attack = setattack;
    }
    public void setSpeed(double setspeed){
        //set speed
        this.speed = setspeed;
    }
    public void setDef(double setdefense){
        this.defense = setdefense;
    }
    public void setHp(double sethp){
        this.hp = sethp;
    }
    public void takeDamage(double damage) {
        this.hp -= damage;
    }
    public boolean isDead() {
        return this.hp == 0;
    }

    
}