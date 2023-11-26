import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The boss is the final enemy to be defeated before the user wins, the boss has ShotGun, DeathRay and Heal
 * 
 * @author Jaiden
 * <p>
 * Modified by: Dawson
 * </p>
 * @version November 2023
 */
public class Boss extends Enemy
{
    public Boss(){
        name = "Reddy";
        addMoveset(new ShotGun());
        addMoveset(new DeathRay());
        addMoveset(new Heal());
        
        maxHp = 300;
        hp = maxHp;
        speed = 7;
        attack = 4;
        
        entityImageUrl = "enemy/boss.png";
        entityImage = createDuplicateImage();
        
        portraitImageUrl = "enemy/BossPortrait.png";
        portraitImage = new GreenfootImage(portraitImageUrl);
        portraitImage.scale(portraitImage.getWidth()*Constants.PORTRAIT_SCALING, portraitImage.getHeight()*Constants.PORTRAIT_SCALING);
        
        setImage(entityImage);
        width = getImage().getWidth();
        height = getImage().getHeight();
        
        desc = "Reddy is a tough enemy to beat with his unmatched stats... ";
    }

    public Enemy cloneEnemy(){
        return new Boss();
    }
}
