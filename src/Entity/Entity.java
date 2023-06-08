package Entity;

import main.GamePanel;

import java.awt.image.BufferedImage;

public class Entity {
    //Player
    public int posX,posY;
    public int speed,diagonalSpeed;

    public BufferedImage playerImg_1,playerImg_2,bulletImg;
    public String motion;



    //    Bullet


    public int _bulletSpeed;
    public int _bulletLifeSpan;
    public int _bulletAge;


//  Attribute
    public boolean alive = false;




}
