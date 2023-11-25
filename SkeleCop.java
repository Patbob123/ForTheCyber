import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * SkeleCop is a difficult enemy that uses DeathRay
 * 
 * @author Jaiden
 * <p>
 * Modified by: Dawson
 * </p>
 * @version November 2023 */
public class SkeleCop extends Enemy
{
    public SkeleCop(){
        name = "SkeleCop";
        addMoveset(new DeathRay());
        
        entityImageUrl = "enemy/skelecop.png";
        entityImage = createDuplicateImage();
        
        portraitImage = new GreenfootImage("enemy/SkelecopPortrait.png");
        portraitImage.scale(portraitImage.getWidth()*Constants.PORTRAIT_SCALING, portraitImage.getHeight()*Constants.PORTRAIT_SCALING);
    
        setImage(entityImage);
        width = getImage().getWidth();
        height = getImage().getHeight();
    }
    public Enemy cloneEnemy(){
        return new SkeleCop();
    }
}
