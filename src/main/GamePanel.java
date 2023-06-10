package main;

import Entity.Player;
import main.Tile.TilesManager;

import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel{
    final int originalTileSize = 32; //32x32
    final int scale = 2;
    public final int tileSize = originalTileSize*scale; //64x64 tiles
    public final int maxScreenCol = 30;
    public final int maxScreenRow = 16;
    public final int screenWidth = tileSize*maxScreenCol; //1024px tiles
    public final int screenHeight = tileSize*maxScreenRow;//768px tiles






    // Creating Objects
    TilesManager tileN = new TilesManager(this);
    MouseHandler mouseHandler = new MouseHandler();
    KeyHandler KeyH = new KeyHandler(); //Object of KeyHandler class
    public Player player = new Player(this,KeyH,mouseHandler); //Object of Player class




    //World settings
    public final int maxWorldCol = 500;
    public final int maxWorldRow = 500;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize + maxWorldRow;





    GamePanel(){
        setPanelSize();
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(KeyH);
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
    }
    public void setPanelSize(){
        Dimension size = new Dimension(screenWidth,screenHeight);
        setPreferredSize(size);
    }
    public void updateGame(){//Here goes every logic of the game
        player.update();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        tileN.draw(g2);
        player.draw(g2);

    }
}






