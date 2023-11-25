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
    public Juggernaut(){
        name = "Juggernaut";
        addMoveset(new BodySlam());
 
        entityImageUrl = "enemy/juggernaut.png";
        entityImage = createDuplicateImage();
        
        portraitImage = new GreenfootImage("enemy/JuggernautPortrait.png");
        portraitImage.scale(portraitImage.getWidth()*Constants.PORTRAIT_SCALING, portraitImage.getHeight()*Constants.PORTRAIT_SCALING);
        
        setImage(entityImage);
        width = getImage().getWidth();
        height = getImage().getHeight();
    }
    public Enemy cloneEnemy(){
        return new Juggernaut();
    }
}
