import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Gunner enemy is a basic enemy that uses ShotGun
 * 
 * @author Jaiden
 * <p>
 * Modified by: Dawson
 * </p>
 * @version November 2023
 */
public class Gunner extends Enemy
{
    public Gunner(){
        name = "Gunner";
        
        addMoveset(new ShotGun());
        
        entityImageUrl = "enemy/gunner.png";
        entityImage = createDuplicateImage();
        
        portraitImageUrl = "enemy/GunnerPortrait.png";
        portraitImage = new GreenfootImage(portraitImageUrl);
        portraitImage.scale(portraitImage.getWidth()*Constants.PORTRAIT_SCALING, portraitImage.getHeight()*Constants.PORTRAIT_SCALING);
        
        attack = 2;
        speed = 5;
        maxHp = 50;
        hp = maxHp;
        
        setImage(entityImage);
        width = getImage().getWidth();
        height = getImage().getHeight();
    
    }

    public Enemy cloneEnemy(){
        return new Gunner();
    }
}
