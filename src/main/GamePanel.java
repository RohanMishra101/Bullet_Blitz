package main;

import Entity.Player;

import javax.swing.*;
import java.awt.*;
import java.security.Key;

public class GamePanel extends JPanel {
    final int originalTileSize = 32; //32x32
    final int scale = 2;
    public final int tileSize = originalTileSize*scale; //64x64 tiles
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize*maxScreenCol; //1024 tiles
    final int screenHeight = tileSize*maxScreenRow;//768px tiles


    // Creating Objects
    KeyHandler KeyH = new KeyHandler(); //Object of KeyHandler class
    Player player = new Player(this,KeyH); //Object of Player class

    GamePanel(){
        setPanelSize();
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(KeyH);
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
        player.draw(g2);
    }

}
