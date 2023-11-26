import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This shows a brief description of enemies
 * 
 * @author Dawson
 * @version Nov 2023
 */
public class EnemyDisplay extends Actor
{
    private Enemy enemy;
    private GreenfootImage enemyDisplayImage;
    private Presser close;
    
    /**
     * Sets image
     * @param enemy   The enemy it is displaying
     */
    public EnemyDisplay(Enemy enemy){
        this.enemy = enemy;
        enemyDisplayImage = new GreenfootImage("enemyDisplay.png");
        enemyDisplayImage.drawImage(enemy.getPortrait(), enemyDisplayImage.getWidth()/2-enemy.getPortrait().getWidth()/2, enemyDisplayImage.getHeight()/8-enemy.getPortrait().getHeight()/2);
       
    }
    
    /**
     * Adds enemy display to the world
     * 
     * @param w        The world it is going to get displayed on
     */
    public void addedToWorld(World w)
    {
        
        enemyDisplayImage.scale(enemyDisplayImage.getWidth()*Constants.IMAGE_SCALING, enemyDisplayImage.getHeight()*Constants.IMAGE_SCALING);
        setImage(enemyDisplayImage);
        
        //creates temp textplace objects, gets its image, and adds draws it on enemy display
        TextPlace enemyName = TextPlace.initTextDisplay("Select Augment", 0, 0, 120, true);
        getWorld().addObject(enemyName, 0, 0);
        System.out.println(enemy);
        enemyName.setSentence(String.valueOf(enemy));
        enemyName.removeSentence();
        GreenfootImage enemyNameImage = enemyName.getText().getImage();
        enemyDisplayImage.drawImage(enemyNameImage, enemyDisplayImage.getWidth()/2-enemyNameImage.getWidth()/2, enemyDisplayImage.getHeight()/4-enemyNameImage.getHeight()/2);
           
        TextPlace enemyDesc = TextPlace.initTextDisplay("Select Augment", 0, 0, 90, true);
        getWorld().addObject(enemyDesc, 0, 0);
        enemyDesc.setSentence(enemy.getDesc());
        enemyDesc.removeSentence();
        GreenfootImage enemyDescImage = enemyDesc.getText().getImage();
        enemyDisplayImage.drawImage(enemyDescImage, enemyDisplayImage.getWidth()/2-enemyDescImage.getWidth()/2, enemyDisplayImage.getHeight()/2-enemyDescImage.getHeight()/2);
        
        //creates a button that removes this object
        close = new Presser(closeEnemyInfo, "enemyDisplaybutton.png", "enemyDisplaybuttonhover.png");
        getWorld().addObject(close, getX()+getImage().getWidth()/2-30, getY()-getImage().getHeight()/2+30);
    }
    
    /**
     * Method to remove display from world
     */
    public void removeFromWorld(){
        getWorld().removeObject(close);
        getWorld().removeObject(this);
    }
    
    /**
     * Lambdas function to remove enemy info from world
     */
    public Function closeEnemyInfo = () -> removeFromWorld();
}
