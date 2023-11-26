import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Sustainer is a basic enemy that uses Heal
 * 
 * @author Jaiden
 * <p>
 * Modified by: Dawson
 * </p>
 * @version November 2023
 */
public class Sustainer extends Enemy
{
    public Sustainer(){
        name = "Sustainer";
        addMoveset(new Heal());
        
        entityImageUrl = "enemy/sustainer.png";
        entityImage = createDuplicateImage();
        
        portraitImage = new GreenfootImage("enemy/SustainerPortrait.png");
        portraitImage.scale(portraitImage.getWidth()*Constants.PORTRAIT_SCALING, portraitImage.getHeight()*Constants.PORTRAIT_SCALING);
    
        maxHp = 15;
        hp = maxHp;
        speed = 3;
        setImage(entityImage);
        width = getImage().getWidth();
        height = getImage().getHeight();
        
    }
    public Enemy cloneEnemy(){
        return new Sustainer();
    }
}
