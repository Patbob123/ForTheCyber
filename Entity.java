import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList; // import the ArrayList class
import java.util.Arrays;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.AlphaComposite;
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
    protected double maxHp;
    protected double maxSpeed;
    protected double maxAttack;
    protected double maxDefense;
    protected HPBar hpBar;
    
    protected double hp;
    protected double speed;
    protected double attack;
    protected double defense;
    
    protected int attackTime;
    protected boolean finishedAttack;
    
    protected String name;
    protected int side;
    protected Slot slot;
    
    protected String entityImageUrl;
    protected GreenfootImage entityImage;
    protected GreenfootImage filteredImage;
    protected GreenfootImage portraitImage;
    protected int width;
    protected int height;
    protected boolean inhaling;
    protected int breathEveryAct;
    protected boolean onSlot;
    protected double ImageSizeScale;
    protected double toSlotSpeed;
    protected int filterActs;
    
    protected boolean stunner;
    protected boolean stunned;
    protected boolean wideRange;
    protected boolean dodge;

    protected ArrayList<Attack> attackSet = new ArrayList<Attack>(Arrays.asList(new BodySlam())); 
    public Entity(){
        maxSpeed = 9;
        maxDefense = 9;
        maxAttack = 9;
        
        stunner = false;
        stunned = false;
        wideRange = false;
        dodge = false;
        //attack = maxAttack;
        //speed = maxSpeed;
        //defense = maxDefense;
        finishedAttack = false;
        onSlot = false;
        
        inhaling = true;
        breathEveryAct = 3;
        
        ImageSizeScale = 0.02;

        
    }
    public GreenfootImage createDuplicateImage(){
        GreenfootImage image = new GreenfootImage(entityImageUrl);
        image.scale(image.getWidth()*Constants.IMAGE_SCALING, image.getHeight()*Constants.IMAGE_SCALING);
        return image;
    }
    
    public void act() 
    {
        if(filterActs > 0){
            filterActs--;
        }else if(filterActs == 0){
            setImage(entityImage);
        }

        breathe();
        if(!onSlot) {
            toSlot();
        }else {
            executeAttack();
        }
    }    
    

    public ArrayList<Entity> attack(Attack move,Side[] entireField){
        if(attackSet.size() <= 0) return null;
        this.finishedAttack = false;
        
        
        ArrayList<Entity> allTargets = move.target(this, entireField, this.side); // Call move.target, which gets all targets affected by this move, then pass to performMove(), which executes the effects on targets
        if(getWideRange()) allTargets = entireField[1-getSide()].getEntities();
        if(getStunner()){
            for(Entity e: allTargets) e.stun(true);
        }
        move.performMove(allTargets,this);
        
        attackTime = move.getDuration(); 
        initToSlot(((BattleWorld)getWorld()).getAttackSlots()[getSide()]); 
        return allTargets;
    }
    public Attack pickRandomMove(){
        return attackSet.get(Greenfoot.getRandomNumber(attackSet.size())); // Pick a move out of the arraylist of moves
    }
    public void executeAttack(){
        attackTime--;
        if(attackTime <= 0){
            finishedAttack = true;
        }
        
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
    public GreenfootImage getPortrait(){
        return this.portraitImage;
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
        if(((BattleWorld)getWorld()).getAct()%5!=0) return;
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
    public void addMoveset(Attack attackMove){
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
    public void assignHpBar(HPBar hpBar){
        this.hpBar = hpBar;
    }
    public HPBar getHpBar(){
        return this.hpBar;
    }
    public double getMaxHp(){
        return this.maxHp;
    }
    public Augment getAugment(){
        return null;
    }
    public String toString(){
        return this.name;
    }
    
    //setters for attack, speed, hp, defense
    public void setAttack(double setattack){
        //set attack... attack == dmg for now
        this.attack = setattack > maxAttack ? maxAttack : setattack;
    }
    public void setSpeed(double setspeed){
        //set speed
        this.speed = setspeed > maxSpeed ? maxSpeed : setspeed;
    }
    public void setDef(double setdefense){
        this.defense = setdefense > maxDefense ? maxDefense : setdefense;
    }
    public void setHp(double sethp){
        this.hp = sethp > 0 ? sethp : 0;
        if(getHpBar()!=null){
            getHpBar().refresh();
        }else{
            maxHp = hp;
        }
    }
    public boolean getStunner(){
        return this.stunner;
    }
    public boolean getDodge(){
        return this.dodge;
    }
    public boolean getWideRange(){
        return this.wideRange;
    }
    public boolean getStunned(){
        return this.stunned;
    }
    public void setStunner(){
        this.stunner = true;
    }
    public void setDodge(){
        this.dodge = true;
    }
    public void setWideRange(){
        this.wideRange = true;
    }
    public void setMoveset(ArrayList<Attack> attackSet){
        this.attackSet = attackSet;
    }
    public void stun(boolean stunned){
        this.stunned = stunned;
    }
    public void takeDamage(double damage) {
        if(getDodge() && Greenfoot.getRandomNumber(2)==1) return;
        setHp(this.hp - damage);

        filteredImage = createDuplicateImage();
        changeColour(filteredImage.getAwtImage(), +2, -1, -1, 40);
        setImage(filteredImage);
        filterActs = 50;
    }
    public void heal(double healing) {
        if(this.hp + healing < this.maxHp){
            setHp(this.hp + healing);
        }else{
            setHp(this.maxHp);
        }
        filteredImage = createDuplicateImage();
        changeColour(filteredImage.getAwtImage(), -1, +2, -1, 40);
        setImage(filteredImage);
        filterActs = 50;
    }
    public boolean isDead() {
        return this.hp == 0;
    }
    public void removeFromWorld(){
        getWorld().removeObject(getHpBar());
        getWorld().removeObject(this);
    }
    /**
     * Example colour altering method by Mr. Cohen. This method will
     * increase the blue value while reducing the red and green values.
     * 
     * Demonstrates use of packagePixel() and unpackPixel() methods.
     * 
     * @param bi    The BufferedImage (passed by reference) to change.
     */
    public static void changeColour (BufferedImage bi, int addRed, int addGreen, int addBlue, int multiplier)
    {
        // Get image size to use in for loops
        int xSize = bi.getWidth();
        int ySize = bi.getHeight();

        
        
        // Using array size as limit
        for (int y = 0; y < ySize; y++)
        {
            for (int x = 0; x < xSize; x++)
            {
                // Calls method in BufferedImage that returns R G B and alpha values
                // encoded together in an integer
                int rgba = bi.getRGB(x, y);

                // Call the unpackPixel method to retrieve the four integers for
                // R, G, B and alpha and assign them each to their own integer
                int[] rgbValues = unpackPixel (rgba);
                
                int alpha = rgbValues[0];
                int red = rgbValues[1];
                int green = rgbValues[2];
                int blue = rgbValues[3];

                // make the pic BLUE-er
                for(int i = 0; i < multiplier; i++){
                    if (blue < 253 && blue >= 50)
                        blue += addBlue;
                    if (red < 253 && red >= 50)
                        red += addRed;
                    if (green < 253 && green >= 50)
                        green += addGreen;
                }
                

                int newColour = packagePixel (red, green, blue, alpha);
                bi.setRGB (x, y, newColour);
            }
        }

    }
    /**
     * Takes in an rgb value - the kind that is returned from BufferedImage's
     * getRGB() method - and returns 4 integers for easy manipulation.
     * 
     * By Jordan Cohen
     * Version 0.2
     * 
     * @param rgbaValue The value of a single pixel as an integer, representing<br>
     *                  8 bits for red, green and blue and 8 bits for alpha:<br>
     *                  <pre>alpha   red     green   blue</pre>
     *                  <pre>00000000000000000000000000000000</pre>
     * @return int[4]   Array containing 4 shorter ints<br>
     *                  <pre>0       1       2       3</pre>
     *                  <pre>alpha   red     green   blue</pre>
     */
    public static int[] unpackPixel (int rgbaValue)
    {
        int[] unpackedValues = new int[4];
        // alpha
        unpackedValues[0] = (rgbaValue >> 24) & 0xFF;
        // red
        unpackedValues[1] = (rgbaValue >> 16) & 0xFF;
        // green
        unpackedValues[2] = (rgbaValue >>  8) & 0xFF;
        // blue
        unpackedValues[3] = (rgbaValue) & 0xFF;

        return unpackedValues;
    }

    /**
     * Takes in a red, green, blue and alpha integer and uses bit-shifting
     * to package all of the data into a single integer.
     * 
     * @param   int red value (0-255)
     * @param   int green value (0-255)
     * @param   int blue value (0-255)
     * @param   int alpha value (0-255)
     * 
     * @return int  Integer representing 32 bit integer pixel ready
     *              for BufferedImage
     */
    public static int packagePixel (int r, int g, int b, int a)
    {
        int newRGB = (a << 24) | (r << 16) | (g << 8) | b;
        return newRGB;
    }
    
    
}