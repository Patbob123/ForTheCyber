import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Melee here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Melee extends Enemy
{
    public Melee(){
        name = "Melee";
        addMoveset(new Pincer());
        
        entityImageUrl = "enemy/melee.png";
        entityImage = createDuplicateImage();
        
        portraitImage = new GreenfootImage("enemy/MeleePortrait.png");
        portraitImage.scale(portraitImage.getWidth()*Constants.PORTRAIT_SCALING, portraitImage.getHeight()*Constants.PORTRAIT_SCALING);
    
        setImage(entityImage);
        width = getImage().getWidth();
        height = getImage().getHeight();
    }
    public Enemy cloneEnemy(){
        return new Melee();
    }
}
