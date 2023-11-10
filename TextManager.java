import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList; 
/**
 * Write a description of class TextManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextManager extends Actor
{
    ArrayList<SuperTextBox> text;
    Font funFont = new Font ("Comic Sans MS", false, false, 16);
    public TextManager(ArrayList <SuperTextBox> text){
        this.text = text;
        
    }
    public void addSentence(String sentence){
        text.add(0,new SuperTextBox(sentence,  funFont, 236));
    }
    public void act()
    {
        // Add your action code here.
    }
}
