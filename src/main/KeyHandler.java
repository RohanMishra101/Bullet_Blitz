package main;

import Entity.Entity;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

    public Boolean up = false,left = false,right = false,down = false;
    Entity et = new Entity();

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
            up = true;
        }


        if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
            down = true;
        }


        if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT){
            left = true;
        }


        if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){
            right = true;
        }
        else {
            code = e.getKeyCode();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
//        et.motion = "still";
        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
            up = false;
        }


        if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
            down = false;
        }


        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
            left = false;
        }


        if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
            right = false;
        }
    }

//    public void resetDirBooleans() {
//        up = false;
//        left = false;
//        right = false;
//        down = false;
//    }
}
