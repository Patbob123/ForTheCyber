import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Container here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        if(e.getHp() <= 0) return;
        //System.out.println(e.getMaxHp());
        getImage().scale((int)(maxHpWidth*(e.getHp()/e.getMaxHp())) ,getImage().getHeight());
        setLocation(180+getImage().getWidth()/2, 735);
    }
}
