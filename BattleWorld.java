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
    private UserChar uc;
    
    private ArrayList<Entity> entities = new ArrayList<Entity>();
    private ArrayList<SuperTextBox> text = new ArrayList<SuperTextBox>();
    private Side userSide;
    private Side enemySide;
    private Slot[] attackSlots;
    
    private Side[] entireField;
    
    private int actCounter;
    
    SuperTextBox sidebar;
    TextManager tm;
    int count = 0;
    
    public BattleWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 
        setupField();
        actCounter = 0;
    }
    public void act(){
        checkIfAddText();
        actCounter++;
    }
    public int getAct(){
        return actCounter;
    }
    
    public BattleWorld(UserChar u)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 
        setupField();
        uc = u;
        // sidebar = new SuperTextBox ("Testing 123",  funFont, 236);
        // addObject(sidebar, 150,100);
        tm = new TextManager(text);
        addObject(tm, 0, 0);
        
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
        if(Greenfoot.getRandomNumber(100) == 1){
            //String input = Greenfoot.ask("Please input a value");
            System.out.println(tm);
            if(Greenfoot.getRandomNumber(4) == 1){
                tm.addSentence("ASDASD");
            }else if(Greenfoot.getRandomNumber(4) == 2){
                tm.addSentence("FASFASDDS");
            }else{
                tm.addSentence("EFASDWADSADWS");
            }
            
            count++;
        }
    }
    
}
