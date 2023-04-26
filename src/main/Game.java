package main;

public class Game implements Runnable {
    private GameFrame gameFrame;
    private GamePanel gamePanel;
    private Thread gameLoopThread;
    private final int FPS_SET = 120;
    private final int UPS_SET = 200;
    public Game(){
        gamePanel = new GamePanel();
        gameFrame = new GameFrame(gamePanel);
        gamePanel.requestFocus();
        startGameLoop();
    }
    private void startGameLoop(){
        gameLoopThread = new Thread(this);
        gameLoopThread.start();
    }

    public void update(){
        gamePanel.updategame();
    }

    @Override
    public void run() {
        double timePerUpdate = 1000000000.0/UPS_SET;
        double timePerFrame = 1000000000.0/FPS_SET;

        long previousTime = System.nanoTime();

        int frames = 0;
        int update = 0;
        long lastChack = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;
        while (true){
            long currentTime = System.nanoTime();

            deltaU += (currentTime-previousTime)/timePerUpdate;
            deltaF += (currentTime-previousTime)/timePerFrame;
            previousTime = currentTime;


            if(deltaU >= 1){
                update();
                update++;
                deltaU--;
            }

            if(deltaF >= 1){
                gamePanel.repaint();
                frames++;
                deltaF--;
            }

            if(System.currentTimeMillis() - lastChack >=1000){
                lastChack = System.currentTimeMillis();
                System.out.println("FPS: "+frames+ " | UPS : " + update);
                frames = 0;
                update = 0;
            }
        }
    }

}
