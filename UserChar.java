import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Arrays;
/**
 * UserChar holds all the information for the user's character in builder world and battle world
 * 
 * @author Edmond
 * <p>
 * Modified by: Dawson
 * </p>
 * @version Nov 7 2023
 */
public class UserChar extends Entity
{    
    private Augment augment;
    private StatBar statBar;
    
    /**
     * Constructor for user character
     */
    public UserChar(){
        entityImageUrl = "epickwick.png";
        entityImage = createDuplicateImage();
        
        portraitImageUrl = "epickwickPortrait.png";
        portraitImage = new GreenfootImage(portraitImageUrl);
        portraitImage.scale(portraitImage.getWidth()*Constants.PORTRAIT_SCALING, portraitImage.getHeight()*Constants.PORTRAIT_SCALING);
        //set hp to max at beginning
        maxHp = 15;
        hp = maxHp;
        speed = 1;
        attack = 1;
        defense = 1;
        
        side = 0;
        name = "EpickWick";
        addMoveset(new DeathRay());
        setImage(entityImage);
        width = getImage().getWidth();
        height = getImage().getHeight();
        
    }

    /**
     * removes itself when dead
     */    
    public void act() 
    {
        super.act();
        if (isDead()){
            getWorld().removeObject(this);
        }
    }
    
    /**
     * Method to assign an hp bar to character
     * 
     * @param hpBar
     */
    public void assignHpBar(HPBar hpBar){
        this.hpBar = hpBar;
    }
    
    /**
     * Method to assign an stat bar to character
     * 
     * @param statBar
     */
    public void assignStatBar(StatBar statBar){
        this.statBar = statBar;
    }
    
    /**
     * Method to set hp for character
     * 
     * @param hp
     */
    public void setHp(double hp){
        super.setHp(hp);
        if(getHpBar()!= null) getHpBar().refresh();
    }
    
    /**
     * Method to set attack for character
     * 
     * @param attk
     */
    public void setAttack(double attk){
        super.setAttack(attk);
        if(getStatBar()!= null) getStatBar().refresh();
    }
    
    /**
     * Method to set defense for character
     * 
     * @param def
     */
    public void setDef(double def){
        super.setDef(def);
        if(getStatBar()!= null) getStatBar().refresh();
    }
    
    /**
     * Method to set speed for character
     * 
     * @param speed
     */
    public void setSpeed(double speed){
        super.setSpeed(speed);
        if(getStatBar()!= null) getStatBar().refresh();
    }
    
    /**
     * Method to get HpBar for character
     * 
     * @return hpBar
     */
    public HPBar getHpBar(){
        return this.hpBar;
    }
    
    /**
     * Method to get StatBar for character
     * 
     * @return statBar
     */
    public StatBar getStatBar(){
        return this.statBar;
    }
    
    /**
     * Method to get attack for character
     * 
     * @return attack
     */
    public double getAttack(){
        return this.attack + 3; // 3 is the base damage for userchar, for balancing
    }
    
    /**
     * Method to set augment for character
     * 
     * @param augment
     */
    public void setAugment(Augment augment){
        augment.setOwner(this);
        this.augment = augment;
    }
    
    /**
     * Method to get augment for character
     * 
     * @return augment
     */
    public Augment getAugment(){
        return this.augment;
    }
}