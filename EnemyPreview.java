import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
/**
 * Write a description of class EnemyPreview here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyPreview extends AttackQueue
{
    private int scale;
    public EnemyPreview(LinkedList<Entity> entities, int scale){
        super(entities);
        this.scale = scale;
        
    }
    public void addedToWorld(World w){
        displayQueue();
    }
    
    /**
     * Displays the enemy lineup the user will face
     */
    public void displayQueue(){
        int i = 0;
        while(!entities.isEmpty()){
            Enemy enemy = (Enemy)entities.poll();
            String headImageUrl = enemy.getPortraitUrl();
            if(enemy.getName().equals("Boss")) headImageUrl = enemy.getImageUrl();
            GreenfootImage headImage = new GreenfootImage(headImageUrl);
            headImage.scale(headImage.getWidth()*Constants.IMAGE_SCALING*scale, headImage.getHeight()*Constants.IMAGE_SCALING*scale);
            
            Pusher enemyInfoButton = new Pusher(viewEnemyInfo, "augmentbutton.png", "augmentbutton.png", enemy);
            enemyInfoButton.setButtonImage(headImage);
            if(enemy.getName().equals("Boss")){
                getWorld().addObject(enemyInfoButton, getX()+60*scale, getY()+60*scale);
            }else{
                getWorld().addObject(enemyInfoButton, getX()+i*40*scale, getY());
            }
            
            i++;
        }
    }
    
    public EnemyFunction viewEnemyInfo = (enemy) -> ((EnemyWorld)getWorld()).showEnemyInfo(enemy);
}
