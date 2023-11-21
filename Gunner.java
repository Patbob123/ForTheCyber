import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gunner extends Enemy
{
    public Gunner(){
        this.name = "Gunner";
        
        entityImage = new GreenfootImage("enemy/gunner.png");
        entityImage.scale(entityImage.getWidth()*Constants.IMAGE_SCALING, entityImage.getHeight()*Constants.IMAGE_SCALING);
        
        portraitImage = new GreenfootImage("enemy/GunnerPortrait.png");
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
