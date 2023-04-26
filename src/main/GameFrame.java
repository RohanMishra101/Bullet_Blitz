package main;
import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class GameFrame {
    JFrame frame;

    public GameFrame( GamePanel gamePanel){
        frame = new JFrame("Bullet Blitz");


        frame.add(gamePanel);//Adding GamePanel

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);//Used for making Game window full screen
        frame.setVisible(true);
    }

}
