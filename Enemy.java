import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Write a description of class Enemy here.
 * 
 * @author Jaiden
 * @version November 2023
 */
public abstract class Enemy extends Entity
{
    
    /**
     * Constructor for enemy
     */
    public Enemy(){
        side = 1;
        attack = 1;
        maxHp = 20;
        hp = maxHp;
        speed = 3;
        hpBar = new HPBar(this);
        assignHpBar(hpBar);
    }
    
    /**
     * Adds its hp bar to the world
     * 
     * @param w        The world it is going to get displayed on
     */
    public void addedToWorld(World w){
        w.addObject(getHpBar(), 0, 0);
    }
    
    /**
     * Drags hp bar along itself each act
     */
    public void act() 
    {
        super.act();
        dragHpBar();
    }   
    
    /**
     * Method to get augment for enemy
     * 
     * @return augment
     */
    public Augment getAugment(){
        return null;
    }
    
    /**
     * Method to drag its hp bar
     */
    public void dragHpBar(){
        getHpBar().setLocation(getX(), getY()+60);
    }
    
    /**
     * Method to clone a gunner as default
     * 
     * @return new Gunner()
     */
    public Enemy cloneEnemy(){
        return new Gunner();
    }
    
    /**
     * Method to get portrait image for enemy
     * 
     * @return portraitImage
     */
    public GreenfootImage getEnemyPortrait(){
        return portraitImage;
    }
}
