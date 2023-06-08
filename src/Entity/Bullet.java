package Entity;

import main.GamePanel;
import main.KeyHandler;
import main.MouseHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
/*
    Here the constructor is taking the value of the provided
    parameters but the value is automatically converted to 0 automatically need to fix it.
 */
public class Bullet extends Entity{
//    int playerPosX,playerPosY;
    int _bulletPosX;
    int _bulletPosY;
    int mousePosX, mousePosY;
    int centerX,centerY;
    double angle;


    GamePanel gp;
    Player player;
    MouseHandler mouseH = new MouseHandler();
    KeyHandler KeyH;


    //angle
    public Bullet(int x, int y, int centerX1,int centerY1){
        super();
        _bulletSpeed = 5;
        _bulletLifeSpan = 80;
        _bulletAge = 0;


        this.mousePosX = x;
        this.mousePosY = y;
        this.centerX = centerX1;
        this.centerY = centerY1;

//        _bulletPosX = playerPosX;
//        _bulletPosY = playerPosY;

        player = new Player(gp, KeyH, mouseH);
        this._bulletPosX = player.posX;
        this._bulletPosY = player.posY;

//        System.out.println(playerPosX + " " + playerPosY);


    }
    public Bullet(GamePanel gamePanel){
        this.gp = gamePanel;
        impBulletImg();
//        System.out.println(_bulletPosX + " " + _bulletPosY);
    }

    private void impBulletImg() {
        InputStream is = getClass().getResourceAsStream("/Bullet1.png");
        try {
            assert is != null;
            bulletImg = ImageIO.read(is);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                assert is != null;
                is.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }


//    public void update(){
//        _bulletAge++;
//        int bulletSpeedX = (int) (_bulletSpeed * Math.cos(angle));
//        int bulletSpeedY = (int) (_bulletSpeed * Math.sin(angle));
//
////        System.out.println(angle);
//
//
//        _bulletPosX += bulletSpeedX;
//        _bulletPosY += bulletSpeedY;
//
////        System.out.println(_bulletPosX+" "+_bulletPosY);
//        if(_bulletAge > _bulletLifeSpan){
//            destroy();
//        }
//    }

    public void render(Graphics2D g2){
//        System.out.println(_bulletPosX + " " + _bulletPosY);

//        _bulletPosX = playerPosX;
//        _bulletPosY = playerPosY;

//        System.out.println(this.playerPosX + " " + this.playerPosY);

        BufferedImage bulletSubImg = bulletImg.getSubimage(0,0,16,16);
        g2.drawImage(bulletSubImg,_bulletPosX,_bulletPosY,16,16,null);
    }

//    public void destroy(){
//        gp.bullets.remove(this);
//    }

}
