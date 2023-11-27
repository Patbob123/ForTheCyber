import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Juggernaut is a difficult enemy that uses BodySlam
 * 
 * @author Jaiden
 * <p>
 * Modified by: Dawson
 * </p>
 * @version November 2023
 */
public class Juggernaut extends Enemy
{
    /**
     * Constructor for juggernaut
     */
    public Juggernaut(){
        name = "Juggernaut";
        addMoveset(new BodySlam());
 
        entityImageUrl = "enemy/juggernaut.png";
        entityImage = createDuplicateImage();
        
        portraitImageUrl = "enemy/JuggernautPortrait.png";
        portraitImage = new GreenfootImage(portraitImageUrl);
        portraitImage.scale(portraitImage.getWidth()*Constants.PORTRAIT_SCALING, portraitImage.getHeight()*Constants.PORTRAIT_SCALING);
        
        attack = 3;
        speed = 3;
        maxHp = 70;
        hp = maxHp;
        
        setImage(entityImage);
        width = getImage().getWidth();
        height = getImage().getHeight();
 
        desc = "A beefy fighter with respectable damage";  
    }
    
    /**
     * Clone this enemy
     * 
     * @return new Juggernaut()
     */
    public Enemy cloneEnemy(){
        return new Juggernaut();
    }
}
