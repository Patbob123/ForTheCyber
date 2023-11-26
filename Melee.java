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
        
        portraitImageUrl = "enemy/MeleePortrait.png";
        portraitImage = new GreenfootImage(portraitImageUrl);
        portraitImage.scale(portraitImage.getWidth()*Constants.PORTRAIT_SCALING, portraitImage.getHeight()*Constants.PORTRAIT_SCALING);
    
        speed = 9;
        attack = 0.25;
        maxHp = 25;
        hp = maxHp;
        
        setImage(entityImage);
        width = getImage().getWidth();
        height = getImage().getHeight();
        
    }
    public Enemy cloneEnemy(){
        return new Melee();
    }
}
