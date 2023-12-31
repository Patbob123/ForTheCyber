import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.FontFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Give functionality to buttons and tabs in Builder World (Make the UI work)
 * 
 * @author Dawson
 * @version November 2023
 */
public class CustomizePanel extends Actor
{
    private GreenfootImage augmentPanelImg;
    private GreenfootImage movesetPanelImg;
    private boolean onAugment;
    private ArrayList <Attack> moveset;
    
    // All the attacks are stored in a Hashmap for easy retrievability 
    private static Map<String, Attack> totalMoveset = new HashMap<String, Attack>(){{
        put("BodySlam", new BodySlam());
        put("BoxJab", new BoxJab());
        put("DeathRay", new DeathRay());
        put("Pincer", new Pincer());
        put("PlasmaBeam", new PlasmaBeam());
        put("ShotGun", new ShotGun());
        put("Heal", new Heal());
    }};;
    
    private TextPlace nameDisplay;
    private TextPlace descDisplay;
    private Presser[] movesetButtons;
    private TextPlace[] movesetDescs;
    
    /**
     * Constructor for CustomizePanel
     */
    public CustomizePanel(){
        augmentPanelImg = new GreenfootImage("augmentpanel.png");
        movesetPanelImg = new GreenfootImage("movesetpanel.png");
        augmentPanelImg.scale(augmentPanelImg.getWidth()*Constants.IMAGE_SCALING, augmentPanelImg.getHeight()*Constants.IMAGE_SCALING);
        movesetPanelImg.scale(movesetPanelImg.getWidth()*Constants.IMAGE_SCALING, movesetPanelImg.getHeight()*Constants.IMAGE_SCALING);
        
        moveset = new ArrayList<>();

        
        
        setImage(augmentPanelImg);
        
    }
    
    /**
     * Method to add augment information 
     * 
     * @param w              A world that gets passed into the method
     */
    public void addedToWorld(World w){
        nameDisplay = TextPlace.initTextDisplay("Select Augment", getX(), getY(), true);
        descDisplay = TextPlace.initTextDisplay("Select Augment", getX(), getY()+50);
        
        getWorld().addObject(nameDisplay, getX(), getY());
        getWorld().addObject(descDisplay, getX(), getY());
        movesetButtons = new Presser[totalMoveset.size()];
        movesetDescs = new TextPlace[totalMoveset.size()];
        int i = 0;
        for(Map.Entry<String, Attack> set: totalMoveset.entrySet()){
            Presser move = new Presser(setMoveset, "augmentbutton.png", "augmentbuttonFlashed.png", set.getKey());
            movesetButtons[i] = move;
            
            TextPlace attackDesc = TextPlace.initTextDisplay("Select Augment", getX()+50, getY() - 20 - getImage().getHeight()/3 + i * 75 , 180);
            movesetDescs[i] = attackDesc;
            getWorld().addObject(movesetDescs[i], getX(), getY());
            i++;
        }
    }
    
    /**
     * Switch to Augment Tab
     */
    public void goToAugment(){
        onAugment = true;
        if(movesetButtons[0]!=null){
            for(int i = 0; i < movesetButtons.length; i++){
                getWorld().removeObject(movesetButtons[i]);
                movesetDescs[i].removeSentence();
            }
        }
        augmentPanelImg = new GreenfootImage("augmentpanel.png");
        augmentPanelImg.scale(augmentPanelImg.getWidth()*Constants.IMAGE_SCALING, augmentPanelImg.getHeight()*Constants.IMAGE_SCALING);
        Augment curAugment = ((BuilderWorld)getWorld()).getUserChar().getAugment();
        if(curAugment != null){
            augmentPanelImg.drawImage(curAugment.getPortrait(), 36*Constants.IMAGE_SCALING, 32*Constants.IMAGE_SCALING);
            nameDisplay.setSentence(curAugment.getName());
            descDisplay.setSentence(curAugment.getDesc());
        }
        setImage(augmentPanelImg);
        
       
    }
    
    /**
     * Switch to Moveset Tab
     */
    public void goToMoveset(){
        onAugment = false;
        nameDisplay.removeSentence();
        descDisplay.removeSentence();
        int i = 0;
        for(Map.Entry<String, Attack> set: totalMoveset.entrySet()){
            getWorld().addObject(movesetButtons[i], getX()-getImage().getWidth()/3, getY() - getImage().getHeight()/3 + i * 75);
            movesetDescs[i].setSentence(set.getKey());
            i++;
        }
        setImage(movesetPanelImg);
    }
    
    /**
     * Get method to retrieve moveset
     * 
     * @return Possible moves
     */
    public ArrayList<Attack> getMoveset(){
        return moveset;
    }
    
    /**
     * Method to add selected move to moveset
     * 
     * @param move      A string that gets passed into the method and is the move's string
     */
    public void addToMoveset(String move){
        if(moveset.contains(totalMoveset.get(move))){
            moveset.remove(totalMoveset.get(move));
        }else{
            if(moveset.size() >= 3) return;
            moveset.add(totalMoveset.get(move));
        }
        int i = 0;
        for(Map.Entry<String, Attack> set: totalMoveset.entrySet()){
            if(moveset.contains(set.getValue())){
                movesetDescs[i].setColour(Constants.DARK_BLUE, Constants.LIME_GREEN, Constants.NEON_GREEN);
            }else{
                movesetDescs[i].setColour(Constants.DARK_BLUE, Constants.LIGHT_AQUA, Constants.AQUA);
            }
            i++;
        }
    }
    
    /**
     * Lambdas function to add selected move into the moveset
     */
    public AugmentFunction setMoveset = (move) -> addToMoveset(move);
}
