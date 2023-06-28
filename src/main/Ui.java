package main;

import java.awt.*;



/*This class is mainly used for UI of the game,
  This is just a layout class which will be used later  cause
  the game does not require the UI in its Current state*/
public class Ui {
    GamePanel gp;
    Font fontArial40;

    Ui(GamePanel gamePanel){
        this.gp = gamePanel;

        fontArial40 = new Font("Arial", Font.PLAIN, 40);
    }

    public void draw(Graphics2D g2){
        g2.setFont(fontArial40);
        g2.setColor(Color.white);
        //This below code allows to display some image or
//        g2.drawString("Key = " +gp.player.hasKey, 30,50);
    }
}
