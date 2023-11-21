import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.FontFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Write a description of class AugmentPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CustomizePanel extends Actor
{
    //private TextPlace augmentName;
    //private TextPlace augmentDesc;
    private GreenfootImage augmentPanelImg;
    private GreenfootImage movesetPanelImg;
    private boolean onAugment;
    private ArrayList <Attack> moveset;
    private static Map<String, Attack> totalMoveset = new HashMap<String, Attack>(){{
            put("BodySlam", new BodySlam());
            put("BoxJab", new BoxJab());
            put("DeathRay", new DeathRay());
            put("Pincer", new Pincer());
            put("PlasmaBeam", new PlasmaBeam());
            put("ShotGun", new ShotGun());
        }};;
    
    private TextPlace nameDisplay;
    private TextPlace descDisplay;
    private Presser[] movesetButtons;
    private TextPlace[] movesetDescs;
    
    public CustomizePanel(){
        augmentPanelImg = new GreenfootImage("augmentpanel.png");
        movesetPanelImg = new GreenfootImage("movesetpanel.png");
        augmentPanelImg.scale(augmentPanelImg.getWidth()*Constants.IMAGE_SCALING, augmentPanelImg.getHeight()*Constants.IMAGE_SCALING);
        movesetPanelImg.scale(movesetPanelImg.getWidth()*Constants.IMAGE_SCALING, movesetPanelImg.getHeight()*Constants.IMAGE_SCALING);
        
        moveset = new ArrayList<>();

        
        
        setImage(augmentPanelImg);
        
        //addObject
    }
    public void addedToWorld(World w){
        nameDisplay = initTextDisplay("Select Augment", getX(), getY());
        descDisplay = initTextDisplay("Select Augment", getX(), getY()+50);
        
        getWorld().addObject(nameDisplay, getX(), getY());
        getWorld().addObject(descDisplay, getX(), getY());
        movesetButtons = new Presser[totalMoveset.size()];
        movesetDescs = new TextPlace[totalMoveset.size()];
        int i = 0;
        for(Map.Entry<String, Attack> set: totalMoveset.entrySet()){
            Presser move = new Presser(setMoveset, "augmentbutton.png", "augmentbutton.png", set.getKey());
            movesetButtons[i] = move;
            
            TextPlace attackDesc = initTextDisplay("Select Augment", getX()+50, getY() - 20 - getImage().getHeight()/3 + i * 75 , 180);
            movesetDescs[i] = attackDesc;
            getWorld().addObject(movesetDescs[i], getX(), getY());
            i++;
        }
    }
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
    public void goToMoveset(){
        onAugment = false;
        nameDisplay.removeSentence();
        descDisplay.removeSentence();
        int i = 0;
        for(Map.Entry<String, Attack> set: totalMoveset.entrySet()){
            getWorld().addObject(movesetButtons[i], getX()-getImage().getWidth()/4, getY() - getImage().getHeight()/3 + i * 75);
            movesetDescs[i].setSentence(set.getKey());
            i++;
        }
        setImage(movesetPanelImg);
    }
    public TextPlace initTextDisplay(String text, int x, int y, int textBoxWidth){
        try{
            TextPlace textDisplay = new TextPlace(text, x, y, textBoxWidth);
            return textDisplay;
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
        return null;
    }
    public TextPlace initTextDisplay(String text, int x, int y){
        return initTextDisplay(text, x, y, 236);
    }
    public ArrayList<Attack> getMoveset(){
        return moveset;
    }
    public void addToMoveset(String move){
        if(moveset.size() >= 3) return;
        if(moveset.contains(totalMoveset.get(move))){
            moveset.remove(totalMoveset.get(move));
        }else{
            moveset.add(totalMoveset.get(move));
        }
        
    }
    public AugmentFunction setMoveset = (move) -> addToMoveset(move);
}
