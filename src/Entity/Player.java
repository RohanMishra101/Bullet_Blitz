package Entity;

import main.GamePanel;
import main.KeyHandler;
import main.MouseHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.security.Key;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler KeyH;
    MouseHandler MouseH;
    private double angle; // angle in radians
    private BufferedImage img,subImg;
    private int centerX,centerY;
    private double dx,dy;


    public Player(GamePanel gp, KeyHandler KeyH, MouseHandler MouseH){
        this.gp = gp;
        this.KeyH = KeyH;
        this.MouseH = MouseH;

        importImg();
        setDefaultValues();
    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/Main_Player.png");
        try {
            img = ImageIO.read(is);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                is.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void setDefaultValues(){
        posX = 480;
        posY = 354;
        speed = (int) Math.sqrt(2);
        diagonalSpeed = (int) (speed/Math.sqrt(50));

    }
    public void update(){
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


        //Getting mouse position
        centerX = posX + (gp.tileSize / 2);
        centerY = posY + (gp.tileSize / 2);
        dx = MouseH.posX - centerX;
        dy = MouseH.posY - centerY;
        angle = Math.atan2(dy, dx);

    }
    public void draw(Graphics2D g2){
        // Calculate the center of the player sprite
        int centerX = posX + (gp.tileSize / 2);
        int centerY = posY + (gp.tileSize / 2);

        // Rotate the graphics context around the center of the player sprite
        g2.rotate(angle, centerX, centerY);


        g2.setColor(Color.red);
//        g2.fillRect(posX, posY, gp.tileSize, gp.tileSize);
        subImg = img.getSubimage(0,0,32,32);
        g2.drawImage(img,posX,posY,80,80,null);
        // Reset the rotation of the graphics context
        g2.rotate(-angle, centerX, centerY);
    }

}
