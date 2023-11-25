import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Enemy extends Entity
{
    public Enemy(){
        side = 1;
        attack = 1;
        maxHp = 100;
        hp = maxHp;
        speed = 5;
        hpBar = new HPBar(this);
        assignHpBar(hpBar);
    }
    public void addedToWorld(World w){
        w.addObject(getHpBar(), 0, 0);
    }
    public void act() 
    {
        super.act();
        dragHpBar();
    }   
    public Augment getAugment(){
        return null;
    }
    public void dragHpBar(){
        getHpBar().setLocation(getX(), getY()+60);
    }
    public Enemy cloneEnemy(){
        return new Gunner();
    }
    public GreenfootImage getEnemyPortrait(){
        return portraitImage;
    }
}
