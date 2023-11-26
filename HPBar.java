import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Display Enemy Hp Bars and periodically updates the values
 * 
 * @author Dawson 
 * @version November 2023
 */
public class HPBar extends Actor
{
    private GreenfootImage hpImage;
    private int maxHpWidth;
    private Entity e;
    
    public HPBar(UserChar uc){
        hpImage = new GreenfootImage(80, 2);
        hpImage.scale(hpImage.getWidth()*Constants.IMAGE_SCALING, hpImage.getHeight()*Constants.IMAGE_SCALING);
        maxHpWidth = hpImage.getWidth();
        
        hpImage.setColor(new Color(249, 126, 211));
        hpImage.fill();
        setImage(hpImage);
        
        this.e = uc;
        
    }
    public HPBar(Enemy enemy){
        hpImage = new GreenfootImage(30, 2);
        hpImage.scale(hpImage.getWidth()*Constants.IMAGE_SCALING, hpImage.getHeight()*Constants.IMAGE_SCALING);
        maxHpWidth = hpImage.getWidth();
        
        hpImage.setColor(new Color(249, 126, 211));
        hpImage.fill();
        setImage(hpImage);
        
        this.e = enemy;
        
    }
    public void refresh(){
        if((int)(maxHpWidth*(e.getHp()/e.getMaxHp())) <= 0) return;
        getImage().scale((int)(maxHpWidth*(e.getHp()/e.getMaxHp())) ,getImage().getHeight());
        setLocation(180+getImage().getWidth()/2, 735);
    }
}
