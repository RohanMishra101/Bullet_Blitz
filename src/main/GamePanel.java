package main;

import javax.swing.*;
import java.awt.*;
import java.security.Key;

public class GamePanel extends JPanel {

    final int originalTileSize = 32; //32x32
    final int scale = 2;
    final int tileSize = originalTileSize*scale; //64x64 tiles
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize*maxScreenCol; //1024 tiles
    final int screenHeight = tileSize*maxScreenRow;//768px tiles



//    Position of the Player
    int posX = 50, posY = 50;
    int speed = (int) Math.sqrt(3);
    int diagonalSpeed = (int) (speed / Math.sqrt(12));


    KeyHandler KeyH = new KeyHandler();

    GamePanel(){
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(KeyH);
    }
    public void updategame(){//Here goes every logic of the game

        if(KeyH.up != null && KeyH.up.booleanValue()) {
            posY -= speed;
        }
        if(KeyH.down != null && KeyH.down.booleanValue()) {
            posY += speed;
        }
        if(KeyH.left != null && KeyH.left.booleanValue()) {
            posX -= speed;
        }
        if(KeyH.right != null && KeyH.right.booleanValue()) {
            posX += speed;
        }
        // Diagonal movement
        if(KeyH.up != null && KeyH.up.booleanValue() && KeyH.left != null && KeyH.left.booleanValue()) {
            posX -= diagonalSpeed;
            posY -= diagonalSpeed;
        }
        if(KeyH.up != null && KeyH.up.booleanValue() && KeyH.right != null && KeyH.right.booleanValue()) {
            posX += diagonalSpeed;
            posY -= diagonalSpeed;
        }
        if(KeyH.down != null && KeyH.down.booleanValue() && KeyH.left != null && KeyH.left.booleanValue()) {
            posX -= diagonalSpeed;
            posY += diagonalSpeed;
        }
        if(KeyH.down != null && KeyH.down.booleanValue() && KeyH.right != null && KeyH.right.booleanValue()) {
            posX += diagonalSpeed;
            posY += diagonalSpeed;
        }
//
//        if(KeyH.up == true){
//            posY -= speed;
//        } else if (KeyH.down == true) {
//            posY += speed;
//        }else if (KeyH.left == true){
//            posX -= speed;
//        } else if (KeyH.right == true) {
//            posX += speed;
//        } else if (KeyH.up == true && KeyH.left == true) {
//            posX -= speed;
//            posY -= speed;
//        }else if (KeyH.up == true && KeyH.right == true){
//            posX += speed;
//            posY -= speed;
//        }
//        else if (KeyH.down == true && KeyH.left == true) {
//            posX -= speed;
//            posY += speed;
//        }else if (KeyH.down == true && KeyH.right == true){
//            posX += speed;
//            posY += speed;
//        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.red);
        g2.fillRect(posX,posY,50,50);
    }
}
