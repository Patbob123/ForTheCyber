import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RoboCop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SkeleCop extends Enemy
{
    public SkeleCop(){
        entityImage = new GreenfootImage("enemy/skelecop.png");
        entityImage.scale(entityImage.getWidth()*Constants.IMAGE_SCALING, entityImage.getHeight()*Constants.IMAGE_SCALING);
        
        portraitImage = new GreenfootImage("enemy/SkeleCopPortrait.png");
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
