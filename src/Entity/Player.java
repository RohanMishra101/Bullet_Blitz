package Entity;

import main.GamePanel;
import main.KeyHandler;
import main.MouseHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.security.PublicKey;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler KeyH;
    MouseHandler MouseH;

    public double angle; // angle in radians
    public int centerX,centerY;
    BufferedImage img;
    Bullet bullet ;


    public int screenX;
    public int screenY;



    public Player(GamePanel gp, KeyHandler KeyH, MouseHandler MouseH){
        this.gp = gp;
        this.KeyH = KeyH;
        this.MouseH = MouseH;

        screenX = gp.screenWidth/2 - gp.tileSize/2;
        screenY = gp.screenHeight/2 - gp.tileSize/2;
        importImg();
        setDefaultValues();
    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/SpaceShip.png");
        InputStream is_1 = getClass().getResourceAsStream("/FlySpaceShip.png");
        try {
            assert is != null;
            playerImg_1 = ImageIO.read(is);
            assert is_1 != null;
            playerImg_2 = ImageIO.read(is_1);

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                assert is != null;
                is.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void setDefaultValues(){
        posX = gp.tileSize * 23;
        posY = gp.tileSize * 21;
        speed = (int) Math.sqrt(3.5);
        diagonalSpeed = (int) (speed/Math.sqrt(50));

        motion = "still";
    }
    public void update(){

        if(KeyH.up != null && KeyH.up) {
            motion = "move";
            posY -= speed;
        }else{
            motion = "still";
        }
        if(KeyH.down != null && KeyH.down) {
            motion = "move";
            posY += speed;
        }
        if(KeyH.left != null && KeyH.left) {
            motion = "move";
            posX -= speed;
        }
        if(KeyH.right != null && KeyH.right) {
            motion = "move";
            posX += speed;
        }
        // Diagonal movement
        if(KeyH.up != null && KeyH.up && KeyH.left != null && KeyH.left) {
            motion = "move";
            posX -= diagonalSpeed;
            posY -= diagonalSpeed;
        }
        if(KeyH.up != null && KeyH.up && KeyH.right != null && KeyH.right) {
            motion = "move";
            posX += diagonalSpeed;
            posY -= diagonalSpeed;
        }
        if(KeyH.down != null && KeyH.down && KeyH.left != null && KeyH.left) {
            motion = "move";
            posX -= diagonalSpeed;
            posY += diagonalSpeed;
        }
        if(KeyH.down != null && KeyH.down&& KeyH.right != null && KeyH.right) {
            motion = "move";
            posX += diagonalSpeed;
            posY += diagonalSpeed;
        }
        //Getting mouse position
        int centerX = screenX + (gp.tileSize / 2);
        int centerY = screenY + (gp.tileSize / 2);
        double dx = MouseH. X - centerX;
        double dy = MouseH.Y - centerY;
        angle = Math.atan2(dy,dx);


        //Bullet Update


    }

    public void draw(Graphics2D g2){
        // Calculate the center of the player sprite
        centerX = screenX + (gp.tileSize / 2);
        centerY = screenY + (gp.tileSize / 2);

        // Rotate the graphics context around the center of the player sprite
        g2.rotate(angle, centerX, centerY);


        g2.setColor(Color.red);
        switch (motion){
            case "move":
                img = playerImg_2;
                break;
            case "still":
                img = playerImg_1;
                break;
        }
//        BufferedImage playerImgSubimage = img.getSubimage(0, 0, 32, 32);
        g2.drawImage(img,screenX,screenY,gp.tileSize,gp.tileSize,null);



        // Reset the rotation of the graphics context
        g2.rotate(-angle, centerX, centerY);
    }
}





