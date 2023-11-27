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
public class Pincher extends Enemy
{
    /**
     * Constructor for pincher enemy
     */
    public Pincher(){
        name = "Pincher";
        addMoveset(new Pincer());
        
        entityImageUrl = "enemy/melee.png";
        entityImage = createDuplicateImage();
        
        portraitImageUrl = "enemy/MeleePortrait.png";
        portraitImage = new GreenfootImage(portraitImageUrl);
        portraitImage.scale(portraitImage.getWidth()*Constants.PORTRAIT_SCALING, portraitImage.getHeight()*Constants.PORTRAIT_SCALING);
    
        speed = 8;
        attack = 0.5;
        maxHp = 20;
        hp = maxHp;
        
        setImage(entityImage);
        width = getImage().getWidth();
        height = getImage().getHeight();
        
        desc = "A swift fighter that attacks rapidly"; 
    }
    
    /**
     * Clone this enemy
     * 
     * @return new Pincher()
     */
    public Enemy cloneEnemy(){
        return new Pincher();
    }
}
