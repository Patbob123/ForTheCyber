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
    
    private Side[] entireField;
    
    private boolean battling;
    
    public BattleWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 
        setupField();
        
    }
    
    public void setupField(){
        userSide = new Side(0, 1);
        enemySide = new Side(1, 6);
        
        entireField = new Side[]{userSide, enemySide};
        
        Slot[] userSideSlots = userSide.getSlots();
        for(int i = 0; i < userSideSlots.length; i++){
            Slot slot = userSideSlots[i];
            addObject(slot, slot.peekX(), slot.peekY());
        }
        
        Slot[] enemySideSlots = enemySide.getSlots();
        for(int i = 0 ; i < enemySideSlots.length; i++){
            Slot slot = enemySideSlots[i];
            addObject(slot, slot.peekX(), slot.peekY());
        }
        startBattle();
    }
    
    public void startBattle(){
        battling = true;
        
        for(int i = 0; i < userSide.getSlots().length; i++){
            UserChar uc = new UserChar();
            addObject(uc, 0, 0);
            uc.toSlot(userSide.getSlots()[i]);
            entities.add(uc);
        }
        for(int i = 0; i < enemySide.getSlots().length; i++){
            Cube cube = new Cube();
            addObject(cube, 0, 0);
            cube.toSlot(enemySide.getSlots()[i]);
            entities.add(cube);
        }
        
        Collections.sort(entities);
    }
    
    public void battlePhase(){
        int curAttacker = 0;
        while(battling){ //WE NEED A WAY FOR GUYS TO DIE FIRST
            Entity e = entities.get(curAttacker);
            Side targetSide = entireField[1-e.getSide()];
            Entity target = targetSide.getRandomEntity();
            e.attack(target);
            
            
            curAttacker++;
            battling = false;
        }
    }
    
}
