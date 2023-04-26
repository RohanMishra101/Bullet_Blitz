package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    final int originalTileSize = 32; //32x32
    final int scale = 2;
    final int tileSize = originalTileSize*scale; //64x64 tiles
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize*maxScreenCol; //1024 tiles
    final int screenHeight = tileSize*maxScreenRow;//768px tiles

    GamePanel(){
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }
    public void updategame(){//Here goes every logic of the game

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.red);
        g2.fillRect(50,50,50,50);

    }
}
