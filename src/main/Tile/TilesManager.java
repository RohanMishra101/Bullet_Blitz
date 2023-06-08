package main.Tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.util.Objects;
import java.util.Random;

public class TilesManager {
    Random randNum = new Random();
    GamePanel gp;
    Tiles[] tilesBG;

    String filePath = "res/maps/WorldMapTest.txt";

    int mapTileNum[][];


    public TilesManager(GamePanel gp){
        this.gp = gp;

        tilesBG = new Tiles[10];

        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        File file = new File(filePath);
        getTileImg();
        if(file.length() != 0){
            loadMap();
        }else {
            setMap();
            loadMap();
        }

    }
    public void getTileImg(){
        try {
            tilesBG[0] = new Tiles();
            tilesBG[0].image = ImageIO.read(
                    Objects.requireNonNull(getClass().
                            getResourceAsStream("/Tiles/SpaceBackGround.png")));

            tilesBG[1] = new Tiles();
            tilesBG[1].image = ImageIO.read(
                    Objects.requireNonNull(getClass().
                            getResourceAsStream("/Tiles/SpaceBackGround1.png")));

            tilesBG[2] = new Tiles();
            tilesBG[2].image = ImageIO.read(
                    Objects.requireNonNull(getClass().
                            getResourceAsStream("/Tiles/SpaceBackGround2.png")));
            tilesBG[3] = new Tiles();
            tilesBG[3].image = ImageIO.read(
                    Objects.requireNonNull(getClass().
                            getResourceAsStream("/Tiles/SpaceBackGround3.png")));
            tilesBG[4] = new Tiles();
            tilesBG[4].image = ImageIO.read(
                    Objects.requireNonNull(getClass().
                            getResourceAsStream("/Tiles/BlankSpaceBackGround.png")));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void loadMap(){
        try {
            FileInputStream fis = new FileInputStream("res/maps/WorldMapTest.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            int col = 0;
            int row = 0;
            String line;
            while ((line = br.readLine()) != null) {
                String[] numbers = line.split(" ");
                for (col = 0; col < numbers.length && col < gp.maxWorldCol; col++) {
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                }
                row++;
                if (row >= gp.maxWorldRow) {
                    break;
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("WorldMapTest not found");
        }

    }
    public void draw(Graphics2D g2){

        int worldCol = 0;
        int worldRow = 0;

//        int value;
        while (worldCol<gp.maxWorldCol && worldRow < gp.maxWorldRow){
            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.posX + gp.player.screenX;
            int screenY = worldY - gp.player.posY + gp.player.screenY;

            if (worldX + (gp.tileSize*4)> gp.player.posX - gp.player.screenX &&
                    worldX - (gp.tileSize*4)< gp.player.posX + gp.player.screenX &&
                    worldY + (gp.tileSize*4)> gp.player.posY - gp.player.screenY &&
                    worldY - (gp.tileSize*4)< gp.player.posY + gp.player.screenY) {

                g2.drawImage(tilesBG[tileNum].image,screenX,screenY,gp.tileSize, gp.tileSize, null);

            }
            worldCol++;


            if(worldCol == gp.maxWorldCol){
                worldCol = 0;
                worldRow++;
            }
        }
    }


    public void setMap(){
        try {
            FileWriter writer = new FileWriter("res/maps/WorldMapTest.txt");
            for (int i=0;i<gp.maxWorldRow;i++){
                for(int j = 0; j< gp.maxWorldCol;j++){
                    writer.write(randNum.nextInt(5) + " ");
                }
                writer.write(System.lineSeparator());
            }
            writer.close();
        }catch (IOException e){
//            e.printStackTrace();
            System.out.println("World not found");
        }

    }




}
