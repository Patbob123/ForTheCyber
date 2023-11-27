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
    
    /**
     * Constructor for sustainer
     */
    public Sustainer(){
        name = "Sustainer";
        addMoveset(new Heal());
        
        entityImageUrl = "enemy/sustainer.png";
        entityImage = createDuplicateImage();
        
        portraitImageUrl = "enemy/SustainerPortrait.png";
        portraitImage = new GreenfootImage(portraitImageUrl);
        portraitImage.scale(portraitImage.getWidth()*Constants.PORTRAIT_SCALING, portraitImage.getHeight()*Constants.PORTRAIT_SCALING);
    
        maxHp = 15;
        hp = maxHp;
        speed = 2;
        setImage(entityImage);
        width = getImage().getWidth();
        height = getImage().getHeight();
        
        desc = "The critical support that keeps all the fighters alive"; 
    }
    
    /**
     * Clone this enemy
     * 
     * @return new Sustainer();
     */
    public Enemy cloneEnemy(){
        return new Sustainer();
    }
}
