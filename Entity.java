import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList; // import the ArrayList class
import java.util.Arrays;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.AlphaComposite;
/**
 * Base Template for all the characters, handles attacks, stores and sorts battle field information.  
 * Borrowed Mr.Cohen's code for Image Manipulation
 * 
 * @author Jaiden
 * <p>
 * Modified by: Dawson
 * </p>
 * @version November 2023
 * 
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
    protected String desc;
    protected int side;
    protected Slot slot;
    protected Entity meleeTarget;
    protected Coordinate rangedTarget;
    
    protected String entityImageUrl;
    protected GreenfootImage entityImage;
    protected GreenfootImage filteredImage;
    protected String portraitImageUrl;
    protected GreenfootImage portraitImage;
    protected int width;
    protected int height;
    protected boolean inhaling;
    protected int breathEveryAct;
    protected boolean onSlot;
    protected double ImageSizeScale;
    protected double toSlotSpeed;
    protected double meleeSpeed;
    protected String queuedMeleeSound;
    protected String projectileImageUrl;
    protected int targetedX;
    protected int targetedY;
    protected int filterActs;
    
    protected boolean stunner;
    protected boolean stunned;
    protected boolean wideRange;
    protected boolean dodge;

    protected ArrayList<Attack> attackSet = new ArrayList<Attack>(); 
    
    /**
     * Constructor for Entity
     */
    public Entity(){
        desc = "DESC \n DIE";
        
        maxSpeed = 9;
        maxDefense = 9;
        maxAttack = 9;
        
        stunner = false;
        stunned = false;
        wideRange = false;
        dodge = false;
        finishedAttack = false;
        onSlot = false;
        
        inhaling = true;
        breathEveryAct = 3;
        
        ImageSizeScale = 0.02;
    }
    
    /**
     * Create deep copy of entity's sprite
     */
    public GreenfootImage createDuplicateImage(){
        GreenfootImage image = new GreenfootImage(entityImageUrl);
        image.scale(image.getWidth()*Constants.IMAGE_SCALING, image.getHeight()*Constants.IMAGE_SCALING);
        return image;
    }
    
    /**
     * Act method
     */
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
    
    /**
     * Based on current move, target entities and execute move to all the entities that were targeted. Current attacker goes to designated attacking slot.
     * 
     * @param move                      The attack 
     * @param entireField               List that holds which side entities are on
     */
    public ArrayList<Entity> attack(Attack move,Side[] entireField){
        if(attackSet.size() <= 0) return null;
        this.finishedAttack = false;
        
        
        ArrayList<Entity> allTargets = move.target(this, entireField, this.side); // Call move.target, which gets all targets affected by this move, then pass to performMove(), which executes the effects on targets
        if(getWideRange()) allTargets = entireField[1-getSide()].getEntities();
        if(getStunner() && Greenfoot.getRandomNumber(7) < 10){
            for(Entity e: allTargets) e.stun(true);
        }
        move.performMove(allTargets,this);
        
        attackTime = move.getDuration(); 
        initToSlot(((BattleWorld)getWorld()).getAttackSlots()[getSide()]);
        return allTargets;
    }
    
    /**
     * Method to select a move for attacker
     * 
     * @return A move 
     */
    public Attack pickRandomMove(){
        return attackSet.get(Greenfoot.getRandomNumber(attackSet.size())); // Pick a move out of the arraylist of moves
    }
    
    /**
     * Method to do an attack
     */
    public void executeAttack(){
        attackTime--;
        if(meleeTarget != null) hitMeleeTarget();
        if(rangedTarget != null) useRangeAttack();
            
        
        if(attackTime <= 0){
            finishedAttack = true;
        }
        
    }
    
    /**
     * Check is attack duration is over
     */
    public boolean isAttackFinished(){
        return this.finishedAttack;
    }
    
    /**
     * Gets the slot
     */
    public Slot getSlot(){
        return this.slot;
    }
    
    /**
     * Gets side
     */
    public int getSide(){
        return this.side;
    }
    
    /**
     * Gets name
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Gets description
     */
    public String getDesc(){
        return this.desc;
    }
    
    /**
     * Gets portrait of the entity
     */
    public GreenfootImage getPortrait(){
        return this.portraitImage;
    }
    
    /**
     * Gets portrait URL of the entity
     */
    public String getPortraitUrl(){
        return this.portraitImageUrl;
    }
    
    /**
     * Gets image URL of the entity
     */
    public String getImageUrl(){
        return this.entityImageUrl;
    }
    
    /**
     * Method to set entity to start slot
     */
    public void initToSlot(Slot slot){
        onSlot = false;
        this.slot = slot;
        double distance = getDistance(slot);
        toSlotSpeed = distance/30;
        
        slot.setEntity(this);
    }
    
    /**
     * Moves entity to correct slot
     */
    public void toSlot(){
        
        int targetX = slot.getX(); //gets slot x-coord
        int targetY = slot.getY(); //gets slot x-coord
        double distance = getDistance(slot);
        
        turnTowards(targetX, targetY);
        if(distance > 0) {
            move(distance < toSlotSpeed ? 1 : toSlotSpeed);
            distance = getDistance(slot);
        }else if(distance == 0){
            onSlot = true;
        }
        
        setRotation(0); 

    }
    
    /**
     * Gets distance to an actor from current position
     * 
     * @return Distance to actor
     */
    public double getDistance(Actor a){
        int targetX = a.getX(); //gets slot x-coord
        int targetY = a.getY(); //gets slot x-coord
        int xDistance = targetX - getX(); //gets x distance to the actor
        int yDistance = targetY - getY(); //gets y distance to the actor
        double distance = Math.sqrt(xDistance * xDistance + yDistance * yDistance); //calculate distance to the actor
        return distance;
    }
    
    /**
     * Gets distance to an actor from current position
     * 
     * @return Distance to actor
     */
    public double getDistance(int x, int y){
        int targetX = x; //gets slot x-coord
        int targetY = y; //gets slot x-coord
        int xDistance = targetX - getX(); //gets x distance to the slot
        int yDistance = targetY - getY(); //gets y distance to the slot
        double distance = Math.sqrt(xDistance * xDistance + yDistance * yDistance); //calculate distance to the slot
        return distance;
    }
    
    /**
     * Idle animation for entities 
     */
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
    
    /**
     * Sets up attack animation
     * 
     * @param target                 The target of the attacker
     * @param meleesound             Name of the attack sound
     */
    public void meleeAttackAnimate(Entity target, String meleeSound){
        double distance = getDistance(target);
        meleeSpeed = 1;
        meleeTarget = target;
        targetedX = meleeTarget.getX();
        targetedY = meleeTarget.getY();
        queuedMeleeSound = meleeSound;
    }
    
    /**
     * Method for the attack animation movement
     */
    public void hitMeleeTarget(){
        int targetX = getTargetedX(); //gets target x-coord
        int targetY = getTargetedY(); //gets target y-coord
        double distance = getDistance(targetX, targetY);
        
        turnTowards(targetX, targetY);
        if(distance > 0) {
            meleeSpeed*=1.1;
            move(distance < meleeSpeed ? 1 : meleeSpeed);
        }else if(distance == 0) {
            meleeTarget = null;
            ((SuperWorld)getWorld()).getSM().playSound(queuedMeleeSound);
            initToSlot(this.slot);   
        }
        
        setRotation(0); 
    }
        
    /**
     * Sets up range attack animation
     * 
     * @param projectileImageUrl                Url of the projectile
     * @param target                            The entity that is using the attack
     */
    public void rangeAttackAnimate(String projectileImageUrl, Entity target){
        this.projectileImageUrl = projectileImageUrl;
        rangedTarget = new Coordinate(target.getX(), target.getY());
    }
    
    /**
     * Method to execute the animation of the projectile
     */
    public void useRangeAttack(){
        Projectile p = new Projectile(projectileImageUrl); 
        getWorld().addObject(p, getX(), getY());
        p.turnTowards(rangedTarget.getX(), rangedTarget.getY());
        p.move(p.getImage().getWidth()/2);
        rangedTarget = null;
    }
    
    /**
    * Method to compare two entities speed and return which one is faster
    * 
    * @param e                 The entity that is being compared to the first one
    */
    public int compareTo(Entity e)
    {
        if (this.speed < e.speed) return -1;
        if (this.speed > e.speed) return 1;
        return 0;
    }
    
    /**
     * Method to add a move to the entity's moveset
     */
    public void addMoveset(Attack attackMove){
        attackSet.add(attackMove);
    }
    
    /**
     * Method to get attack stat
     * 
     * @return the entity's damange
     */
    public double getAttack(){
        return(this.attack);
    }
    
    /**
     * Method to get speed stat
     * 
     * @return the entity's speed
     */
    public double getSpeed(){
        return(this.speed);
    }
    
    /**
     * Method to get defense stat
     * 
     * @return the entity's defense
     */
    public double getDef(){
        return(this.defense);
    }
    
    /**
     * Method to get hp stat
     * 
     * @return the entity's hp
     */
    public double getHp(){
        return(this.hp);
    } 
    
    /**
     * Method to set according hp to the entity
     * 
     * @param hpBar        The hp bar of the entity
     */
    public void assignHpBar(HPBar hpBar){
        this.hpBar = hpBar;
    }
    
    /**
     * Method to get hp bar
     * 
     * @return the entity's hp bar
     */
    public HPBar getHpBar(){
        return this.hpBar;
    }
    
    /**
     * Method to get max hp stat
     * 
     * @return the entity's max hp
     */
    public double getMaxHp(){
        return this.maxHp;
    }
    
    /**
     * Method to get augment for enemies (none)
     * 
     * @return the entity's augment
     */
    public Augment getAugment(){
        return null;
    }
    
    /**
     * Method to get name
     * 
     * @return the entity's name
     */
    public String toString(){
        return this.name;
    }
    
    /**
     * Method to get entity's x coord
     * 
     * @return the entity's x coord
     */
    public int getTargetedX(){
        return targetedX;
    }
    
    /**
     * Method to get entity's y coord
     * 
     * @return the entity's entity's y coord
     */
    public int getTargetedY(){
        return targetedY;
    }
    
    /**
     * Set attack for entity
     * 
     * @param setattack                 Attack value
     */
    public void setAttack(double setAttack){
        this.attack = setAttack > maxAttack ? maxAttack : setAttack;
    }
    
    /**
     * Set attack for entity
     * 
     * @param setAttack                 Attack value
     */
    public void setSpeed(double setSpeed){
        //set speed
        this.speed = setSpeed > maxSpeed ? maxSpeed : setSpeed;
    }
    
    /**
     * Set defense for entity
     * 
     * @param setDefense                Defense value
     */
    public void setDef(double setDefense){
        this.defense = setDefense > maxDefense ? maxDefense : setDefense;
    }
    
    /**
     * Set hp for entity
     * 
     * @param setHp                 HP value
     */
    public void setHp(double setHp){
        this.hp = setHp > 0 ? setHp : 0;
        if(getHpBar()!=null){
            getHpBar().refresh();
        }else{
            maxHp = hp;
        } 
    }
    
    /**
     * Gets if stunner
     * 
     * @return stunner
     */
    public boolean getStunner(){
        return this.stunner;
    }
    
    /**
     * Gets if dodge
     * 
     * @return dodge
     */
    public boolean getDodge(){
        return this.dodge;
    }
    
    /**
     * Gets if wide range
     * 
     * @return wide range
     */
    public boolean getWideRange(){
        return this.wideRange;
    }
    
    /**
     * Gets if stunned
     * 
     * @return stunned
     */
    public boolean getStunned(){
        return this.stunned;
    }
    
    /**
     * Sets stunner 
     */
    public void setStunner(){
        this.stunner = true;
    }
    
    /**
     * Sets dodge
     */
    public void setDodge(){
        this.dodge = true;
    }
    
    /**
     * Sets wide range
     */
    public void setWideRange(){
        this.wideRange = true;
    }
    
    /**
     * Sets moveset 
     * 
     * @param attackSet               Attack set of entity
     */
    public void setMoveset(ArrayList<Attack> attackSet){
        this.attackSet = attackSet;
    }
    
    /**
     * Checks if stunned
     */
    public void stun(boolean stunned){
        this.stunned = stunned;
    }
    
    /**
     * Method for entity to take damage
     * 
     * @param damage              Amount entity takes as damage
     */
    public void takeDamage(double damage) {
        if(getDodge() && Greenfoot.getRandomNumber(2)==1) return;
        setHp(this.hp - damage/(1+this.defense/3));

        filteredImage = createDuplicateImage();
        changeColour(filteredImage.getAwtImage(), +2, -1, -1, 40);
        setImage(filteredImage);
        filterActs = 50;
    }
    
    /**
     * Method for entity to heal
     * 
     * @param healing             Amount entity heals
     */
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
    
    /**
     * Method to return hp as 0, the entity has died
     * 
     * @return 0 hp
     */
    public boolean isDead() {
        return this.hp == 0;
    }
    
    /**
     * Method to set attack as finished
     * 
     * @return the entity's damange
     */
    public void setAttackFinished(){
        this.finishedAttack = true;
    }
    
    /**
     * Method to remove entity from a world
     */
    public void removeFromWorld(){
        //play enemy death sound
        if(getWorld()==null) return;
        ((SuperWorld)getWorld()).getSM().playSound("enemydeath");
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