import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Melee is a basic enemy that uses Pincer
 * 
 * @author Jaiden
 * <p>
 * Modified by: Dawson
 * </p>
 * @version November 2023
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
