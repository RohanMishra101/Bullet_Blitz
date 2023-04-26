package main;
import javax.swing.*;

public class GameFrame {
    JFrame frame;

    public GameFrame( GamePanel gamePanel){
        frame = new JFrame("Bullet Blitz");


        frame.add(gamePanel);//Adding GamePanel
//        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);//Used for making Game window full screen
        frame.setVisible(true);
    }

}
