import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DeathRay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mech57 extends Enemy
{
    public Mech57(){
        name = "Mech57";
        
        entityImageUrl = "enemy/mech57.png";
        entityImage = createDuplicateImage();
        
        portraitImage = new GreenfootImage("enemy/Mech57Portrait.png");
        portraitImage.scale(portraitImage.getWidth()*Constants.PORTRAIT_SCALING, portraitImage.getHeight()*Constants.PORTRAIT_SCALING);
    
        setImage(entityImage);
        width = getImage().getWidth();
        height = getImage().getHeight();
    }
    public Enemy cloneEnemy(){
        return new Mech57();
    }
}
