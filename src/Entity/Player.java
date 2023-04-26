package Entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;
import java.security.Key;
public class Player extends Entity{
    GamePanel gp;
    KeyHandler KeyH;

    public Player(GamePanel gp, KeyHandler KeyH){
        this.gp = gp;
        this.KeyH = KeyH;
        setDefaultValues();
    }
    public void setDefaultValues(){
        posX = 100;
        posY = 100;
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
    }
    public void draw(Graphics2D g2){
        g2.setColor(Color.red);
        g2.fillRect(posX, posY, gp.tileSize, gp.tileSize);
    }


}
