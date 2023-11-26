import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button class that runs its Function object's function when clicked by the mouse
 * 
 * @author Dawson
 * @version 2023-11-20
 */
public class Pusher extends Presser
{
    /**
     * Constructor for Enemy Preview Buttons
     */
    public Pusher(EnemyFunction buttonAction, String buttonFile, String hoverButtonFile, Enemy enemy){
        super(buttonAction, buttonFile, hoverButtonFile, enemy);
    }
}
