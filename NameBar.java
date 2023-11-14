import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NameBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NameBar extends Actor
{
    private String nameText;
    private boolean enteringName;
    public NameBar(){
        nameText = "";
        enteringName = false;
    }
    public void act()
    {
        
    }
    public void toggleEnterName(){
        if(Greenfoot.mouseClicked(this)){
            enteringName = !enteringName;
        }
    }
    public void enterName(){
        if(enteringName){
            
        }
    }
}
