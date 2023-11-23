import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Arrays;
/**
 * <p>This is the UserChar class. It 
 * 
 * @Edmond
 * @Nov 7 2023
 */
public class UserChar extends Entity
{    
    private Augment augment;
    private StatBar statBar;
    
    public UserChar(){
        entityImage = new GreenfootImage("enemy/juggernaut.png");
        entityImage.scale(entityImage.getWidth()*Constants.IMAGE_SCALING, entityImage.getHeight()*Constants.IMAGE_SCALING);
        
        portraitImage = new GreenfootImage("enemy/JuggernautPortrait.png");
        portraitImage.scale(portraitImage.getWidth()*Constants.PORTRAIT_SCALING, portraitImage.getHeight()*Constants.PORTRAIT_SCALING);
        //set hp to max at beginning
        maxHp = 10;
        hp = maxHp;
        speed = 1;
        attack = 1;
        defense = 1;
        
        side = 0;
        name = "ssundee";
        addAttack(new DeathRay());
        setImage(entityImage);
        width = getImage().getWidth();
        height = getImage().getHeight();
        
    }

    public void act() 
    {
        super.act();
        if (isDead()){
            //if hp is 0 or less, die
            //PUT DYING ANIM HERE IN FUTURE
            getWorld().removeObject(this);
        }
    }
    public void assignHpBar(HPBar hpBar){
        this.hpBar = hpBar;
    }
    public void assignStatBar(StatBar statBar){
        this.statBar = statBar;
    }
    public void setHp(double hp){
        super.setHp(hp);
        if(getHpBar()!= null) getHpBar().refresh();
    }
    public void setAttack(double attk){
        super.setAttack(attk);
        if(getStatBar()!= null) getStatBar().refresh();
    }
    public void setDef(double def){
        super.setDef(def);
        if(getStatBar()!= null) getStatBar().refresh();
    }
    public void setSpeed(double speed){
        super.setSpeed(speed);
        if(getStatBar()!= null) getStatBar().refresh();
    }
    public HPBar getHpBar(){
        return this.hpBar;
    }
    public StatBar getStatBar(){
        return this.statBar;
    }
    public double getMaxHp(){
        return this.maxHp;
    }
    public void setAugment(Augment augment){
        augment.setOwner(this);
        this.augment = augment;
    }
    public Augment getAugment(){
        return this.augment;
    }
    
    public void attackAll(){
        ArrayList<Enemy> ppl = (ArrayList<Enemy>)getObjectsInRange (2000, Enemy.class);
        for (Entity e : ppl){
            e.takeDamage(this.attack);
        }
    }
}