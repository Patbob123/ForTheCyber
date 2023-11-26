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
     * @param buttonAction       The Function object that will run
     * @param buttonFile         The image of the button's directory
     * @param hoverButtonFile    The image of the button's hover directory
     * @param enemy              Enemy object
     */
    public Pusher(EnemyFunction buttonAction, String buttonFile, String hoverButtonFile, Enemy enemy){
        super(buttonAction, buttonFile, hoverButtonFile, enemy);
    }
}
