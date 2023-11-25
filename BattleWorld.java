import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Collections;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Battle Simulation: Epick Wick
 * 
 * <p>Set in the futuristic undercity of 2145, Epick Wick embarks on a grueling journey to take revenge against the robot gang that brutally assassinated his only companion, Bark the dog. 
 * With nothing left to lose, Epick Wick cybernetically augments himself to become more durable, faster and stronger so that he can stand a chance to take down the mechanical menaces. </p>
 * 
 * <p>
 * Key Features:
 * <ul>
 * - All choosable attacks and augments are original 
 * </ul>
 * 
 * <ul>
 * - Randomly generated waves of enemies 
 * </ul>
 * 
 * <ul>
 * - Customizable stats and abilities for the user
 * </ul>
 * 
 * <ul>
 * - A self generating turn based simulator, that chooses the order in which entities attack 
 * </ul>
 * 
 * <ul>
 * - All of the pixel art is created by group members, except the rain in battle world
 * </ul>
 * 
 * <ul>
 * - Unique Art work for UI, animations, characters, Start Screen, and Gifs
 * </ul>
 * 
 * <ul>
 * - A live textbox feed with custom font, colourable text, and automatic resizablity
 * </ul>
 * 
 * <ul>
 * - Lots of code is handled in a Manager Class to create modular and reusable code
 * </ul>
 * 
 * Miscellaneous Features: 
 * <ul>
 * - Run StartWorld and wait 30 seconds to experience a small easter egg
 * </ul>
 * 
 * </p>
 * 
 * <p>
 * Credits:
 * 
 * <p>
 * Code:-------------------------------------------------------------
 * 
 * <ul>
 * Code for importing Custom Font:
 * - Written by: crissty21
 * - Link: https://www.greenfoot.org/topics/65058/0
 * </ul>
 * 
 * <ul>
 * Code for SuperTextBox and ImageManipulatorStarterCode:
 * - Written by: Mr. Cohen
 * </ul>
 * 
 * <ul>
 * Colour code for image tinting:
 * - Written by: Yusuf Shakeel
 * - Link: https://www.youtube.com/watch?v=oHPegWucwEo
 * </ul>
 * 
 * <ul>
 * Detect Hovering Movement Code:
 * - Written by: arw90
 * - Link: https://www.greenfoot.org/topics/55324/0
 * </ul>
 * 
 * <ul>
 * Gif Image:
 * - Michael Berry, Neil Brown Copyright (c) 2011,2013,2014,2018,2021
 * - Greenfoot Imported Code
 * </ul>
 * </p>
 * 
 * <p>
 * Graphics:----------------------------------------------------------
 * <ul>
 * BattleWorld Rain
 * <ul>
 * Pixel Rain Sticker By Douglas Schatz
 * Link: https://giphy.com/stickers/nostalgia-bling-3ohhwutQL0CDTq3kKA 
 * </ul>
 * </ul>
 * </p>
 * 
 * <p>
 * Music:-------------------------------------------------------------
 * <ul>
 * Jaded by LONE
 * Copyright: R&S Records 2014
 * Link: https://www.youtube.com/watch?v=nettIPeJauM&ab_channel=Lone-Topic 
 * </ul>
 * </p>
 * 
 * <p>
 * Sound Effects:-------------------------------------------------------------
 * <ul>
 * Click:
 * By: 666Herohero
 * Link: https://pixabay.com/sound-effects/click-21156/ 
 * </ul>
 * 
 * <ul>
 * Blaster Sound:
 * By: Pixabay
 * Link: https://pixabay.com/sound-effects/blaster-103340/
 * </ul>
 * 
 * <ul>
 * Boom Sound:
 * By: SUMBORITY
 * Link: https://pixabay.com/sound-effects/boom-geomorphism-cinematic-trailer-sound-effects-123876/
 * </ul>
 * 
 * <ul>
 * Body Slam Sound:
 * By: Pixabay
 * Link: https://pixabay.com/sound-effects/hard-slap-46388/
 * </ul>
 * 
 * <ul>
 * Death Ray Sound:
 * By: Pixabay
 * Link: https://pixabay.com/sound-effects/search/beam/ 
 * </ul>
 * 
 * <ul>
 * Pincer Sound:
 * By: Pixabay
 * Link: https://pixabay.com/sound-effects/knife-stab-sound-effect-36354/ 
 * </ul>
 * 
 * <ul>
 * Plasma Beam Sound:
 * By: Pixabay
 * Link: https://pixabay.com/sound-effects/beam-8-43831/ 
 * </ul>
 * 
 * <ul>
 * Punch Sound:
 * By: floraphonic
 * https://pixabay.com/sound-effects/punch-6-166699/ 
 * </ul>
 * 
 * <ul>
 * Shotgun Sound:
 * By: Pixabay
 * https://pixabay.com/sound-effects/shotgun-firing-4-6746/ 
 * </ul>
 * 
 * <ul>
 * Heal Sound:
 * By: Pixabay
 * https://pixabay.com/sound-effects/084373-heal-36672/ 
 * </ul>
 * 
 * <ul>
 * Pixel Sound:
 * By: Pixabay
 * https://pixabay.com/sound-effects/pixel-sound-effect-5-103221/ 
 * </ul>
 * 
 * <ul>
 * Rain Ambient Sound:
 * By: SoundsForYou
 * https://pixabay.com/sound-effects/soft-rain-ambient-111154/
 * </ul>
 * 
 * <ul>
 * Hover Sound
 * By: Pixabay
 * https://pixabay.com/sound-effects/fairy-sound-6469/ 
 * 
 * <ul>
 * Electric Shock Sound
 * By: Pixabay
 * Link: https://pixabay.com/sound-effects/075681-electric-shock-33018/ 
 * </ul>
 * </p>
 * 
 * <p> 
 * Known Bugs:
 * <ul>
 * - Sometimes Supertextbox incorrectly spaces out words
 * </ul>


 * @author Dawson Li
 * <p>
 * Modified by: Rex Xu
 * </p>
 * @version November, 24, 2023
 */
public class BattleWorld extends SuperWorld
{
    private UserChar uc;
    private ArrayList<ArrayList<Enemy>> stages;
    
    private ArrayList<Entity> entities = new ArrayList<Entity>();
    private ArrayList<SuperTextBox> text = new ArrayList<SuperTextBox>();
    private Side userSide;
    private Side enemySide;
    private Slot[] attackSlots;
    
    private Side[] entireField;
    
    private int wave;
    private int actCounter;

    private TextManager tm;
    private StatBar sb;
    private AttackQueue aq;
    
    private GreenfootImage bgImage;
    private GreenfootImage bg1 = new GreenfootImage("wave1Bg.png");
  
    
    public BattleWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT, 1); 
        
        // Spawning TextManager requires error handling for reading files (See textmanager class)
        try{
            tm = new TextManager();
            addObject(tm, tm.getImage().getWidth()/2,tm.getImage().getHeight()/2);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
        
        
        actCounter = 0;
        
        bgImage = new GreenfootImage(getWidth(), getHeight());
        setBackground(bgImage);
        
        
        //sm = new SoundManager();
        
    }
    public void act(){
        super.act();
        actCounter++;
        if(actCounter==1){
            sm.playSoundLoop("rain");
            sm.fadeIn("rain");
        }
    }
    public int getAct(){
        return actCounter;
    }
    public void setBg(GreenfootImage bg){
        
        bgImage.drawImage(bg1, 250, 0);
    }
    public BattleWorld(UserChar u, ArrayList<ArrayList<Enemy>> stages)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        this();
        uc = u;
        sb = new StatBar(uc);
        addObject(sb, sb.getImage().getWidth()/2,sb.getImage().getHeight()/2);
        aq = new AttackQueue(new LinkedList<Entity>());
        addObject(aq, 140*Constants.IMAGE_SCALING+aq.getImage().getWidth()/2,7*Constants.IMAGE_SCALING+aq.getImage().getHeight()/2);
        
        this.stages = stages;
        this.wave = -1;
        
        bg1.scale(bg1.getWidth()*Constants.IMAGE_SCALING, bg1.getHeight()*Constants.IMAGE_SCALING);
        setupField();
        
        
    }
    
    public void setupField(){
        wave++;
        if(wave == stages.size()){
            Greenfoot.setWorld(new WinWorld());
            return;
        }
        
        userSide = new Side(0, 1);
        enemySide = new Side(1, stages.get(wave).size());
        
        entireField = new Side[]{userSide, enemySide};
        attackSlots = new Slot[]{new Slot(550, 450), new Slot(625, 375)};
        
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
            addObject(uc, userSideSpawn.getX(), userSideSpawn.getY());
            uc.initToSlot(slot);
            entities.add(uc);
        }
        for(int i = 0 ; i <  enemySide.getSlots().length; i++){
            
            Enemy e = stages.get(wave).get(i).cloneEnemy();
            addObject(e, enemySideSpawn.getX(), enemySideSpawn.getY());
            e.initToSlot(enemySide.getSlots()[i]);
            entities.add(e);
        }
        
        Collections.sort(entities);
        
        
        addObject(new Rain(), Constants.WORLD_WIDTH/2, Constants.WORLD_HEIGHT/2);
        setBg(bg1);
        
        BattleManager bm = new BattleManager(entities, entireField);
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
    public TextManager getTM(){
        return tm;
    }

    public AttackQueue getAttackQueue(){
        return aq;
    }
    
}
