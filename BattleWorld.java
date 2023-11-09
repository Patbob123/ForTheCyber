import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Collections;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BattleWorld extends World
{

    private ArrayList<Entity> entities = new ArrayList<Entity>();
    private Side userSide;
    private Side enemySide;
    private Slot[] attackSlots;
    
    private Side[] entireField;
    
    Label abc;
    
    public BattleWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 
        setupField();
        abc = new Label("Aello");
        addObject(abc, 100,100);
        
    }
    public void act(){
        checkIfAddText();
    }
    
    public void setupField(){
        userSide = new Side(0, 1);
        enemySide = new Side(1, 6);
        
        entireField = new Side[]{userSide, enemySide};
        attackSlots = new Slot[]{new Slot(650, 550), new Slot(550, 450)};
        
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
            UserChar uc = new UserChar();
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
        bm.nextTurn();
        addObject(bm, 0, 0);
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
    public void checkIfAddText(){
        int rand = Greenfoot.getRandomNumber(100);
        spawnText("Hello", rand);
    }
    public void spawnText(String message,int y){
        System.out.println("here");
        Label text = new Label (message);
        addObject(text,100,10*y);
    }
}
