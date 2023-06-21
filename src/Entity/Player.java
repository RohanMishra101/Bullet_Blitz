package Entity;

import main.GamePanel;
import main.KeyHandler;
import main.MouseHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler KeyH;
    MouseHandler MouseH;

    public double angle; // angle in radians
    public int centerX,centerY;
    BufferedImage img;



    public int screenX;
    public int screenY;


    public Player(GamePanel gp, KeyHandler KeyH, MouseHandler MouseH){
        this.gp = gp;
        this.KeyH = KeyH;
        this.MouseH = MouseH;

        solidArea = new Rectangle(10,10,32,32);

//        screenX = gp.screenWidth/2 - gp.tileSize/2;
        screenX = gp.screenWidth/2;
//        screenY = gp.screenHeight/2 - gp.tileSize/2;
        screenY = gp.screenHeight/2;

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
        speed = (int) Math.sqrt(16);
        rotationSpeed = (int) Math.sqrt(16);
        backSpeed = 2;

        motion = "still";
    }
    public void update(){
        // Getting mouse position
        int centerX = screenX + (gp.tileSize / 2);
        int centerY = screenY + (gp.tileSize / 2);
        double dx = MouseH.X - centerX;
        double dy = MouseH.Y - centerY;
        angle = Math.atan2(dy, dx);

        // Player movement logic
        if (KeyH.up != null && KeyH.up && !collisionOn) {
            motion = "move";
            double movX = Math.cos(angle);
            double movY = Math.sin(angle);
            double magnitude = Math.sqrt(movX * movX + movY * movY);

            if (magnitude != 0) {
                movX /= magnitude;
                movY /= magnitude;
            }

            movX *= speed;
            movY *= speed;

            posX += movX;
            posY += movY;
        } else if (KeyH.down != null && KeyH.down && !collisionOn) {
            motion = "move";
            double movX = -Math.cos(angle);
            double movY = -Math.sin(angle);
            double magnitude = Math.sqrt(movX * movX + movY * movY);

            if (magnitude != 0) {
                movX /= magnitude;
                movY /= magnitude;
            }

            movX *= backSpeed;
            movY *= backSpeed;

            posX += movX;
            posY += movY;
        } else {
            motion = "still";
        }
        //Collisio Check
        collisionOn = false;
        gp.checker.CheckTile(this);
        //Passing player class as the entity as it is a subclass of the Entity class


        //If collison is false player can move if not then the player is not allowed to move



        //Bullet mechanism


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





