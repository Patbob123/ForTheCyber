import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sustain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sustainer extends Enemy
{
    public Sustainer(){
        entityImage = new GreenfootImage("enemy/sustainer.png");
        entityImage.scale(entityImage.getWidth()*Constants.IMAGE_SCALING, entityImage.getHeight()*Constants.IMAGE_SCALING);
        
        portraitImage = new GreenfootImage("enemy/SustainerPortrait.png");
        portraitImage.scale(portraitImage.getWidth()*Constants.PORTRAIT_SCALING, portraitImage.getHeight()*Constants.PORTRAIT_SCALING);
    
        setImage(entityImage);
        width = getImage().getWidth();
        height = getImage().getHeight();
    }
    public void act()
    {
        // Add your action code here.
    }
}
