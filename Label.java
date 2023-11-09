import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Label here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Label extends Actor
{
    /**
     * Act - do whatever the Label wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Label(String text){
        GreenfootImage label = new GreenfootImage(text.length()*20,20);
        label.drawString(text,2,20);
        setImage(label);
    }
    public void setText(){
        
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
