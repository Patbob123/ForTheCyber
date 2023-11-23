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
        name = "Gunner";
        
        entityImageUrl = "enemy/gunner.png";
        entityImage = createDuplicateImage();
        
        portraitImage = new GreenfootImage("enemy/GunnerPortrait.png");
        portraitImage.scale(portraitImage.getWidth()*Constants.PORTRAIT_SCALING, portraitImage.getHeight()*Constants.PORTRAIT_SCALING);
        
        setImage(entityImage);
        width = getImage().getWidth();
        height = getImage().getHeight();
    }

    public Enemy cloneEnemy(){
        return new Gunner();
    }
}
