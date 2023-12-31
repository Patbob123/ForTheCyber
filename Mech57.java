import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Mech57 is a difficult enemy that uses PlasmaBeam
 * 
 * @author Jaiden
 * <p>
 * Modified by: Dawson
 * </p>
 * @version November 2023
 */
public class Mech57 extends Enemy
{
    /**
     * Constructor for mech57
     */
    public Mech57(){
        name = "Mech57";
        addMoveset(new PlasmaBeam());
        
        entityImageUrl = "enemy/mech57.png";
        entityImage = createDuplicateImage();
        
        portraitImageUrl = "enemy/Mech57Portrait.png";
        portraitImage = new GreenfootImage(portraitImageUrl);
        portraitImage.scale(portraitImage.getWidth()*Constants.PORTRAIT_SCALING, portraitImage.getHeight()*Constants.PORTRAIT_SCALING);
            
        attack = 4;
        speed = 3;
        maxHp = 55;
        hp = maxHp;
        
        setImage(entityImage);
        width = getImage().getWidth();
        height = getImage().getHeight();
        
        desc = "A menacing robot with an even more menacing weapon of destruction";
    }
    
    /**
     * Clone this enemy
     * 
     * @return new Mech57()
     */
    public Enemy cloneEnemy(){
        return new Mech57();
    }
}
