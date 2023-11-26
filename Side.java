import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * (User or Enemy) Side Class
 * - Sets up the user and enemy idle positions 
 * 
 * @author Dawson
 * @version November 2023
 */
public class Side extends Actor//
{
    private Slot[] slots;
    private ArrayList<Entity> entities;
    
    public Side(int side, int slotAmount){ //0 is user side, 1 is enemy side
        
        slots = new Slot[slotAmount];
        int row = 0;
        int column = 0;
        
        // Generate Slot positions
        if(side == 0){
            for(int i = 0; i < slots.length; i++){
                Slot slot = new Slot(400+column, 550+column*30);
                slots[i] = slot;
            }
        }else if(side == 1){
            for(int i = 1; i < slots.length+1; i++){
                Slot slot = new Slot(600+column*150, 100+column*30+row*150 );
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
    public Entity getRandomEntity(){ //Get one entity from array slot
        return getEntities().get(Greenfoot.getRandomNumber(getEntities().size()));
    }
    
    public ArrayList<Entity> getEntities(){ //Get all entities from slot array list
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
