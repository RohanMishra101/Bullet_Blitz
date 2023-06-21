package Entity;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    //Player
    public int posX,posY;
    public int speed,backSpeed,rotationSpeed;

    public BufferedImage playerImg_1,playerImg_2,bulletImg;
    public String motion;

    public Rectangle solidArea;
    public boolean collisionOn = false;




}
