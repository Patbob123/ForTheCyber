import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Collections;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Battle World Controls:
 * 
 * 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BattleWorld extends World
{
    private UserChar uc;
    
    private ArrayList<Entity> entities = new ArrayList<Entity>();
    private ArrayList<SuperTextBox> text = new ArrayList<SuperTextBox>();
    private Side userSide;
    private Side enemySide;
    private Slot[] attackSlots;
    
    private Side[] entireField;
    
    private int actCounter;

    private TextManager tm;
    private StatBar sb;
    private AttackQueue aq;
    
    private GreenfootImage bgImage;
    private GreenfootImage bg1 = new GreenfootImage("bg1.png");
    
    
    public BattleWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1008, 816, 1); 
        
        // Spawning TextManager requires error handling for reading files (See textmanager class)
        try{
            tm = new TextManager();
            addObject(tm, tm.getImage().getWidth()/2,tm.getImage().getHeight()/2);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
        
        
        
        actCounter = 0;
        
        bgImage = new GreenfootImage(getWidth(), getHeight());
        setBackground(bgImage);
        
        setPaintOrder(SuperTextBox.class);
    }
    public void act(){
        actCounter++;
    }
    public int getAct(){
        return actCounter;
    }
    public void setBg(GreenfootImage bg){
        bg.scale(bg.getWidth()*Constants.IMAGE_SCALING, bg.getHeight()*Constants.IMAGE_SCALING);
        bgImage.drawImage(bg1, 250, 0);
    }
    public BattleWorld(UserChar u)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        this();
        uc = u;
        sb = new StatBar(uc);
        addObject(sb, sb.getImage().getWidth()/2,sb.getImage().getHeight()/2);
        aq = new AttackQueue(new LinkedList<Entity>());
        addObject(aq, 140*Constants.IMAGE_SCALING+aq.getImage().getWidth()/2,7*Constants.IMAGE_SCALING+aq.getImage().getHeight()/2);
        
        setupField();
        // sidebar = new SuperTextBox ("Testing 123",  funFont, 236);
        // addObject(sidebar, 150,100);
                
    }
    
    public void setupField(){
        userSide = new Side(0, 1);
        enemySide = new Side(1, 6);
        
        entireField = new Side[]{userSide, enemySide};
        attackSlots = new Slot[]{new Slot(550, 450), new Slot(625, 375)};
        
        for(Slot slot: userSide.getSlots()){
            addObject(slot, slot.peekX(), slot.peekY());
        }        
        for(Slot slot: enemySide.getSlots()){
            addObject(slot, slot.peekX(), slot.peekY());
        }
        
        for(Slot slot: attackSlots){
            addObject(slot, slot.peekX(), slot.peekY());
        }
        startBattle();
    }
    
    public void startBattle(){
        Coordinate userSideSpawn = new Coordinate(800, 800);
        Coordinate enemySideSpawn = new Coordinate(400, 0);
        
        for(Slot slot: userSide.getSlots()){
            addObject(uc, userSideSpawn.getX(), userSideSpawn.getY());
            uc.initToSlot(slot);
            entities.add(uc);
        }
        for(Slot slot: enemySide.getSlots()){
            Cube cube = new Cube();
            addObject(cube, enemySideSpawn.getX(), enemySideSpawn.getY());
            cube.initToSlot(slot);
            entities.add(cube);
        }
        
        Collections.sort(entities);
        BattleManager bm = new BattleManager(entities, entireField);
        addObject(bm, 0, 0);
        bm.nextTurn();
        
        setBg(bg1);
    }
    public void refreshEntities(){
        removeObjects(getObjects(Entity.class));
        for(Entity e: entities){
            addObject(e, 0, 0);
        }
    }
    
    public Slot[] getAttackSlots(){
        return attackSlots;
    }
    public TextManager getTM(){
        return tm;
    }
    public AttackQueue getAttackQueue(){
        return aq;
    }
    
}
