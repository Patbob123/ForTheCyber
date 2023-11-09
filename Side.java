import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Field here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Side extends Actor
{
    private Slot[] slots;
    private ArrayList<Entity> entities;
    
    public Side(int side, int slotAmount){ //0 is user side, 1 is enemy side
        
        slots = new Slot[slotAmount];
        int row = 0;
        int column = 0;
        if(side == 0){
            for(int i = 0; i < slots.length; i++){
                Slot slot = new Slot(700+column, 600+column*30);
                slots[i] = slot;
            }
        }else if(side == 1){
            for(int i = 1; i < slots.length+1; i++){
                Slot slot = new Slot(300+column*200, 150-column*30+row*200 );
                slots[i-1] = slot;
                column++;
                if(i%3 == 0){
                    row++;
                    column = 0;
                }
                
            }
        }
        
    }
    public Slot[] getSlots(){
        return slots;
    }
    public Entity getRandomEntity(){
        return slots[Greenfoot.getRandomNumber(slots.length)].getEntity();
    }
    public ArrayList<Entity> getEntities(){
        if(entities == null){
            entities = new ArrayList<Entity>();
            for(Slot slot: slots){
                entities.add(slot.getEntity());
            }
        }
        return entities;
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
