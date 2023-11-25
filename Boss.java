import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss extends Enemy
{
    public Boss(){
        name = "Boss";
        addMoveset(new ShotGun());
        addMoveset(new DeathRay());
        addMoveset(new Heal());
        
        maxHp = 300;
        hp = maxHp;
        speed = 7;
        attack = 3;
        
        entityImageUrl = "enemy/boss.png";
        entityImage = createDuplicateImage();
        
        portraitImage = new GreenfootImage("enemy/boss.png");
        portraitImage.scale(portraitImage.getWidth()*Constants.PORTRAIT_SCALING, portraitImage.getHeight()*Constants.PORTRAIT_SCALING);
        
        setImage(entityImage);
        width = getImage().getWidth();
        height = getImage().getHeight();
    }

    public Enemy cloneEnemy(){
        return new Boss();
    }
}
